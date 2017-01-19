package EJT.Arquiteto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import EJT.Jardineiro.Jardineiro;
import EJT.Jardineiro.RepositorioJardineiroSet;

public class RepositorioArquitetoSet implements IRepositorioArquiteto {

private static RepositorioArquitetoSet instance = null;	
private Set<Arquiteto> set;
	
	
	public RepositorioArquitetoSet() {
	set = new HashSet<Arquiteto>();
	}
	
	public static RepositorioArquitetoSet getInstance(){
		if(RepositorioArquitetoSet.instance == null){
			RepositorioArquitetoSet.instance = new RepositorioArquitetoSet();
		}
		
		return RepositorioArquitetoSet.instance;
	}

	@Override
	public void Cadastrar(Arquiteto arquiteto)
			throws ArquitetoJaCadastradoException, CampoObrigatorioException,
			SQLException {
		set.add(arquiteto);
	}

	@Override
	public void atualizar(Arquiteto arquiteto)
			throws CampoObrigatorioException, ArquitetoNaoEncontradoException,
			SQLException {
		arquiteto.getCpf();
		for(Arquiteto arquitetoAtualizar : set){
			if(arquiteto.getCpf().equals(arquitetoAtualizar.getCpf())){
				set.remove(arquitetoAtualizar);
				set.add(arquiteto);
				break;
			}
			
		}
		
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	ArquitetoNaoEncontradoException, SQLException {
		for(Arquiteto arquiteto : set){
			if(arquiteto.getCpf().equals(cpf)){
				set.remove(arquiteto);
				break;
			}
		}
		
	}

	@Override
	public Arquiteto procurar(String cpf) throws CampoObrigatorioException,
	ArquitetoNaoEncontradoException, SQLException {
	   Arquiteto arquiteto = new Arquiteto();
		
		for(Arquiteto a : set){
			if(cpf.equals(a.getCpf())){
				return a;
			}
		}
		return arquiteto;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	ArquitetoNaoEncontradoException, SQLException {
		for(Arquiteto e : set){
			if(cpf.equals(e.getCpf())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<Arquiteto> listar() throws SQLException {
	
		ArrayList<Arquiteto> listar = new ArrayList<Arquiteto>();
		
		
		
		for(Arquiteto e : set){
			listar.add(e);
		}
		return listar;
		//return set.toString();
	}

	@Override
	public ArrayList<Arquiteto> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
	
	
	
}
