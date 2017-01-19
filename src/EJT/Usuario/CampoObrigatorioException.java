package EJT.Usuario;

public class CampoObrigatorioException extends Exception {

	public CampoObrigatorioException(){
		super("Campo Obrigatório Vazio!");
	}
}
