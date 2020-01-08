
package br.com.intraPRO.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.AnexoTO;
import br.com.intraPRO.modelo.FracaoAnexoTO;
import br.com.intraPRO.persistencia.FracaoAnexoDAO;

import com.ibatis.dao.client.DaoManager;


public class FracaoAnexoBO {
	private static Log log = LogFactory.getLog(ItemBO.class);

	public FracaoAnexoBO() {
	}

	public void incluir(int fracaoAnexoTO) throws ExceptionNegocioPRO {
	}

	
	public boolean incluirFragmentos(AnexoTO anexoTO, HashMap pedacos) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		FracaoAnexoDAO fracaoAnexoDAO = (FracaoAnexoDAO) daoManager.getDao(FracaoAnexoDAO.class);
		FracaoAnexoTO fracaoAnexoTO = new FracaoAnexoTO();
		fracaoAnexoTO.setAnoCriacao(anexoTO.getAnoCriacao());// Seta os no fracaoAnexoTO os valores anoCriacao, numeroSequencialTarefa e NumeroSquencialArquivoAnexo.
		fracaoAnexoTO.setNumeroSequencialTarefa(anexoTO.getNumeroSequencialTarefa());
		fracaoAnexoTO.setNumeroSequencialArquivoAnexo(anexoTO.getNumeroSequencialArquivo());
		try {
			daoManager.startTransaction();
			for (int idCount = 0; idCount < pedacos.size(); idCount++) {// para cada pedaço do arquivo blob fragmentado inserir na nova base.
				String stringPedaco = pedacos.get(new Integer(idCount)).toString();				
				fracaoAnexoTO.setNumeroFracaoAnexoTarefa(idCount + 1);
				fracaoAnexoTO.setConteudoFracaoAnexo(stringPedaco);// Define na TO a fraçao do arquivo.
				fracaoAnexoDAO.incluir(fracaoAnexoTO);// Inclui no Banco de dados a fração do arquivo selecionado.
			}
			daoManager.commitTransaction();
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}
	}


	public void excluir(FracaoAnexoTO fracaoAnexoTO) throws ExceptionNegocioPRO {
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			FracaoAnexoDAO fracaoAnexoDAO = (FracaoAnexoDAO) daoManager.getDao(FracaoAnexoDAO.class);
			daoManager.startTransaction();
			fracaoAnexoDAO.excluir(fracaoAnexoTO);
			daoManager.commitTransaction();
		} catch (ExceptionPersistenciaPRO e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally {
			daoManager.endTransaction();
		}

	}

	
	public Collection download(FracaoAnexoTO fracaoAnexoTO) throws ExceptionNegocioPRO {

		DaoManager daoManager = FabricaDAO.getDaoManager();
		FracaoAnexoDAO fracaoAnexoDAO = (FracaoAnexoDAO) daoManager.getDao(FracaoAnexoDAO.class);
		Collection resultadoPesquisaFracao = new ArrayList();

		try {
			daoManager.startTransaction();
			// Efetua o download dos fragmentos
			resultadoPesquisaFracao = fracaoAnexoDAO.download(fracaoAnexoTO);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally {
			daoManager.endTransaction();
		}
		return resultadoPesquisaFracao;
	}
}