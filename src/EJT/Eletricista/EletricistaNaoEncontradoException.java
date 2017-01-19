package EJT.Eletricista;

public class EletricistaNaoEncontradoException extends Exception {

	public EletricistaNaoEncontradoException(){
		super ("Eletricista não foi encontrado");
	}
}
