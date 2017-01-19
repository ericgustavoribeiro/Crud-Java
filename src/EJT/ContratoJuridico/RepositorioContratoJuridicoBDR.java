package EJT.ContratoJuridico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import EJT.Arquiteto.Arquiteto;
import EJT.Atendente.Atendente;
import EJT.ClienteJuridico.ClienteJuridico;
import EJT.Eletricista.Eletricista;
import EJT.Empresa.Empresa;
import EJT.Encanador.Encanador;
import EJT.Engenheiro.Engenheiro;
import EJT.Gerente.Gerente;
import EJT.Jardineiro.Jardineiro;
import EJT.MestredeObras.MestreDeObras;
import EJT.Util.Conexao;
import EJT.Util.Database;

public class RepositorioContratoJuridicoBDR implements
		IRepositorioContratoJuridico {

	private Connection conectar = null;

	public RepositorioContratoJuridicoBDR() throws Exception {
		this.conectar = Conexao.getConnection(Database.MYSQL);
	}

	@Override
	public void cadastrar(ContratoJuridico contratoJuridico)
			throws CampoObrigatorioException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "insert into contratojuridico(id_atendente, id_arquiteto, id_eletricista, id_encanador, id_engenheiro, "
					+ "id_jardineiro, id_mestre, "
					+ "id_gerente, id_juridico, cnpj, descricao)"
					+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			stmt = this.conectar.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, contratoJuridico.getId_atendente());
			stmt.setInt(2, contratoJuridico.getId_arquiteto());
			stmt.setInt(3, contratoJuridico.getId_eletricista());
			stmt.setInt(4, contratoJuridico.getId_encanador());
			stmt.setInt(5, contratoJuridico.getId_engenheiro());
			stmt.setInt(6, contratoJuridico.getId_jardineiro());
			stmt.setInt(7, contratoJuridico.getId_mestre());
			stmt.setInt(8, contratoJuridico.getId_gerente());
			stmt.setInt(9, contratoJuridico.getId_clienteJuridico());
			stmt.setString(10, contratoJuridico.getCnpj());
			stmt.setString(11, contratoJuridico.getDescricao());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			
			int contratoId = 0;
			while (rs.next()) {
				contratoId = rs.getInt(1);
			}
			contratoJuridico.setIdContrato(contratoId);

		} finally {
			stmt.close();
		}

	}

	@Override
	public void atualizar(ContratoJuridico contratoJuridico)
			throws ContratoNaoEncontradoException, SQLException {
		PreparedStatement stmt = null;
		if (contratoJuridico != null) {
			try {
				String sql = "update contratojuridico set descricao = ? "
						+ " where id = ? ";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, contratoJuridico.getDescricao());
				stmt.setInt(2, contratoJuridico.getIdContrato());
				Integer resultado = stmt.executeUpdate();
				if (resultado == 0)
					throw new ContratoNaoEncontradoException();
			} finally {
				stmt.close();
			}
		}

	}

	@Override
	public void remover(int idContrato) throws ContratoNaoEncontradoException,
			SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "delete from contratojuridico where id = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setInt(1, idContrato);
			stmt.execute();

		} finally {
			stmt.close();
		}
	}

	@Override
	public ContratoJuridico procurar(int idContrato)
			throws ContratoNaoEncontradoException, SQLException {
		ContratoJuridico contrato = null;
		String complemento = " and contratojuridico.id = " + idContrato;
		ArrayList<ContratoJuridico> contratos = this.listar(complemento);
		if (contratos.isEmpty())
			throw new ContratoNaoEncontradoException();

		return contratos.get(0);
	}

	@Override
	public ArrayList<ContratoJuridico> listar() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		ArrayList<ContratoJuridico> contratos = new ArrayList<ContratoJuridico>();
		try {
			sql = "select contratojuridico.id as CONTRATO, cliente_juridico.nome as CLIENTE, atendente.nome as ATENDENTE, "
					+ "arquiteto.nome as ARQUITETO, eletricista.nome as ELETRICISTA, encanador.nome as ENCANADOR, "
					+ "engenheiro.nome as ENGENHEIRO, jardineiro.nome as JARDINEIRO, mestre_obras.nome as MESTRE, "
					+ "gerente.nome as GERENTE, empresa.nome_fantasia as EMPRESA, contratojuridico.descricao as DESCRICAO "
					+ "from cliente_juridico, atendente, arquiteto, eletricista, encanador, engenheiro, jardineiro, "
					+ "mestre_obras, gerente, empresa, contratojuridico "
					+ "where contratojuridico.id_juridico = cliente_juridico.id_juridico "
					+ "and contratojuridico.id_atendente = atendente.id_atendente "
					+ "and contratojuridico.id_arquiteto = arquiteto.id_arquiteto "
					+ "and contratojuridico.id_eletricista = eletricista.id_eletricista "
					+ "and contratojuridico.id_encanador = encanador.id_encanador "
					+ "and contratojuridico.id_engenheiro = engenheiro.id_engenheiro "
					+ "and contratojuridico.id_jardineiro = jardineiro.id_jardineiro "
					+ "and contratojuridico.id_mestre = mestre_obras.id_mestre "
					+ "and contratojuridico.id_gerente = gerente.id_gerente "
					+ "and contratojuridico.cnpj = empresa.cnpj ";

			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {

				ContratoJuridico contratoJuridico = new ContratoJuridico(
						rs.getInt("CONTRATO"), rs.getString("CLIENTE"),
						rs.getString("ATENDENTE"), rs.getString("ARQUITETO"),
						rs.getString("ELETRICISTA"), rs.getString("ENCANADOR"),
						rs.getString("ENGENHEIRO"), rs.getString("JARDINEIRO"),
						rs.getString("MESTRE"), rs.getString("GERENTE"),
						rs.getString("EMPRESA"), rs.getString("DESCRICAO"));

				ClienteJuridico cliente = new ClienteJuridico();
				Atendente atendente = new Atendente();
				Arquiteto arquiteto = new Arquiteto();
				Eletricista eletricista = new Eletricista();
				Encanador encanador = new Encanador();
				Engenheiro engenheiro = new Engenheiro();
				Jardineiro jardineiro = new Jardineiro();
				MestreDeObras mestre = new MestreDeObras();
				Gerente gerente = new Gerente();
				Empresa empresa = new Empresa();

				cliente.setNome(rs.getString("CLIENTE"));
				atendente.setNome(rs.getString("ATENDENTE"));
				arquiteto.setNome(rs.getString("ARQUITETO"));
				eletricista.setNome(rs.getString("ELETRICISTA"));
				encanador.setNome(rs.getString("ENCANADOR"));
				engenheiro.setNome(rs.getString("ENGENHEIRO"));
				jardineiro.setNome(rs.getString("JARDINEIRO"));
				mestre.setNome(rs.getString("MESTRE"));
				gerente.setNome(rs.getString("GERENTE"));
				empresa.setNome_fantasia(rs.getString("EMPRESA"));

				contratoJuridico.setAtendente(atendente);
				contratoJuridico.setArquiteto(arquiteto);
				contratoJuridico.setClienteJuridico(cliente);
				contratoJuridico.setEletricista(eletricista);
				contratoJuridico.setEncanador(encanador);
				contratoJuridico.setEngenheiro(engenheiro);
				contratoJuridico.setJardineiro(jardineiro);
				contratoJuridico.setMestreDeObras(mestre);
				contratoJuridico.setGerente(gerente);
				contratoJuridico.setEmpresa(empresa);

				contratos.add(contratoJuridico);
			}

		} finally {
			stmt.close();
			rs.close();
		}

		return contratos;
	}

	@Override
	public ArrayList<ContratoJuridico> listar(String complemento)
			throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		ArrayList<ContratoJuridico> contratos = new ArrayList<ContratoJuridico>();
		try {
			sql = "select contratojuridico.id as CONTRATO, cliente_juridico.nome as CLIENTE, atendente.nome as ATENDENTE, "
					+ "arquiteto.nome as ARQUITETO, eletricista.nome as ELETRICISTA, encanador.nome as ENCANADOR, "
					+ "engenheiro.nome as ENGENHEIRO, jardineiro.nome as JARDINEIRO, mestre_obras.nome as MESTRE, "
					+ "gerente.nome as GERENTE, empresa.nome_fantasia as EMPRESA, contratojuridico.descricao as DESCRICAO "
					+ "from cliente_juridico, atendente, arquiteto, eletricista, encanador, engenheiro, jardineiro, "
					+ "mestre_obras, gerente, empresa, contratojuridico "
					+ "where contratojuridico.id_juridico = cliente_juridico.id_juridico "
					+ "and contratojuridico.id_atendente = atendente.id_atendente "
					+ "and contratojuridico.id_arquiteto = arquiteto.id_arquiteto "
					+ "and contratojuridico.id_eletricista = eletricista.id_eletricista "
					+ "and contratojuridico.id_encanador = encanador.id_encanador "
					+ "and contratojuridico.id_engenheiro = engenheiro.id_engenheiro "
					+ "and contratojuridico.id_jardineiro = jardineiro.id_jardineiro "
					+ "and contratojuridico.id_mestre = mestre_obras.id_mestre "
					+ "and contratojuridico.id_gerente = gerente.id_gerente "
					+ "and contratojuridico.cnpj = empresa.cnpj ";
			sql += complemento;

			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {

				ContratoJuridico contratoJuridico = new ContratoJuridico(
						rs.getInt("CONTRATO"), rs.getString("CLIENTE"),
						rs.getString("ATENDENTE"), rs.getString("ARQUITETO"),
						rs.getString("ELETRICISTA"), rs.getString("ENCANADOR"),
						rs.getString("ENGENHEIRO"), rs.getString("JARDINEIRO"),
						rs.getString("MESTRE"), rs.getString("GERENTE"),
						rs.getString("EMPRESA"), rs.getString("DESCRICAO"));

				ClienteJuridico cliente = new ClienteJuridico();
				Atendente atendente = new Atendente();
				Arquiteto arquiteto = new Arquiteto();
				Eletricista eletricista = new Eletricista();
				Encanador encanador = new Encanador();
				Engenheiro engenheiro = new Engenheiro();
				Jardineiro jardineiro = new Jardineiro();
				MestreDeObras mestre = new MestreDeObras();
				Gerente gerente = new Gerente();
				Empresa empresa = new Empresa();

				cliente.setNome(rs.getString("CLIENTE"));
				atendente.setNome(rs.getString("ATENDENTE"));
				arquiteto.setNome(rs.getString("ARQUITETO"));
				eletricista.setNome(rs.getString("ELETRICISTA"));
				encanador.setNome(rs.getString("ENCANADOR"));
				engenheiro.setNome(rs.getString("ENGENHEIRO"));
				jardineiro.setNome(rs.getString("JARDINEIRO"));
				mestre.setNome(rs.getString("MESTRE"));
				gerente.setNome(rs.getString("GERENTE"));
				empresa.setNome_fantasia(rs.getString("EMPRESA"));

				contratoJuridico.setAtendente(atendente);
				contratoJuridico.setArquiteto(arquiteto);
				contratoJuridico.setClienteJuridico(cliente);
				contratoJuridico.setEletricista(eletricista);
				contratoJuridico.setEncanador(encanador);
				contratoJuridico.setEngenheiro(engenheiro);
				contratoJuridico.setJardineiro(jardineiro);
				contratoJuridico.setMestreDeObras(mestre);
				contratoJuridico.setGerente(gerente);
				contratoJuridico.setEmpresa(empresa);

				contratos.add(contratoJuridico);
			}

		} finally {
			stmt.close();

		}

		return contratos;
	}

}
