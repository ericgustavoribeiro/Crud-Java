package EJT.Arquiteto;

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
import javax.swing.text.MaskFormatter;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import EJT.Util.teclasPermitidas;

import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroArquiteto {

	//TESTA ESSA AQUI
	
	public JFrame frmCadastroArquiteto;
	private JTextField textFieldCAU;
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
	JFormattedTextField formattedTextFieldCEL = new JFormattedTextField();
	JFormattedTextField formattedDisponibilidade = new JFormattedTextField();

    public JComboBox comboBoxEstado;

	private String estados[] = {"", "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};

	JFormattedTextField TELs = new JFormattedTextField();
	JFormattedTextField CPF = new JFormattedTextField();
	JFormattedTextField CEP = new JFormattedTextField();
	private EJT.Fachada.Fachada fachada;
	private EJT.Arquiteto.Arquiteto arquiteto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroArquiteto window = new TelaCadastroArquiteto();
					window.frmCadastroArquiteto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroArquiteto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroArquiteto = new JFrame();
		frmCadastroArquiteto.getContentPane().setBackground(Color.WHITE);
		frmCadastroArquiteto.setTitle("CADASTRO ARQUITETO");
		frmCadastroArquiteto.setBounds(100, 100, 650, 447);
		frmCadastroArquiteto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frmCadastroArquiteto.setUndecorated(true);
		frmCadastroArquiteto.setLocationRelativeTo(null); 
		frmCadastroArquiteto.getContentPane().setLayout(new MigLayout("", "[594px]", "[14px][283px][41px]"));
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(Color.WHITE);
		frmCadastroArquiteto.getContentPane().add(panelBotoes, "cell 0 2,grow");
		panelBotoes.setLayout(null);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(SystemColor.activeCaption);
		btnLimpar.setBackground(SystemColor.inactiveCaptionBorder);
		btnLimpar.setIcon(new ImageIcon(TelaCadastroArquiteto.class.getResource("/EJT/imagens/buttonLimpar.png")));
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
		btnCancelar.setIcon(new ImageIcon(TelaCadastroArquiteto.class.getResource("/EJT/imagens/buttonCancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				frmCadastroArquiteto.dispose();
				
				
			//	System.exit(0);				
				
				
			}
		});
		btnCancelar.setBounds(243, 11, 118, 23);
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
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroArquiteto.class.getResource("/EJT/imagens/buttonComfirma.png")));
		btnCadastrar.setBounds(371, 11, 137, 23);
		panelBotoes.add(btnCadastrar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmCadastroArquiteto.getContentPane().add(panel, "cell 0 1,grow");
		panel.setLayout(null);
		
		JLabel lblCAU = new JLabel("CAU: ");
		lblCAU.setBounds(0, 14, 46, 14);
		panel.add(lblCAU);
		
		textFieldCAU = new JTextField();
		textFieldCAU.setBounds(45, 11, 166, 20);
		panel.add(textFieldCAU);
		textFieldCAU.setColumns(10);
		
	
		
		
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
		
		 comboBoxEstado = new JComboBox(estados);
			comboBoxEstado.setBounds(457, 39, 46, 20);
			panel_1.add(comboBoxEstado);
			
		
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
	
		JLabel lblDadosPessoais = new JLabel("Cadastro de Arquiteto");
		frmCadastroArquiteto.getContentPane().add(lblDadosPessoais, "cell 0 0,alignx center,aligny top");
		
	
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
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmCadastroArquiteto.dispose();
			}
		});
		lblSair.setIcon(new ImageIcon(TelaCadastroArquiteto.class.getResource("/EJT/imagens/botao_fechar.png")));
		lblSair.setBounds(553, 2, 31, 39);
		panel.add(lblSair);

	
		
	
		
	
		
	
		
		
				
	}
	private void limparCampos() {
		textFieldNOME.setText("");
		textFieldEmail.setText("");
		textFieldCAU.setText("");
		textFieldLogradouro.setText("");
		textFieldNumero.setText("");
		textFieldBairro.setText("");
		textFieldCidade.setText("");
		textFieldRG.setText("");
		formattedTextFieldCEL.setText("");
		formattedDisponibilidade.setText("");
		CEP.setText("");
		CPF.setText("");
		TELs.setText("");
	
		

		
		
			
	}
	
	private void cadastrarArquiteto() throws Exception {

		String disponibilidade = "DISPONIVEL";
	
		
		
		

		String nome = textFieldNOME.getText().toUpperCase();
		String cau = textFieldCAU.getText();
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
		Arquiteto arquiteto = new Arquiteto(nome, cau, cpf, rg, disponibilidade, endereco, contato);
		
	
		
		
		
	

		
		
		int resultado = JOptionPane.showConfirmDialog(
				frmCadastroArquiteto,
				"OS DADOS INFORMADOS ESTÃO CORRETOS?\n\nNOME: "
						+ textFieldNOME.getText().toUpperCase() + "\n\nESPECIALIDADE: "
						
						+ "\n\nDISPONIBILIDADE: "
						+ disponibilidade
						+ "\n\nCONTATO: " + telefone + " / " + celular ,
				"COMFIRMAR CADASTRO", JOptionPane.YES_NO_OPTION);

		try {
		if (resultado == JOptionPane.YES_OPTION) {
		
		
			Fachada.getInstance().arquitetoCadastrar(arquiteto);
			JOptionPane.showMessageDialog(frmCadastroArquiteto, "Cadastro Realizado com sucesso!");
			this.limparCampos();
		}
		} catch (CPFInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastroArquiteto, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
		} catch (ArquitetoJaCadastradoException e){
			JOptionPane.showMessageDialog(frmCadastroArquiteto, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioException e) {
			JOptionPane.showMessageDialog(frmCadastroArquiteto, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
		} catch (RGInvalidoException e){
			JOptionPane.showMessageDialog(frmCadastroArquiteto, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE); 
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frmCadastroArquiteto, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			JOptionPane.showMessageDialog(frmCadastroArquiteto, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} 
	
		
		
		
		
		
		
		
		
	}
}
