package EJT.Eletricista;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Eletricista.CampoObrigatorioException;
import EJT.Eletricista.EletricistaNaoEncontradoException;
import EJT.Util.Validacao;

public class ControladorEletricista {

	private IRepositorioEletricista repositorioEletricista;
	
	public ControladorEletricista() throws Exception{
		this.repositorioEletricista = new RepositorioEletricistaBDR();
		
	}
	
	public void cadastrar(Eletricista eletricista) throws SQLException, CampoObrigatorioException, EletricistaJaCadastradoEXception, EletricistaNaoEncontradoException, CPFInvalidoException{
		if(!Validacao.validaCPF(eletricista.getCpf())) throw new CPFInvalidoException(eletricista.getCpf());
		if (eletricista.getNome().equals("") == true)throw new  CampoObrigatorioException();
		if (eletricista.getEndereco().getBairro().equals("") == true)throw new  CampoObrigatorioException();
		if (eletricista.getEndereco().getCidade().equals("") == true)throw new  CampoObrigatorioException();
		if (eletricista.getEndereco().getCep().equals("") == true)throw new  CampoObrigatorioException();
		if (eletricista.getEndereco().getLogradouro().equals("") == true)throw new  CampoObrigatorioException();
		if (eletricista.getEndereco().getNumero().equals("") == true)throw new  CampoObrigatorioException();
		if (eletricista.getEndereco().getEstado().equals("") == true)throw new  CampoObrigatorioException();
		if (eletricista.getContato().getCelular().equals("") == true)throw new  CampoObrigatorioException();
		if (eletricista.getContato().getTelefone().equals("") == true)throw new  CampoObrigatorioException();
		if (this.repositorioEletricista.existe(eletricista.getCpf())) throw new EletricistaJaCadastradoEXception();
		this.repositorioEletricista.Cadastrar(eletricista);
	}
	public void remover(String cpf) throws CPFInvalidoException, EletricistaNaoEncontradoException, SQLException, CampoObrigatorioException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		Eletricista eletricista = null;
		
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		eletricista = this.repositorioEletricista.procurar(cpf);
		
		
		this.repositorioEletricista.remover(cpf);
		
	}

	public Eletricista procurar(String cpf) throws CPFInvalidoException, EletricistaNaoEncontradoException, SQLException, CampoObrigatorioException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		return this.repositorioEletricista.procurar(cpf);
	}

	

	public void atualizar(Eletricista eletricista) throws EletricistaNaoEncontradoException, SQLException, CPFInvalidoException, CampoObrigatorioException{
		if(!Validacao.validaCPF(eletricista.getCpf())) throw new CPFInvalidoException(eletricista.getCpf());
		if(eletricista.getNome().equals("") == true) throw new CampoObrigatorioException();
		
		this.repositorioEletricista.atualizar(eletricista);
	}

	public ArrayList<Eletricista> listar() throws SQLException{
		return this.repositorioEletricista.listar();
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
