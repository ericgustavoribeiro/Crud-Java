package EJT.Encanador;

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
import EJT.Util.teclasPermitidas;

import java.awt.Window.Type;

public class TelaBuscarEncanador {

	Encanador encanador;
	
	public JFrame frame;
	private JTextField textFieldCpf;
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
					TelaBuscarEncanador window = new TelaBuscarEncanador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarEncanador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("BUSCAR ENCANADOR");
		frame.setBounds(100, 100, 556, 431);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setUndecorated(true);
	    frame.setLocationRelativeTo(null); 
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(114, 30, 38, 14);
		frame.getContentPane().add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(162, 27, 138, 20);
		frame.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldCpf.getText();
			try {
				
				Fachada.getInstance().encanadorProcurar(cpf);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldNome.setText(fachada.encanadorProcurar(cpf).getNome().toUpperCase());
				textFieldCpf.setText(fachada.encanadorProcurar(cpf).getCpf());
				textFieldRG.setText(fachada.encanadorProcurar(cpf).getRg());
				
				if(fachada.encanadorProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
					textFieldDisponibilidade.setForeground(Color.RED);
				}else{
					textFieldDisponibilidade.setForeground(Color.GREEN);
				}
				textFieldDisponibilidade.setText(fachada.encanadorProcurar(cpf).getDisponibilidade().toUpperCase());
				
				
				
				
				textFieldEmail.setText(fachada.encanadorProcurar(cpf).getContato().getEmail());
				textFieldCel.setText(fachada.encanadorProcurar(cpf).getContato().getCelular());
				textFieldTel.setText(fachada.encanadorProcurar(cpf).getContato().getTelefone());
				
				
				textFieldRua.setText(fachada.encanadorProcurar(cpf).getEndereco().getLogradouro().toUpperCase());
				textFieldBairro.setText(fachada.encanadorProcurar(cpf).getEndereco().getBairro().toUpperCase());
				textFieldNumero.setText(fachada.encanadorProcurar(cpf).getEndereco().getNumero());
				textFieldCEP.setText(fachada.encanadorProcurar(cpf).getEndereco().getCep().toUpperCase());
				textFieldCidade.setText(fachada.encanadorProcurar(cpf).getEndereco().getCidade().toUpperCase());
				textFieldEstado.setText(fachada.encanadorProcurar(cpf).getEndereco().getEstado().toUpperCase());
				
				
				
				

			} catch (CPFInvalidoException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (EncanadorNaoEncontradoException e){
				JOptionPane.showMessageDialog(frame, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e){
				JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} 
				
			}
		});
		btnBuscar.setBounds(310, 26, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(54, 142, 46, 14);
		frame.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 139, 175, 20);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
	//	textFieldRG.setDocument(new teclasPermitidas());

		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(54, 114, 46, 14);
		frame.getContentPane().add(lblRg);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(109, 111, 86, 20);
		frame.getContentPane().add(textFieldRG);
		textFieldRG.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(54, 173, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(110, 170, 384, 20);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(54, 239, 46, 14);
		frame.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(54, 274, 46, 14);
		frame.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(54, 308, 46, 14);
		frame.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(338, 239, 146, 14);
		frame.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(358, 236, 136, 20);
		frame.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 540, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnSair.setBounds(456, 11, 74, 34);
		panel.add(btnSair);
		
		
		
		JButton btnRemoverEncanador = new JButton("Excluir");
		btnRemoverEncanador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frame, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().encanadorRemover(cpf);;
						Fachada fachada = Fachada.getInstance();
						JOptionPane.showMessageDialog(frame, "Removido com Sucesso!");
					} catch (CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (EncanadorNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					} 
				}

				
			
			}
		});
		
		
		btnRemoverEncanador.setBounds(180, 17, 100, 23);
		panel.add(btnRemoverEncanador);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = JOptionPane.showConfirmDialog(
						frame,
						"ATENÇÃO!!!"
						+ "\nConfirme antes a disponibilidade: " + comboBoxdDisponibilidade.getSelectedItem() +"\n"
								+ "\n"
								+ "Deseja Alterar os dados modificados?\n" ,
						"Alterar Dados", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(resultado == JOptionPane.YES_OPTION){
				
				
				try{
				
				
				String cpf = textFieldCpf.getText();
				Fachada fachada = Fachada.getInstance();
				Encanador encanador = fachada.encanadorProcurar(cpf);
				Endereco endereco = encanador.getEndereco();
				Contato contato = encanador.getContato();
				
				encanador.setNome(textFieldNome.getText());
				encanador.setRg(textFieldRG.getText());
				encanador.setDisponibilidade((String) comboBoxdDisponibilidade.getSelectedItem());
				
				endereco.setLogradouro(textFieldRua.getText());
				endereco.setNumero(textFieldNumero.getText());
				endereco.setBairro(textFieldBairro.getText());
				endereco.setCidade(textFieldCidade.getText());
				endereco.setEstado(textFieldEstado.getText());
				endereco.setCep(textFieldCEP.getText());
				encanador.setEndereco(endereco);
				
				contato.setEmail(textFieldEmail.getText());
				contato.setTelefone(textFieldTel.getText());
				contato.setCelular(textFieldCel.getText());
				encanador.setContato(contato);
				
				fachada.encandadorAtualizar(encanador);
			} catch (CPFInvalidoException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (EncanadorNaoEncontradoException e1){
				JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e1){
				JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} 
			
				}
			}
		});
		btnAtualizar.setBounds(321, 17, 88, 23);
		panel.add(btnAtualizar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroEncanador window = new TelaCadastroEncanador();
				window.frmCadastroEncanador.setVisible(true);
			}
		});
		btnNovo.setBounds(31, 17, 89, 23);
		panel.add(btnNovo);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 236, 222, 20);
		frame.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(110, 271, 175, 20);
		frame.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(292, 274, 46, 14);
		frame.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(348, 271, 146, 20);
		frame.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(110, 305, 222, 20);
		frame.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(338, 308, 146, 14);
		frame.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(358, 305, 136, 20);
		frame.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(54, 198, 46, 14);
		frame.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(110, 195, 103, 20);
		frame.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 198, 46, 14);
		frame.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(251, 195, 115, 20);
		frame.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		
		
		JLabel lblDisponibilidade = new JLabel("Disponibilidade: ");
		lblDisponibilidade.setBounds(93, 78, 106, 27);
		frame.getContentPane().add(lblDisponibilidade);
		
		
		JPanel panelBuscarCpf = new JPanel();
		panelBuscarCpf.setBounds(93, 11, 324, 56);
		frame.getContentPane().add(panelBuscarCpf);
		
		
		textFieldDisponibilidade.setBounds(197, 84, 103, 14);
		frame.getContentPane().add

(textFieldDisponibilidade);

comboBoxdDisponibilidade = new JComboBox(disponibilidade);
		comboBoxdDisponibilidade.setBounds(323, 81, 95, 20);
		frame.getContentPane().add(comboBoxdDisponibilidade);
	
		
		
		

	}

}
