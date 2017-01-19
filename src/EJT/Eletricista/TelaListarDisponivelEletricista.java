package EJT.Eletricista;

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
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarDisponivelEletricista extends JFrame {

	private JPanel contentPane;

	public JFrame frmEletricistasDisponiveis;
	private JTable tableEletricista;
	private Fachada fachada;
	private String[] colunaTabelaEletricista;
	private DefaultTableModel tabelaEletricista;
	private JButton BotaoSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarDisponivelEletricista window = new TelaListarDisponivelEletricista();
					window.frmEletricistasDisponiveis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarDisponivelEletricista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEletricistasDisponiveis = new JFrame();
		frmEletricistasDisponiveis.setBackground(SystemColor.window);
		frmEletricistasDisponiveis.setType(Type.UTILITY);
		frmEletricistasDisponiveis.setTitle("Eletricistas Disponiveis");
		frmEletricistasDisponiveis.setBounds(100, 100, 628, 460);
		frmEletricistasDisponiveis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEletricistasDisponiveis.setExtendedState(frmEletricistasDisponiveis.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		BotaoSair = new JButton("SAIR");
		BotaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEletricistasDisponiveis.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmEletricistasDisponiveis.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(BotaoSair, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(BotaoSair)
					.addContainerGap())
		);
		
		tableEletricista = new JTable();
		colunaTabelaEletricista = new String[] {"NOME", "CPF","DISPONIBILIDADE","CELULAR"};
		tabelaEletricista = new DefaultTableModel(new Object[][] {},colunaTabelaEletricista);
		tableEletricista.setModel(tabelaEletricista);
		scrollPaneListagemCliente.setViewportView(tableEletricista);
		frmEletricistasDisponiveis.getContentPane().setLayout(groupLayout);
		listarTodosEletricista();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosEletricista() {
		
		try {
			
			ArrayList<Eletricista> listar = Fachada.getInstance().eletricistaListar();
			
			for(Eletricista eletricista: listar) {
				Vector vector = new Vector();
				vector.add(eletricista.getNome());
				vector.add(eletricista.getCpf());
				vector.add(eletricista.getDisponibilidade());
				vector.add(eletricista.getContato().getCelular());
				
				if(eletricista.getDisponibilidade().equalsIgnoreCase("DISPONIVEL")){
				tabelaEletricista.addRow(vector);
				}
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmEletricistasDisponiveis, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
