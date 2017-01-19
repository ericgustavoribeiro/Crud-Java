package EJT.MestredeObras;

import java.sql.SQLException;
import java.util.ArrayList;



import EJT.Contato.Contato;

import EJT.Endereco.Endereco;

import EJT.Util.Validacao;

public class ControladorMestreDeObras {

	
		private IRepositorioMestreDeObras repositorioMestreDeObras;
		
		
		public ControladorMestreDeObras() throws Exception {
			this.repositorioMestreDeObras = new RepositorioMestreDeObrasBDR();
			
		}
		
		public void cadastrar(MestreDeObras mestre_de_obras) throws CPFInvalidoException, CampoObrigatorioException, SQLException, MestreDeObrasJaCadastradoException, MestreDeObrasNaoEncontradoException{
			if(!Validacao.validaCPF(mestre_de_obras.getCpf())) throw new CPFInvalidoException(mestre_de_obras.getCpf());
			if(mestre_de_obras.getNome().equals("") == true) throw new CampoObrigatorioException();
			if(mestre_de_obras.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioException();
			if(mestre_de_obras.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioException();
			if(mestre_de_obras.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioException();
			if(mestre_de_obras.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
			if(mestre_de_obras.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioException();
			if(mestre_de_obras.getEndereco().getCep().equals("") == true) throw new CampoObrigatorioException();
			if(mestre_de_obras.getContato().getCelular().equals("") == true) throw new CampoObrigatorioException();
			if(mestre_de_obras.getContato().getTelefone().equals("") == true) throw new CampoObrigatorioException();
			if(this.repositorioMestreDeObras.existe(mestre_de_obras.getCpf())) throw new MestreDeObrasJaCadastradoException();
			
			this.repositorioMestreDeObras.Cadastrar(mestre_de_obras);
			
		
		}
		
		public void remover(String cpf) throws CPFInvalidoException, MestreDeObrasNaoEncontradoException, SQLException, CampoObrigatorioException{
			cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
			MestreDeObras mestre_de_obras = null;
			
			if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
			mestre_de_obras = this.repositorioMestreDeObras.procurar(cpf);
			
			
			this.repositorioMestreDeObras.remover(cpf);
			
		}

		public MestreDeObras procurar(String cpf) throws CPFInvalidoException, MestreDeObrasNaoEncontradoException, SQLException, CampoObrigatorioException{
			cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
			
			if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
			return this.repositorioMestreDeObras.procurar(cpf);
		}

		

		public void atualizar(MestreDeObras mestre_de_obras) throws MestreDeObrasNaoEncontradoException, SQLException, CPFInvalidoException, CampoObrigatorioException{
			if(!Validacao.validaCPF(mestre_de_obras.getCpf())) throw new CPFInvalidoException(mestre_de_obras.getCpf());
			if(mestre_de_obras.getNome().equals("") == true) throw new CampoObrigatorioException();
			
			this.repositorioMestreDeObras.atualizar(mestre_de_obras);
		}

		public ArrayList<MestreDeObras> listar() throws SQLException{
			return this.repositorioMestreDeObras.listar();
		}

	
//ok
}
