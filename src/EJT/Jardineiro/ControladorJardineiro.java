package EJT.Jardineiro;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Util.Validacao;

public class ControladorJardineiro {

	private IRepositorioJardineiro repositorioJardineiro;
	
	public ControladorJardineiro() throws Exception{
		this.repositorioJardineiro = new RepositorioJardineiroBDR();
	}
	
	public void cadastrar(Jardineiro jardineiro) throws CPFInvalidoException, CampoObrigatorioException, JardineiroNaoEncontradoException, SQLException, JardineiroJaCadastradoException{
		if(!Validacao.validaCPF(jardineiro.getCpf())) throw new CPFInvalidoException(jardineiro.getCpf());
		if(jardineiro.getNome().equals("")==true) throw new CampoObrigatorioException();
		if(jardineiro.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioException();
		if(jardineiro.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioException();
		if(jardineiro.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioException();
		if(jardineiro.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
		if(jardineiro.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioException();
		if(jardineiro.getEndereco().getCep().equals("") == true) throw new CampoObrigatorioException();
		if(jardineiro.getContato().getCelular().equals("")==true) throw new CampoObrigatorioException();
		if(jardineiro.getContato().getTelefone().equals("")==true) throw new CampoObrigatorioException();
		if(this.repositorioJardineiro.existe(jardineiro.getCpf())) throw new JardineiroJaCadastradoException();
	
		
		this.repositorioJardineiro.cadastrar(jardineiro);
	 
	}
	
	public void remover(String cpf) throws CampoObrigatorioException, JardineiroNaoEncontradoException, SQLException, CPFInvalidoException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		Jardineiro jardineiro = null;
		
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		jardineiro = this.repositorioJardineiro.procurar(cpf);
		
		this.repositorioJardineiro.remover(cpf);
		
	}
	
	public Jardineiro procurar(String cpf) throws CPFInvalidoException, CampoObrigatorioException, JardineiroNaoEncontradoException, SQLException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		
	
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		return this.repositorioJardineiro.procurar(cpf);
		
	}
	
	public void atualizar(Jardineiro jardineiro) throws CPFInvalidoException, CampoObrigatorioException, JardineiroNaoEncontradoException, SQLException{
		if(!Validacao.validaCPF(jardineiro.getCpf())) throw new CPFInvalidoException(jardineiro.getCpf());
		if(jardineiro.getNome().equals("")) throw new CampoObrigatorioException();
		
		this.repositorioJardineiro.atualizar(jardineiro);
	}
	
	public ArrayList<Jardineiro> listar() throws SQLException{
		
		return this.repositorioJardineiro.listar();
	}
}
