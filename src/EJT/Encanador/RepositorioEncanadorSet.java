package EJT.Encanador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;





public class RepositorioEncanadorSet implements IRepositorioEncanador{

	private Set<Encanador> set;
	private static RepositorioEncanadorSet instance = null;
	
	public RepositorioEncanadorSet() {
	set = new HashSet<Encanador>();
	}
	public static RepositorioEncanadorSet getInstance(){
		if(RepositorioEncanadorSet.instance == null){
			RepositorioEncanadorSet.instance = new RepositorioEncanadorSet();
		}
		
		return RepositorioEncanadorSet.instance;
	}

	@Override
	public void Cadastrar(Encanador encanador)
			throws EncanadorCadastradoException, CampoObrigatorioException,
			SQLException {
		set.add(encanador);
	}

	@Override
	public void atualizar(Encanador encanador)
			throws CampoObrigatorioException, EncanadorNaoEncontradoException,
			SQLException {
		encanador.getCpf();
		for(Encanador encanadorAtualizar : set){
			if(encanador.getCpf().equals(encanadorAtualizar.getCpf())){
				set.remove(encanadorAtualizar);
				set.add(encanador);
				break;
			}
			
		}
		
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	EncanadorNaoEncontradoException, SQLException {
		for(Encanador encanador : set){
			if(encanador.getCpf().equals(cpf)){
				set.remove(encanador);
				break;
			}
		}
		
	}

	@Override
	public Encanador procurar(String cpf) throws CampoObrigatorioException,
	            EncanadorNaoEncontradoException, SQLException {
		Encanador encanador = new Encanador();
		
		for(Encanador e : set){
			if(cpf.equals(e.getCpf())){
				return e;
			}
		}
		return encanador;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	EncanadorNaoEncontradoException, SQLException {
		for(Encanador e : set){
			if(cpf.equals(e.getCpf())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<Encanador> listar() throws SQLException {
	
		ArrayList<Encanador> listar = new ArrayList<Encanador>();
		
		
		
		for(Encanador e : set){
			listar.add(e);
		}
		return listar;
		//return set.toString();
	}

	@Override
	public ArrayList<Encanador> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
