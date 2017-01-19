package EJT.Eletricista;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

public class Eletricista {
	private int id_eletricista;
	private String nome;
	private String cpf;
	private String rg;
	private String disponibilidade;
	private Endereco endereco;
	private Contato contato;
	
	public Eletricista(int id_eletricista, String nome, String cpf, String rg,
			String disponibilidade, Endereco endereco, Contato contato) {
		super();
		this.id_eletricista = id_eletricista;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Eletricista(String nome, String cpf, String rg,
			String disponibilidade, Endereco endereco, Contato contato) {
		super();
	
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	
	public Eletricista(int id_eletricista, String nome, String cpf, String rg,
			String disponibilidade, String logradouro, String numero, String bairro,
			String cidade, String estado, String cep, String email, String telefone, String celular) {
	
		this.id_eletricista = id_eletricista; 
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
	
	
	
	
	
	
	
	
	
	public Eletricista() {
		// TODO Auto-generated constructor stub
	}

	public int getId_eletricista() {
		return id_eletricista;
	}
	public void setId_eletricista(int id_eletricista) {
		this.id_eletricista = id_eletricista;
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
		return "Eletricista [id_eletricista=" + id_eletricista + ", nome="
				+ nome + ", cpf=" + cpf + ", rg=" + rg + ", disponibilidade="
				+ disponibilidade + ", endereco=" + endereco + ", contato="
				+ contato + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
