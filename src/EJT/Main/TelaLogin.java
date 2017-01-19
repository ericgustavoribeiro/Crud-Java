package EJT.Main;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import EJT.Fachada.Fachada;
import EJT.Usuario.Usuario;
import EJT.Util.teclasPermitidas;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JProgressBar;

import java.awt.SystemColor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.SwingConstants;

public class TelaLogin {

	public static String usuario;
	
	public JFrame frmLogin;
	private JTextField txtCpf;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() throws StringIndexOutOfBoundsException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws StringIndexOutOfBoundsException {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/EJT/imagens/senhaicone.png")));
		frmLogin.setTitle("LOGIN");
		frmLogin.getContentPane().setBackground(new Color(255, 69, 0));
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		frmLogin.setUndecorated(true);
	    frmLogin.setLocationRelativeTo(null);
		
		JLabel UsuarioLabel = new JLabel("");
		UsuarioLabel.setToolTipText("CPF DO USUARIO");
		UsuarioLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/EJT/imagens/usuarioicone.png")));
		UsuarioLabel.setBounds(49, 76, 63, 48);
		frmLogin.getContentPane().add(UsuarioLabel);
		
		txtCpf = new JTextField();
		txtCpf.setText("CPF");
		txtCpf.setToolTipText("DIGITE SEU CPF, APENAS NUMEROS");
		txtCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCpf.setBounds(118, 91, 249, 33);
		frmLogin.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		txtCpf.setDocument(new teclasPermitidas());

		
		JLabel lblSenha = new JLabel("");
		lblSenha.setToolTipText("SENHA");
		lblSenha.setIcon(new ImageIcon(TelaLogin.class.getResource("/EJT/imagens/senhaicone.png")));
		lblSenha.setBounds(49, 147, 62, 38);
		frmLogin.getContentPane().add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setToolTipText("DIGITE SUA SENHA");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(118, 147, 249, 33);
		frmLogin.getContentPane().add(passwordField);
		
		
		
		JButton btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon(TelaLogin.class.getResource("/EJT/imagens/buttonComfirma.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				
				if(txtCpf.getText().equals("")){
					JOptionPane.showMessageDialog(frmLogin, "Campo Obrigatório Vazio!"," ERRO ", JOptionPane.ERROR_MESSAGE);
				}else{
					try {
						login();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frmLogin, e.getMessage(), " ERRO ", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				
				
				
			}

			private void login() throws Exception, StringIndexOutOfBoundsException{

			String cpf = txtCpf.getText().replace("-", "").replace(".", "");
		   	String senha = passwordField.getText();
		    	Fachada fachada = Fachada.getInstance();
		    	
		    	String cpftempo = fachada.usuarioProcurar(cpf).getCpf();
		    	String senhatemp = fachada.usuarioProcurar(cpf).getSenha();
		   
		    	if(fachada.usuarioProcurar(cpf).getCpf().equals(cpftempo)){
		    		if(fachada.usuarioProcurar(cpf).getSenha().equals(senha)){
		    			usuario = fachada.usuarioProcurar(cpftempo).getNome();
		    			TelaPrincipal window = new TelaPrincipal();
		    			window.framePrincipal.setVisible(true);
		    			registroLogins();
		    			frmLogin.dispose();
		    			if(txtCpf.getText().equals("11111111111")){
		    				JOptionPane.showMessageDialog(frmLogin, "VOCÊ FEZ O LOGIN COMO USUARIO PADRÃO\nFAVOR MUDAR A SENHA NO PRIMEIRO ACESSO AO SISTEMA!");
		    			}
		    		}
		    		
		    		else{
		    		JOptionPane.showMessageDialog(frmLogin, "USUARIO ou SENHA\nINVALIDO");	
		    		}
		    	}
				
			}

			private void registroLogins() throws IOException {
				
				Calendar calendar = new GregorianCalendar();
				Date trialTime = new Date();
				calendar.setTime(trialTime);
				
				
				
				String caminho = "registro.txt";
				Path path = Paths.get(caminho);
				Charset utf8 = StandardCharsets.UTF_8;
				BufferedWriter escrever = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND);
				escrever.write("\nACESSO: " + calendar.getTime().toLocaleString()  + " NOME USUARIO: " + usuario);
				escrever.flush();//sempre usar flush
				escrever.close();//semrpe fechar aqruivo
			}
		});
		btnOk.setBounds(276, 191, 89, 23);
		frmLogin.getContentPane().add(btnOk);
		
		JLabel lblUsuarioPadroAdmin = new JLabel("CPF Padr\u00E3o: 11111111111 / Senha Padr\u00E3o: 12345");
		lblUsuarioPadroAdmin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuarioPadroAdmin.setBounds(86, 280, 286, 14);
		frmLogin.getContentPane().add(lblUsuarioPadroAdmin);
		
		JLabel lblAcessoAoSistema = new JLabel("ACESSO AO SISTEMA");
		lblAcessoAoSistema.setVerticalAlignment(SwingConstants.TOP);
		lblAcessoAoSistema.setBackground(SystemColor.window);
		lblAcessoAoSistema.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAcessoAoSistema.setBounds(145, 5, 175, 23);
		frmLogin.getContentPane().add(lblAcessoAoSistema);
		
		JLabel lblFechar = new JLabel("");
		lblFechar.setToolTipText("SAIR");
		lblFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		
		lblFechar.setIcon(new ImageIcon(TelaLogin.class.getResource("/EJT/imagens/botao_fechar.png")));
		lblFechar.setBounds(415, 25, 25, 33);
		frmLogin.getContentPane().add(lblFechar);
		
		JLabel fundotela = new JLabel("New label");
		fundotela.setIcon(new ImageIcon(TelaLogin.class.getResource("/EJT/imagens/fundoLoginTESTE.jpg")));
		fundotela.setBounds(0, 25, 450, 247);
		frmLogin.getContentPane().add(fundotela);
	}
}
