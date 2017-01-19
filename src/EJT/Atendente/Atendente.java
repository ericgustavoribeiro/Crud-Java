package EJT.Atendente;

import java.util.ArrayList;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;


public class Atendente {

	private int id_atendente;
	private String nome;
	private String cpf;
	private String rg;
	private Endereco endereco;
	private Contato contato;
	
	
	public Atendente(String nome, String cpf, String rg,
		 Endereco endereco, Contato contato) {

		
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Atendente(String nome, String cpf, String rg) {

		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	
	}
	
	public Atendente(int id_funcionario, String nome, String cpf, String rg,
			 Endereco endereco, Contato contato) {

		this.id_atendente = id_atendente;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Atendente(int id_funcionario, String nome, String cpf, String rg) {

		this.id_atendente = id_atendente;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;


	}
	
	
	public Atendente(int id_atendente, String nome,  String cpf,
			String rg,  String logradouro, String numero, String bairro,
			String cidade, String estado, String cep, String email, String telefone, String celular) {

		this.id_atendente = id_atendente;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
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

	public Atendente() {
		// TODO Auto-generated constructor stub
	}

	public int getId_atendente() {
		return id_atendente;
	}

	public void setId_atendente(int id_atendente) {
		this.id_atendente = id_atendente;
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
		return "Atendente [id_atendente=" + id_atendente + ", nome="
				+ nome + ", cpf=" + cpf + ", rg=" + rg +  ", endereco=" + endereco + ", contato=" + contato + "]";
	}




	
}
