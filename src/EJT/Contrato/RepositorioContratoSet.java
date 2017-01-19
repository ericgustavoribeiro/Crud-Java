package EJT.Contrato;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;





public class RepositorioContratoSet implements IRepositorioContrato{

	private static RepositorioContratoSet instance = null;	
	private Set<Contrato> set;
		
		
		public RepositorioContratoSet() {
		set = new HashSet<Contrato>();
		}
		
		public static RepositorioContratoSet getInstance(){
			if(RepositorioContratoSet.instance == null){
				RepositorioContratoSet.instance = new RepositorioContratoSet();
			}
			
			return RepositorioContratoSet.instance;
		}

	
	@Override
	public void cadastrarPF(Contrato contrato) throws SQLException {
		// TODO Auto-generated method stub
		set.add(contrato);
	}

	@Override
	public Contrato contratoProcurar(int idContrato) throws SQLException {
		// TODO Auto-generated method stub
		 Contrato contrato = new  Contrato();
		for(Contrato c : set){
			if(idContrato == c.getIdContrato()){
				return c;
			}
		}
		return contrato;
	}

	@Override
	public ArrayList<Contrato> listar() throws SQLException {
		// TODO Auto-generated method stub
	ArrayList<Contrato> listar = new ArrayList<Contrato>();
		
		
		
		for(Contrato c : set){
			listar.add(c);
		}
		return listar;
		//return set.toString();
	}

	@Override
	public ArrayList<Contrato> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Contrato contrato) throws SQLException {
		// TODO Auto-generated method stub
		contrato.getIdContrato();
		for(Contrato contratoAtualizar : set){
		if(contrato.getIdContrato() == contratoAtualizar.getIdContrato()){
				set.remove(contratoAtualizar);
				set.add(contrato);
				break;
			}
		}
		
	}

	@Override
	public void remover(int idContrato) throws SQLException {
		// TODO Auto-generated method stub
		for(Contrato contrato: set){
			if(contrato.getIdContrato() == idContrato){
				set.remove(contrato);
				break;
			}
		}
	}

}
