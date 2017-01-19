package EJT.Gerente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import EJT.Jardineiro.Jardineiro;
import EJT.Jardineiro.RepositorioJardineiroSet;


public class RepositorioGerenteSet implements IRepositorioGerente{

	
private static RepositorioGerenteSet instance = null;	
private Set<Gerente> set;
	
	
	public RepositorioGerenteSet() {
	set = new HashSet<Gerente>();
	}
	
	public static RepositorioGerenteSet getInstance(){
		if(RepositorioGerenteSet.instance == null){
			RepositorioGerenteSet.instance = new RepositorioGerenteSet();
		}
		
		return RepositorioGerenteSet.instance;
	}

	@Override
	public void Cadastrar(Gerente gerente)
			throws GerenteJaCadastradoException, CampoObrigatorioException,
			SQLException {
		set.add(gerente);
	}

	@Override
	public void atualizar(Gerente gerente)
			throws CampoObrigatorioException, GerenteNaoEncontradoExceptio,
			SQLException {
		gerente.getCpf();
		for(Gerente gerenteAtualizar : set){
			if(gerente.getCpf().equals(gerenteAtualizar.getCpf())){
				set.remove(gerenteAtualizar);
				set.add(gerente);
				break;
			}
			
		}
		
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	GerenteNaoEncontradoExceptio, SQLException {
		for(Gerente gerente : set){
			if(gerente.getCpf().equals(cpf)){
				set.remove(gerente);
				break;
			}
		}
		
	}

	@Override
	public Gerente procurar(String cpf) throws CampoObrigatorioException,
	GerenteNaoEncontradoExceptio, SQLException {
       Gerente gerente = new Gerente();
		
		for(Gerente g : set){
			if(cpf.equals(g.getCpf())){
				return g;
			}
		}
		return gerente;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	GerenteNaoEncontradoExceptio, SQLException {
		for(Gerente e : set){
			if(cpf.equals(e.getCpf())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<Gerente> listar() throws SQLException {
	
		ArrayList<Gerente> listar = new ArrayList<Gerente>();
		
		
		
		for(Gerente e : set){
			listar.add(e);
		}
		return listar;
		//return set.toString();
	}

	@Override
	public ArrayList<Gerente> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
