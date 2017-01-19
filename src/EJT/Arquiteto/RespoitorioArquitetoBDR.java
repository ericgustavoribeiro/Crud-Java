package EJT.Arquiteto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import EJT.Contato.Contato;
import EJT.Endereco.Endereco;
import EJT.Engenheiro.Engenheiro;
import EJT.Engenheiro.EngenheiroNaoEncontradoException;
import EJT.Util.Conexao;
import EJT.Util.Database;

public class RespoitorioArquitetoBDR implements IRepositorioArquiteto {

	private Connection conectar = null;
	   public static final String NOME_TABELA_ARQUITETO = "arquiteto";
	    private PreparedStatement preparedStatement;
	    private Statement statement;
	    private ResultSet resultSet;
	    private int bancoDados = 0;
	    
	 public RespoitorioArquitetoBDR() throws Exception{
		 this.conectar = Conexao.getConnection(Database.MYSQL);
		 
	 }
	 
	 
	 public RespoitorioArquitetoBDR(int bancoDados) throws Exception {
	        this.conectar = Conexao.getConnection(bancoDados);
	        this.bancoDados = bancoDados;
	    }
	 
	@Override
	public void Cadastrar(Arquiteto arquiteto) 
		throws ArquitetoJaCadastradoException, SQLException{
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String sql;
		if(arquiteto !=null){
			try{
			sql="insert into arquiteto(nome, cau, cpf, rg, disponibilidade, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular)" +
					" values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, arquiteto.getNome());
			stmt.setString(2, arquiteto.getCau());
			stmt.setString(3, arquiteto.getCpf());
			stmt.setString(4, arquiteto.getRg());
			stmt.setString(5, arquiteto.getDisponibilidade());
			stmt.setString(6, arquiteto.getEndereco().getLogradouro());
			stmt.setString(7, arquiteto.getEndereco().getNumero());
			stmt.setString(8, arquiteto.getEndereco().getBairro());
			stmt.setString(9, arquiteto.getEndereco().getCidade());
			stmt.setString(10, arquiteto.getEndereco().getEstado());
			stmt.setString(11, arquiteto.getEndereco().getCep());
			stmt.setString(12, arquiteto.getContato().getEmail());
			stmt.setString(13, arquiteto.getContato().getTelefone());
			stmt.setString(14, arquiteto.getContato().getCelular());
			rs = stmt.getGeneratedKeys();
			stmt.execute();
	
			int arquitetoId = 0;
			while(rs.next()){
				arquiteto.getId_arquiteto();
			}
			
		}finally{
			stmt.close();
			rs.close();
		}
		
	}
	}

	@Override
	public Arquiteto procurar(String cpf) throws ArquitetoNaoEncontradoException, SQLException {
	Arquiteto arquiteto = null;
	String complemento = " and arquiteto.cpf = " + cpf;
	ArrayList<Arquiteto> arquitetos = this.listar(complemento);
	if (arquitetos.isEmpty()){
		throw new ArquitetoNaoEncontradoException();
	} 
	return arquitetos.get(0);
		
		
	}


	
	
	public void atualizar(Arquiteto arquiteto)
			throws ArquitetoNaoEncontradoException, SQLException {
		
		PreparedStatement stmt = null;
		try{
			if(arquiteto != null){
			
				String sql = "update arquiteto set nome = ?, cau = ?, rg = ?, disponibilidade = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ?, "
						+ "estado = ?, cep = ?, email = ?, telefone = ?, celular = ?"; 
				sql += " where cpf = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, arquiteto.getNome());
				stmt.setString(2, arquiteto.getCau());
				stmt.setString(3, arquiteto.getRg());
				stmt.setString(4, arquiteto.getDisponibilidade());
				stmt.setString(5, arquiteto.getEndereco().getLogradouro());
				stmt.setString(6, arquiteto.getEndereco().getNumero());
				stmt.setString(7, arquiteto.getEndereco().getBairro());
				stmt.setString(8, arquiteto.getEndereco().getCidade());
				stmt.setString(9, arquiteto.getEndereco().getEstado());
				stmt.setString(10, arquiteto.getEndereco().getCep());
				stmt.setString(11, arquiteto.getContato().getEmail());
				stmt.setString(12, arquiteto.getContato().getTelefone());
				stmt.setString(13, arquiteto.getContato().getCelular());
				stmt.setString(14, arquiteto.getCpf());
				
				
				Integer resultado = stmt.executeUpdate();
				
				if(resultado == 0) throw new ArquitetoNaoEncontradoException();
				
			}
			
		}finally{
			stmt.close();
		}
		
	}
	
	public void remover(String cpf) throws ArquitetoNaoEncontradoException,
	SQLException {
	PreparedStatement stmt = null;
	try{
		String sql ="delete from arquiteto where cpf = ?" ;
		stmt = this.conectar.prepareStatement(sql);
		stmt.setString(1, cpf);
		stmt.execute();
	}finally{
		stmt.close();
	}

}

	public boolean existe(String cpf) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String sql ="select count(*) as quantidade from arquiteto where cpf = ?";
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
	
	
	public ArrayList<Arquiteto> listar() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Arquiteto> arquitetos = new ArrayList<Arquiteto>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from arquiteto";
			sql += " where id_arquiteto is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				
				Arquiteto arquiteto = new Arquiteto(rs.getInt("id_arquiteto"), rs.getString("nome"), rs.getString("cau"), rs.getString("cpf"),
						rs.getString("rg"), rs.getString("disponibilidade"),rs.getString("logradouro"), rs.getString("numero"), 
						rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"));
				
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
				
				arquiteto.setContato(contato);
				arquiteto.setEndereco(endereco);
				arquitetos.add(arquiteto);
				
				
				
				
				
				
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return arquitetos;
	}

	@Override
	public ArrayList<Arquiteto> listar(String complemento) throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Arquiteto> arquitetos = new ArrayList<Arquiteto>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from arquiteto";
			sql += " where id_arquiteto is not null ";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				
				Arquiteto arquiteto = new Arquiteto(rs.getInt("id_arquiteto"), rs.getString("nome"), rs.getString("cau"), rs.getString("cpf"),
						rs.getString("rg"), rs.getString("disponibilidade"),rs.getString("logradouro"), rs.getString("numero"), 
						rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"));
				
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
				
				arquiteto.setContato(contato);
				arquiteto.setEndereco(endereco);
				arquitetos.add(arquiteto);
				
				
				
				
				
			}
		}finally{
			stmt.close();
		
		}
		
		return arquitetos;
	}

	
	
	
	
	
	
	
}
