package EJT.Eletricista;

import java.awt.EventQueue;
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

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import EJT.MestredeObras.MestreDeObras;
import EJT.Util.teclasPermitidas;

import javax.swing.JFrame;

import java.awt.Window.Type;

public class TelaBuscarEletricista {

	
	public JFrame frmBuscarEletricista;
	private JTextField textFieldCpf;
	Fachada fachada;
	Eletricista eletricista;
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
					TelaBuscarEletricista window = new TelaBuscarEletricista();
					window.frmBuscarEletricista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarEletricista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarEletricista = new JFrame();
		frmBuscarEletricista.setType(Type.UTILITY);
		frmBuscarEletricista.getContentPane().setBackground(Color.WHITE);
		frmBuscarEletricista.setTitle("BUSCAR ELETRICISTA");
		frmBuscarEletricista.setBounds(100, 100, 556, 431);
		frmBuscarEletricista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarEletricista.getContentPane().setLayout(null);
		
		frmBuscarEletricista.setUndecorated(true);
	    frmBuscarEletricista.setLocationRelativeTo(null); 
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(114, 30, 38, 14);
		frmBuscarEletricista.getContentPane().add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(162, 27, 138, 20);
		frmBuscarEletricista.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldCpf.getText();
			try {
				
				Fachada.getInstance().eletricistaProcurar(cpf);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldNome.setText(fachada.eletricistaProcurar(cpf).getNome().toUpperCase());
				textFieldCpf.setText(fachada.eletricistaProcurar(cpf).getCpf());
				textFieldRG.setText(fachada.eletricistaProcurar(cpf).getRg());
				
				if(fachada.eletricistaProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
					textFieldDisponibilidade.setForeground(Color.RED);
				}else{
					textFieldDisponibilidade.setForeground(Color.GREEN);
				}
				textFieldDisponibilidade.setText(fachada.eletricistaProcurar(cpf).getDisponibilidade().toUpperCase());
				
			
				
				
				textFieldEmail.setText(fachada.eletricistaProcurar(cpf).getContato().getEmail());
				textFieldCel.setText(fachada.eletricistaProcurar(cpf).getContato().getCelular());
				textFieldTel.setText(fachada.eletricistaProcurar(cpf).getContato().getTelefone());
				
				
				textFieldRua.setText(fachada.eletricistaProcurar(cpf).getEndereco().getLogradouro().toUpperCase());
				textFieldBairro.setText(fachada.eletricistaProcurar(cpf).getEndereco().getBairro().toUpperCase());
				textFieldNumero.setText(fachada.eletricistaProcurar(cpf).getEndereco().getNumero());
				textFieldCEP.setText(fachada.eletricistaProcurar(cpf).getEndereco().getCep().toUpperCase());
				textFieldCidade.setText(fachada.eletricistaProcurar(cpf).getEndereco().getCidade().toUpperCase());
				textFieldEstado.setText(fachada.eletricistaProcurar(cpf).getEndereco().getEstado().toUpperCase());
				
				
				
				
			} catch (CPFInvalidoException e) {
				JOptionPane.showMessageDialog(frmBuscarEletricista, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (EletricistaNaoEncontradoException e){
				JOptionPane.showMessageDialog(frmBuscarEletricista, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e) {
				JOptionPane.showMessageDialog(frmBuscarEletricista, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frmBuscarEletricista, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e){
				JOptionPane.showMessageDialog(frmBuscarEletricista, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} 
				
			}
		});
		btnBuscar.setBounds(310, 26, 89, 23);
		frmBuscarEletricista.getContentPane().add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(54, 142, 46, 14);
		frmBuscarEletricista.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 139, 175, 20);
		frmBuscarEletricista.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(63, 117, 46, 14);
		frmBuscarEletricista.getContentPane().add(lblRg);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(110, 114, 86, 20);
		frmBuscarEletricista.getContentPane().add(textFieldRG);
		textFieldRG.setColumns(10);
		textFieldRG.setDocument(new teclasPermitidas());

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(54, 173, 46, 14);
		frmBuscarEletricista.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(110, 170, 384, 20);
		frmBuscarEletricista.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(54, 239, 46, 14);
		frmBuscarEletricista.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(54, 274, 46, 14);
		frmBuscarEletricista.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(54, 308, 46, 14);
		frmBuscarEletricista.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(338, 239, 146, 14);
		frmBuscarEletricista.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(358, 236, 136, 20);
		frmBuscarEletricista.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 540, 56);
		frmBuscarEletricista.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBuscarEletricista.dispose();
			}
		});
		btnSair.setBounds(417, 8, 83, 40);
		panel.add(btnSair);
		
		JButton btnAlterar = new JButton("Atualizar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(
						frmBuscarEletricista,
						"ATENÇÃO!!!"
						+ "\nConfirme antes a disponibilidade: " + comboBoxdDisponibilidade.getSelectedItem() +"\n"
								+ "\n"
								+ "Deseja Alterar os dados modificados?\n" ,
						"Alterar Dados", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(resultado == JOptionPane.YES_OPTION){
	try {
					String cpf = textFieldCpf.getText();
					
					Fachada fachada = Fachada.getInstance();
					Eletricista eletricista = fachada.eletricistaProcurar(cpf);
					Endereco endereco = eletricista.getEndereco();
					Contato contato = eletricista.getContato();
					
					eletricista.setNome(textFieldNome.getText());
					eletricista.setRg(textFieldRG.getText());
					eletricista.setDisponibilidade((String) comboBoxdDisponibilidade.getSelectedItem());
					
					endereco.setLogradouro(textFieldRua.getText());
					endereco.setNumero(textFieldNumero.getText());
					endereco.setBairro(textFieldBairro.getText());
					endereco.setCidade(textFieldCidade.getText());
					endereco.setEstado(textFieldEstado.getText());
					endereco.setCep(textFieldCEP.getText());
					eletricista.setEndereco(endereco);
					
					contato.setEmail(textFieldEmail.getText());
					contato.setTelefone(textFieldTel.getText());
					contato.setCelular(textFieldCel.getText());
					eletricista.setContato(contato);
					
					fachada.eletricistaAtualizar(eletricista);
					
					
	} catch (CPFInvalidoException e1) {
		JOptionPane.showMessageDialog(frmBuscarEletricista, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
	} catch (EletricistaNaoEncontradoException e1){
		JOptionPane.showMessageDialog(frmBuscarEletricista, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
	} catch (CampoObrigatorioException e1) {
		JOptionPane.showMessageDialog(frmBuscarEletricista, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
	} catch (SQLException e1) {
		JOptionPane.showMessageDialog(frmBuscarEletricista, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	}catch (Exception e1){
		JOptionPane.showMessageDialog(frmBuscarEletricista, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	} 
				}
			}
		});
		btnAlterar.setToolTipText("gerar um arquivo texto para imprimir");
		btnAlterar.setBounds(151, 17, 113, 23);
		panel.add(btnAlterar);
		
		JButton btnRemoverEletricista = new JButton("Excluir");
		btnRemoverEletricista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frmBuscarEletricista, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().eletricistaRemover(cpf);
						Fachada fachada = Fachada.getInstance();
						JOptionPane.showMessageDialog(frmBuscarEletricista, "Removido com Sucesso!");
					
					} catch (CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frmBuscarEletricista, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (EletricistaNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarEletricista, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarEletricista, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarEletricista, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarEletricista, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					} 
				}

				
			
			}
		});
		btnRemoverEletricista.setBounds(284, 17, 113, 23);
		panel.add(btnRemoverEletricista);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroEletricista window = new TelaCadastroEletricista();
				window.frmCadastroEletricista.setVisible(true);
			}
		});
		btnNovo.setBounds(28, 17, 89, 23);
		panel.add(btnNovo);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 236, 222, 20);
		frmBuscarEletricista.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(110, 271, 175, 20);
		frmBuscarEletricista.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(292, 274, 46, 14);
		frmBuscarEletricista.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(348, 271, 146, 20);
		frmBuscarEletricista.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(110, 305, 289, 20);
		frmBuscarEletricista.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(413, 308, 38, 14);
		frmBuscarEletricista.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(461, 305, 33, 20);
		frmBuscarEletricista.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(64, 198, 46, 14);
		frmBuscarEletricista.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(110, 195, 103, 20);
		frmBuscarEletricista.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 198, 46, 14);
		frmBuscarEletricista.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(251, 195, 115, 20);
		frmBuscarEletricista.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		
		JLabel lblDisponibilidade = new JLabel("Disponibilidade: ");
		lblDisponibilidade.setBounds(93, 79, 106, 27);
		frmBuscarEletricista.getContentPane().add(lblDisponibilidade);
		
		
		JPanel panelBuscarCpf = new JPanel();
		panelBuscarCpf.setBounds(93, 11, 324, 56);
		frmBuscarEletricista.getContentPane().add(panelBuscarCpf);
		
		textFieldDisponibilidade.setBounds(197, 84, 103, 14);
		frmBuscarEletricista.getContentPane().add(textFieldDisponibilidade);

        comboBoxdDisponibilidade = new JComboBox(disponibilidade);
		comboBoxdDisponibilidade.setBounds(323, 81, 95, 20);
		frmBuscarEletricista.getContentPane().add(comboBoxdDisponibilidade);
		
	
	}
}
	