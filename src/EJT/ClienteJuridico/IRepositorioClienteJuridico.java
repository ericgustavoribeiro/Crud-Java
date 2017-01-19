package EJT.ClienteJuridico;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.ClienteFisico.ClienteNaoEncontradoException;

public interface IRepositorioClienteJuridico {
 
	public void cadastrar(ClienteJuridico clienteJuridico) throws CampoObrigatorioException, CNPJInvalidoException, ClienteJuridicoJaCadastradoException, SQLException;
	public void atualizar(ClienteJuridico clienteJuridico)  throws CampoObrigatorioException, ClienteJuridicoNaoEncontradoException, SQLException, ClienteNaoEncontradoException;
	public void remover(String cnpj) throws CampoObrigatorioException, ClienteJuridicoNaoEncontradoException, SQLException;
	public ClienteJuridico procuarar(String cnpj) throws CampoObrigatorioException, ClienteJuridicoNaoEncontradoException, SQLException;
	public boolean existe(String cnpj) throws CampoObrigatorioException, ClienteJuridicoNaoEncontradoException, SQLException;
	public ArrayList<ClienteJuridico> listar() throws SQLException;
	public ArrayList<ClienteJuridico> listar(String complemento) throws SQLException;

}
