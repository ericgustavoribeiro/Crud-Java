package EJT.Contrato;

import java.sql.SQLException;



import java.util.ArrayList;

import EJT.Arquiteto.RespoitorioArquitetoBDR;
import EJT.Arquiteto.ArquitetoJaCadastradoException;
import EJT.Arquiteto.ArquitetoNaoEncontradoException;
import EJT.Arquiteto.IRepositorioArquiteto;
import EJT.Atendente.Atendente;
import EJT.Atendente.IRepositorioAtendente;
import EJT.Atendente.RepositorioAtendenteBDR;
import EJT.ClienteFisico.IRepositorioClienteFisico;
import EJT.ClienteFisico.RepositorioClienteFisicoBDR;
import EJT.ClienteJuridico.IRepositorioClienteJuridico;
import EJT.ClienteJuridico.RepositorioClienteJuridicoBDR;
import EJT.Contrato.ContratoNaoEncontradoException;
import EJT.Eletricista.IRepositorioEletricista;
import EJT.Eletricista.RepositorioEletricistaBDR;
import EJT.Empresa.Empresa;
import EJT.Empresa.IRepositorioEmpresa;
import EJT.Empresa.RepositorioEmpresaBDR;
import EJT.Encanador.IRepositorioEncanador;
import EJT.Encanador.RepositorioEncanadorBDR;
import EJT.Engenheiro.CPFInvalidoException;
import EJT.Engenheiro.IRepositorioEngenheiro;
import EJT.Engenheiro.RepositorioEngenheiroBDR;
import EJT.Gerente.IRepositorioGerente;
import EJT.Jardineiro.IRepositorioJardineiro;
import EJT.Jardineiro.RepositorioJardineiroBDR;
import EJT.MestredeObras.IRepositorioMestreDeObras;
import EJT.MestredeObras.RepositorioMestreDeObrasBDR;
import EJT.Util.Database;
import EJT.Util.Validacao;

public class ControladorContrato {

	
	IRepositorioArquiteto repositorioArquiteto;
	IRepositorioAtendente repositorioAtendente;
	IRepositorioClienteFisico repositorioClienteFisico;
	IRepositorioClienteJuridico repositorioClienteJuridico;
	IRepositorioEletricista repositorioEletricista;
	IRepositorioEmpresa repositorioEmpresa;
	IRepositorioEncanador repositorioEncanador;
	IRepositorioEngenheiro repositorioEngenheiro;
	IRepositorioGerente repositorioGerente;
	IRepositorioJardineiro repositorioJardineiro;
	IRepositorioMestreDeObras repositorioMestreDeObras;
	IRepositorioContrato repositorioContrato;
	
	
	
	public ControladorContrato() throws Exception{
		this.repositorioContrato = new RepositorioContratoBDR();
		this.repositorioArquiteto = new RespoitorioArquitetoBDR();
		this.repositorioAtendente = new RepositorioAtendenteBDR();
		this.repositorioClienteFisico = new RepositorioClienteFisicoBDR();
		this.repositorioClienteJuridico = new RepositorioClienteJuridicoBDR();
		this.repositorioEletricista = new RepositorioEletricistaBDR();
		this.repositorioEmpresa = new RepositorioEmpresaBDR();
		this.repositorioEncanador = new RepositorioEncanadorBDR();
		this.repositorioEngenheiro = new RepositorioEngenheiroBDR();
		this.repositorioJardineiro = new RepositorioJardineiroBDR();
		this.repositorioMestreDeObras = new RepositorioMestreDeObrasBDR();
		
		
	}
	
	
	public void cadastrar (Contrato contrato) throws SQLException{
		
		this.repositorioContrato.cadastrarPF(contrato);
	}
	
	public void remover(int idContrato) throws SQLException{
		this.repositorioContrato.remover(idContrato);
	}
	
	public void atualizar(Contrato contrato) throws SQLException, ContratoNaoEncontradoException{
		this.repositorioContrato.atualizar(contrato);
	}
	
	public Contrato procurar(int idContrato) throws SQLException, ContratoNaoEncontradoException{
		return this.repositorioContrato.contratoProcurar(idContrato);
	}

	public ArrayList<Contrato> listar() throws SQLException, ContratoNaoEncontradoException{
		return this.repositorioContrato.listar();
	}
}
