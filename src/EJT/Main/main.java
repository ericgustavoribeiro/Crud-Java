package EJT.Main;

import javax.swing.JOptionPane;


import EJT.Fachada.Fachada;

import EJT.Usuario.Usuario;

public class main {

	
	private static String cpf;
	private static String senha;
	private static String nome;
	public static void main(String[] args) throws Exception {
		
		
		cpf = "77997336249";
		Fachada fachada = Fachada.getInstance();
		if(fachada.atendenteProcurar(cpf)!=null){
			nome = fachada.atendenteProcurar(cpf).getNome();
		    senha = JOptionPane.showInputDialog("DIGITE SENHA");
		    String nsenha = JOptionPane.showInputDialog("DIGITE SUA SENHA NOVAMENTE");
		    if(senha.equals(nsenha)){
				Usuario usuario = new Usuario(nome, senha, cpf);
			    usuario.setCpf(cpf);
				usuario.setSenha(senha);
				fachada.usuarioCadastrar(usuario);			
		    }else{
		    	JOptionPane.showMessageDialog(null, "Senha digitada errada");
		    }
		}else if(fachada.gerenteProcurar(cpf)!=null){
			nome = fachada.gerenteProcurar(cpf).getNome();
		    senha = JOptionPane.showInputDialog("DIGITE SENHA");
	        String nsenha = JOptionPane.showInputDialog("DIGITE SUA SENHA NOVAMENTE");
	    if(senha.equals(nsenha)){
	    	Usuario usuario = new Usuario(nome, senha, cpf);
	    	usuario.setNome(nome);
	    	usuario.setSenha(senha);
	    	fachada.usuarioCadastrar(usuario);
	    	JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO!");
	    }
			
			
		}
		
		
		
	//	System.out.println(fachada.usuarioProcurar(cpf));
	//	Usuario usuario = fachada.usuarioProcurar(cpf);
//		
//		usuario.setNome("ERIC");
//		usuario.setSenha("123456789");
//		fachada.usuarioAtualizar(usuario);
//		
//		System.out.println(usuario.toString());

		
		
//		TelaLogin window = new TelaLogin();
//		window.frmLogin.setVisible(true);
//				
	
	}


}
