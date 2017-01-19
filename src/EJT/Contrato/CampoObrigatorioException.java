package EJT.Contrato;

public class CampoObrigatorioException extends Exception{
	
	public CampoObrigatorioException(){
		super("digite os campos obrigatorios");
	}

}
