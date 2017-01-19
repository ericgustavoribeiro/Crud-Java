package EJT.Gerente;


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
import javax.swing.table.DefaultTableModel;

import EJT.Fachada.Fachada;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class TelaListarGerente {

	public JFrame frmRelatrioGerentes;
	private JTable tableGerente;
	private Fachada fachada;
	private String[] colunaTabelaGerente;
	private DefaultTableModel tabelaGerente;
	private JButton btnNovo;
	private JButton btnBuscar;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarGerente window = new TelaListarGerente();
					window.frmRelatrioGerentes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarGerente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRelatrioGerentes = new JFrame();
		frmRelatrioGerentes.getContentPane().setForeground(Color.WHITE);
		frmRelatrioGerentes.setTitle("Relat\u00F3rio Gerentes");
		frmRelatrioGerentes.setBounds(100, 100, 628, 460);
		frmRelatrioGerentes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRelatrioGerentes.setExtendedState(frmRelatrioGerentes.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		btnNovo = new JButton("Novo ");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroGerente window = new TelaCadastroGerente();
				window.frmCadastroGerente.setVisible(true);
			}
		});
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarGerente window = new TelaBuscarGerente();
				window.frmBuscarGerente.setVisible(true);
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRelatrioGerentes.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmRelatrioGerentes.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1168, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNovo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(btnNovo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSair)))
					.addContainerGap())
		);
		
		tableGerente = new JTable();
		colunaTabelaGerente = new String[] {"ID", "NOME", "CPF","RG","LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "ESTADO", "CEP", "EMAIL", "TELEFONE","CELULAR"};
		tabelaGerente = new DefaultTableModel(new Object[][] {},colunaTabelaGerente);
		tableGerente.setModel(tabelaGerente);
		scrollPaneListagemCliente.setViewportView(tableGerente);
		frmRelatrioGerentes.getContentPane().setLayout(groupLayout);
		listarTodosAtendentes();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosAtendentes() {
		
		try {
		
			ArrayList<Gerente> listar = Fachada.getInstance().gerenteListar();
			
			for(Gerente gerente: listar) {
				Vector vector = new Vector();
				vector.add(gerente.getId_gerente());
				vector.add(gerente.getNome());
				vector.add(gerente.getCpf());
				vector.add(gerente.getRg());
				vector.add(gerente.getEndereco().getLogradouro());
				vector.add(gerente.getEndereco().getNumero());
				vector.add(gerente.getEndereco().getBairro());
				vector.add(gerente.getEndereco().getCidade());
				vector.add(gerente.getEndereco().getEstado());
				vector.add(gerente.getEndereco().getCep());
				vector.add(gerente.getContato().getEmail());
				vector.add(gerente.getContato().getTelefone());
				vector.add(gerente.getContato().getCelular());
				tabelaGerente.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmRelatrioGerentes, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
