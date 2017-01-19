package EJT.Engenheiro;

import java.awt.EventQueue;
import java.awt.EventQueue;
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
import javax.swing.JFrame;
import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class TelaListarEngenheiro {

	public JFrame frmRelatrioEngenheiros;
	private JTable tableEngenheiro;
	private Fachada fachada;
	private String[] colunaTabelaEngenheiro;
	private DefaultTableModel tabelaEngenheiro;
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
					TelaListarEngenheiro window = new TelaListarEngenheiro();
					window.frmRelatrioEngenheiros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarEngenheiro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRelatrioEngenheiros = new JFrame();
		frmRelatrioEngenheiros.getContentPane().setBackground(SystemColor.window);
		frmRelatrioEngenheiros.setTitle("Relat\u00F3rio Engenheiros");
		frmRelatrioEngenheiros.setBounds(100, 100, 628, 460);
		frmRelatrioEngenheiros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frmRelatrioEngenheiros.setExtendedState(frmRelatrioEngenheiros.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroEngenheiro window = new TelaCadastroEngenheiro();
				window.frmCadastroEngenheiro.setVisible(true);
			}
		});
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarEngenheiro window = new TelaBuscarEngenheiro();
				window.frmBuscarEngenheiro.setVisible(true);
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRelatrioEngenheiros.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmRelatrioEngenheiros.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1213, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNovo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(btnNovo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair)))
					.addContainerGap())
		);
		
		tableEngenheiro = new JTable();
		colunaTabelaEngenheiro = new String[] {"ID", "NOME", "CPF","CREA", "RG", "DISPONIBILIDADE", "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "ESTADO", "CEP", "EMAIL", "TELEFONE","CELULAR"};
		tabelaEngenheiro = new DefaultTableModel(new Object[][] {},colunaTabelaEngenheiro);
		tableEngenheiro.setModel(tabelaEngenheiro);
		scrollPaneListagemCliente.setViewportView(tableEngenheiro);
		frmRelatrioEngenheiros.getContentPane().setLayout(groupLayout);
		listarTodosEngenheiro();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosEngenheiro() {
		
		try {
			
			ArrayList<Engenheiro> listar = Fachada.getInstance().engenheiroListar();
			
			for(Engenheiro engenheiro: listar) {
				Vector vector = new Vector();
				vector.add(engenheiro.getId_engenheiro());
				vector.add(engenheiro.getNome());
				vector.add(engenheiro.getCpf());
				vector.add(engenheiro.getCrea());
				vector.add(engenheiro.getRg());
				vector.add(engenheiro.getDisponibilidade());
				vector.add(engenheiro.getEndereco().getLogradouro());
				vector.add(engenheiro.getEndereco().getNumero());
				vector.add(engenheiro.getEndereco().getBairro());
				vector.add(engenheiro.getEndereco().getCidade());
				vector.add(engenheiro.getEndereco().getEstado());
				vector.add(engenheiro.getEndereco().getCep());
				vector.add(engenheiro.getContato().getEmail());
				vector.add(engenheiro.getContato().getTelefone());
				vector.add(engenheiro.getContato().getCelular());
				tabelaEngenheiro.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmRelatrioEngenheiros, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
