package EJT.ClienteFisico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class RepositorioClienteFisicoSet implements IRepositorioClienteFisico{
	private static RepositorioClienteFisicoSet instance = null;	
	private Set<ClienteFisico> set;
		
		
		public RepositorioClienteFisicoSet() {
		set = new HashSet<ClienteFisico>();
		}
		
		public static RepositorioClienteFisicoSet getInstance(){
			if(RepositorioClienteFisicoSet.instance == null){
				RepositorioClienteFisicoSet.instance = new RepositorioClienteFisicoSet();
			}
			
			return RepositorioClienteFisicoSet.instance;
		}
	@Override
	public void cadastrar(ClienteFisico clienteFisico)
			throws CPFInvalidoException, ClienteJaCadastradoException,
			CampoObrigatorioException, SQLException {
		// TODO Auto-generated method stub
		set.add(clienteFisico);
	}

	@Override
	public void atualizar(ClienteFisico clienteFisico)
			throws ClienteNaoEncontradoException, CampoObrigatorioException,
			SQLException {
		// TODO Auto-generated method stub
		clienteFisico.getCpf();
		for(ClienteFisico clienteFisicoAtualizar : set){
			if(clienteFisico.getCpf().equals(clienteFisicoAtualizar.getCpf())){
				set.remove(clienteFisicoAtualizar);
				set.add(clienteFisico);
				break;
			}
			
		}
	}

	@Override
	public void remover(String cpf) throws ClienteNaoEncontradoException,
			CampoObrigatorioException, SQLException {
		// TODO Auto-generated method stub
		for(ClienteFisico clienteFisico : set){
			if(clienteFisico.getCpf().equals(cpf)){
				set.remove(clienteFisico);
				break;
			}
		}
	}

	@Override
	public ClienteFisico procurar(String cpf)
			throws ClienteNaoEncontradoException, CampoObrigatorioException,
			SQLException {
		// TODO Auto-generated method stub
		ClienteFisico clienteFisico = new ClienteFisico();
		for(ClienteFisico c : set){
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
		for(ClienteFisico c : set){
			if(cpf.equals(c.getCpf())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<ClienteFisico> listar() throws SQLException {
		// TODO Auto-generated method stub
		
		ArrayList<ClienteFisico> listar = new ArrayList<ClienteFisico>();
		
		
		for(ClienteFisico c : this.set){
			
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
