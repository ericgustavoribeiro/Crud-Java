package EJT.Encanador;

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

public class RepositorioEncanadorBDR implements IRepositorioEncanador{

	
private Connection conectar = null;
	
	
	
	public RepositorioEncanadorBDR() throws Exception {

		this.conectar = Conexao.getConnection(Database.MYSQL);
	}
	
	
	@Override
	public void Cadastrar(Encanador encanador)
			throws EncanadorCadastradoException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if(encanador != null){
			try{
				sql = "insert into encanador(nome, cpf, rg, disponibilidade, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular) " +
						"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, encanador.getNome());
				stmt.setString(2, encanador.getCpf());
				stmt.setString(3, encanador.getRg());
				stmt.setString(4, encanador.getDisponibilidade());
				stmt.setString(5, encanador.getEndereco().getLogradouro());
				stmt.setString(6, encanador.getEndereco().getNumero());
				stmt.setString(7, encanador.getEndereco().getBairro());
				stmt.setString(8, encanador.getEndereco().getCidade());
				stmt.setString(9, encanador.getEndereco().getEstado());
				stmt.setString(10, encanador.getEndereco().getCep());
				stmt.setString(11, encanador.getContato().getEmail());
				stmt.setString(12, encanador.getContato().getTelefone());
				stmt.setString(13, encanador.getContato().getCelular());	
				stmt.execute();
				rs = stmt.getGeneratedKeys();
				int encanadorId = 0;
				while(rs.next()){
					encanador.getId_encanador();
				}
				
			}finally{
				stmt.close();
				rs.close();
			}
		}
	     }
		
	
	@Override
	public Encanador procurar(String cpf)
			throws EncanadorNaoEncontradoException, SQLException {
		Encanador encanador = null;
		String complemento = " and encanador.cpf = " + cpf;
		ArrayList<Encanador> encanadores = this.listar(complemento);
		if(encanadores.isEmpty()){
			throw new EncanadorNaoEncontradoException();
		}
		return encanadores.get(0);
	}
	
	
	@Override
	public void atualizar(Encanador encanador)
			throws EncanadorNaoEncontradoException, SQLException {
		PreparedStatement stmt = null;
		try{
			if(encanador != null){
				String sql = "update encanador set nome = ?, rg = ?, disponibilidade = ?, "
						+ "logradouro = ?, numero = ?,  bairro = ?, cidade = ?, estado = ?, "
						+ "cep = ?, email = ?, telefone = ?, celular = ?";
				sql += " where cpf = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, encanador.getNome());
				stmt.setString(2, encanador.getRg());
				stmt.setString(3, encanador.getDisponibilidade());
				stmt.setString(4, encanador.getEndereco().getLogradouro());
				stmt.setString(5, encanador.getEndereco().getNumero());
				stmt.setString(6, encanador.getEndereco().getBairro());
				stmt.setString(7, encanador.getEndereco().getCidade());
				stmt.setString(8, encanador.getEndereco().getEstado());
				stmt.setString(9, encanador.getEndereco().getCep());
				stmt.setString(10, encanador.getContato().getEmail());
				stmt.setString(11, encanador.getContato().getTelefone());
				stmt.setString(12, encanador.getContato().getCelular());	
				stmt.setString(13, encanador.getCpf());
				Integer resultado = stmt.executeUpdate();
				if(resultado == 0){
					throw new EncanadorNaoEncontradoException();
				}
			}
			
		}finally{
			stmt.close();
		}
		
	}
	
	@Override
	public void remover(String cpf) throws EncanadorNaoEncontradoException,
			SQLException {
			PreparedStatement stmt = null;
			try{
				String sql ="delete from encanador where cpf = ?" ;
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
			String sql ="select count(*) as quantidade from encanador where cpf = ?";
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
	public ArrayList<Encanador> listar() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Encanador> encanadores = new ArrayList<Encanador>();
		
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from encanador";
			sql += " where id_encanador is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Encanador encanador = new Encanador(rs.getInt("id_encanador"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg") ,rs.getString("disponibilidade"), rs.getString("logradouro"), rs.getString("numero"), 
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
				
				encanador.setContato(contato);
				encanador.setEndereco(endereco);
				encanadores.add(encanador);
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return encanadores;
	}
	
	
	@Override
	public ArrayList<Encanador> listar(String complemento) throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Encanador> encanadores = new ArrayList<Encanador>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from encanador";
			sql += " where encanador.id_encanador is not null";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Encanador encanador = new Encanador(rs.getInt("id_encanador"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg") ,rs.getString("disponibilidade"), rs.getString("logradouro"), rs.getString("numero"), 
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
				
				encanador.setContato(contato);
				encanador.setEndereco(endereco);
				encanadores.add(encanador);
			}
		}finally{
			stmt.close();
			
		}
		
		return encanadores;
	}


	}
	

