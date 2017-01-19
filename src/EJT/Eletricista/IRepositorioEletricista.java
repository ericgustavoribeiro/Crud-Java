package EJT.Eletricista;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioEletricista {

	public void Cadastrar (Eletricista eletricista) throws CampoObrigatorioException, SQLException, EletricistaJaCadastradoEXception;
	public Eletricista procurar(String cpf) throws CampoObrigatorioException, SQLException, EletricistaNaoEncontradoException;
	public void atualizar (Eletricista eletricista) throws CampoObrigatorioException, SQLException, EletricistaNaoEncontradoException;
	public void remover (String cpf) throws CampoObrigatorioException, SQLException, EletricistaNaoEncontradoException;
	public boolean existe (String cpf) throws CampoObrigatorioException, SQLException, EletricistaNaoEncontradoException;
	public ArrayList<Eletricista> listar() throws SQLException;
	public ArrayList<Eletricista> listar(String complemento) throws SQLException;
	
	
	
}
