package EJT.Usuario;

public class UsuarioJaCadastradoException extends Exception {
	
	public UsuarioJaCadastradoException(){
		super("Usuario já Cadastrado");
	}

}
