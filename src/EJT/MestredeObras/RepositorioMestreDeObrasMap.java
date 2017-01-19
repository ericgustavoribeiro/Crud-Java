package EJT.MestredeObras;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import EJT.Fachada.Fachada;


public class RepositorioMestreDeObrasMap implements IRepositorioMestreDeObras{
	private static RepositorioMestreDeObrasMap instance = null;
	private static Map<Integer, MestreDeObras> mapa;
	private static Integer codigo = 0;
	
	public RepositorioMestreDeObrasMap(){
        mapa = new TreeMap<Integer, MestreDeObras>();
        
    }
	
	public static RepositorioMestreDeObrasMap getInstance(){
		if(RepositorioMestreDeObrasMap.instance == null){
			RepositorioMestreDeObrasMap.instance = new RepositorioMestreDeObrasMap();
		}
		
		return RepositorioMestreDeObrasMap.instance;
	}
	        
    @Override
	public void Cadastrar(MestreDeObras mestre)
			throws MestreDeObrasJaCadastradoException, CampoObrigatorioException{
			mapa.put(codigo, mestre);
			
            codigo++;
	}

	@Override
	public void atualizar(MestreDeObras mestreAtualizado)
			throws CampoObrigatorioException, MestreDeObrasNaoEncontradoException,
			SQLException {
		
		  for (int i : mapa.keySet()) {
	            MestreDeObras mestre = mapa.get(i);
	            if (mestreAtualizado.getCpf().equals(mestre.getCpf())) {
	               // mapa.replace(i, mestreAtualizado);
	                //break;
	            }
	        }
		
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	MestreDeObrasNaoEncontradoException, SQLException {
		 for (int i : mapa.keySet()) {
              MestreDeObras mestre = mapa.get(i);
	            if (cpf.equals(mestre.getCpf())) {
	                mapa.remove(i);
	                break;
	            }
	        }
		
		
	}

	@Override
	public MestreDeObras procurar(String cpf) throws CampoObrigatorioException,
	MestreDeObrasNaoEncontradoException, SQLException {

        MestreDeObras mestreNull = new MestreDeObras();
        
        for (int i : mapa.keySet()) {
        	MestreDeObras mestre = mapa.get(i);
            if (cpf.equals(mestre.getCpf())) {
                return mestre;
            }
        }
        return mestreNull;
		
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	MestreDeObrasNaoEncontradoException, SQLException {
		 for (int i : mapa.keySet()) {
	            MestreDeObras mestre = mapa.get(i);
	            if (cpf.equals(mestre.getCpf())) {
	                return true;
	            }
	        }
	        return false;
	}

	@Override
	public ArrayList<MestreDeObras> listar() throws SQLException {
    ArrayList<MestreDeObras> listaMestre = new ArrayList<>();
        
        for (int i : mapa.keySet()) {
        	MestreDeObras mestre = mapa.get(i);
            listaMestre.add(mestre);
        }
        return listaMestre;
	}

	@Override
	public ArrayList<MestreDeObras> listar(String complemento)
			throws SQLException {
		ArrayList<MestreDeObras> listaMestre = new ArrayList<>();
        for (int i : mapa.keySet()) {
        	MestreDeObras mestre = mapa.get(i);
            listaMestre.add(mestre);
        }
        return listaMestre;
	}

//

}
