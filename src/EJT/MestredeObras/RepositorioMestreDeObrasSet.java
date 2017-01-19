package EJT.MestredeObras;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;







public class RepositorioMestreDeObrasSet implements IRepositorioMestreDeObras{

	private Set<MestreDeObras> set;
	private static RepositorioMestreDeObrasSet instance = null;
	
	public RepositorioMestreDeObrasSet() {
	set = new HashSet<MestreDeObras>();
	}

	public static RepositorioMestreDeObrasSet getInstance(){
		if(RepositorioMestreDeObrasSet.instance == null){
			RepositorioMestreDeObrasSet.instance = new RepositorioMestreDeObrasSet();
		}
		
		return RepositorioMestreDeObrasSet.instance;
	}

	@Override
	public void Cadastrar(MestreDeObras mestre)
			throws MestreDeObrasJaCadastradoException, CampoObrigatorioException,
			SQLException {
		set.add(mestre);
	}

	@Override
	public void atualizar(MestreDeObras mestre)
			throws CampoObrigatorioException, MestreDeObrasNaoEncontradoException,
			SQLException {
		mestre.getCpf();
		for(MestreDeObras mestreAtualizar : set){
			if(mestre.getCpf().equals(mestreAtualizar.getCpf())){
				set.remove(mestreAtualizar);
				set.add(mestre);
				break;
			}
			
		}
		
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	MestreDeObrasNaoEncontradoException, SQLException {
		for(MestreDeObras mestre : set){
			if(mestre.getCpf().equals(cpf)){
				set.remove(mestre);
				break;
			}
		}
		
	}

	@Override
	public MestreDeObras procurar(String cpf) throws CampoObrigatorioException,
	MestreDeObrasNaoEncontradoException, SQLException {
           MestreDeObras mestre = new MestreDeObras();
		
		for(MestreDeObras m : set){
			if(cpf.equals(m.getCpf())){
				return m;
			}
		}
		return mestre;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	MestreDeObrasNaoEncontradoException, SQLException {
		for(MestreDeObras m : set){
			if(cpf.equals(m.getCpf())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<MestreDeObras> listar() throws SQLException {
	
		ArrayList<MestreDeObras> listar = new ArrayList<MestreDeObras>();
		
		
		
		for(MestreDeObras m : set){
			listar.add(m);
		}
		return listar;
		//return set.toString();
	}

	@Override
	public ArrayList<MestreDeObras> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

