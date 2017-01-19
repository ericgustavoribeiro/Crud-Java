package EJT.Atendente;


//ok
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

import EJT.Util.Conexao;
import EJT.Util.Database;


public class RepositorioAtendenteBDR implements IRepositorioAtendente {

	private Connection conectar = null;
	
	public RepositorioAtendenteBDR() throws Exception{
		this.conectar = Conexao.getConnection(Database.MYSQL);
	}
	
	@Override
	public void Cadastrar(Atendente atendente)
			throws AtendenteJaCadastradoException, SQLException {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if(atendente != null){
			try{
				sql = "insert into atendente(nome, cpf, rg, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular) " +
						"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, atendente.getNome());
				stmt.setString(2, atendente.getCpf());
				stmt.setString(3, atendente.getRg());
				stmt.setString(4, atendente.getEndereco().getLogradouro());
				stmt.setString(5, atendente.getEndereco().getNumero());
				stmt.setString(6, atendente.getEndereco().getBairro());
				stmt.setString(7, atendente.getEndereco().getCidade());
				stmt.setString(8, atendente.getEndereco().getEstado());
				stmt.setString(9, atendente.getEndereco().getCep());
				stmt.setString(10, atendente.getContato().getEmail());
				stmt.setString(11, atendente.getContato().getTelefone());
				stmt.setString(12, atendente.getContato().getCelular());
				stmt.execute();
				rs = stmt.getGeneratedKeys();
				int atendenteId = 0;
				while(rs.next()){
					atendenteId = rs.getInt(1);
				}
				atendente.setId_atendente(atendenteId);
				
			}finally{
				stmt.close();
				rs.close();
			}
		}
	}

	@Override
	public Atendente procurar(String cpf)
			throws AtendenteNaoEncontradoException, SQLException {
		Atendente atendente = null;
		String complemento = " and atendente.cpf = " + cpf;
		ArrayList<Atendente> atendentes = this.listar(complemento);
		if(atendentes.isEmpty()){
			throw new AtendenteNaoEncontradoException();
		}
		return atendentes.get(0);
	}
	
	@Override
	public void atualizar(Atendente atendente)
			throws AtendenteNaoEncontradoException, SQLException {
		
		PreparedStatement stmt = null;
		try{
		if(atendente != null){
			String sql = "update atendente set nome = ?, rg = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ?, "
						+ "estado = ?, cep = ?, email = ?, telefone = ?, celular = ?";
			sql += " where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, atendente.getNome());
			stmt.setString(2, atendente.getRg());
			stmt.setString(3, atendente.getEndereco().getLogradouro());
			stmt.setString(4, atendente.getEndereco().getNumero());
			stmt.setString(5, atendente.getEndereco().getBairro());
			stmt.setString(6, atendente.getEndereco().getCidade());
			stmt.setString(7, atendente.getEndereco().getEstado());
			stmt.setString(8, atendente.getEndereco().getCep());
			stmt.setString(9, atendente.getContato().getEmail());
			stmt.setString(10, atendente.getContato().getTelefone());
			stmt.setString(11, atendente.getContato().getCelular());
			stmt.setString(12, atendente.getCpf());
			Integer resultado = stmt.executeUpdate();
			if(resultado == 0) throw new AtendenteNaoEncontradoException();
			
		}
		}finally{
			stmt.close();
		}
	}

	@Override
	public void remover(String cpf) throws AtendenteNaoEncontradoException,
			SQLException {
		PreparedStatement stmt = null;
		try{
			String sql = "delete from atendente where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
		}finally{
			stmt.close();
		}
		
	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String sql = "select count(*) as quantidade from atendente where cpf = ?";
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
	public ArrayList<Atendente> listar() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Atendente> atendentes = new ArrayList<Atendente>(); 
		
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from atendente";
			sql += " where id_atendente is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Atendente atendente = new Atendente(rs.getInt("id_atendente"), rs.getString("nome"),  rs.getString("cpf"),
						rs.getString("rg"),  rs.getString("logradouro"), rs.getString("numero"), 
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
				
				atendente.setContato(contato);
				atendente.setEndereco(endereco);
				atendentes.add(atendente);
				}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return atendentes;
	}

	@Override
	public ArrayList<Atendente> listar(String complemento)
			throws SQLException {
		ArrayList<Atendente> atendentes = new ArrayList<Atendente>(); 
		PreparedStatement stmt = null;
		
		String sql = "";
		ResultSet rs = null;
		try{
			sql = "select * from atendente";
			sql += " where id_atendente is not null ";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Atendente atendente = new Atendente(rs.getInt("id_atendente"), rs.getString("nome"),  rs.getString("cpf"),
						rs.getString("rg"),  rs.getString("logradouro"), rs.getString("numero"), 
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
				
				atendente.setContato(contato);
				atendente.setEndereco(endereco);
				atendentes.add(atendente);
				}
		}finally{
			stmt.close();
			//rs.close();
		}
		
		return atendentes;
	}

}
