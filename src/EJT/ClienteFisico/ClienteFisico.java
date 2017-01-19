package EJT.ClienteFisico;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

public class ClienteFisico {

	private int id_clienteFisico;
	private String nome;	
	private String cpf;
	private String rg;
	private Endereco endereco;
	private Contato contato;
	
	
	
	public ClienteFisico(String nome, String cpf, String rg,
			Endereco endereco, Contato contato) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.contato = contato;
	}

	public ClienteFisico(String nome, String cpf, String rg) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	}

	public ClienteFisico(int id_clienteFisico, String nome, String cpf, String rg,
			Endereco endereco, Contato contato) {
		this.id_clienteFisico = id_clienteFisico;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.contato = contato;
	}

	public ClienteFisico(int id_clienteFisico, String nome, String cpf, String rg) {
		this.id_clienteFisico = id_clienteFisico;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	}

	public ClienteFisico(int id_clienteFisico, String nome, String cpf, String rg, String logradouro, String numero, String bairro,
			String cidade, String estado, String cep, String email, String telefone, String celular) {
		this.id_clienteFisico = id_clienteFisico;
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

	public ClienteFisico() {
		// TODO Auto-generated constructor stub
	}

	public int getId_clienteFisico() {
		return id_clienteFisico;
	}

	public void setId_clienteFisico(int id_clienteFisico) {
		this.id_clienteFisico = id_clienteFisico;
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
		return "ClienteFisico [id_clienteFisico=" + id_clienteFisico + ", cpf="
				+ cpf + ", rg=" + rg + ", endereco=" + endereco + ", contato="
				+ contato + "]";
	}

}
