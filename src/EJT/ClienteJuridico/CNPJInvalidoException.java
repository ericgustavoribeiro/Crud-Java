package EJT.ClienteJuridico;

public class CNPJInvalidoException extends Exception {

	public CNPJInvalidoException(String cnpj) {
		super("CNPJ : " + cnpj + "é nulo ou invalido !!!");
		// TODO Auto-generated constructor stub
	}

}
