package EJT.Encanador;

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
import javax.swing.table.DefaultTableModel;

import EJT.Arquiteto.Arquiteto;
import EJT.Fachada.Fachada;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarDisponivelEncanador {

	private JPanel contentPane;
	public JFrame frmEncanadoresDisponiveis;
	private JTable tableEncanador;
	private Fachada fachada;
	private String[] colunaTabelaEncanador;
	private DefaultTableModel tabelaEncanador;
	private JButton BotaoSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarDisponivelEncanador window = new TelaListarDisponivelEncanador();
					window.frmEncanadoresDisponiveis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarDisponivelEncanador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEncanadoresDisponiveis = new JFrame();
		frmEncanadoresDisponiveis.setType(Type.UTILITY);
		frmEncanadoresDisponiveis.setTitle("Encanadores Disponiveis");
		frmEncanadoresDisponiveis.setBounds(100, 100, 628, 460);
		frmEncanadoresDisponiveis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//copia isso
		frmEncanadoresDisponiveis.setExtendedState(frmEncanadoresDisponiveis.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		
		BotaoSair = new JButton("SAIR");
		BotaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEncanadoresDisponiveis.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmEncanadoresDisponiveis.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(BotaoSair, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(BotaoSair)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tableEncanador = new JTable();
		colunaTabelaEncanador = new String[] {"NOME", "CPF",  "DISPONIBILIDADE",  "CELULAR"};
		tabelaEncanador = new DefaultTableModel(new Object[][] {},colunaTabelaEncanador);
		tableEncanador.setModel(tabelaEncanador);
		scrollPaneListagemCliente.setViewportView(tableEncanador);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frmEncanadoresDisponiveis.getContentPane().setLayout(groupLayout);
		
		listarTodosAEncanador();
		
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosAEncanador() {
		
		try {
			ArrayList<Encanador> listar = Fachada.getInstance().encanadorListar();
			
			for(Encanador encanador: listar) {
				Vector vector = new Vector();
				vector.add(encanador.getNome());
				vector.add(encanador.getCpf());			
				vector.add(encanador.getDisponibilidade());
				vector.add(encanador.getContato().getCelular());
				
				if(encanador.getDisponibilidade().equalsIgnoreCase("DISPONIVEL")){
				tabelaEncanador.addRow(vector);
				}
				}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmEncanadoresDisponiveis, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}


}
