package EJT.Contrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import EJT.Arquiteto.Arquiteto;
import EJT.Arquiteto.ArquitetoNaoEncontradoException;
import EJT.Arquiteto.IRepositorioArquiteto;
import EJT.Atendente.Atendente;
import EJT.ClienteFisico.ClienteFisico;
import EJT.ClienteJuridico.ClienteJuridico;
import EJT.Contato.Contato;
import EJT.Contrato.ContratoNaoEncontradoException;
import EJT.Eletricista.Eletricista;
import EJT.Empresa.Empresa;
import EJT.Encanador.Encanador;
import EJT.Endereco.Endereco;
import EJT.Engenheiro.Engenheiro;
import EJT.Gerente.Gerente;
import EJT.Jardineiro.Jardineiro;
import EJT.MestredeObras.MestreDeObras;
import EJT.Util.Conexao;
import EJT.Util.Database;

public class RepositorioContratoBDR implements IRepositorioContrato {

	private Connection conectar = null;
	private int database = 0;

	public RepositorioContratoBDR() throws Exception {
		this.conectar = Conexao.getConnection(Database.MYSQL);
	}

	public void cadastrarPF(Contrato contrato) throws SQLException {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if (contrato != null) {
			try {
				//

				sql = "insert into contratofisico(id_atendente, id_arquiteto, id_eletricista, "
						+ "id_encanador, id_engenheiro, "
						+ "id_jardineiro, id_mestre, "
						+ "id_gerente, id_clienteFisico, cnpj, descricao)"
						+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
				stmt = this.conectar.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, contrato.getId_atendente());
				stmt.setInt(2, contrato.getId_arquiteto());
				stmt.setInt(3, contrato.getId_eletricista());
				stmt.setInt(4, contrato.getId_encanador());
				stmt.setInt(5, contrato.getId_engenheiro());
				stmt.setInt(6, contrato.getId_jardineiro());
				stmt.setInt(7, contrato.getId_mestre());
				stmt.setInt(8, contrato.getId_gerente());
				stmt.setInt(9, contrato.getId_clienteFisico());
				stmt.setString(10, contrato.getCnpj());
				stmt.setString(11, contrato.getDescricao());
				// stmt.setInt(1, contrato.getId_gerentente());
				// stmt.setInt(2, contrato.getId_arquiteto());
				// stmt.setInt(3, contrato.getId_eletricista());
				// stmt.setInt(4, contrato.getId_encanador());
				// stmt.setInt(5, contrato.getId_engenheiro());
				// stmt.setInt(6, contrato.getId_jardineiro());
				// stmt.setInt(7, contrato.getId_mestre());
				// stmt.setInt(8, contrato.getId_gerente());
				// stmt.setInt(9, contrato.getId_clienteFisico());
				// stmt.setString(10, contrato.getCpnj());
				// stmt.setString(11, contrato.getDescricao());
				// stmt.setInt(12,
				// contrato.getArquiteto().getEndereco().getCep());
				// stmt.setString(13,
				// contrato.getArquiteto().getContato().getEmail());
				// stmt.setString(14,
				// contrato.getArquiteto().getContato().getTelefone());
				// stmt.setString(15,
				// contrato.getArquiteto().getContato().getCelular());
				stmt.execute();
				rs = stmt.getGeneratedKeys();
				
				int contratoId = 0;
				while (rs.next()) {
					contratoId = rs.getInt(1);
				}
				contrato.setIdContrato(contratoId);
			
			} finally {
				stmt.close();
				rs.close();
			}
		}

	}

	// public void cadastrarPJ(Contrato contrato) throws SQLException{
	// System.out.println("chegou no BDR Contrato");
	// PreparedStatement stmt = null;
	// ResultSet rs = null;
	// String sql;
	// if (contrato != null){
	// try {
	// //
	//
	//
	// sql =
	// "insert into contrato_juridico(id_atendente, id_arquiteto, id_eletricista, id_encanador, id_engenheiro, "
	// + "id_jardineiro, id_mestre, "
	// + "id_gerente, id_clienteJuridico, cnpj, descricao)" +
	// " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	//
	//
	//
	//
	// stmt = this.conectar.prepareStatement(sql,
	// Statement.RETURN_GENERATED_KEYS);
	// stmt.setInt(1, contrato.getAtendente().getId_atendente());
	// stmt.setInt(2, contrato.getArquiteto().getId_arquiteto());
	// stmt.setInt(3, contrato.getEletricista().getId_eletricista());
	// stmt.setInt(4, contrato.getEncanador().getId_encanador());
	// stmt.setInt(5, contrato.getEngenheiro().getId_engenheiro());
	// stmt.setInt(6, contrato.getJardineiro().getId_jardineiro());
	// stmt.setInt(7, contrato.getMestreDeObras().getId_mestre());
	// stmt.setInt(8, contrato.getGerente().getId_gerente());
	// stmt.setInt(9, contrato.getClienteJuridico().getId_juridico());
	// stmt.setString(10, contrato.getEmpresa().getCnpj());
	// stmt.setString(11, contrato.getDescricao());
	// // stmt.setInt(12, contrato.getArquiteto().getEndereco().getCep());
	// // stmt.setString(13, contrato.getArquiteto().getContato().getEmail());
	// // stmt.setString(14,
	// contrato.getArquiteto().getContato().getTelefone());
	// // stmt.setString(15, contrato.getArquiteto().getContato().getCelular());
	// rs = stmt.getGeneratedKeys();
	// stmt.execute();
	// int contratoId = 0;
	// while(rs.next()){
	// contrato.getIdContrato();
	// }
	// contrato.setIdContrato(contratoId);
	// } finally {
	// stmt.close();
	// rs.close();
	// }
	// }
	//
	//
	//
	// }

	public void atualizar(Contrato contrato) throws SQLException, ContratoNaoEncontradoException {
		PreparedStatement stmt = null;
		String sql;
		try {
		if (contrato != null) {
			
				 sql = "update contratofisico set descricao = ? "
						+ " where id = ? ";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, contrato.getDescricao());
				stmt.setInt(2, contrato.getIdContrato());
				Integer resultado = stmt.executeUpdate();
		
		 if(resultado == 0) {
			 throw new ContratoNaoEncontradoException();
		}	 
		}
			} finally {
				stmt.close();
			}
		}

	

	public Contrato contratoProcurar(int idContrato) throws SQLException, ContratoNaoEncontradoException {
		Contrato contrato = null;

		String complemento = " and contratofisico.id = " + idContrato;
		ArrayList<Contrato> contratos = this.listar(complemento);
		if (contratos.isEmpty()) {

		}
		return contratos.get(0);

	}

	public ArrayList<Contrato> listar() throws SQLException, ContratoNaoEncontradoException {
		PreparedStatement stmt = null;
		ArrayList<Contrato> contratos = new ArrayList<Contrato>();
		String sql = "";
		ResultSet rs = null;
		try {
			// sql += "select * from contrato";
			// sql += " where idContrato is not null";
			sql = "select contratofisico.id as contrato, cliente_fisico.nome as cliente, atendente.nome as atendente, "
					+ "arquiteto.nome as arquiteto,eletricista.nome as eletricista, encanador.nome as encanador, "
					+ "engenheiro.nome as engenheiro, jardineiro.nome as jardineiro, mestre_obras.nome as mestre, "
					+ "gerente.nome as gerente, empresa.nome_fantasia as empresa, contratofisico.descricao "
					+ "from cliente_fisico, atendente, arquiteto, eletricista, encanador, engenheiro, jardineiro, "
					+ "mestre_obras, gerente, empresa, contratofisico "
					+ "where contratofisico.id_clienteFisico = cliente_fisico.id_clienteFisico "
					+ "and contratofisico.id_atendente = atendente.id_atendente "
					+ "and contratofisico.id_arquiteto = arquiteto.id_arquiteto "
					+ "and contratofisico.id_eletricista = eletricista.id_eletricista "
					+ "and contratofisico.id_encanador = encanador.id_encanador "
					+ "and contratofisico.id_engenheiro = engenheiro.id_engenheiro "
					+ "and contratofisico.id_jardineiro = jardineiro.id_jardineiro "
					+ "and contratofisico.id_mestre = mestre_obras.id_mestre "
					+ "and contratofisico.id_gerente = gerente.id_gerente "
					+ "and contratofisico.cnpj = empresa.cnpj ";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {

				Contrato contrato = new Contrato(rs.getInt("contrato"),
						rs.getString("CLIENTE"), rs.getString("ATENDENTE"),
						rs.getString("ARQUITETO"), rs.getString("ELETRICISTA"),
						rs.getString("ENCANADOR"), rs.getString("ENGENHEIRO"),
						rs.getString("JARDINEIRO"), rs.getString("MESTRE"),
						rs.getString("GERENTE"), rs.getString("EMPRESA"),
						rs.getString("DESCRICAO"));

				ClienteFisico cliente = new ClienteFisico();
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

				contrato.setAtendente(atendente);
				contrato.setArquiteto(arquiteto);
				contrato.setClienteFisico(cliente);
				contrato.setEletricista(eletricista);
				contrato.setEncanador(encanador);
				contrato.setEngenheiro(engenheiro);
				contrato.setJardineiro(jardineiro);
				contrato.setMestreDeObras(mestre);
				contrato.setGerente(gerente);
				contrato.setEmpresa(empresa);

				contratos.add(contrato);

			}
		} finally {
			stmt.close();
			rs.close();
		}

		return contratos;
	}

	public ArrayList<Contrato> listar(String complemento) throws SQLException, ContratoNaoEncontradoException {
		PreparedStatement stmt = null;

		ArrayList<Contrato> contratos = new ArrayList<Contrato>();
		String sql = "";
		ResultSet rs = null;
		try {
			sql = "select contratofisico.id as contrato, cliente_fisico.nome as cliente, atendente.nome as atendente, "
					+ "arquiteto.nome as arquiteto,eletricista.nome as eletricista, encanador.nome as encanador, "
					+ "engenheiro.nome as engenheiro, jardineiro.nome as jardineiro, mestre_obras.nome as mestre, "
					+ "gerente.nome as gerente, empresa.nome_fantasia as empresa, contratofisico.descricao "
					+ "from cliente_fisico, atendente, arquiteto, eletricista, encanador, engenheiro, jardineiro, "
					+ "mestre_obras, gerente, empresa, contratofisico "
					+ "where contratofisico.id_clienteFisico = cliente_fisico.id_clienteFisico "
					+ "and contratofisico.id_atendente = atendente.id_atendente "
					+ "and contratofisico.id_arquiteto = arquiteto.id_arquiteto "
					+ "and contratofisico.id_eletricista = eletricista.id_eletricista "
					+ "and contratofisico.id_encanador = encanador.id_encanador "
					+ "and contratofisico.id_engenheiro = engenheiro.id_engenheiro "
					+ "and contratofisico.id_jardineiro = jardineiro.id_jardineiro "
					+ "and contratofisico.id_mestre = mestre_obras.id_mestre "
					+ "and contratofisico.id_gerente = gerente.id_gerente "
					+ "and contratofisico.cnpj = empresa.cnpj ";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {

				Contrato contrato = new Contrato(rs.getInt("contrato"),
						rs.getString("CLIENTE"), rs.getString("ATENDENTE"),
						rs.getString("ARQUITETO"), rs.getString("ELETRICISTA"),
						rs.getString("ENCANADOR"), rs.getString("ENGENHEIRO"),
						rs.getString("JARDINEIRO"), rs.getString("MESTRE"),
						rs.getString("GERENTE"), rs.getString("EMPRESA"),
						rs.getString("DESCRICAO"));

				ClienteFisico cliente = new ClienteFisico();
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

				contrato.setAtendente(atendente);
				contrato.setArquiteto(arquiteto);
				contrato.setClienteFisico(cliente);
				contrato.setEletricista(eletricista);
				contrato.setEncanador(encanador);
				contrato.setEngenheiro(engenheiro);
				contrato.setJardineiro(jardineiro);
				contrato.setMestreDeObras(mestre);
				contrato.setGerente(gerente);
				contrato.setEmpresa(empresa);

				contratos.add(contrato);

			}
		} finally {
			stmt.close();
			rs.close();
		}

		return contratos;
	}

	@Override
	public void remover(int idContrato) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "delete from contratofisico where id = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setInt(1, idContrato);
			stmt.execute();

		} finally {
			stmt.close();
		}
	}

}
