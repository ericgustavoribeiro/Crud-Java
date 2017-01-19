package EJT.Eletricista;

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
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Window.Type;

public class TelaListarEletricista {

	public JFrame frmRelatrioEletricista;
	private JTable tableEletricista;
	private Fachada fachada;
	private String[] colunaTabelaEletricista;
	private DefaultTableModel tabelaEletricista;
	private JButton btnNovoEletricista;
	private JButton btnBuscarEletricista;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarEletricista window = new TelaListarEletricista();
					window.frmRelatrioEletricista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarEletricista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRelatrioEletricista = new JFrame();
		frmRelatrioEletricista.setType(Type.UTILITY);
		frmRelatrioEletricista.getContentPane().setBackground(SystemColor.window);
		frmRelatrioEletricista.setTitle("Relat\u00F3rio Eletricista");
		frmRelatrioEletricista.setBounds(100, 100, 628, 460);
		frmRelatrioEletricista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRelatrioEletricista.setExtendedState(frmRelatrioEletricista.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2));
		
		btnNovoEletricista = new JButton("Novo Eletricista");
		btnNovoEletricista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroEletricista window = new TelaCadastroEletricista();
				window.frmCadastroEletricista.setVisible(true);
			}
		});
		
		btnBuscarEletricista = new JButton("Buscar Eletricista");
		btnBuscarEletricista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarEletricista window = new TelaBuscarEletricista();
				window.frmBuscarEletricista.setVisible(true);
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRelatrioEletricista.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmRelatrioEletricista.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1202, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNovoEletricista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBuscarEletricista)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(btnSair)))
					.addGap(29))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(btnNovoEletricista)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscarEletricista)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSair)))
					.addContainerGap())
		);
		
		tableEletricista = new JTable();
		colunaTabelaEletricista = new String[] {"ID", "NOME", "CPF","RG", "DISPONIBILIDADE", "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "ESTADO", "CEP", "EMAIL", "TELEFONE","CELULAR"};
		tabelaEletricista = new DefaultTableModel(new Object[][] {},colunaTabelaEletricista);
		tableEletricista.setModel(tabelaEletricista);
		scrollPaneListagemCliente.setViewportView(tableEletricista);
		frmRelatrioEletricista.getContentPane().setLayout(groupLayout);
		listarTodosEletricista();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosEletricista() {
		
		try {
			
			ArrayList<Eletricista> listar = Fachada.getInstance().eletricistaListar();
			
			for(Eletricista eletricista: listar) {
				Vector vector = new Vector();
				vector.add(eletricista.getId_eletricista());
				vector.add(eletricista.getNome());
				vector.add(eletricista.getCpf());
				vector.add(eletricista.getRg());
				vector.add(eletricista.getDisponibilidade());
				vector.add(eletricista.getEndereco().getLogradouro());
				vector.add(eletricista.getEndereco().getNumero());
				vector.add(eletricista.getEndereco().getBairro());
				vector.add(eletricista.getEndereco().getCidade());
				vector.add(eletricista.getEndereco().getEstado());
				vector.add(eletricista.getEndereco().getCep());
				vector.add(eletricista.getContato().getEmail());
				vector.add(eletricista.getContato().getTelefone());
				vector.add(eletricista.getContato().getCelular());
				tabelaEletricista.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmRelatrioEletricista, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
