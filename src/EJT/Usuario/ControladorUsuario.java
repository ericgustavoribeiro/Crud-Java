package EJT.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.ClienteFisico.CPFInvalidoException;
import EJT.Empresa.CampoObricatorioException;
import EJT.Util.Validacao;

public class ControladorUsuario {
	IRepositorioUsuario repositorioUsuario;
	
	public ControladorUsuario() throws Exception {
		this.repositorioUsuario = new RepositorioUsuarioBDR();
		
	}
	public void cadastrar(Usuario usuario) throws CPFInvalidoException, CampoObricatorioException, UsuarioJaCadastradoException, SQLException {
		if(!Validacao.validaCPF(usuario.getCpf())) throw new CPFInvalidoException(usuario.getCpf());
		if(usuario.getNome().equals("")==true) throw new CampoObricatorioException();
		if(this.repositorioUsuario.existe(usuario.getCpf())) throw new UsuarioJaCadastradoException();
		
		this.repositorioUsuario.cadastrar(usuario);
	}

	public void remover(String cpf) throws CPFInvalidoException, UsuarioNaoEncontrado, SQLException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		Usuario usuario = null;
		
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		usuario = this.repositorioUsuario.procurar(cpf);
		this.repositorioUsuario.remover(cpf);
	}
	public Usuario procurar(String cpf) throws UsuarioNaoEncontrado, CPFInvalidoException, SQLException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		return this.repositorioUsuario.procurar(cpf);
	}
	
	public void atualizar(Usuario usuario) throws CampoObrigatorioException, SQLException, UsuarioNaoEncontrado{
		if(!Validacao.validaCPF(usuario.getCpf()));
		if(usuario.getNome().equals("")==true) throw new CampoObrigatorioException();
		this.repositorioUsuario.atualizar(usuario);
	}
	
	public ArrayList<Usuario> listar() throws SQLException{
	return this.repositorioUsuario.listar();
}

}
