package EJT.Gerente;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Util.Conexao;
import EJT.Util.Database;

public class RepositorioGerenteBDR implements IRepositorioGerente {

	private Connection conectar = null;
	
	public RepositorioGerenteBDR() throws Exception{
		this.conectar = Conexao.getConnection(Database.MYSQL);
	}
	
	@Override
	public void Cadastrar(Gerente gerente) throws GerenteJaCadastradoException,
			SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if(gerente !=null){
			try{
				sql = "insert into gerente(nome, cpf, rg, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular)" + 
				"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, gerente.getNome());
				stmt.setString(2, gerente.getCpf());
				stmt.setString(3, gerente.getRg());
				stmt.setString(4, gerente.getEndereco().getLogradouro());
				stmt.setString(5, gerente.getEndereco().getNumero());
				stmt.setString(6, gerente.getEndereco().getBairro());
				stmt.setString(7, gerente.getEndereco().getCidade());
				stmt.setString(8, gerente.getEndereco().getEstado());
				stmt.setString(9, gerente.getEndereco().getCep());
				stmt.setString(10, gerente.getContato().getEmail());
				stmt.setString(11, gerente.getContato().getTelefone());
				stmt.setString(12, gerente.getContato().getCelular());
				stmt.execute();
				rs = stmt.getGeneratedKeys();
				int gerenteId = 0;
				while(rs.next()){
					gerenteId = rs.getInt(1);
				}
				gerente.setId_gerente(gerenteId);
			}finally{
				stmt.close();
			}
		}

		
		
	}

	@Override
	public Gerente procurar(String cpf) throws GerenteNaoEncontradoExceptio,
			SQLException {
		Gerente gerente = null;
		String complemento = " and gerente.cpf = " + cpf;
		ArrayList<Gerente> gerentes = this.listar(complemento);
		if(gerentes.isEmpty()){
			throw new GerenteNaoEncontradoExceptio();
			
		}
			return gerentes.get(0);
	}

	@Override
	public void atualizar(Gerente gerente) throws GerenteNaoEncontradoExceptio,
			SQLException {

		PreparedStatement stmt = null;
		try{
			if(gerente !=null){
				String sql = "update gerente set nome = ?, rg = ?, "
						+ "logradouro = ?, numero = ?,  bairro = ?, cidade = ?, estado = ?, "
						+ "cep = ?, email = ?, telefone = ?, celular = ?" ;
				sql +=" where cpf =?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, gerente.getNome());
				stmt.setString(2, gerente.getRg());
				stmt.setString(3, gerente.getEndereco().getLogradouro());
				stmt.setString(4, gerente.getEndereco().getNumero());
				stmt.setString(5, gerente.getEndereco().getBairro());
				stmt.setString(6, gerente.getEndereco().getCidade());
				stmt.setString(7, gerente.getEndereco().getEstado());
				stmt.setString(8, gerente.getEndereco().getCep());
				stmt.setString(9, gerente.getContato().getEmail());
				stmt.setString(10, gerente.getContato().getTelefone());
				stmt.setString(11, gerente.getContato().getCelular());
				stmt.setString(12, gerente.getCpf());
				Integer resultado = stmt.executeUpdate();
				
				if(resultado == 0){
					throw new GerenteNaoEncontradoExceptio();
				}
			}
		}finally {
			stmt.close();
		}
	}

	@Override
	public void remover(String cpf) throws GerenteNaoEncontradoExceptio,
			SQLException {
		PreparedStatement stmt = null;
		try{
			String sql = "delete from gerente where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
		}finally{
			stmt.close();
		}
		
	}


	@Override
	public boolean existe(String cpf) throws GerenteNaoEncontradoExceptio,
			SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String sql = "select count(*) as quantidade from gerente where cpf=?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt("quantidade") == 0){
				return false;
			}else {
				return true;
			}
		}finally{
			stmt.close();
		}
		
	}
	

	
	@Override
	public ArrayList<Gerente> listar() throws SQLException {
		ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
		PreparedStatement stmt = null;
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from gerente";
			sql += " where id_gerente is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()){
				Gerente gerente = new Gerente(rs.getInt("id_gerente"), rs.getString("nome"), 
						rs.getString("cpf"),  rs.getString("rg"), rs.getString("logradouro"), rs.getString("numero"), 
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
				
				gerente.setContato(contato);
				gerente.setEndereco(endereco);
				gerentes.add(gerente);
				
			}
		}finally{
			stmt.close();
			rs.close();
		}
		return gerentes;
	}

	@Override
	public ArrayList<Gerente> listar(String complemento) throws SQLException {
		ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
		PreparedStatement stmt = null;
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from gerente";
			sql += " where id_gerente is not null ";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()){
				Gerente gerente = new Gerente(rs.getInt("id_gerente"), rs.getString("nome"), 
						rs.getString("cpf"),  rs.getString("rg"), rs.getString("logradouro"), rs.getString("numero"), 
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
				
				gerente.setContato(contato);
				gerente.setEndereco(endereco);
				gerentes.add(gerente);
				
			}
		}finally{
			stmt.close();
			rs.close();
		}
		return gerentes;
	}
}
