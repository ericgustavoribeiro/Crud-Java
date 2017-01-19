package EJT.Arquiteto;

import java.awt.EventQueue;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Engenheiro.Engenheiro;
import EJT.Fachada.Fachada;
import EJT.Util.teclasPermitidas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.TextEvent;

import javax.swing.JSpinner;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JComboBox;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class TelaBuscarArquiteto {

	private JFrame frame;
	public JFrame frmBuscarArquiteto;
	private JTextField textFieldCpf;
	Fachada fachada;
	Arquiteto arquiteto;
	Contato contato;
	Endereco endereco;
	
	private JTextField textFieldNome;
	private JTextField textFieldCAU;
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

	JLabel textFieldDisponibilidade = new JLabel("---------");
	
	public JComboBox comboBoxdDisponibilidade;
	private String disponibilidade[] = {"DISPONIVEL", "OCUPADO"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarArquiteto window = new TelaBuscarArquiteto();
					window.frmBuscarArquiteto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarArquiteto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarArquiteto = new JFrame();
		frmBuscarArquiteto.setType(Type.UTILITY);
		frmBuscarArquiteto.getContentPane().setBackground(Color.WHITE);
		frmBuscarArquiteto.setTitle("BUSCAR ARQUITETO");
		frmBuscarArquiteto.setBounds(100, 100, 556, 431);
		frmBuscarArquiteto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarArquiteto.getContentPane().setLayout(null);
		
		
		frmBuscarArquiteto.setUndecorated(true);
	    frmBuscarArquiteto.setLocationRelativeTo(null); 
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(114, 30, 38, 14);
		frmBuscarArquiteto.getContentPane().add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(162, 27, 138, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
				String cpf = textFieldCpf.getText();
				Fachada.getInstance().arquitetoProcurar(cpf);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldNome.setText(fachada.arquitetoProcurar(cpf).getNome().toUpperCase());
				textFieldCAU.setText(fachada.arquitetoProcurar(cpf).getCau());
				textFieldCpf.setText(fachada.arquitetoProcurar(cpf).getCpf());
				textFieldRG.setText(fachada.arquitetoProcurar(cpf).getRg());
				
				if(fachada.arquitetoProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
					textFieldDisponibilidade.setForeground(Color.RED);
				}else{
					textFieldDisponibilidade.setForeground(Color.GREEN);
				}
				textFieldDisponibilidade.setText(fachada.arquitetoProcurar(cpf).getDisponibilidade().toUpperCase());
				
				
				textFieldEmail.setText(fachada.arquitetoProcurar(cpf).getContato().getEmail());
				textFieldCel.setText(fachada.arquitetoProcurar(cpf).getContato().getCelular());
				textFieldTel.setText(fachada.arquitetoProcurar(cpf).getContato().getTelefone());
				
				
				textFieldRua.setText(fachada.arquitetoProcurar(cpf).getEndereco().getLogradouro().toUpperCase());
				textFieldBairro.setText(fachada.arquitetoProcurar(cpf).getEndereco().getBairro().toUpperCase());
				textFieldNumero.setText(fachada.arquitetoProcurar(cpf).getEndereco().getNumero());
				textFieldCEP.setText(fachada.arquitetoProcurar(cpf).getEndereco().getCep().toUpperCase());
				textFieldCidade.setText(fachada.arquitetoProcurar(cpf).getEndereco().getCidade().toUpperCase());
				textFieldEstado.setText(fachada.arquitetoProcurar(cpf).getEndereco().getEstado().toUpperCase());
				
				
				
				
				
			} catch (CPFInvalidoException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (ArquitetoNaoEncontradoException e){
				JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e){
				JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			
			}
		});
		btnBuscar.setBounds(310, 26, 89, 23);
		frmBuscarArquiteto.getContentPane().add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(54, 142, 46, 14);
		frmBuscarArquiteto.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 139, 175, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCrea = new JLabel("CAU: ");
		lblCrea.setBounds(54, 117, 46, 14);
		frmBuscarArquiteto.getContentPane().add(lblCrea);
		
		textFieldCAU = new JTextField();
		textFieldCAU.setBounds(110, 111, 86, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldCAU);
		textFieldCAU.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(206, 117, 46, 14);
		frmBuscarArquiteto.getContentPane().add(lblRg);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(246, 111, 120, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldRG);
		textFieldRG.setColumns(10);
		textFieldRG.setDocument(new teclasPermitidas());

		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(54, 173, 46, 14);
		frmBuscarArquiteto.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(110, 170, 384, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(54, 239, 46, 14);
		frmBuscarArquiteto.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(54, 274, 46, 14);
		frmBuscarArquiteto.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(54, 308, 46, 14);
		frmBuscarArquiteto.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(338, 239, 146, 14);
		frmBuscarArquiteto.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(358, 236, 136, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 540, 56);
		frmBuscarArquiteto.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBuscarArquiteto.dispose();
			}
		});
		btnSair.setBounds(456, 11, 74, 34);
		panel.add(btnSair);
		
		JButton btnRemoverArquiteto = new JButton("REMOVER ARQUITETO");
		btnRemoverArquiteto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = JOptionPane.showConfirmDialog(
						frmBuscarArquiteto,
						"Deseja Excluir?\n" + textFieldNome.getText(),
						"Excluir", JOptionPane.YES_NO_CANCEL_OPTION);
				if (resultado == JOptionPane.YES_OPTION) {
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().arquitetoRemover(cpf);
						Fachada fachada = Fachada.getInstance();
					} catch (CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (ArquitetoNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (SQLException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}

				}

			}
		});

	
		btnRemoverArquiteto.setBounds(155, 17, 181, 23);
		panel.add(btnRemoverArquiteto);
		
		JButton btnApagar = new JButton("ATUALIZAR");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int resultado = JOptionPane.showConfirmDialog(
						frmBuscarArquiteto,
						"ATENÇÃO!!!"
						+ "\nConfirme antes a disponibilidade: " + comboBoxdDisponibilidade.getSelectedItem() +"\n"
								+ "\n"
								+ "Deseja Alterar os dados modificados?\n" ,
						"Alterar Dados", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(resultado == JOptionPane.YES_OPTION){

				try {
					String cpf = textFieldCpf.getText();
					
					
					Fachada fachada = Fachada.getInstance();
					Arquiteto arquiteto = fachada.arquitetoProcurar(cpf);
					Endereco endereco = arquiteto.getEndereco();
					Contato contato = arquiteto.getContato();
					
					arquiteto.setNome(textFieldNome.getText());
					arquiteto.setCau(textFieldCAU.getText());
					arquiteto.setRg(textFieldRG.getText());
					arquiteto.setDisponibilidade((String) comboBoxdDisponibilidade.getSelectedItem());
					
					endereco.setLogradouro(textFieldRua.getText());
					endereco.setNumero(textFieldNumero.getText());
					endereco.setBairro(textFieldBairro.getText());
					endereco.setCidade(textFieldCidade.getText());
					endereco.setEstado(textFieldEstado.getText());
					endereco.setCep(textFieldCEP.getText());
					arquiteto.setEndereco(endereco);
					
					contato.setEmail(textFieldEmail.getText());
					contato.setTelefone(textFieldTel.getText());
					contato.setCelular(textFieldCel.getText());
					arquiteto.setContato(contato);
					
			
					fachada.arquitetoAtualizar(arquiteto);

				} catch (CPFInvalidoException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (ArquitetoNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}


			}
			}
		});
		btnApagar.setBounds(346, 17, 100, 23);
		panel.add(btnApagar);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroArquiteto window = new TelaCadastroArquiteto();
				window.frmCadastroArquiteto.setVisible(true);
				
			}
		});
		btnNovo.setBounds(22, 17, 89, 23);
		panel.add(btnNovo);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 236, 222, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(110, 271, 175, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(292, 274, 46, 14);
		frmBuscarArquiteto.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(348, 271, 146, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(110, 305, 279, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(399, 308, 32, 14);
		frmBuscarArquiteto.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(441, 305, 53, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(64, 201, 46, 14);
		frmBuscarArquiteto.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(110, 198, 103, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 201, 46, 14);
		frmBuscarArquiteto.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(251, 198, 115, 20);
		frmBuscarArquiteto.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		
	
		
	
		
		JLabel lblDisponibilidade = new JLabel("Disponibilidade: ");
		lblDisponibilidade.setBounds(107, 78, 95, 27);
		frmBuscarArquiteto.getContentPane().add(lblDisponibilidade);
		
		
		JPanel panelBuscarCpf = new JPanel();
		panelBuscarCpf.setBounds(93, 11, 324, 56);
		frmBuscarArquiteto.getContentPane().add(panelBuscarCpf);
		textFieldDisponibilidade.setForeground(Color.BLACK);
		textFieldDisponibilidade.setBackground(Color.BLACK);
		textFieldDisponibilidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldDisponibilidade.setBounds(197, 82, 103, 14);
		frmBuscarArquiteto.getContentPane().add(textFieldDisponibilidade);
		
		comboBoxdDisponibilidade = new JComboBox(disponibilidade);
		comboBoxdDisponibilidade.setBounds(323, 81, 95, 20);
		frmBuscarArquiteto.getContentPane().add(comboBoxdDisponibilidade);
		



		
	
		
		
		

	}
}
