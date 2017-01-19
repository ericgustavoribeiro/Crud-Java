package EJT.Arquiteto;

import java.util.ArrayList;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

public class Arquiteto {

	private int id_arquiteto;
	private String nome;
	private String cau; //cau conselho de arquitetura e urbanismo
	private String cpf;
	private String rg;
	private String disponibilidade;
	
	private Endereco endereco;
	private Contato contato;
	
	public Arquiteto(String nome, String cau, String cpf,
			String rg, String disponibilidade,
			Endereco endereco, Contato contato) {

		
		this.nome = nome;
		this.cau = cau;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
	
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Arquiteto(int id_arquiteto, String nome, String cau, String cpf,
			String rg, String disponibilidade,  String logradouro, String numero, String bairro,String  cidade, String estado, String email) {
		
		
		this.nome = nome;
		this.id_arquiteto = id_arquiteto;
		this.cau = cau;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		
		this.contato = contato;
		this.endereco = endereco;

	}
	
	public Arquiteto(int id_arquiteto, String nome, String cau, String cpf,
			String rg, String disponibilidade,  Endereco endereco, Contato contato) {
		
		this.id_arquiteto = id_arquiteto;
		this.nome = nome;
		this.cau = cau;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
		
		this.contato = contato;
		this.endereco =  endereco;

	}
	
	public Arquiteto(int id_arquiteto, String nome, String cau, String cpf,
			String rg, String disponibilidade) {
		
		this.id_arquiteto = id_arquiteto;
		this.nome = nome;
		this.cau = cau;
		this.cpf = cpf;
		this.rg = rg;
		this.disponibilidade = disponibilidade;
	

	}


	public Arquiteto() {
		// TODO Auto-generated constructor stub
	}

	public int getId_arquiteto() {
		return id_arquiteto;
	}

	public void setId_arquiteto(int id_arquiteto) {
		this.id_arquiteto = id_arquiteto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCau() {
		return cau;
	}

	public void setCau(String cau) {
		this.cau = cau;
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
		return "Arquiteto [id_arquiteto=" + id_arquiteto + ", nome=" + nome
				+ ", cau=" + cau + ", cpf=" + cpf + ", rg=" + rg + ", status="
				+ disponibilidade + ", endereco="
				+ endereco + ", contato=" + contato + "]";
	}
	
	
	
	
	
}
