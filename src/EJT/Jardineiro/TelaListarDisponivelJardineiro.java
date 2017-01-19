package EJT.Jardineiro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import EJT.Fachada.Fachada;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarDisponivelJardineiro extends JFrame {

	private JPanel contentPane;
	public JFrame frame;
	private JTable tableJardineiro;
	private Fachada fachada;
	private String[] colunaTabelaJardineiro;
	private DefaultTableModel tabelaJardineiro;
	private JButton BotaoSair;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarDisponivelJardineiro window = new TelaListarDisponivelJardineiro();
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
	public TelaListarDisponivelJardineiro() {
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
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		
		BotaoSair = new JButton("SAIR");
		BotaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(BotaoSair, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 648, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(BotaoSair)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		tableJardineiro = new JTable();
		colunaTabelaJardineiro = new String[] {"NOME", "CPF", "DISPONIBILIDADE", "CEL"};
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
				vector.add(jardineiro.getNome());
				vector.add(jardineiro.getCpf());
				vector.add(jardineiro.getDisponibilidade());
				vector.add(jardineiro.getContato().getCelular());
				
				if(jardineiro.getDisponibilidade().equalsIgnoreCase("DISPONIVEL")){
				tabelaJardineiro.addRow(vector);
				}
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
