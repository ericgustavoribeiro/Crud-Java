package EJT.ClienteFisico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Util.Conexao;
import EJT.Util.Database;

public class RepositorioClienteFisicoBDR implements IRepositorioClienteFisico {

	private Connection conectar = null;
	
	
	public RepositorioClienteFisicoBDR() throws Exception {
		this.conectar = Conexao.getConnection(Database.MYSQL);
	}

	@Override
	public void cadastrar(ClienteFisico clienteFisico)
			throws CPFInvalidoException, ClienteJaCadastradoException,
			CampoObrigatorioException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		try{
			sql = "insert into cliente_fisico(nome, cpf, rg, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular)"
					+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, clienteFisico.getNome());
			stmt.setString(2, clienteFisico.getCpf());
			stmt.setString(3, clienteFisico.getRg());
			stmt.setString(4, clienteFisico.getEndereco().getLogradouro());
			stmt.setString(5, clienteFisico.getEndereco().getNumero());
			stmt.setString(6, clienteFisico.getEndereco().getBairro());
			stmt.setString(7, clienteFisico.getEndereco().getCidade());
			stmt.setString(8, clienteFisico.getEndereco().getEstado());
			stmt.setString(9, clienteFisico.getEndereco().getCep());
			stmt.setString(10, clienteFisico.getContato().getEmail());
			stmt.setString(11, clienteFisico.getContato().getTelefone());
			stmt.setString(12, clienteFisico.getContato().getCelular());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			int clienteId = 0;
			while(rs.next()){
				clienteId = rs.getInt(1);
			}
			clienteFisico.setId_clienteFisico(clienteId);
		}finally{
			stmt.close();
		}
		
	}

	@Override
	public void atualizar(ClienteFisico clienteFisico)
			throws ClienteNaoEncontradoException, CampoObrigatorioException,
			SQLException {
		PreparedStatement stmt = null;
		String sql;
		try{
			if(clienteFisico != null){
				sql = "update cliente_fisico set nome = ?, rg = ?, "
						+ "logradouro = ?, numero = ?,  bairro = ?, cidade = ?, "
						+ "estado = ?, cep = ?, email = ?, telefone = ?, celular = ? "
						+ "where cpf = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, clienteFisico.getNome());
				stmt.setString(2, clienteFisico.getRg());
				stmt.setString(3, clienteFisico.getEndereco().getLogradouro());
				stmt.setString(4, clienteFisico.getEndereco().getNumero());
				stmt.setString(5, clienteFisico.getEndereco().getBairro());
				stmt.setString(6, clienteFisico.getEndereco().getCidade());
				stmt.setString(7, clienteFisico.getEndereco().getEstado());
				stmt.setString(8, clienteFisico.getEndereco().getCep());
				stmt.setString(9, clienteFisico.getContato().getEmail());
				stmt.setString(10, clienteFisico.getContato().getTelefone());
				stmt.setString(11, clienteFisico.getContato().getCelular());
				stmt.setString(12, clienteFisico.getCpf());
				Integer resultado = stmt.executeUpdate();
				if(resultado == 0){
					throw new ClienteNaoEncontradoException();
				}
			}
		}finally{
			stmt.close();
		}
		
	}

	@Override
	public void remover(String cpf) throws ClienteNaoEncontradoException,
			CampoObrigatorioException, SQLException {
		PreparedStatement stmt = null;
		try{
		String sql = "delete from cliente_fisico where cpf = ?";
		stmt = this.conectar.prepareStatement(sql);
		stmt.setString(1, cpf);
		stmt.execute();
		}finally{
			stmt.close();
		}
		
	}

	@Override
	public ClienteFisico procurar(String cpf)
			throws ClienteNaoEncontradoException, CampoObrigatorioException,
			SQLException {
		ClienteFisico cliente = null;
		String complemento = " and cliente_fisico.cpf = " + cpf;
		ArrayList<ClienteFisico> clientes = this.listar(complemento);
		if(clientes.isEmpty()){
			throw new ClienteNaoEncontradoException();
		}
		return clientes.get(0);
	}

	@Override
	public boolean existe(String cpf) throws CampoObrigatorioException,
			ClienteNaoEncontradoException, CPFInvalidoException, SQLException {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String sql = "select count(*) as quantidade from cliente_fisico where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt("quantidade") == 0){
				return false;
			}else{
				return true;
			}
		}finally{
			stmt.close();
		}
	}

	@Override
	public ArrayList<ClienteFisico> listar() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<ClienteFisico> clientes = new ArrayList<ClienteFisico>();
		String sql;
		try{
			sql = "select * from cliente_fisico "
					+ "where id_clienteFisico is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				ClienteFisico cliente = new ClienteFisico(rs.getInt("id_clienteFisico"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("logradouro"), rs.getString("numero"), 
						rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), 
						rs.getString("email"), rs.getString("telefone"), rs.getString("celular"));
					
				Endereco endereco = new Endereco();
				Contato contato = new Contato();
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCep(rs.getString("cep"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				
				cliente.setContato(contato);
				cliente.setEndereco(endereco);
				clientes.add(cliente);
			}	
		}finally{
			stmt.close();
		}

		return clientes;
	}

	@Override
	public ArrayList<ClienteFisico> listar(String complemento)
			throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<ClienteFisico> clientes = new ArrayList<ClienteFisico>();
		String sql;
		try{
			sql = "select * from cliente_fisico "
					+ "where id_clienteFisico is not null ";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				ClienteFisico cliente = new ClienteFisico(rs.getInt("id_clienteFisico"), rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("logradouro"), rs.getString("numero"), 
						rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), 
						rs.getString("email"), rs.getString("telefone"), rs.getString("celular"));
					
				Endereco endereco = new Endereco();
				Contato contato = new Contato();
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCep(rs.getString("cep"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				
				cliente.setContato(contato);
				cliente.setEndereco(endereco);
				clientes.add(cliente);
			}	
		}finally{
			stmt.close();
		}

		return clientes;
	}

}
