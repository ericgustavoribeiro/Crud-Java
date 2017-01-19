package EJT.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import EJT.Contato.Contato;
import EJT.Encanador.Encanador;
import EJT.Endereco.Endereco;
import EJT.Util.Conexao;
import EJT.Util.Database;

public class RepositorioEmpresaBDR implements IRepositorioEmpresa <Empresa, String>{

	private Connection conectar = null;
	
	public RepositorioEmpresaBDR() throws Exception {
		this.conectar = Conexao.getConnection(Database.MYSQL);
	}
	
	public void Cadastrar(Empresa empresa) throws CNPJInvalidoException, CampoObricatorioException, 
	EmpresaJ·CadastradaException, SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if (empresa != null){
			try{
				sql = "insert into empresa(nome_fantasia, cnpj, razao_social, inscricao_estadual, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular) "
						+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, empresa.getNome_fantasia());
				stmt.setString(2, empresa.getCnpj());
				stmt.setString(3, empresa.getRazao_socia());
				stmt.setString(4, empresa.getInscricao_estadual());
				stmt.setString(5, empresa.getEndereco().getLogradouro());
				stmt.setString(6, empresa.getEndereco().getNumero());
				stmt.setString(7, empresa.getEndereco().getBairro());
				stmt.setString(8, empresa.getEndereco().getCidade());
				stmt.setString(9, empresa.getEndereco().getEstado());
				stmt.setString(10, empresa.getEndereco().getCep());
				stmt.setString(11, empresa.getContato().getEmail());
				stmt.setString(12, empresa.getContato().getTelefone());
				stmt.setString(13, empresa.getContato().getCelular());
				rs = stmt.getGeneratedKeys();
				stmt.execute();
				int empresaCnpj = 0;
				while(rs.next()){
					empresa.getCnpj();
				}
				
				
			}finally{
				stmt.close();
				rs.close();
			}
		}
	}
	
	
	public Empresa procurar(String cnpj) throws EmpresaNaoEncontradaException, CampoObricatorioException, SQLException{
		Empresa empresa = null;
		String complemento = " and empresa.cnpj = " + cnpj;
		ArrayList<Empresa> empresas = this.listar(complemento);
		
		if (empresas.isEmpty()){
			throw new EmpresaNaoEncontradaException();
		}		
		return empresas.get(0);
	}
	
	
	public void atualizar(Empresa empresa) throws SQLException, CampoObricatorioException, EmpresaNaoEncontradaException{
		PreparedStatement stmt = null;
		try{
			if(empresa != null) {
				String sql =  "update empresa set nome_fantasia = ?, razao_social = ?, inscricao_estadual = ?, "
						+ "logradouro = ?, numero = ?,  bairro = ?, cidade = ?, estado = ?, "
						+ "cep = ?, email = ?, telefone = ?, celular = ? ";
				sql += "where cnpj = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, empresa.getNome_fantasia());
				stmt.setString(2, empresa.getRazao_socia());
				stmt.setString(3, empresa.getInscricao_estadual());
				stmt.setString(4, empresa.getEndereco().getLogradouro());
				stmt.setString(5, empresa.getEndereco().getNumero());
				stmt.setString(6, empresa.getEndereco().getBairro());
				stmt.setString(7, empresa.getEndereco().getCidade());
				stmt.setString(8, empresa.getEndereco().getEstado());
				stmt.setString(9, empresa.getEndereco().getCep());
				stmt.setString(10, empresa.getContato().getEmail());
				stmt.setString(11, empresa.getContato().getTelefone());
				stmt.setString(12, empresa.getContato().getCelular());
				stmt.setString(13, empresa.getCnpj());
				Integer resultado = stmt.executeUpdate();
				
				if (resultado == 0){
					throw new EmpresaNaoEncontradaException();
				}
			}
			}finally {
				stmt.close();
			}
		}
	
	public void remover(String cnpj) throws EmpresaNaoEncontradaException, SQLException {
		PreparedStatement  stmt =  null;
		try {
			String sql = "delete from empresa where cnpj = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cnpj);
			stmt.execute();
		} finally{
			stmt.close();
		}
	}
	
	public boolean existe(String cnpj) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) as quantidade from empresa where cnpj = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cnpj);
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getInt("quantidade") == 0){
				return false;
			} else {
				return true;
			}
		} finally {
			stmt.close();
		}
	}

	public boolean existe() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) as quantidade from empresa where cnpj";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getInt("quantidade") == 0){
				return false;
			} else {
				return true;
			}
		} finally {
			stmt.close();
		}
	}
	
	public ArrayList<Empresa> listar() throws SQLException{
		PreparedStatement stmt = null;
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		String sql = "";
		ResultSet rs = null;
		try {
			sql += "select * from empresa";
			sql += " where cnpj is not null";
			stmt  = this.conectar.prepareStatement (sql);
			rs = stmt.executeQuery();
			while (rs.next()){
				Empresa empresa = new Empresa(rs.getString("nome_fantasia"),rs.getString("cnpj"), rs.getString("razao_social"),
						rs.getString("inscricao_estadual"), rs.getString("logradouro"), rs.getString("numero"),
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
				
				empresa.setContato(contato);
				empresa.setEndereco(endereco);
				empresas.add(empresa);
			}
		} finally{
			stmt.close();
			rs.close();
		} return empresas;
	}
	
	
	public ArrayList<Empresa> listar(String complemento) throws SQLException{
		PreparedStatement stmt = null;
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		String sql = "";
		ResultSet rs = null;
		try {
			sql += "select * from empresa";
			sql += " where empresa.cnpj is not null";
			sql += complemento;
			stmt  = this.conectar.prepareStatement (sql);
			rs = stmt.executeQuery();
			while (rs.next()){
				Empresa empresa = new Empresa(rs.getString("nome_fantasia"), rs.getString("CNPJ"),
						rs.getString("razao_social"),
						rs.getString("inscricao_estadual"),
						rs.getString("logradouro"), rs.getString("numero"),
						rs.getString("bairro"), rs.getString("cidade"),
						rs.getString("estado"), rs.getString("cep"),
						rs.getString("email"), rs.getString("telefone"),
						rs.getString("celular"));
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
				
				empresa.setContato(contato);
				empresa.setEndereco(endereco);
				empresas.add(empresa);
			}
		} finally{
			stmt.close();

		} return empresas;
	}
	
	
	
	
	
	
	
	
	
	
	
}
