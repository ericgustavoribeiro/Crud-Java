package EJT.Engenheiro;

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



public class RepositorioEngenheiroIO implements  IRepositorioEngenheiro{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<Engenheiro> engenheiros = new ArrayList<Engenheiro>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioEngenheiroIO() {
		
	try{
			
			file = new File("C:/temp/engenheiro.txt");
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
	public void Cadastrar(Engenheiro engenheiro)
			throws EngenheiroJaCadastradoException, CampoObrigatorioException,
			SQLException {
		try{
		engenheiros = (ArrayList<Engenheiro>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				engenheiros.add(engenheiro);
				objectOutputStream.writeObject(engenheiros);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(Engenheiro engenheiro)
			throws CampoObrigatorioException, EngenheiroNaoEncontradoException,
			SQLException {
		
		try{
			engenheiros = (ArrayList<Engenheiro>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(Engenheiro e : engenheiros){
				if(engenheiro.getCpf().equals(e.getCpf())){
			    engenheiros.remove(e);
				engenheiros.add(engenheiro);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(engenheiros);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	EngenheiroNaoEncontradoException, SQLException {
		try{
			engenheiros = (ArrayList<Engenheiro>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(Engenheiro engenheiro : engenheiros){
				if(cpf.equals(engenheiro.getCpf())){
					engenheiros.remove(engenheiro);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(engenheiros);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public Engenheiro procurar(String cpf) throws CampoObrigatorioException,
	EngenheiroNaoEncontradoException, SQLException {
		Engenheiro e = null;
		
		try{
			engenheiros = (ArrayList<Engenheiro>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!engenheiros.isEmpty()){
				for(Engenheiro engenheiro: engenheiros){
					if(cpf.equals(engenheiro.getCpf())){
						return engenheiro;
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
	EngenheiroNaoEncontradoException, SQLException {
		try{
			engenheiros = (ArrayList<Engenheiro>) objectInputStream.readObject();
			
			for(Engenheiro engenheiro : engenheiros){
				if(cpf.equals(engenheiro.getCpf())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(Engenheiro engenheiro : engenheiros){
				if(cpf.equals(engenheiro.getCpf())){
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
	public ArrayList<Engenheiro> listar() throws SQLException {
		try{
			engenheiros = (ArrayList<Engenheiro>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return engenheiros;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return engenheiros;
	}

	@Override
	public ArrayList<Engenheiro> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
