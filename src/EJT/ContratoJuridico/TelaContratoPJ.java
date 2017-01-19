package EJT.ContratoJuridico;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.plaf.TextUI;

import EJT.Arquiteto.ArquitetoNaoEncontradoException;
import EJT.Arquiteto.CPFInvalidoException;
import EJT.Atendente.AtendenteNaoEncontradoException;
import EJT.Atendente.TelaListarAtendentes;
import EJT.ClienteFisico.ClienteNaoEncontradoException;
import EJT.ClienteJuridico.*;
import EJT.Eletricista.Eletricista;
import EJT.Eletricista.EletricistaNaoEncontradoException;
import EJT.Eletricista.TelaListarDisponivelEletricista;
import EJT.Empresa.Empresa;
import EJT.Encanador.Encanador;
import EJT.Encanador.EncanadorNaoEncontradoException;
import EJT.Encanador.TelaListarDisponivelEncanador;
import EJT.Engenheiro.Engenheiro;
import EJT.Engenheiro.EngenheiroNaoEncontradoException;
import EJT.Engenheiro.TelaListarDisponivelEngenheiro;
import EJT.Engenheiro.TelaListarEngenheiro;
import EJT.Fachada.Fachada;
import EJT.Gerente.GerenteNaoEncontradoExceptio;
import EJT.Jardineiro.Jardineiro;
import EJT.Jardineiro.JardineiroNaoEncontradoException;
import EJT.Jardineiro.TelaListarDisponivelJardineiro;
import EJT.MestredeObras.MestreDeObras;
import EJT.MestredeObras.MestreDeObrasNaoEncontradoException;
import EJT.MestredeObras.TelaListarDisponivelMestreDeObras;
import EJT.Arquiteto.*;

import java.awt.Window.Type;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


 

public class TelaContratoPJ  {

	
	public JFrame frmContrato;
	private JTextField textFieldAtendenteNome;
	private JTextField textFieldNomeCliente;
	private JTextField textNomeEngenheiro;
	private JTextField textTelCliente;
	private JTextField textCelCliente;
	private JTextField textTelefoneEngenheiro;
	private JTextField textCelularEngenheiro;
	private JTextField textNomeArquiteto;
	private JTextField textTelefoneArquiteto;
	private JTextField textCelularArquiteto;
	private JTextField textTelMestre;
	private JTextField textCelMestre;
	private JTextField textNomeMestre;
	
	private JTextField NomeEncanador;
	private JTextField CelEncanador;
	private JTextField TelEncanador;
	
	
	 private int id_engenheiro;
	    private int id_clienteJuridico;
		private int id_arquiteto;
		private int id_atendente;
		private int id_eletricista;
		private String descricao;
		private int id_jardineiro;
		private int id_mestre;
		private String cnpj = "";
		private int id_encanador;
		private JTextField CPFencanador;
	
	
	private JTextField TelefoneEncanador;

	private JTextField CelularEncanador;
	private JTextField TelefoneEletricista;
	private JTextField NomeEletricista;
	private JTextField CelularEletricista;
	private JTextField TelefoneJardineiro;
	private JTextField NomeJardineiro;
	private JTextField CelularJardineiro;
	
	private int id_gerente;
	private JLabel horario      =   new JLabel();  
    private JTextField textBuscaCPFEncanador;
    private JTextField textBuscaCPFengenheiro;
    private JTextField textCPFArquiteto;
    private JTextField textCpfMestre;
    private JTextField textCpfEncanador;
    private JTextField textCpfCliente;
    private JTextField textRuaCliente;
    private JTextField textBairroCliente;
    private JTextField textCidadeCliente;
    private JTextField textEstadoCliente;
    private JTextField textCepCliente;
    private JTextField BuscaCPF;
    private JTextField textField;
    private JTextField textBuscarCPFEletricista;
    private JTextField BuscarCPFJardineiro;

    private JTextPane txtpnDescricao = new JTextPane();
    private JTextField textFieldCpfAtendente;
    private JTextField textFieldGerenteCpf;
    private JTextField textFieldGerenteNome;
   private TextArea CampoDescricao;
    
    
    Jardineiro jardineiro;
    Engenheiro engenheiro;
    Arquiteto arquiteto;
    Encanador encanador;
    Eletricista eletricista;
    MestreDeObras mestre_de_obras;
	private static int idContrato;
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaContratoPJ window = new TelaContratoPJ();
					window.frmContrato.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaContratoPJ() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContrato = new JFrame();
		frmContrato.setType(Type.UTILITY);
		frmContrato.getContentPane().setForeground(Color.BLUE);
		frmContrato.setTitle("FAZER NOVO CONTRATO PESSOA JURIDICA");
		frmContrato.setBounds(100, 100, 750, 611);
		frmContrato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmContrato.getContentPane().setLayout(null);
		  
		frmContrato.setUndecorated(true);
	    frmContrato.setLocationRelativeTo(null); 

		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		panel.setBounds(20, 84, 520, 72);
		frmContrato.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAtendente = new JLabel("Atendente: ");
		lblAtendente.setBounds(10, 44, 76, 14);
		panel.add(lblAtendente);
		
		textFieldAtendenteNome = new JTextField();
		textFieldAtendenteNome.setBounds(93, 41, 391, 20);
		panel.add(textFieldAtendenteNome);
		textFieldAtendenteNome.setColumns(10);
		
		JLabel lblCpf_7 = new JLabel("CPF:");
		lblCpf_7.setBounds(40, 11, 46, 14);
		panel.add(lblCpf_7);
		
		textFieldCpfAtendente = new JTextField();
		textFieldCpfAtendente.setBounds(93, 8, 143, 20);
		panel.add(textFieldCpfAtendente);
		textFieldCpfAtendente.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldCpfAtendente.getText();
				
				try {
					textFieldAtendenteNome.setText(Fachada.getInstance().atendenteProcurar(cpf).getNome());
					id_atendente = Fachada.getInstance().atendenteProcurar(cpf).getId_atendente();
					
				} catch (EJT.Atendente.CPFInvalidoException e)	{	
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);	
					
				} catch(AtendenteNaoEncontradoException e){		
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch (StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(frmContrato, "Digite o CPF do Atendente que ira fazer o contrato");	
						
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(246, 7, 89, 23);
		panel.add(btnBuscar);
		
		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarAtendentes window = new TelaListarAtendentes();
				window.frmAtendentes.setVisible(true);
			}
		});
		btnListarTodos.setBounds(346, 7, 119, 23);
		panel.add(btnListarTodos);
		horario.setBounds(0, 38, 100, -38);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(153, 180, 209), 2));
		tabbedPane.setBounds(20, 285, 715, 136);
		frmContrato.getContentPane().add(tabbedPane);
		
		JPanel Engenheiro = new JPanel();
		Engenheiro.setBorder(null);
		tabbedPane.addTab("Engenheiro", null, Engenheiro, null);
		Engenheiro.setLayout(null);
		
		textNomeEngenheiro = new JTextField();
		textNomeEngenheiro.setBounds(70, 42, 361, 20);
		Engenheiro.add(textNomeEngenheiro);
		textNomeEngenheiro.setColumns(10);
		
		
		
		JLabel lblNomeDoProfissional = new JLabel("Nome:");
		lblNomeDoProfissional.setBounds(36, 45, 46, 14);
		Engenheiro.add(lblNomeDoProfissional);
		
		JLabel lblTelefone_1 = new JLabel("Telefone:");
		lblTelefone_1.setBounds(5, 76, 55, 14);
		Engenheiro.add(lblTelefone_1);
		
		textTelefoneEngenheiro = new JTextField();
		textTelefoneEngenheiro.setBounds(70, 73, 112, 20);
		Engenheiro.add(textTelefoneEngenheiro);
		textTelefoneEngenheiro.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(192, 76, 46, 14);
		Engenheiro.add(lblCelular);
		
		textCelularEngenheiro = new JTextField();
		textCelularEngenheiro.setBounds(237, 73, 102, 20);
		Engenheiro.add(textCelularEngenheiro);
		textCelularEngenheiro.setColumns(10);
		
		JButton btnBuscarProfissional = new JButton("Buscar Engenheiro");
		btnBuscarProfissional.setBounds(237, 11, 148, 23);
		Engenheiro.add(btnBuscarProfissional);
		
		JButton button_7 = new JButton("Limpar");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
							textBuscaCPFengenheiro.setText("");
							textNomeEngenheiro.setText("");
							textCelularEngenheiro.setText("");
						    textTelefoneEngenheiro.setText("");
				
				
				
				
			}
		});
		button_7.setBounds(580, 41, 89, 23);
		Engenheiro.add(button_7);
		
		JButton button = new JButton("Contratar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				String cpf = textBuscaCPFengenheiro.getText();
				if(textNomeEngenheiro.getText().equals("")){
					JOptionPane.showMessageDialog(frmContrato, "Favor Escolher um Engenheiro");
				}else{
				try {
					JOptionPane.showMessageDialog(frmContrato, "Engeheiro:\n " + textNomeEngenheiro.getText() +"\nadiconado no contrato!");
					Fachada fachada = Fachada.getInstance();
					EJT.Engenheiro.Engenheiro engenheiro = fachada.engenheiroProcurar(cpf);
					id_engenheiro = fachada.engenheiroProcurar(cpf).getId_engenheiro();
//					engenheiro.setDisponibilidade("OCUPADO");
//					fachada.engenheiroAtualizar(engenheiro);
							} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			}
		});
		button.setBounds(580, 77, 89, 23);
		Engenheiro.add(button);
		
		textBuscaCPFengenheiro = new JTextField();
		textBuscaCPFengenheiro.setBounds(70, 11, 148, 20);
		Engenheiro.add(textBuscaCPFengenheiro);
		textBuscaCPFengenheiro.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(36, 15, 46, 14);
		Engenheiro.add(lblCpf);
		
		JButton btnListarDisponiveis = new JButton("Listar Disponiveis");
		btnListarDisponiveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelEngenheiro window = new TelaListarDisponivelEngenheiro();
				window.frmEngenheirosDisponiveis.setVisible(true);
			}
		});
		btnListarDisponiveis.setBounds(395, 11, 139, 23);
		Engenheiro.add(btnListarDisponiveis);
		btnBuscarProfissional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String cpf = textBuscaCPFengenheiro.getText();
				try {
					Fachada.getInstance().engenheiroProcurar(cpf);
						Fachada fachada = Fachada.getInstance();
						
						if(fachada.engenheiroProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
							JOptionPane.showMessageDialog(frmContrato, "ENGENHEIRO OCUPADO\nPOR FAVOR PROCURE OUTRO ENGENHEIRO");
						}else{
							textNomeEngenheiro.setText(fachada.engenheiroProcurar(cpf).getNome().toUpperCase());
							textCelularEngenheiro.setText(fachada.engenheiroProcurar(cpf).getContato().getCelular());
						    textTelefoneEngenheiro.setText(fachada.engenheiroProcurar(cpf).getContato().getTelefone());
						  //  id_engenheiro = fachada.engenheiroProcurar(cpf).getId_engenheiro();
						
						}

				} catch (EJT.Engenheiro.CPFInvalidoException e)	{	
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);	
					
				} catch(EngenheiroNaoEncontradoException e){		
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch (StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(frmContrato, "Digite o CPF do Engenheiro para a busca ");
					
				    
				    
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		
		Panel Arquiteto = new Panel();
		tabbedPane.addTab("Arquiteto", null, Arquiteto, null);
		Arquiteto.setLayout(null);
		
		JButton btnBuscarArquiteto = new JButton("Buscar Arquiteto");
		btnBuscarArquiteto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cpf = textCPFArquiteto.getText();
				try {
					Fachada.getInstance().arquitetoProcurar(cpf);
					Fachada fachada = Fachada.getInstance();
					if(fachada.arquitetoProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
						JOptionPane.showMessageDialog(frmContrato, "ARQUITETO OCUPADO\nPOR FAVOR PROCURE OUTRO ARQUITETO");

					}else {
						textNomeArquiteto.setText(fachada.arquitetoProcurar(cpf).getNome().toUpperCase());
						textTelefoneArquiteto.setText(fachada.arquitetoProcurar(cpf).getContato().getTelefone());
						textCelularArquiteto.setText(fachada.arquitetoProcurar(cpf).getContato().getCelular());
						
					}
					
				} catch (CPFInvalidoException e){
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch(ArquitetoNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmContrato, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			
				} catch (StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(frmContrato, "Digite o CPF do Arquiteto para a busca ");
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnBuscarArquiteto.setBounds(257, 11, 126, 23);
		Arquiteto.add(btnBuscarArquiteto);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(30, 48, 46, 14);
		Arquiteto.add(lblNome);
		
		textNomeArquiteto = new JTextField();
		textNomeArquiteto.setBounds(81, 45, 359, 20);
		Arquiteto.add(textNomeArquiteto);
		textNomeArquiteto.setColumns(10);
		
		JLabel lblTelefone_2 = new JLabel("Telefone: ");
		lblTelefone_2.setBounds(30, 76, 66, 14);
		Arquiteto.add(lblTelefone_2);
		
		textTelefoneArquiteto = new JTextField();
		textTelefoneArquiteto.setBounds(81, 70, 119, 20);
		Arquiteto.add(textTelefoneArquiteto);
		textTelefoneArquiteto.setColumns(10);
		
		JLabel lblCelular_1 = new JLabel("Celular:");
		lblCelular_1.setBounds(210, 76, 46, 14);
		Arquiteto.add(lblCelular_1);
		
		textCelularArquiteto = new JTextField();
		textCelularArquiteto.setBounds(251, 70, 132, 20);
		Arquiteto.add(textCelularArquiteto);
		textCelularArquiteto.setColumns(10);
		
		JButton btnContratar = new JButton("Contratar");
		btnContratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				String cpf = textCPFArquiteto.getText();
				if(textNomeArquiteto.getText().equals("")){
					JOptionPane.showMessageDialog(frmContrato, "Favor Escolher um Arquiteto");
				}else{
				try {
					JOptionPane.showMessageDialog(frmContrato, "Arquiteto:\n " + textNomeArquiteto.getText() +"\nadiconado no contrato!");
					Fachada fachada = Fachada.getInstance();
					Arquiteto arquiteto = fachada.arquitetoProcurar(cpf);
					id_arquiteto = fachada.arquitetoProcurar(cpf).getId_arquiteto();
//					arquiteto.setDisponibilidade("OCUPADO");
//					fachada.arquitetoAtualizar(arquiteto);
							} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			

			}
		});
		btnContratar.setBounds(571, 72, 89, 23);
		Arquiteto.add(btnContratar);
		
		JButton button_10 = new JButton("Limpar");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
						textCPFArquiteto.setText("");
						textNomeArquiteto.setText("");
						textTelefoneArquiteto.setText("");
						textCelularArquiteto.setText("");
			}
		});
		button_10.setBounds(571, 44, 89, 23);
		Arquiteto.add(button_10);
		
		JLabel lblCpf_1 = new JLabel("CPF:");
		lblCpf_1.setBounds(30, 15, 46, 14);
		Arquiteto.add(lblCpf_1);
		
		textCPFArquiteto = new JTextField();
		textCPFArquiteto.setBounds(78, 12, 158, 20);
		Arquiteto.add(textCPFArquiteto);
		textCPFArquiteto.setColumns(10);
		
		JButton btnListarDisponiveis_1 = new JButton("Listar Disponiveis");
		btnListarDisponiveis_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelArquiteto window = new TelaListarDisponivelArquiteto();
				window.frame.setVisible(true);
			}
		});
		btnListarDisponiveis_1.setBounds(393, 11, 132, 23);
		Arquiteto.add(btnListarDisponiveis_1);
		
		Panel panel_3 = new Panel();
		tabbedPane.addTab("Mestre de Obra", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("Telefone: ");
		label.setBounds(30, 76, 66, 14);
		panel_3.add(label);
		
		textTelMestre = new JTextField();
		textTelMestre.setColumns(10);
		textTelMestre.setBounds(81, 70, 119, 20);
		panel_3.add(textTelMestre);
		
		textCelMestre = new JTextField();
		textCelMestre.setColumns(10);
		textCelMestre.setBounds(251, 70, 132, 20);
		panel_3.add(textCelMestre);
		
		JLabel label_1 = new JLabel("Celular:");
		label_1.setBounds(210, 76, 46, 14);
		panel_3.add(label_1);
		
		textNomeMestre = new JTextField();
		textNomeMestre.setColumns(10);
		textNomeMestre.setBounds(81, 45, 359, 20);
		panel_3.add(textNomeMestre);
		
		JLabel label_2 = new JLabel("Nome: ");
		label_2.setBounds(30, 48, 46, 14);
		panel_3.add(label_2);
		
		JButton button_1 = new JButton("Buscar Mestre de Obra");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String cpf = textCpfMestre.getText();
				
				try {
					Fachada.getInstance().mestreProcurar(cpf);
					Fachada fachada = Fachada.getInstance();
					if(fachada.mestreProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
						JOptionPane.showMessageDialog(frmContrato, "MESTRE DE OBRAS OCUPADO\nPOR FAVOR PROCURE OUTRO");
					}else{
						textNomeMestre.setText(fachada.mestreProcurar(cpf).getNome().toUpperCase());
						textCelMestre.setText(fachada.mestreProcurar(cpf).getContato().getCelular());
						textTelMestre.setText(fachada.mestreProcurar(cpf).getContato().getCelular());
				
					}
					
				} catch (EJT.MestredeObras.CPFInvalidoException e ){
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch (MestreDeObrasNaoEncontradoException e ){	
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch (StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(frmContrato, "Digite o CPF do Mestre de Obras para a busca ");	
					
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button_1.setBounds(212, 11, 171, 23);
		panel_3.add(button_1);
		
		JButton button_2 = new JButton("Contratar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cpf = textCpfMestre.getText();
				if(textNomeMestre.getText().equals("")){
					JOptionPane.showMessageDialog(frmContrato, "Favor Escolher um Mestre de Obra");
				}else{
				try {
					JOptionPane.showMessageDialog(frmContrato, "Mestre de Obra:\n " + textNomeMestre.getText() +"\nadiconado no contrato!");
					Fachada fachada = Fachada.getInstance();
					MestreDeObras mestre_de_obras = fachada.mestreProcurar(cpf);
					id_mestre = fachada.mestreProcurar(cpf).getId_mestre();
//					mestre_de_obras.setDisponibilidade("OCUPADO");
//					fachada.mestreAtualizar(mestre_de_obras);
							} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			}
		});
		button_2.setBounds(571, 72, 89, 23);
		panel_3.add(button_2);
		
		JButton button_9 = new JButton("Limpar");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						textCpfMestre.setText("");
						textNomeMestre.setText("");
						textCelMestre.setText("");
						textTelMestre.setText("");
				
				
				
				
				
			}
		});
		button_9.setBounds(571, 44, 89, 23);
		panel_3.add(button_9);
		
		JLabel lblCpf_2 = new JLabel("CPF:");
		lblCpf_2.setBounds(30, 15, 46, 14);
		panel_3.add(lblCpf_2);
		
		textCpfMestre = new JTextField();
		textCpfMestre.setBounds(83, 12, 119, 20);
		panel_3.add(textCpfMestre);
		textCpfMestre.setColumns(10);
		
		JButton btnListarDisponiveis_2 = new JButton("Listar Disponiveis");
		btnListarDisponiveis_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelMestreDeObras window = new TelaListarDisponivelMestreDeObras();
				window.frame.setVisible(true);
			}
		});
		btnListarDisponiveis_2.setBounds(389, 11, 132, 23);
		panel_3.add(btnListarDisponiveis_2);
		
		Panel painelEncanador = new Panel();
		tabbedPane.addTab("Encanador", null, painelEncanador, "");
		painelEncanador.setLayout(null);
		
		JButton btnBuscarEncanador_1 = new JButton("Buscar Encanador");
		btnBuscarEncanador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
					String cpf = textBuscaCPFEncanador.getText();
				
				try {	
					Fachada.getInstance().encanadorProcurar(cpf);
					Fachada fachada = Fachada.getInstance();
					if(fachada.encanadorProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
						JOptionPane.showMessageDialog(frmContrato, "ENCANADOR OCUPADO\nPOR FAVOR PROCURE OUTRO");
					}else{
						NomeEncanador.setText(fachada.encanadorProcurar(cpf).getNome().toUpperCase());
						CelularEncanador.setText(fachada.encanadorProcurar(cpf).getContato().getCelular());
						TelefoneEncanador.setText(fachada.encanadorProcurar(cpf).getContato().getCelular());
						
						
					}
					
				} catch (EJT.Encanador.CPFInvalidoException e ){
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch (EncanadorNaoEncontradoException e ){	
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch (StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(frmContrato, "Digite o CPF do Encanador para a busca ");	
						
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
				
				
				
			
	
		});
		btnBuscarEncanador_1.setBounds(210, 11, 160, 23);
		painelEncanador.add(btnBuscarEncanador_1);
		
		JLabel label_3 = new JLabel("Nome: ");
		label_3.setBounds(30, 48, 46, 14);
		painelEncanador.add(label_3);
		
		JLabel label_4 = new JLabel("Telefone: ");
		label_4.setBounds(30, 76, 66, 14);
		painelEncanador.add(label_4);
		
		TelefoneEncanador = new JTextField();
		TelefoneEncanador.setColumns(10);
		TelefoneEncanador.setBounds(81, 70, 119, 20);
		painelEncanador.add(TelefoneEncanador);
		
		NomeEncanador = new JTextField();
		NomeEncanador.setColumns(10);
		NomeEncanador.setBounds(81, 45, 359, 20);
		painelEncanador.add(NomeEncanador);
		
		JLabel label_5 = new JLabel("Celular:");
		label_5.setBounds(210, 76, 46, 14);
		painelEncanador.add(label_5);
		
		CelularEncanador = new JTextField();
		CelularEncanador.setColumns(10);
		CelularEncanador.setBounds(251, 70, 132, 20);
		painelEncanador.add(CelularEncanador);
		
		
	
		
		
		
		
		JButton button_4 = new JButton("Contratar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				String cpf = textBuscaCPFEncanador.getText();
				if(NomeEncanador.getText().equals("")){
					JOptionPane.showMessageDialog(frmContrato, "Favor Escolher um Encanador");
				}else{
				try {
					JOptionPane.showMessageDialog(frmContrato, "Encanador:\n " + NomeEncanador.getText() +"\nadiconado no contrato!");
					Fachada fachada = Fachada.getInstance();
					Encanador encanador = fachada.encanadorProcurar(cpf);
					id_encanador = fachada.encanadorProcurar(cpf).getId_encanador();
//					encanador.setDisponibilidade("OCUPADO");
//					fachada.encandadorAtualizar(encanador);
					
							} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			

				
			}
		});
		button_4.setBounds(571, 72, 89, 23);
		painelEncanador.add(button_4);
		
		JButton button_8 = new JButton("Limpar");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textBuscaCPFEncanador.setText("");
				NomeEncanador.setText("");
				CelularEncanador.setText("");
				TelefoneEncanador.setText("");
			}
		});
		button_8.setBounds(571, 44, 89, 23);
		painelEncanador.add(button_8);
		
		JLabel lblCpf_4 = new JLabel("CPF:");
		lblCpf_4.setBounds(30, 15, 46, 14);
		painelEncanador.add(lblCpf_4);
		
		textBuscaCPFEncanador = new JTextField();
		textBuscaCPFEncanador.setBounds(81, 12, 119, 20);
		painelEncanador.add(textBuscaCPFEncanador);
		textBuscaCPFEncanador.setColumns(10);
		
		JButton btnListarDisponiveis_3 = new JButton("Listar Disponiveis");
		btnListarDisponiveis_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelEncanador window = new TelaListarDisponivelEncanador();
				window.frmEncanadoresDisponiveis.setVisible(true);
				
			}
		});
		btnListarDisponiveis_3.setBounds(380, 11, 139, 23);
		painelEncanador.add(btnListarDisponiveis_3);
		
		
		
		Panel PainelEletricista = new Panel();
		tabbedPane.addTab("Eletricista", null, PainelEletricista, null);
		PainelEletricista.setLayout(null);
		
		JButton btnBuscarEletricista = new JButton("Buscar Eletricista");
		btnBuscarEletricista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cpf = textBuscarCPFEletricista.getText();
				
				try {	
					Fachada.getInstance().eletricistaProcurar(cpf);
					Fachada fachada = Fachada.getInstance();
					if(fachada.eletricistaProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
						JOptionPane.showMessageDialog(frmContrato, "ELETRICISTA OCUPADO\nPOR FAVOR PROCURE OUTRO");
					}else{
						NomeEletricista.setText(fachada.eletricistaProcurar(cpf).getNome().toUpperCase());
						CelularEletricista.setText(fachada.eletricistaProcurar(cpf).getContato().getCelular());
						TelefoneEletricista.setText(fachada.eletricistaProcurar(cpf).getContato().getCelular());
						
						
					}
					
					
				} catch (EJT.Eletricista.CPFInvalidoException e) {
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
					
				} catch (EletricistaNaoEncontradoException e){	
					
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch (StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(frmContrato, "Digite o CPF do Eletricista para a busca ");	
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
				
				
				
				
				
			
		});
		btnBuscarEletricista.setBounds(251, 11, 160, 23);
		PainelEletricista.add(btnBuscarEletricista);
		
		JLabel label_6 = new JLabel("Nome: ");
		label_6.setBounds(30, 48, 46, 14);
		PainelEletricista.add(label_6);
		
		JLabel label_7 = new JLabel("Telefone: ");
		label_7.setBounds(30, 76, 66, 14);
		PainelEletricista.add(label_7);
		
		TelefoneEletricista = new JTextField();
		TelefoneEletricista.setColumns(10);
		TelefoneEletricista.setBounds(81, 70, 119, 20);
		PainelEletricista.add(TelefoneEletricista);
		
		NomeEletricista = new JTextField();
		NomeEletricista.setColumns(10);
		NomeEletricista.setBounds(81, 45, 359, 20);
		PainelEletricista.add(NomeEletricista);
		
		JLabel label_8 = new JLabel("Celular:");
		label_8.setBounds(210, 76, 46, 14);
		PainelEletricista.add(label_8);
		
		CelularEletricista = new JTextField();
		CelularEletricista.setColumns(10);
		CelularEletricista.setBounds(251, 70, 132, 20);
		PainelEletricista.add(CelularEletricista);
		
		JButton button_5 = new JButton("Contratar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				
				String cpf = textBuscarCPFEletricista.getText();
				if(NomeEletricista.getText().equals("")){
					JOptionPane.showMessageDialog(frmContrato, "Favor Escolher um Eletricista");
				}else{
				try {
					JOptionPane.showMessageDialog(frmContrato, "Eletricista:\n" + NomeEletricista.getText() +"\nadiconado no contrato!");
					Fachada fachada = Fachada.getInstance();
					Eletricista eletricista = fachada.eletricistaProcurar(cpf);
					id_eletricista = fachada.eletricistaProcurar(cpf).getId_eletricista();
//					eletricista.setDisponibilidade("OCUPADO");
//					fachada.eletricistaAtualizar(eletricista);					
							} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			

				
			
			
			
			}
		});
		button_5.setBounds(571, 72, 89, 23);
		PainelEletricista.add(button_5);
		
		JButton button_3 = new JButton("Limpar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	

				
						textBuscarCPFEletricista.setText("");
						NomeEletricista.setText("");
						CelularEletricista.setText("");
						TelefoneEletricista.setText("");
	
				
				
			}
		});
		button_3.setBounds(571, 44, 89, 23);
		PainelEletricista.add(button_3);
		
		JLabel lblCpf_5 = new JLabel("CPF:");
		lblCpf_5.setBounds(30, 15, 46, 14);
		PainelEletricista.add(lblCpf_5);
		
		textBuscarCPFEletricista = new JTextField();
		textBuscarCPFEletricista.setBounds(81, 12, 148, 20);
		PainelEletricista.add(textBuscarCPFEletricista);
		textBuscarCPFEletricista.setColumns(10);
		
		JButton btnListarDisponiveis_4 = new JButton("Listar Disponiveis");
		btnListarDisponiveis_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelEletricista window = new TelaListarDisponivelEletricista();
				window.frmEletricistasDisponiveis.setVisible(true);
				
			}
		});
		btnListarDisponiveis_4.setBounds(423, 11, 125, 23);
		PainelEletricista.add(btnListarDisponiveis_4);
		
		Panel painelJardineiro = new Panel();
		tabbedPane.addTab("Jardineiro", null, painelJardineiro, null);
		painelJardineiro.setLayout(null);
		
		JButton btnBuscarJardineiro = new JButton("Buscar Jardineiro");
		btnBuscarJardineiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				

				String cpf = BuscarCPFJardineiro.getText();
				
				try {	
					Fachada.getInstance().jardineiroProcurar(cpf);
					Fachada fachada = Fachada.getInstance();
					if(fachada.jardineiroProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
						JOptionPane.showMessageDialog(frmContrato, "JARDINEIRO OCUPADO\nPOR FAVOR PROCURE OUTRO");
					}else{
						NomeJardineiro.setText(fachada.jardineiroProcurar(cpf).getNome().toUpperCase());
						CelularJardineiro.setText(fachada.jardineiroProcurar(cpf).getContato().getCelular());
						TelefoneJardineiro.setText(fachada.jardineiroProcurar(cpf).getContato().getCelular());
					 
					
						
					}
					
					
				} catch (EJT.Jardineiro.CPFInvalidoException e){
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
					
				} catch (JardineiroNaoEncontradoException e) {
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch (StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(frmContrato, "Digite o CPF do Jardineiro para a busca ");	
						
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
				
				
				
				
			
		});
		btnBuscarJardineiro.setBounds(244, 11, 160, 23);
		painelJardineiro.add(btnBuscarJardineiro);
		
		JLabel label_9 = new JLabel("Nome: ");
		label_9.setBounds(30, 48, 46, 14);
		painelJardineiro.add(label_9);
		
		JLabel label_10 = new JLabel("Telefone: ");
		label_10.setBounds(30, 76, 66, 14);
		painelJardineiro.add(label_10);
		
		TelefoneJardineiro = new JTextField();
		TelefoneJardineiro.setColumns(10);
		TelefoneJardineiro.setBounds(81, 70, 119, 20);
		painelJardineiro.add(TelefoneJardineiro);
		
		NomeJardineiro = new JTextField();
		NomeJardineiro.setColumns(10);
		NomeJardineiro.setBounds(81, 45, 359, 20);
		painelJardineiro.add(NomeJardineiro);
		
		JLabel label_11 = new JLabel("Celular:");
		label_11.setBounds(210, 76, 46, 14);
		painelJardineiro.add(label_11);
		
		CelularJardineiro = new JTextField();
		CelularJardineiro.setColumns(10);
		CelularJardineiro.setBounds(251, 70, 132, 20);
		painelJardineiro.add(CelularJardineiro);
		
		JButton button_6 = new JButton("Contratar");//jardineiro
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			




				
				String cpf = BuscarCPFJardineiro.getText();
				if(NomeJardineiro.getText().equals("")){
					JOptionPane.showMessageDialog(frmContrato, "Favor Escolher um Jardineiro");
				}else{
				try {
					JOptionPane.showMessageDialog(frmContrato, "Jardineiro:\n" + NomeJardineiro.getText() +"\nadiconado no contrato!");
					Fachada fachada = Fachada.getInstance();
					Jardineiro jardineiro = fachada.jardineiroProcurar(cpf);
					 id_jardineiro =fachada.jardineiroProcurar(cpf).getId_jardineiro();	 
//					jardineiro.setDisponibilidade("OCUPADO");
//					fachada.jardineiroAtualizar(jardineiro);					
							} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			

				
			
			
			
			
			
			
			
			
			}
		});
		button_6.setBounds(571, 72, 89, 23);
		painelJardineiro.add(button_6);
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
						BuscarCPFJardineiro.setText("");
			
						NomeJardineiro.setText("");
						CelularJardineiro.setText("");
						TelefoneJardineiro.setText("");
				
				
			}
		});
		btnNewButton_2.setBounds(571, 44, 89, 23);
		painelJardineiro.add(btnNewButton_2);
		
		JLabel lblCpf_6 = new JLabel("CPF:");
		lblCpf_6.setBounds(30, 15, 46, 14);
		painelJardineiro.add(lblCpf_6);
		
		BuscarCPFJardineiro = new JTextField();
		BuscarCPFJardineiro.setBounds(81, 12, 148, 20);
		painelJardineiro.add(BuscarCPFJardineiro);
		BuscarCPFJardineiro.setColumns(10);
		
		JButton btnListarDisponiveis_5 = new JButton("Listar Disponiveis");
		btnListarDisponiveis_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelJardineiro window = new TelaListarDisponivelJardineiro();
				window.frame.setVisible(true);
			}
		});
		btnListarDisponiveis_5.setBounds(414, 11, 119, 23);
		painelJardineiro.add(btnListarDisponiveis_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(153, 180, 209), 2));
		panel_2.setBounds(20, 167, 715, 117);
		frmContrato.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setBounds(54, 33, 327, 20);
		panel_2.add(textFieldNomeCliente);
		textFieldNomeCliente.setText("");
		textFieldNomeCliente.setColumns(10);
		
		JLabel lblCliente = new JLabel("Nome:");
		lblCliente.setBounds(10, 36, 46, 14);
		panel_2.add(lblCliente);
		
		JLabel lblTelefone = new JLabel("Tel.:");
		lblTelefone.setBounds(388, 61, 46, 14);
		panel_2.add(lblTelefone);
		
		textTelCliente = new JTextField();
		textTelCliente.setBounds(436, 58, 129, 20);
		panel_2.add(textTelCliente);
		textTelCliente.setColumns(10);
		
		JLabel lblContato = new JLabel("Cel.:");
		lblContato.setBounds(388, 39, 46, 14);
		panel_2.add(lblContato);
		
		textCelCliente = new JTextField();
		textCelCliente.setBounds(436, 33, 129, 20);
		panel_2.add(textCelCliente);
		textCelCliente.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente ");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnpj = textCpfCliente.getText();
				
				try {
					Fachada.getInstance().clienteJuridicoProcurar(cnpj);
					Fachada fachada = Fachada.getInstance();
					textFieldNomeCliente.setText(fachada.clienteJuridicoProcurar(cnpj).getNome().toUpperCase());
					textRuaCliente.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getLogradouro().toUpperCase().toUpperCase());
					textBairroCliente.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getBairro().toUpperCase());
					textCidadeCliente.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getCidade().toUpperCase());
					textEstadoCliente.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getEstado().toUpperCase());
					textCepCliente.setText(fachada.clienteJuridicoProcurar(cnpj).getEndereco().getCep());
					textCelCliente.setText(fachada.clienteJuridicoProcurar(cnpj).getContato().getCelular());
					textTelCliente.setText(fachada.clienteJuridicoProcurar(cnpj).getContato().getTelefone());	
					id_clienteJuridico = fachada.clienteJuridicoProcurar(cnpj).getId_juridico();
					
				} catch (CNPJInvalidoException e){
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
					
				} catch (ClienteJuridicoNaoEncontradoException e ){
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch (StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(frmContrato, "Digite o CNPJ do Cliente a ser atendido! ");	
						
					
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnBuscarCliente.setBounds(243, 5, 128, 23);
		panel_2.add(btnBuscarCliente);
		
		JButton btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastroClienteJuridico window = new TelaCadastroClienteJuridico();	
				window.frmCadastroClienteJuridico.setVisible(true);
		
			
			}
		});
		btnNovoCliente.setBounds(572, 7, 118, 23);
		panel_2.add(btnNovoCliente);
		
		JLabel lblCpf_3 = new JLabel("CNPJ:");
		lblCpf_3.setBounds(10, 11, 46, 14);
		panel_2.add(lblCpf_3);
		
		textCpfCliente = new JTextField();
		textCpfCliente.setBounds(54, 8, 129, 20);
		panel_2.add(textCpfCliente);
		textCpfCliente.setColumns(10);
		
		JButton btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaBuscarClienteJuridico window = new TelaBuscarClienteJuridico();
				window.frmBuscarClienteJuridico.setVisible(true);
				
			}
		});
		btnAlterarCliente.setBounds(575, 42, 115, 23);
		panel_2.add(btnAlterarCliente);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(20, 61, 46, 14);
		panel_2.add(lblRua);
		
		textRuaCliente = new JTextField();
		textRuaCliente.setBounds(54, 58, 170, 20);
		panel_2.add(textRuaCliente);
		textRuaCliente.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(227, 61, 46, 14);
		panel_2.add(lblBairro);
		
		textBairroCliente = new JTextField();
		textBairroCliente.setBounds(263, 58, 118, 20);
		panel_2.add(textBairroCliente);
		textBairroCliente.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 86, 46, 14);
		panel_2.add(lblCidade);
		
		textCidadeCliente = new JTextField();
		textCidadeCliente.setBounds(54, 83, 207, 20);
		panel_2.add(textCidadeCliente);
		textCidadeCliente.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(286, 89, 46, 14);
		panel_2.add(lblEstado);
		
		textEstadoCliente = new JTextField();
		textEstadoCliente.setBounds(331, 83, 46, 20);
		panel_2.add(textEstadoCliente);
		textEstadoCliente.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(388, 86, 46, 14);
		panel_2.add(lblCep);
		
		textCepCliente = new JTextField();
		textCepCliente.setBounds(436, 83, 129, 20);
		panel_2.add(textCepCliente);
		textCepCliente.setColumns(10);
		
		JButton btnListarTodos_1 = new JButton("Listar Todos");
		btnListarTodos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaListarClienteJuridico window = new TelaListarClienteJuridico();
				window.frame.setVisible(true);
			}
		});
		btnListarTodos_1.setBounds(384, 5, 118, 23);
		panel_2.add(btnListarTodos_1);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new LineBorder(SystemColor.activeCaption, 2));
		painelBotoes.setBounds(20, 517, 715, 44);
		frmContrato.getContentPane().add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Concluir Contrato");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					CadastrarContratoJuridico();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				
				
				
			}
		});
		btnNewButton_1.setBounds(540, 11, 143, 23);
		painelBotoes.add(btnNewButton_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmContrato.dispose();
				
			}
		});
		btnCancelar.setBounds(441, 11, 89, 23);
		painelBotoes.add(btnCancelar);
		
		JLabel lblHorario = new JLabel("");
		lblHorario.setBounds(138, 11, 178, 23);
		painelBotoes.add(lblHorario);
		
	    CampoDescricao = new TextArea();
		CampoDescricao.setText("DESCRI\u00C7\u00C3O DE SERVI\u00C7O");
		CampoDescricao.setBounds(20, 427, 715, 84);
		frmContrato.getContentPane().add(CampoDescricao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		panel_1.setBounds(20, 11, 520, 62);
		frmContrato.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCpf_8 = new JLabel("CPF:");
		lblCpf_8.setBounds(31, 11, 48, 14);
		panel_1.add(lblCpf_8);
		
		textFieldGerenteCpf = new JTextField();
		textFieldGerenteCpf.setBounds(89, 8, 142, 20);
		panel_1.add(textFieldGerenteCpf);
		textFieldGerenteCpf.setColumns(10);
		
		textFieldGerenteNome = new JTextField();
		textFieldGerenteNome.setBounds(89, 31, 397, 20);
		panel_1.add(textFieldGerenteNome);
		textFieldGerenteNome.setColumns(10);
		
		JLabel lblGerente = new JLabel("Gerente:");
		lblGerente.setBounds(10, 34, 69, 14);
		panel_1.add(lblGerente);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldGerenteCpf.getText();
				
				try {
					textFieldGerenteNome.setText(Fachada.getInstance().gerenteProcurar(cpf).getNome().toUpperCase());
					id_gerente = Fachada.getInstance().gerenteProcurar(cpf).getId_gerente();
					
					
				} catch (EJT.Gerente.CPFInvalidoException e)	{	
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);	
					
				} catch(GerenteNaoEncontradoExceptio e){		
					JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				} catch (StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(frmContrato, "Digite o CPF do Gerente para a busca ");	
					
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnBuscar_1.setBounds(241, 7, 89, 23);
		panel_1.add(btnBuscar_1);
		
		
		
		
	}
		
		
		public void CadastrarContratoJuridico() throws Exception {
			
			Fachada fachada = Fachada.getInstance();
			
			
			if(textFieldNomeCliente.getText().equals("")){
				JOptionPane.showMessageDialog(frmContrato, "Por favor escolha um cliente");
			}
			else if(id_engenheiro==0){
				JOptionPane.showMessageDialog(frmContrato, "Falta escolher um Engenheiro");
			}
			else if(id_arquiteto==0){
				JOptionPane.showMessageDialog(frmContrato, "Falta escolher um Arquiteto");
			}
			else if(id_eletricista==0){
				JOptionPane.showMessageDialog(frmContrato, "Falta escolher um Eletricista");
			}
			else if(id_encanador==0){
				JOptionPane.showMessageDialog(frmContrato, "Falta escolher um Encanador");
			}
			else if(id_jardineiro==0){
				JOptionPane.showMessageDialog(frmContrato, "Falta escolher um Jardineiro");
			}
			else if(id_mestre==0){
				JOptionPane.showMessageDialog(frmContrato, "Falta esolher um Mestre de Obra");
				
			} else if (textFieldAtendenteNome.getText().equals("")){
				JOptionPane.showMessageDialog(frmContrato, "Falta escolhar um atendente");
				
			}
			else{
				descricao = CampoDescricao.getText();
				
				ArrayList<Empresa> listar = Fachada.getInstance().empresaListar();
				for(Empresa empresa : listar){
					cnpj += empresa.getCnpj();
				}

				ContratoJuridico contratoJuridico = new ContratoJuridico(id_arquiteto, id_atendente, id_clienteJuridico, id_eletricista, id_encanador, id_engenheiro, id_gerente, id_jardineiro, id_mestre, cnpj, descricao);
				frmContrato.dispose();
				try {
					Fachada.getInstance().contratoJuridicoCadastrar(contratoJuridico);
					JOptionPane.showMessageDialog(frmContrato, "Contrato Feito com Sucesso!");
					idContrato = contratoJuridico.getIdContrato();
					registrocontratopj();
					
					
				} catch (CPFInvalidoException e1) {
					JOptionPane.showMessageDialog(frmContrato, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmContrato, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
		
			
			
			
		}


			private void registrocontratopj() throws Exception {
				Fachada fachada = Fachada.getInstance();
				String cpf = textCpfCliente.getText();
				
				Calendar calendar = new GregorianCalendar();
				Date trialTime = new Date();
				calendar.setTime(trialTime);
				
				
				String caminho = "registrocontratopj.txt";
				Path path = Paths.get(caminho);

				Charset utf8 = StandardCharsets.UTF_8;
				BufferedWriter escrever = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND);
				escrever.newLine();
				escrever.write("-----------------------INICIO CONTRATO-------------------------------------");
				escrever.newLine();
				escrever.write("Numero Contrato: " + idContrato);
				escrever.write("DATA: " + calendar.getTime().toLocaleString());
				escrever.newLine();
				escrever.write("Atendente: " + textFieldAtendenteNome.getText());
				escrever.newLine();
				escrever.write("Cliente: " + textFieldNomeCliente.getText().toUpperCase() + " Contato: " + textCelCliente.getText());
				escrever.newLine();	
				escrever.write("\rEngenheiro: " + textNomeEngenheiro.getText().toUpperCase() + " Contato: " + textCelularEngenheiro.getText());
				escrever.newLine();
				escrever.write("\rArquiteto: " + textNomeArquiteto.getText().toUpperCase() + " Contato: " + textTelefoneArquiteto.getText());
				escrever.newLine();
				escrever.write("Mestre de Obra: " + textNomeMestre.getText().toUpperCase() + " Contato: " + textTelMestre.getText());
				escrever.newLine();
				escrever.write("Eletricista: " + NomeEletricista.getText().toUpperCase()+ " Contato: " + CelularEletricista.getText());
				escrever.newLine();
				escrever.write("Encanador: " + NomeEncanador.getText().toUpperCase()+ " Contato: " + CelularEncanador.getText());
				escrever.newLine();
				escrever.write("Jardineiro: " + NomeJardineiro.getText().toUpperCase()+ " Contato: " + CelularJardineiro.getText());
				escrever.newLine();
				escrever.write("DESCRIÇÃO DO SERVIÇO" + txtpnDescricao.getText());
				escrever.newLine();
				escrever.write("\n----------------------------FIM CONTRATO------------------------------");
				escrever.flush();//sempre usar flush
				escrever.close();//semrpe fechar aqruivo
				
				frmContrato.dispose();
				
			}

		}
	

