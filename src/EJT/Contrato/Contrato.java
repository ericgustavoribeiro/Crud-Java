package EJT.Contrato;

import EJT.Arquiteto.Arquiteto;
import EJT.Atendente.Atendente;
import EJT.ClienteFisico.ClienteFisico;
import EJT.ClienteJuridico.ClienteJuridico;
import EJT.Contato.Contato;
import EJT.Eletricista.Eletricista;
import EJT.Empresa.Empresa;
import EJT.Encanador.Encanador;
import EJT.Endereco.Endereco;
import EJT.Engenheiro.Engenheiro;
import EJT.Gerente.Gerente;
import EJT.Jardineiro.Jardineiro;
import EJT.MestredeObras.MestreDeObras;

public class Contrato {

	// private int idContrato;
	// private int atendente;
	// private int arquiteto;
	// private int clienteFisico;
	// private ClienteJuridico clienteJuridico;
	// private int eletricista;
	// private Empresa empresa;
	// private Encanador encanador;
	// private Engenheiro engenheiro;
	// private Gerente gerente;
	// private Jardineiro jardineiro;
	// private MestreDeObras mestreDeObras;
	// private String descricao;

	// testando

	private int idContrato;
	private int id_arquiteto;
	private int id_atendente;
	private int id_clienteFisico;
	private int id_eletricista;
	private int id_encanador;
	private int id_engenheiro;
	private int id_gerente;
	private int id_jardineiro;
	private int id_mestre;
	private String cnpj;
	private String descricao;

	private Atendente atendente;
	private Arquiteto arquiteto;
	private ClienteFisico clienteFisico;
	private Eletricista eletricista;
	private Empresa empresa;
	private Encanador encanador;
	private Engenheiro engenheiro;
	private Gerente gerente;
	private Jardineiro jardineiro;
	private MestreDeObras mestreDeObras;

	public Contrato(int idContrato, String cliente, String atendente,
			String arquiteto, String eletricista, String encanador,
			String engenheiro, String jardineiro, String mestre_obras,
			String gerente, String empresa, String descricao) {
		this.idContrato = idContrato;
		cliente = cliente;
		atendente = atendente;
		arquiteto = arquiteto;
		eletricista = eletricista;
		encanador = encanador;
		engenheiro = engenheiro;
		jardineiro = jardineiro;
		mestre_obras = mestre_obras;
		gerente = gerente;
		empresa = empresa;
		this.descricao = descricao;

	}

	public Contrato(int id_arquiteto, int id_atendente, int id_clienteFisico,
			int id_eletricista, int id_encanador, int id_engenheiro,
			int id_gerente, int id_jardineiro, int id_mestre, String cnpj,
			String descricao) {
		this.id_arquiteto = id_arquiteto;
		this.id_atendente = id_atendente;
		this.id_clienteFisico = id_clienteFisico;
		this.id_eletricista = id_eletricista;
		this.id_encanador = id_encanador;
		this.id_engenheiro = id_engenheiro;
		this.id_gerente = id_gerente;
		this.id_jardineiro = id_jardineiro;
		this.id_mestre = id_mestre;
		this.cnpj = cnpj;
		this.descricao = descricao;

	}

	public int getId_arquiteto() {
		return id_arquiteto;
	}

	public void setId_arquiteto(int id_arquiteto) {
		this.id_arquiteto = id_arquiteto;
	}

	public int getId_atendente() {
		return id_atendente;
	}

	public void setId_atendente(int id_atendente) {
		this.id_atendente = id_atendente;
	}

	public int getId_clienteFisico() {
		return id_clienteFisico;
	}

	public void setId_clienteFisico(int id_clienteFisico) {
		this.id_clienteFisico = id_clienteFisico;
	}

	public int getId_eletricista() {
		return id_eletricista;
	}

	public void setId_eletricista(int id_eletricista) {
		this.id_eletricista = id_eletricista;
	}

	public int getId_encanador() {
		return id_encanador;
	}

	public void setId_encanador(int id_encanador) {
		this.id_encanador = id_encanador;
	}

	public int getId_engenheiro() {
		return id_engenheiro;
	}

	public void setId_engenheiro(int id_engenheiro) {
		this.id_engenheiro = id_engenheiro;
	}

	public int getId_gerente() {
		return id_gerente;
	}

	public void setId_gerente(int id_gerente) {
		this.id_gerente = id_gerente;
	}

	public int getId_jardineiro() {
		return id_jardineiro;
	}

	public void setId_jardineiro(int id_jardineiro) {
		this.id_jardineiro = id_jardineiro;
	}

	public int getId_mestre() {
		return id_mestre;
	}

	public void setId_mestre(int id_mestre) {
		this.id_mestre = id_mestre;
	}

	public Contrato(int idContrato, String descricao) {
		this.idContrato = idContrato;
		this.descricao = descricao;
	}

	public Contrato(int id_engenheiro, int id_clienteFisico, int id_arquiteto,
			int id_atendente, String descricao, int id_eletricista,
			int id_gerente, int id_jardineiro, int id_mestre, String cnpj,
			int id_encanador) {
	}

	public Contrato(String descricao) {
		this.descricao = descricao;
	}

	public Contrato() {
		// TODO Auto-generated constructor stub
	}

	public int getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCpnj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Arquiteto getArquiteto() {
		return arquiteto;
	}

	public void setArquiteto(Arquiteto arquiteto) {
		this.arquiteto = arquiteto;
	}

	public ClienteFisico getClienteFisico() {
		return clienteFisico;
	}

	public void setClienteFisico(ClienteFisico clienteFisico) {
		this.clienteFisico = clienteFisico;
	}

	public Eletricista getEletricista() {
		return eletricista;
	}

	public void setEletricista(Eletricista eletricista) {
		this.eletricista = eletricista;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Encanador getEncanador() {
		return encanador;
	}

	public void setEncanador(Encanador encanador) {
		this.encanador = encanador;
	}

	public Engenheiro getEngenheiro() {
		return engenheiro;
	}

	public void setEngenheiro(Engenheiro engenheiro) {
		this.engenheiro = engenheiro;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Jardineiro getJardineiro() {
		return jardineiro;
	}

	public void setJardineiro(Jardineiro jardineiro) {
		this.jardineiro = jardineiro;
	}

	public MestreDeObras getMestreDeObras() {
		return mestreDeObras;
	}

	public void setMestreDeObras(MestreDeObras mestreDeObras) {
		this.mestreDeObras = mestreDeObras;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Contrato [descricao=" + descricao + ", atendente=" + atendente
				+ ", arquiteto=" + arquiteto + ", clienteFisico="
				+ clienteFisico + ", eletricista=" + eletricista + ", empresa="
				+ empresa + ", encanador=" + encanador + ", engenheiro="
				+ engenheiro + ", gerente=" + gerente + ", jardineiro="
				+ jardineiro + ", mestreDeObras=" + mestreDeObras + "]";
	}

	

}