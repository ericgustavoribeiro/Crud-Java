package EJT.Empresa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class RepositorioEmpresaMap implements IRepositorioEmpresa <Empresa, String>{
	private static RepositorioEmpresaMap instance = null;
	private static Map<Integer, Empresa> mapa;
	private static Integer codigo = 0;
	
	public RepositorioEmpresaMap(){
        mapa = new TreeMap<Integer, Empresa>();
        
    }
	
	public static RepositorioEmpresaMap getInstance(){
		if(RepositorioEmpresaMap.instance == null){
			RepositorioEmpresaMap.instance = new RepositorioEmpresaMap();
		}
		
		return RepositorioEmpresaMap.instance;
	}
	@Override
	public void Cadastrar(Empresa empresa) throws SQLException {
		// TODO Auto-generated method stub
		mapa.put(codigo, empresa);
		
        codigo++;
	}

	@Override
	public Empresa procurar(String cnpj) throws SQLException,
			EmpresaNaoEncontradaException {
		// TODO Auto-generated method stub
		 Empresa empresaNull = new Empresa();
	        
	        for (int i : mapa.keySet()) {
	        	Empresa empresa = mapa.get(i);
	            if (cnpj.equals(empresa.getCnpj())) {
	                return empresa;
	            }
	        }
	        return empresaNull;
	}

	@Override
	public void atualizar(Empresa empresaAtualizado) throws SQLException,
			EmpresaNaoEncontradaException {
		// TODO Auto-generated method stub
		  for (int i : mapa.keySet()) {
	           Empresa empresa = mapa.get(i);
	            if (empresaAtualizado.getCnpj().equals(empresa.getCnpj())) {
	              // mapa.replace(i, juridicoAtualizado);
	                //break;
	            }
	        }
	}

	@Override
	public void remover(String cnpj) throws SQLException,
			EmpresaNaoEncontradaException {
		// TODO Auto-generated method stub
		 for (int i : mapa.keySet()) {
             Empresa empresa = mapa.get(i);
	            if (cnpj.equals(empresa.getCnpj())) {
	                mapa.remove(i);
	                break;
	            }
	        }
		
	}

	@Override
	public boolean existe(String cnpj) throws SQLException,
			EmpresaNaoEncontradaException {
		// TODO Auto-generated method stub
		 for (int i : mapa.keySet()) {
			 Empresa empresa = mapa.get(i);
	            if (cnpj.equals(empresa.getCnpj())) {
	                return true;
	            }
	        }
	        return false;
	}

	@Override
	public ArrayList<Empresa> listar() throws SQLException {
		// TODO Auto-generated method stub
		  ArrayList<Empresa> listaempresa = new ArrayList<>();
	    for (int i : mapa.keySet()) {
        	Empresa empresa = mapa.get(i);
        	listaempresa.add(empresa);
        }
        return listaempresa;
	}

	@Override
	public ArrayList<Empresa> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		  ArrayList<Empresa> listaempresa = new ArrayList<>();
		    for (int i : mapa.keySet()) {
	        	Empresa empresa = mapa.get(i);
	        	listaempresa.add(empresa);
	        }
	        return listaempresa;
	}

	public boolean existe() throws SQLException {
		return false;
		
	}
	
}
