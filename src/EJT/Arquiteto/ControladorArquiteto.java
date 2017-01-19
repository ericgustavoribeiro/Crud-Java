package EJT.Arquiteto;

import java.sql.SQLException;
import java.util.ArrayList;


import EJT.Jardineiro.JardineiroNaoEncontradoException;
import EJT.Util.Validacao;

public class ControladorArquiteto {

	private IRepositorioArquiteto respositorioArquiteto;


	
	public ControladorArquiteto () throws Exception{
		this.respositorioArquiteto = new RespoitorioArquitetoBDR();
		}
	
	public void cadastrar(Arquiteto arquiteto)  throws EJT.Arquiteto.CPFInvalidoException, CampoObrigatorioException, SQLException, ArquitetoJaCadastradoException, EJT.Arquiteto.CampoObrigatorioException, ArquitetoNaoEncontradoException{
		if(!Validacao.validaCPF(arquiteto.getCpf())) throw new EJT.Arquiteto.CPFInvalidoException(arquiteto.getCpf());
		if(arquiteto.getNome().equals("") == true) throw new CampoObrigatorioException();
		if(arquiteto.getCau().equals("") == true) throw new CampoObrigatorioException();
		if(arquiteto.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioException();
		if(arquiteto.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioException();
		if(arquiteto.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
		if(arquiteto.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioException();
		if(arquiteto.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioException();
		if(arquiteto.getContato().getCelular().equals("") == true) throw new CampoObrigatorioException();
		if(arquiteto.getContato().getTelefone().equals("") == true) throw new CampoObrigatorioException();
		if(this.respositorioArquiteto.existe(arquiteto.getCpf())) throw new ArquitetoJaCadastradoException();
		
		this.respositorioArquiteto.Cadastrar(arquiteto);
		
	}
	
	public void remover(String cpf) throws CPFInvalidoException, ArquitetoJaCadastradoException, SQLException, ArquitetoNaoEncontradoException, EJT.Arquiteto.CampoObrigatorioException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		Arquiteto arquiteto = null;
		
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		arquiteto = this.respositorioArquiteto.procurar(cpf);
		
		this.respositorioArquiteto.remover(cpf);
		
	}
	
	public Arquiteto procurar(String cpf) throws CPFInvalidoException, ArquitetoJaCadastradoException, SQLException, ArquitetoNaoEncontradoException, EJT.Arquiteto.CampoObrigatorioException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		Arquiteto arquiteto = null;
		if (!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
	
		return this.respositorioArquiteto.procurar(cpf);
		
	}

	
	public void atualizar(Arquiteto arquiteto) throws ArquitetoJaCadastradoException, CPFInvalidoException, CampoObrigatorioException, SQLException, ArquitetoNaoEncontradoException, EJT.Arquiteto.CampoObrigatorioException{
		if (!Validacao.validaCPF(arquiteto.getCpf())) throw new CPFInvalidoException(null);
		if (arquiteto.getNome().equals("") == true) throw new CampoObrigatorioException();
			this.respositorioArquiteto.atualizar(arquiteto);
	}
	
	public ArrayList<Arquiteto> listar() throws SQLException{
		return this.respositorioArquiteto.listar();
	}
	
	
	
	
	
}
