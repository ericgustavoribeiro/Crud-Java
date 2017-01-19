package EJT.Arquiteto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
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

public class TelaListarDisponivelArquiteto extends JFrame {

	public JPanel contentPane;
	public JFrame frame;
	private JTable tableArquiteto;
	private Fachada fachada;
	private String[] colunaTabelaArquiteto;
	private DefaultTableModel tabelaArquiteto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarDisponivelArquiteto window = new TelaListarDisponivelArquiteto();
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
	public TelaListarDisponivelArquiteto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//copia isso
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		
		JButton botaoSair = new JButton("SAIR ");
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(1269, Short.MAX_VALUE)
							.addComponent(botaoSair, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 649, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(botaoSair)
					.addContainerGap())
		);
		
		tableArquiteto = new JTable();
		colunaTabelaArquiteto = new String[] {"NOME", "CPF", "CAU", "DISPONIBILIDADE", "CELULAR"};
		tabelaArquiteto = new DefaultTableModel(new Object[][] {},colunaTabelaArquiteto);
		tableArquiteto.setModel(tabelaArquiteto);
		scrollPaneListagemCliente.setViewportView(tableArquiteto);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frame.getContentPane().setLayout(groupLayout);
		
		
		listarTodosArquiteto();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosArquiteto() {
		
		try {
	
			ArrayList<Arquiteto> listar = Fachada.getInstance().arquitetoListar();
		
			
			for(Arquiteto arquiteto: listar) {
				
				
				Vector vector = new Vector();
				vector.add(arquiteto.getNome());
				vector.add(arquiteto.getCpf());
				vector.add(arquiteto.getCau());			
				vector.add(arquiteto.getDisponibilidade());
                vector.add(arquiteto.getContato().getCelular());
				
				if(arquiteto.getDisponibilidade().equalsIgnoreCase("DISPONIVEL")){
				tabelaArquiteto.addRow(vector);
				}
				}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
