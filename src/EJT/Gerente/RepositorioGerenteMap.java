package EJT.Gerente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import EJT.MestredeObras.RepositorioMestreDeObrasMap;


public class RepositorioGerenteMap implements IRepositorioGerente {
	private static RepositorioGerenteMap instance = null;
	private Map<Integer, Gerente> map;
	private static Integer id_gerente = 0;
	
	public RepositorioGerenteMap(){
		map = new HashMap<Integer, Gerente>();
	}
	
	public static RepositorioGerenteMap getInstance(){
		if(RepositorioGerenteMap.instance == null){
			RepositorioGerenteMap.instance = new RepositorioGerenteMap();
		}
		
		return RepositorioGerenteMap.instance;
	}
	
	public void Cadastrar(Gerente gerente) throws GerenteJaCadastradoException, CampoObrigatorioException, SQLException{
		map.put(id_gerente, gerente);
		id_gerente++;
	}
	
	public void atualizar(Gerente gerente) throws CampoObrigatorioException, GerenteNaoEncontradoExceptio, SQLException{
		
		for (int i : map.keySet()){
			Gerente x = map.get(i);
			if (gerente.getCpf().equals(x.getCpf())){
				
				break;
			}
		}
	}
	
	public void remover(String cpf) throws CampoObrigatorioException, GerenteNaoEncontradoExceptio, SQLException{
		
		for (int i : map.keySet()){
			Gerente x = map.get(i);
			if(cpf.equals(x.getCpf())){
				map.remove(i);
				break;
			}
		}
	}
	
	public Gerente procurar (String cpf) throws CampoObrigatorioException, GerenteNaoEncontradoExceptio, SQLException{
		
		Gerente gerente = new Gerente();
		for (int i : map.keySet()){
			Gerente x = map.get(i);
			if(cpf.equals(x.getCpf())){
				return x;
			}
		}
		return gerente;
	}
	
	public boolean existe(String cpf) throws CampoObrigatorioException, GerenteNaoEncontradoExceptio, SQLException{
		
		for(int i : map.keySet()){
			Gerente x = map.get(i);
			if(cpf.equals(x.getCpf())){
				return true;
			}
		} return false;
	}
	
	public ArrayList<Gerente> listar() throws SQLException {
		
		ArrayList<Gerente> listar = new ArrayList();
		
		for(int i : map.keySet()){
			Gerente e = map.get(i);
			listar.add(e);
		}
		
		return listar;
		//this.map.toString();
	}
	
	
public ArrayList<Gerente> listar(String complemento) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

	
	
}
