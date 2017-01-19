package EJT.ClienteFisico;

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



public class RepositorioClienteFisicoIO implements IRepositorioClienteFisico{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<ClienteFisico> fisicos= new ArrayList<ClienteFisico>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioClienteFisicoIO() {
		
	try{
			
			file = new File("C:/temp/ClienteFisico.txt");
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
	public void cadastrar(ClienteFisico fisico)
			throws CampoObrigatorioException, ClienteJaCadastradoException, SQLException {
		try{
		fisicos = (ArrayList<ClienteFisico>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				fisicos.add(fisico);
				objectOutputStream.writeObject(fisicos);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(ClienteFisico fisico)
			throws CampoObrigatorioException, ClienteNaoEncontradoException,
			SQLException {
		
		try{
			fisicos = (ArrayList<ClienteFisico>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(ClienteFisico c : fisicos){
				if(fisico.getCpf().equals(c.getCpf())){
					fisicos.remove(c);
					fisicos.add(fisico);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(fisicos);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	ClienteNaoEncontradoException, SQLException {
		try{
			fisicos = (ArrayList<ClienteFisico>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(ClienteFisico fisico : fisicos){
				if(cpf.equals(fisico.getCpf())){
					fisicos.remove(fisico);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(fisicos);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public ClienteFisico procurar(String cpf) throws CampoObrigatorioException,
	ClienteNaoEncontradoException, SQLException {
		ClienteFisico c = null;
		
		try{
			fisicos = (ArrayList<ClienteFisico>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!fisicos.isEmpty()){
				for(ClienteFisico fisico: fisicos){
					if(cpf.equals(fisico.getCpf())){
						return fisico;
					}
				}
			}
		}catch (FileNotFoundException erro){
			
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
		return c;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	ClienteNaoEncontradoException, SQLException {
		try{
			fisicos = (ArrayList<ClienteFisico>) objectInputStream.readObject();
			
			for(ClienteFisico fisico : fisicos){
				if(cpf.equals(fisico.getCpf())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(ClienteFisico fisico : fisicos){
				if(cpf.equals(fisico.getCpf())){
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
	public ArrayList<ClienteFisico> listar() throws SQLException {
		try{
			fisicos = (ArrayList<ClienteFisico>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return fisicos;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return fisicos;
	}

	@Override
	public ArrayList<ClienteFisico> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
