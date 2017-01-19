package EJT.ClienteJuridico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;






public class RepositorioClienteJuridicoSet implements IRepositorioClienteJuridico{
	private static RepositorioClienteJuridicoSet instance = null;
	private Set<ClienteJuridico> set;
	private static int contador;
	
	public RepositorioClienteJuridicoSet() {
	set = new HashSet<ClienteJuridico>();
	}
	
	public static RepositorioClienteJuridicoSet getInstance(){
		if(RepositorioClienteJuridicoSet.instance == null){
			RepositorioClienteJuridicoSet.instance = new RepositorioClienteJuridicoSet();
		}
		
		return RepositorioClienteJuridicoSet.instance;
	}
	@Override
	public void cadastrar(ClienteJuridico clienteJuridico)
			throws CampoObrigatorioException, CNPJInvalidoException,
			ClienteJuridicoJaCadastradoException, SQLException {
		// TODO Auto-generated method stub
		contador++;
		clienteJuridico.setId_clienteJuridico(contador);
		set.add(clienteJuridico);
		
		
		
	}

	@Override
	public void atualizar(ClienteJuridico clienteJuridico)
			throws CampoObrigatorioException,
			ClienteJuridicoNaoEncontradoException, SQLException,
			ClienteJuridicoNaoEncontradoException {
		// TODO Auto-generated method stub
		 clienteJuridico.getCnpj();
		for(ClienteJuridico clienteJuridicoAtualizar : set){
			if(clienteJuridico.getCnpj().equals(clienteJuridicoAtualizar.getCnpj())){
				set.remove(clienteJuridicoAtualizar);
				set.add(clienteJuridico);
				break;
           	}
		}
	}

	@Override
	public void remover(String cnpj) throws CampoObrigatorioException,
			ClienteJuridicoNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
		for(ClienteJuridico clienteJuridico : set){
			if(clienteJuridico.getCnpj().equals(cnpj)){
				set.remove(clienteJuridico);
				break;
			}
		}
	}

	@Override
	public ClienteJuridico procuarar(String cnpj)
			throws CampoObrigatorioException,
			ClienteJuridicoNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
		 ClienteJuridico clienteJuridico = new ClienteJuridico();
			
			for(ClienteJuridico c : set){
				if(cnpj.equals(c.getCnpj())){
					return c;
				}
			}
			return clienteJuridico;
	}

	@Override
	public boolean existe(String cnpj) throws CampoObrigatorioException,
			ClienteJuridicoNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
		for(ClienteJuridico c : set){
			if(cnpj.equals(c.getCnpj())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<ClienteJuridico> listar() throws SQLException {
	
		ArrayList<ClienteJuridico> listar = new ArrayList<ClienteJuridico>();
		
		
		for(ClienteJuridico c : this.set){
			
			listar.add(c);
		}
		
		
		return listar;
	}

	@Override
	public ArrayList<ClienteJuridico> listar(String complemento)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
