package EJT.Atendente;

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

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import EJT.Util.teclasPermitidas;

public class TelaBuscarAtendente {

	public JFrame frmBuscarAtendente;
	private JTextField textFieldCpf;
	Fachada fachada;
	Atendente atendente;
	Contato contato;
	Endereco endereco;
	
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


	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarAtendente window = new TelaBuscarAtendente();
					window.frmBuscarAtendente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarAtendente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarAtendente= new JFrame();
		frmBuscarAtendente.getContentPane().setBackground(Color.WHITE);
		frmBuscarAtendente.setTitle("BUSCAR ATENDENTE");
		frmBuscarAtendente.setBounds(100, 100, 556, 431);
		frmBuscarAtendente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarAtendente.getContentPane().setLayout(null);
		
		frmBuscarAtendente.setUndecorated(true);
		frmBuscarAtendente.setLocationRelativeTo(null); 
		
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(114, 30, 38, 14);
		frmBuscarAtendente.getContentPane().add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(162, 27, 138, 20);
		frmBuscarAtendente.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldCpf.getText();
			try {
				
				Fachada.getInstance().atendenteProcurar(cpf);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldNome.setText(fachada.atendenteProcurar(cpf).getNome().toUpperCase());
				textFieldCpf.setText(fachada.atendenteProcurar(cpf).getCpf());
				textFieldRG.setText(fachada.atendenteProcurar(cpf).getRg());
			
				JOptionPane.showMessageDialog(frmBuscarAtendente, "Código do Atendente\n" + fachada.atendenteProcurar(cpf).getId_atendente());
			
				
				textFieldEmail.setText(fachada.atendenteProcurar(cpf).getContato().getEmail());
				textFieldCel.setText(fachada.atendenteProcurar(cpf).getContato().getCelular());
				textFieldTel.setText(fachada.atendenteProcurar(cpf).getContato().getTelefone());
				
				
				textFieldRua.setText(fachada.atendenteProcurar(cpf).getEndereco().getLogradouro().toUpperCase());
				textFieldBairro.setText(fachada.atendenteProcurar(cpf).getEndereco().getBairro().toUpperCase());
				textFieldNumero.setText(fachada.atendenteProcurar(cpf).getEndereco().getNumero());
				textFieldCEP.setText(fachada.atendenteProcurar(cpf).getEndereco().getCep().toUpperCase());
				textFieldCidade.setText(fachada.atendenteProcurar(cpf).getEndereco().getCidade().toUpperCase());
				textFieldEstado.setText(fachada.atendenteProcurar(cpf).getEndereco().getEstado().toUpperCase());
				
				
				
				
				
			} catch (EJT.Atendente.CPFInvalidoException e) {
				JOptionPane.showMessageDialog(frmBuscarAtendente, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (EJT.Atendente.CampoObrigatorioException e) {
				JOptionPane.showMessageDialog(frmBuscarAtendente, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (AtendenteNaoEncontradoException e){
				JOptionPane.showMessageDialog(frmBuscarAtendente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(frmBuscarAtendente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e){
				JOptionPane.showMessageDialog(frmBuscarAtendente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		
				
			}
		});
		btnBuscar.setBounds(310, 26, 89, 23);
		frmBuscarAtendente.getContentPane().add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(54, 115, 46, 14);
		frmBuscarAtendente.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 112, 175, 20);
		frmBuscarAtendente.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(54, 87, 46, 14);
		frmBuscarAtendente.getContentPane().add(lblRg);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(110, 84, 86, 20);
		frmBuscarAtendente.getContentPane().add(textFieldRG);
		textFieldRG.setColumns(10);
		textFieldRG.setDocument(new teclasPermitidas());

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(54, 146, 46, 14);
		frmBuscarAtendente.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(110, 143, 394, 20);
		frmBuscarAtendente.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(54, 212, 46, 14);
		frmBuscarAtendente.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(54, 252, 46, 14);
		frmBuscarAtendente.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(54, 292, 46, 14);
		frmBuscarAtendente.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(342, 212, 24, 14);
		frmBuscarAtendente.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(376, 209, 136, 20);
		frmBuscarAtendente.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 540, 56);
		frmBuscarAtendente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBuscarAtendente.dispose();
			}
		});
		btnSair.setBounds(456, 17, 74, 23);
		panel.add(btnSair);
		
		
		
		JButton btnRemoverAtendente = new JButton("REMOVER ATENDENTE");
		btnRemoverAtendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frmBuscarAtendente, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().atendenteRemover(cpf);
						Fachada fachada = Fachada.getInstance();
					} catch (EJT.Atendente.CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frmBuscarAtendente, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (EJT.Atendente.CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarAtendente, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (AtendenteNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarAtendente, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarAtendente, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarAtendente, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				
				
				}

				
			
			}
		});
		
		
		btnRemoverAtendente.setBounds(109, 17, 173, 23);
		panel.add(btnRemoverAtendente);
		
		JButton btnAtualizar = new JButton("ATUALIZAR DADOS ");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String cpf = textFieldCpf.getText();
					Fachada fachada = Fachada.getInstance();
					Atendente atendente = fachada.atendenteProcurar(cpf);
					Endereco endereco = atendente.getEndereco();
					Contato contato = atendente.getContato();
					
					atendente.setNome(textFieldNome.getText());
					atendente.setRg(textFieldRG.getText());
					
					endereco.setLogradouro(textFieldRua.getText());
					endereco.setNumero(textFieldNumero.getText());
					endereco.setBairro(textFieldBairro.getText());
					endereco.setCidade(textFieldCidade.getText());
					endereco.setEstado(textFieldEstado.getText());
					endereco.setCep(textFieldCEP.getText());
					atendente.setEndereco(endereco);
					
					contato.setEmail(textFieldEmail.getText());
					contato.setTelefone(textFieldTel.getText());
					contato.setCelular(textFieldCel.getText());
					atendente.setContato(contato);
					
					fachada.atendenteAtualizar(atendente);
				} catch (EJT.Atendente.CPFInvalidoException e1) {
					JOptionPane.showMessageDialog(frmBuscarAtendente, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (EJT.Atendente.CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarAtendente, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (AtendenteNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarAtendente, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarAtendente, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarAtendente, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			
			
			
			}
		});
		btnAtualizar.setBounds(297, 17, 149, 23);
		panel.add(btnAtualizar);
		
		JButton btnNewButton = new JButton("NOVO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastroAtendente window = new TelaCadastroAtendente();
				window.frmCadastroAtendente.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 17, 89, 23);
		panel.add(btnNewButton);
		
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 209, 222, 20);
		frmBuscarAtendente.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(110, 252, 175, 20);
		frmBuscarAtendente.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(300, 252, 38, 14);
		frmBuscarAtendente.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(368, 249, 146, 20);
		frmBuscarAtendente.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(110, 289, 320, 20);
		frmBuscarAtendente.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(440, 292, 30, 14);
		frmBuscarAtendente.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(474, 289, 38, 20);
		frmBuscarAtendente.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(64, 174, 46, 14);
		frmBuscarAtendente.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(110, 171, 103, 20);
		frmBuscarAtendente.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 174, 46, 14);
		frmBuscarAtendente.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(251, 171, 115, 20);
		frmBuscarAtendente.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		
	
		
		
		JPanel panelBuscarCpf = new JPanel();
		panelBuscarCpf.setBounds(93, 11, 324, 56);
		frmBuscarAtendente.getContentPane().add(panelBuscarCpf);
		
	
		
		
		

	}
}
