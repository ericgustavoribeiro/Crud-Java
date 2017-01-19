package EJT.Jardineiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Util.Conexao;
import EJT.Util.Database;

public class RepositorioJardineiroBDR implements IRepositorioJardineiro{

	private Connection conectar = null;
	
	
	public RepositorioJardineiroBDR() throws Exception {
		this.conectar = Conexao.getConnection(Database.MYSQL);
		
	}
	
	@Override
	public void cadastrar(Jardineiro jardineiro)
			throws JardineiroJaCadastradoException, CampoObrigatorioException,
			SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		try{
			sql = "insert into jardineiro(nome, cpf, rg, disponibilidade, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, jardineiro.getNome());
				stmt.setString(2, jardineiro.getCpf());
				stmt.setString(3, jardineiro.getRg());
				stmt.setString(4, jardineiro.getDisponibilidade());
				stmt.setString(5, jardineiro.getEndereco().getLogradouro());
				stmt.setString(6, jardineiro.getEndereco().getNumero());
				stmt.setString(7, jardineiro.getEndereco().getBairro());
				stmt.setString(8, jardineiro.getEndereco().getCidade());
				stmt.setString(9, jardineiro.getEndereco().getEstado());
				stmt.setString(10, jardineiro.getEndereco().getCep());
				stmt.setString(11, jardineiro.getContato().getEmail());
				stmt.setString(12, jardineiro.getContato().getTelefone());
				stmt.setString(13, jardineiro.getContato().getCelular());
				stmt.execute();
				rs = stmt.getGeneratedKeys();
				int jardinerioId = 0;
				while(rs.next()){
					jardinerioId = rs.getInt(1);
				}
				jardineiro.setId_jardineiro(jardinerioId);
		
		}finally{
			stmt.close();
		}
		
		
	}

	@Override
	public Jardineiro procurar(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
		Jardineiro jardineiro = null;
		String complemento = " and jardineiro.cpf = " + cpf;
		ArrayList<Jardineiro> jardineiros = this.listar(complemento);
		if(jardineiro != null){
			throw new JardineiroNaoEncontradoException();
		}
		
		return jardineiros.get(0);
	}
	
	@Override
	public void atualizar(Jardineiro jardineiro)
			throws CampoObrigatorioException, JardineiroNaoEncontradoException,
			SQLException {
		PreparedStatement stmt = null;
		String sql;
		try{
		if(jardineiro != null){
			sql =  "update jardineiro set nome = ?, rg = ?, disponibilidade = ?, "
					+ "logradouro = ?, numero = ?,  bairro = ?, cidade = ?, estado = ?, "
					+ "cep = ?, email = ?, telefone = ?, celular = ?";
				sql	+= " where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, jardineiro.getNome());
			stmt.setString(2, jardineiro.getRg());
			stmt.setString(3, jardineiro.getDisponibilidade());
			stmt.setString(4, jardineiro.getEndereco().getLogradouro());
			stmt.setString(5, jardineiro.getEndereco().getNumero());
			stmt.setString(6, jardineiro.getEndereco().getBairro());
			stmt.setString(7, jardineiro.getEndereco().getCidade());
			stmt.setString(8, jardineiro.getEndereco().getEstado());
			stmt.setString(9, jardineiro.getEndereco().getCep());
			stmt.setString(10, jardineiro.getContato().getEmail());
			stmt.setString(11, jardineiro.getContato().getTelefone());
			stmt.setString(12, jardineiro.getContato().getCelular());
			stmt.setString(13, jardineiro.getCpf());
			
			Integer resultado = stmt.executeUpdate();
			if(resultado == 0) throw new JardineiroNaoEncontradoException();
		
		}
		}finally{
			stmt.close();
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
	PreparedStatement stmt = null;
	try{
	String sql = "delete from jardineiro where cpf = ?";
	stmt = this.conectar.prepareStatement(sql);
	stmt.setString(1, cpf);
	stmt.execute();
	}finally{
		stmt.close();
	}
		
	}



	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String sql = "select count(*) as quantidade from jardineiro where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt("quantidade") == 0){
				return false;
			}else{
				return true;
			}
		}finally{
			stmt.close();
		}
	}

	@Override
	public ArrayList<Jardineiro> listar() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Jardineiro> jardineiros = new ArrayList<Jardineiro>();
		String sql;
		try{
			sql = "select * from jardineiro";
			sql += " where id_jardineiro is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Jardineiro jardineiro = new Jardineiro(rs.getInt("id_jardineiro"), rs.getString("nome"), rs.getString("cpf"), 
						rs.getString("rg"), rs.getString("disponibilidade"), rs.getString("logradouro"), rs.getString("numero"), 
						rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), 
						rs.getString("email"), rs.getString("telefone"), rs.getString("celular"));
				
				Endereco endereco = new Endereco();
				Contato contato = new Contato();
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCep(rs.getString("cep"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				
				jardineiro.setEndereco(endereco);
				jardineiro.setContato(contato);
				jardineiros.add(jardineiro);
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return jardineiros;
	}

	@Override
	public ArrayList<Jardineiro> listar(String complemento) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Jardineiro> jardineiros = new ArrayList<Jardineiro>();
		String sql;
		try{
			sql = "select * from jardineiro";
			sql += " where id_jardineiro is not null ";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Jardineiro jardineiro = new Jardineiro(rs.getInt("id_jardineiro"), rs.getString("nome"), rs.getString("cpf"), 
						rs.getString("rg"), rs.getString("disponibilidade"), rs.getString("logradouro"), rs.getString("numero"), 
						rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), 
						rs.getString("email"), rs.getString("telefone"), rs.getString("celular"));
				
				Endereco endereco = new Endereco();
				Contato contato = new Contato();
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCep(rs.getString("cep"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				
				jardineiro.setEndereco(endereco);
				jardineiro.setContato(contato);
				jardineiros.add(jardineiro);
				
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return jardineiros;
	}

}
