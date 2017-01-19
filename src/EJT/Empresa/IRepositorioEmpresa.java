package EJT.Empresa;
//ok
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioEmpresa <T, E>{

	public void Cadastrar(T objeto) throws CNPJInvalidoException, CampoObricatorioException, EmpresaJ·CadastradaException, SQLException;
	public Empresa procurar (E localizador) throws SQLException, EmpresaNaoEncontradaException, CampoObricatorioException;
	public void atualizar (T objeto)throws SQLException, EmpresaNaoEncontradaException, CampoObricatorioException ;
	public void remover(E localizador ) throws SQLException, EmpresaNaoEncontradaException;
	public boolean existe (E localizador) throws SQLException, EmpresaNaoEncontradaException;
	public ArrayList<T> listar() throws SQLException;
	public ArrayList<T> listar (String complemento) throws SQLException;
	public boolean existe() throws SQLException;
	
	
}
