package EJT.ClienteJuridico;
//ok
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


public class RepositorioClienteJuridicoIO implements IRepositorioClienteJuridico{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<ClienteJuridico> juridicos = new ArrayList<ClienteJuridico>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioClienteJuridicoIO() {
		
	try{
			
			file = new File("C:/temp/ClienteJuridico.txt");
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
	public void cadastrar(ClienteJuridico juridico)
			throws CampoObrigatorioException, ClienteJuridicoJaCadastradoException, SQLException {
		try{
		juridicos = (ArrayList<ClienteJuridico>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				juridicos.add(juridico);
				objectOutputStream.writeObject(juridicos);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(ClienteJuridico juridico)
			throws CampoObrigatorioException, ClienteJuridicoNaoEncontradoException,
			SQLException {
		
		try{
			juridicos = (ArrayList<ClienteJuridico>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(ClienteJuridico c : juridicos){
				if(juridico.getCnpj().equals(c.getCnpj())){
					juridicos.remove(c);
					juridicos.add(juridico);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(juridicos);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cnpj) throws CampoObrigatorioException,
	ClienteJuridicoNaoEncontradoException, SQLException {
		try{
			juridicos = (ArrayList<ClienteJuridico>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(ClienteJuridico juridico : juridicos){
				if(cnpj.equals(juridico.getCnpj())){
					juridicos.remove(juridico);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(juridicos);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public ClienteJuridico procuarar(String cnpj) throws CampoObrigatorioException,
	ClienteJuridicoNaoEncontradoException, SQLException {
		ClienteJuridico c = null;
		
		try{
			juridicos = (ArrayList<ClienteJuridico>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!juridicos.isEmpty()){
				for(ClienteJuridico juridico: juridicos){
					if(cnpj.equals(juridico.getCnpj())){
						return juridico;
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
	public boolean existe(String cnpj) throws CampoObrigatorioException,
	ClienteJuridicoNaoEncontradoException, SQLException {
		try{
			juridicos = (ArrayList<ClienteJuridico>) objectInputStream.readObject();
			
			for(ClienteJuridico juridico : juridicos){
				if(cnpj.equals(juridico.getCnpj())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(ClienteJuridico juridico : juridicos){
				if(cnpj.equals(juridico.getCnpj())){
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
	public ArrayList<ClienteJuridico> listar() throws SQLException {
		try{
			juridicos = (ArrayList<ClienteJuridico>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return juridicos;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return juridicos;
	}

	@Override
	public ArrayList<ClienteJuridico> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
