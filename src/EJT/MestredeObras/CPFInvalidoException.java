package EJT.MestredeObras;

public class CPFInvalidoException extends Exception {

	public CPFInvalidoException(String cpf) {
		super("CPF : " + cpf + "� nulo ou invalido !!!");
		
	}

}
