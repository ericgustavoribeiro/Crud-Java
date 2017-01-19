package EJT.MestredeObras;

import java.sql.SQLException;
import java.util.ArrayList;



public interface IRepositorioMestreDeObras {
	public void Cadastrar(MestreDeObras MestreDeObras) throws MestreDeObrasJaCadastradoException, SQLException, CampoObrigatorioException;
	public MestreDeObras procurar(String cpf) throws MestreDeObrasNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void atualizar(MestreDeObras MestreDeObras)throws MestreDeObrasNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void remover(String cpf)throws MestreDeObrasNaoEncontradoException, SQLException, CampoObrigatorioException;
	public boolean existe(String cpf)throws SQLException, CampoObrigatorioException, MestreDeObrasNaoEncontradoException;
	public ArrayList<MestreDeObras> listar()throws SQLException;
	public ArrayList<MestreDeObras> listar(String complemento)throws SQLException;
}
//ok