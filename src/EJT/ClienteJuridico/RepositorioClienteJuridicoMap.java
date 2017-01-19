package EJT.ClienteJuridico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;







public class RepositorioClienteJuridicoMap implements IRepositorioClienteJuridico {
	private static RepositorioClienteJuridicoMap instance = null;
	private static Map<Integer, ClienteJuridico> mapa;
	private static Integer codigo = 0;
	
	public RepositorioClienteJuridicoMap(){
        mapa = new TreeMap<Integer, ClienteJuridico>();
        
    }
	
	public static RepositorioClienteJuridicoMap getInstance(){
		if(RepositorioClienteJuridicoMap.instance == null){
			RepositorioClienteJuridicoMap.instance = new RepositorioClienteJuridicoMap();
		}
		
		return RepositorioClienteJuridicoMap.instance;
	}
	@Override
    public void cadastrar(ClienteJuridico clienteJuridico)
			throws CampoObrigatorioException, CNPJInvalidoException, ClienteJuridicoJaCadastradoException, SQLException{
			mapa.put(codigo, clienteJuridico);
			
            codigo++;
	}
	@Override
	public void atualizar(ClienteJuridico juridicoAtualizado)
			throws CampoObrigatorioException, ClienteJuridicoNaoEncontradoException,
			SQLException, ClienteJuridicoNaoEncontradoException {
		
		  for (int i : mapa.keySet()) {
	            ClienteJuridico clienteJuridico = mapa.get(i);
	            if (juridicoAtualizado.getCnpj().equals(clienteJuridico.getCnpj())) {
	              // mapa.replace(i, juridicoAtualizado);
	                //break;
	            }
	        }
		
	}

	@Override
	public void remover(String cnpj) throws CampoObrigatorioException, ClienteJuridicoNaoEncontradoException, SQLException {
		 for (int i : mapa.keySet()) {
              ClienteJuridico clienteJuridico = mapa.get(i);
	            if (cnpj.equals(clienteJuridico.getCnpj())) {
	                mapa.remove(i);
	                break;
	            }
	        }
		
		
	}

	@Override
	public ClienteJuridico procuarar(String cnpj) throws CampoObrigatorioException, ClienteJuridicoNaoEncontradoException, SQLException {

        ClienteJuridico juridicoNull = new ClienteJuridico();
        
        for (int i : mapa.keySet()) {
        	ClienteJuridico clienteJuridico = mapa.get(i);
            if (cnpj.equals(clienteJuridico.getCnpj())) {
                return clienteJuridico;
            }
        }
        return juridicoNull;
		
	}

	@Override
	public boolean existe(String cnpj) throws CampoObrigatorioException,
	ClienteJuridicoNaoEncontradoException, SQLException {
		 for (int i : mapa.keySet()) {
			 ClienteJuridico clienteJuridico = mapa.get(i);
	            if (cnpj.equals(clienteJuridico.getCnpj())) {
	                return true;
	            }
	        }
	        return false;
	}

	@Override
	public ArrayList<ClienteJuridico> listar() throws SQLException {
    ArrayList<ClienteJuridico> listaclienteJuridico = new ArrayList<>();
        
        for (int i : mapa.keySet()) {
        	ClienteJuridico clienteJuridico = mapa.get(i);
        	listaclienteJuridico.add(clienteJuridico);
        }
        return listaclienteJuridico;
	}

	@Override
	public ArrayList<ClienteJuridico> listar(String complemento)
			throws SQLException {
         ArrayList<ClienteJuridico> listaclienteJuridico = new ArrayList<>();
        for (int i : mapa.keySet()) {
        	ClienteJuridico  clienteJuridico = mapa.get(i);
        	listaclienteJuridico.add(clienteJuridico);
        }
        return listaclienteJuridico;
	}

}
