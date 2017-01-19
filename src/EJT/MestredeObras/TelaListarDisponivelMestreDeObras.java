package EJT.MestredeObras;

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

public class TelaListarDisponivelMestreDeObras {
	

	public JPanel contentPane;
	public JFrame frame;
	private JTable tableMestre;
	private Fachada fachada;
	private String[] colunaTabelaMestre;
	private DefaultTableModel tabelaMestre;
	private JButton BotaoSair;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarDisponivelMestreDeObras window = new TelaListarDisponivelMestreDeObras();
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
	public TelaListarDisponivelMestreDeObras() {
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
							.addComponent(BotaoSair, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 637, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(BotaoSair)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		tableMestre = new JTable();
		colunaTabelaMestre = new String[] {"NOME", "CPF", "DISPONIBILIDADE", "CELULAR"};
		tabelaMestre = new DefaultTableModel(new Object[][] {},colunaTabelaMestre);
		tableMestre.setModel(tabelaMestre);
		scrollPaneListagemCliente.setViewportView(tableMestre);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frame.getContentPane().setLayout(groupLayout);
		
		
		listarTodosMestre();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosMestre() {
		
		try {
	
			ArrayList<MestreDeObras> listar = Fachada.getInstance().mestreListar();
		
			
			for(MestreDeObras mestre: listar) {
				
				Vector vector = new Vector();
				vector.add(mestre.getNome());
				vector.add(mestre.getCpf());		
				vector.add(mestre.getDisponibilidade());
                vector.add(mestre.getContato().getCelular());
				
				if(mestre.getDisponibilidade().equalsIgnoreCase("DISPONIVEL")){
				tabelaMestre.addRow(vector);
				}
				}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
