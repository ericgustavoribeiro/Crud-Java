package EJT.Engenheiro;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Util.Validacao;

public class ControladorEngenheiro {

	private IRepositorioEngenheiro repositorioEngenheiro;
	
	public ControladorEngenheiro() throws Exception {
		this.repositorioEngenheiro = new RepositorioEngenheiroBDR();
	}
	
	public void cadastrar(Engenheiro engenheiro) throws CPFInvalidoException, CampoObrigatorioException, SQLException, EngenheiroJaCadastradoException, EngenheiroNaoEncontradoException{
		if(!Validacao.validaCPF(engenheiro.getCpf())) throw new CPFInvalidoException(engenheiro.getCpf());
		if(engenheiro.getNome().equals("") == true) throw new CampoObrigatorioException();
		if(engenheiro.getCrea().equals("") == true) throw new CampoObrigatorioException();
		if(engenheiro.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioException();
		if(engenheiro.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioException();
		if(engenheiro.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioException();
		if(engenheiro.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
		if(engenheiro.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioException();
		if(engenheiro.getEndereco().getCep().equals("") == true) throw new CampoObrigatorioException();
		if(engenheiro.getContato().getCelular().equals("") == true) throw new CampoObrigatorioException();
		if(engenheiro.getContato().getTelefone().equals("") == true) throw new CampoObrigatorioException();		
		if(this.repositorioEngenheiro.existe(engenheiro.getCpf())) throw new EngenheiroJaCadastradoException();
		
		this.repositorioEngenheiro.Cadastrar(engenheiro);
		
	}
	
	public void remover(String cpf) throws CPFInvalidoException, EngenheiroNaoEncontradoException, SQLException, CampoObrigatorioException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		Engenheiro engenherio = null;
		
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		engenherio = this.repositorioEngenheiro.procurar(cpf);
		
		this.repositorioEngenheiro.remover(cpf);
		
	}

	public Engenheiro procurar(String cpf) throws CPFInvalidoException, EngenheiroNaoEncontradoException, SQLException, CampoObrigatorioException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		return this.repositorioEngenheiro.procurar(cpf);
	}


	public void atualizar(Engenheiro engenheiro) throws EngenheiroNaoEncontradoException, SQLException, CPFInvalidoException, CampoObrigatorioException{
		if(!Validacao.validaCPF(engenheiro.getCpf())) throw new CPFInvalidoException(engenheiro.getCpf());
		if(engenheiro.getNome().equals("") == true) throw new CampoObrigatorioException();
		
		this.repositorioEngenheiro.atualizar(engenheiro);
	}

	public ArrayList<Engenheiro> listar() throws SQLException{
		return this.repositorioEngenheiro.listar();
	}





}
