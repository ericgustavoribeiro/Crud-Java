package EJT.Empresa;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;


//ok


public class RepositorioEmpresaIO implements IRepositorioEmpresa <Empresa, String>{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioEmpresaIO() {
		
	try{
			
			file = new File("C:/temp/empresa.txt");
			file.createNewFile();
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			
		
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
	}
		
	}

	@Override
	public void Cadastrar(Empresa empresa)
			throws SQLException {
		try{
		empresas = (ArrayList<Empresa>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				empresas.add(empresa);
				objectOutputStream.writeObject(empresas);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(Empresa empresa)
			throws EmpresaNaoEncontradaException,
			SQLException {
		
		try{
			empresas = (ArrayList<Empresa>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(Empresa e : empresas){
				if(empresa.getCnpj().equals(e.getCnpj())){
				empresas.remove(e);
				empresas.add(empresa);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(empresas);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cnpj) throws 
			EmpresaNaoEncontradaException, SQLException {
		try{
			empresas = (ArrayList<Empresa>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(Empresa empresa : empresas){
				if(cnpj.equals(empresa.getCnpj())){
					empresas.remove(empresa);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(empresas);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public Empresa procurar(String cnpj) throws 
	EmpresaNaoEncontradaException, SQLException {
		Empresa e = null;
		
		try{
			empresas = (ArrayList<Empresa>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!empresas.isEmpty()){
				for(Empresa empresa: empresas){
					if(cnpj.equals(empresa.getCnpj())){
						return empresa;
					}
				}
			}
		}catch (FileNotFoundException erro){
			
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
		return e;
	}

	@Override
	public boolean existe(String cnpj) throws 
	EmpresaNaoEncontradaException, SQLException {
		try{
			empresas = (ArrayList<Empresa>) objectInputStream.readObject();
			
			for(Empresa empresa : empresas){
				if(cnpj.equals(empresa.getCnpj())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(Empresa empresa : empresas){
				if(cnpj.equals(empresa.getCnpj())){
					return true;
				}
			}
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		
		return false;
	}

	@Override
	public ArrayList<Empresa> listar() throws SQLException {
		try{
			empresas = (ArrayList<Empresa>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return empresas;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return empresas;
	}

	@Override
	public ArrayList<Empresa> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existe() throws SQLException {
		return false;
		
	}

}
