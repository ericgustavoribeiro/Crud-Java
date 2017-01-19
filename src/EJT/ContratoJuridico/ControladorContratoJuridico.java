package EJT.ContratoJuridico;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.ClienteJuridico.CNPJInvalidoException;
import EJT.Util.Validacao;

public class ControladorContratoJuridico {

	private IRepositorioContratoJuridico repositorioContrato;

	public ControladorContratoJuridico() throws Exception {

		this.repositorioContrato = new RepositorioContratoJuridicoBDR();
	}

	public void cadastrar(ContratoJuridico contratoJuridico)
			throws CampoObrigatorioException, CNPJInvalidoException,
			SQLException {

		this.repositorioContrato.cadastrar(contratoJuridico);
	}

	public void atualizar(ContratoJuridico contratoJuridico)
			throws ContratoNaoEncontradoException, SQLException {

		this.repositorioContrato.atualizar(contratoJuridico);

	}

	public void remover(int idContrato) throws ContratoNaoEncontradoException,
			SQLException {
		ContratoJuridico contratoJuridico = null;

		contratoJuridico = this.procurar(idContrato);

		this.repositorioContrato.remover(idContrato);
	}

	public ContratoJuridico procurar(int idContrato)
			throws ContratoNaoEncontradoException, SQLException {

		return this.repositorioContrato.procurar(idContrato);
	}

	public ArrayList<ContratoJuridico> listar() throws SQLException {

		return this.repositorioContrato.listar();
	}
}
