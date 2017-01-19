package EJT.ContratoJuridico;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import EJT.Fachada.Fachada;
import EJT.Jardineiro.JardineiroJaCadastradoException;

public class TelaListarContratos extends JFrame {

	public JPanel contentPane;
	public JFrame frmContratosJuridicos;
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
					window.frmContratosJuridicos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public TelaListarContratos() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frmContratosJuridicos = new JFrame();
		frmContratosJuridicos.setTitle("CONTRATOS JURIDICOS");
		frmContratosJuridicos.setBounds(100, 100, 628, 460);
		frmContratosJuridicos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmContratosJuridicos.setExtendedState(frmContratosJuridicos.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frmContratosJuridicos.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1169, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(175, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		
		tableContratos = new JTable();
		colunaTabelaContratos = new String[] {"ID", "CLIENTE", "ATENDENTE", "ARQUITETO", "ELETRICISTA", "ENCANADOR", "ENGENHEIRO", "JARDINEIRO", "MESTRE", "GERENTE", "EMPRESA", "DESCRICAO"};
		tabelaContratos = new DefaultTableModel(new Object[][] {},colunaTabelaContratos);
		tableContratos.setModel(tabelaContratos);
		scrollPaneListagemCliente.setViewportView(tableContratos);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frmContratosJuridicos.getContentPane().setLayout(groupLayout);
		
		
		listarTodosArquiteto();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosArquiteto() throws Exception {
		
		try {
			ArrayList<ContratoJuridico> listar = Fachada.getInstance().contratoJuridicoListar();
			
			for(ContratoJuridico contrato: listar) {
				Vector vector = new Vector();
				
				vector.add(contrato.getIdContrato());
				vector.add(contrato.getClienteJuridico().getNome());
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
		
			
		} catch (JardineiroJaCadastradoException e) {
			JOptionPane.showMessageDialog(frmContratosJuridicos, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
