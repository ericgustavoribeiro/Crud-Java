package EJT.ClienteFisico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;







public class RepositorioClienteFisicoMap implements IRepositorioClienteFisico{
	private static RepositorioClienteFisicoMap instance = null;
	private Map<Integer, ClienteFisico> map;
	private static Integer id_clienteFisico = 0;
	
	
	
	public RepositorioClienteFisicoMap() {
	map = new HashMap<Integer, ClienteFisico>();
		
	}
	
	public static RepositorioClienteFisicoMap getInstance(){
		if(RepositorioClienteFisicoMap.instance == null){
			RepositorioClienteFisicoMap.instance = new RepositorioClienteFisicoMap();
		}
		
		return RepositorioClienteFisicoMap.instance;
	}
	@Override
	public void cadastrar(ClienteFisico clienteFisico)
			throws CPFInvalidoException, ClienteJaCadastradoException,
			CampoObrigatorioException, SQLException {
		// TODO Auto-generated method stub
		map.put(id_clienteFisico, clienteFisico);
		id_clienteFisico++;	
		
	}

	@Override
	public void atualizar(ClienteFisico clienteFisico)
			throws ClienteNaoEncontradoException, CampoObrigatorioException,
			SQLException {
		// TODO Auto-generated method stub
		for(int i : map.keySet()){
			ClienteFisico c = map.get(i);
			if(clienteFisico.getCpf().equals(c.getCpf())){
				//map.replace(i, jardineiro);
				break;
			}
		}
	}

	@Override
	public void remover(String cpf) throws ClienteNaoEncontradoException,
			CampoObrigatorioException, SQLException {
		// TODO Auto-generated method stub
		for(int i : map.keySet()){
			ClienteFisico c = map.get(i);
			if(cpf.equals(c.getCpf())){
				map.remove(c);
				break;
			}
		}
	}

	@Override
	public ClienteFisico procurar(String cpf)
			throws ClienteNaoEncontradoException, CampoObrigatorioException,
			SQLException {
		ClienteFisico clienteFisico = new ClienteFisico();
		for(int i : map.keySet()){
			ClienteFisico c = map.get(i);
			if(cpf.equals(c.getCpf())){
				return c;
			}
		}
        return clienteFisico;
	
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
			ClienteNaoEncontradoException, CPFInvalidoException, SQLException {
		// TODO Auto-generated method stub
		for(int i : map.keySet()){
			ClienteFisico c = map.get(i);
			if(cpf.equals(c.getCpf())){
				return true;
			}
		}return false;
	}

	@Override
	public ArrayList<ClienteFisico> listar() throws SQLException {
		// TODO Auto-generated method stub
	ArrayList<ClienteFisico> listar = new ArrayList();
		
		for(int i : map.keySet()){
			ClienteFisico c = map.get(i);
			listar.add(c);
		}
		
		return listar;
	}

	@Override
	public ArrayList<ClienteFisico> listar(String complemento)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
