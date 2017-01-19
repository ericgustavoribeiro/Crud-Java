package EJT.Engenheiro;

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
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarDisponivelEngenheiro extends JFrame {

	public JFrame frmEngenheirosDisponiveis;
	private JTable tableEngenheiro;
	private Fachada fachada;
	private String[] colunaTabelaEngenheiro;
	private DefaultTableModel tabelaEngenheiro;
	private JButton BotaoSair;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarDisponivelEngenheiro window = new TelaListarDisponivelEngenheiro();
					window.frmEngenheirosDisponiveis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarDisponivelEngenheiro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEngenheirosDisponiveis = new JFrame();
		frmEngenheirosDisponiveis.setTitle("Engenheiros Disponiveis");
		frmEngenheirosDisponiveis.setType(Type.UTILITY);
		frmEngenheirosDisponiveis.setBounds(100, 100, 628, 460);
		frmEngenheirosDisponiveis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frmEngenheirosDisponiveis.setExtendedState(frmEngenheirosDisponiveis.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		
		BotaoSair = new JButton("SAIR");
		BotaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEngenheirosDisponiveis.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmEngenheirosDisponiveis.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
						.addComponent(BotaoSair, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(BotaoSair)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		tableEngenheiro = new JTable();
		colunaTabelaEngenheiro = new String[] {"NOME", "CPF","CREA", "DISPONIBILIDADE", "CELULAR"};
		tabelaEngenheiro = new DefaultTableModel(new Object[][] {},colunaTabelaEngenheiro);
		tableEngenheiro.setModel(tabelaEngenheiro);
		scrollPaneListagemCliente.setViewportView(tableEngenheiro);
		frmEngenheirosDisponiveis.getContentPane().setLayout(groupLayout);
		listarTodosEngenheiro();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosEngenheiro() {
		
		try {
			
			ArrayList<Engenheiro> listar = Fachada.getInstance().engenheiroListar();
			
			for(Engenheiro engenheiro: listar) {
				Vector vector = new Vector();
				vector.add(engenheiro.getNome());
				vector.add(engenheiro.getCpf());
				vector.add(engenheiro.getCrea());
				vector.add(engenheiro.getDisponibilidade());
				vector.add(engenheiro.getContato().getCelular());
				
				if(engenheiro.getDisponibilidade().equalsIgnoreCase("DISPONIVEL")){
				tabelaEngenheiro.addRow(vector);
				}
				}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmEngenheirosDisponiveis, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
