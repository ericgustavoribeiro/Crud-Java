package EJT.Empresa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import EJT.ClienteFisico.CampoObrigatorioException;
import EJT.Contato.Contato;
import EJT.Encanador.Encanador;
import EJT.Encanador.TelaBuscarEncanador;
import EJT.Endereco.Endereco;
import EJT.Fachada.Fachada;

public class TelaBuscarEmpresa {

	public JFrame frmBuscarEmpresa;
	Fachada fachada;
	Empresa empresa;
	Contato contato;
	Endereco endereco;
	
	private JTextField textFieldNomeFantasia;
	private JTextField textFieldEmail;
	private JTextField textFieldNumero;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldCEP;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldTel;
	private JTextField textFieldCel;
	private JTextField textFieldDisponibilidade;
	private JTextField textFieldCnpj;
	private JTextField textFieldInscricao;
	private JTextField textFieldRazao;
	private JTextField textFieldInscricao2;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarEmpresa window = new TelaBuscarEmpresa();
					window.frmBuscarEmpresa.setVisible(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro");
					//e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public TelaBuscarEmpresa() throws Exception {
		initialize();
		
		String cnpj = "";
		ArrayList<Empresa> listar = Fachada.getInstance().empresaListar();
		for(Empresa empresa : listar){
			cnpj += empresa.getCnpj();
		}
		
		Fachada fachada = Fachada.getInstance();
		textFieldNomeFantasia.setText(fachada.empresaProcurar(cnpj).getNome_fantasia().toUpperCase());
		textFieldInscricao.setText(fachada.empresaProcurar(cnpj).getInscricao_estadual().toUpperCase());
		textFieldRazao.setText(fachada.empresaProcurar(cnpj).getRazao_socia());
		textFieldCnpj.setText(fachada.empresaProcurar(cnpj).getCnpj());
		textFieldEmail.setText(fachada.empresaProcurar(cnpj).getContato().getEmail());
		
	textFieldEstado.setText(fachada.empresaProcurar(cnpj).getEndereco().getEstado());
		
	
		textFieldTel.setText(fachada.empresaProcurar(cnpj).getContato().getTelefone());
		textFieldCel.setText(fachada.empresaProcurar(cnpj).getContato().getCelular());
		textFieldRua.setText(fachada.empresaProcurar(cnpj).getEndereco().getLogradouro().toUpperCase());
		textFieldBairro.setText(fachada.empresaProcurar(cnpj).getEndereco().getBairro().toUpperCase());
		textFieldCidade.setText(fachada.empresaProcurar(cnpj).getEndereco().getCidade().toUpperCase());
		textFieldNumero.setText(fachada.empresaProcurar(cnpj).getEndereco().getNumero());

		textFieldCEP.setText(fachada.empresaProcurar(cnpj).getEndereco().getCep());
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frmBuscarEmpresa = new JFrame();
		frmBuscarEmpresa.getContentPane().setBackground(Color.WHITE);
		frmBuscarEmpresa.setTitle("BUSCAR EMPRESA");
		frmBuscarEmpresa.setBounds(100, 100, 556, 431);
		frmBuscarEmpresa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarEmpresa.getContentPane().setLayout(null);
		
		frmBuscarEmpresa.setUndecorated(true);
	    frmBuscarEmpresa.setLocationRelativeTo(null);
		
		JLabel lblNome = new JLabel("Nome Fantasia:");
		lblNome.setBounds(10, 31, 98, 14);
		frmBuscarEmpresa.getContentPane().add(lblNome);
		
		textFieldNomeFantasia = new JTextField();
		textFieldNomeFantasia.setBounds(99, 28, 236, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldNomeFantasia);
		textFieldNomeFantasia.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(43, 84, 46, 14);
		frmBuscarEmpresa.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(99, 81, 384, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(43, 143, 46, 14);
		frmBuscarEmpresa.getContentPane().add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(43, 206, 46, 14);
		frmBuscarEmpresa.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(43, 246, 46, 14);
		frmBuscarEmpresa.getContentPane().add(lblCidade);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(43, 171, 146, 14);
		frmBuscarEmpresa.getContentPane().add(lblN);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(99, 168, 76, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 336, 556, 56);
		frmBuscarEmpresa.getContentPane().add(panel);
		panel.setLayout(null);
	
		textFieldInscricao = new JTextField();
		textFieldInscricao.setBounds(352, 3, 157, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldInscricao);
		textFieldInscricao.setColumns(10);
		
		JLabel lblRazo = new JLabel("Raz\u00E3o:");
		lblRazo.setBounds(43, 56, 46, 14);
		frmBuscarEmpresa.getContentPane().add(lblRazo);
		
		textFieldRazao = new JTextField();
		textFieldRazao.setBounds(99, 53, 112, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldRazao);
		textFieldRazao.setColumns(10);
		
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBuscarEmpresa.dispose();
			}
		});
		btnSair.setBounds(437, 17, 93, 23);
		panel.add(btnSair);

		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
			try{
			
				Fachada fachada = Fachada.getInstance();
				String cnpj = textFieldCnpj.getText();
				Empresa empresa = fachada.empresaProcurar(cnpj);
				
				Endereco endereco = empresa.getEndereco();
				Contato contato = empresa.getContato();
				
				empresa.setNome_fantasia(textFieldNomeFantasia.getText());
				empresa.setInscricao_estadual(textFieldInscricao.getText());
				empresa.setRazao_socia(textFieldRazao.getText());
				
				endereco.setLogradouro(textFieldRua.getText());
				endereco.setNumero(textFieldNumero.getText());
				endereco.setBairro(textFieldBairro.getText());
				endereco.setCidade(textFieldCidade.getText());
				endereco.setEstado(textFieldEstado.getText());
				endereco.setCep(textFieldCEP.getText());
				empresa.setEndereco(endereco);
				
				contato.setEmail(textFieldEmail.getText());
				contato.setTelefone(textFieldTel.getText());
				contato.setCelular(textFieldCel.getText());
				empresa.setContato(contato);
				
				fachada.empresaAtualizar(empresa);
				
			}catch (CampoObricatorioException e1) {
				JOptionPane.showMessageDialog(frmBuscarEmpresa, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			}catch (CNPJInvalidoException e1) {
				JOptionPane.showMessageDialog(frmBuscarEmpresa, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			} catch (EmpresaNaoEncontradaException e1) {
				JOptionPane.showMessageDialog(frmBuscarEmpresa, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(frmBuscarEmpresa, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				}
			
			
			}
		});
		btnAtualizar.setBounds(236, 17, 89, 23);
		panel.add(btnAtualizar);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(99, 140, 222, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JLabel lblInscrioEstadual = new JLabel("Inscri\u00E7\u00E3o Estadual:");
		lblInscrioEstadual.setBounds(221, 6, 136, 14);
		frmBuscarEmpresa.getContentPane().add(lblInscrioEstadual);
		
		
		textFieldBairro = new JTextField();
		textFieldBairro.setText("");
		textFieldBairro.setBounds(99, 203, 222, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(43, 283, 46, 14);
		frmBuscarEmpresa.getContentPane().add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(99, 277, 146, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(99, 243, 222, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(255, 283, 27, 14);
		frmBuscarEmpresa.getContentPane().add(lblUf);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(283, 280, 38, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(43, 115, 46, 14);
		frmBuscarEmpresa.getContentPane().add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(99, 112, 103, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(223, 115, 46, 14);
		frmBuscarEmpresa.getContentPane().add(lblCel);
		
		textFieldCel = new JTextField();
		textFieldCel.setBounds(269, 112, 103, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldCel);
		textFieldCel.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(32, 6, 46, 14);
		frmBuscarEmpresa.getContentPane().add(lblCnpj);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setText("66024482000128");
		textFieldCnpj.setBounds(99, 3, 112, 20);
		frmBuscarEmpresa.getContentPane().add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
	}
}

