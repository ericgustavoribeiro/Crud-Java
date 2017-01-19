package EJT.Encanador;

import java.sql.SQLException;
import java.util.ArrayList;



import EJT.Contato.Contato;

import EJT.Endereco.Endereco;

import EJT.Util.Validacao;
import  EJT.Encanador.CampoObrigatorioException;
public class ControladorEncanador {

	
		private IRepositorioEncanador repositorioEncanador;
		
		
		public ControladorEncanador() throws Exception {
			this.repositorioEncanador = new RepositorioEncanadorBDR();
			
		}
		
		public void cadastrar(Encanador encanador) throws CPFInvalidoException, CampoObrigatorioException, SQLException, EncanadorCadastradoException,  EncanadorNaoEncontradoException, CampoObrigatorioException{
			if(!Validacao.validaCPF(encanador.getCpf())) throw new CPFInvalidoException(encanador.getCpf());
			if(encanador.getNome().equals("") == true) throw new CampoObrigatorioException();
			if(encanador.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioException();
			if(encanador.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioException();
			if(encanador.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioException();
			if(encanador.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
			if(encanador.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioException();
			if(encanador.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
			if(encanador.getContato().getCelular().equals("") == true) throw new CampoObrigatorioException();
			if(encanador.getContato().getTelefone().equals("") == true) throw new CampoObrigatorioException();	
			if(this.repositorioEncanador.existe(encanador.getCpf())) throw new EncanadorCadastradoException();
			
			this.repositorioEncanador.Cadastrar(encanador);
			
		
		}
		
		public void remover(String cpf) throws CPFInvalidoException, EncanadorNaoEncontradoException, SQLException, CampoObrigatorioException{
			cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
			Encanador encanador = null;
			
			if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
			encanador = this.repositorioEncanador.procurar(cpf);
			
			
			this.repositorioEncanador.remover(cpf);
			
		}

		public Encanador procurar(String cpf) throws CPFInvalidoException, EncanadorNaoEncontradoException, SQLException, CampoObrigatorioException{
			cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
			
			if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
			return this.repositorioEncanador.procurar(cpf);
		}

		

		public void atualizar(Encanador encanador) throws EncanadorNaoEncontradoException, SQLException, CPFInvalidoException, CampoObrigatorioException, CampoObrigatorioException{
			if(!Validacao.validaCPF(encanador.getCpf())) throw new CPFInvalidoException(encanador.getCpf());
			if(encanador.getNome().equals("") == true) throw new CampoObrigatorioException();
			
			this.repositorioEncanador.atualizar(encanador);
		}

		public ArrayList<Encanador> listar() throws SQLException{
			return this.repositorioEncanador.listar();
		}

	

}
