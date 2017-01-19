package EJT.Jardineiro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import EJT.MestredeObras.RepositorioMestreDeObrasMap;

public class RepositorioJardineiroMap implements IRepositorioJardineiro {
	private static RepositorioJardineiroMap instance = null;
	private Map<Integer, Jardineiro> map;
	private static Integer id_jardineiro = 0;
	
	
	
	public RepositorioJardineiroMap() {
	map = new HashMap<Integer, Jardineiro>();
		
	}
	
	public static RepositorioJardineiroMap getInstance(){
		if(RepositorioJardineiroMap.instance == null){
			RepositorioJardineiroMap.instance = new RepositorioJardineiroMap();
		}
		
		return RepositorioJardineiroMap.instance;
	}

	@Override
	public void cadastrar(Jardineiro jardineiro)
			throws JardineiroJaCadastradoException, CampoObrigatorioException,
			SQLException {
		map.put(id_jardineiro, jardineiro);
		id_jardineiro++;	
	}

	@Override
	public void atualizar(Jardineiro jardineiro)
			throws CampoObrigatorioException, JardineiroNaoEncontradoException,
			SQLException {
		
		for(int i : map.keySet()){
			Jardineiro j = map.get(i);
			if(jardineiro.getCpf().equals(j.getCpf())){
				//map.replace(i, jardineiro);
				break;
			}
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
		
		for(int i : map.keySet()){
			Jardineiro j = map.get(i);
			if(cpf.equals(j.getCpf())){
				map.remove(i);
				break;
			}
		}
	}

	@Override
	public Jardineiro procurar(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
		Jardineiro jardineiro = new Jardineiro();
		for(int i : map.keySet()){
			Jardineiro j = map.get(i);
			if(cpf.equals(j.getCpf())){
				return j;
			}
		}
	return jardineiro;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
		for(int i : map.keySet()){
			Jardineiro j = map.get(i);
			if(cpf.equals(j.getCpf())){
				return true;
			}
		}return false;
	}

	@Override
	public ArrayList<Jardineiro> listar() throws SQLException {
		
		ArrayList<Jardineiro> listar = new ArrayList();
		
		for(int i : map.keySet()){
			Jardineiro j = map.get(i);
			listar.add(j);
		}
		
		return listar;
		//this.map.toString();
	}

	@Override
	public ArrayList<Jardineiro> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
