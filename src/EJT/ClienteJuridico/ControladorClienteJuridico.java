package EJT.ClienteJuridico;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.ClienteFisico.ClienteNaoEncontradoException;
import EJT.Util.Validacao;

public class ControladorClienteJuridico {

	IRepositorioClienteJuridico repositorioClienteJuridico;

	public ControladorClienteJuridico() throws Exception {
	this.repositorioClienteJuridico = new RepositorioClienteJuridicoBDR();
	
	}
	
	public void cadastrar(ClienteJuridico clienteJuridico) throws CampoObrigatorioException, CNPJInvalidoException, ClienteJuridicoJaCadastradoException, SQLException, ClienteNaoEncontradoException, ClienteJuridicoNaoEncontradoException{
		if(!Validacao.validaCNPJ(clienteJuridico.getCnpj())) throw new CNPJInvalidoException(clienteJuridico.getCnpj());
		if(clienteJuridico.getNome().equals("") == true) throw new CampoObrigatorioException();
		if(clienteJuridico.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioException();
		if(clienteJuridico.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioException();
		if(clienteJuridico.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioException();
		if(clienteJuridico.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
		if(clienteJuridico.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioException();
		if(clienteJuridico.getEndereco().getCep().equals("") == true) throw new CampoObrigatorioException();
		if(clienteJuridico.getContato().getCelular().equals("") == true) throw new CampoObrigatorioException();
		if(clienteJuridico.getContato().getTelefone().equals("") == true) throw new CampoObrigatorioException();		
		if(this.repositorioClienteJuridico.existe(clienteJuridico.getCnpj())) throw new ClienteJuridicoJaCadastradoException();
		
		this.repositorioClienteJuridico.cadastrar(clienteJuridico);
	}

	
	public void remover(String cnpj) throws CNPJInvalidoException, CampoObrigatorioException, ClienteNaoEncontradoException, SQLException, ClienteJuridicoNaoEncontradoException{
		cnpj = cnpj.replaceAll("\\.|\\-|\\ ", "");
		ClienteJuridico cliente = null;
		
		if(!Validacao.validaCNPJ(cnpj)) throw new CNPJInvalidoException(cnpj);
		cliente = this.repositorioClienteJuridico.procuarar(cnpj);
		
		this.repositorioClienteJuridico.remover(cnpj);
	}
	
	public ClienteJuridico procurar(String cnpj) throws CNPJInvalidoException, CampoObrigatorioException, ClienteNaoEncontradoException, SQLException, ClienteJuridicoNaoEncontradoException{
		cnpj = cnpj.replaceAll("\\.|\\-|\\ ", "");
		
		if(!Validacao.validaCNPJ(cnpj)) throw new CNPJInvalidoException(cnpj);
		return this.repositorioClienteJuridico.procuarar(cnpj);
		
	}

	public void atualizar(ClienteJuridico clienteJuridico) throws CNPJInvalidoException, CampoObrigatorioException, ClienteNaoEncontradoException, SQLException, ClienteJuridicoNaoEncontradoException{
		if(!Validacao.validaCNPJ(clienteJuridico.getCnpj())) throw new CNPJInvalidoException(clienteJuridico.getCnpj());
		if(clienteJuridico.getNome().equals("") == true) throw new CampoObrigatorioException();
		
		this.repositorioClienteJuridico.atualizar(clienteJuridico);
	}

	public ArrayList<ClienteJuridico> listar() throws SQLException{
		return this.repositorioClienteJuridico.listar();
	}
}
