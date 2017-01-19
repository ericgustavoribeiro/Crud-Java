	package EJT.Encanador;

import java.awt.EventQueue;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import EJT.Fachada.Fachada;
import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Window.Type;

public class TelaListarEncanador {

	public JFrame frmRelatrioEncanadores;
	private JTable tableEncanador;
	private Fachada fachada;
	private String[] colunaTabelaEncanador;
	private DefaultTableModel tabelaEncanador;
	private JButton btnNovoEncanador;
	private JButton btnBuscarEncanador;
	private JButton btnSair;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarEncanador window = new TelaListarEncanador();
					window.frmRelatrioEncanadores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarEncanador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRelatrioEncanadores = new JFrame();
		frmRelatrioEncanadores.setTitle("Relat\u00F3rio Encanadores");
		frmRelatrioEncanadores.setType(Type.UTILITY);
		frmRelatrioEncanadores.getContentPane().setBackground(SystemColor.window);
		frmRelatrioEncanadores.setBounds(100, 100, 628, 460);
		frmRelatrioEncanadores.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frmRelatrioEncanadores.setExtendedState(frmRelatrioEncanadores.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		btnNovoEncanador = new JButton("Novo Encanador");
		btnNovoEncanador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			TelaCadastroEncanador window = new TelaCadastroEncanador();
			window.frmCadastroEncanador.setVisible(true);
				
			}
		});
		
		btnBuscarEncanador = new JButton("Buscar Encanador");
		btnBuscarEncanador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				TelaBuscarEncanador window = new TelaBuscarEncanador();
				window.frame.setVisible(true);
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRelatrioEncanadores.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmRelatrioEncanadores.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1196, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNovoEncanador, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBuscarEncanador, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(btnSair)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(btnNovoEncanador)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscarEncanador)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair)))
					.addContainerGap())
		);
		
		tableEncanador = new JTable();
		colunaTabelaEncanador = new String[] {"ID", "NOME", "CPF","RG","DISPONIBILIDADE","LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "ESTADO", "CEP", "EMAIL", "TELEFONE","CELULAR"};
		tabelaEncanador = new DefaultTableModel(new Object[][] {},colunaTabelaEncanador);
		tableEncanador.setModel(tabelaEncanador);
		scrollPaneListagemCliente.setViewportView(tableEncanador);
		frmRelatrioEncanadores.getContentPane().setLayout(groupLayout);
		listarTodosEncanador();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosEncanador() {
		
		try {
		
			ArrayList<Encanador> listar = Fachada.getInstance().encanadorListar();

			for(Encanador encanador: listar) {
				Vector vector = new Vector();
				vector.add(encanador.getId_encanador());
				vector.add(encanador.getNome());
				vector.add(encanador.getCpf());
				vector.add(encanador.getRg());
				vector.add(encanador.getDisponibilidade());
				vector.add(encanador.getEndereco().getLogradouro());
				vector.add(encanador.getEndereco().getNumero());
				vector.add(encanador.getEndereco().getBairro());
				vector.add(encanador.getEndereco().getCidade());
				vector.add(encanador.getEndereco().getEstado());
				vector.add(encanador.getEndereco().getCep());
				vector.add(encanador.getContato().getEmail());
				vector.add(encanador.getContato().getTelefone());
				vector.add(encanador.getContato().getCelular());
				tabelaEncanador.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmRelatrioEncanadores, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
