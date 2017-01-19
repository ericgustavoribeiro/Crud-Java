package EJT.Gerente;

public class GerenteJaCadastradoException extends Exception {

	public GerenteJaCadastradoException(String msg){
		super ("Gerente já Cadastrado");
	}
}
