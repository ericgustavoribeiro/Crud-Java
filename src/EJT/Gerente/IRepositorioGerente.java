package EJT.Gerente;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioGerente {
	
	public void Cadastrar(Gerente gerente) throws GerenteJaCadastradoException, SQLException, CampoObrigatorioException;
	public Gerente procurar(String cpf)throws GerenteJaCadastradoException, SQLException, CampoObrigatorioException, GerenteNaoEncontradoExceptio;
	public void atualizar(Gerente gerente)throws GerenteJaCadastradoException, SQLException, CampoObrigatorioException, GerenteNaoEncontradoExceptio;
	public void remover(String cpf) throws GerenteJaCadastradoException, SQLException, CampoObrigatorioException, GerenteNaoEncontradoExceptio;
	public boolean existe(String cpf) throws GerenteJaCadastradoException, SQLException, CampoObrigatorioException, GerenteNaoEncontradoExceptio;
	public ArrayList<Gerente> listar()throws SQLException, CampoObrigatorioException;
	public ArrayList<Gerente> listar(String complemento)throws SQLException;
	
	
	

}
