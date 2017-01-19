package EJT.Gerente;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Util.Validacao;

public class ControladorGerente {
	
	private IRepositorioGerente repositorioGerente;
	
	public ControladorGerente() throws Exception{
		this.repositorioGerente = new RepositorioGerenteBDR();
		
	}
	
	public void cadastrar(Gerente gerente) throws CPFInvalidoException, CampoObrigatorioException, GerenteJaCadastradoException, SQLException, GerenteNaoEncontradoExceptio{
		if(!Validacao.validaCPF(gerente.getCpf())) throw new CPFInvalidoException(gerente.getCpf());
		if(gerente.getNome().equals("")==true) throw new CampoObrigatorioException();
		if(gerente.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioException();
		if(gerente.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioException();
		if(gerente.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioException();
		if(gerente.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
		if(gerente.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioException();
		if(gerente.getEndereco().getCep().equals("") == true) throw new CampoObrigatorioException();
		if(gerente.getContato().getCelular().equals("") == true) throw new CampoObrigatorioException();
		if(gerente.getContato().getTelefone().equals("") == true) throw new CampoObrigatorioException();
		if(this.repositorioGerente.existe(gerente.getCpf())) throw new GerenteJaCadastradoException("Gerente Já Esta Cadastrado !!!");
		
		
		this.repositorioGerente.Cadastrar(gerente);
		
	}
	
	public void remover(String cpf) throws GerenteJaCadastradoException, SQLException, CPFInvalidoException, CampoObrigatorioException, GerenteNaoEncontradoExceptio{
		cpf=cpf.replaceAll("\\.|\\|\\ ", "");
		Gerente gerente = null;
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		gerente = this.repositorioGerente.procurar(cpf);
		this.repositorioGerente.remover(cpf);
	}
	
	public Gerente procurar(String cpf) throws CPFInvalidoException,GerenteJaCadastradoException, SQLException, CampoObrigatorioException, GerenteNaoEncontradoExceptio{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		if(!Validacao.validaCPF(cpf))
			throw new CPFInvalidoException(cpf);
		return this.repositorioGerente.procurar(cpf);
	}

	public void atualizar(Gerente gerente) throws CPFInvalidoException,
			GerenteJaCadastradoException, SQLException, EJT.Gerente.CampoObrigatorioException, GerenteNaoEncontradoExceptio {
		if (!Validacao.validaCPF(gerente.getCpf())) throw new CPFInvalidoException(gerente.getCpf());
		if(gerente.getNome().equals("")) throw new EJT.Gerente.CampoObrigatorioException();
		this.repositorioGerente.atualizar(gerente);
		}

	public ArrayList<Gerente> listar() throws SQLException, CampoObrigatorioException{
		return this.repositorioGerente.listar();
	}
}
