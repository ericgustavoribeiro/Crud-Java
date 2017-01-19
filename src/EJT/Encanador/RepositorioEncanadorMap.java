package EJT.Encanador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import EJT.Encanador.CampoObrigatorioException;
import EJT.Encanador.IRepositorioEncanador;
import EJT.Jardineiro.Jardineiro;
import EJT.MestredeObras.RepositorioMestreDeObrasMap;
import EJT.Encanador.EncanadorCadastradoException;
import EJT.Encanador.EncanadorNaoEncontradoException;


public class RepositorioEncanadorMap implements IRepositorioEncanador {
	private static RepositorioEncanadorMap instance = null;
	private Map<Integer, Encanador> map;
	private static Integer id_encanador = 0;
	
	
	
	public RepositorioEncanadorMap() {
	map = new HashMap<Integer, Encanador>();
		
	}
	
	public static RepositorioEncanadorMap getInstance(){
		if(RepositorioEncanadorMap.instance == null){
			RepositorioEncanadorMap.instance = new RepositorioEncanadorMap();
		}
		
		return RepositorioEncanadorMap.instance;
	}

	@Override
	public void Cadastrar(Encanador encanador)
			throws EncanadorCadastradoException, CampoObrigatorioException,
			SQLException {
		map.put(id_encanador, encanador);
		id_encanador++;	
	}

	
	public void atualizar(Encanador encanador)
			throws CampoObrigatorioException, EncanadorNaoEncontradoException,
			SQLException {
		
		for(int i : map.keySet()){
			Encanador e = map.get(i);
			if(encanador.getCpf().equals(e.getCpf())){
				//map.replace(i, jardineiro);
				break;
			}
		}
	}

	
	public void remover(String cpf) throws CampoObrigatorioException,
			EncanadorNaoEncontradoException, SQLException {
		
		for(int i : map.keySet()){
			Encanador e = map.get(i);
			if(cpf.equals(e.getCpf())){
				map.remove(i);
				break;
			}
		}
	}

	
	public Encanador procurar(String cpf) throws CampoObrigatorioException,
	  EncanadorNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
		Encanador encanador = new Encanador();
		for(int i : map.keySet()){
			Encanador e = map.get(i);
			if(cpf.equals(e.getCpf())){
				return e;
			}
		}
	return encanador;
	}

	
	public boolean existe(String cpf) throws CampoObrigatorioException,
			EncanadorNaoEncontradoException, SQLException {
		for(int i : map.keySet()){
			Encanador e = map.get(i);
			if(cpf.equals(e.getCpf())){
				return true;
			}
		}return false;
	}

	
	public ArrayList<Encanador> listar() throws SQLException {
		
		ArrayList<Encanador> listar = new ArrayList();
		
		for(int i : map.keySet()){
			Encanador e = map.get(i);
			listar.add(e);
		}
		
		return listar;
		//this.map.toString();
	}

	
	public ArrayList<Encanador> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
