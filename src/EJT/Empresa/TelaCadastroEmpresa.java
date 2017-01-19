package EJT.Empresa;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
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
import javax.swing.text.MaskFormatter;







import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;

import javax.swing.JFrame;

import java.awt.Font;

public class TelaCadastroEmpresa {

	
	public JFrame frmCadastroEmpresa;
	private JTextField textFieldRAZAO;
	private JTextField textFieldNOME_FANTASIA;
	private JTextField textFieldLogradouro;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldEmail;
	private JTextField textFieldINSCRICAO;
	private String selecao;
	private String cnpjformatado;
	private String cepformatado;
	private String telformatado;
	private String celformatado;
	private JTextField TesteCPF;
	JFormattedTextField formattedTextFieldCEL = new JFormattedTextField();
	private JFormattedTextField CELs;
	JFormattedTextField TELs = new JFormattedTextField();
	JFormattedTextField CNPJ = new JFormattedTextField();
	JFormattedTextField CEP = new JFormattedTextField();
	
	   public JComboBox comboBoxEstado;

		private String estados[] = {"", "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};

	
	private EJT.Fachada.Fachada fachada;
	private EJT.Arquiteto.Arquiteto arquiteto;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEmpresa window = new TelaCadastroEmpresa();
					window.frmCadastroEmpresa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public TelaCadastroEmpresa() throws Exception {
		initialize();
//		String cnpj = "66024482000128";
//		Fachada fachada = Fachada.getInstance();
//		textFieldNOME_FANTASIA.setText(fachada.empresaProcurar(cnpj).getNome_fantasia().toUpperCase());
//		textFieldINSCRICAO.setText(fachada.empresaProcurar(cnpj).getInscricao_estadual().toUpperCase());
//		textFieldRAZAO.setText(fachada.empresaProcurar(cnpj).getRazao_socia());
//		CNPJ.setText(fachada.empresaProcurar(cnpj).getCnpj());
//		textFieldEmail.setText(fachada.empresaProcurar(cnpj).getContato().getEmail());
//		TELs.setText(fachada.empresaProcurar(cnpj).getContato().getTelefone());
//		CELs.setText(fachada.empresaProcurar(cnpj).getContato().getCelular());
//		
//		textFieldLogradouro.setText(fachada.empresaProcurar(cnpj).getEndereco().getLogradouro().toUpperCase());
//		textFieldBairro.setText(fachada.empresaProcurar(cnpj).getEndereco().getBairro().toUpperCase());
//		textFieldCidade.setText(fachada.empresaProcurar(cnpj).getEndereco().getCidade().toUpperCase());
//		textFieldNumero.setText(fachada.empresaProcurar(cnpj).getEndereco().getNumero());
//		CEP.setText(fachada.empresaProcurar(cnpj).getEndereco().getCep());
//		
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frmCadastroEmpresa = new JFrame();
		frmCadastroEmpresa.getContentPane().setBackground(Color.WHITE);
		frmCadastroEmpresa.setTitle("CADASTRO EMPRESA");
		frmCadastroEmpresa.setBounds(100, 100, 630, 418);
		frmCadastroEmpresa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroEmpresa.getContentPane().setLayout(null);
		
		frmCadastroEmpresa.setUndecorated(true);
	    frmCadastroEmpresa.setLocationRelativeTo(null); 
		
		frmCadastroEmpresa.setUndecorated(true);
	    frmCadastroEmpresa.setLocationRelativeTo(null); 

	
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(Color.WHITE);
		panelBotoes.setBounds(10, 336, 594, 41);
		frmCadastroEmpresa.getContentPane().add(panelBotoes);
		panelBotoes.setLayout(null);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(SystemColor.activeCaption);
		btnLimpar.setBackground(SystemColor.inactiveCaptionBorder);
		btnLimpar.setIcon(new ImageIcon(TelaCadastroEmpresa.class.getResource("/EJT/imagens/buttonLimpar.png")));
		
		
		
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
		btnCancelar.setIcon(new ImageIcon(TelaCadastroEmpresa.class.getResource("/EJT/imagens/buttonCancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frmCadastroEmpresa.dispose();
				
			}
		});
		btnCancelar.setBounds(243, 11, 118, 23);
		panelBotoes.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					cadastrarEmpresa();
					
				
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		
		});
		btnCadastrar.setForeground(SystemColor.activeCaption);
		btnCadastrar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroEmpresa.class.getResource("/EJT/imagens/buttonComfirma.png")));
		btnCadastrar.setBounds(371, 11, 137, 23);
		panelBotoes.add(btnCadastrar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 27, 594, 310);
		frmCadastroEmpresa.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCAU = new JLabel("RAZ\u00C3O SOCIAL:");
		lblCAU.setBounds(0, 14, 118, 14);
		panel.add(lblCAU);
		
		textFieldRAZAO = new JTextField();
		textFieldRAZAO.setBounds(140, 11, 166, 20);
		panel.add(textFieldRAZAO);
		textFieldRAZAO.setColumns(10);
		
	
		
		
		JLabel lblCpf = new JLabel("CNPJ:");
		lblCpf.setBounds(344, 14, 46, 14);
		panel.add(lblCpf);
	
		MaskFormatter formatarCNPJ ;
		
		
		try {
			formatarCNPJ = new MaskFormatter("##.###.###/####-##");
			formatarCNPJ .setValidCharacters("0123456789");
			CNPJ = new JFormattedTextField(formatarCNPJ );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CNPJ.setText(null);
		CNPJ.setBounds(386, 11, 118, 20);
		panel.add(CNPJ);
		cnpjformatado = CNPJ.getText();
		
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(0, 64, 46, 14);
		panel.add(lblNome);
		
		textFieldNOME_FANTASIA = new JTextField();
		textFieldNOME_FANTASIA.setBounds(45, 61, 459, 20);
		panel.add(textFieldNOME_FANTASIA);
		textFieldNOME_FANTASIA.setColumns(10);
		
		JLabel lblRg = new JLabel("INSCRI\u00C7\u00C3O ESTADUAL:");
		lblRg.setBounds(0, 39, 134, 14);
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
		 comboBoxEstado.setSelectedIndex(5);
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
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereo.setBounds(253, 137, 65, 14);
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
	
		JLabel lblDadosPessoais = new JLabel("Dados da empresa");
		lblDadosPessoais.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDadosPessoais.setBounds(241, 11, 165, 14);
		frmCadastroEmpresa.getContentPane().add(lblDadosPessoais);
		
	
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
			CELs = new JFormattedTextField(formatarCEL);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CELs.setBounds(455, 92, 118, 20);
		panel.add(CELs);		
		
		

		
		
		textFieldINSCRICAO = new JTextField();
		textFieldINSCRICAO.setBounds(140, 36, 166, 20);
		panel.add(textFieldINSCRICAO);
		textFieldINSCRICAO.setColumns(10);
		
		
		
		
		
				
	}
	
//	private void buscar() {
//		Fachada fachada = Fachada.getInstance();
//		
//		String cnpj = JOptionPane.showInputDialog(frmCadastroEmpresa, "cnpj");
//		try {
//			CNPJ.setText(cnpj);
//			textFieldNOME_FANTASIA.setText(fachada.empresaProcurar(cnpj).getNome_fantasia());
//			textFieldINSCRICAO.setText(fachada.empresaProcurar(cnpj).getInscricao_estadual());
//			textFieldNOME_FANTASIA.setText(fachada.empresaProcurar(cnpj).getNome_fantasia());
//			textFieldRAZAO.setText(fachada.empresaProcurar(cnpj).getRazao_socia());
//			
//			
//		} catch (Exception e2) {
//			//JOptionPane.showMessageDialog(frmCadastroEmpresa, e2);
//		}
//	}

	private void limparCampos() {
		textFieldNOME_FANTASIA.setText("");
		textFieldEmail.setText("");
		textFieldRAZAO.setText("");
		textFieldLogradouro.setText("");
		textFieldNumero.setText("");
		textFieldBairro.setText("");
		textFieldCidade.setText("");
		textFieldINSCRICAO.setText("");
		CELs.setText("");
		CNPJ.setText("");
		CEP.setText("");
		TELs.setText("");
		
	
	}
	
	private void cadastrarEmpresa() throws Exception {
	
		
		
		String nome_fantasia = textFieldNOME_FANTASIA.getText().toUpperCase();
		String razao_social = textFieldRAZAO.getText();
		String inscricao_estadual = textFieldINSCRICAO.getText();
		String cep = CEP.getText().replace("-", "");
		String logradouro = textFieldLogradouro.getText();
		String numero = textFieldNumero.getText();
		String bairro = textFieldBairro.getText();
		String cidade = textFieldCidade.getText();
	
		String estado = (String) comboBoxEstado.getSelectedItem();

	
		String cnpj = CNPJ.getText().replace(".", "").replace("/", "").replace("-", "");
		
		String email = textFieldEmail.getText();
		String celular = CELs.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		String telefone = TELs.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		
		
		Contato contato = new Contato(email, telefone, celular);
		Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado, cep);
		Empresa empresa = new Empresa(nome_fantasia, cnpj, razao_social,
		 inscricao_estadual, endereco,  contato);
		
	try {
		
		Fachada.getInstance().empresaCadastrar(empresa);
		JOptionPane.showMessageDialog(frmCadastroEmpresa, "EMPRESA ACABA DE SER CADASTRADA COM SUCESSO !!!", " CADASTRO REALIZADO ", JOptionPane.YES_OPTION);
		frmCadastroEmpresa.dispose();
		
	} catch (CNPJInvalidoException e1){
		JOptionPane.showMessageDialog(frmCadastroEmpresa, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
		
	} catch (EmpresaJ·CadastradaException e1){
		JOptionPane.showMessageDialog(frmCadastroEmpresa, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			
	} catch (CampoObricatorioException e) {
		JOptionPane.showMessageDialog(frmCadastroEmpresa, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(frmCadastroEmpresa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	}catch (Exception e){
		JOptionPane.showMessageDialog(frmCadastroEmpresa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	} 	
		
	}
}
