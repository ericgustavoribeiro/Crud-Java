package EJT.ContratoJuridico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;




public class RepositorioContratoJuridicoSet implements IRepositorioContratoJuridico {

	private static RepositorioContratoJuridicoSet instance = null;	
	private Set<ContratoJuridico> set;
		
		
		public RepositorioContratoJuridicoSet() {
		set = new HashSet<ContratoJuridico>();
		}
		
		public static RepositorioContratoJuridicoSet getInstance(){
			if(RepositorioContratoJuridicoSet.instance == null){
				RepositorioContratoJuridicoSet.instance = new RepositorioContratoJuridicoSet();
			}
			
			return RepositorioContratoJuridicoSet.instance;
		}
	@Override
	public void cadastrar(ContratoJuridico contratoJuridico)
			throws CampoObrigatorioException, SQLException {
		// TODO Auto-generated method stub
		set.add(contratoJuridico);
	}

	@Override
	public void atualizar(ContratoJuridico contratoJuridico)
			throws ContratoNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
		contratoJuridico.getIdContrato();
		for(ContratoJuridico contratoAtualizar : set){
		if(contratoJuridico.getIdContrato() == contratoAtualizar.getIdContrato()){
				set.remove(contratoAtualizar);
				set.add(contratoJuridico);
				break;
			}
		}
	}

	@Override
	public void remover(int idContrato) throws ContratoNaoEncontradoException,
			SQLException {
		// TODO Auto-generated method stub
		for(ContratoJuridico contratoJuridico: set){
			if(contratoJuridico.getIdContrato() == idContrato){
				set.remove(contratoJuridico);
				break;
			}
		}
	}
	

	@Override
	public ContratoJuridico procurar(int idContrato)
			throws ContratoNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
		 ContratoJuridico contratoJuridico = new  ContratoJuridico();
			for(ContratoJuridico c : set){
				if(idContrato == c.getIdContrato()){
					return c;
				}
			}
			return contratoJuridico;
	}

	@Override
	public ArrayList<ContratoJuridico> listar() throws SQLException {
		// TODO Auto-generated method stub
	ArrayList<ContratoJuridico> listar = new ArrayList<ContratoJuridico>();
		
		
		
		for(ContratoJuridico c : set){
			listar.add(c);
		}
		return listar;
		//return set.toString();
	}

	@Override
	public ArrayList<ContratoJuridico> listar(String complemento)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
