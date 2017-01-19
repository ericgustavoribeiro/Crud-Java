package EJT.Empresa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import EJT.ClienteJuridico.ClienteJuridico;



public class RepositorioEmpresaSet implements IRepositorioEmpresa <Empresa, String>{
	private static RepositorioEmpresaSet instance = null;
	private Set<Empresa> set;

	
	public RepositorioEmpresaSet() {
	set = new HashSet<Empresa>();
	}
	
	public static RepositorioEmpresaSet getInstance(){
		if(RepositorioEmpresaSet.instance == null){
			RepositorioEmpresaSet.instance = new RepositorioEmpresaSet();
		}
		
		return RepositorioEmpresaSet.instance;
	}
	@Override
	public void Cadastrar(Empresa empresa) throws SQLException {
		// TODO Auto-generated method stub
		
		
		set.add(empresa);
		
		
	}

	@Override
	public Empresa procurar(String cnpj) throws SQLException,
			EmpresaNaoEncontradaException {
		// TODO Auto-generated method stub
		 Empresa empresa = new Empresa();
			
			for(Empresa e : set){
				if(cnpj.equals(e.getCnpj())){
					return e;
				}
			}
			return empresa;
	}

	@Override
	public void atualizar(Empresa empresa) throws SQLException,
			EmpresaNaoEncontradaException {
		// TODO Auto-generated method stub
		   empresa.getCnpj();
			for(Empresa empresaAtualizar : set){
				if(empresa.getCnpj().equals(empresaAtualizar.getCnpj())){
					set.remove(empresaAtualizar);
					set.add(empresa);
					break;
				}
			}
	}

	@Override
	public void remover(String cnpj) throws SQLException,
			EmpresaNaoEncontradaException {
		// TODO Auto-generated method stub
		for(Empresa empresa : set){
			if(empresa.getCnpj().equals(cnpj)){
				set.remove(empresa);
				break;
			}
		}
		
	}

	@Override
	public boolean existe(String cnpj) throws SQLException,
			EmpresaNaoEncontradaException {
		// TODO Auto-generated method stub
		for(Empresa e : set){
			if(cnpj.equals(e.getCnpj())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<Empresa> listar() throws SQLException {
		// TODO Auto-generated method stub
	ArrayList<Empresa> listar = new ArrayList<Empresa>();
		
		
		for(Empresa e : this.set){
			
			listar.add(e);
		}
		
		
		return listar;
	}

	@Override
	public ArrayList<Empresa> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existe() throws SQLException {
		return false;
		
	}
	
}
