package EJT.Eletricista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import EJT.MestredeObras.RepositorioMestreDeObrasMap;


public class RepositorioEletricistaMap implements IRepositorioEletricista{

	
	private static RepositorioEletricistaMap instance = null;
	private Map<Integer, Eletricista> map;
	private static Integer id_eletricista = 0;
	
	public RepositorioEletricistaMap(){
		map = new HashMap<Integer, Eletricista>();
	}
	
	public static RepositorioEletricistaMap getInstance(){
		if(RepositorioEletricistaMap.instance == null){
			RepositorioEletricistaMap.instance = new RepositorioEletricistaMap();
		}
		
		return RepositorioEletricistaMap.instance;
	}
	
	public void Cadastrar(Eletricista eletricista) throws EletricistaJaCadastradoEXception, CampoObrigatorioException, SQLException{
		map.put(id_eletricista, eletricista);
		id_eletricista++;
	}
	
	public void atualizar(Eletricista eletricista) throws CampoObrigatorioException, EletricistaNaoEncontradoException, SQLException{
		
		for (int i : map.keySet()){
			Eletricista x = map.get(i);
			if (eletricista.getCpf().equals(x.getCpf())){
				
				break;
			}
		}
	}
	
	public void remover(String cpf) throws CampoObrigatorioException, EletricistaNaoEncontradoException, SQLException{
		
		for (int i : map.keySet()){
			Eletricista x = map.get(i);
			if(cpf.equals(x.getCpf())){
				map.remove(i);
				break;
			}
		}
	}
	
	public Eletricista procurar (String cpf) throws CampoObrigatorioException, EletricistaNaoEncontradoException, SQLException{
		
		Eletricista eletricista = new Eletricista();
		for (int i : map.keySet()){
			Eletricista x = map.get(i);
			if(cpf.equals(x.getCpf())){
				return x;
			}
		}
		return eletricista;
	}
	
	public boolean existe(String cpf) throws CampoObrigatorioException, EletricistaNaoEncontradoException, SQLException{
		
		for(int i : map.keySet()){
			Eletricista x = map.get(i);
			if(cpf.equals(x.getCpf())){
				return true;
			}
		} return false;
	}
	
	public ArrayList<Eletricista> listar() throws SQLException {
		
		ArrayList<Eletricista> listar = new ArrayList();
		
		for(int i : map.keySet()){
			Eletricista e = map.get(i);
			listar.add(e);
		}
		
		return listar;
		//this.map.toString();
	}
	
	
public ArrayList<Eletricista> listar(String complemento) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

	
	
	
	
	
	
	
}
