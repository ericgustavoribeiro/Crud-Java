package EJT.MestredeObras;

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
import EJT.MestredeObras.TelaCadastroMestredeObras;
import EJT.Util.teclasPermitidas;

public class TelaBuscarMestreDeObras {

	Fachada fachada;
	MestreDeObras mestre;
	Contato contato;
	Endereco endereco;
	
	public JFrame frmBuscarMestreDeObras;
	private JTextField textFieldCpf;
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
					TelaBuscarMestreDeObras window = new TelaBuscarMestreDeObras();
					window.frmBuscarMestreDeObras.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarMestreDeObras() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarMestreDeObras = new JFrame();
		frmBuscarMestreDeObras.getContentPane().setBackground(Color.WHITE);
		frmBuscarMestreDeObras.setTitle("BUSCAR MESTRE DE OBRAS");
		frmBuscarMestreDeObras.setBounds(100, 100, 556, 431);
		frmBuscarMestreDeObras.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarMestreDeObras.getContentPane().setLayout(null);
		
		
		frmBuscarMestreDeObras.setUndecorated(true);
	    frmBuscarMestreDeObras.setLocationRelativeTo(null); 
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(114, 30, 38, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(162, 27, 138, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldCpf.getText();
			try {
				
				Fachada.getInstance().mestreProcurar(cpf);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldNome.setText(fachada.mestreProcurar(cpf).getNome().toUpperCase());
				textFieldCpf.setText(fachada.mestreProcurar(cpf).getCpf());
				textFieldRG.setText(fachada.mestreProcurar(cpf).getRg());
				
				if(fachada.mestreProcurar(cpf).getDisponibilidade().equalsIgnoreCase("OCUPADO")){
					textFieldDisponibilidade.setForeground(Color.RED);
				}else{
					textFieldDisponibilidade.setForeground(Color.GREEN);
				}
				textFieldDisponibilidade.setText(fachada.mestreProcurar(cpf).getDisponibilidade().toUpperCase());
				
			
				
				
				textFieldEmail.setText(fachada.mestreProcurar(cpf).getContato().getEmail());
				textFieldCel.setText(fachada.mestreProcurar(cpf).getContato().getCelular());
				textFieldTel.setText(fachada.mestreProcurar(cpf).getContato().getTelefone());
				
				
				textFieldRua.setText(fachada.mestreProcurar(cpf).getEndereco().getLogradouro().toUpperCase());
				textFieldBairro.setText(fachada.mestreProcurar(cpf).getEndereco().getBairro().toUpperCase());
				textFieldNumero.setText(fachada.mestreProcurar(cpf).getEndereco().getNumero());
				textFieldCEP.setText(fachada.mestreProcurar(cpf).getEndereco().getCep().toUpperCase());
				textFieldCidade.setText(fachada.mestreProcurar(cpf).getEndereco().getCidade().toUpperCase());
				textFieldEstado.setText(fachada.mestreProcurar(cpf).getEndereco().getEstado().toUpperCase());
				
				
				
				

			} catch (EJT.MestredeObras.CPFInvalidoException e) {
				JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (MestreDeObrasNaoEncontradoException e){
				JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (EJT.MestredeObras.CampoObrigatorioException e) {
				JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e){
				JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} 

		
				
			}
		});
		btnBuscar.setBounds(310, 26, 89, 23);
		frmBuscarMestreDeObras.getContentPane().add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(54, 142, 46, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 139, 175, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(56, 117, 46, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblRg);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(110, 114, 86, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldRG);
		textFieldRG.setColumns(10);
		textFieldRG.setDocument(new teclasPermitidas());

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(54, 173, 46, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(110, 170, 384, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(54, 239, 46, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(54, 274, 46, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(54, 308, 46, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(338, 239, 146, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(358, 236, 136, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 567, 56);
		frmBuscarMestreDeObras.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBuscarMestreDeObras.dispose();
			}
		});
		btnSair.setBounds(456, 17, 74, 23);
		panel.add(btnSair);
		
		JButton btnNewButton = new JButton("REMOVER MESTRE DE OBRAS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frmBuscarMestreDeObras, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().mestreRemover(cpf);
						Fachada fachada = Fachada.getInstance();
						JOptionPane.showMessageDialog(frmBuscarMestreDeObras, "Removido com Sucesso!");
			
						
					} catch (EJT.MestredeObras.CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (MestreDeObrasNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (EJT.MestredeObras.CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					} 
				
				}

				
			
			}
		});
		btnNewButton.setBounds(106, 17, 222, 23);
		panel.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(
						frmBuscarMestreDeObras,
						"ATENÇÃO!!!"
						+ "\nConfirme antes a disponibilidade: " + comboBoxdDisponibilidade.getSelectedItem() +"\n"
								+ "\n"
								+ "Deseja Alterar os dados modificados?\n" ,
						"Alterar Dados", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(resultado == JOptionPane.YES_OPTION){
			try{
				String cpf = textFieldCpf.getText();
				Fachada fachada = Fachada.getInstance();
				MestreDeObras mestreDeObras = fachada.mestreProcurar(cpf);
				Endereco endereco = mestreDeObras.getEndereco();
				Contato contato = mestreDeObras.getContato();
				
				mestreDeObras.setNome(textFieldNome.getText());
				mestreDeObras.setRg(textFieldRG.getText());
				mestreDeObras.setDisponibilidade((String) comboBoxdDisponibilidade.getSelectedItem());


				
				endereco.setLogradouro(textFieldRua.getText());
				endereco.setNumero(textFieldNumero.getText());
				endereco.setBairro(textFieldBairro.getText());
				endereco.setCidade(textFieldCidade.getText());
				endereco.setEstado(textFieldEstado.getText());
				endereco.setCep(textFieldCEP.getText());
				mestreDeObras.setEndereco(endereco);
				
				contato.setEmail(textFieldEmail.getText());
				contato.setTelefone(textFieldTel.getText());
				contato.setCelular(textFieldCel.getText());
				mestreDeObras.setContato(contato);
				
				fachada.mestreAtualizar(mestreDeObras);
				
			} catch (EJT.MestredeObras.CPFInvalidoException e1) {
				JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (MestreDeObrasNaoEncontradoException e1){
				JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (EJT.MestredeObras.CampoObrigatorioException e1) {
				JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e1){
				JOptionPane.showMessageDialog(frmBuscarMestreDeObras, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} 
			}
			}
		});
		btnAtualizar.setBounds(338, 17, 108, 23);
		panel.add(btnAtualizar);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastroMestredeObras window = new TelaCadastroMestredeObras();
				window.frmCadastroMestredeObras.setVisible(true);
				
				
			}
		});
		btnNovo.setBounds(10, 17, 89, 23);
		panel.add(btnNovo);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 236, 222, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(110, 271, 175, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(292, 274, 46, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(348, 271, 146, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(110, 305, 289, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(422, 308, 31, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(463, 305, 31, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(64, 198, 46, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(110, 195, 103, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 198, 46, 14);
		frmBuscarMestreDeObras.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(251, 195, 115, 20);
		frmBuscarMestreDeObras.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		
		JLabel lblDisponibilidade = new JLabel("Disponibilidade: ");
		lblDisponibilidade.setBounds(93, 81, 106, 27);
		frmBuscarMestreDeObras.getContentPane().add(lblDisponibilidade);
		
		
		JPanel panelBuscarCpf = new JPanel();
		panelBuscarCpf.setBounds(93, 11, 324, 56);
		frmBuscarMestreDeObras.getContentPane().add(panelBuscarCpf);
		
	
		textFieldDisponibilidade.setBounds(197, 84, 103, 14);
		frmBuscarMestreDeObras.getContentPane().add

(textFieldDisponibilidade);

comboBoxdDisponibilidade = new JComboBox(disponibilidade);
		comboBoxdDisponibilidade.setBounds(323, 81, 95, 20);
		frmBuscarMestreDeObras.getContentPane().add(comboBoxdDisponibilidade);
	}
		
}
