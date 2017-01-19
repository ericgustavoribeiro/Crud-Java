package EJT.ClienteFisico;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioClienteFisico {

	public void cadastrar(ClienteFisico clienteFisico) throws CPFInvalidoException, ClienteJaCadastradoException, CampoObrigatorioException, SQLException;
	public void atualizar(ClienteFisico clienteFisico) throws ClienteNaoEncontradoException, CampoObrigatorioException, SQLException;
	public void remover(String cpf) throws ClienteNaoEncontradoException, CampoObrigatorioException, SQLException;
	public ClienteFisico procurar(String cpf) throws ClienteNaoEncontradoException, CampoObrigatorioException, SQLException;;
	public boolean existe(String cpf) throws CampoObrigatorioException, ClienteNaoEncontradoException, CPFInvalidoException, SQLException;
	public ArrayList<ClienteFisico> listar() throws SQLException;
	public ArrayList<ClienteFisico> listar(String complemento) throws SQLException;
}
