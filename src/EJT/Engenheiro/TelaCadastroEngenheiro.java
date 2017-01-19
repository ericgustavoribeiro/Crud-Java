package EJT.Engenheiro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.text.MaskFormatter;
import javax.swing.JList;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;

import EJT.Arquiteto.Arquiteto;
import EJT.Atendente.AtendenteNaoEncontradoException;
import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import EJT.Util.teclasPermitidas;

import java.awt.Window.Type;

public class TelaCadastroEngenheiro {

	public JFrame frmCadastroEngenheiro;
	
	private JTextField textFieldCREA;
	private JTextField textFieldNOME;
	private JTextField textFieldLogradouro;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldEmail;
	private JTextField textFieldRG;
	private String selecao;
	private String cpfformatado;
	private String cepformatado;
	private String telformatado;
	private String celformatado;
	private JTextField TesteCPF;
	JFormattedTextField formattedTextFieldCEL = new JFormattedTextField();
	JFormattedTextField formattedDisponibilidade = new JFormattedTextField();
	JFormattedTextField TELs = new JFormattedTextField();
	JFormattedTextField CPF = new JFormattedTextField();
	JFormattedTextField CEP = new JFormattedTextField();
	   public JComboBox comboBoxEstado;

		private String estados[] = {"", "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEngenheiro window = new TelaCadastroEngenheiro();
					window.frmCadastroEngenheiro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroEngenheiro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroEngenheiro = new JFrame();
		frmCadastroEngenheiro.setType(Type.UTILITY);
		frmCadastroEngenheiro.getContentPane().setBackground(Color.WHITE);
		frmCadastroEngenheiro.setTitle("CADASTRO ENGENHEIRO");
		frmCadastroEngenheiro.setBounds(100, 100, 630, 414);
		frmCadastroEngenheiro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroEngenheiro.getContentPane().setLayout(null);
		
		frmCadastroEngenheiro.setUndecorated(true);
	    frmCadastroEngenheiro.setLocationRelativeTo(null); 
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(Color.WHITE);
		panelBotoes.setBounds(10, 331, 594, 41);
		frmCadastroEngenheiro.getContentPane().add(panelBotoes);
		panelBotoes.setLayout(null);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(SystemColor.activeCaption);
		btnLimpar.setBackground(SystemColor.inactiveCaptionBorder);
		btnLimpar.setIcon(new ImageIcon(TelaCadastroEngenheiro.class.getResource("/EJT/imagens/buttonLimpar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limparCampos();
				
			}


		});
		btnLimpar.setBounds(101, 11, 112, 23);
		panelBotoes.add(btnLimpar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(SystemColor.activeCaption);
		btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCancelar.setIcon(new ImageIcon(TelaCadastroEngenheiro.class.getResource("/EJT/imagens/buttonCancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frmCadastroEngenheiro.dispose();
				
			}
		});
		btnCancelar.setBounds(237, 11, 118, 23);
		panelBotoes.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					cadastrarArquiteto();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		
		});
		btnCadastrar.setForeground(SystemColor.activeCaption);
		btnCadastrar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroEngenheiro.class.getResource("/EJT/imagens/buttonComfirma.png")));
		btnCadastrar.setBounds(371, 11, 137, 23);
		panelBotoes.add(btnCadastrar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 27, 594, 293);
		frmCadastroEngenheiro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCAU = new JLabel("CREA: ");
		lblCAU.setBounds(0, 14, 46, 14);
		panel.add(lblCAU);
		
		textFieldCREA = new JTextField();
		textFieldCREA.setBounds(45, 11, 166, 20);
		panel.add(textFieldCREA);
		textFieldCREA.setColumns(10);
		
	
		
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(230, 11, 46, 14);
		panel.add(lblCpf);
	
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
		CPF.setBounds(267, 8, 118, 20);
		panel.add(CPF);
		cpfformatado = CPF.getText();
		
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(0, 64, 46, 14);
		panel.add(lblNome);
		
		textFieldNOME = new JTextField();
		textFieldNOME.setBounds(45, 61, 459, 20);
		panel.add(textFieldNOME);
		textFieldNOME.setColumns(10);
		
		JLabel lblRg = new JLabel("RG: ");
		lblRg.setBounds(10, 39, 46, 14);
		panel.add(lblRg);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 162, 594, 97);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogradouro = new JLabel("Rua:");
		lblLogradouro.setBounds(10, 11, 119, 14);
		panel_1.add(lblLogradouro);
		
		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setBounds(43, 8, 304, 20);
		panel_1.add(textFieldLogradouro);
		textFieldLogradouro.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(357, 11, 61, 14);
		panel_1.add(lblNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(428, 8, 75, 20);
		panel_1.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(0, 39, 61, 14);
		panel_1.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(43, 36, 125, 20);
		panel_1.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(172, 39, 46, 14);
		panel_1.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(215, 36, 207, 20);
		panel_1.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(431, 39, 40, 14);
		panel_1.add(lblUf);
		
		
		 comboBoxEstado = new JComboBox(estados);
			comboBoxEstado.setBounds(457, 39, 46, 20);
			panel_1.add(comboBoxEstado);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 64, 40, 20);
		panel_1.add(lblCep);
		MaskFormatter formatarCEP;
		
		try {
			formatarCEP = new MaskFormatter("#####-###");
			formatarCEP.setValidCharacters("0123456789");
			CEP = new JFormattedTextField(formatarCEP);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CEP.setBounds(42, 64, 126, 20);
		panel_1.add(CEP);
	
		
		cepformatado = CPF.getText();
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(241, 137, 65, 14);
		panel.add(lblEndereo);
		
		JLabel lblNewLabel = new JLabel("E-Mail: ");
		lblNewLabel.setBounds(0, 95, 46, 14);
		panel.add(lblNewLabel);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(45, 92, 186, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabelTels = new JLabel("Telefone: ");
		lblNewLabelTels.setBounds(241, 92, 65, 14);
		panel.add(lblNewLabelTels);
	
		JLabel lblDadosPessoais = new JLabel("Cadastro Engenheiro");
		lblDadosPessoais.setBounds(241, 11, 165, 14);
		frmCadastroEngenheiro.getContentPane().add(lblDadosPessoais);
		
	
		MaskFormatter formatarTEL;
		
		try {
			formatarTEL = new MaskFormatter("(##) ####-####");
			formatarTEL.setValidCharacters("0123456789");
			TELs = new JFormattedTextField(formatarTEL);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TELs.setBounds(303, 92, 118, 20);
		panel.add(TELs);
		
		JLabel lblCelular = new JLabel("Cel:");
		lblCelular.setBounds(430, 92, 46, 14);
		panel.add(lblCelular);
		
		MaskFormatter formatarCEL;
		
		try {
			
			
			formatarCEL = new MaskFormatter("(##) ####-####");
			formatarCEL.setValidCharacters("0123456789");
			formattedTextFieldCEL = new JFormattedTextField(formatarCEL);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		formattedTextFieldCEL.setBounds(454, 92, 118, 20);
		panel.add(formattedTextFieldCEL);
		
		MaskFormatter formatarDisponibilidade;
		try {
			formatarDisponibilidade = new MaskFormatter("#");
			formatarDisponibilidade.setValidCharacters("12");
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
		
		
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(45, 36, 166, 20);
		panel.add(textFieldRG);
		textFieldRG.setColumns(10);
		textFieldRG.setDocument(new teclasPermitidas());
		
		JLabel lblSair = new JLabel("sair");
		lblSair.setIcon(new ImageIcon(TelaCadastroEngenheiro.class.getResource("/EJT/imagens/botao_fechar.png")));
		lblSair.setBounds(569, 0, 25, 28);
		panel.add(lblSair);

	
		
	
		
	
		
	
		
		
				
	}
	private void limparCampos() {
		textFieldNOME.setText("");
		textFieldEmail.setText("");
		textFieldCREA.setText("");
		textFieldLogradouro.setText("");
		textFieldNumero.setText("");
		textFieldBairro.setText("");
		textFieldCidade.setText("");
		textFieldRG.setText("");
		formattedTextFieldCEL.setText("");
		formattedDisponibilidade.setText("");
		CPF.setText("");
		TELs.setText("");
		CEP.setText("");
		
		
			
	}
	
	private void cadastrarArquiteto() throws Exception {

		String disponibilidade = "DISPONIVEL";
	

		

		String nome = textFieldNOME.getText().toUpperCase();
		String crea = textFieldCREA.getText();
		String rg = textFieldRG.getText();
		String cep = CEP.getText().replace("-", "");
		String logradouro = textFieldLogradouro.getText();
		String numero = textFieldNumero.getText();
		String bairro = textFieldBairro.getText();
		String cidade = textFieldCidade.getText();
		
		String estado = (String) comboBoxEstado.getSelectedItem();


		String cpf = CPF.getText().replace(".", "").replace("-", "");
		
		String email = textFieldEmail.getText();
		String celular = formattedTextFieldCEL.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		String telefone = TELs.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		
	
		
		
		Contato contato = new Contato(email, telefone, celular);
		Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado, cep);
		Engenheiro engenheiro = new Engenheiro(nome, crea, cpf, rg, disponibilidade, endereco, contato);
		
		
	

		
		
		int resultado = JOptionPane.showConfirmDialog(
				frmCadastroEngenheiro,
				"OS DADOS INFORMADOS ESTÃO CORRETOS?\n\nNOME: "
						+ textFieldNOME.getText().toUpperCase() + "\n\nESPECIALIDADE: "
						
					
						+ "\n\nCONTATO: " + telefone + " / " + celular ,
				"COMFIRMAR CADASTRO", JOptionPane.YES_NO_OPTION);
try {
		if (resultado == JOptionPane.YES_OPTION) {
			Fachada.getInstance().engenheiroCadastrar(engenheiro);
			JOptionPane.showMessageDialog(frmCadastroEngenheiro, "Cadastro Realizado com sucesso!");
		}
		} catch (CPFInvalidoException e1) {
			JOptionPane.showMessageDialog(frmCadastroEngenheiro, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioException e1) {
			JOptionPane.showMessageDialog(frmCadastroEngenheiro, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
		} catch (EngenheiroJaCadastradoException e1){
			JOptionPane.showMessageDialog(frmCadastroEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(frmCadastroEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e1){
			JOptionPane.showMessageDialog(frmCadastroEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	
			
			limparCampos();
		}

	}

