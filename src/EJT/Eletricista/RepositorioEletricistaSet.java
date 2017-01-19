package EJT.Eletricista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import EJT.Jardineiro.Jardineiro;
import EJT.Jardineiro.RepositorioJardineiroSet;


public class RepositorioEletricistaSet implements IRepositorioEletricista {

	

private static RepositorioEletricistaSet instance = null;	
private Set<Eletricista > set;
	
	
	public RepositorioEletricistaSet() {
	set = new HashSet<Eletricista >();
	}
	
	public static RepositorioEletricistaSet getInstance(){
		if(RepositorioEletricistaSet.instance == null){
			RepositorioEletricistaSet.instance = new RepositorioEletricistaSet();
		}
		
		return RepositorioEletricistaSet.instance;
	}


	@Override
	public void Cadastrar(Eletricista  eletricista)
			throws EletricistaJaCadastradoEXception, CampoObrigatorioException,
			SQLException {
		set.add(eletricista);
	}

	@Override
	public void atualizar(Eletricista eletricista)
			throws CampoObrigatorioException, EletricistaNaoEncontradoException,
			SQLException {
		eletricista.getCpf();
		for(Eletricista eletricistaAtualizar : set){
			if(eletricista.getCpf().equals(eletricistaAtualizar.getCpf())){
				set.remove(eletricistaAtualizar);
				set.add(eletricista);
				break;
			}
			
		}
		
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	EletricistaNaoEncontradoException, SQLException {
		for(Eletricista eletricista: set){
			if(eletricista.getCpf().equals(cpf)){
				set.remove(eletricista);
				break;
			}
		}
		
	}

	@Override
	public Eletricista procurar(String cpf) throws CampoObrigatorioException,
	EletricistaNaoEncontradoException, SQLException {
       Eletricista eletricista = new  Eletricista();
		
		for(Eletricista e : set){
			if(cpf.equals(e.getCpf())){
				return e;
			}
		}
		return eletricista;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	EletricistaNaoEncontradoException, SQLException {
		for(Eletricista e : set){
			if(cpf.equals(e.getCpf())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<Eletricista> listar() throws SQLException {
	
		ArrayList<Eletricista> listar = new ArrayList<Eletricista>();
		
		
		
		for(Eletricista e : set){
			listar.add(e);
		}
		return listar;
		//return set.toString();
	}

	@Override
	public ArrayList<Eletricista> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
	
	
}
