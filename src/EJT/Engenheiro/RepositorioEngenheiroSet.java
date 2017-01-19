package EJT.Engenheiro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import EJT.Jardineiro.Jardineiro;
import EJT.Jardineiro.RepositorioJardineiroSet;


public class RepositorioEngenheiroSet implements IRepositorioEngenheiro{

	

	
private Set<Engenheiro> set;
private static RepositorioEngenheiroSet instance = null;	
	
	public RepositorioEngenheiroSet() {
	set = new HashSet<Engenheiro>();
	}

	public static RepositorioEngenheiroSet getInstance(){
		if(RepositorioEngenheiroSet.instance == null){
			RepositorioEngenheiroSet.instance = new RepositorioEngenheiroSet();
		}
		
		return RepositorioEngenheiroSet.instance;
	}

	@Override
	public void Cadastrar(Engenheiro engenheiro)
			throws EngenheiroJaCadastradoException, CampoObrigatorioException,
			SQLException {
		set.add(engenheiro);
	}

	@Override
	public void atualizar(Engenheiro engenheiro)
			throws CampoObrigatorioException, EngenheiroNaoEncontradoException,
			SQLException {
		engenheiro.getCpf();
		for(Engenheiro engenheiroAtualizar : set){
			if(engenheiro.getCpf().equals(engenheiroAtualizar.getCpf())){
				set.remove(engenheiroAtualizar);
				set.add(engenheiro);
				break;
			}
			
		}
		
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	EngenheiroNaoEncontradoException, SQLException {
		for(Engenheiro engenheiro : set){
			if(engenheiro.getCpf().equals(cpf)){
				set.remove(engenheiro);
				break;
			}
		}
		
	}

	@Override
	public Engenheiro procurar(String cpf) throws CampoObrigatorioException,
	EngenheiroNaoEncontradoException, SQLException {
	Engenheiro engenheiro = new Engenheiro();
		
		for(Engenheiro e : set){
			if(cpf.equals(e.getCpf())){
				return e;
			}
		}
		return engenheiro;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	EngenheiroNaoEncontradoException, SQLException {
		for(Engenheiro e : set){
			if(cpf.equals(e.getCpf())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<Engenheiro> listar() throws SQLException {
	
		ArrayList<Engenheiro> listar = new ArrayList<Engenheiro>();
		
		
		
		for(Engenheiro e : set){
			listar.add(e);
		}
		return listar;
		//return set.toString();
	}

	@Override
	public ArrayList<Engenheiro> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
	
	
}
