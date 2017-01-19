package EJT.Atendente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import EJT.MestredeObras.RepositorioMestreDeObrasMap;



public class RepositorioAtendenteMap implements IRepositorioAtendente{

	
	
	private static RepositorioAtendenteMap instance = null;
	private Map<Integer, Atendente> map;
	private static Integer id_atendente = 0;
	
	public RepositorioAtendenteMap(){
		map = new HashMap<Integer, Atendente>();
	}
	
	public static RepositorioAtendenteMap getInstance(){
		if(RepositorioAtendenteMap.instance == null){
			RepositorioAtendenteMap.instance = new RepositorioAtendenteMap();
		}
		
		return RepositorioAtendenteMap.instance;
	}
	
	public void Cadastrar(Atendente atendente) throws AtendenteJaCadastradoException, CampoObrigatorioException, SQLException{
		map.put(id_atendente, atendente);
		id_atendente++;
	}
	
	public void atualizar(Atendente atendente) throws CampoObrigatorioException,  AtendenteNaoEncontradoException, SQLException{
		
		for (int i : map.keySet()){
			Atendente x = map.get(i);
			if (atendente.getCpf().equals(x.getCpf())){
				
				break;
			}
		}
	}
	
	public void remover(String cpf) throws CampoObrigatorioException, AtendenteNaoEncontradoException, SQLException{
		
		for (int i : map.keySet()){
			Atendente x = map.get(i);
			if(cpf.equals(x.getCpf())){
				map.remove(i);
				break;
			}
		}
	}
	
	public Atendente procurar (String cpf) throws CampoObrigatorioException, AtendenteNaoEncontradoException, SQLException{
		
		Atendente atendente = new Atendente();
		for (int i : map.keySet()){
			Atendente x = map.get(i);
			if(cpf.equals(x.getCpf())){
				return x;
			}
		}
		return atendente;
	}
	
	public boolean existe(String cpf) throws CampoObrigatorioException, AtendenteNaoEncontradoException, SQLException{
		
		for(int i : map.keySet()){
			Atendente x = map.get(i);
			if(cpf.equals(x.getCpf())){
				return true;
			}
		} return false;
	}
	
	public ArrayList<Atendente> listar() throws SQLException {
		
		ArrayList<Atendente> listar = new ArrayList();
		
		for(int i : map.keySet()){
			Atendente e = map.get(i);
			listar.add(e);
		}
		
		return listar;
		//this.map.toString();
	}
	
	
public ArrayList<Atendente> listar(String complemento) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

	
	
	
}
