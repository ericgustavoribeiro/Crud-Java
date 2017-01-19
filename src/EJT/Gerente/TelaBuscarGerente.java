package EJT.Gerente;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import EJT.Atendente.Atendente;
import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;
import EJT.Util.teclasPermitidas;

import javax.swing.JFrame;

public class TelaBuscarGerente {

	
	public JFrame frmBuscarGerente;
	private JTextField textFieldCpf;
	Fachada fachada;
	Gerente gerente;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarGerente window = new TelaBuscarGerente();
					window.frmBuscarGerente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarGerente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarGerente= new JFrame();
		frmBuscarGerente.getContentPane().setBackground(Color.WHITE);
		frmBuscarGerente.setTitle("BUSCAR GERENTE");
		frmBuscarGerente.setBounds(100, 100, 556, 431);
		frmBuscarGerente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarGerente.getContentPane().setLayout(null);
		
		frmBuscarGerente.setUndecorated(true);
	    frmBuscarGerente.setLocationRelativeTo(null); 
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(54, 115, 46, 14);
		frmBuscarGerente.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(110, 112, 175, 20);
		frmBuscarGerente.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(394, 115, 46, 14);
		frmBuscarGerente.getContentPane().add(lblRg);
		
		textFieldRG = new JTextField();
		textFieldRG.setBounds(426, 109, 86, 20);
		frmBuscarGerente.getContentPane().add(textFieldRG);
		textFieldRG.setColumns(10);
		textFieldRG.setDocument(new teclasPermitidas());

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(54, 146, 46, 14);
		frmBuscarGerente.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(110, 143, 402, 20);
		frmBuscarGerente.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(54, 212, 46, 14);
		frmBuscarGerente.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(54, 252, 46, 14);
		frmBuscarGerente.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(54, 292, 46, 14);
		frmBuscarGerente.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(431, 209, 24, 14);
		frmBuscarGerente.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(447, 206, 65, 20);
		frmBuscarGerente.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 540, 56);
		frmBuscarGerente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBuscarGerente.dispose();
			}
		});
		btnSair.setBounds(456, 17, 74, 23);
		panel.add(btnSair);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frmBuscarGerente, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().gerenteRemover(cpf);
						
						Fachada fachada = Fachada.getInstance();
						JOptionPane.showMessageDialog(frmBuscarGerente, "Removido com Sucesso!");
					} catch (CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frmBuscarGerente, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (GerenteNaoEncontradoExceptio e1){
						JOptionPane.showMessageDialog(frmBuscarGerente, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarGerente, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarGerente, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarGerente, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					} 

				
				}

				
			
			}
		});
		btnNewButton.setBounds(225, 17, 92, 23);
		panel.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				String cpf = textFieldCpf.getText();
				Fachada fachada = Fachada.getInstance();
				Gerente gerente = fachada.gerenteProcurar(cpf);
				Endereco endereco = gerente.getEndereco();
				Contato contato = gerente.getContato();
				
				gerente.setNome(textFieldNome.getText());
				gerente.setRg(textFieldRG.getText());
				
				endereco.setLogradouro(textFieldRua.getText());
				endereco.setNumero(textFieldNumero.getText());
				endereco.setBairro(textFieldBairro.getText());
				endereco.setCidade(textFieldCidade.getText());
				endereco.setEstado(textFieldEstado.getText());
				endereco.setCep(textFieldCEP.getText());
				gerente.setEndereco(endereco);
				
				contato.setEmail(textFieldEmail.getText());
				contato.setTelefone(textFieldTel.getText());
				contato.setCelular(textFieldCel.getText());
				gerente.setContato(contato);
				
				fachada.gerenteAtualizar(gerente);
				
			} catch (CPFInvalidoException e1) {
				JOptionPane.showMessageDialog(frmBuscarGerente, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (GerenteNaoEncontradoExceptio e1){
				JOptionPane.showMessageDialog(frmBuscarGerente, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e1) {
				JOptionPane.showMessageDialog(frmBuscarGerente, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(frmBuscarGerente, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e1){
				JOptionPane.showMessageDialog(frmBuscarGerente, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} 

			
			}
		});
		btnAtualizar.setBounds(327, 17, 99, 23);
		panel.add(btnAtualizar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroGerente window = new TelaCadastroGerente();
				window.frmCadastroGerente.setVisible(true);
			}
		});
		btnNovo.setBounds(45, 17, 89, 23);
		panel.add(btnNovo);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(110, 209, 311, 20);
		frmBuscarGerente.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(110, 252, 175, 20);
		frmBuscarGerente.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(318, 252, 38, 14);
		frmBuscarGerente.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(366, 252, 146, 20);
		frmBuscarGerente.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(110, 289, 222, 20);
		frmBuscarGerente.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(342, 292, 146, 14);
		frmBuscarGerente.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(376, 289, 136, 20);
		frmBuscarGerente.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(64, 174, 46, 14);
		frmBuscarGerente.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(110, 171, 103, 20);
		frmBuscarGerente.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 174, 46, 14);
		frmBuscarGerente.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(251, 171, 115, 20);
		frmBuscarGerente.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		
	
		
		
		JPanel panelBuscarCpf = new JPanel();
		panelBuscarCpf.setBounds(54, 11, 440, 46);
		frmBuscarGerente.getContentPane().add(panelBuscarCpf);
		panelBuscarCpf.setLayout(null);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(58, 12, 138, 20);
		panelBuscarCpf.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(10, 15, 38, 14);
		panelBuscarCpf.add(lblCpf);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(206, 11, 89, 23);
		panelBuscarCpf.add(btnBuscar);
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		
		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarGerente window = new TelaListarGerente();
				window.frmRelatrioGerentes.setVisible(true);
			}
		});
		btnListarTodos.setBounds(305, 11, 112, 23);
		panelBuscarCpf.add(btnListarTodos);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldCpf.getText();
			try {
				
				Fachada.getInstance().gerenteProcurar(cpf);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldNome.setText(fachada.gerenteProcurar(cpf).getNome().toUpperCase());
				textFieldCpf.setText(fachada.gerenteProcurar(cpf).getCpf());
				textFieldRG.setText(fachada.gerenteProcurar(cpf).getRg());
				
			
				
				textFieldEmail.setText(fachada.gerenteProcurar(cpf).getContato().getEmail());
				textFieldCel.setText(fachada.gerenteProcurar(cpf).getContato().getCelular());
				textFieldTel.setText(fachada.gerenteProcurar(cpf).getContato().getTelefone());
				
				
				textFieldRua.setText(fachada.gerenteProcurar(cpf).getEndereco().getLogradouro().toUpperCase());
				textFieldBairro.setText(fachada.gerenteProcurar(cpf).getEndereco().getBairro().toUpperCase());
				textFieldNumero.setText(fachada.gerenteProcurar(cpf).getEndereco().getNumero());
				textFieldCEP.setText(fachada.gerenteProcurar(cpf).getEndereco().getCep().toUpperCase());
				textFieldCidade.setText(fachada.gerenteProcurar(cpf).getEndereco().getCidade().toUpperCase());
				textFieldEstado.setText(fachada.gerenteProcurar(cpf).getEndereco().getEstado().toUpperCase());
				
				
				
				
			} catch (CPFInvalidoException e) {
				JOptionPane.showMessageDialog(frmBuscarGerente, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (GerenteNaoEncontradoExceptio e){
				JOptionPane.showMessageDialog(frmBuscarGerente, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e) {
				JOptionPane.showMessageDialog(frmBuscarGerente, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frmBuscarGerente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e){
				JOptionPane.showMessageDialog(frmBuscarGerente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} 

		
				
			}
		});
		
	
		
		
		

	}
}
