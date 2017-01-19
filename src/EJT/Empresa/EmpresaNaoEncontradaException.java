package EJT.Empresa;

public class EmpresaNaoEncontradaException extends Exception {

	public EmpresaNaoEncontradaException(){
		super("Empresa Não Encontrada");
	}
}
