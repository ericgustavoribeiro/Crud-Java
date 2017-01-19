package EJT.ContratoJuridico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class RepositorioContratoJuridicoMap implements IRepositorioContratoJuridico{

	private static RepositorioContratoJuridicoMap instance = null;
	private Map<Integer, ContratoJuridico> map;
	private static Integer id_contrato = 0;
	
	public RepositorioContratoJuridicoMap(){
		map = new HashMap<Integer, ContratoJuridico>();
	}
	
	public static RepositorioContratoJuridicoMap getInstance(){
		if(RepositorioContratoJuridicoMap.instance == null){
			RepositorioContratoJuridicoMap.instance = new RepositorioContratoJuridicoMap();
		}
		
		return RepositorioContratoJuridicoMap.instance;
	}
	
	
	@Override
	public void cadastrar(ContratoJuridico contratoJuridico)
			throws CampoObrigatorioException, SQLException {
		// TODO Auto-generated method stub
		map.put(id_contrato, contratoJuridico);
		id_contrato++;
	}

	@Override
	public void atualizar(ContratoJuridico contratoJuridico)
			throws ContratoNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
		for (int i : map.keySet()){
			ContratoJuridico x = map.get(i);
			if (contratoJuridico.getIdContrato() == x.getIdContrato()){
				
				break;
			}
		}
	}

	@Override
	public void remover(int idContrato) throws ContratoNaoEncontradoException,
			SQLException {
		// TODO Auto-generated method stub
		for (int i : map.keySet()){
			ContratoJuridico x = map.get(i);
			if(idContrato == x.getIdContrato()){
				map.remove(i);
				break;
			}
		}
	}

	@Override
	public ContratoJuridico procurar(int idContrato)
			throws ContratoNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
		ContratoJuridico contratoJuridico = new ContratoJuridico();
		for (int i : map.keySet()){
			ContratoJuridico x = map.get(i);
			if(idContrato == x.getIdContrato()){
				return x;
			}
		}
		return contratoJuridico;
	}

	@Override
	public ArrayList<ContratoJuridico> listar() throws SQLException {
		// TODO Auto-generated method stub
	     ArrayList<ContratoJuridico> listar = new ArrayList();
			
			for(int i : map.keySet()){
				ContratoJuridico c = map.get(i);
				listar.add(c);
			}
			
			return listar;
			//this.map.toString();
	}

	@Override
	public ArrayList<ContratoJuridico> listar(String complemento)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
