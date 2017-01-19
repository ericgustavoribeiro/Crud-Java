package EJT.Jardineiro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import EJT.Util.teclasPermitidas;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroJardineiro extends JFrame {


	private JFrame frame;

	public JFrame frmCadastroJardineiro;
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
	JFormattedTextField TELs = new JFormattedTextField();
	JFormattedTextField CPF = new JFormattedTextField();
	JFormattedTextField CEP = new JFormattedTextField();
	

	   public JComboBox comboBoxEstado;

		private String estados[] = {"", "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};

	private EJT.Fachada.Fachada fachada;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroJardineiro window = new TelaCadastroJardineiro();
					window.frmCadastroJardineiro.setVisible(true);
				//teste
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroJardineiro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroJardineiro = new JFrame();
		frmCadastroJardineiro.setType(Type.UTILITY);
		frmCadastroJardineiro.getContentPane().setBackground(Color.WHITE);
		frmCadastroJardineiro.setTitle("CADASTRO JARDINEIRO");
		frmCadastroJardineiro.setBounds(100, 100, 630, 434);
		frmCadastroJardineiro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroJardineiro.getContentPane().setLayout(null);
		
		frmCadastroJardineiro.setUndecorated(true);
	    frmCadastroJardineiro.setLocationRelativeTo(null); 
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(Color.WHITE);
		panelBotoes.setBounds(10, 348, 594, 41);
		frmCadastroJardineiro.getContentPane().add(panelBotoes);
		panelBotoes.setLayout(null);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(SystemColor.activeCaption);
		btnLimpar.setBackground(SystemColor.inactiveCaptionBorder);
		btnLimpar.setIcon(new ImageIcon(TelaCadastroJardineiro.class.getResource("/EJT/imagens/buttonLimpar.png")));
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
		btnCancelar.setIcon(new ImageIcon(TelaCadastroJardineiro.class.getResource("/EJT/imagens/buttonCancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCadastroJardineiro.dispose();
				
			}
		});
		btnCancelar.setBounds(233, 11, 118, 23);
		panelBotoes.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					cadastrarEncanador();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		
		});
		btnCadastrar.setForeground(SystemColor.activeCaption);
		btnCadastrar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroJardineiro.class.getResource("/EJT/imagens/buttonComfirma.png")));
		btnCadastrar.setBounds(371, 11, 137, 23);
		panelBotoes.add(btnCadastrar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 27, 594, 310);
		frmCadastroJardineiro.getContentPane().add(panel);
		panel.setLayout(null);
		
	
		
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(0, 11, 46, 14);
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
		CPF.setBounds(45, 8, 118, 20);
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
	
		JLabel lblDadosPessoais = new JLabel("Cadastro Jardineiro");
		lblDadosPessoais.setBounds(241, 11, 165, 14);
		frmCadastroJardineiro.getContentPane().add(lblDadosPessoais);
		
	
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
		
		formattedTextFieldCEL.setBounds(455, 92, 118, 20);
		panel.add(formattedTextFieldCEL);		
		
		

		
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(45, 36, 166, 20);
		panel.add(textFieldRG);
		textFieldRG.setColumns(10);
		textFieldRG.setDocument(new teclasPermitidas());
		
		JLabel lblSair = new JLabel("sair");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmCadastroJardineiro.dispose();
			}
		});
		lblSair.setIcon(new ImageIcon(TelaCadastroJardineiro.class.getResource("/EJT/imagens/botao_fechar.png")));
		lblSair.setBounds(569, 0, 25, 25);
		panel.add(lblSair);

	

		
		
				
	}
	private void limparCampos() {
		textFieldNOME.setText("");
		textFieldEmail.setText("");
		textFieldLogradouro.setText("");
		textFieldNumero.setText("");
		textFieldBairro.setText("");
		textFieldCidade.setText("");
		textFieldRG.setText("");
		formattedTextFieldCEL.setText("");
		CEP.setText("");
		CPF.setText("");
		TELs.setText("");
		

		
		
			
	}
	
	private void cadastrarEncanador() throws Exception {
	
		
		
		
		
		String nome = textFieldNOME.getText().toUpperCase();
		String rg = textFieldRG.getText();
		String cep = CEP.getText().replace("-", "");
		String logradouro = textFieldLogradouro.getText();
		String numero = textFieldNumero.getText();
		String bairro = textFieldBairro.getText();
		String cidade = textFieldCidade.getText();
		String estado = (String) comboBoxEstado.getSelectedItem();
	

		
		String disponibilidade = "DISPONIVEL";
		String cpf = CPF.getText().replace(".", "").replace("-", "");
		
		String email = textFieldEmail.getText();
		String celular = formattedTextFieldCEL.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		String telefone = TELs.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		
		
		Contato contato = new Contato(email, telefone, celular);
		Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado, cep);
		Jardineiro jardineiro = new Jardineiro(nome, cpf, rg, disponibilidade, endereco, contato);
	
	try {
		Fachada.getInstance().jardineiroCadastrar(jardineiro);
		JOptionPane.showMessageDialog(frmCadastroJardineiro, "Cadastro Realizado com sucesso!");
		this.limparCampos();
	
	} catch (CPFInvalidoException e) {
		JOptionPane.showMessageDialog(frmCadastroJardineiro, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
	} catch (JardineiroJaCadastradoException e){
		JOptionPane.showMessageDialog(frmCadastroJardineiro, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
	} catch (CampoObrigatorioException e) {
		JOptionPane.showMessageDialog(frmCadastroJardineiro, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(frmCadastroJardineiro, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	}catch (Exception e){
		JOptionPane.showMessageDialog(frmCadastroJardineiro, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	}
	
}