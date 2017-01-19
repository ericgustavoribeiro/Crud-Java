package EJT.ContratoJuridico;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioContratoJuridico {

	public void cadastrar(ContratoJuridico contratoJuridico) throws CampoObrigatorioException, SQLException;
	public void atualizar(ContratoJuridico contratoJuridico) throws ContratoNaoEncontradoException, SQLException;
	public void remover(int idContrato) throws ContratoNaoEncontradoException, SQLException;
	public ContratoJuridico procurar(int idContrato) throws ContratoNaoEncontradoException, SQLException;
	public ArrayList<ContratoJuridico> listar() throws SQLException;
	public ArrayList<ContratoJuridico> listar(String complemento) throws SQLException;
	
}
