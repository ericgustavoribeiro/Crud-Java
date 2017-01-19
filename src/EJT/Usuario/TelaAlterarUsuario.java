package EJT.Usuario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import EJT.Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Window.Type;

import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.Font;

public class TelaAlterarUsuario {

	public JFrame frmAlterarUsuario;
	private JTextField textFieldCpf;
	private JPasswordField passwordFieldAntigo;
	private JTextField textFieldNomeUsuario;
	private JLabel lblCpf;
	private JLabel lblNome;
	private JLabel lblSenhaAntiga;
	private JButton btnRemover;
	private JButton btnComfirmar;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarUsuario window = new TelaAlterarUsuario();
					window.frmAlterarUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAlterarUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlterarUsuario = new JFrame();
		frmAlterarUsuario.setType(Type.UTILITY);
		frmAlterarUsuario.setTitle("ALTERAR USUARIO");
		frmAlterarUsuario.setBounds(100, 100, 554, 236);
		frmAlterarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlterarUsuario.getContentPane().setLayout(null);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(147, 34, 177, 20);
		frmAlterarUsuario.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String cpf = textFieldCpf.getText();
				
				Fachada fachada = Fachada.getInstance();
				try {
					fachada.usuarioProcurar(cpf);
					textFieldNomeUsuario.setText(fachada.usuarioProcurar(cpf).getNome());
					
				} catch (Exception e1) {
                  JOptionPane.showMessageDialog(frmAlterarUsuario, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		btnBuscar.setBounds(334, 33, 119, 23);
		frmAlterarUsuario.getContentPane().add(btnBuscar);
		
		passwordFieldAntigo = new JPasswordField();
		passwordFieldAntigo.setBounds(147, 98, 177, 23);
		frmAlterarUsuario.getContentPane().add(passwordFieldAntigo);
		
		JButton btnValidar = new JButton("NOVA SENHA");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldCpf.getText().equals("")){
					JOptionPane.showMessageDialog(frmAlterarUsuario, "CAMPO CPF VAZIO");
				}else{
				    try {
				        Fachada fachada = Fachada.getInstance();
			    	    String cpf = textFieldCpf.getText();
						String senhatemp = passwordFieldAntigo.getText();
					if(fachada.usuarioProcurar(cpf).getSenha().equals(senhatemp)){
						
						String senhanova = JOptionPane.showInputDialog(frmAlterarUsuario,"DIGITE NOVA SENHA");
						String senhanovacomfirmar = JOptionPane.showInputDialog(frmAlterarUsuario, "REDIGITE SUA NOVA SENHA");
						if(senhanova.equals(senhanovacomfirmar)){
							usuario = fachada.usuarioProcurar(cpf);
							usuario.setSenha(senhanova);
						}else{
							JOptionPane.showMessageDialog(frmAlterarUsuario, "SENHA INCORRETA");
						}

					
//						fachada.usuarioAtualizar(usuario);
						
						}else{
							JOptionPane.showMessageDialog(frmAlterarUsuario, "SENHA INCORRETA");
						}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frmAlterarUsuario, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);

				}
					
				}
				
		 
				
				
			}
		});
		btnValidar.setBounds(334, 98, 119, 23);
		frmAlterarUsuario.getContentPane().add(btnValidar);
		
		textFieldNomeUsuario = new JTextField();
		textFieldNomeUsuario.setBounds(147, 65, 177, 20);
		frmAlterarUsuario.getContentPane().add(textFieldNomeUsuario);
		textFieldNomeUsuario.setColumns(10);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setForeground(SystemColor.text);
		lblCpf.setBounds(79, 37, 46, 14);
		frmAlterarUsuario.getContentPane().add(lblCpf);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(SystemColor.text);
		lblNome.setBounds(79, 68, 46, 14);
		frmAlterarUsuario.getContentPane().add(lblNome);
		
		lblSenhaAntiga = new JLabel("Senha Antiga:");
		lblSenhaAntiga.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenhaAntiga.setForeground(SystemColor.text);
		lblSenhaAntiga.setBounds(45, 107, 80, 14);
		frmAlterarUsuario.getContentPane().add(lblSenhaAntiga);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldCpf.getText();
				Fachada fachada = Fachada.getInstance();
				try {
					if(textFieldCpf.getText().equals("")){
						JOptionPane.showMessageDialog(frmAlterarUsuario, "BUSCAR PRIMEIRO UM USUARIO");
					}else{
						String senhatemp = JOptionPane.showInputDialog("Confirme a sua senha");
						if(fachada.usuarioProcurar(cpf).getSenha().equals(senhatemp)){
								fachada.usuarioRemover(cpf);
								JOptionPane.showMessageDialog(frmAlterarUsuario, "USUARIO REMOVIDO COM SUCESSO");	
						}else{
							JOptionPane.showMessageDialog(frmAlterarUsuario, "SENHA INCORRETA");
						}
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frmAlterarUsuario, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnRemover.setBounds(181, 152, 89, 23);
		frmAlterarUsuario.getContentPane().add(btnRemover);
		
		btnComfirmar = new JButton("Comfirmar");
		btnComfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.getInstance().usuarioAtualizar(usuario);
					JOptionPane.showMessageDialog(frmAlterarUsuario, "ALTERAÇÃO FEITA COM SUCESSO!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frmAlterarUsuario, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnComfirmar.setBounds(348, 152, 105, 23);
		frmAlterarUsuario.getContentPane().add(btnComfirmar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaAlterarUsuario.class.getResource("/EJT/imagens/fundoteste.jpg")));
		lblNewLabel.setBounds(0, 0, 538, 197);
		frmAlterarUsuario.getContentPane().add(lblNewLabel);
	}
}
