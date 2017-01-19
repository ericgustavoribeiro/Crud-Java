package EJT.Eletricista;

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

public class RepositorioEletricistaBDR implements IRepositorioEletricista {
	
	
private Connection conectar = null;
	
	
	
	public RepositorioEletricistaBDR() throws Exception {

		this.conectar = Conexao.getConnection(Database.MYSQL);
	}
	
	
	@Override
	public void Cadastrar(Eletricista eletricista)
			 throws EletricistaJaCadastradoEXception, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if(eletricista != null){
			try{
				sql = "insert into eletricista(nome, cpf, rg, disponibilidade, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular) " +
						"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, eletricista.getNome());
				stmt.setString(2, eletricista.getCpf());
				stmt.setString(3, eletricista.getRg());
				stmt.setString(4, eletricista.getDisponibilidade());
				stmt.setString(5, eletricista.getEndereco().getLogradouro());
				stmt.setString(6, eletricista.getEndereco().getNumero());
				stmt.setString(7, eletricista.getEndereco().getBairro());
				stmt.setString(8, eletricista.getEndereco().getCidade());
				stmt.setString(9, eletricista.getEndereco().getEstado());
				stmt.setString(10, eletricista.getEndereco().getCep());
				stmt.setString(11, eletricista.getContato().getEmail());
				stmt.setString(12, eletricista.getContato().getTelefone());
				stmt.setString(13, eletricista.getContato().getCelular());	
				stmt.execute();
				rs = stmt.getGeneratedKeys();
				int eletricistaId = 0;
				while(rs.next()){
					eletricista.getId_eletricista();
				}
				
			}finally{
				stmt.close();
				rs.close();
			}
		}
	     }
		
	
	@Override
	public Eletricista procurar(String cpf)
			throws EletricistaNaoEncontradoException, SQLException {
		Eletricista eletricista = null;
		String complemento = " and eletricista.cpf = " + cpf;
		ArrayList<Eletricista> eletricistas = this.listar(complemento);
		if(eletricistas.isEmpty()){
			throw new EletricistaNaoEncontradoException();
		}
		return eletricistas.get(0);
	}
	
	
	@Override
	public void atualizar(Eletricista eletricista)
			throws EletricistaNaoEncontradoException, SQLException {
		PreparedStatement stmt = null;
		try{
			if(eletricista != null){
				String sql = "update eletricista set nome = ?, rg = ?, disponibilidade = ?, "
						+ "logradouro = ?, numero = ?,  bairro = ?, cidade = ?, estado = ?, "
						+ "cep = ?, email = ?, telefone = ?, celular = ?" ;
				sql += " where cpf = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, eletricista.getNome());
				stmt.setString(2, eletricista.getRg());
				stmt.setString(3, eletricista.getDisponibilidade());
				stmt.setString(4, eletricista.getEndereco().getLogradouro());
				stmt.setString(5, eletricista.getEndereco().getNumero());
				stmt.setString(6, eletricista.getEndereco().getBairro());
				stmt.setString(7, eletricista.getEndereco().getCidade());
				stmt.setString(8, eletricista.getEndereco().getEstado());
				stmt.setString(9, eletricista.getEndereco().getCep());
				stmt.setString(10, eletricista.getContato().getEmail());
				stmt.setString(11, eletricista.getContato().getTelefone());
				stmt.setString(12, eletricista.getContato().getCelular());	
				stmt.setString(13, eletricista.getCpf());
				Integer resultado = stmt.executeUpdate();
				
				if(resultado == 0){
					throw new EletricistaNaoEncontradoException();
				}
			}
			
		}finally{
			stmt.close();
		}
		
	}
	
	@Override
	public void remover(String cpf) throws EletricistaNaoEncontradoException,
			SQLException {
			PreparedStatement stmt = null;
			try{
				String sql ="delete from eletricista where cpf = ?" ;
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
			String sql ="select count(*) as quantidade from eletricista where cpf = ?";
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
	public ArrayList<Eletricista> listar() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Eletricista> eletricistas = new ArrayList<Eletricista>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from eletricista";
			sql += " where id_eletricista is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Eletricista eletricista = new Eletricista(rs.getInt("id_eletricista"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg") ,rs.getString("disponibilidade"), rs.getString("logradouro"), rs.getString("numero"), 
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
				eletricista.setContato(contato);
				eletricista.setEndereco(endereco);
				eletricistas.add(eletricista);
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return eletricistas;
	}
	
	
	@Override
	public ArrayList<Eletricista> listar(String complemento) throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Eletricista> eletricistas = new ArrayList<Eletricista>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from eletricista";
			sql += " where id_eletricista is not null";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Eletricista eletricista = new Eletricista(rs.getInt("id_eletricista"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg") ,rs.getString("disponibilidade"), rs.getString("logradouro"), rs.getString("numero"), 
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
				
				eletricista.setContato(contato);
				eletricista.setEndereco(endereco);
				eletricistas.add(eletricista);
			}
		}finally{
			stmt.close();
		
		}
		
		return eletricistas;
	}


	}
	

