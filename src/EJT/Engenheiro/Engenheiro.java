package EJT.Engenheiro;

import java.util.ArrayList;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

public class Engenheiro {

	private int id_engenheiro;
	private String nome;
	private String crea;
	private String cpf;
	private String rg;

	private String disponibilidade;
	private Endereco endereco;
	private Contato contato;
	
	
	
	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	
	
	public Engenheiro(String nome, String crea, String cpf,
			String rg, String disponibilidade, 
			Endereco endereco, Contato contato) {

		this.nome = nome;
		this.crea = crea;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		
		this.endereco = endereco;
		this.contato = contato;
	}

	public Engenheiro(String nome, String crea, String cpf,
			String rg,String disponibilidade) {

		this.nome = nome;
		this.crea = crea;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		
	}
	
	public Engenheiro(int id_engenheiro, String nome, String crea, String cpf,
			String rg, String disponibilidade,
			Endereco endereco, Contato contato) {

		this.id_engenheiro = id_engenheiro;
		this.nome = nome;
		this.crea = crea;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Engenheiro(int id_engenheiro, String nome, String crea, String cpf,
			String rg,String disponibilidade) {

		this.id_engenheiro = id_engenheiro;
		this.nome = nome;
		this.crea = crea;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		
	}
	
	public Engenheiro(int id_engenheiro, String nome, String crea, String cpf,
			String rg,String disponibilidade, String logradouro, String numero, String bairro,
			String cidade, String estado, String cep, String email, String telefone, String celular) {

		this.id_engenheiro = id_engenheiro;
		this.nome = nome;
		this.crea = crea;
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
	
	public Engenheiro() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId_engenheiro() {
		return id_engenheiro;
	}
	public void setId_engenheiro(int id_engenheiro) {
		this.id_engenheiro = id_engenheiro;
	}
	public String getCrea() {
		return crea;
	}
	public void setCrea(String crea) {
		this.crea = crea;
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
		return "Engenheiro [id_engenheiro=" + id_engenheiro + ", nome=" + nome
				+ ", crea=" + crea + ", cpf=" + cpf + ", rg=" + rg
				+ ", status=" +  disponibilidade 
				+ ", endereco=" + endereco + ", contato=" + contato + "]";
	}

	
	
	
	
	
	
}
