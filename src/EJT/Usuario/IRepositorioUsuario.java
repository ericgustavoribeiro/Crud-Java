package EJT.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioUsuario {

	
	public void cadastrar(Usuario usuario) throws SQLException;
	public void atualizar (Usuario usuario) throws SQLException, UsuarioNaoEncontrado;
	public void remover(String cpf) throws SQLException;
	public Usuario procurar(String cpf) throws UsuarioNaoEncontrado, SQLException;
	public boolean existe(String cpf) throws SQLException;
	public ArrayList<Usuario> listar() throws SQLException;
	public ArrayList<Usuario> listar(String complemento) throws SQLException;
}
