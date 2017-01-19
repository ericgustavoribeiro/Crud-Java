package EJT.Atendente;

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
import java.awt.Window.Type;

public class TelaListarAtendentes {

	public JFrame frmAtendentes;
	private JTable tableAtendente;
	private Fachada fachada;
	private String[] colunaTabelaAtendente;
	private DefaultTableModel tabelaAtendente;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnSair;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarAtendentes window = new TelaListarAtendentes();
					window.frmAtendentes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarAtendentes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAtendentes = new JFrame();
		frmAtendentes.setType(Type.UTILITY);
		frmAtendentes.getContentPane().setBackground(Color.WHITE);
		frmAtendentes.setTitle("ATENDENTES");
		frmAtendentes.setBounds(100, 100, 628, 460);
		frmAtendentes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAtendentes.setExtendedState(frmAtendentes.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		btnNewButton = new JButton("Novo Cadastro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAtendente window = new TelaCadastroAtendente();
				window.frmCadastroAtendente.setVisible(true);
			}
		});
		
		btnNewButton_1 = new JButton("Buscar Atendente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarAtendente window = new TelaBuscarAtendente();
				window.frmBuscarAtendente.setVisible(true);
				
				
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAtendentes.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmAtendentes.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1158, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair)
							.addGap(63))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneListagemCliente, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(btnSair)))
					.addContainerGap())
		);
		
		tableAtendente = new JTable();
		colunaTabelaAtendente = new String[] {"ID", "NOME", "CPF","RG","LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "ESTADO", "CEP", "EMAIL", "TELEFONE","CELULAR"};
		tabelaAtendente = new DefaultTableModel(new Object[][] {},colunaTabelaAtendente);
		tableAtendente.setModel(tabelaAtendente);
		scrollPaneListagemCliente.setViewportView(tableAtendente);
		frmAtendentes.getContentPane().setLayout(groupLayout);
		listarTodosAtendentes();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosAtendentes() {
		
		try {
			ArrayList<Atendente> listar = Fachada.getInstance().atendenteListar();
			for(Atendente atendente: listar) {
				Vector vector = new Vector();
				vector.add(atendente.getId_atendente());
				vector.add(atendente.getNome());
				vector.add(atendente.getCpf());
				vector.add(atendente.getRg());
				vector.add(atendente.getEndereco().getLogradouro());
				vector.add(atendente.getEndereco().getNumero());
				vector.add(atendente.getEndereco().getBairro());
				vector.add(atendente.getEndereco().getCidade());
				vector.add(atendente.getEndereco().getEstado());
				vector.add(atendente.getEndereco().getCep());
				vector.add(atendente.getContato().getEmail());
				vector.add(atendente.getContato().getTelefone());
				vector.add(atendente.getContato().getCelular());
				tabelaAtendente.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmAtendentes, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
