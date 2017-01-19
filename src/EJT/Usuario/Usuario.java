package EJT.Usuario;

public class Usuario {

	private int idUsuario;
	private String nome;
	private String senha;
	private String cpf;
	
	public Usuario(String nome, String senha, String cpf ){
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		
	}

	public Usuario(int idUsuairo, String nome, String senha, String cpf) {
		this.idUsuario = idUsuairo;
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String toString(){
		return "Usuario [idUsuario=" +idUsuario+" Nome : " +nome + "senha: " + senha + "CPF: "+cpf +"]";
	}
	
}
