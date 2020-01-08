
package br.com.intraPRO.negocio;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.util.DataUtil;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.AnexoTO;
import br.com.intraPRO.modelo.FracaoAnexoTO;
import br.com.intraPRO.persistencia.AnexoDAO;

import br.com.intraPRO.util.Fragmentador;


import com.ibatis.dao.client.DaoManager;


public class AnexoBO {

	private static Log log = LogFactory.getLog(AnexoBO.class);
	//private double valorMaior = 0.0;
	public AnexoBO() {
	}

	public void incluir(AnexoTO anexoTO) throws ExceptionNegocioPRO {

		DaoManager daoManager = FabricaDAO.getDaoManager();
		AnexoDAO anexoDAO = (AnexoDAO) daoManager.getDao(AnexoDAO.class);
		boolean confirmaInclusaoAnexo;
		FracaoAnexoBO fracaoAnexoBO = new FracaoAnexoBO();
		
		try {
			HashMap pedacos = new HashMap();
			if (anexoTO.getArquivo() != null){
				pedacos = Fragmentador.fragmentarArquivo(anexoTO.getArquivo().getInputStream());
			}else if (anexoTO.getByteAnexo() != null){
				
				
				ByteArrayInputStream g = new ByteArrayInputStream(anexoTO.getByteAnexo());
				pedacos = Fragmentador.fragmentarArquivo(g);
			}

			if (anexoTO.getArquivo() != null){
				anexoTO.setNome(anexoTO.getArquivo().getFileName());	
				anexoTO.setQuantByteAnexo(anexoTO.getArquivo().getFileSize());
				//Define na TO o conteudo do arquivo a ser anexado
				anexoTO.setTextoTipoConteudo(anexoTO.getArquivo().getContentType());
			}else{
				anexoTO.setNome(anexoTO.getNome());	
				anexoTO.setQuantByteAnexo(anexoTO.getQuantByteAnexo());				
			}
			anexoTO.setQuantFracaoAnexo(pedacos.size());// Seta no TO a quantidade de fraçoes do arquivo anexo
			anexoTO.setNumeroSequencialArquivo(anexoDAO.consultarMax(anexoTO));// Define o número sequencial do arquivo anexado			
			DataUtil dtUtil = new DataUtil();//Define na variável o timestamp atual
			Timestamp timestampAtual = dtUtil.getTimestampAtual();
			anexoTO.setTsCriacaoAnexo(timestampAtual);
			daoManager.startTransaction();
			confirmaInclusaoAnexo = anexoDAO.incluir(anexoTO);// Faz a inclusão dos dados referentes ao arquivo a ser anexado.

			if (confirmaInclusaoAnexo) {
				fracaoAnexoBO.incluirFragmentos(anexoTO, pedacos);// inclui os fragmentos do arquivo selecionado pelo usuário
			}
			daoManager.commitTransaction();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}

	public AnexoTO consultarUm(AnexoTO anexoTO) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		AnexoDAO anexoDAO = (AnexoDAO) daoManager.getDao(AnexoDAO.class);
		AnexoTO anexoTORetorno = new AnexoTO();
		try {
			daoManager.startTransaction();
				anexoTORetorno = anexoDAO.consultarUm(anexoTO);
			return anexoTORetorno;
		} catch (ExceptionNegocioPRO e) {
			log.error("pro.anexo.erro.buscarDados");
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}

	public void excluir(AnexoTO anexoTO) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			AnexoDAO anexoDAO = (AnexoDAO) daoManager.getDao(AnexoDAO.class);
			daoManager.startTransaction();
			anexoDAO.excluir(anexoTO);
			FracaoAnexoBO fracaoAnexoBO = new FracaoAnexoBO();
			FracaoAnexoTO fracaoAnexoTO = new FracaoAnexoTO();
			fracaoAnexoTO.setAnoCriacao(anexoTO.getAnoCriacao());
			fracaoAnexoTO.setNumeroSequencialTarefa(anexoTO.getNumeroSequencialTarefa());
			fracaoAnexoTO.setNumeroSequencialArquivoAnexo(anexoTO.getNumeroSequencialArquivo());
			fracaoAnexoBO.excluir(fracaoAnexoTO);
			daoManager.commitTransaction();

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}

	}

	@SuppressWarnings("unchecked")
	public AnexoTO download(AnexoTO anexoTO) throws ExceptionNegocioPRO {
		FracaoAnexoTO fracaoAnexoTO = new FracaoAnexoTO();
		FracaoAnexoBO fracaoAnexoBO = new FracaoAnexoBO();
		try {

			
			fracaoAnexoTO.setAnoCriacao(anexoTO.getAnoCriacao());// Transefere os dados do anexoTO para o fracaoAnexoTO
			fracaoAnexoTO.setNumeroSequencialTarefa(anexoTO.getNumeroSequencialTarefa());
			fracaoAnexoTO.setNumeroSequencialArquivoAnexo(anexoTO.getNumeroSequencialArquivo());
			anexoTO.setNome(consultarUm(anexoTO).getNome());// define no anexoTO o nome do arquivo
			HashMap montarArquivo = new HashMap();// Cria um HashMap para receber os fragmentos do arquivo
			
			if (fracaoAnexoTO != null) {
				Collection retorno = fracaoAnexoBO.download(fracaoAnexoTO);// Efetua o download do arquivo selecionado
				Iterator resultados = retorno.iterator();// Insere no HashMap todos os fragemntos do arquivo selecionado
				while (resultados.hasNext()) {
					FracaoAnexoTO fracao = (FracaoAnexoTO) resultados.next();
					montarArquivo.put(new Integer(fracao.getNumeroFracaoAnexoTarefa() - 1), fracao.getConteudoFracaoAnexo());
				}
				anexoTO.setByteAnexo(Fragmentador.recuperaArrayByteArquivo(montarArquivo));// Define na anexoTO o array com o arquivo recuperado
			}
			return anexoTO;
		} catch (ExceptionNegocioPRO e) {
			log.error("pro.anexo.erro.buscarDadosAnexo");
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}

	
	public int consultarMax(AnexoTO anexoTO) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		AnexoDAO anexoDAO = (AnexoDAO) daoManager.getDao(AnexoDAO.class);
		try {
			daoManager.startTransaction();
			int resultNumOrdemIncrementado = anexoDAO.consultarMax(anexoTO);
			return resultNumOrdemIncrementado;
		} catch (ExceptionNegocioPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
	}
	
	public Collection consultarVarios(AnexoTO anexoTO) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		AnexoDAO anexoDAO = (AnexoDAO) daoManager.getDao(AnexoDAO.class);
		Collection anexos = new ArrayList();
		try {
			daoManager.startTransaction();
			anexos = anexoDAO.consultarVarios(anexoTO);
		} catch (ExceptionNegocioPRO e) {
			log.error("pro.anexo.erro.buscarDados");
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
		return anexos;
	}
	
	
	public int getEspacoUtilizado(Collection anexos) {
		int tamanhoTodosAquivos = 0;
		double tamanhoArquivo = 0;
		Iterator iteracao = anexos.iterator();

		while (iteracao.hasNext()) {
			AnexoTO anexoTO = (AnexoTO) iteracao.next();
			tamanhoArquivo = anexoTO.getQuantByteAnexo();
			DecimalFormat formato = new DecimalFormat("0");
			anexoTO.setTamanho(formato.format((tamanhoArquivo / 1024)) + "Kb");
			tamanhoTodosAquivos += tamanhoArquivo;
		}
		return tamanhoTodosAquivos;
	}

}
