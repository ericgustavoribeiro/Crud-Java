package EJT.Arquiteto;

public class CampoObrigatorioException extends Exception{

	public CampoObrigatorioException(){
		super ("preencha os campos obrigatorios");
	}
}
