package EJT.MestredeObras;

import java.util.ArrayList;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

public class MestreDeObras {

	private int id_mestre;
	private String nome;
	private String cpf;
	private String rg;
	private String disponibilidade;
	private Endereco endereco;
	private Contato contato;
	
	
	public MestreDeObras(String nome, String cpf, String rg,
			String disponibilidade,
			Endereco endereco, Contato contato) {
	
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public MestreDeObras(String nome, String cpf, String rg,
			String disponibilidade) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		
	}
	
	
	public MestreDeObras(int id_mestre, String nome, String cpf, String rg,
			String disponibilidade,
			Endereco endereco,Contato contato) {
	
		this.id_mestre = id_mestre; 
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public MestreDeObras(int id_mestre_de_obras, String nome, String cpf, String rg,
			String disponibilidade) {
	
		this.id_mestre = id_mestre_de_obras; 
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		
	}
	
	public MestreDeObras(int id_mestre_de_obras, String nome, String cpf, String rg,
			String disponibilidade, String logradouro, String numero, String bairro,
			String cidade, String estado, String cep, String email, String telefone, String celular) {
	
		this.id_mestre = id_mestre_de_obras; 
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

	public MestreDeObras() {
		// TODO Auto-generated constructor stub
	}

	public int getId_mestre() {
		return id_mestre;
	}

	public void setId_mestre_de_obras(int id_mestre) {
		this.id_mestre = id_mestre;
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

	public void setId_mestre(int id_mestre) {
		this.id_mestre = id_mestre;
	}

	@Override
	public String toString() {
		return "MestreDeObras [id_mestre=" + id_mestre + ", nome=" + nome
				+ ", cpf=" + cpf + ", rg=" + rg + ", disponibilidade="
				+ disponibilidade + ", endereco=" + endereco + ", contato="
				+ contato + "]";
	}

}
