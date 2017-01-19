package EJT.ClienteJuridico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import EJT.Atendente.AtendenteNaoEncontradoException;
import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import java.awt.Window.Type;

public class TelaBuscarClienteJuridico extends JFrame {

	private JPanel contentPane;

	Fachada fachada = Fachada.getInstance();
	ClienteJuridico clienteJuridico;
	Contato contato;
	Endereco endereco;
	
	public JFrame frmBuscarClienteJuridico;
	private JTextField textFieldCnpj;
	private JTextField textFieldNome;
	private JTextField textFieldInscricao;
	private JTextField textFieldEmail;
	private JTextField textFieldNumero;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldCEP;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldTel;
	private JTextField textFieldCel;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarClienteJuridico window = new TelaBuscarClienteJuridico();
					window.frmBuscarClienteJuridico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarClienteJuridico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarClienteJuridico = new JFrame();
		frmBuscarClienteJuridico.setType(Type.UTILITY);
		frmBuscarClienteJuridico.getContentPane().setBackground(Color.WHITE);
		frmBuscarClienteJuridico.setTitle("BUSCAR CLIENTE JURIDICO");
		frmBuscarClienteJuridico.setBounds(100, 100, 556, 431);
		frmBuscarClienteJuridico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarClienteJuridico.getContentPane().setLayout(null);
		
		frmBuscarClienteJuridico.setUndecorated(true);
		frmBuscarClienteJuridico.setLocationRelativeTo(null); 
		
		
		JLabel lblCnpj = new JLabel("CNPJ: ");
		lblCnpj.setBounds(114, 30, 38, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblCnpj);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setBounds(162, 27, 138, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnpj = textFieldCnpj.getText();
			try {
				
				Fachada.getInstance().clienteJuridicoProcurar(cnpj);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldNome.setText(fachada.clienteJuridicoProcurar(cnpj).getNome().toUpperCase());
				textFieldCnpj.setText(fachada.clienteJuridicoProcurar(cnpj).getCnpj());
				textFieldInscricao.setText(fachada.clienteJuridicoProcurar(cnpj).getInscricao_estadual());
			
				
				
				textFieldEmail.setText(fachada.clienteJuridicoProcurar(cnpj).getContato().getEmail());
				textFieldCel.setText(fachada.clienteJuridicoProcurar(cnpj).getContato().getCelular());
				textFieldTel.setText(fachada.clienteJuridicoProcurar(cnpj).getContato().getTelefone());
				
				
				textFieldRua.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getLogradouro().toUpperCase());
				textFieldBairro.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getBairro().toUpperCase());
				textFieldNumero.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getNumero());
				textFieldCEP.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getCep().toUpperCase());
				textFieldCidade.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getCidade().toUpperCase());
				textFieldEstado.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getEstado().toUpperCase());
				
				
			} catch (CNPJInvalidoException e1) {
				JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e1) {
				JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (ClienteJuridicoNaoEncontradoException e1){
				JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (SQLException e1) {
				JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e1){
				JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
				
			}
		});
		btnBuscar.setBounds(310, 26, 89, 23);
		frmBuscarClienteJuridico.getContentPane().add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(54, 142, 46, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 139, 175, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		
		
		JLabel lblInscricao = new JLabel("INSCRIÇÃO ESTADUAL:");
		lblInscricao.setBounds(54, 117, 159, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblInscricao);
		
		textFieldInscricao = new JTextField();
		textFieldInscricao.setBounds(192, 114, 108, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldInscricao);
		textFieldInscricao.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(54, 173, 46, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(110, 170, 384, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(54, 239, 46, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(54, 274, 46, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(54, 308, 46, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(338, 239, 146, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(358, 236, 136, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 540, 56);
		frmBuscarClienteJuridico.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBuscarClienteJuridico.dispose();
		
			}
		});
		btnSair.setBounds(419, 17, 74, 23);
		panel.add(btnSair);
		
		JButton btnGerarArquivo = new JButton("Excluir");
		btnGerarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frmBuscarClienteJuridico, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cnpj = textFieldCnpj.getText();
						Fachada.getInstance().clienteJuridicoRemover(cnpj);
						Fachada fachada = Fachada.getInstance();
						JOptionPane.showMessageDialog(frmBuscarClienteJuridico, "Removido com Sucesso!");
						
					} catch (CNPJInvalidoException e1) {
						JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (ClienteJuridicoNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}

				
			
			}
		});
		btnGerarArquivo.setToolTipText("gerar um arquivo texto para imprimir");
		btnGerarArquivo.setBounds(279, 17, 119, 23);
		panel.add(btnGerarArquivo);
		
		JButton btnNewButtonAlterar = new JButton("Alterar");
		btnNewButtonAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					String cnpj = textFieldCnpj.getText();
					Fachada fachada = Fachada.getInstance();
					ClienteJuridico clienteJuridico = fachada.clienteJuridicoProcurar(cnpj);
					Endereco endereco = clienteJuridico.getEndereco();
					Contato contato = clienteJuridico.getContato();
					
					clienteJuridico.setNome(textFieldNome.getText());
					clienteJuridico.setInscricao_estadual(textFieldInscricao.getText());
					
					endereco.setLogradouro(textFieldRua.getText());
					endereco.setNumero(textFieldNumero.getText());
					endereco.setBairro(textFieldBairro.getText());
					endereco.setCidade(textFieldCidade.getText());
					endereco.setEstado(textFieldEstado.getText());
					endereco.setCep(textFieldCEP.getText());
					clienteJuridico.setEndereco(endereco);
					
					contato.setEmail(textFieldEmail.getText());
					contato.setTelefone(textFieldTel.getText());
					contato.setCelular(textFieldCel.getText());
					clienteJuridico.setContato(contato);
					
					fachada.clienteJuridicoAtualizar(clienteJuridico);
					
				} catch (CNPJInvalidoException e1) {
					JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (ClienteJuridicoNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarClienteJuridico, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				
				}
			}
		});
		btnNewButtonAlterar.setBounds(142, 17, 104, 23);
		panel.add(btnNewButtonAlterar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroClienteJuridico window = new TelaCadastroClienteJuridico();
				window.frmCadastroClienteJuridico.setVisible(true);
			}
		});
		btnNovo.setBounds(25, 17, 89, 23);
		panel.add(btnNovo);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 236, 222, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(110, 271, 175, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(292, 274, 46, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(348, 271, 146, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(110, 305, 222, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(338, 308, 146, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(358, 305, 136, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(64, 198, 46, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(110, 195, 103, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 198, 46, 14);
		frmBuscarClienteJuridico.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(251, 195, 115, 20);
		frmBuscarClienteJuridico.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		

		
		JPanel panelBuscarCpf = new JPanel();
		panelBuscarCpf.setBounds(93, 11, 324, 56);
		frmBuscarClienteJuridico.getContentPane().add(panelBuscarCpf);
		
	
	}
}
