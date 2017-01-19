package EJT.Jardineiro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RepositorioJardineiroSet implements IRepositorioJardineiro{
	private static RepositorioJardineiroSet instance = null;
	private Set<Jardineiro> set;
	private static int contador;
	
	public RepositorioJardineiroSet() {
	set = new HashSet<Jardineiro>();
	}
	
	public static RepositorioJardineiroSet getInstance(){
		if(RepositorioJardineiroSet.instance == null){
			RepositorioJardineiroSet.instance = new RepositorioJardineiroSet();
		}
		
		return RepositorioJardineiroSet.instance;
	}

	@Override
	public void cadastrar(Jardineiro jardineiro)
			throws JardineiroJaCadastradoException, CampoObrigatorioException,
			SQLException {
		
		contador++;
		jardineiro.setId_jardineiro(contador);
		set.add(jardineiro);
		
		
	
	}

	@Override
	public void atualizar(Jardineiro jardineiro)
			throws CampoObrigatorioException, JardineiroNaoEncontradoException,
			SQLException {
		jardineiro.getCpf();
		for(Jardineiro jardineiroAtualizar : set){
			if(jardineiro.getCpf().equals(jardineiroAtualizar.getCpf())){
				set.remove(jardineiroAtualizar);
				set.add(jardineiro);
				break;
			}
			
		}
		
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
		for(Jardineiro jardineiro : set){
			if(jardineiro.getCpf().equals(cpf)){
				set.remove(jardineiro);
				break;
			}
		}
		
	}

	@Override
	public Jardineiro procurar(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
		Jardineiro jardineiro = new Jardineiro();
		
		for(Jardineiro j : set){
			if(cpf.equals(j.getCpf())){
				return j;
			}
		}
		return jardineiro;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
		for(Jardineiro j : set){
			if(cpf.equals(j.getCpf())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<Jardineiro> listar() throws SQLException {
	
		ArrayList<Jardineiro> listar = new ArrayList<Jardineiro>();
		
		for(Jardineiro j : this.set){
			listar.add(j);
		}
		
		return listar;
	}

	@Override
	public ArrayList<Jardineiro> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
