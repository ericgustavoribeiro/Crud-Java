package EJT.Empresa;

public class CNPJInvalidoException extends Exception{

	String cnpj;

	public CNPJInvalidoException(String cnpj) {
		super("CNPJ : " + cnpj +" é nulo ou invalido !");
		// TODO Auto-generated constructor stub
	}
	
	
	
}
