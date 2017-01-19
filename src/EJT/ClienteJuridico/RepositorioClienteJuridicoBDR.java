package EJT.ClienteJuridico;

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

public class RepositorioClienteJuridicoBDR implements IRepositorioClienteJuridico {

	private Connection conectar = null;
	
	
	
	public RepositorioClienteJuridicoBDR() throws Exception {
		this.conectar = Conexao.getConnection(Database.MYSQL);
	}

	@Override
	public void cadastrar(ClienteJuridico clienteJuridico)
			throws CampoObrigatorioException, CNPJInvalidoException,
			ClienteJuridicoJaCadastradoException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		try{
			sql = "insert into cliente_juridico(nome, cnpj, inscricao_estadual, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular)"
					+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, clienteJuridico.getNome());
			stmt.setString(2, clienteJuridico.getCnpj());
			stmt.setString(3, clienteJuridico.getInscricao_estadual());
			stmt.setString(4, clienteJuridico.getEndereco().getLogradouro());
			stmt.setString(5, clienteJuridico.getEndereco().getNumero());
			stmt.setString(6, clienteJuridico.getEndereco().getBairro());
			stmt.setString(7, clienteJuridico.getEndereco().getCidade());
			stmt.setString(8, clienteJuridico.getEndereco().getEstado());
			stmt.setString(9, clienteJuridico.getEndereco().getCep());
			stmt.setString(10, clienteJuridico.getContato().getEmail());
			stmt.setString(11, clienteJuridico.getContato().getTelefone());
			stmt.setString(12, clienteJuridico.getContato().getCelular());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			int clienteId = 0;
			while(rs.next()){
				clienteId = rs.getInt(1);
			}
			clienteJuridico.setId_clienteJuridico(clienteId);
		}finally{
			stmt.close();
		}
		
	}

	@Override
	public void atualizar(ClienteJuridico clienteJuridico) throws CampoObrigatorioException, 
	SQLException, ClienteJuridicoNaoEncontradoException{
		PreparedStatement stmt = null;
		String sql;
		try{
			if(clienteJuridico != null){
				sql = "update cliente_juridico set nome = ?, inscricao_estadual = ?, "
						+ "logradouro = ?, numero = ?,  bairro = ?, cidade = ?, "
						+ "estado = ?, cep = ?, email = ?, telefone = ?, celular = ? "
						+ "where cnpj = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, clienteJuridico.getNome());
				stmt.setString(2, clienteJuridico.getInscricao_estadual());
				stmt.setString(3, clienteJuridico.getEndereco().getLogradouro());
				stmt.setString(4, clienteJuridico.getEndereco().getNumero());
				stmt.setString(5, clienteJuridico.getEndereco().getBairro());
				stmt.setString(6, clienteJuridico.getEndereco().getCidade());
				stmt.setString(7, clienteJuridico.getEndereco().getEstado());
				stmt.setString(8, clienteJuridico.getEndereco().getCep());
				stmt.setString(9, clienteJuridico.getContato().getEmail());
				stmt.setString(10, clienteJuridico.getContato().getTelefone());
				stmt.setString(11, clienteJuridico.getContato().getCelular());
				stmt.setString(12, clienteJuridico.getCnpj());
				Integer resultado = stmt.executeUpdate();	
				if(resultado == 0){
					throw new ClienteJuridicoNaoEncontradoException();
				}
			}
		}finally{
			stmt.close();
		}
		
	}

	@Override
	public void remover(String cnpj) throws CampoObrigatorioException,
			SQLException {
		PreparedStatement stmt = null;
		try{
		String sql = "delete from cliente_juridico where cnpj = ?";
		stmt = this.conectar.prepareStatement(sql);
		stmt.setString(1, cnpj);
		stmt.execute();
		}finally{
			stmt.close();
		}
		
	}

	@Override
	public ClienteJuridico procuarar(String cnpj)
			throws CampoObrigatorioException, SQLException, ClienteJuridicoNaoEncontradoException {
		ClienteJuridico cliente = null;
		String complemento = " and cliente_juridico.cnpj = " + cnpj;
		ArrayList<ClienteJuridico> clientes = this.listar(complemento);
		if(clientes.isEmpty()){
			throw new ClienteJuridicoNaoEncontradoException();
		}
		return clientes.get(0);
	}

	@Override
	public boolean existe(String cnpj) throws CampoObrigatorioException,
			SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String sql = "select count(*) as quantidade from cliente_juridico where cnpj = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cnpj);
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
	public ArrayList<ClienteJuridico> listar() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<ClienteJuridico> clientes = new ArrayList<ClienteJuridico>();
		String sql;
		try{
			sql = "select * from cliente_juridico "
					+ "where id_juridico is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				ClienteJuridico cliente = new ClienteJuridico(rs.getInt("id_juridico"), rs.getString("nome"), rs.getString("cnpj"), rs.getString("inscricao_estadual"), rs.getString("logradouro"), rs.getString("numero"), 
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
	public ArrayList<ClienteJuridico> listar(String complemento)
			throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<ClienteJuridico> clientes = new ArrayList<ClienteJuridico>();
		String sql;
		try{
			sql = "select * from cliente_juridico "
					+ "where id_juridico is not null ";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				ClienteJuridico cliente = new ClienteJuridico(rs.getInt("id_juridico"), rs.getString("nome"), rs.getString("cnpj"), rs.getString("inscricao_estadual"), rs.getString("logradouro"), rs.getString("numero"), 
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
