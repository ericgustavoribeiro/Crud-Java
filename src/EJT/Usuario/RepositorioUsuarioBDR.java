package EJT.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import EJT.Util.Conexao;
import EJT.Util.Database;

public class RepositorioUsuarioBDR implements IRepositorioUsuario {

	private Connection conectar = null;
	private PreparedStatement stmt;
	
	public RepositorioUsuarioBDR() throws Exception {
		this.conectar = Conexao.getConnection(Database.MYSQL);
		
	}

	@Override
	public void cadastrar(Usuario usuario) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		try{
			sql = "insert into usuario(nome, senha, cpf)" + "values(?, ?, ?)";
			stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getCpf());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			int idUsuario = 0;
			while(rs.next()){
				idUsuario = rs.getInt(1);
			}
			usuario.setIdUsuario(idUsuario);
		}finally{
			stmt.close();
			rs.close();
		}
		
	}

	@Override
	public void atualizar(Usuario usuario) throws SQLException, UsuarioNaoEncontrado {
		PreparedStatement stmt = null;
		String sql;
		try{
		if(usuario != null){
			sql = "update usuario set nome = ?, senha = ?"
					+ " where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getCpf());
			Integer resultado = stmt.executeUpdate();
			if(resultado == 0 ){
				throw new UsuarioNaoEncontrado();
				
			}
		}
		}finally{
			stmt.close();
			
		}
		
	}

	@Override
	public void remover(String cpf) throws SQLException {
		PreparedStatement stmt = null;
		try{
			String sql = "delete from usuario where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
		}finally{
			stmt.close();
			
		}
		
		
	}

	@Override
	public Usuario procurar(String cpf) throws UsuarioNaoEncontrado, SQLException {

		Usuario usuario = null;
		String complemento = " and usuario.cpf = " + cpf;
		ArrayList<Usuario> usuarios = this.listar(complemento);
		if(usuarios.isEmpty()){
			throw new UsuarioNaoEncontrado();			
		}
		
		return usuarios.get(0);
		
	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String sql = "select count(*) as quantidade from usuario where cpf = ? ";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt("quantidade")== 0 ){
				return false;
			}else{
				return true;
			}
		}finally{
			stmt.close();
		}
	}

	@Override
	public ArrayList<Usuario> listar() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql +="select * from usuario";
			sql +=" where usuario.idUsuario is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nome"), rs.getString("Senha"), rs.getString("cpf"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setCpf(rs.getString("cpf"));
				
				usuarios.add(usuario);
				
			}
		}finally{
			stmt.close();
			rs.close();
			
		}
		
		return usuarios;
	}

	@Override
	public ArrayList<Usuario> listar(String complemento) throws SQLException {
		stmt = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql +="select * from usuario";
			sql +=" where usuario.idUsuario is not null";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nome"), rs.getString("Senha"), rs.getString("cpf"));
				
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setCpf(rs.getString("cpf"));
				usuarios.add(usuario);
				
			}
		}finally{
			stmt.close();
		}
		return usuarios;
	}
	
}
