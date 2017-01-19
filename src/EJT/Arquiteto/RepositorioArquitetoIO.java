package EJT.Arquiteto;


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
import java.util.logging.Level;
import java.util.logging.Logger;




public class RepositorioArquitetoIO implements IRepositorioArquiteto{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<Arquiteto> arquitetos = new ArrayList<Arquiteto>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioArquitetoIO() {
		
	try{
			
			file = new File("C:/temp/arquiteto.txt");
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
	public void Cadastrar(Arquiteto arquiteto)
			throws ArquitetoJaCadastradoException, CampoObrigatorioException,
			SQLException {
		try{
		arquitetos = (ArrayList<Arquiteto>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				arquitetos.add(arquiteto);
				objectOutputStream.writeObject(arquitetos);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(Arquiteto arquiteto)
			throws CampoObrigatorioException, ArquitetoNaoEncontradoException,
			SQLException {
		
		try{
			arquitetos = (ArrayList<Arquiteto>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(Arquiteto a : arquitetos){
				if(arquiteto.getCpf().equals(a.getCpf())){
				arquitetos.remove(a);
				arquitetos.add(arquiteto);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(arquitetos);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	ArquitetoNaoEncontradoException, SQLException {
		try{
			arquitetos = (ArrayList<Arquiteto>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(Arquiteto arquiteto : arquitetos){
				if(cpf.equals(arquiteto.getCpf())){
					arquitetos.remove(arquiteto);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(arquitetos);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public Arquiteto procurar(String cpf) throws CampoObrigatorioException,
	ArquitetoNaoEncontradoException, SQLException {
		Arquiteto a = null;
		
		try{
			arquitetos = (ArrayList<Arquiteto>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!arquitetos.isEmpty()){
				for(Arquiteto arquiteto: arquitetos){
					if(cpf.equals(arquiteto.getCpf())){
						return arquiteto;
					}
				}
			}
		}catch (FileNotFoundException erro){
			
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
		return a;
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
	ArquitetoNaoEncontradoException, SQLException {
		try{
			arquitetos = (ArrayList<Arquiteto>) objectInputStream.readObject();
			
			for(Arquiteto arquiteto : arquitetos){
				if(cpf.equals(arquiteto.getCpf())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(Arquiteto arquiteto : arquitetos){
				if(cpf.equals(arquiteto.getCpf())){
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
	public ArrayList<Arquiteto> listar() throws SQLException {
		try{
			arquitetos = (ArrayList<Arquiteto>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return arquitetos;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return arquitetos;
	}

	@Override
	public ArrayList<Arquiteto> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
