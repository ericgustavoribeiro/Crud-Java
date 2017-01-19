package EJT.Jardineiro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import EJT.Encanador.Encanador;
import EJT.Encanador.TelaListarEncanador;
import EJT.Fachada.Fachada;

public class TelaListarJardineiro extends JFrame {

	public JFrame frame;
	private JTable tableJardineiro;
	private Fachada fachada;
	private String[] colunaTabelaJardineiro;
	private DefaultTableModel tabelaJardineiro;
	private JButton btnNovoCadastro;
	private JButton btnBuscar;
	private JButton btnSair;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarJardineiro window = new TelaListarJardineiro();
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
	public TelaListarJardineiro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		
		frame.setUndecorated(true);
	    frame.setLocationRelativeTo(null); 
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		
		btnNovoCadastro = new JButton("Novo Cadastro");
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroJardineiro window = new TelaCadastroJardineiro();
				window.frmCadastroJardineiro.setVisible(true);
			}
		});
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarJardineiro window = new TelaBuscarJardineiro();
				window.frmBuscarJardineiro.setVisible(true);
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1209, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNovoCadastro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair)
							.addGap(45))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(btnNovoCadastro)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair)))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		
		tableJardineiro = new JTable();
		colunaTabelaJardineiro = new String[] {"ID", "NOME", "CPF","RG","DISPONIBILIDADE", "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "UF", "CEP", "EMAIL", "TEL","CEL"};
		tabelaJardineiro = new DefaultTableModel(new Object[][] {},colunaTabelaJardineiro);
		tableJardineiro.setModel(tabelaJardineiro);
		scrollPaneListagemCliente.setViewportView(tableJardineiro);
		frame.getContentPane().setLayout(groupLayout);
		listarTodosJardineiro();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosJardineiro() {
		
		try {
		
			ArrayList<Jardineiro> listar = Fachada.getInstance().jardineiroListar();

			for(Jardineiro jardineiro: listar) {
				Vector vector = new Vector();
				vector.add(jardineiro.getId_jardineiro());
				vector.add(jardineiro.getNome());
				vector.add(jardineiro.getCpf());
				vector.add(jardineiro.getRg());
				vector.add(jardineiro.getDisponibilidade());
				vector.add(jardineiro.getEndereco().getLogradouro());
				vector.add(jardineiro.getEndereco().getNumero());
				vector.add(jardineiro.getEndereco().getBairro());
				vector.add(jardineiro.getEndereco().getCidade());
				vector.add(jardineiro.getEndereco().getEstado());
				vector.add(jardineiro.getEndereco().getCep());
				vector.add(jardineiro.getContato().getEmail());
				vector.add(jardineiro.getContato().getTelefone());
				vector.add(jardineiro.getContato().getCelular());
				tabelaJardineiro.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
