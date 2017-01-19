package EJT.ClienteJuridico;

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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import EJT.Atendente.AtendenteJaCadastradoException;
import EJT.Atendente.CampoObrigatorioInvalidoException;
import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroClienteJuridico extends JFrame {

	private JPanel contentPane;


	public JFrame frmCadastroClienteJuridico;
	private JTextField textFieldNOME;
	private JTextField textFieldLogradouro;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldUF;
	private JTextField textFieldEmail;
	private JTextField textFieldInscricao;
//	private String selecao;
	private String cnpjformatado;
	private String cepformatado;
	private String telformatado;
	private String celformatado;
	private JTextField TesteCNPJ;
	JFormattedTextField formattedTextFieldCEL = new JFormattedTextField();
	JFormattedTextField TELs = new JFormattedTextField();
	JFormattedTextField CNPJ = new JFormattedTextField();
	JFormattedTextField CEP = new JFormattedTextField();
	private EJT.Fachada.Fachada fachada;
	
	
	   public JComboBox comboBoxEstado;

		private String estados[] = {"", "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroClienteJuridico window = new TelaCadastroClienteJuridico();
					window.frmCadastroClienteJuridico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroClienteJuridico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroClienteJuridico = new JFrame();
		frmCadastroClienteJuridico.setType(Type.UTILITY);
		frmCadastroClienteJuridico.getContentPane().setBackground(Color.WHITE);
		frmCadastroClienteJuridico.setTitle("CADASTRO CLIENTE PESSOA JURIDICA");
		frmCadastroClienteJuridico.setBounds(100, 100, 630, 418);
		frmCadastroClienteJuridico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroClienteJuridico.getContentPane().setLayout(null);
		
		frmCadastroClienteJuridico.setUndecorated(true);
	    frmCadastroClienteJuridico.setLocationRelativeTo(null); 
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(Color.WHITE);
		panelBotoes.setBounds(10, 337, 594, 41);
		frmCadastroClienteJuridico.getContentPane().add(panelBotoes);
		panelBotoes.setLayout(null);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(SystemColor.activeCaption);
		btnLimpar.setBackground(SystemColor.inactiveCaptionBorder);
		btnLimpar.setIcon(new ImageIcon(TelaCadastroClienteJuridico.class.getResource("/EJT/imagens/buttonLimpar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limparCampos();
				
			}


		});
		btnLimpar.setBounds(83, 11, 112, 23);
		panelBotoes.add(btnLimpar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(SystemColor.activeCaption);
		btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCancelar.setIcon(new ImageIcon(TelaCadastroClienteJuridico.class.getResource("/EJT/imagens/buttonCancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frmCadastroClienteJuridico.dispose();
				
			}
		});
		btnCancelar.setBounds(223, 11, 118, 23);
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
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroClienteJuridico.class.getResource("/EJT/imagens/buttonComfirma.png")));
		btnCadastrar.setBounds(371, 11, 137, 23);
		panelBotoes.add(btnCadastrar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 27, 594, 310);
		frmCadastroClienteJuridico.getContentPane().add(panel);
		panel.setLayout(null);
		
	
		
		
		JLabel lblCpf = new JLabel("CNPJ:");
		lblCpf.setBounds(0, 11, 46, 14);
		panel.add(lblCpf);
	
		MaskFormatter formatarCNPJ;
		
		
		try {
			formatarCNPJ = new MaskFormatter("##.###.###/####-##");
			formatarCNPJ.setValidCharacters("0123456789");
			CNPJ = new JFormattedTextField(formatarCNPJ);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CNPJ.setText(null);
		CNPJ.setBounds(45, 8, 118, 20);
		panel.add(CNPJ);
		cnpjformatado = CNPJ.getText();
		
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(0, 42, 46, 14);
		panel.add(lblNome);
		
		textFieldNOME = new JTextField();
		textFieldNOME.setBounds(45, 39, 529, 20);
		panel.add(textFieldNOME);
		textFieldNOME.setColumns(10);
		
		JLabel lblRg = new JLabel("INSCRIÇÃO ESTADUAL: ");
		lblRg.setBounds(173, 11, 140, 14);
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
		cepformatado = CNPJ.getText();
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(241, 137, 65, 14);
		panel.add(lblEndereo);
		
		JLabel lblNewLabel = new JLabel("E-Mail: ");
		lblNewLabel.setBounds(0, 73, 46, 14);
		panel.add(lblNewLabel);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(45, 70, 186, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabelTels = new JLabel("Telefone: ");
		lblNewLabelTels.setBounds(241, 73, 65, 14);
		panel.add(lblNewLabelTels);
	
		JLabel lblDadosPessoais = new JLabel("Cliente Pessoa Juridica");
		lblDadosPessoais.setBounds(241, 11, 165, 14);
		frmCadastroClienteJuridico.getContentPane().add(lblDadosPessoais);
		
	
		MaskFormatter formatarTEL;
		
		try {
			formatarTEL = new MaskFormatter("(##) ####-####");
			formatarTEL.setValidCharacters("0123456789");
			TELs = new JFormattedTextField(formatarTEL);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TELs.setBounds(303, 70, 118, 20);
		panel.add(TELs);
		
		JLabel lblCelular = new JLabel("Cel:");
		lblCelular.setBounds(431, 73, 34, 14);
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
		
		formattedTextFieldCEL.setBounds(456, 70, 118, 20);
		panel.add(formattedTextFieldCEL);		
		
		

		
		
		textFieldInscricao = new JTextField();
		textFieldInscricao.setBounds(303, 8, 236, 20);
		panel.add(textFieldInscricao);
		textFieldInscricao.setColumns(10);
		
		JLabel lblSair = new JLabel("sair");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmCadastroClienteJuridico.dispose();
			}
		});
		lblSair.setIcon(new ImageIcon(TelaCadastroClienteJuridico.class.getResource("/EJT/imagens/botao_fechar.png")));
		lblSair.setBounds(570, 0, 24, 25);
		panel.add(lblSair);
		
	

		
		
				
	}
	private void limparCampos() {
		textFieldNOME.setText("");
		textFieldEmail.setText("");
		textFieldLogradouro.setText("");
		textFieldNumero.setText("");
		textFieldBairro.setText("");
		textFieldCidade.setText("");
        textFieldInscricao.setText("");
		formattedTextFieldCEL.setText("");
		CNPJ.setText("");
		TELs.setText("");
		CEP.setText("");

		
		
			
	}
	
	private void cadastrarEncanador() throws Exception {
	
		
		
		
		
		String nome = textFieldNOME.getText().toUpperCase();
		String inscricao_estadual = textFieldInscricao.getText();
		String cep = CEP.getText().replace("-", "");
		String logradouro = textFieldLogradouro.getText();
		String numero = textFieldNumero.getText();
		String bairro = textFieldBairro.getText();
		String cidade = textFieldCidade.getText();
		String estado = (String) comboBoxEstado.getSelectedItem();

	

		
		
		String cnpj = CNPJ.getText().replace(".", "").replace("/", "").replace("-", "");
		
		String email = textFieldEmail.getText();
		String celular = formattedTextFieldCEL.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		String telefone = TELs.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		
		
		Contato contato = new Contato(email, telefone, celular);
		Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado, cep);
		ClienteJuridico clienteJuridico = new ClienteJuridico(nome, cnpj, inscricao_estadual, endereco, contato);
	
	try {	
	
		Fachada.getInstance().clienteJuridicoCadastrar(clienteJuridico);;
		JOptionPane.showMessageDialog(frmCadastroClienteJuridico, "Cadastro Realizado com sucesso!");
		this.limparCampos();
		
	} catch (CNPJInvalidoException e) {
		JOptionPane.showMessageDialog(frmCadastroClienteJuridico, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
	} catch (ClienteJuridicoJaCadastradoException e){
		JOptionPane.showMessageDialog(frmCadastroClienteJuridico, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
	} catch (CampoObrigatorioException e) {
		JOptionPane.showMessageDialog(frmCadastroClienteJuridico, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(frmCadastroClienteJuridico, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	}catch (Exception e){
		JOptionPane.showMessageDialog(frmCadastroClienteJuridico, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	} 
	
		

	}

}
