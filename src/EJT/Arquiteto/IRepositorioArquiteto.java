package EJT.Arquiteto;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Arquiteto.CampoObrigatorioException;



//cau conselho de arquitetura e urbanismo
public interface IRepositorioArquiteto {
	
	public void Cadastrar(Arquiteto arquiteto) throws ArquitetoJaCadastradoException, SQLException, CampoObrigatorioException;
	public Arquiteto procurar(String cpf) throws ArquitetoNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void atualizar(Arquiteto arquiteto) throws ArquitetoNaoEncontradoException, SQLException, CampoObrigatorioException, EJT.Arquiteto.CampoObrigatorioException;
	public boolean existe(String cpf) throws SQLException, CampoObrigatorioException, ArquitetoNaoEncontradoException;
	public ArrayList<Arquiteto> listar() throws SQLException;
	public ArrayList<Arquiteto> listar(String complemento) throws SQLException;
	public void remover(String cpf) throws ArquitetoNaoEncontradoException, SQLException, CampoObrigatorioException;
	
	

}
