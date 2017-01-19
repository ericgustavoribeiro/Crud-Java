package EJT.Engenheiro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import EJT.MestredeObras.RepositorioMestreDeObrasMap;


public class RepositorioEngenheiroMap implements IRepositorioEngenheiro{

	
	private static RepositorioEngenheiroMap instance = null;
	private Map<Integer, Engenheiro> map;
	private static Integer id_engenheiro = 0;
	
	public RepositorioEngenheiroMap(){
		map = new HashMap<Integer, Engenheiro>();
	}
	
	public static RepositorioEngenheiroMap getInstance(){
		if(RepositorioEngenheiroMap.instance == null){
			RepositorioEngenheiroMap.instance = new RepositorioEngenheiroMap();
		}
		
		return RepositorioEngenheiroMap.instance;
	}
	
	public void Cadastrar(Engenheiro engenheiro) throws EngenheiroJaCadastradoException, CampoObrigatorioException, SQLException{
		map.put(id_engenheiro, engenheiro);
		id_engenheiro++;
	}
	
	public void atualizar(Engenheiro engenheiro) throws CampoObrigatorioException, EngenheiroNaoEncontradoException, SQLException{
		
		for (int i : map.keySet()){
			Engenheiro x = map.get(i);
			if (engenheiro.getCpf().equals(x.getCpf())){
				
				break;
			}
		}
	}
	
	public void remover(String cpf) throws CampoObrigatorioException, EngenheiroNaoEncontradoException, SQLException{
		
		for (int i : map.keySet()){
			Engenheiro x = map.get(i);
			if(cpf.equals(x.getCpf())){
				map.remove(i);
				break;
			}
		}
	}
	
	public Engenheiro procurar (String cpf) throws CampoObrigatorioException, EngenheiroNaoEncontradoException, SQLException{
		
		Engenheiro engenheiro = new Engenheiro();
		for (int i : map.keySet()){
			Engenheiro x = map.get(i);
			if(cpf.equals(x.getCpf())){
				return x;
			}
		}
		return engenheiro;
	}
	
	public boolean existe(String cpf) throws CampoObrigatorioException, EngenheiroNaoEncontradoException, SQLException{
		
		for(int i : map.keySet()){
			Engenheiro x = map.get(i);
			if(cpf.equals(x.getCpf())){
				return true;
			}
		} return false;
	}
	
	public ArrayList<Engenheiro> listar() throws SQLException {
		
		ArrayList<Engenheiro> listar = new ArrayList();
		
		for(int i : map.keySet()){
			Engenheiro e = map.get(i);
			listar.add(e);
		}
		
		return listar;
		//this.map.toString();
	}
	
	
public ArrayList<Engenheiro> listar(String complemento) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

	
	
	
	
	
	
	
}
