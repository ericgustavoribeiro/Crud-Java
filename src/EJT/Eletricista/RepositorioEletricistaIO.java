package EJT.Eletricista;

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



public class RepositorioEletricistaIO implements IRepositorioEletricista{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<Eletricista> eletricistas = new ArrayList<Eletricista>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioEletricistaIO() {
		
	try{
			
			file = new File("C:/temp/eletricista.txt");
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
	public void Cadastrar(Eletricista eletricista)
			throws CampoObrigatorioException, EletricistaJaCadastradoEXception, SQLException {
		try{
		eletricistas = (ArrayList<Eletricista>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				eletricistas.add(eletricista);
				objectOutputStream.writeObject(eletricistas);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(Eletricista eletricista)
			throws CampoObrigatorioException, EletricistaNaoEncontradoException,
			SQLException {
		
		try{
			eletricistas = (ArrayList<Eletricista>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(Eletricista e : eletricistas){
				if(eletricista.getCpf().equals(e.getCpf())){
					eletricistas.remove(e);
					eletricistas.add(eletricista);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(eletricistas);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
			EletricistaNaoEncontradoException, SQLException {
		try{
			eletricistas = (ArrayList<Eletricista>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(Eletricista eletricista : eletricistas){
				if(cpf.equals(eletricista.getCpf())){
					eletricistas.remove(eletricista);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(eletricistas);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public Eletricista procurar(String cpf) throws CampoObrigatorioException,
	EletricistaNaoEncontradoException, SQLException {
		Eletricista j = null;
		
		try{
			eletricistas = (ArrayList<Eletricista>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!eletricistas.isEmpty()){
				for(Eletricista eletricista: eletricistas){
					if(cpf.equals(eletricista.getCpf())){
						return eletricista;
					}
				}
			}
		}catch (FileNotFoundException erro){
			
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
		return j;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	EletricistaNaoEncontradoException, SQLException {
		try{
			eletricistas = (ArrayList<Eletricista>) objectInputStream.readObject();
			
			for(Eletricista eletricista : eletricistas){
				if(cpf.equals(eletricista.getCpf())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(Eletricista eletricista : eletricistas){
				if(cpf.equals(eletricista.getCpf())){
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
	public ArrayList<Eletricista> listar() throws SQLException {
		try{
			eletricistas = (ArrayList<Eletricista>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return eletricistas;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return eletricistas;
	}

	@Override
	public ArrayList<Eletricista> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
