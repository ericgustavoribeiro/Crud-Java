package EJT.Empresa;
//ok
import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Util.Validacao;

public class ControladorEmpresa {

	private IRepositorioEmpresa repositorioEmpresa;
	
	public ControladorEmpresa () throws Exception{
		this.repositorioEmpresa = new RepositorioEmpresaBDR();
	}
	
	public boolean existe() throws SQLException, EmpresaJ·CadastradaException {
		
//		if(this.repositorioEmpresa.existe() == true){ 
//			throw new EmpresaJ·CadastradaException();
//		}
//		return false;
//		
	return this.repositorioEmpresa.existe();
	}
	
	public void cadastrar(Empresa empresa) throws SQLException, EmpresaNaoEncontradaException, CNPJInvalidoException, CampoObricatorioException, EmpresaJ·CadastradaException{
		if(!Validacao.validaCNPJ(empresa.getCnpj())) throw new CNPJInvalidoException(empresa.getCnpj());
		if(empresa.getNome_fantasia().equals("") == true) throw new CampoObricatorioException();
		if(empresa.getEndereco().getLogradouro().equals("") == true) throw new CampoObricatorioException();
		if(empresa.getEndereco().getNumero().equals("") == true) throw new CampoObricatorioException();
		if(empresa.getEndereco().getBairro().equals("") == true) throw new CampoObricatorioException();
		if(empresa.getEndereco().getCidade().equals("") == true) throw new CampoObricatorioException();
		if(empresa.getEndereco().getEstado().equals("") == true) throw new CampoObricatorioException();
		if(empresa.getEndereco().getCep().equals("") == true) throw new CampoObricatorioException();
		if(empresa.getContato().getCelular().equals("") == true) throw new CampoObricatorioException();
		if(empresa.getContato().getTelefone().equals("") == true) throw new CampoObricatorioException();
		if(this.repositorioEmpresa.existe(empresa.getCnpj())) throw new EmpresaJ·CadastradaException();
		
		this.repositorioEmpresa.Cadastrar(empresa);
		
	}
	
	
	public void remover(String cnpj) throws SQLException, EmpresaNaoEncontradaException, CampoObricatorioException, CNPJInvalidoException {
		cnpj = cnpj.replaceAll("\\.|\\-|\\ ", "");
		Empresa empresa = null;
		
		if (!Validacao.validaCNPJ(cnpj)) throw new CNPJInvalidoException(cnpj);
		empresa = this.repositorioEmpresa.procurar(cnpj);
		this.repositorioEmpresa.remover(cnpj);
	}
	
	public Empresa procurar (String cnpj) throws SQLException, EmpresaNaoEncontradaException, CampoObricatorioException, CNPJInvalidoException{
		cnpj = cnpj.replaceAll("\\.|\\-|\\ ", "");
		
		if(!Validacao.validaCNPJ(cnpj)) throw new CNPJInvalidoException(cnpj);
		
		return this.repositorioEmpresa.procurar(cnpj);
	}
	
	
	public void atualizar (Empresa empresa) throws SQLException, EmpresaNaoEncontradaException, CampoObricatorioException, CNPJInvalidoException{
		if(!Validacao.validaCNPJ(empresa.getCnpj())) throw new CNPJInvalidoException(empresa.getCnpj());;
		if(empresa.getNome_fantasia().equals("") == true) throw new CampoObricatorioException();;
		
		this.repositorioEmpresa.atualizar(empresa);
	}
	
	public ArrayList<Empresa> listar() throws SQLException {
		return this.repositorioEmpresa.listar();
	}
}
