package EJT.Contrato;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class RepositorioContratoMap implements IRepositorioContrato{

	private static RepositorioContratoMap instance = null;
	private Map<Integer, Contrato> map;
	private static Integer id_contrato = 0;
	
	public RepositorioContratoMap(){
		map = new HashMap<Integer, Contrato>();
	}
	
	public static RepositorioContratoMap getInstance(){
		if(RepositorioContratoMap.instance == null){
			RepositorioContratoMap.instance = new RepositorioContratoMap();
		}
		
		return RepositorioContratoMap.instance;
	}
	
	
	@Override
	public void cadastrarPF(Contrato contrato) throws SQLException {
		// TODO Auto-generated method stub
		map.put(id_contrato, contrato);
		id_contrato++;
	}

	@Override
	public Contrato contratoProcurar(int idContrato) throws SQLException {
		// TODO Auto-generated method stub
		Contrato contrato = new Contrato();
		for (int i : map.keySet()){
			Contrato x = map.get(i);
			if(idContrato == x.getIdContrato()){
				return x;
			}
		}
		return contrato;
	}

	@Override
	public ArrayList<Contrato> listar() throws SQLException {
		// TODO Auto-generated method stub
         ArrayList<Contrato> listar = new ArrayList();
		
		for(int i : map.keySet()){
			Contrato c = map.get(i);
			listar.add(c);
		}
		
		return listar;
		//this.map.toString();
	}

	@Override
	public ArrayList<Contrato> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Contrato contrato) throws SQLException {
		// TODO Auto-generated method stub
		for (int i : map.keySet()){
			Contrato x = map.get(i);
			if (contrato.getIdContrato() == x.getIdContrato()){
				
				break;
			}
		}
	}

	@Override
	public void remover(int idContrato) throws SQLException {
		// TODO Auto-generated method stub
		for (int i : map.keySet()){
			Contrato x = map.get(i);
			if(idContrato == x.getIdContrato()){
				map.remove(i);
				break;
			}
		}
	}

}
