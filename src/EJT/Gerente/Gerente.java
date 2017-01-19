package EJT.Gerente;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

public class Gerente {
	
	private int id_gerente;
	private String nome;
	private String cpf;
	private String rg;
	private Endereco endereco;
	private Contato contato;
	
	public Gerente(String nome, String cpf, String rg,
			Endereco endereco, Contato contato) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Gerente(String nome, String cpf, String rg) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	}
	
	public Gerente(int id_gerente, String nome, String cpf, String rg,
			Endereco endereco, Contato contato) {
		this.id_gerente = id_gerente;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.contato = contato;
	}

	public Gerente(int id_gerente, String nome, String cpf, String rg) {
		this.id_gerente = id_gerente;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	}
	
	public Gerente(int id_gerente, String nome, String cpf, String rg,
			String logradouro, String numero, String bairro,
			String cidade, String estado, String cep, String email, String telefone, String celular) {
		this.id_gerente = id_gerente;
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
	
	public Gerente() {
		// TODO Auto-generated constructor stub
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getId_gerente() {
		return id_gerente;
	}

	public void setId_gerente(int id_gerente) {
		this.id_gerente = id_gerente;
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
		return "Gerente [id_gerente=" + id_gerente + ", nome=" + nome
				+ ", cpf=" + cpf + ", rg=" + rg + ", endereco=" + endereco
				+ ", contato=" + contato + "]";
	}


	

}
