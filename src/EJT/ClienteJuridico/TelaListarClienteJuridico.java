package EJT.ClienteJuridico;

import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import EJT.Fachada.Fachada;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class TelaListarClienteJuridico extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
	//private JFrame frmRelatorioClientesJuridicos;
	private JTable tableClienteJuridico;
	private Fachada fachada;
	private String[] colunaTabelaClienteJuridico;
	private DefaultTableModel tabelaClienteJuridico;
	private JButton btnNovoCliente;
	private JButton btnBuscarCliente;
	private JButton btnSair;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarClienteJuridico window = new TelaListarClienteJuridico();
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
	public TelaListarClienteJuridico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setTitle("RELATORIO CLIENTES JURIDICOS");
		frame.setBounds(100, 100, 628, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroClienteJuridico window = new TelaCadastroClienteJuridico();
				window.frmCadastroClienteJuridico.setVisible(true);
			}
		});
		
		btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarClienteJuridico window = new TelaBuscarClienteJuridico();
				window.frmBuscarClienteJuridico.setVisible(true);
				
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1227, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNovoCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBuscarCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(btnSair)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(btnNovoCliente)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscarCliente)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSair))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		tableClienteJuridico = new JTable();
		colunaTabelaClienteJuridico = new String[] {"ID", "NOME", "CNPJ", "INS ESTADUAL", "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "UF", "CEP", "EMAIL", "TEL", "CEL"};
		tabelaClienteJuridico = new DefaultTableModel(new Object[][] {},colunaTabelaClienteJuridico);
		tableClienteJuridico.setModel(tabelaClienteJuridico);
		scrollPaneListagemCliente.setViewportView(tableClienteJuridico);
		frame.getContentPane().setLayout(groupLayout);
		listarTodosClienteJuridico();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosClienteJuridico() {
		
		try {
			
			ArrayList<ClienteJuridico> listar = Fachada.getInstance().clienteJuridicoListar();
		
			for(ClienteJuridico cliente: listar) {
				Vector vector = new Vector();
				vector.add(cliente.getId_juridico());
				vector.add(cliente.getNome());
				vector.add(cliente.getCnpj());
				vector.add(cliente.getInscricao_estadual());
				vector.add(cliente.getEndereco().getLogradouro());
				vector.add(cliente.getEndereco().getNumero());
				vector.add(cliente.getEndereco().getBairro());
				vector.add(cliente.getEndereco().getCidade());
				vector.add(cliente.getEndereco().getEstado());
				vector.add(cliente.getEndereco().getCep());
				vector.add(cliente.getContato().getEmail());
				vector.add(cliente.getContato().getTelefone());
				vector.add(cliente.getContato().getCelular());
				
				tabelaClienteJuridico.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
