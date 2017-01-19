package EJT.Empresa;

import java.awt.BorderLayout;
import java.awt.Component;
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

import EJT.Arquiteto.Arquiteto;
import EJT.Fachada.Fachada;

public class TelaListarEmpresa extends JFrame {

	private JPanel contentPane;
	public JFrame frmRelatorioEmpresa;
	private JTable tableEmpresa;
	private Fachada fachada;
	private String[] colunaTabelaEmpresa;
	private DefaultTableModel tabelaEmpresa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarEmpresa window = new TelaListarEmpresa();
					window.frmRelatorioEmpresa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarEmpresa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRelatorioEmpresa = new JFrame();
		frmRelatorioEmpresa.setTitle("RELATORIO EMPRESAS");
		frmRelatorioEmpresa.setBounds(100, 100, 628, 460);
		frmRelatorioEmpresa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frmRelatorioEmpresa.setExtendedState(frmRelatorioEmpresa.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemEmpresa = new JScrollPane();
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRelatorioEmpresa.dispose();
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmRelatorioEmpresa.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPaneListagemEmpresa, GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemEmpresa, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSair)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		Component scrollPaneListagemCliente;
		
		tableEmpresa = new JTable();
		colunaTabelaEmpresa = new String[] {"NOME", "CNPJ", "INS ESTADUAL", "RAZÃO SOCIAL", "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "UF", "CEP", "EMAIL", "TEL", "CEL"};
		tabelaEmpresa = new DefaultTableModel(new Object[][] {},colunaTabelaEmpresa);
		tableEmpresa.setModel(tabelaEmpresa);
		scrollPaneListagemEmpresa.setViewportView(tableEmpresa);
		frmRelatorioEmpresa.getContentPane().setLayout(groupLayout);
		
		
		listarEmpresa();
		
		
	}
private void listarEmpresa() {
		
		try {
			ArrayList<Empresa> listar = Fachada.getInstance().empresaListar();
			for(Empresa empresa: listar) {
				Vector vector = new Vector();
		
				vector.add(empresa.getNome_fantasia());
				vector.add(empresa.getCnpj());
				vector.add(empresa.getInscricao_estadual());
				vector.add(empresa.getRazao_socia());
				vector.add(empresa.getEndereco().getLogradouro());
				vector.add(empresa.getEndereco().getNumero());
				vector.add(empresa.getEndereco().getBairro());
				vector.add(empresa.getEndereco().getCidade());
				vector.add(empresa.getEndereco().getEstado());
				vector.add(empresa.getEndereco().getCep());
				vector.add(empresa.getContato().getEmail());
				vector.add(empresa.getContato().getTelefone());
				vector.add(empresa.getContato().getCelular());
				tabelaEmpresa.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmRelatorioEmpresa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
		
		
		
		
		
		
		
		
		
		
		
	
}
