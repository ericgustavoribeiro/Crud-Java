package EJT.Encanador;

import java.util.ArrayList;

import javax.swing.JTextField;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

public class Encanador {

	private int id_encanador;
	private String nome;
	private String cpf;
	private String rg;
	private String disponibilidade;
	private Endereco endereco;
	private Contato contato;
	
	
	
	public Encanador(String nome, String cpf, String rg,
			 String disponibilidade,
			Endereco endereco, Contato contato) {
	
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Encanador(String nome, String cpf, String rg,
			 String disponibilidade) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		
	}
	
	
	public Encanador(int encanador, String nome, String cpf, String rg,
			 String disponibilidade,
			Endereco endereco,Contato contato) {
	
		
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Encanador(int id_encanador, String nome, String cpf, String rg,
			String disponibilidade) {
	
		this.id_encanador = id_encanador; 
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		
	}

	
	
		public Encanador(int id_encanador, String nome, String cpf, String rg,
			String disponibilidade, String logradouro, String numero, String bairro,
			String cidade, String estado, String cep, String email, String telefone, String celular) {
	
		this.id_encanador = id_encanador; 
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		logradouro = logradouro;
		numero = numero;
		bairro = bairro;
		cidade = cidade;
		estado = estado;
		cep = cep;
		email = email;
		telefone = telefone;
		celular = celular;
		
	}
	
	public Encanador() {
			// TODO Auto-generated constructor stub
		}

	public int getId_encanador() {
		return id_encanador;
	}

	public void setId_encanador(int id_encanador) {
		this.id_encanador = id_encanador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}



	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}


	@Override
	public String toString() {
		return "Encanador [id_encanador=" + id_encanador + ", nome=" + nome
				+ ", cpf=" + cpf + ", rg=" + rg + ", status=" + disponibilidade
				+ ", endereco=" + endereco + ", contato=" + contato + "]";
	}


	


	
	
	
	
	
	

}
