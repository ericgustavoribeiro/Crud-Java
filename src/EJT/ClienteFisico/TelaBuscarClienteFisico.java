package EJT.ClienteFisico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import EJT.Util.teclasPermitidas;

import java.awt.Window.Type;

public class TelaBuscarClienteFisico extends JFrame {

	Fachada fachada = Fachada.getInstance();
	ClienteFisico clienteFisico;
	Contato contato;
	Endereco endereco;
	
	public JFrame frmBuscarClienteFisico;
	private JTextField textFieldCpf;
	private JTextField textFieldNome;
	private JTextField textFieldRG;
	private JTextField textFieldEmail;
	private JTextField textFieldNumero;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldCEP;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldTel;
	private JTextField textFieldCel;
	private JTextField textFieldDisponibilidade;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarClienteFisico window = new TelaBuscarClienteFisico();
					window.frmBuscarClienteFisico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarClienteFisico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarClienteFisico = new JFrame();
		frmBuscarClienteFisico.setType(Type.UTILITY);
		frmBuscarClienteFisico.getContentPane().setBackground(Color.WHITE);
		frmBuscarClienteFisico.setTitle("BUSCAR CLIENTE FISICO");
		frmBuscarClienteFisico.setBounds(100, 100, 556, 431);
		frmBuscarClienteFisico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarClienteFisico.getContentPane().setLayout(null);
		
		frmBuscarClienteFisico.setUndecorated(true);
	    frmBuscarClienteFisico.setLocationRelativeTo(null); 
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(114, 30, 38, 14);
		frmBuscarClienteFisico.getContentPane().add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(162, 27, 138, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldCpf.getText();
			try {
				
				Fachada.getInstance().clienteFisicoProcurar(cpf);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldNome.setText(fachada.clienteFisicoProcurar(cpf).getNome().toUpperCase());
				textFieldCpf.setText(fachada.clienteFisicoProcurar(cpf).getCpf());
				textFieldRG.setText(fachada.clienteFisicoProcurar(cpf).getRg());
			
				
				
				textFieldEmail.setText(fachada.clienteFisicoProcurar(cpf).getContato().getEmail());
				textFieldCel.setText(fachada.clienteFisicoProcurar(cpf).getContato().getCelular());
				textFieldTel.setText(fachada.clienteFisicoProcurar(cpf).getContato().getTelefone());
				
				
				textFieldRua.setText(fachada.clienteFisicoProcurar(cpf).getEndereco().getLogradouro().toUpperCase());
				textFieldBairro.setText(fachada.clienteFisicoProcurar(cpf).getEndereco().getBairro().toUpperCase());
				textFieldNumero.setText(fachada.clienteFisicoProcurar(cpf).getEndereco().getNumero());
				textFieldCEP.setText(fachada.clienteFisicoProcurar(cpf).getEndereco().getCep().toUpperCase());
				textFieldCidade.setText(fachada.clienteFisicoProcurar(cpf).getEndereco().getCidade().toUpperCase());
				textFieldEstado.setText(fachada.clienteFisicoProcurar(cpf).getEndereco().getEstado().toUpperCase());
				
				
				
				
				
			} catch (CPFInvalidoException e) {
				JOptionPane.showMessageDialog(frmBuscarClienteFisico, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e) {
				JOptionPane.showMessageDialog(frmBuscarClienteFisico, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (ClienteNaoEncontradoException e){
				JOptionPane.showMessageDialog(frmBuscarClienteFisico, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e) {	
				JOptionPane.showMessageDialog(frmBuscarClienteFisico, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e){
				JOptionPane.showMessageDialog(frmBuscarClienteFisico, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} 
		
				
			}
		});
		btnBuscar.setBounds(310, 26, 89, 23);
		frmBuscarClienteFisico.getContentPane().add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(54, 142, 46, 14);
		frmBuscarClienteFisico.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 139, 175, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(54, 114, 46, 14);
		frmBuscarClienteFisico.getContentPane().add(lblRg);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(114, 111, 86, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldRG);
		textFieldRG.setColumns(10);
		textFieldRG.setDocument(new teclasPermitidas());

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(54, 173, 46, 14);
		frmBuscarClienteFisico.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(110, 170, 384, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(54, 239, 46, 14);
		frmBuscarClienteFisico.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(54, 274, 46, 14);
		frmBuscarClienteFisico.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(54, 308, 46, 14);
		frmBuscarClienteFisico.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(338, 239, 146, 14);
		frmBuscarClienteFisico.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(358, 236, 136, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 540, 56);
		frmBuscarClienteFisico.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frmBuscarClienteFisico.dispose();
			}
		});
		btnSair.setBounds(419, 17, 74, 23);
		panel.add(btnSair);
		
		JButton btnGerarArquivo = new JButton("Excluir");
		btnGerarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frmBuscarClienteFisico, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().clienteFisicoRemover(cpf);
						Fachada fachada = Fachada.getInstance();
						JOptionPane.showMessageDialog(frmBuscarClienteFisico, "Removido com Sucesso!");
					
					} catch (CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (ClienteNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {	
						JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					} 
				
				}

				
			
			}
		});
		

		btnGerarArquivo.setToolTipText("gerar um arquivo texto para imprimir");
		btnGerarArquivo.setBounds(301, 17, 108, 23);
		panel.add(btnGerarArquivo);
		
		JButton btnNewButtonAlterar = new JButton("Alterar");
		btnNewButtonAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cpf = textFieldCpf.getText();
					Fachada fachada = Fachada.getInstance();
					ClienteFisico clienteFisico = fachada.clienteFisicoProcurar(cpf);
					Endereco endereco = clienteFisico.getEndereco();
					Contato contato = clienteFisico.getContato();
					
					clienteFisico.setNome(textFieldNome.getText());
					clienteFisico.setRg(textFieldRG.getText());
					
					endereco.setLogradouro(textFieldRua.getText());
					endereco.setNumero(textFieldNumero.getText());
					endereco.setBairro(textFieldBairro.getText());
					endereco.setCidade(textFieldCidade.getText());
					endereco.setEstado(textFieldEstado.getText());
					endereco.setCep(textFieldCEP.getText());
					clienteFisico.setEndereco(endereco);
					
					contato.setEmail(textFieldEmail.getText());
					contato.setTelefone(textFieldTel.getText());
					contato.setCelular(textFieldCel.getText());
					clienteFisico.setContato(contato);
					fachada.clienteFisicoAtualizar(clienteFisico);
				
				
					
				} catch (CPFInvalidoException e1) {
					JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (ClienteNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {	
					JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} catch (Throwable e1) {
					JOptionPane.showMessageDialog(frmBuscarClienteFisico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} 
				}
			
				
		});
		btnNewButtonAlterar.setBounds(136, 17, 123, 23);
		panel.add(btnNewButtonAlterar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroClienteFisico window = new TelaCadastroClienteFisico();
				window.frmCadastroClienteFisico.setVisible(true);
			}
		});
		btnNovo.setBounds(10, 17, 89, 23);
		panel.add(btnNovo);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 236, 222, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(110, 271, 175, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(292, 274, 46, 14);
		frmBuscarClienteFisico.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(348, 271, 146, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(110, 305, 222, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(338, 308, 146, 14);
		frmBuscarClienteFisico.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(358, 305, 136, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(64, 198, 46, 14);
		frmBuscarClienteFisico.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(110, 195, 103, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 198, 46, 14);
		frmBuscarClienteFisico.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(251, 195, 115, 20);
		frmBuscarClienteFisico.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		
//		JLabel lblDisponibilidade = new JLabel("Disponibilidade: ");
//		lblDisponibilidade.setBounds(71, 79, 106, 27);
//		frmBuscarClienteFisico.getContentPane().add(lblDisponibilidade);
//		
//		textFieldDisponibilidade = new JTextField();
//		textFieldDisponibilidade.setHorizontalAlignment(SwingConstants.CENTER);
//		textFieldDisponibilidade.setForeground(new Color(34, 139, 34));
//	
//		textFieldDisponibilidade.setFont(new Font("Tahoma", Font.BOLD, 14));
//		textFieldDisponibilidade.setBackground(SystemColor.activeCaption);
//		textFieldDisponibilidade.setBounds(172, 79, 138, 27);
//		frmBuscarClienteFisico.getContentPane().add(textFieldDisponibilidade);
//		textFieldDisponibilidade.setColumns(10);
//		
		
		JPanel panelBuscarCpf = new JPanel();
		panelBuscarCpf.setBounds(93, 11, 324, 56);
		frmBuscarClienteFisico.getContentPane().add(panelBuscarCpf);
		
	
	}
}
