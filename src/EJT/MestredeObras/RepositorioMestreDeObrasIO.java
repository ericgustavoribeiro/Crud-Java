package EJT.MestredeObras;

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



public class RepositorioMestreDeObrasIO implements IRepositorioMestreDeObras{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<MestreDeObras> mestres = new ArrayList<MestreDeObras>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioMestreDeObrasIO() {
		
	try{
			
			file = new File("C:/temp/mestre.txt");
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
	public void Cadastrar(MestreDeObras mestre)
			throws MestreDeObrasJaCadastradoException, CampoObrigatorioException,
			SQLException {
		try{
		mestres = (ArrayList<MestreDeObras>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				mestres.add(mestre);
				objectOutputStream.writeObject(mestres);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(MestreDeObras mestre)
			throws CampoObrigatorioException, MestreDeObrasNaoEncontradoException,
			SQLException {
		
		try{
			mestres = (ArrayList<MestreDeObras>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(MestreDeObras m : mestres){
				if(mestre.getCpf().equals(m.getCpf())){
				mestres.remove(m);
				mestres.add(mestre);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(mestres);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	MestreDeObrasNaoEncontradoException, SQLException {
		try{
			mestres = (ArrayList<MestreDeObras>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(MestreDeObras mestre : mestres){
				if(cpf.equals(mestre.getCpf())){
					mestres.remove(mestre);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(mestres);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public MestreDeObras procurar(String cpf) throws CampoObrigatorioException,
	MestreDeObrasNaoEncontradoException, SQLException {
		MestreDeObras m = null;
		
		try{
			mestres = (ArrayList<MestreDeObras>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!mestres.isEmpty()){
				for(MestreDeObras mestre: mestres){
					if(cpf.equals(mestre.getCpf())){
						return mestre;
					}
				}
			}
		}catch (FileNotFoundException erro){
			
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
		return m;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	MestreDeObrasNaoEncontradoException, SQLException {
		try{
			mestres = (ArrayList<MestreDeObras>) objectInputStream.readObject();
			
			for(MestreDeObras jardineiro : mestres){
				if(cpf.equals(jardineiro.getCpf())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(MestreDeObras mestre : mestres){
				if(cpf.equals(mestre.getCpf())){
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
	public ArrayList<MestreDeObras> listar() throws SQLException {
		try{
			mestres = (ArrayList<MestreDeObras>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return mestres;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return mestres;
	}

	@Override
	public ArrayList<MestreDeObras> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
