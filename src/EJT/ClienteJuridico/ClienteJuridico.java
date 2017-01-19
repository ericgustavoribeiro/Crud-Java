package EJT.ClienteJuridico;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

public class ClienteJuridico {

	private int id_juridico;
	private String nome;
	private String cnpj;
	private String inscricao_estadual;
	private Endereco endereco;
	private Contato contato;
	
	public ClienteJuridico(String nome, String cnpj, String inscricao_estadual, Endereco endereco, Contato contato) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricao_estadual = inscricao_estadual;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public ClienteJuridico(String nome, String cnpj, String inscricao_estadual) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricao_estadual = inscricao_estadual;

	}
	
	public ClienteJuridico(int id_juridico, String nome, String cnpj,
			String inscricao_estadual, Endereco endereco, Contato contato) {
		this.id_juridico = id_juridico;
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricao_estadual = inscricao_estadual;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public ClienteJuridico(int id_juridico, String nome, String cnpj,
			String inscricao_estadual) {
		this.id_juridico = id_juridico;
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricao_estadual = inscricao_estadual;
	}
	
	public ClienteJuridico(int id_juridico, String nome, String cnpj,
			String inscricao_estadual, String logradouro, String numero, String bairro,
			String cidade, String estado, String cep, String email, String telefone, String celular) {
		this.id_juridico = id_juridico;
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricao_estadual = inscricao_estadual;
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

	
	public ClienteJuridico() {
		// TODO Auto-generated constructor stub
	}

	public int getId_juridico() {
		return id_juridico;
	}

	public void setId_clienteJuridico(int id_juridico) {
		this.id_juridico = id_juridico;
	}

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricao_estadual() {
		return inscricao_estadual;
	}

	public void setInscricao_estadual(String inscricao_estadual) {
		this.inscricao_estadual = inscricao_estadual;
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
		return "ClienteJuridico [id_clienteJuridico=" + id_juridico
				+ ", cnpj=" + cnpj + ", inscricao_estadual="
				+ inscricao_estadual + ", endereco=" + endereco + ", contato="
				+ contato + "]";
	}

	
	
}
