package EJT.Empresa;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;

public class Empresa {

	private String nome_fantasia;
	private String razao_socia;
	private String cnpj;
	private String inscricao_estadual;
	private Endereco endereco;
	private Contato contato;
	
	
	public Empresa(String nome_fantasia, String cnpj, String razao_socia, 
			String inscricao_estadual) {
		super();
		this.nome_fantasia = nome_fantasia;
		this.razao_socia = razao_socia;
		this.cnpj = cnpj;
		this.inscricao_estadual = inscricao_estadual;

	}
	

	
	
	public Empresa(String nome_fantasia,  String cnpj, String razao_socia,
			String inscricao_estadual, Endereco endereco, Contato contato) {
		super();
		this.nome_fantasia = nome_fantasia;
		this.razao_socia = razao_socia;
		this.cnpj = cnpj;
		this.inscricao_estadual = inscricao_estadual;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Empresa( String nome_fantasia,String cnpj, String razao_socia, String inscricao_estadual,
			 String logradouro, String numero, String bairro,
			String cidade, String estado, String cep, String email, String telefone, String celular) {
	
		
		this.nome_fantasia = nome_fantasia;
		this.razao_socia = razao_socia;
		this.inscricao_estadual = inscricao_estadual;
		this.cnpj = cnpj;
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
	
	
	public Empresa() {
		// TODO Auto-generated constructor stub
	}




	public String getNome_fantasia() {
		return nome_fantasia;
	}
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	public String getRazao_socia() {
		return razao_socia;
	}
	public void setRazao_socia(String razao_socia) {
		this.razao_socia = razao_socia;
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
		return "Empresa [nome_fantasia=" + nome_fantasia + ", razao_socia="
				+ razao_socia + ", cnpj=" + cnpj + ", inscricao_estadual="
				+ inscricao_estadual + ", endereco=" + endereco + ", contato="
				+ contato + "]";
	}
	
	
	
	
	
	
	
	
	
}
