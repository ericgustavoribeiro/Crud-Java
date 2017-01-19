package EJT.Atendente;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Contato.Contato;

import EJT.Endereco.Endereco;

import EJT.Util.Validacao;

public class ControladorAtendente {

	private IRepositorioAtendente repositorioAtendente;

	public ControladorAtendente() throws Exception {
		this.repositorioAtendente = new RepositorioAtendenteBDR();

	}

	public void cadastrar(Atendente atendente) throws CPFInvalidoException,
			CampoObrigatorioInvalidoException, AtendenteJaCadastradoException,
			SQLException, CampoObrigatorioException, AtendenteNaoEncontradoException{
		if (!Validacao.validaCPF(atendente.getCpf())) throw new CPFInvalidoException(atendente.getCpf());
		if (atendente.getNome().equals("") == true) throw new CampoObrigatorioInvalidoException("Campo nulo ou invalido");
		if (atendente.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioInvalidoException("Campo nulo ou invalido");
		if (atendente.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioInvalidoException("Campo nulo ou invalido");
		if (atendente.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioInvalidoException("Campo nulo ou invalido");
		if (atendente.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioInvalidoException("Campo nulo ou invalido");
		if (atendente.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioInvalidoException("Campo nulo ou invalido");
		if (atendente.getEndereco().getCep().equals("") == true) throw new CampoObrigatorioInvalidoException("Campo nulo ou invalido");	
		if (atendente.getContato().getCelular().equals("") == true) throw new CampoObrigatorioInvalidoException("Campo nulo ou invalido");
		if (atendente.getContato().getTelefone().equals("") == true) throw new CampoObrigatorioInvalidoException("Campo nulo ou invalido");
		if (this.repositorioAtendente.existe(atendente.getCpf())) throw new AtendenteJaCadastradoException();
		this.repositorioAtendente.Cadastrar(atendente);

	}

	public void remover(String cpf) throws AtendenteNaoEncontradoException,
			SQLException, CPFInvalidoException, CampoObrigatorioException {
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		Atendente atendente = null;

		if (!Validacao.validaCPF(cpf))
			throw new CPFInvalidoException(cpf);
		atendente = this.repositorioAtendente.procurar(cpf);

		this.repositorioAtendente.remover(cpf);
	}

	public Atendente procurar(String cpf) throws CPFInvalidoException,
	AtendenteNaoEncontradoException, SQLException, CampoObrigatorioException {
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		if (!Validacao.validaCPF(cpf))
			throw new CPFInvalidoException(cpf);
		return this.repositorioAtendente.procurar(cpf);

	}

	public void atualizar(Atendente antendente) throws CPFInvalidoException,
			CampoObrigatorioInvalidoException, AtendenteNaoEncontradoException,
			SQLException, CampoObrigatorioException {
		if (!Validacao.validaCPF(antendente.getCpf()))
			throw new CPFInvalidoException(antendente.getCpf());
		if (antendente.getNome().equals("") == true)
			throw new CampoObrigatorioInvalidoException("Campo nulo um invalido");

		this.repositorioAtendente.atualizar(antendente);
	}

	public ArrayList<Atendente> listar() throws SQLException {
		return this.repositorioAtendente.listar();
	}
}
