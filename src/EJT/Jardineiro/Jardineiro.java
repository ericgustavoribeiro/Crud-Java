package EJT.Jardineiro;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

public class Jardineiro {

	private int id_jardineiro;
	private String nome;
	private String cpf;
	private String rg;
	private String disponibilidade;
	private Endereco endereco;
	private Contato contato;
	
	public Jardineiro(String nome, String cpf, String rg,
			String disponibilidade, Endereco endereco, Contato contato) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Jardineiro(String nome, String cpf, String rg,
			String disponibilidade) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
	}
	
	public Jardineiro(int id_jardineiro, String nome, String cpf, String rg,
			String disponibilidade, Endereco endereco, Contato contato) {
		this.id_jardineiro = id_jardineiro;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Jardineiro(int id_jardineiro, String nome, String cpf, String rg,
			String disponibilidade, String logradouro, String numero, String bairro,
			String cidade, String estado, String cep, String email, String telefone, String celular) {
		this.id_jardineiro = id_jardineiro;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
		this.contato = contato;
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
	
	public Jardineiro(int id_jardineiro, String nome, String cpf, String rg,
			String disponibilidade) {
		this.id_jardineiro = id_jardineiro;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
	}
	
	public Jardineiro() {
		// TODO Auto-generated constructor stub
	}

	public int getId_jardineiro() {
		return id_jardineiro;
	}
	public void setId_jardineiro(int id_jardineiro) {
		this.id_jardineiro = id_jardineiro;
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
		return "Jardineiro [id_jardineiro=" + id_jardineiro + ", nome=" + nome
				+ ", cpf=" + cpf + ", rg=" + rg + ", status=" + disponibilidade
				+ ", endereco=" + endereco + ", contato=" + contato + "]";
	}


	
	
}
