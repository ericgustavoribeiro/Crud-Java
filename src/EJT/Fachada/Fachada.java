package EJT.Fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import EJT.Arquiteto.Arquiteto;
import EJT.Arquiteto.ControladorArquiteto;
import EJT.Atendente.Atendente;
import EJT.Atendente.ControladorAtendente;
import EJT.ClienteFisico.CPFInvalidoException;
import EJT.ClienteFisico.CampoObrigatorioException;
import EJT.ClienteFisico.ClienteFisico;
import EJT.ClienteFisico.ClienteNaoEncontradoException;
import EJT.ClienteFisico.ControladorClienteFisico;
import EJT.ClienteJuridico.ClienteJuridico;
import EJT.ClienteJuridico.ControladorClienteJuridico;
import EJT.Contrato.Contrato;
import EJT.Contrato.ContratoNaoEncontradoException;
import EJT.Contrato.ControladorContrato;
import EJT.ContratoJuridico.ContratoJuridico;
import EJT.ContratoJuridico.ControladorContratoJuridico;
import EJT.Eletricista.ControladorEletricista;
import EJT.Eletricista.Eletricista;
import EJT.Empresa.ControladorEmpresa;
import EJT.Empresa.Empresa;
import EJT.Encanador.ControladorEncanador;
import EJT.Encanador.Encanador;
import EJT.Engenheiro.ControladorEngenheiro;
import EJT.Engenheiro.Engenheiro;
import EJT.Gerente.ControladorGerente;
import EJT.Gerente.Gerente;
import EJT.Jardineiro.ControladorJardineiro;
import EJT.Jardineiro.Jardineiro;
import EJT.MestredeObras.ControladorMestreDeObras;
import EJT.MestredeObras.MestreDeObras;
import EJT.Usuario.ControladorUsuario;
import EJT.Usuario.Usuario;

public class Fachada {

private static Fachada instance = null;
	
	
	private Fachada(){}
	
	public static Fachada getInstance(){
		if(Fachada.instance == null){
			Fachada.instance = new Fachada();
		}
		
		return Fachada.instance;
	}
	
	private ControladorEngenheiro controladorEngenheiro;
	private ControladorJardineiro controladorJardineiro;
	private ControladorArquiteto controladorArquiteto;
	private ControladorAtendente controladorAtendente;
	private ControladorEncanador controladorEncanador;
	private ControladorMestreDeObras controladorMestre;
	private ControladorGerente controladorGerente;
	private ControladorEmpresa controladorEmpresa;
	private ControladorEletricista controladorEletricista;
	private ControladorClienteFisico controladorClienteFisico;
	private ControladorClienteJuridico controladorClienteJuridico;
	private ControladorContrato controladorContrato;
	private ControladorContratoJuridico controladorContratoJuridico;
	private ControladorUsuario controladorUsuario;
	
	
	public void usuarioCadastrar(Usuario usuario) throws Exception{
		this.controladorUsuario = new ControladorUsuario();
		this.controladorUsuario.cadastrar(usuario);
	}

	public Usuario usuarioProcurar(String cpf) throws Exception{
		this.controladorUsuario = new ControladorUsuario();
		return this.controladorUsuario.procurar(cpf);
	}
	
	public void usuarioRemover(String cpf) throws Exception{
		this.controladorUsuario = new ControladorUsuario();
		this.controladorUsuario.remover(cpf);
	}
	
	public ArrayList<Usuario> usuarioListar() throws Exception{
		this.controladorUsuario = new ControladorUsuario();
		return this.controladorUsuario.listar();
	}

	public void usuarioAtualizar(Usuario usuario) throws Exception{
		this.controladorUsuario = new ControladorUsuario();
		this.controladorUsuario.atualizar(usuario);
	}
	

	public void contratoCadastrar(Contrato contrato) throws Exception{
		this.controladorContrato = new ControladorContrato();
		this.controladorContrato.cadastrar(contrato);
	}
	
	
	public void engenheiroCadastrar(Engenheiro engenheiro) throws Exception{
		this.controladorEngenheiro = new ControladorEngenheiro();
		this.controladorEngenheiro.cadastrar(engenheiro);
	}
	
	public Engenheiro engenheiroProcurar(String cpf) throws Exception{
		this.controladorEngenheiro = new ControladorEngenheiro();
		return this.controladorEngenheiro.procurar(cpf);
	}
	

	
	public void engenheiroAtualizar(Engenheiro engenheiro) throws Exception{
		this.controladorEngenheiro = new ControladorEngenheiro();
		this.controladorEngenheiro.atualizar(engenheiro);
	}
	
	public void engenheiroRemover(String cpf) throws Exception{
		this.controladorEngenheiro = new ControladorEngenheiro();
		this.controladorEngenheiro.remover(cpf);
	}
	
	public ArrayList<Engenheiro> engenheiroListar() throws Exception{
		this.controladorEngenheiro = new ControladorEngenheiro();
		return this.controladorEngenheiro.listar();
	}

	

		
	
	
	public void arquitetoCadastrar(Arquiteto arquiteto) throws Exception{
		this.controladorArquiteto = new ControladorArquiteto();
		this.controladorArquiteto.cadastrar(arquiteto);
	}
	
	public Arquiteto arquitetoProcurar(String cpf) throws  EJT.Arquiteto.CampoObrigatorioException,Exception{
		this.controladorArquiteto = new ControladorArquiteto();
		return this.controladorArquiteto.procurar(cpf);
	}
	

	
	public ArrayList<Arquiteto> arquitetoListar() throws Exception, SQLException{
		this.controladorArquiteto = new ControladorArquiteto();
		return this.controladorArquiteto.listar();
	}

	public void arquitetoRemover(String cpf) throws Exception{
		this.controladorArquiteto = new ControladorArquiteto();
		this.controladorArquiteto.remover(cpf);
	}
	
	public void arquitetoAtualizar(Arquiteto arquiteto) throws Exception{
		this.controladorArquiteto = new ControladorArquiteto();
		this.controladorArquiteto.atualizar(arquiteto);
	}
	
	
	public void atendenteCadastrar(Atendente atendente) throws Exception{
		this.controladorAtendente = new ControladorAtendente();
		this.controladorAtendente.cadastrar(atendente);
	}
	

	public Atendente atendenteProcurar(String cpf) throws Exception{
		this.controladorAtendente = new ControladorAtendente();
		return this.controladorAtendente.procurar(cpf);
	}

	public void atendenteRemover(String cpf) throws Exception{
		this.controladorAtendente = new ControladorAtendente();
		this.controladorAtendente.remover(cpf);
	}
		
	public void atendenteAtualizar(Atendente atendente) throws Exception{
		this.controladorAtendente = new ControladorAtendente();
		this.controladorAtendente.atualizar(atendente);
	}
	
	public ArrayList<Atendente> atendenteListar() throws Exception{
		this.controladorAtendente = new ControladorAtendente();
		return this.controladorAtendente.listar();
	}
	
	public Gerente gerenteProcurar(String cpf) throws Exception{
		this.controladorGerente = new ControladorGerente();
		return this.controladorGerente.procurar(cpf);
	
	}
	
	public void encanadorCadastrar(Encanador encanador) throws Exception{
		this.controladorEncanador = new ControladorEncanador();
		this.controladorEncanador.cadastrar(encanador);

	}
	
	public Encanador encanadorProcurar(String cpf) throws Exception{
			this.controladorEncanador = new ControladorEncanador();
		return this.controladorEncanador.procurar(cpf);
	}
	
	public void encanadorRemover(String cpf) throws Exception{
		this.controladorEncanador = new ControladorEncanador();
		this.controladorEncanador.remover(cpf);
	}
	
	public void encandadorAtualizar(Encanador encanador) throws Exception{
		this.controladorEncanador = new ControladorEncanador();
		this.controladorEncanador.atualizar(encanador);
	}
	
	public ArrayList<Encanador> encanadorListar() throws Exception{
		this.controladorEncanador = new ControladorEncanador();
		return this.controladorEncanador.listar();
	}

	public void jardineiroCadastrar(Jardineiro jardineiro) throws Exception{
		this.controladorJardineiro = new ControladorJardineiro();
		this.controladorJardineiro.cadastrar(jardineiro);
	}

	
	public void empresaCadastrar(Empresa empresa) throws Exception{
		this.controladorEmpresa = new ControladorEmpresa();
		this.controladorEmpresa.cadastrar(empresa);
	}
	
	public Empresa empresaProcurar(String cnpj) throws Exception{
		this.controladorEmpresa = new ControladorEmpresa();
		return this.controladorEmpresa.procurar(cnpj);
	}
	
	public ArrayList<Empresa> empresaListar() throws Exception{
		this.controladorEmpresa = new ControladorEmpresa();
		return this.controladorEmpresa.listar();
	}
	
	public void empresaRemover(String cnpj) throws Exception{
		this.controladorEmpresa = new ControladorEmpresa();
		this.controladorEmpresa.remover(cnpj);
	}
	
	public void empresaAtualizar(Empresa empresa) throws Exception{
		this.controladorEmpresa = new ControladorEmpresa();
		this.controladorEmpresa.atualizar(empresa);
	}
	
	public boolean empresaExiste() throws Exception{
		this.controladorEmpresa = new ControladorEmpresa();
		return this.controladorEmpresa.existe();
	}
	
	public void eletricistaCadastrar (Eletricista eletricista) throws Exception{
		this.controladorEletricista = new ControladorEletricista();
		this.controladorEletricista.cadastrar(eletricista);
	}
	
	public Eletricista eletricistaProcurar(String cpf) throws Exception{
		this.controladorEletricista = new ControladorEletricista();
		return this.controladorEletricista.procurar(cpf);
	}
	
	public void eletricistaRemover(String cpf) throws Exception{
		this.controladorEletricista = new ControladorEletricista();
		this.controladorEletricista.remover(cpf);
	}
	
	public void eletricistaAtualizar(Eletricista eletricista) throws Exception{
		this.controladorEletricista = new ControladorEletricista();
		this.controladorEletricista.atualizar(eletricista);
	}
	
	public ArrayList<Eletricista> eletricistaListar() throws Exception{
		this.controladorEletricista = new ControladorEletricista();
		return this.controladorEletricista.listar();
	}
	
	public Jardineiro jardineiroProcurar(String cpf) throws Exception{
		this.controladorJardineiro = new ControladorJardineiro();
		return this.controladorJardineiro.procurar(cpf);
	}
	
	public void jardineiroAtualizar(Jardineiro jardineiro) throws Exception{
		this.controladorJardineiro = new ControladorJardineiro();
		this.controladorJardineiro.atualizar(jardineiro);
	}

	public void jardineiroRemover(String cpf) throws Exception{
		this.controladorJardineiro = new ControladorJardineiro();
		this.controladorJardineiro.remover(cpf);
	}

	public ArrayList<Jardineiro> jardineiroListar() throws Exception{
		this.controladorJardineiro = new ControladorJardineiro();
		return this.controladorJardineiro.listar();
	}
	

	public void mestreCadastrar(MestreDeObras mestre_de_obras) throws Exception{
		this.controladorMestre = new ControladorMestreDeObras();
		this.controladorMestre.cadastrar(mestre_de_obras);
	}
	
	public MestreDeObras mestreProcurar(String cpf) throws Exception{
		this.controladorMestre = new ControladorMestreDeObras();
		return this.controladorMestre.procurar(cpf);
	}
	
	public void mestreAtualizar(MestreDeObras mestre_de_obras) throws Exception{
		this.controladorMestre = new ControladorMestreDeObras();
		this.controladorMestre.atualizar(mestre_de_obras);
	}
	
	public void mestreRemover(String cpf) throws Exception{
		this.controladorMestre = new ControladorMestreDeObras();
		this.controladorMestre.remover(cpf);
	}

	public ArrayList<MestreDeObras> mestreListar() throws Exception{
		this.controladorMestre = new ControladorMestreDeObras();
		return this.controladorMestre.listar();
	}
	
	public void gerenteCadastrar(Gerente gerente) throws Exception{
		this.controladorGerente = new ControladorGerente();
		this.controladorGerente.cadastrar(gerente);
	}
	
	public Gerente procurarGerente(String cpf) throws Exception{
		this.controladorGerente = new ControladorGerente();
		return this.controladorGerente.procurar(cpf);
	}

	public void gerenteAtualizar(Gerente gerente) throws Exception{
		this.controladorGerente = new ControladorGerente();
		this.controladorGerente.atualizar(gerente);
	}

	public void gerenteRemover(String cpf) throws Exception{
		this.controladorGerente = new ControladorGerente();
		this.controladorGerente.remover(cpf);
	}
	
	public ArrayList<Gerente> gerenteListar() throws Exception{
		this.controladorGerente = new ControladorGerente();
		return this.controladorGerente.listar();
	}
	
	public void clienteFisicoCadastrar(ClienteFisico clienteFisico) throws Exception{
		this.controladorClienteFisico = new ControladorClienteFisico();
		this.controladorClienteFisico.cadastrar(clienteFisico);
	}
	
	public ClienteFisico clienteFisicoProcurar(String cpf) throws Exception{
		this.controladorClienteFisico = new ControladorClienteFisico();
		return this.controladorClienteFisico.procurar(cpf);
	}
	
	public void clienteFisicoAtualizar(ClienteFisico clienteFisico) throws Throwable{
		this.controladorClienteFisico = new ControladorClienteFisico();
		this.controladorClienteFisico.atualizar(clienteFisico);
	}
	
	public void clienteFisicoRemover(String cpf) throws Exception{
		this.controladorClienteFisico = new ControladorClienteFisico();
		this.controladorClienteFisico.remover(cpf);
	}
	
	public ArrayList<ClienteFisico> clienteFisicoListar() throws Exception{
		this.controladorClienteFisico = new ControladorClienteFisico();
		return this.controladorClienteFisico.listar();
	}

	public void clienteJuridicoCadastrar(ClienteJuridico clienteJuridico) throws Exception{
		this.controladorClienteJuridico = new ControladorClienteJuridico();
		this.controladorClienteJuridico.cadastrar(clienteJuridico);
	}
	
	public ClienteJuridico clienteJuridicoProcurar(String cnpj) throws Exception{
		this.controladorClienteJuridico = new ControladorClienteJuridico();
		return this.controladorClienteJuridico.procurar(cnpj);
	}
	
	public void clienteJuridicoAtualizar(ClienteJuridico clienteJuridico) throws Exception{
		this.controladorClienteJuridico = new ControladorClienteJuridico();
		this.controladorClienteJuridico.atualizar(clienteJuridico);
	}
	
	public void clienteJuridicoRemover(String cnpj) throws Exception{
		this.controladorClienteJuridico = new ControladorClienteJuridico();
		this.controladorClienteJuridico.remover(cnpj);
	}
	
	public ArrayList<ClienteJuridico> clienteJuridicoListar() throws Exception{
		this.controladorClienteJuridico = new ControladorClienteJuridico();
		return this.controladorClienteJuridico.listar();
	}


	public void contratoJuridicoCadastrar(ContratoJuridico contratoJuridico) throws Exception{
		this.controladorContratoJuridico = new ControladorContratoJuridico();
		this.controladorContratoJuridico.cadastrar(contratoJuridico);
	}
	
	public ContratoJuridico contratoJuridicoProcurar(int idContrato) throws Exception{
		this.controladorContratoJuridico = new ControladorContratoJuridico();
		return this.controladorContratoJuridico.procurar(idContrato);
	}
	
	public void contratoJuridicoAtualizar(ContratoJuridico contratoJuridico) throws Exception{
		this.controladorContratoJuridico = new ControladorContratoJuridico();
		this.controladorContratoJuridico.atualizar(contratoJuridico);
	}

	public void contratoJuridicoRemover(int idContrato) throws Exception{
		this.controladorContratoJuridico = new ControladorContratoJuridico();
		this.controladorContratoJuridico.remover(idContrato);
	}

	public ArrayList<ContratoJuridico> contratoJuridicoListar() throws Exception{
		this.controladorContratoJuridico = new ControladorContratoJuridico();
		return this.controladorContratoJuridico.listar();
	}

	public Contrato contratoFisicoProcurar(int idContrato) throws ContratoNaoEncontradoException,Exception{
		this.controladorContrato = new ControladorContrato();
		return this.controladorContrato.procurar(idContrato);
	}
	
	public void contratoFisicoAtualizar(Contrato contrato) throws ContratoNaoEncontradoException, Exception{
		this.controladorContrato = new ControladorContrato();
		this.controladorContrato.atualizar(contrato);
	}

	public void contratoFisicoRemover(int idContrato) throws ContratoNaoEncontradoException, Exception{
		this.controladorContrato = new ControladorContrato();
		this.controladorContrato.remover(idContrato);
	}

	public ArrayList<Contrato> contratoFisicoListar() throws Exception{
		this.controladorContrato = new ControladorContrato();
		return this.controladorContrato.listar();
	}
	
}
