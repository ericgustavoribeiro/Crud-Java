package EJT.Atendente;

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


import EJT.Atendente.CampoObrigatorioException;
import EJT.Atendente.Atendente;
import EJT.Atendente.AtendenteNaoEncontradoException;
import EJT.Atendente.Atendente;
import EJT.Atendente.AtendenteNaoEncontradoException;


public class RepositorioAtendenteIO implements IRepositorioAtendente{

	private static File file;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static ArrayList<Atendente> atendentes = new ArrayList<Atendente>();
	
	
	public static void recuperar(){
		
	
	}	
	public RepositorioAtendenteIO() {
		
	try{
			
			file = new File("C:/temp/atendente.txt");
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
	public void Cadastrar(Atendente atendente)
			throws AtendenteJaCadastradoException, CampoObrigatorioException,
			SQLException {
		try{
		atendentes = (ArrayList<Atendente>) objectInputStream.readObject();
		
		}catch (EOFException erro){
			try{
				atendentes.add(atendente);
				objectOutputStream.writeObject(atendentes);
		}catch (IOException erro2){
			
		}
		}catch (ClassNotFoundException erro2){
			
		}catch (IOException erro3){
			
		}
		
	}

	@Override
	public void atualizar(Atendente atendente)
			throws CampoObrigatorioException, AtendenteNaoEncontradoException,
			SQLException {
		
		try{
			atendentes = (ArrayList<Atendente>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			for(Atendente a : atendentes){
				if(atendente.getCpf().equals(a.getCpf())){
					atendentes.remove(a);
					atendentes.add(atendente);
				break;
				}
			}
		try{
			objectOutputStream.writeObject(atendentes);
		}catch (IOException erro1){
			
		}
		
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
	}

	@Override
	public void remover(String cpf) throws CampoObrigatorioException,
	AtendenteNaoEncontradoException, SQLException {
		try{
			atendentes = (ArrayList<Atendente>) objectInputStream.readObject();
			
		}catch(EOFException erro){
			for(Atendente atendente : atendentes){
				if(cpf.equals(atendente.getCpf())){
					atendentes.remove(atendente);
					break;
				}
			}
		try{
			objectOutputStream.writeObject(atendentes);
		}catch(IOException erro1){
			
		}
		}catch (IOException erro2){
			
		}catch (ClassNotFoundException erro3){
			
		}
		
	}

	@Override
	public Atendente procurar(String cpf) throws CampoObrigatorioException,
	AtendenteNaoEncontradoException, SQLException {
		Atendente a = null;
		
		try{
			atendentes = (ArrayList<Atendente>) objectInputStream.readObject();
				
		}catch (EOFException erro){
			if(!atendentes.isEmpty()){
				for(Atendente atendente: atendentes){
					if(cpf.equals(atendente.getCpf())){
						return atendente;
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
	AtendenteNaoEncontradoException, SQLException {
		try{
			atendentes = (ArrayList<Atendente>) objectInputStream.readObject();
			
			for(Atendente atendente : atendentes){
				if(cpf.equals(atendente.getCpf())){
					return true;
				}
			}
		}catch (EOFException erro){
			for(Atendente atendente : atendentes){
				if(cpf.equals(atendente.getCpf())){
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
	public ArrayList<Atendente> listar() throws SQLException {
		try{
			atendentes = (ArrayList<Atendente>) objectInputStream.readObject();
			
		}catch (EOFException erro){
			return atendentes;
		}catch (FileNotFoundException erro1) {
			
		}catch (IOException erro2) {
			// TODO: handle exception
		}catch (ClassNotFoundException erro3) {
			// TODO: handle exception
		}
		
		return atendentes;
	}

	@Override
	public ArrayList<Atendente> listar(String complemento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

