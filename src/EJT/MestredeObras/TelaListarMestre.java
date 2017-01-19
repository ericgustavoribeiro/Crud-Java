package EJT.MestredeObras;
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



public class TelaListarMestre {

	public JFrame frame;
	private JTable tableMestre;
	private Fachada fachada;
	private String[] colunaTabelaMestre;
	private DefaultTableModel tabelaMestre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarMestre window = new TelaListarMestre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarMestre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null); 
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		
		JButton btnNovoCadastro = new JButton("Novo Cadastro");
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroMestredeObras window = new TelaCadastroMestredeObras();
				window.frmCadastroMestredeObras.setVisible(true);
			}
		});
		
		JButton btnBuscar = new JButton("Buscar ");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBuscarMestreDeObras window = new TelaBuscarMestreDeObras();
				window.frmBuscarMestreDeObras.setVisible(true);
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1174, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNovoCadastro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(btnSair)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(btnNovoCadastro)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSair)))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		
		tableMestre = new JTable();
		colunaTabelaMestre = new String[] {"ID", "NOME", "CPF","RG","DISPONIBILIDADE","LOGRADOURO","NUMERO", "BAIRRO", "CIDADE", "ESTADO", "CEP", "EMAIL", "TELEFONE","CELULAR"};
		tabelaMestre = new DefaultTableModel(new Object[][] {},colunaTabelaMestre);
		tableMestre.setModel(tabelaMestre);
		scrollPaneListagemCliente.setViewportView(tableMestre);
		frame.getContentPane().setLayout(groupLayout);
		listarTodosMestre();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosMestre() {
		
		try {
			
			ArrayList<MestreDeObras> listar = Fachada.getInstance().mestreListar();
			
			for(MestreDeObras mestre: listar) {
				Vector vector = new Vector();
				vector.add(mestre.getId_mestre());
				vector.add(mestre.getNome());
				vector.add(mestre.getCpf());
				vector.add(mestre.getRg());
				vector.add(mestre.getDisponibilidade());
				vector.add(mestre.getEndereco().getLogradouro());
				vector.add(mestre.getEndereco().getNumero());
				vector.add(mestre.getEndereco().getBairro());
				vector.add(mestre.getEndereco().getCidade());
				vector.add(mestre.getEndereco().getEstado());
				vector.add(mestre.getEndereco().getCep());
				vector.add(mestre.getContato().getEmail());
				vector.add(mestre.getContato().getTelefone());
				vector.add(mestre.getContato().getCelular());
				tabelaMestre.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
