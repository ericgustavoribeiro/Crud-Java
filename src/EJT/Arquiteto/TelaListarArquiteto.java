package EJT.Arquiteto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;

import EJT.Fachada.Fachada;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class TelaListarArquiteto {

	public JFrame frmArquitetos;
	private JTable tableArquiteto;
	private Fachada fachada;
	private String[] colunaTabelaArquiteto;
	private DefaultTableModel tabelaArquiteto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarArquiteto window = new TelaListarArquiteto();
					window.frmArquitetos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarArquiteto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmArquitetos = new JFrame();
		frmArquitetos.setType(Type.UTILITY);
		frmArquitetos.getContentPane().setBackground(Color.WHITE);
		frmArquitetos.setTitle("ARQUITETOS");
		frmArquitetos.setBounds(100, 100, 628, 460);
		frmArquitetos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//copia isso
		frmArquitetos.setExtendedState(frmArquitetos.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		JButton btnNovoArquiteto = new JButton("Novo Arquiteto");
		btnNovoArquiteto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastroArquiteto window = new TelaCadastroArquiteto();
				window.frmCadastroArquiteto.setVisible(true);
			}
		});
		
		JButton btnBuscarArquiteto = new JButton("Buscar Arquiteto");
		btnBuscarArquiteto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBuscarArquiteto window = new TelaBuscarArquiteto();
				window.frmBuscarArquiteto.setVisible(true);
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmArquitetos.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmArquitetos.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1169, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnBuscarArquiteto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNovoArquiteto, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(btnSair)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNovoArquiteto)
							.addGap(9)
							.addComponent(btnBuscarArquiteto)
							.addGap(13)
							.addComponent(btnSair)))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		
		tableArquiteto = new JTable();
		colunaTabelaArquiteto = new String[] {"ID", "NOME", "CPF", "CAU", "RG", "DISPONIBILIDADE", "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "ESTADO", "CEP", "EMAIL", "TELEFONE","CELULAR"};
		tabelaArquiteto = new DefaultTableModel(new Object[][] {},colunaTabelaArquiteto);
		tableArquiteto.setModel(tabelaArquiteto);
		scrollPaneListagemCliente.setViewportView(tableArquiteto);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frmArquitetos.getContentPane().setLayout(groupLayout);
		
		
		listarTodosArquiteto();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosArquiteto() {
		
		try {
			ArrayList<Arquiteto> listar = Fachada.getInstance().arquitetoListar();
			for(Arquiteto arquiteto: listar) {
				Vector vector = new Vector();
				vector.add(arquiteto.getId_arquiteto());
				vector.add(arquiteto.getNome());
				vector.add(arquiteto.getCau());
				vector.add(arquiteto.getCpf());
				vector.add(arquiteto.getDisponibilidade());
				vector.add(arquiteto.getRg());
				vector.add(arquiteto.getEndereco().getLogradouro());
				vector.add(arquiteto.getEndereco().getNumero());
				vector.add(arquiteto.getEndereco().getBairro());
				vector.add(arquiteto.getEndereco().getCidade());
				vector.add(arquiteto.getEndereco().getEstado());
				vector.add(arquiteto.getEndereco().getCep());
				vector.add(arquiteto.getContato().getEmail());
				vector.add(arquiteto.getContato().getTelefone());
				vector.add(arquiteto.getContato().getCelular());
				tabelaArquiteto.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmArquitetos, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
	