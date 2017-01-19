package EJT.Jardineiro;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioJardineiro {

	public void cadastrar(Jardineiro jardineiro) throws JardineiroJaCadastradoException, CampoObrigatorioException, SQLException;
	public void atualizar(Jardineiro jardineiro) throws CampoObrigatorioException, JardineiroNaoEncontradoException, SQLException;
	public void remover(String cpf) throws CampoObrigatorioException, JardineiroNaoEncontradoException, SQLException;;
	public Jardineiro procurar(String cpf) throws CampoObrigatorioException, JardineiroNaoEncontradoException, SQLException;;
	public boolean existe(String cpf) throws CampoObrigatorioException, JardineiroNaoEncontradoException, SQLException;;
	public ArrayList<Jardineiro> listar() throws SQLException;
	public ArrayList<Jardineiro> listar(String complemento) throws SQLException;
	
	
}
