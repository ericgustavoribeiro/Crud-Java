package EJT.Encanador;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Encanador.CampoObrigatorioException;



public interface IRepositorioEncanador {
	public void Cadastrar(Encanador encanador) throws EncanadorCadastradoException, SQLException, EncanadorCadastradoException, CampoObrigatorioException, CampoObrigatorioException ;
	public Encanador procurar(String cpf) throws EncanadorNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void atualizar(Encanador encanador)throws EncanadorNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void remover(String cpf)throws EncanadorNaoEncontradoException, SQLException, CampoObrigatorioException;
	public boolean existe(String cpf)throws SQLException, CampoObrigatorioException, EncanadorNaoEncontradoException;
	public ArrayList<Encanador> listar()throws SQLException;
	public ArrayList<Encanador> listar(String complemento)throws SQLException;
}
