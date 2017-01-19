package EJT.Jardineiro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import EJT.Contato.Contato;
import EJT.Jardineiro.TelaCadastroJardineiro;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import EJT.Gerente.CPFInvalidoException;
import EJT.Gerente.CampoObrigatorioException;
import EJT.Gerente.GerenteJaCadastradoException;
import EJT.Util.teclasPermitidas;

public class TelaBuscarJardineiro extends JFrame {

	private JPanel contentPane;

	public JFrame frmBuscarJardineiro;
	private JTextField textFieldCpf;
	Jardineiro jardineiro;
	Fachada fachada;
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
					TelaBuscarJardineiro window = new TelaBuscarJardineiro();
					window.frmBuscarJardineiro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarJardineiro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarJardineiro = new JFrame();
		frmBuscarJardineiro.getContentPane().setBackground(Color.WHITE);
		frmBuscarJardineiro.setTitle("BUSCAR JARDINEIRO");
		frmBuscarJardineiro.setBounds(100, 100, 556, 431);
		frmBuscarJardineiro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarJardineiro.getContentPane().setLayout(null);
		
		frmBuscarJardineiro.setUndecorated(true);
	    frmBuscarJardineiro.setLocationRelativeTo(null); 
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(114, 30, 38, 14);
		frmBuscarJardineiro.getContentPane().add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(162, 27, 138, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldCpf.getText();
			try {
				
				Fachada fachada = Fachada.getInstance();
				Fachada.getInstance().jardineiroProcurar(cpf);
				
				
				
				textFieldNome.setText(fachada.jardineiroProcurar(cpf).getNome().toUpperCase());
				textFieldCpf.setText(fachada.jardineiroProcurar(cpf).getCpf());
				textFieldRG.setText(fachada.jardineiroProcurar(cpf).getRg());
				
				if(fachada.jardineiroProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
					textFieldDisponibilidade.setForeground(Color.RED);
				}else{
					textFieldDisponibilidade.setForeground(Color.GREEN);
				}
				textFieldDisponibilidade.setText(fachada.jardineiroProcurar(cpf).getDisponibilidade().toUpperCase());
				
				
				
				
				textFieldEmail.setText(fachada.jardineiroProcurar(cpf).getContato().getEmail());
				textFieldCel.setText(fachada.jardineiroProcurar(cpf).getContato().getCelular());
				textFieldTel.setText(fachada.jardineiroProcurar(cpf).getContato().getTelefone());
				
				
				textFieldRua.setText(fachada.jardineiroProcurar(cpf).getEndereco().getLogradouro().toUpperCase());
				textFieldBairro.setText(fachada.jardineiroProcurar(cpf).getEndereco().getBairro().toUpperCase());
				textFieldNumero.setText(fachada.jardineiroProcurar(cpf).getEndereco().getNumero());
				textFieldCEP.setText(fachada.jardineiroProcurar(cpf).getEndereco().getCep().toUpperCase());
				textFieldCidade.setText(fachada.jardineiroProcurar(cpf).getEndereco().getCidade().toUpperCase());
				textFieldEstado.setText(fachada.jardineiroProcurar(cpf).getEndereco().getEstado().toUpperCase());
				
				
				
				
				
			} catch (EJT.Jardineiro.CPFInvalidoException e) {
				JOptionPane.showMessageDialog(frmBuscarJardineiro, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (JardineiroNaoEncontradoException e){
				JOptionPane.showMessageDialog(frmBuscarJardineiro, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (EJT.Jardineiro.CampoObrigatorioException e) {
				JOptionPane.showMessageDialog(frmBuscarJardineiro, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frmBuscarJardineiro, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e){
				JOptionPane.showMessageDialog(frmBuscarJardineiro, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} 

				
			}
		});
		btnBuscar.setBounds(310, 26, 89, 23);
		frmBuscarJardineiro.getContentPane().add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(54, 142, 46, 14);
		frmBuscarJardineiro.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 139, 175, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(54, 114, 46, 14);
		frmBuscarJardineiro.getContentPane().add(lblRg);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(109, 111, 86, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldRG);
		textFieldRG.setColumns(10);
		textFieldRG.setDocument(new teclasPermitidas());

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(54, 173, 46, 14);
		frmBuscarJardineiro.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(110, 170, 384, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(54, 239, 46, 14);
		frmBuscarJardineiro.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(54, 274, 46, 14);
		frmBuscarJardineiro.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(54, 308, 46, 14);
		frmBuscarJardineiro.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(338, 239, 146, 14);
		frmBuscarJardineiro.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(358, 236, 136, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 540, 56);
		frmBuscarJardineiro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBuscarJardineiro.dispose();
			}
		});
		btnSair.setBounds(456, 11, 74, 34);
		panel.add(btnSair);
		
		
		JButton btnRemoverJardineiro = new JButton("REMOVER JARDINEIRO");
		btnRemoverJardineiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frmBuscarJardineiro, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().jardineiroRemover(cpf);
						Fachada fachada = Fachada.getInstance();
						JOptionPane.showMessageDialog(frmBuscarJardineiro, "Removido com Sucesso!");
					
					} catch (EJT.Jardineiro.CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frmBuscarJardineiro, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (JardineiroNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarJardineiro, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (EJT.Jardineiro.CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarJardineiro, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarJardineiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarJardineiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					} 
				}

				
			
			}
		});
		btnRemoverJardineiro.setBounds(119, 17, 178, 23);
		panel.add(btnRemoverJardineiro);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int resultado = JOptionPane.showConfirmDialog(
						frmBuscarJardineiro,
						"ATENÇÃO!!!"
						+ "\nConfirme antes a disponibilidade: " + comboBoxdDisponibilidade.getSelectedItem() +"\n"
								+ "\n"
								+ "Deseja Alterar os dados modificados?\n" ,
						"Alterar Dados", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(resultado == JOptionPane.YES_OPTION){
				
				String cpf = textFieldCpf.getText();
				try{
				
				Fachada fachada = Fachada.getInstance();
				Jardineiro jardineiro = fachada.jardineiroProcurar(cpf);
				Endereco endereco = jardineiro.getEndereco();
				Contato contato = jardineiro.getContato();
				
				jardineiro.setNome(textFieldNome.getText());
				jardineiro.setRg(textFieldRG.getText());
				jardineiro.setDisponibilidade((String) comboBoxdDisponibilidade.getSelectedItem());

				
				endereco.setLogradouro(textFieldRua.getText());
				endereco.setNumero(textFieldNumero.getText());
				endereco.setBairro(textFieldBairro.getText());
				endereco.setCidade(textFieldCidade.getText());
				endereco.setEstado(textFieldEstado.getText());
				endereco.setCep(textFieldCEP.getText());
				jardineiro.setEndereco(endereco);
				
				contato.setEmail(textFieldEmail.getText());
				contato.setTelefone(textFieldTel.getText());
				contato.setCelular(textFieldCel.getText());
				jardineiro.setContato(contato);
				
				fachada.jardineiroAtualizar(jardineiro);
				
				} catch (EJT.Jardineiro.CPFInvalidoException e1) {
					JOptionPane.showMessageDialog(frmBuscarJardineiro, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (JardineiroNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarJardineiro, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (EJT.Jardineiro.CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarJardineiro, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarJardineiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarJardineiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Throwable e1) {

				e1.printStackTrace();
			}
			
			
			}
	}
		});
		btnAtualizar.setBounds(322, 17, 109, 23);
		panel.add(btnAtualizar);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastroJardineiro window = new TelaCadastroJardineiro();
				window.frmCadastroJardineiro.setVisible(true);
				
				
			}
		});
		btnNovo.setBounds(10, 17, 89, 23);
		panel.add(btnNovo);
		
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 236, 222, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(110, 271, 175, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(292, 274, 46, 14);
		frmBuscarJardineiro.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(348, 271, 146, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(110, 305, 298, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(418, 308, 28, 14);
		frmBuscarJardineiro.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(456, 305, 38, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(54, 198, 46, 14);
		frmBuscarJardineiro.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(110, 195, 103, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 198, 46, 14);
		frmBuscarJardineiro.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(251, 195, 115, 20);
		frmBuscarJardineiro.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		
		
		JLabel lblDisponibilidade = new JLabel("Disponibilidade: ");
		lblDisponibilidade.setBounds(93, 79, 106, 27);
		frmBuscarJardineiro.getContentPane().add(lblDisponibilidade);
		
		
		JPanel panelBuscarCpf = new JPanel();
		panelBuscarCpf.setBounds(93, 11, 324, 56);
		frmBuscarJardineiro.getContentPane().add(panelBuscarCpf);
		
		textFieldDisponibilidade.setBounds(197, 84, 103, 14);
		frmBuscarJardineiro.getContentPane().add

(textFieldDisponibilidade);

comboBoxdDisponibilidade = new JComboBox(disponibilidade);
		comboBoxdDisponibilidade.setBounds(323, 81, 95, 20);
		frmBuscarJardineiro.getContentPane().add

(comboBoxdDisponibilidade);
		
	//ok	
		

	}

}
