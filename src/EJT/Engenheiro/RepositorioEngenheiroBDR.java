package EJT.Engenheiro;

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

public class RepositorioEngenheiroBDR implements IRepositorioEngenheiro {

	private Connection conectar = null;

	public RepositorioEngenheiroBDR() throws Exception {

		this.conectar = Conexao.getConnection(Database.MYSQL);
	}

	@Override
	public void Cadastrar(Engenheiro engenheiro)
			throws EngenheiroJaCadastradoException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if (engenheiro != null) {
			try {
				sql = "insert into engenheiro(nome, crea, cpf, rg, disponibilidade, logradouro, numero, bairro, cidade, estado, cep, email, telefone, celular) "
						+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = this.conectar.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, engenheiro.getNome());
				stmt.setString(2, engenheiro.getCrea());
				stmt.setString(3, engenheiro.getCpf());
				stmt.setString(4, engenheiro.getRg());
				stmt.setString(5, engenheiro.getDisponibilidade());
				stmt.setString(6, engenheiro.getEndereco().getLogradouro());
				stmt.setString(7, engenheiro.getEndereco().getNumero());
				stmt.setString(8, engenheiro.getEndereco().getBairro());
				stmt.setString(9, engenheiro.getEndereco().getCidade());
				stmt.setString(10, engenheiro.getEndereco().getEstado());
				stmt.setString(11, engenheiro.getEndereco().getCep());
				stmt.setString(12, engenheiro.getContato().getEmail());
				stmt.setString(13, engenheiro.getContato().getTelefone());
				stmt.setString(14, engenheiro.getContato().getCelular());
				rs = stmt.getGeneratedKeys();
				stmt.execute();
				int engenheiroId = 0;
				while (rs.next()) {
					engenheiro.getId_engenheiro();
				}

			} finally {
				stmt.close();
				rs.close();
			}

		}
	}

	@Override
	public Engenheiro procurar(String cpf)
			throws EngenheiroNaoEncontradoException, SQLException {
		Engenheiro engenheiro = null;
		String complemento = " and engenheiro.cpf = " + cpf;
		ArrayList<Engenheiro> engenheiros = this.listar(complemento);
		if (engenheiros.isEmpty()) {
			throw new EngenheiroNaoEncontradoException();
		}
		return engenheiros.get(0);
	}

	@Override
	public void atualizar(Engenheiro engenheiro)
			throws EngenheiroNaoEncontradoException, SQLException {
		PreparedStatement stmt = null;
		try {
			if (engenheiro != null) {
				String sql = "update engenheiro set nome = ?, crea = ?, rg = ?, disponibilidade = ?, "
						+ "logradouro = ?, numero = ?,  bairro = ?, cidade = ?, estado = ?, "
						+ "cep = ?, email = ?, telefone = ?, celular = ?";
				sql += " where cpf = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, engenheiro.getNome());
				stmt.setString(2, engenheiro.getCrea());
				stmt.setString(3, engenheiro.getRg());
				stmt.setString(4, engenheiro.getDisponibilidade());
				stmt.setString(5, engenheiro.getEndereco().getLogradouro());
				stmt.setString(6, engenheiro.getEndereco().getNumero());
				stmt.setString(7, engenheiro.getEndereco().getBairro());
				stmt.setString(8, engenheiro.getEndereco().getCidade());
				stmt.setString(9, engenheiro.getEndereco().getEstado());
				stmt.setString(10, engenheiro.getEndereco().getCep());
				stmt.setString(11, engenheiro.getContato().getEmail());
				stmt.setString(12, engenheiro.getContato().getTelefone());
				stmt.setString(13, engenheiro.getContato().getCelular());
				stmt.setString(14, engenheiro.getCpf());

				Integer resultado = stmt.executeUpdate();
				if (resultado == 0) {
					throw new EngenheiroNaoEncontradoException();
				}
			}

		} finally {
			stmt.close();
		}

	}

	@Override
	public void remover(String cpf) throws EngenheiroNaoEncontradoException,
			SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "delete from engenheiro where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
		} finally {
			stmt.close();
		}

	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) as quantidade from engenheiro where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getInt("quantidade") == 0) {
				return false;
			} else {
				return true;
			}
		} finally {
			stmt.close();
		}

	}

	@Override
	public ArrayList<Engenheiro> listar() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Engenheiro> engenheiros = new ArrayList<Engenheiro>();
		String sql = "";
		ResultSet rs = null;
		try {
			sql += "select * from engenheiro";
			sql += " where id_engenheiro is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Engenheiro engenheiro = new Engenheiro(
						rs.getInt("id_engenheiro"), rs.getString("nome"),
						rs.getString("crea"), rs.getString("cpf"),
						rs.getString("rg"), rs.getString("disponibilidade"),
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

				engenheiro.setContato(contato);
				engenheiro.setEndereco(endereco);
				engenheiros.add(engenheiro);
			}
		} finally {
			stmt.close();
			rs.close();
		}

		return engenheiros;
	}

	@Override
	public ArrayList<Engenheiro> listar(String complemento) throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Engenheiro> engenheiros = new ArrayList<Engenheiro>();
		String sql = "";
		ResultSet rs = null;
		try {
			sql += "select * from engenheiro";
			sql += " where engenheiro.id_engenheiro is not null";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Engenheiro engenheiro = new Engenheiro(
						rs.getInt("id_engenheiro"), rs.getString("nome"),
						rs.getString("crea"), rs.getString("cpf"),
						rs.getString("rg"), rs.getString("disponibilidade"),
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

				engenheiro.setContato(contato);
				engenheiro.setEndereco(endereco);
				engenheiros.add(engenheiro);
			}
		} finally {
			stmt.close();
		}

		return engenheiros;
	}

}
