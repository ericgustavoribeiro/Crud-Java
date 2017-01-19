package EJT.Gerente;

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


public class RepositorioGerenteIO implements IRepositorioGerente{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioGerenteIO() {
		
	try{
			
			file = new File("C:/temp/gerente.txt");
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
	public void Cadastrar(Gerente gerente)
			throws GerenteJaCadastradoException, CampoObrigatorioException,
			SQLException {
		try{
			gerentes = (ArrayList<Gerente>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				gerentes.add(gerente);
				objectOutputStream.writeObject(gerentes);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(Gerente gerente)
			throws CampoObrigatorioException, GerenteNaoEncontradoExceptio,
			SQLException {
		
		try{
			gerentes = (ArrayList<Gerente>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(Gerente g : gerentes){
				if(gerente.getCpf().equals(g.getCpf())){
				gerentes.remove(g);
				gerentes.add(gerente);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(gerentes);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	GerenteNaoEncontradoExceptio, SQLException {
		try{
			gerentes = (ArrayList<Gerente>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(Gerente gerente : gerentes){
				if(cpf.equals(gerente.getCpf())){
					gerentes.remove(gerente);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(gerentes);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public Gerente procurar(String cpf) throws CampoObrigatorioException,
	GerenteNaoEncontradoExceptio, SQLException {
		Gerente g = null;
		
		try{
			gerentes = (ArrayList<Gerente>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!gerentes.isEmpty()){
				for(Gerente gerente: gerentes){
					if(cpf.equals(gerente.getCpf())){
						return gerente;
					}
				}
			}
		}catch (FileNotFoundException erro){
			
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
		return g;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	GerenteNaoEncontradoExceptio, SQLException {
		try{
			gerentes = (ArrayList<Gerente>) objectInputStream.readObject();
			
			for(Gerente gerente : gerentes){
				if(cpf.equals(gerente.getCpf())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(Gerente gerente : gerentes){
				if(cpf.equals(gerente.getCpf())){
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
	public ArrayList<Gerente> listar() throws SQLException {
		try{
			gerentes = (ArrayList<Gerente>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return gerentes;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return gerentes;
	}

	@Override
	public ArrayList<Gerente> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
