package EJT.Contrato;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Arquiteto.Arquiteto;
import EJT.Contrato.ContratoNaoEncontradoException;

public interface IRepositorioContrato {

	public void cadastrarPF(Contrato contrato) throws SQLException;
	public Contrato contratoProcurar(int idContrato) throws SQLException, ContratoNaoEncontradoException;
	//public boolean existe(String cpf) throws SQLException;
	public ArrayList<Contrato> listar() throws SQLException, ContratoNaoEncontradoException;
	public ArrayList<Contrato> listar(String complemento) throws SQLException, ContratoNaoEncontradoException;
	public void atualizar(Contrato contrato) throws SQLException, ContratoNaoEncontradoException;
	public void remover(int idContrato) throws SQLException;
	
}
