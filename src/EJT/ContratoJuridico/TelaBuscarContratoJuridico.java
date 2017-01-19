package EJT.ContratoJuridico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window.Type;
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

import EJT.Arquiteto.Arquiteto;
import EJT.Atendente.Atendente;
import EJT.ClienteJuridico.ClienteJuridico;
import EJT.Eletricista.Eletricista;
import EJT.Empresa.Empresa;
import EJT.Encanador.Encanador;
import EJT.Engenheiro.Engenheiro;
import EJT.Fachada.Fachada;
import EJT.Gerente.Gerente;
import EJT.Jardineiro.Jardineiro;
import EJT.MestredeObras.MestreDeObras;
import EJT.Util.teclasPermitidas;

public class TelaBuscarContratoJuridico {

	private JFrame frame;
	public JFrame frmBuscarContratoJuridico;
	private JTextField textFieldId;
	Fachada fachada;
	Atendente atendente;
	Arquiteto arquiteto;
	ClienteJuridico cliente;
	ContratoJuridico contrato;
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
	private JTextField textFieldDescricao2;
	private JTextField textFieldAtendente;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarContratoJuridico window = new TelaBuscarContratoJuridico();
					window.frmBuscarContratoJuridico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscarContratoJuridico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarContratoJuridico = new JFrame();
		frmBuscarContratoJuridico.setType(Type.UTILITY);
		frmBuscarContratoJuridico.getContentPane().setBackground(Color.WHITE);
		frmBuscarContratoJuridico.setTitle("BUSCAR CONTRATOS JURIDICOS");
		frmBuscarContratoJuridico.setBounds(100, 100, 831, 388);
		frmBuscarContratoJuridico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		frmBuscarContratoJuridico.setUndecorated(true);
	    frmBuscarContratoJuridico.setLocationRelativeTo(null); 
		frmBuscarContratoJuridico.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID : ");
		lblId.setBounds(40, 10, 38, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(92, 7, 138, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(240, 6, 89, 23);
		btnBuscar.setToolTipText("Procurar, VAIII!!!!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
				int idContrato = Integer.parseInt(textFieldId.getText());
				Fachada.getInstance().contratoJuridicoProcurar(idContrato);
				Fachada fachada = Fachada.getInstance();
				
				
				textFieldArquiteto.setText(fachada.contratoJuridicoProcurar(idContrato).getArquiteto().getNome());
				textFieldCliente.setText(fachada.contratoJuridicoProcurar(idContrato).getClienteJuridico().getNome());
				textFieldAtendente.setText(fachada.contratoJuridicoProcurar(idContrato).getAtendente().getNome());
				textFieldEletricista.setText(fachada.contratoJuridicoProcurar(idContrato).getEletricista().getNome());
				textFieldEncanador1.setText(fachada.contratoJuridicoProcurar(idContrato).getEncanador().getNome());
				textFieldEngenheiro1.setText(fachada.contratoJuridicoProcurar(idContrato).getEngenheiro().getNome());
				textFieldJardineiro1.setText(fachada.contratoJuridicoProcurar(idContrato).getJardineiro().getNome());
				textFieldEmpresa.setText(fachada.contratoJuridicoProcurar(idContrato).getEmpresa().getNome_fantasia());
				textFieldGerente1.setText(fachada.contratoJuridicoProcurar(idContrato).getGerente().getNome());
				textFieldMestre1.setText(fachada.contratoJuridicoProcurar(idContrato).getMestreDeObras().getNome());
				textFieldDescricao2.setText(fachada.contratoJuridicoProcurar(idContrato).getDescricao());
				
				
				
			} catch (ContratoNaoEncontradoException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
				JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			
			}
		});
		frmBuscarContratoJuridico.getContentPane().add(btnBuscar);
		
		JLabel lblArquiteto = new JLabel("ARQUITETO : ");
		lblArquiteto.setBounds(40, 102, 90, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblArquiteto);
		
		textFieldArquiteto = new JTextField();
		textFieldArquiteto.setBounds(140, 99, 244, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldArquiteto);
		textFieldArquiteto.setColumns(10);
		
		JLabel lblCliente = new JLabel("CLIENTE : ");
		lblCliente.setBounds(40, 71, 90, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblCliente);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setBounds(140, 71, 243, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldCliente);
		textFieldCliente.setColumns(10);
		
		JLabel lblAtendente = new JLabel("ATENDENTE :");
		lblAtendente.setBounds(393, 43, 90, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblAtendente);

		
		JLabel lblEletricista = new JLabel("ELETRICISTA :");
		lblEletricista.setBounds(390, 102, 90, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblEletricista);
		
		textFieldEletricista = new JTextField();
		textFieldEletricista.setBounds(490, 99, 244, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldEletricista);
		textFieldEletricista.setColumns(10);
		
		JLabel lblEngenheiro = new JLabel("ENGENHEIRO :");
		lblEngenheiro.setBounds(40, 139, 90, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblEngenheiro);
		
		JLabel lblJardineiro = new JLabel("JARDINEIRO : ");
		lblJardineiro.setBounds(390, 136, 90, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblJardineiro);
		
		JLabel lblMestre = new JLabel("MESTRE DE OBRAS :");
		lblMestre.setBounds(40, 180, 100, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblMestre);
		
		JLabel lblEmpresa = new JLabel("EMPRESA :");
		lblEmpresa.setBounds(40, 40, 146, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblEmpresa);
		
		textFieldEmpresa = new JTextField();
		textFieldEmpresa.setBounds(140, 40, 240, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldEmpresa);
		textFieldEmpresa.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(-14, 255, 854, 56);
		frmBuscarContratoJuridico.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBuscarContratoJuridico.dispose();
			}
		});
		btnSair.setBounds(641, 11, 74, 34);
		panel.add(btnSair);
		
		JButton btnRemoverArquiteto = new JButton("REMOVER ");
		btnRemoverArquiteto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = JOptionPane.showConfirmDialog(
						frmBuscarContratoJuridico,
						"Deseja Excluir?\n O Contrato " + textFieldId.getText(),
						"Excluir", JOptionPane.YES_NO_CANCEL_OPTION);
				if (resultado == JOptionPane.YES_OPTION) {
					try {
						int idContrato = Integer.parseInt(textFieldId.getText());
						Fachada fachada = Fachada.getInstance();
						fachada.contratoJuridicoRemover(idContrato);
//						String nome = fachada.contratoJuridicoProcurar(idContrato).getArquiteto().getNome();
//						Arquiteto arquiteto = fachada.arquitetoProcurarNome(nome);
//						String disponibilidade = "DISPONIVEL";
//						arquiteto.setDisponibilidade(disponibilidade);
//						fachada.arquitetoAtualizar(arquiteto);
					//	
					//	System.out.println(fachada.contratoJuridicoProcurar(idContrato).getArquiteto().getCpf());
					//	System.out.println(fachada.contratoJuridicoProcurar(idContrato).getArquiteto().getNome());
						
						
				//		System.out.println(fachada.contratoJuridicoProcurar(idContrato).getArquiteto().getNome());
				//		System.out.println(fachada.contratoJuridicoProcurar(idContrato).getArquiteto().getDisponibilidade());
						
			//			fachada.arquitetoAtualizar(arquiteto);
					//	System.out.println(fachada.arquitetoProcurar(cpf).getDisponibilidade());
						
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

	
		btnRemoverArquiteto.setBounds(36, 17, 181, 23);
		panel.add(btnRemoverArquiteto);
		
		JButton btnApagar = new JButton("ATUALIZAR");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				try {
					int idContrato = Integer.parseInt(textFieldId.getText());
					
					
					Fachada fachada = Fachada.getInstance();
					ContratoJuridico contrato = fachada.contratoJuridicoProcurar(idContrato);
					Atendente atendente = contrato.getAtendente();
					Arquiteto arquiteto = contrato.getArquiteto();
					ClienteJuridico cliente = contrato.getClienteJuridico() ;
					Eletricista eletricista = contrato.getEletricista();
					Empresa empresa = contrato.getEmpresa();
					Encanador encanador = contrato.getEncanador();
					Engenheiro engenheiro = contrato.getEngenheiro();
					Gerente gerente = contrato.getGerente();
					Jardineiro jardineiro = contrato.getJardineiro();
					MestreDeObras mestre = contrato.getMestreDeObras();
					
					contrato.setDescricao(textFieldDescricao2.getText());
						
					fachada.contratoJuridicoAtualizar(contrato);

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
		btnApagar.setBounds(501, 17, 100, 23);
		panel.add(btnApagar);
		
		textFieldEngenheiro1 = new JTextField();
		textFieldEngenheiro1.setBounds(140, 136, 243, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldEngenheiro1);
		textFieldEngenheiro1.setColumns(10);
		
		textFieldJardineiro1 = new JTextField();
		textFieldJardineiro1.setText("");
		textFieldJardineiro1.setBounds(490, 133, 244, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldJardineiro1);
		textFieldJardineiro1.setColumns(10);
		
		textFieldMestre1 = new JTextField();
		textFieldMestre1.setBounds(150, 177, 234, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldMestre1);
		textFieldMestre1.setColumns(10);
		
		JLabel lblEncanador = new JLabel("ENCANADOR");
		lblEncanador.setBounds(390, 177, 75, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblEncanador);
		
		textFieldEncanador1 = new JTextField();
		textFieldEncanador1.setBounds(490, 174, 244, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldEncanador1);
		textFieldEncanador1.setColumns(10);
		
		JLabel lblGerente = new JLabel("GERENTE:");
		lblGerente.setBounds(393, 68, 75, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblGerente);
		
		textFieldGerente1 = new JTextField();
		textFieldGerente1.setBounds(493, 62, 244, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldGerente1);
		textFieldGerente1.setColumns(10);
		
		textFieldDescricao2 = new JTextField();
		textFieldDescricao2.setColumns(10);
		textFieldDescricao2.setBounds(91, 207, 643, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldDescricao2);
		
		JLabel lblDescricao_1 = new JLabel("Descricao");
		lblDescricao_1.setBounds(40, 210, 46, 14);
		frmBuscarContratoJuridico.getContentPane().add(lblDescricao_1);
		
		textFieldAtendente = new JTextField();
		textFieldAtendente.setBounds(493, 40, 244, 20);
		frmBuscarContratoJuridico.getContentPane().add(textFieldAtendente);
		textFieldAtendente.setColumns(10);
		
		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarContratos window;
				try {
					window = new TelaListarContratos();
					window.frmContratosJuridicos.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListarTodos.setBounds(337, 6, 128, 23);
		frmBuscarContratoJuridico.getContentPane().add(btnListarTodos);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				TelaContratoPJ window = null;
				try {
					window = new TelaContratoPJ();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				window.frmContrato.setVisible(true);
				
			}
		});
//		btnNovo.setBounds(22, 17, 89, 23);
//		panel.add(btnNovo);
//		
//		textFieldEngenheiro = new JTextField();
//		textFieldEngenheiro.setBounds(111, 236, 243, 20);
//		frmBuscarContratoJuridico.getContentPane().add(textFieldEngenheiro);
//		textFieldEngenheiro.setColumns(10);
//		
//		textFieldJardineiro = new JTextField();
//		textFieldJardineiro.setBounds(110, 271, 244, 20);
//		textFieldJardineiro.setText("");
//		frmBuscarContratoJuridico.getContentPane().add(textFieldJardineiro);
//		textFieldJardineiro.setColumns(10);
//		
//		JLabel lblGerente = new JLabel("GERENTE : ");
//		lblGerente.setBounds(10, 406, 90, 14);
//		frmBuscarContratoJuridico.getContentPane().add(lblGerente);
//		
//		textFieldGerente = new JTextField();
//		textFieldGerente.setBounds(114, 406, 240, 20);
//		frmBuscarContratoJuridico.getContentPane().add(textFieldGerente);
//		textFieldGerente.setColumns(10);
//		
//		textFieldMestre = new JTextField();
//		textFieldMestre.setBounds(110, 305, 244, 20);
//		frmBuscarContratoJuridico.getContentPane().add(textFieldMestre);
//		textFieldMestre.setColumns(10);
//		
//		JLabel lblEncanador = new JLabel("ENCANADOR :");
//		lblEncanador.setBounds(10, 201, 100, 14);
//		frmBuscarContratoJuridico.getContentPane().add(lblEncanador);
//		
//		textFieldEncandador = new JTextField();
//		textFieldEncandador.setBounds(110, 195, 244, 20);
//		frmBuscarContratoJuridico.getContentPane().add(textFieldEncandador);
//		textFieldEncandador.setColumns(10);
//		
//		
//		JPanel panelBuscarCpf = new JPanel();
//		panelBuscarCpf.setBounds(93, 11, 324, 56);
//		frmBuscarContratoJuridico.getContentPane().add(panelBuscarCpf);
//		
//		lblDescricao = new JLabel("DESCRI\u00C7\u00C3O :");
//		lblDescricao.setBounds(364, 89, 90, 14);
//		frmBuscarContratoJuridico.getContentPane().add(lblDescricao);
//		
//		textFieldDescricao = new JTextField();
//		textFieldDescricao.setColumns(10);
//		textFieldDescricao.setBounds(364, 114, 182, 174);
//		frmBuscarContratoJuridico.getContentPane().add(textFieldDescricao);
//		
//
//
//
//		
//	
//		
//		
//		

	}
}