package EJT.Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import EJT.Arquiteto.TelaBuscarArquiteto;
import EJT.Arquiteto.TelaCadastroArquiteto;
import EJT.Arquiteto.TelaListarArquiteto;
import EJT.Arquiteto.TelaListarDisponivelArquiteto;
import EJT.Atendente.TelaBuscarAtendente;
import EJT.Atendente.TelaCadastroAtendente;
import EJT.Atendente.TelaListarAtendentes;
import EJT.ClienteFisico.TelaBuscarClienteFisico;
import EJT.ClienteFisico.TelaCadastroClienteFisico;
import EJT.ClienteFisico.TelaListarClienteFisico;
import EJT.ClienteJuridico.TelaBuscarClienteJuridico;
import EJT.ClienteJuridico.TelaCadastroClienteJuridico;
import EJT.ClienteJuridico.TelaListarClienteJuridico;
import EJT.Contrato.TelaBuscarContratoFisico;
import EJT.Contrato.TelaContrato;
import EJT.Contrato.TelaListarContratos;
import EJT.ContratoJuridico.TelaBuscarContratoJuridico;
import EJT.ContratoJuridico.TelaContratoPJ;
import EJT.Eletricista.TelaBuscarEletricista;
import EJT.Eletricista.TelaCadastroEletricista;
import EJT.Eletricista.TelaListarDisponivelEletricista;
import EJT.Eletricista.TelaListarEletricista;
import EJT.Empresa.EmpresaJ·CadastradaException;
import EJT.Empresa.TelaBuscarEmpresa;
import EJT.Empresa.TelaCadastroEmpresa;
import EJT.Empresa.TelaListarEmpresa;
import EJT.Encanador.TelaBuscarEncanador;
import EJT.Encanador.TelaCadastroEncanador;
import EJT.Encanador.TelaListarDisponivelEncanador;
import EJT.Encanador.TelaListarEncanador;
import EJT.Engenheiro.TelaBuscarEngenheiro;
import EJT.Engenheiro.TelaCadastroEngenheiro;
import EJT.Engenheiro.TelaListarDisponivelEngenheiro;
import EJT.Engenheiro.TelaListarEngenheiro;
import EJT.Fachada.Fachada;
import EJT.Gerente.TelaBuscarGerente;
import EJT.Gerente.TelaCadastroGerente;
import EJT.Gerente.TelaListarGerente;
import EJT.Jardineiro.TelaBuscarJardineiro;
import EJT.Jardineiro.TelaCadastroJardineiro;
import EJT.Jardineiro.TelaListarDisponivelJardineiro;
import EJT.Jardineiro.TelaListarJardineiro;
import EJT.MestredeObras.TelaBuscarMestreDeObras;
import EJT.MestredeObras.TelaCadastroMestredeObras;
import EJT.MestredeObras.TelaListarDisponivelMestreDeObras;
import EJT.MestredeObras.TelaListarMestre;
import EJT.Usuario.TelaAlterarUsuario;
import EJT.Usuario.TelaCadastroUsuario;
import EJT.Usuario.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;

import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import javax.swing.JDesktopPane;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;

import java.awt.Toolkit;

public class TelaPrincipal {

	public JFrame framePrincipal;
	private final JLabel lblNewLabel_1 = new JLabel("logomarca");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.framePrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * 
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/EJT/imagens/iconeSistema2.png")));


		framePrincipal.setTitle("EJT - Terceriza\u00E7\u00E3o");
		framePrincipal.setBounds(100, 100, 450, 300);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setExtendedState(framePrincipal.MAXIMIZED_BOTH);
		framePrincipal.getContentPane().setLayout(null);
		
		JMenuBar menuBarPrinciapal = new JMenuBar();
		menuBarPrinciapal.setBackground(SystemColor.activeCaption);
		menuBarPrinciapal.setBounds(0, 0, 1370, 21);
		framePrincipal.getContentPane().add(menuBarPrinciapal);
		
		JMenu mnCadastro = new JMenu("Inicio");
		mnCadastro.setBackground(new Color(255, 255, 255));
		menuBarPrinciapal.add(mnCadastro);
		
		JMenuItem mntmDadosDaEmpresa = new JMenuItem("Dados da Empresa");
		mntmDadosDaEmpresa.setBackground(new Color(255, 255, 255));
		mntmDadosDaEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Fachada fachada = Fachada.getInstance();
				try {
					if(fachada.empresaExiste() == false){
						TelaCadastroEmpresa windows = new TelaCadastroEmpresa();
						windows.frmCadastroEmpresa.setVisible(true);
					}else{
						TelaBuscarEmpresa buscar = new TelaBuscarEmpresa();
						buscar.frmBuscarEmpresa.setVisible(true);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
		JMenu mnAtendente = new JMenu("Atendente");
		mnCadastro.add(mnAtendente);
		
		JMenuItem mntmAtendente = new JMenuItem("Cadastro de Atendente ");
		mnAtendente.add(mntmAtendente);
		mntmAtendente.setBackground(new Color(255, 255, 255));
		
		JMenuItem mntmBuscarAtendente = new JMenuItem("Buscar Atendente");
		mntmBuscarAtendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarAtendente window = new TelaBuscarAtendente();
				window.frmBuscarAtendente.setVisible(true);
			}
		});
		mnAtendente.add(mntmBuscarAtendente);
		mntmAtendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			TelaCadastroAtendente window = new TelaCadastroAtendente();
			window.frmCadastroAtendente.setVisible(true);
			
			}
		});
		
		JMenu mnGerente = new JMenu("Gerente");
		mnCadastro.add(mnGerente);
		
		JMenuItem mntmGerente = new JMenuItem("Cadastro de Gerente");
		mnGerente.add(mntmGerente);
		mntmGerente.setBackground(new Color(255, 255, 255));
		
		JMenuItem mntmBuscarGerente = new JMenuItem("Buscar Gerente");
		mntmBuscarGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBuscarGerente window = new TelaBuscarGerente();
				window.frmBuscarGerente.setVisible(true);
			}
		});
		mnGerente.add(mntmBuscarGerente);
		mntmGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroGerente window = new TelaCadastroGerente();
				window.frmCadastroGerente.setVisible(true);
				
				
			}
		});
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnCadastro.add(mnUsuarios);
		
		JMenuItem mntmCadastroDeUsuario = new JMenuItem("Cadastro de Usuario");
		mnUsuarios.add(mntmCadastroDeUsuario);
		
		JMenuItem mntmAlterarUsuario = new JMenuItem("Alterar Usuario");
		mntmAlterarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaAlterarUsuario window = new TelaAlterarUsuario();
			window.frmAlterarUsuario.setVisible(true);
			
			}
		});
		mnUsuarios.add(mntmAlterarUsuario);
		mntmCadastroDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Fachada fachada = Fachada.getInstance();
//				if(TelaLogin.usuario.equals("ADMIN")){
					TelaCadastroUsuario window = new TelaCadastroUsuario();
					window.frmAcessoAoSistema.setVisible(true);
//				}else{
//					JOptionPane.showMessageDialog(framePrincipal, "FAVOR ENTRAR COMO ADMINSTRADOR DO SISTEMA"+"\nPARA CADASTRAR UM NOVO USUARIO!");
//				}
				
			}
		});
		mnCadastro.add(mntmDadosDaEmpresa);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBarPrinciapal.add(mnClientes);
		
		JMenu mnCadastrp = new JMenu("Cadastro");
		mnCadastrp.setBackground(new Color(255, 255, 255));
		mnClientes.add(mnCadastrp);
		
		JMenuItem mntmPessoaFisica_1 = new JMenuItem("Pessoa Fisica");
		mntmPessoaFisica_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroClienteFisico window = new TelaCadastroClienteFisico();
				window.frmCadastroClienteFisico.setVisible(true);
			}
		});
		mnCadastrp.add(mntmPessoaFisica_1);
		
		JMenuItem mntmPessoaJuridica = new JMenuItem("Pessoa Juridica");
		mntmPessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			TelaCadastroClienteJuridico window = new TelaCadastroClienteJuridico();
			window.frmCadastroClienteJuridico.setVisible(true);
			}
		});
		mnCadastrp.add(mntmPessoaJuridica);
		
		JMenu mnBusca = new JMenu("Buscar");
		mnBusca.setBackground(new Color(255, 255, 255));
		mnClientes.add(mnBusca);
		
		JMenuItem mntmPessoaFisica = new JMenuItem("Pessoa Fisica");
		mntmPessoaFisica.setBackground(new Color(255, 255, 255));
		mntmPessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			TelaBuscarClienteFisico window = new TelaBuscarClienteFisico();
			window.frmBuscarClienteFisico.setVisible(true);
			}
		});
		mnBusca.add(mntmPessoaFisica);
		
		JMenuItem mntmJuridico = new JMenuItem("Pessoa Juridica");
		mntmJuridico.setBackground(new Color(255, 255, 255));
		mntmJuridico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			TelaBuscarClienteJuridico window = new TelaBuscarClienteJuridico();
			window.frmBuscarClienteJuridico.setVisible(true);
			}
		});
		mnBusca.add(mntmJuridico);
		
		JMenu mnContratos = new JMenu("Contratos");
		menuBarPrinciapal.add(mnContratos);
		
		JMenu mnContratoFsico = new JMenu("Contrato F\u00EDsico");
		mnContratos.add(mnContratoFsico);
		
		JMenuItem mntmFazerUmContrato = new JMenuItem("Fazer um Contrato");
		mntmFazerUmContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaContrato window = new TelaContrato();
				window.frmContrato.setVisible(true);
			}
		});
		mnContratoFsico.add(mntmFazerUmContrato);
		
		JMenuItem mntmProcurarUmContrato = new JMenuItem("Procurar um Contrato");
		mntmProcurarUmContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaBuscarContratoFisico window = new TelaBuscarContratoFisico();
				window.frmBuscarContratoFisico.setVisible(true);
				
			}
		});
		mnContratoFsico.add(mntmProcurarUmContrato);
		
		JMenu mnContratoJurdico = new JMenu("Contrato Jur\u00EDdico");
		mnContratos.add(mnContratoJurdico);
		
		JMenuItem mntmFazerUmContrato_1 = new JMenuItem("Fazer um Contrato");
		mntmFazerUmContrato_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaContratoPJ window = new TelaContratoPJ();
				window.frmContrato.setVisible(true);
			}
		});
		mnContratoJurdico.add(mntmFazerUmContrato_1);
		
		JMenuItem mntmPrpcurarUmContrato = new JMenuItem("Procurar um Contrato");
		mntmPrpcurarUmContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaBuscarContratoJuridico window = new TelaBuscarContratoJuridico();
				window.frmBuscarContratoJuridico.setVisible(true);
				
			}
		});
		mnContratoJurdico.add(mntmPrpcurarUmContrato);
		
		JMenu mnNewMenu = new JMenu("Profissionais ");
		menuBarPrinciapal.add(mnNewMenu);
		
		JMenu mnCadastro_1 = new JMenu("Cadastro");
		mnNewMenu.add(mnCadastro_1);
		
		JMenuItem mntmArquiteto = new JMenuItem("Arquiteto");
		mntmArquiteto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    TelaCadastroArquiteto window = new TelaCadastroArquiteto();
				window.frmCadastroArquiteto.setVisible(true);

			}
		});
		mnCadastro_1.add(mntmArquiteto);
		
		JMenuItem mntmEngenherio = new JMenuItem("Engenherio");
		mntmEngenherio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastroEngenheiro window = new TelaCadastroEngenheiro();
				window.frmCadastroEngenheiro.setVisible(true);
			}
		});
		mnCadastro_1.add(mntmEngenherio);
		
		JMenuItem mntmEncanador = new JMenuItem("Encanador");
		mntmEncanador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroEncanador window = new TelaCadastroEncanador();
				window.frmCadastroEncanador.setVisible(true);
			}
		});
		mnCadastro_1.add(mntmEncanador);
		
		JMenuItem mntmEletricista = new JMenuItem("Eletricista");
		mntmEletricista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroEletricista window = new TelaCadastroEletricista();
				window.frmCadastroEletricista.setVisible(true);
			}
		});
		mnCadastro_1.add(mntmEletricista);
		
		JMenuItem mntmMestreDeObra = new JMenuItem("Mestre de Obra");
		mntmMestreDeObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroMestredeObras window = new TelaCadastroMestredeObras();
				window.frmCadastroMestredeObras.setVisible(true);
			}
		});
		
		JMenuItem mntmJardineiro = new JMenuItem("Jardineiro");
		mntmJardineiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroJardineiro window = new TelaCadastroJardineiro();
				window.frmCadastroJardineiro.setVisible(true);
			}
		});
		mnCadastro_1.add(mntmJardineiro);
		mnCadastro_1.add(mntmMestreDeObra);
		
		JMenu mnBuscar = new JMenu("Buscar");
		mnNewMenu.add(mnBuscar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Arquiteto");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarArquiteto window = new TelaBuscarArquiteto();
				window.frmBuscarArquiteto.setVisible(true);
				
			}
		});
		mnBuscar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Engenheiro");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarEngenheiro window = new TelaBuscarEngenheiro();
				window.frmBuscarEngenheiro.setVisible(true);
				
			}
		});
		mnBuscar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Mestre de Obra");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarMestreDeObras window = new TelaBuscarMestreDeObras();
				window.frmBuscarMestreDeObras.setVisible(true);
			}
		});
		
		JMenuItem mntmEletricista_1 = new JMenuItem("Eletricista");
		mntmEletricista_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarEletricista window = new TelaBuscarEletricista();
				window.frmBuscarEletricista.setVisible(true);
			}
		});
		mnBuscar.add(mntmEletricista_1);
		
		JMenuItem mntmEncanador_1 = new JMenuItem("Encanador");
		mntmEncanador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarEncanador window = new TelaBuscarEncanador();
				window.frame.setVisible(true);
			}
		});
		mnBuscar.add(mntmEncanador_1);
		
		JMenuItem mntmJardineiro_1 = new JMenuItem("Jardineiro");
		mntmJardineiro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarJardineiro window = new TelaBuscarJardineiro();
				window.frmBuscarJardineiro.setVisible(true);
			}
		});
		mnBuscar.add(mntmJardineiro_1);
		mnBuscar.add(mntmNewMenuItem_2);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBarPrinciapal.add(mnRelatrios);
		
		JMenuItem mntmAtendentes = new JMenuItem("Atendentes");
		mntmAtendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaListarAtendentes window = new TelaListarAtendentes();
				window.frmAtendentes.setVisible(true);
			}
		});
		mnRelatrios.add(mntmAtendentes);
		
		JMenuItem mntmGerentes = new JMenuItem("Gerentes");
		mntmGerentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaListarGerente window = new TelaListarGerente();
				window.frmRelatrioGerentes.setVisible(true);
			}
		});
		mnRelatrios.add(mntmGerentes);
		
		JMenu mnContratos_1 = new JMenu("Contratos");
		mnRelatrios.add(mnContratos_1);
		
		JMenuItem mntmContrtatosFisicos = new JMenuItem("Contrtatos Fisicos");
		mntmContrtatosFisicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarContratos window = new TelaListarContratos();
				window.frmContratosFisicos.setVisible(true);
			}
		});
		mnContratos_1.add(mntmContrtatosFisicos);
		
		JMenuItem mntmContratosJuridicos = new JMenuItem("Contratos Juridicos");
		mntmContratosJuridicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EJT.ContratoJuridico.TelaListarContratos window;
				try {
					window = new EJT.ContratoJuridico.TelaListarContratos();
					window.frmContratosJuridicos.setVisible(true);	
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
				}
		});
		mnContratos_1.add(mntmContratosJuridicos);
		
		JMenu mnArquitetos = new JMenu("Arquitetos");
		mnRelatrios.add(mnArquitetos);
		
		JMenuItem mntmDisponiveis_2 = new JMenuItem("Disponiveis");
		mntmDisponiveis_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelArquiteto window = new TelaListarDisponivelArquiteto();
				window.frame.setVisible(true);
				
			}
		});
		mnArquitetos.add(mntmDisponiveis_2);
		
		JMenuItem mntmTodos_2 = new JMenuItem("Todos");
		mntmTodos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarArquiteto window = new TelaListarArquiteto();
				window.frmArquitetos.setVisible(true);
				
			}
		});
		mnArquitetos.add(mntmTodos_2);
		
		JMenu mnJardineiros = new JMenu("Jardineiros");
		mnRelatrios.add(mnJardineiros);
		
		JMenuItem mntmTodos_5 = new JMenuItem("Todos");
		mntmTodos_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarJardineiro window = new TelaListarJardineiro();
				window.frame.setVisible(true);
			}
		});
		mnJardineiros.add(mntmTodos_5);
		
		JMenuItem mntmDisponiveis_5 = new JMenuItem("Disponiveis ");
		mntmDisponiveis_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarDisponivelJardineiro window = new TelaListarDisponivelJardineiro();
				window.frame.setVisible(true);
			}
		});
		mnJardineiros.add(mntmDisponiveis_5);
		
		JMenu mnClientes_1 = new JMenu("Clientes");
		mnRelatrios.add(mnClientes_1);
		
		JMenuItem mntmPessoaFisica_2 = new JMenuItem("Pessoa Fisica");
		mntmPessoaFisica_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarClienteFisico window = new TelaListarClienteFisico();
				window.frame.setVisible(true);
				
			}
		});
		mnClientes_1.add(mntmPessoaFisica_2);
		
		JMenuItem mntmPessoaJuridica_2 = new JMenuItem("Pessoa Juridica");
		mntmPessoaJuridica_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaListarClienteJuridico window = new TelaListarClienteJuridico();
				window.frame.setVisible(true);
			}
		});
		mnClientes_1.add(mntmPessoaJuridica_2);
		
		JMenu mnEngenheiros = new JMenu("Engenheiros");
		mnRelatrios.add(mnEngenheiros);
		
		JMenuItem mntmDisponiveis = new JMenuItem("Disponiveis");
		mntmDisponiveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelEngenheiro window = new TelaListarDisponivelEngenheiro();
				window.frmEngenheirosDisponiveis.setVisible(true);
			}
		});
		mnEngenheiros.add(mntmDisponiveis);
		
		JMenuItem mntmTodos = new JMenuItem("Todos");
		mntmTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarEngenheiro window = new TelaListarEngenheiro();
				window.frmRelatrioEngenheiros.setVisible(true);
				
			}
		});
		mnEngenheiros.add(mntmTodos);
		
		JMenu mnEletricista = new JMenu("Eletricistas");
		mnRelatrios.add(mnEletricista);
		
		JMenuItem mntmDisponiveis_1 = new JMenuItem("Disponiveis");
		mntmDisponiveis_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelEletricista window = new TelaListarDisponivelEletricista();
				window.frmEletricistasDisponiveis.setVisible(true);
			}
		});
		mnEletricista.add(mntmDisponiveis_1);
		
		JMenuItem mntmTodos_1 = new JMenuItem("Todos");
		mntmTodos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarEletricista window = new TelaListarEletricista();
				window.frmRelatrioEletricista.setVisible(true);
			}
		});
		mnEletricista.add(mntmTodos_1);
		
		JMenu mnMestresDeObra = new JMenu("Mestres de Obra");
		mnRelatrios.add(mnMestresDeObra);
		
		JMenuItem mntmDisponiveis_3 = new JMenuItem("Disponiveis");
		mntmDisponiveis_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelMestreDeObras window = new TelaListarDisponivelMestreDeObras();
				window.frame.setVisible(true);
			}
		});
		mnMestresDeObra.add(mntmDisponiveis_3);
		
		JMenuItem mntmTodos_3 = new JMenuItem("Todos");
		mntmTodos_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			TelaListarMestre window = new TelaListarMestre();
			window.frame.setVisible(true);
			
			}
		});
		mnMestresDeObra.add(mntmTodos_3);
		
		JMenu mnEncanadores = new JMenu("Encanadores");
		mnRelatrios.add(mnEncanadores);
		
		JMenuItem mntmDisponiveis_4 = new JMenuItem("Disponiveis");
		mntmDisponiveis_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarDisponivelEncanador window = new TelaListarDisponivelEncanador();
				window.frmEncanadoresDisponiveis.setVisible(true);
			}
		});
		mnEncanadores.add(mntmDisponiveis_4);
		
		JMenuItem mntmTodos_4 = new JMenuItem("Todos");
		mntmTodos_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarEncanador window = new TelaListarEncanador();
				window.frmRelatrioEncanadores.setVisible(true);
			}
		});
		mnEncanadores.add(mntmTodos_4);
	
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		formatador.format(data);
		
		//lblTeste.setText("Data atual: "+formatador.format(data));
		
		
		Calendar calendar = new GregorianCalendar();
		Date trialTime = new Date();
		calendar.setTime(trialTime);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("PasswordField.border"));
		panel.setBounds(0, 667, 1370, 38);
		framePrincipal.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTeste = new JLabel("Teste");
		lblTeste.setBounds(10, 0, 287, 30);
		panel.add(lblTeste);
		lblTeste.setText("Hora do Acesso ao Sistema:  "+calendar.getTime().toLocaleString());
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setBounds(959, 9, 99, 14);
		panel.add(lblAlunos);
		
		JLabel lblNewLabel = new JLabel("Eric Gustavo, Juliano Araujo, Erivan , Talles Pacheco");
		lblNewLabel.setBounds(1031, 2, 302, 28);
		panel.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(326, 8, 50, 14);
		panel.add(lblUsuario);
		
		JLabel LoginUsuario = new JLabel("ADMIN");
		LoginUsuario.setBounds(386, 8, 107, 14);
		panel.add(LoginUsuario);
		LoginUsuario.setText("teste");
		lblNewLabel_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/EJT/imagens/logotipo2.png")));
		lblNewLabel_1.setBounds(506, 153, 339, 410);
		framePrincipal.getContentPane().add(lblNewLabel_1);
		LoginUsuario.setText(TelaLogin.usuario.toUpperCase());
		
		JLabel lblSair = new JLabel("sair");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		
System.exit(0);

			}
		});
		lblSair.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/EJT/imagens/bot_sair.png")));
		lblSair.setBounds(1283, 24, 69, 69);
		framePrincipal.getContentPane().add(lblSair);
		
		JLabel lblFafica = new JLabel("FAFICA");
		lblFafica.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/EJT/imagens/fafica.png")));
		lblFafica.setBounds(937, 498, 401, 158);
		framePrincipal.getContentPane().add(lblFafica);
		
		JLabel lblTs = new JLabel("TS");
		lblTs.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/EJT/imagens/fundoteste2.jpg")));
		lblTs.setBounds(0, 11, 1370, 660);
		framePrincipal.getContentPane().add(lblTs);
		
		
		
		
	

		
	}
}
