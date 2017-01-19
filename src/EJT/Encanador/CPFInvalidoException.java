package EJT.Encanador;

public class CPFInvalidoException extends Exception {

	public CPFInvalidoException(String cpf) {
		super("CPF : " + cpf + "é nulo ou invalido !!!");
		
	}


}
