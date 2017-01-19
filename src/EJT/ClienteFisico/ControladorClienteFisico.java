package EJT.ClienteFisico;

import java.sql.SQLException;

import java.util.ArrayList;

import EJT.Util.Validacao;

public class ControladorClienteFisico {

	IRepositorioClienteFisico repositorioClienteFisico;

	public ControladorClienteFisico() throws Exception {
	this.repositorioClienteFisico = new RepositorioClienteFisicoBDR();
	}
	
	public void cadastrar(ClienteFisico clienteFisico) throws CPFInvalidoException, CampoObrigatorioException, ClienteNaoEncontradoException, SQLException, ClienteJaCadastradoException{
		if(!Validacao.validaCPF(clienteFisico.getCpf())) throw new CPFInvalidoException(clienteFisico.getCpf());
		if(clienteFisico.getNome().equals("") == true) throw new CampoObrigatorioException();
		if(clienteFisico.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioException();
		if(clienteFisico.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioException();
		if(clienteFisico.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioException();
		if(clienteFisico.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
		if(clienteFisico.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioException();
		if(clienteFisico.getEndereco().getCep().equals("") == true) throw new CampoObrigatorioException();
		if(clienteFisico.getContato().getCelular().equals("") == true) throw new CampoObrigatorioException();
		if(clienteFisico.getContato().getTelefone().equals("") == true) throw new CampoObrigatorioException();
		if(this.repositorioClienteFisico.existe(clienteFisico.getCpf())) throw new ClienteJaCadastradoException();
		
		this.repositorioClienteFisico.cadastrar(clienteFisico);
	}
	
	public void remover(String cpf) throws CPFInvalidoException, ClienteNaoEncontradoException, CampoObrigatorioException, SQLException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		ClienteFisico cliente = null;
		
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		cliente = this.repositorioClienteFisico.procurar(cpf);
		
		this.repositorioClienteFisico.remover(cpf);
	}
	
	public ClienteFisico procurar(String cpf) throws CPFInvalidoException, ClienteNaoEncontradoException, CampoObrigatorioException, SQLException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		return this.repositorioClienteFisico.procurar(cpf);
	}
	
	public void atualizar(ClienteFisico clienteFisico) throws CPFInvalidoException, CampoObrigatorioException, ClienteNaoEncontradoException, Throwable{
		if(!Validacao.validaCPF(clienteFisico.getCpf())) throw new CPFInvalidoException(clienteFisico.getCpf());
		if(clienteFisico.getNome().equals("") == true) throw new CampoObrigatorioException();
		
		this.repositorioClienteFisico.atualizar(clienteFisico);
	}
	
	public ArrayList<ClienteFisico> listar() throws SQLException{
		return this.repositorioClienteFisico.listar();
	}
}
