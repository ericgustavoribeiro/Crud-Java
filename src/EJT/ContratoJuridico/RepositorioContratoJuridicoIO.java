package EJT.ContratoJuridico;

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



public class RepositorioContratoJuridicoIO implements IRepositorioContratoJuridico{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<ContratoJuridico> contratos = new ArrayList<ContratoJuridico>();
	
	public RepositorioContratoJuridicoIO() {
		
	try{
			
			file = new File("C:/temp/contratoJuridico.txt");
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
	public void cadastrar(ContratoJuridico contratoJuridico)
			throws CampoObrigatorioException, SQLException {
		// TODO Auto-generated method stub
		try{
			contratos = (ArrayList<ContratoJuridico>) objectInputStream.readObject();
			
			}catch (EOFException erro){
				try{
					contratos.add(contratoJuridico);
					objectOutputStream.writeObject(contratos);
			}catch (IOException erro2){
				
			}
			}catch (ClassNotFoundException erro2){
				
			}catch (IOException erro3){
				
			}
	}

	@Override
	public void atualizar(ContratoJuridico contratoJuridico)
			throws ContratoNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
		try{
			contratos = (ArrayList<ContratoJuridico>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(ContratoJuridico c : contratos){
				if(contratoJuridico.getIdContrato() == c.getIdContrato()){
					contratos.remove(c);
					contratos.add(contratoJuridico);
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
	public void remover(int idContrato) throws ContratoNaoEncontradoException,
			SQLException {
		// TODO Auto-generated method stub
		try{
			contratos = (ArrayList<ContratoJuridico>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(ContratoJuridico contrato : contratos){
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
	

	@Override
	public ContratoJuridico procurar(int idContrato)
			throws ContratoNaoEncontradoException, SQLException {
		// TODO Auto-generated method stub
	ContratoJuridico c = null;
		
		try{
			contratos = (ArrayList<ContratoJuridico>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!contratos.isEmpty()){
				for(ContratoJuridico contrato: contratos){
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
	public ArrayList<ContratoJuridico> listar() throws SQLException {
		// TODO Auto-generated method stub
		try{
			contratos = (ArrayList<ContratoJuridico>) objectInputStream.readObject();
			
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
	public ArrayList<ContratoJuridico> listar(String complemento)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
