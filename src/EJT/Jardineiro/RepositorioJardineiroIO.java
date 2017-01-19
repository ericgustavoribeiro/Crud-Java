package EJT.Jardineiro;

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
import java.util.logging.Logger;

import javax.jws.Oneway;

public class RepositorioJardineiroIO implements IRepositorioJardineiro{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<Jardineiro> jardineiros = new ArrayList<Jardineiro>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioJardineiroIO() {
		
	try{
			
			file = new File("C:/temp/jardineiro.txt");
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
	public void cadastrar(Jardineiro jardineiro)
			throws JardineiroJaCadastradoException, CampoObrigatorioException,
			SQLException {
		try{
		jardineiros = (ArrayList<Jardineiro>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				jardineiros.add(jardineiro);
				objectOutputStream.writeObject(jardineiros);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(Jardineiro jardineiro)
			throws CampoObrigatorioException, JardineiroNaoEncontradoException,
			SQLException {
		
		try{
			jardineiros = (ArrayList<Jardineiro>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(Jardineiro j : jardineiros){
				if(jardineiro.getCpf().equals(j.getCpf())){
				jardineiros.remove(j);
				jardineiros.add(jardineiro);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(jardineiros);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
		try{
			jardineiros = (ArrayList<Jardineiro>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(Jardineiro jardineiro : jardineiros){
				if(cpf.equals(jardineiro.getCpf())){
					jardineiros.remove(jardineiro);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(jardineiros);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public Jardineiro procurar(String cpf) throws CampoObrigatorioException,
			JardineiroNaoEncontradoException, SQLException {
		Jardineiro j = null;
		
		try{
			jardineiros = (ArrayList<Jardineiro>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!jardineiros.isEmpty()){
				for(Jardineiro jardineiro: jardineiros){
					if(cpf.equals(jardineiro.getCpf())){
						return jardineiro;
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
			JardineiroNaoEncontradoException, SQLException {
		try{
			jardineiros = (ArrayList<Jardineiro>) objectInputStream.readObject();
			
			for(Jardineiro jardineiro : jardineiros){
				if(cpf.equals(jardineiro.getCpf())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(Jardineiro jardineiro : jardineiros){
				if(cpf.equals(jardineiro.getCpf())){
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
	public ArrayList<Jardineiro> listar() throws SQLException {
		try{
			jardineiros = (ArrayList<Jardineiro>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return jardineiros;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return jardineiros;
	}

	@Override
	public ArrayList<Jardineiro> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
