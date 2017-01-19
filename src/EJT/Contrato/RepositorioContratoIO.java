package EJT.Contrato;

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



public class RepositorioContratoIO implements IRepositorioContrato{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<Contrato> contratos = new ArrayList<Contrato>();
	
	public RepositorioContratoIO() {
		
	try{
			
			file = new File("C:/temp/contrato.txt");
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
	public void cadastrarPF(Contrato contrato) throws SQLException {
		// TODO Auto-generated method stub
		try{
		contratos = (ArrayList<Contrato>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				contratos.add(contrato);
				objectOutputStream.writeObject(contratos);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
	}

	@Override
	public Contrato contratoProcurar(int idContrato) throws SQLException {
		// TODO Auto-generated method stub
	Contrato c = null;
		
		try{
			contratos = (ArrayList<Contrato>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!contratos.isEmpty()){
				for(Contrato contrato: contratos){
					if(idContrato == contrato.getIdContrato()){
						return contrato;
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
	public ArrayList<Contrato> listar() throws SQLException {
		// TODO Auto-generated method stub
		try{
			contratos = (ArrayList<Contrato>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return contratos;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return contratos;
	}

	@Override
	public ArrayList<Contrato> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Contrato contrato) throws SQLException {
		// TODO Auto-generated method stub
		try{
			contratos = (ArrayList<Contrato>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(Contrato c : contratos){
				if(contrato.getIdContrato() == c.getIdContrato()){
					contratos.remove(c);
					contratos.add(contrato);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(contratos);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(int idContrato) throws SQLException {
		// TODO Auto-generated method stub
		try{
			contratos = (ArrayList<Contrato>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(Contrato contrato : contratos){
				if(idContrato == contrato.getIdContrato()){
					contratos.remove(contrato);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(contratos);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

}
