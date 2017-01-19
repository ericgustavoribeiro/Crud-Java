package EJT.Atendente;



import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioAtendente {
	
	public void Cadastrar(Atendente atendente) throws AtendenteJaCadastradoException, SQLException, CampoObrigatorioException;
	public Atendente procurar(String cpf) throws AtendenteNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void atualizar(Atendente atendente) throws AtendenteNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void remover(String cpf) throws AtendenteNaoEncontradoException, SQLException, CampoObrigatorioException;
	public boolean existe(String cpf) throws SQLException, CampoObrigatorioException, AtendenteNaoEncontradoException;
	public ArrayList<Atendente> listar() throws SQLException;
	public ArrayList<Atendente> listar(String complemento) throws SQLException;

}
