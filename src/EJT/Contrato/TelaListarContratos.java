package EJT.Contrato;

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

import EJT.Arquiteto.Arquiteto;
import EJT.Arquiteto.TelaListarArquiteto;
import EJT.Fachada.Fachada;
import javax.swing.JButton;

public class TelaListarContratos {

	public JPanel contentPane;
	public JFrame frmContratosFisicos;
	private JTable tableContratos;
	private Fachada fachada;
	private String[] colunaTabelaContratos;
	private DefaultTableModel tabelaContratos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarContratos window = new TelaListarContratos();
					window.frmContratosFisicos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarContratos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContratosFisicos = new JFrame();
		frmContratosFisicos.setTitle("CONTRATOS FISICOS ");
		frmContratosFisicos.setBounds(100, 100, 628, 460);
		frmContratosFisicos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//copia isso
		frmContratosFisicos.setExtendedState(frmContratosFisicos.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frmContratosFisicos.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1169, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		
		tableContratos = new JTable();
		colunaTabelaContratos = new String[] {"ID", "CLIENTE", "ATENDENTE",  "ARQUITETO", "ELETRICISTA", "ENCANADOR", "ENGENHEIRO", 
				"JARDINEIRO", "MESTRE", "GERENTE", "EMPRESA", "DESCRICAO"};
		tabelaContratos = new DefaultTableModel(new Object[][] {},colunaTabelaContratos);
		tableContratos.setModel(tabelaContratos);
		scrollPaneListagemCliente.setViewportView(tableContratos);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frmContratosFisicos.getContentPane().setLayout(groupLayout);
		
		
		listarTodosArquiteto();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosArquiteto() {
		
		try {
			ArrayList<Contrato> listar = Fachada.getInstance().contratoFisicoListar();
			for(Contrato contrato: listar) {
				Vector vector = new Vector();
				vector.add(contrato.getIdContrato());
				vector.add(contrato.getClienteFisico().getNome());
				vector.add(contrato.getAtendente().getNome());
				vector.add(contrato.getArquiteto().getNome());
				vector.add(contrato.getEletricista().getNome());			
				vector.add(contrato.getEncanador().getNome());
				vector.add(contrato.getEngenheiro().getNome());
				vector.add(contrato.getJardineiro().getNome());
				vector.add(contrato.getMestreDeObras().getNome());
				vector.add(contrato.getGerente().getNome());
				vector.add(contrato.getEmpresa().getNome_fantasia());
				vector.add(contrato.getDescricao());
				
				tabelaContratos.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmContratosFisicos, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
