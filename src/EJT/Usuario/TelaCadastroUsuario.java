package EJT.Usuario;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import EJT.Atendente.TelaCadastroAtendente;
import EJT.Fachada.Fachada;
import EJT.Gerente.TelaCadastroGerente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Window.Type;

public class TelaCadastroUsuario {

	private static final JTextComponent VerificarSenha = null;
	public JFrame frmAcessoAoSistema;
	private JTextField CPF;
	private String cpfformatado;
	private JTextField textFieldNome;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario window = new TelaCadastroUsuario();
					window.frmAcessoAoSistema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAcessoAoSistema = new JFrame();
		frmAcessoAoSistema.setType(Type.UTILITY);
		frmAcessoAoSistema.setTitle("NOVO USUARIO");
		frmAcessoAoSistema.setBounds(100, 100, 611, 253);
		frmAcessoAoSistema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAcessoAoSistema.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(81, 44, 46, 14);
		frmAcessoAoSistema.getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(81, 15, 46, 14);
		frmAcessoAoSistema.getContentPane().add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(81, 72, 46, 14);
		frmAcessoAoSistema.getContentPane().add(lblSenha);
		
		JLabel lblVerificarSenha = new JLabel("Senha novamente:");
		lblVerificarSenha.setBounds(224, 72, 118, 14);
		frmAcessoAoSistema.getContentPane().add(lblVerificarSenha);
		
	
		
		
MaskFormatter formatarCPF;
		
		
		try {
			formatarCPF = new MaskFormatter("###.###.###-##");
			formatarCPF.setValidCharacters("0123456789");
			CPF = new JFormattedTextField(formatarCPF);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CPF.setText(null);
		CPF.setBounds(129, 12, 118, 20);
		frmAcessoAoSistema.getContentPane().add(CPF);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(129, 41, 215, 20);
		
		frmAcessoAoSistema.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(129, 69, 85, 20);
		frmAcessoAoSistema.getContentPane().add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setToolTipText("DIGITE SUA SENHA NOVAMENTE");
		passwordField2.setBounds(339, 69, 85, 20);
		frmAcessoAoSistema.getContentPane().add(passwordField2);
		cpfformatado = CPF.getText();
	
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.setToolTipText("COMFIRMAR");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/EJT/imagens/buttonComfirma.png")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(passwordField1.getText().equals("")){
					JOptionPane.showMessageDialog(frmAcessoAoSistema, "FAVOR DIGITE UMA SENHA");
				}
				if(textFieldNome.getText().equals("")){
					JOptionPane.showMessageDialog(frmAcessoAoSistema, "FAVOR DIGITE USUARIO");
				}
				if(!passwordField1.getText().equals(passwordField2.getText())){
JOptionPane.showMessageDialog(frmAcessoAoSistema, "Senhas Digitadas Diferentes");
}else{
					try {
						cadastrar();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frmAcessoAoSistema, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}

			private void cadastrar() throws Exception {

				Fachada fachada = Fachada.getInstance();
				String cpf = CPF.getText().replace(".", "").replace("-", "");
				String nome = textFieldNome.getText().toUpperCase();
				String senha = passwordField1.getText();
				
				Usuario usuario = new Usuario(nome, senha, cpf);	
				fachada.usuarioCadastrar(usuario);
				JOptionPane.showMessageDialog(frmAcessoAoSistema, "CADASTRO REALIZADO COM SUCESSO");
				limparcampos();
				frmAcessoAoSistema.dispose();
				
				
			}

			private void limparcampos() {

				CPF.setText("");
				textFieldNome.setText("");
				passwordField1.setText("");
				passwordField2.setText("");
			}
		});
		btnCadastrar.setBounds(349, 104, 75, 23);
		frmAcessoAoSistema.getContentPane().add(btnCadastrar);
		
		JButton btnGerente = new JButton("Buscar Gerente");
		btnGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fachada = Fachada.getInstance();
				String cpf = CPF.getText().replace("-","").replace(".", "");
				String senha = null;
				try {
					fachada.gerenteProcurar(cpf);
					textFieldNome.setText(fachada.gerenteProcurar(cpf).getNome());
					fachada.gerenteProcurar(cpf).getCpf();
					if(passwordField1.getText().equals(passwordField2.getText())){
						 senha = passwordField1.getText();		
					}
					String nome = textFieldNome.getText();

					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frmAcessoAoSistema, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);

				}
				
			}
		});
		btnGerente.setBounds(257, 11, 140, 23);
		frmAcessoAoSistema.getContentPane().add(btnGerente);
		
		JButton btnAtendente = new JButton("Buscar Atendente ");
		btnAtendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fachada = Fachada.getInstance();
				String cpf = CPF.getText().replace("-", "").replace(".", "");
				String senha = null;
				
				try {
					fachada.getInstance().atendenteProcurar(cpf);
					textFieldNome.setText(fachada.atendenteProcurar(cpf).getNome());
					fachada.atendenteProcurar(cpf).getCpf();
					if(passwordField1.getText().equals(passwordField2.getText())){
						 senha = passwordField1.getText();					 

						 
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frmAcessoAoSistema, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAtendente.setBounds(407, 11, 145, 23);
		frmAcessoAoSistema.getContentPane().add(btnAtendente);
		
		JButton btnNovoGerente = new JButton("Novo Gerente");
		btnNovoGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroGerente window = new TelaCadastroGerente();
				window.frmCadastroGerente.setVisible(true);
			}
		});
		btnNovoGerente.setBounds(117, 150, 130, 23);
		frmAcessoAoSistema.getContentPane().add(btnNovoGerente);
		
		JButton btnNovoAtendente = new JButton("Novo Atendente");
		btnNovoAtendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAtendente window = new TelaCadastroAtendente();
				window.frmCadastroAtendente.setVisible(true);
			}
		});
		btnNovoAtendente.setBounds(313, 150, 130, 23);
		frmAcessoAoSistema.getContentPane().add(btnNovoAtendente);
		
		lblNewLabel = new JLabel("a");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/EJT/imagens/fundoteste.jpg")));
		lblNewLabel.setBounds(0, 0, 609, 214);
		frmAcessoAoSistema.getContentPane().add(lblNewLabel);
		
		
	
	}
}
