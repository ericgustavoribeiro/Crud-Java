package EJT.MestredeObras;

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

public class RepositorioMestreDeObrasBDR implements IRepositorioMestreDeObras{

	
private Connection conectar = null;
	
	
	
	public RepositorioMestreDeObrasBDR() throws Exception {

		this.conectar = Conexao.getConnection(Database.MYSQL);
	}
	
	
	@Override
	public void Cadastrar(MestreDeObras mestreDeObras)
			throws MestreDeObrasJaCadastradoException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if(mestreDeObras != null){
			try{
				sql = "insert into mestre_obras(nome, cpf, rg, disponibilidade, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular) " +
						"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, mestreDeObras.getNome());
				stmt.setString(2, mestreDeObras.getCpf());
				stmt.setString(3, mestreDeObras.getRg());
				stmt.setString(4, mestreDeObras.getDisponibilidade());
				stmt.setString(5, mestreDeObras.getEndereco().getLogradouro());
				stmt.setString(6, mestreDeObras.getEndereco().getNumero());
				stmt.setString(7, mestreDeObras.getEndereco().getBairro());
				stmt.setString(8, mestreDeObras.getEndereco().getCidade());
				stmt.setString(9, mestreDeObras.getEndereco().getEstado());
				stmt.setString(10, mestreDeObras.getEndereco().getCep());
				stmt.setString(11, mestreDeObras.getContato().getEmail());
				stmt.setString(12, mestreDeObras.getContato().getTelefone());
				stmt.setString(13, mestreDeObras.getContato().getCelular());	
				
				rs = stmt.getGeneratedKeys();
				stmt.execute();
				int mestreId = 0;
				while(rs.next()){
					mestreDeObras.getId_mestre();
				}
				
			}finally{
				stmt.close();
				rs.close();
			}
		}
	     }
		
	
	@Override
	public MestreDeObras procurar(String cpf)
			throws MestreDeObrasNaoEncontradoException, SQLException {
		MestreDeObras mestre = null;
		String complemento = " and mestre_obras.cpf = " + cpf;
		ArrayList<MestreDeObras> MestreDeObras = this.listar(complemento);
		if(MestreDeObras.isEmpty()){
			throw new MestreDeObrasNaoEncontradoException();
		}
		return MestreDeObras.get(0);
	}
	
	
	@Override
	public void atualizar(MestreDeObras mestreDeObras)
			throws MestreDeObrasNaoEncontradoException, SQLException {
		PreparedStatement stmt = null;
		try{
			if(mestreDeObras != null){
				String sql = "update mestre_obras set nome = ?, rg = ?, disponibilidade = ?, "
						+ "logradouro = ?, numero = ?,  bairro = ?, cidade = ?, estado = ?, "
						+ "cep = ?, email = ?, telefone = ?, celular = ?" ;
				sql += " where cpf = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, mestreDeObras.getNome());
				stmt.setString(2, mestreDeObras.getRg());
				stmt.setString(3, mestreDeObras.getDisponibilidade());
				stmt.setString(4, mestreDeObras.getEndereco().getLogradouro());
				stmt.setString(5, mestreDeObras.getEndereco().getNumero());
				stmt.setString(6, mestreDeObras.getEndereco().getBairro());
				stmt.setString(7, mestreDeObras.getEndereco().getCidade());
				stmt.setString(8, mestreDeObras.getEndereco().getEstado());
				stmt.setString(9, mestreDeObras.getEndereco().getCep());
				stmt.setString(10, mestreDeObras.getContato().getEmail());
				stmt.setString(11, mestreDeObras.getContato().getTelefone());
				stmt.setString(12, mestreDeObras.getContato().getCelular());	
				stmt.setString(13, mestreDeObras.getCpf());
				Integer resultado = stmt.executeUpdate();
				
				if(resultado == 0){
					throw new MestreDeObrasNaoEncontradoException();
				}
			}
			
		}finally{
			stmt.close();
		}
		
	}
	
	@Override
	public void remover(String cpf) throws MestreDeObrasNaoEncontradoException,
			SQLException {
			PreparedStatement stmt = null;
			try{
				String sql ="delete from mestre_obras where cpf = ?" ;
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
			String sql ="select count(*) as quantidade from mestre_obras where cpf = ?";
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
			rs.close();
		}
	
	}
 
	@Override
	public ArrayList<MestreDeObras> listar() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<MestreDeObras> mestreDeObras = new ArrayList<MestreDeObras>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from mestre_obras";
			sql += " where id_mestre is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				MestreDeObras mestre_de_obras = new MestreDeObras(rs.getInt("id_mestre"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg") ,rs.getString("disponibilidade"), rs.getString("logradouro"), rs.getString("numero"), 
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
				
				mestre_de_obras.setContato(contato);
				mestre_de_obras.setEndereco(endereco);
				mestreDeObras.add(mestre_de_obras);
				
            
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return mestreDeObras;
	}
	
	
	@Override
	public ArrayList<MestreDeObras> listar(String complemento) throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<MestreDeObras> mestreDeObras = new ArrayList<MestreDeObras>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from mestre_obras";
			sql += " where id_mestre is not null";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				MestreDeObras mestre_de_obras = new MestreDeObras(rs.getInt("id_mestre"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg") ,rs.getString("disponibilidade"), rs.getString("logradouro"), rs.getString("numero"), 
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
				
				mestre_de_obras.setContato(contato);
				mestre_de_obras.setEndereco(endereco);
				mestreDeObras.add(mestre_de_obras);
			}
		}finally{
			stmt.close();
		
		}
		
		return mestreDeObras;
	}


	}
	

