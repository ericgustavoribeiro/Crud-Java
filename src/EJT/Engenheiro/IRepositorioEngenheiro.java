package EJT.Engenheiro;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioEngenheiro {

	public void Cadastrar(Engenheiro engenheiro) throws EngenheiroJaCadastradoException, SQLException, CampoObrigatorioException;
	public Engenheiro procurar(String cpf) throws EngenheiroNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void atualizar(Engenheiro engenheiro)throws EngenheiroNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void remover(String cpf)throws EngenheiroNaoEncontradoException, SQLException, CampoObrigatorioException;
	public boolean existe(String cpf)throws SQLException, CampoObrigatorioException, EngenheiroNaoEncontradoException;
	public ArrayList<Engenheiro> listar()throws SQLException;
	public ArrayList<Engenheiro> listar(String complemento)throws SQLException;

	
}
