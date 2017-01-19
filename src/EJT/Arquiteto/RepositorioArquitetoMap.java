package EJT.Arquiteto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import EJT.MestredeObras.RepositorioMestreDeObrasMap;


public class RepositorioArquitetoMap implements IRepositorioArquiteto{

	private static RepositorioArquitetoMap instance = null;
	private Map<Integer, Arquiteto> map;
	private static Integer id_arquiteto = 0;
	
	public RepositorioArquitetoMap(){ 
		map = new HashMap<Integer, Arquiteto>();
	}
	
	public static RepositorioArquitetoMap getInstance(){
		if(RepositorioArquitetoMap.instance == null){
			RepositorioArquitetoMap.instance = new RepositorioArquitetoMap();
		}
		
		return RepositorioArquitetoMap.instance;
	}
	 @Override
	public void Cadastrar(Arquiteto arquiteto) throws ArquitetoJaCadastradoException, CampoObrigatorioException, SQLException{
		map.put(id_arquiteto, arquiteto);
		id_arquiteto++;
	}
	 @Override
	public void atualizar(Arquiteto arquiteto) throws CampoObrigatorioException, ArquitetoNaoEncontradoException, SQLException{
		
		for (int i : map.keySet()){
			Arquiteto x = map.get(i);
			if (arquiteto.getCpf().equals(x.getCpf())){
				
				break;
			}
		}
	}
	 @Override
	public void remover(String cpf) throws CampoObrigatorioException, ArquitetoNaoEncontradoException, SQLException{
		
		for (int i : map.keySet()){
			Arquiteto x = map.get(i);
			if(cpf.equals(x.getCpf())){
				map.remove(i);
				break;
			}
		}
	}
	 @Override
	public Arquiteto procurar (String cpf) throws CampoObrigatorioException, ArquitetoNaoEncontradoException, SQLException{
		
		Arquiteto arquiteto = new Arquiteto();
		
		for (int i : map.keySet()){
			Arquiteto x = map.get(i);
			if(cpf.equals(x.getCpf())){
				return x;
			}
		}
		return arquiteto;
	}
	 @Override
	public boolean existe(String cpf) throws CampoObrigatorioException, ArquitetoNaoEncontradoException, SQLException{
		
		for(int i : map.keySet()){
			Arquiteto x = map.get(i);
			if(cpf.equals(x.getCpf())){
				return true;
			}
		} return false;
	}
	 @Override
	public ArrayList<Arquiteto> listar() throws SQLException {
		
		ArrayList<Arquiteto> listar = new ArrayList();
		
		for(int i : map.keySet()){
			Arquiteto e = map.get(i);
			listar.add(e);
		}
		
		return listar;
		//this.map.toString();
	}
	
	 @Override
public ArrayList<Arquiteto> listar(String complemento) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

	
	
	
	
	
	
}
