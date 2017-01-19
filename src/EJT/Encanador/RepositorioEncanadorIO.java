package EJT.Encanador;

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



public class RepositorioEncanadorIO implements IRepositorioEncanador{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<Encanador> encanadores = new ArrayList<Encanador>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioEncanadorIO() {
		
	try{
			
			file = new File("C:/temp/encanador.txt");
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
	public void Cadastrar(Encanador encanador)
			throws EncanadorCadastradoException, CampoObrigatorioException,
			SQLException {
		try{
		encanadores = (ArrayList<Encanador>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				encanadores.add(encanador);
				objectOutputStream.writeObject(encanadores);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(Encanador encanador)
			throws CampoObrigatorioException, EncanadorNaoEncontradoException,
			SQLException {
		
		try{
			encanadores = (ArrayList<Encanador>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(Encanador e : encanadores){
				if(encanador.getCpf().equals(e.getCpf())){
				encanadores.remove(e);
				encanadores.add(encanador);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(encanadores);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	EncanadorNaoEncontradoException, SQLException {
		try{
			encanadores = (ArrayList<Encanador>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(Encanador encanador : encanadores){
				if(cpf.equals(encanador.getCpf())){
					encanadores.remove(encanador);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(encanadores);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public Encanador procurar(String cpf) throws CampoObrigatorioException,
	EncanadorNaoEncontradoException, SQLException {
		Encanador  e = null;
		
		try{
			encanadores = (ArrayList<Encanador>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!encanadores.isEmpty()){
				for(Encanador encanador: encanadores){
					if(cpf.equals(encanador.getCpf())){
						return encanador;
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
	public boolean existe(String cpf) throws CampoObrigatorioException,
	EncanadorNaoEncontradoException, SQLException {
		try{
			encanadores = (ArrayList<Encanador>) objectInputStream.readObject();
			
			for(Encanador encanador : encanadores){
				if(cpf.equals(encanador.getCpf())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(Encanador encanador : encanadores){
				if(cpf.equals(encanador.getCpf())){
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
	public ArrayList<Encanador> listar() throws SQLException {
		try{
			encanadores = (ArrayList<Encanador>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return encanadores;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return encanadores;
	}

	@Override
	public ArrayList<Encanador> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
