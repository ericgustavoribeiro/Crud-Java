package EJT.Engenheiro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.JobAttributes;
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

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import EJT.Util.teclasPermitidas;


public class TelaBuscarEngenheiro {

	public JFrame frmBuscarEngenheiro;
	private JTextField textFieldCpf;
	Fachada fachada;
	Engenheiro engenheiro;
	Contato contato;
	Endereco endereco;
	
	private JTextField textFieldNome;
	private JTextField textFieldCREA;
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
					TelaBuscarEngenheiro window = new TelaBuscarEngenheiro();
					window.frmBuscarEngenheiro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarEngenheiro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarEngenheiro = new JFrame();
		frmBuscarEngenheiro.getContentPane().setBackground(Color.WHITE);
		frmBuscarEngenheiro.setTitle("BUSCAR ENGENHEIRO");
		frmBuscarEngenheiro.setBounds(100, 100, 556, 431);
		frmBuscarEngenheiro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarEngenheiro.getContentPane().setLayout(null);
		
		frmBuscarEngenheiro.setUndecorated(true);
	    frmBuscarEngenheiro.setLocationRelativeTo(null); 
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(114, 30, 38, 14);
		frmBuscarEngenheiro.getContentPane().add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(162, 27, 138, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldCpf.getText();
				
			try {
				
				Fachada.getInstance().engenheiroProcurar(cpf);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldNome.setText(fachada.engenheiroProcurar(cpf).getNome().toUpperCase());
				textFieldCREA.setText(fachada.engenheiroProcurar(cpf).getCrea());
				textFieldCpf.setText(fachada.engenheiroProcurar(cpf).getCpf());
				textFieldRG.setText(fachada.engenheiroProcurar(cpf).getRg());
                textFieldDisponibilidade.setText(fachada.engenheiroProcurar(cpf).getDisponibilidade().toUpperCase());
				
			
				
				textFieldEmail.setText(fachada.engenheiroProcurar(cpf).getContato().getEmail());
				textFieldCel.setText(fachada.engenheiroProcurar(cpf).getContato().getCelular());
				textFieldTel.setText(fachada.engenheiroProcurar(cpf).getContato().getTelefone());
				
				
				textFieldRua.setText(fachada.engenheiroProcurar(cpf).getEndereco().getLogradouro().toUpperCase());
				textFieldBairro.setText(fachada.engenheiroProcurar(cpf).getEndereco().getBairro().toUpperCase());
				textFieldNumero.setText(fachada.engenheiroProcurar(cpf).getEndereco().getNumero());
				textFieldCEP.setText(fachada.engenheiroProcurar(cpf).getEndereco().getCep().toUpperCase());
				textFieldCidade.setText(fachada.engenheiroProcurar(cpf).getEndereco().getCidade().toUpperCase());
				textFieldEstado.setText(fachada.engenheiroProcurar(cpf).getEndereco().getEstado().toUpperCase());
				
				if(fachada.engenheiroProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
					textFieldDisponibilidade.setForeground(Color.RED);
				}else{
					textFieldDisponibilidade.setForeground(Color.GREEN);
				}
				
	
				
				
			} catch (CPFInvalidoException e1) {
				JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e1) {
				JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (EngenheiroNaoEncontradoException e1){
				JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (SQLException e1) {
				JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e1){
				JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		
				
			}
		});
		btnBuscar.setBounds(310, 26, 89, 23);
		frmBuscarEngenheiro.getContentPane().add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(54, 142, 46, 14);
		frmBuscarEngenheiro.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 139, 175, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCrea = new JLabel("CREA: ");
		lblCrea.setBounds(54, 117, 46, 14);
		frmBuscarEngenheiro.getContentPane().add(lblCrea);
		
		textFieldCREA = new JTextField();
		textFieldCREA.setBounds(110, 111, 86, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldCREA);
		textFieldCREA.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(206, 117, 46, 14);
		frmBuscarEngenheiro.getContentPane().add(lblRg);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(246, 111, 86, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldRG);
		textFieldRG.setColumns(10);
		textFieldRG.setDocument(new teclasPermitidas());

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(54, 173, 46, 14);
		frmBuscarEngenheiro.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(110, 170, 384, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(54, 239, 46, 14);
		frmBuscarEngenheiro.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(54, 274, 46, 14);
		frmBuscarEngenheiro.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(54, 308, 46, 14);
		frmBuscarEngenheiro.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(338, 239, 146, 14);
		frmBuscarEngenheiro.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(358, 236, 136, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 540, 56);
		frmBuscarEngenheiro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBuscarEngenheiro.dispose();
			}
		});
		btnSair.setToolTipText("Fui.....");
		btnSair.setBounds(419, 11, 74, 34);
		btnSair.setBounds(456, 11, 74, 34);
		panel.add(btnSair);
		
		
		JButton btnRemoverEngenheiro = new JButton("Excluir");
		btnRemoverEngenheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frmBuscarEngenheiro, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().engenheiroRemover(cpf);
						Fachada fachada = Fachada.getInstance();
					
					} catch (CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (EngenheiroNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				
				}

				
			
			}
		});
		
		
		btnRemoverEngenheiro.setBounds(192, 17, 74, 23);
		panel.add(btnRemoverEngenheiro);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = JOptionPane.showConfirmDialog(
						frmBuscarEngenheiro,
						"ATENÇÃO!!!"
						+ "\nConfirme antes a disponibilidade: " + comboBoxdDisponibilidade.getSelectedItem() +"\n"
								+ "\n"
								+ "Deseja Alterar os dados modificados?\n" ,
						"Alterar Dados", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(resultado == JOptionPane.YES_OPTION){	
				
				try{
				
				
				String cpf = textFieldCpf.getText();
				Fachada fachada = Fachada.getInstance();
				Engenheiro engenheiro = fachada.engenheiroProcurar(cpf);
				Endereco endereco = engenheiro.getEndereco();
				Contato contato = engenheiro.getContato();
				
				engenheiro.setNome(textFieldNome.getText());
				engenheiro.setCrea(textFieldCREA.getText());
				engenheiro.setRg(textFieldRG.getText());
				engenheiro.setDisponibilidade((String) comboBoxdDisponibilidade.getSelectedItem());
			
				
				endereco.setLogradouro(textFieldRua.getText());
				endereco.setNumero(textFieldNumero.getText());
				endereco.setBairro(textFieldBairro.getText());
				endereco.setCidade(textFieldCidade.getText());
				endereco.setEstado(textFieldEstado.getText());
				endereco.setCep(textFieldCEP.getText());
				engenheiro.setEndereco(endereco);
				
				contato.setEmail(textFieldEmail.getText());
				contato.setTelefone(textFieldTel.getText());
				contato.setCelular(textFieldCel.getText());
				engenheiro.setContato(contato);
				
				fachada.engenheiroAtualizar(engenheiro);
				} catch (CPFInvalidoException e1) {
					JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (EngenheiroNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarEngenheiro, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			}
		});
		btnAtualizar.setBounds(319, 17, 85, 23);
		panel.add(btnAtualizar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroEngenheiro window = new TelaCadastroEngenheiro();
				window.frmCadastroEngenheiro.setVisible(true);
			}
		});
		btnNovo.setBounds(37, 17, 89, 23);
		panel.add(btnNovo);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 236, 222, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(110, 271, 175, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(292, 274, 46, 14);
		frmBuscarEngenheiro.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(348, 271, 146, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(110, 305, 222, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(338, 308, 146, 14);
		frmBuscarEngenheiro.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(358, 305, 136, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(64, 198, 46, 14);
		frmBuscarEngenheiro.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(110, 195, 103, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 198, 46, 14);
		frmBuscarEngenheiro.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(251, 195, 115, 20);
		frmBuscarEngenheiro.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		
	
		
		JLabel lblDisponibilidade = new JLabel("Disponibilidade: ");
		lblDisponibilidade.setBounds(93, 78, 106, 27);
		frmBuscarEngenheiro.getContentPane().add(lblDisponibilidade);
		
		
		JPanel panelBuscarCpf = new JPanel();
		panelBuscarCpf.setBounds(93, 11, 324, 56);
		frmBuscarEngenheiro.getContentPane().add(panelBuscarCpf);
		
		textFieldDisponibilidade.setBounds(197, 84, 103, 14);
		frmBuscarEngenheiro.getContentPane().add

(textFieldDisponibilidade);

comboBoxdDisponibilidade = new JComboBox(disponibilidade);
		comboBoxdDisponibilidade.setBounds(323, 81, 95, 20);
		frmBuscarEngenheiro.getContentPane().add

(comboBoxdDisponibilidade);
		
		
		

	}
}
