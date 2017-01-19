package EJT.ClienteFisico;

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

import EJT.ClienteJuridico.TelaBuscarClienteJuridico;
import EJT.Fachada.Fachada;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class TelaListarClienteFisico extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
//	private JFrame frmRelatorioClientesFisicos;
	private JTable tableClienteFisico;
	private Fachada fachada;
	private String[] colunaTabelaClienteFisico;
	private DefaultTableModel tabelaClienteFisico;
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
					
					TelaListarClienteFisico window = new TelaListarClienteFisico();
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
	public TelaListarClienteFisico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setTitle("RELATORIO CLIENTES FISICOS");
		frame.setBounds(100, 100, 628, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2));
		
		btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroClienteFisico window = new TelaCadastroClienteFisico();
				window.frmCadastroClienteFisico.setVisible(true);
			}
		});
		
		btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarClienteFisico window = new TelaBuscarClienteFisico();
				window.frmBuscarClienteFisico.setVisible(true);
				
				
			
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
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1193, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBuscarCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNovoCliente, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(btnNovoCliente)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscarCliente)
					.addGap(18)
					.addComponent(btnSair)
					.addContainerGap(578, Short.MAX_VALUE))
		);
		
		tableClienteFisico = new JTable();
		colunaTabelaClienteFisico = new String[] {"ID", "NOME", "CPF", "RG", "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "UF", "CEP", "EMAIL", "TEL", "CEL"};
		tabelaClienteFisico = new DefaultTableModel(new Object[][] {},colunaTabelaClienteFisico);
		tableClienteFisico.setModel(tabelaClienteFisico);
		scrollPaneListagemCliente.setViewportView(tableClienteFisico);
		frame.getContentPane().setLayout(groupLayout);
		listarTodosClienteFisico();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosClienteFisico() {
		
		try {
			ArrayList<ClienteFisico> listar = Fachada.getInstance().clienteFisicoListar();
			for(ClienteFisico cliente: listar) {
				Vector vector = new Vector();
				vector.add(cliente.getId_clienteFisico());
				vector.add(cliente.getCpf());
				vector.add(cliente.getNome());
				vector.add(cliente.getRg());
				vector.add(cliente.getEndereco().getLogradouro());
				vector.add(cliente.getEndereco().getNumero());
				vector.add(cliente.getEndereco().getBairro());
				vector.add(cliente.getEndereco().getCidade());
				vector.add(cliente.getEndereco().getEstado());
				vector.add(cliente.getEndereco().getCep());
				vector.add(cliente.getContato().getEmail());
				vector.add(cliente.getContato().getTelefone());
				vector.add(cliente.getContato().getCelular());
				
				tabelaClienteFisico.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
