package EJT.Contrato;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import EJT.Arquiteto.Arquiteto;
import EJT.Atendente.Atendente;
import EJT.ClienteFisico.ClienteFisico;

import EJT.Contrato.*;

import EJT.Contrato.ContratoNaoEncontradoException;

import EJT.Eletricista.Eletricista;
import EJT.Empresa.Empresa;
import EJT.Encanador.Encanador;
import EJT.Engenheiro.Engenheiro;
import EJT.Fachada.Fachada;
import EJT.Gerente.Gerente;
import EJT.Jardineiro.Jardineiro;
import EJT.MestredeObras.MestreDeObras;
import EJT.Util.teclasPermitidas;
import javax.swing.JTextPane;

public class TelaBuscarContratoFisico extends JFrame {

	private JFrame frame;
	public JFrame frmBuscarContratoFisico;
	private JTextField textFieldId;
	Fachada fachada;
	Atendente atendente;
	Arquiteto arquiteto;
	ClienteFisico cliente;

	Eletricista eletricista;
	Empresa empresa;
	Encanador encanador;
	Engenheiro engenheiro;
	Gerente gerente;
	Jardineiro jardineiro;
	MestreDeObras mestre;
	
	
	
	
	private JTextField textFieldArquiteto;
	private JTextField textFieldCliente;
	private JTextField textFieldEletricista;
	private JTextField textFieldEmpresa;
	private JTextField textFieldEngenheiro;
	private JTextField textFieldJardineiro;
	private JTextField textFieldGerente;
	private JTextField textFieldMestre;
	private JTextField textFieldEncandador;
	private JLabel lblDescricao;
	private JTextField textFieldDescricao;
	private JTextField textFieldEngenheiro1;
	private JTextField textFieldJardineiro1;
	private JTextField textFieldMestre1;
	private JTextField textFieldEncanador1;
	private JTextField textFieldGerente1;
	private JTextField textFieldDescricao21;
	private JTextField textFieldAtendente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarContratoFisico window = new TelaBuscarContratoFisico();
					window.frmBuscarContratoFisico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarContratoFisico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarContratoFisico = new JFrame();
		frmBuscarContratoFisico.setType(Type.UTILITY);
		frmBuscarContratoFisico.getContentPane().setBackground(Color.WHITE);
		frmBuscarContratoFisico.setTitle("BUSCAR ARQUITETO");
		frmBuscarContratoFisico.setBounds(100, 100, 829, 350);
		frmBuscarContratoFisico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		frmBuscarContratoFisico.setUndecorated(true);
	    frmBuscarContratoFisico.setLocationRelativeTo(null); 
		frmBuscarContratoFisico.getContentPane().setLayout(null);
		
		frmBuscarContratoFisico.setUndecorated(true);
		frmBuscarContratoFisico.setLocationRelativeTo(null); 
		
		
		JLabel lblId = new JLabel("ID : ");
		lblId.setBounds(47, 15, 38, 14);
		frmBuscarContratoFisico.getContentPane().add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(86, 12, 138, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(234, 11, 89, 23);
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
				int idContrato = Integer.parseInt(textFieldId.getText());
				Fachada.getInstance().contratoFisicoProcurar(idContrato);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldArquiteto.setText(fachada.contratoFisicoProcurar(idContrato).getArquiteto().getNome());
				textFieldCliente.setText(fachada.contratoFisicoProcurar(idContrato).getClienteFisico().getNome());
				textFieldAtendente.setText(fachada.contratoFisicoProcurar(idContrato).getAtendente().getNome());
				textFieldEletricista.setText(fachada.contratoFisicoProcurar(idContrato).getEletricista().getNome());
				textFieldEncanador1.setText(fachada.contratoFisicoProcurar(idContrato).getEncanador().getNome());
				textFieldEngenheiro1.setText(fachada.contratoFisicoProcurar(idContrato).getEngenheiro().getNome());
				textFieldJardineiro1.setText(fachada.contratoFisicoProcurar(idContrato).getJardineiro().getNome());
				textFieldEmpresa.setText(fachada.contratoFisicoProcurar(idContrato).getEmpresa().getNome_fantasia());
				textFieldGerente1.setText(fachada.contratoFisicoProcurar(idContrato).getGerente().getNome());
				textFieldMestre1.setText(fachada.contratoFisicoProcurar(idContrato).getMestreDeObras().getNome());
				textFieldDescricao21.setText(fachada.contratoFisicoProcurar(idContrato).getDescricao());
				
				
			
				
			} catch (ContratoNaoEncontradoException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}catch (Exception e){
				JOptionPane.showMessageDialog(frame, "Erro em buscar o contrato");
			}
			
			
			
			
			}
		});
		frmBuscarContratoFisico.getContentPane().add(btnBuscar);
		
		JLabel lblArquiteto = new JLabel("ARQUITETO : ");
		lblArquiteto.setBounds(47, 102, 90, 14);
		frmBuscarContratoFisico.getContentPane().add(lblArquiteto);
		
		textFieldArquiteto = new JTextField();
		textFieldArquiteto.setBounds(147, 99, 244, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldArquiteto);
		textFieldArquiteto.setColumns(10);
		
		JLabel lblCliente = new JLabel("CLIENTE : ");
		lblCliente.setBounds(47, 71, 90, 14);
		frmBuscarContratoFisico.getContentPane().add(lblCliente);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setBounds(147, 71, 243, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldCliente);
		textFieldCliente.setColumns(10);
		
		JLabel lblAtendente = new JLabel("ATENDENTE :");
		lblAtendente.setBounds(450, 18, 90, 14);
		frmBuscarContratoFisico.getContentPane().add(lblAtendente);

		
		JLabel lblEletricista = new JLabel("ELETRICISTA :");
		lblEletricista.setBounds(450, 105, 90, 14);
		frmBuscarContratoFisico.getContentPane().add(lblEletricista);
		
		textFieldEletricista = new JTextField();
		textFieldEletricista.setBounds(550, 102, 244, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldEletricista);
		textFieldEletricista.setColumns(10);
		
		JLabel lblEngenheiro = new JLabel("ENGENHEIRO :");
		lblEngenheiro.setBounds(47, 133, 90, 14);
		frmBuscarContratoFisico.getContentPane().add(lblEngenheiro);
		
		JLabel lblJardineiro = new JLabel("JARDINEIRO : ");
		lblJardineiro.setBounds(450, 130, 90, 14);
		frmBuscarContratoFisico.getContentPane().add(lblJardineiro);
		
		JLabel lblMestre = new JLabel("MESTRE DE OBRAS :");
		lblMestre.setBounds(47, 161, 100, 14);
		frmBuscarContratoFisico.getContentPane().add(lblMestre);
		
		JLabel lblEmpresa = new JLabel("EMPRESA :");
		lblEmpresa.setBounds(47, 40, 146, 14);
		frmBuscarContratoFisico.getContentPane().add(lblEmpresa);
		
		textFieldEmpresa = new JTextField();
		textFieldEmpresa.setBounds(147, 40, 146, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldEmpresa);
		textFieldEmpresa.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(-14, 244, 841, 56);
		frmBuscarContratoFisico.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBuscarContratoFisico.dispose();
			}
		});
		btnSair.setBounds(556, 11, 74, 34);
		panel.add(btnSair);
		
		JButton btnRemoverArquiteto = new JButton("REMOVER ");
		btnRemoverArquiteto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = JOptionPane.showConfirmDialog(
						frmBuscarContratoFisico,
						"Deseja Excluir?\n O Contrato " + textFieldId.getText(),
						"Excluir", JOptionPane.YES_NO_CANCEL_OPTION);
				if (resultado == JOptionPane.YES_OPTION) {
					try {
						int idContrato = Integer.parseInt(textFieldId.getText());
//						Fachada fachada = Fachada.getInstance();
//						
//						String cpfArquiteto = fachada.contratoJuridicoProcurar(idContrato).getArquiteto().getCpf(); 
//						
////						fachada.contratoJuridicoProcurar(idContrato).getArquiteto().setDisponibilidade("DISPONIVEL");
////						fachada.contratoJuridicoProcurar(idContrato).getEletricista().setDisponibilidade("DISPONIVEL");
////						fachada.contratoJuridicoProcurar(idContrato).getEncanador().setDisponibilidade("DISPONIVEL");
////						fachada.contratoJuridicoProcurar(idContrato).getEngenheiro().setDisponibilidade("DISPONIVEL");
////						fachada.contratoJuridicoProcurar(idContrato).getJardineiro().setDisponibilidade("DISPONIVEL");
////						fachada.contratoJuridicoProcurar(idContrato).getMestreDeObras().setDisponibilidade("DISPONIVEL");
////						
//						Arquiteto arquiteto = fachada.arquitetoProcurar(cpfArquiteto);
//						arquiteto.setDisponibilidade("DISPONIVEL");
//						fachada.arquitetoAtualizar(arquiteto);
//						
						Fachada.getInstance().contratoFisicoRemover(idContrato);
						Fachada fachada = Fachada.getInstance();
						
						limparCampos();
						
					} catch (CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (ContratoNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					}catch (SQLException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}

				}

			}

			private void limparCampos() {

				
				textFieldArquiteto.setText("");
				textFieldAtendente.setText("");
				textFieldCliente.setText("");
				textFieldDescricao.setText("");
				textFieldDescricao21.setText("");
				textFieldEletricista.setText("");
				textFieldEmpresa.setText("");
				textFieldEncanador1.setText("");
				textFieldEncandador.setText("");
				textFieldEngenheiro.setText("");
				textFieldEngenheiro1.setText("");
				textFieldGerente.setText("");
				textFieldGerente1.setText("");
				textFieldJardineiro.setText("");
				textFieldJardineiro1.setText("");
				textFieldMestre1.setText("");
				textFieldMestre.setText("");
				
			
			}
		});

	
		btnRemoverArquiteto.setBounds(113, 17, 137, 23);
		panel.add(btnRemoverArquiteto);
		
		JButton btnApagar = new JButton("ATUALIZAR");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				try {
					int idContrato = Integer.parseInt(textFieldId.getText());
					
					
					Fachada fachada = Fachada.getInstance();
					Contrato contrato = fachada.contratoFisicoProcurar(idContrato);
					
					contrato.setDescricao(textFieldDescricao21.getText());
						
					fachada.contratoFisicoAtualizar(contrato);

				} catch (ContratoNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				}catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}


			}
			}
		);
		btnApagar.setBounds(367, 17, 100, 23);
		panel.add(btnApagar);
		
		textFieldEngenheiro1 = new JTextField();
		textFieldEngenheiro1.setBounds(147, 130, 243, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldEngenheiro1);
		textFieldEngenheiro1.setColumns(10);
		
		textFieldJardineiro1 = new JTextField();
		textFieldJardineiro1.setText("");
		textFieldJardineiro1.setBounds(550, 127, 244, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldJardineiro1);
		textFieldJardineiro1.setColumns(10);
		
		textFieldMestre1 = new JTextField();
		textFieldMestre1.setBounds(157, 158, 234, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldMestre1);
		textFieldMestre1.setColumns(10);
		
		JLabel lblEncanador = new JLabel("ENCANADOR:");
		lblEncanador.setBounds(450, 158, 75, 14);
		frmBuscarContratoFisico.getContentPane().add(lblEncanador);
		
		textFieldEncanador1 = new JTextField();
		textFieldEncanador1.setBounds(550, 155, 244, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldEncanador1);
		textFieldEncanador1.setColumns(10);
		
		JLabel lblGerente = new JLabel("GERENTE:");
		lblGerente.setBounds(450, 49, 75, 14);
		frmBuscarContratoFisico.getContentPane().add(lblGerente);
		
		textFieldGerente1 = new JTextField();
		textFieldGerente1.setBounds(550, 43, 244, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldGerente1);
		textFieldGerente1.setColumns(10);
		
		textFieldDescricao21 = new JTextField();
		textFieldDescricao21.setColumns(10);
		textFieldDescricao21.setBounds(158, 189, 587, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldDescricao21);
		
		JLabel lblDescricao_1 = new JLabel("Descricao");
		lblDescricao_1.setBounds(47, 197, 46, 14);
		frmBuscarContratoFisico.getContentPane().add(lblDescricao_1);
		
		textFieldAtendente = new JTextField();
		textFieldAtendente.setBounds(550, 15, 244, 20);
		frmBuscarContratoFisico.getContentPane().add(textFieldAtendente);
		textFieldAtendente.setColumns(10);
		
		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarContratos window = new TelaListarContratos();
				window.frmContratosFisicos.setVisible(true);
			}
		});
		btnListarTodos.setBounds(325, 11, 115, 23);
		frmBuscarContratoFisico.getContentPane().add(btnListarTodos);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				TelaContrato window = null;
				try {
					window = new TelaContrato();
				} catch (Exception e) {

					JOptionPane.showMessageDialog(frmBuscarContratoFisico, e);
					
				}
				window.frmContrato.setVisible(true);
				
			}
		});

	

	}
}
