package EJT.Atendente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import EJT.Jardineiro.Jardineiro;
import EJT.Jardineiro.RepositorioJardineiroSet;


public class RepositorioAtendenteSet implements IRepositorioAtendente{

	
	
	private static RepositorioAtendenteSet instance = null;	
private Set<Atendente> set;
	
	
	public RepositorioAtendenteSet() {
	set = new HashSet<Atendente>();
	}

	public static RepositorioAtendenteSet getInstance(){
		if(RepositorioAtendenteSet.instance == null){
			RepositorioAtendenteSet.instance = new RepositorioAtendenteSet();
		}
		
		return RepositorioAtendenteSet.instance;
	}
	
	@Override
	public void Cadastrar(Atendente atendente)
			throws AtendenteJaCadastradoException, CampoObrigatorioException,
			SQLException {
		set.add(atendente);
	}

	@Override
	public void atualizar(Atendente atendente)
			throws CampoObrigatorioException, AtendenteNaoEncontradoException,
			SQLException {
		atendente.getCpf();
		for(Atendente atendenteAtualizar : set){
			if(atendente.getCpf().equals(atendenteAtualizar.getCpf())){
				set.remove(atendenteAtualizar);
				set.add(atendente);
				break;
			}
			
		}
		
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	AtendenteNaoEncontradoException, SQLException {
		for(Atendente atendente : set){
			if(atendente.getCpf().equals(cpf)){
				set.remove(atendente);
				break;
			}
		}
		
	}

	@Override
	public Atendente procurar(String cpf) throws CampoObrigatorioException,
	AtendenteNaoEncontradoException, SQLException {
      Atendente atendente = new Atendente();
		
		for(Atendente a : set){
			if(cpf.equals(a.getCpf())){
				return a;
			}
		}
		return atendente;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	AtendenteNaoEncontradoException, SQLException {
		for(Atendente e : set){
			if(cpf.equals(e.getCpf())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<Atendente> listar() throws SQLException {
	
		ArrayList<Atendente> listar = new ArrayList<Atendente>();
		
		
		
		for(Atendente e : set){
			listar.add(e);
		}
		return listar;
		//return set.toString();
	}

	@Override
	public ArrayList<Atendente> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
	
	
	
	
	
}
