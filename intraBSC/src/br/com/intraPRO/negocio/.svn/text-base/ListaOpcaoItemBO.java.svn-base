package br.com.intraPRO.negocio;

import java.util.Collection;

import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.ItemTO;
import br.com.intraPRO.modelo.ListaOpcaoItemTO;
import br.com.intraPRO.persistencia.ListaOpcaoItemDAO;

public class ListaOpcaoItemBO {
	
	public ListaOpcaoItemBO(){
	}
	
	
	public void incluir(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			ListaOpcaoItemDAO listaOpcaoItemDAO = (ListaOpcaoItemDAO) daoManager.getDao(ListaOpcaoItemDAO.class);			
			daoManager.startTransaction();
			listaOpcaoItemTO.setCodigo(consultarMax());
			alterarTipoItem(listaOpcaoItemTO);
			listaOpcaoItemDAO.incluir(listaOpcaoItemTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
	}
	
	
	public void alterar(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			ListaOpcaoItemDAO listaOpcaoItemDAO = (ListaOpcaoItemDAO) daoManager.getDao(ListaOpcaoItemDAO.class);			
			daoManager.startTransaction();
			listaOpcaoItemDAO.alterar(listaOpcaoItemTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
	}
	
	
	public Collection consultarVarios(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			ListaOpcaoItemDAO listaOpcaoItemDAO = (ListaOpcaoItemDAO) daoManager.getDao(ListaOpcaoItemDAO.class);			
			daoManager.startTransaction();
			return listaOpcaoItemDAO.consultarVarios(listaOpcaoItemTO);
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
	}
	
	
	public int consultarMax() throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			ListaOpcaoItemDAO listaOpcaoItemDAO = (ListaOpcaoItemDAO) daoManager.getDao(ListaOpcaoItemDAO.class);
			daoManager.startTransaction();
			return listaOpcaoItemDAO.consultarMax();
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally{
			daoManager.endTransaction();
		}
	}
	
	
	public void exluir(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			ListaOpcaoItemDAO listaOpcaoItemDAO = (ListaOpcaoItemDAO) daoManager.getDao(ListaOpcaoItemDAO.class);			
			daoManager.startTransaction();
			listaOpcaoItemDAO.excluir(listaOpcaoItemTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
	}
	
	
	public void alterarTipoItem(ListaOpcaoItemTO listaOpcaoItemTO) throws ExceptionNegocioPRO{
		try {
			ItemBO itemBO = new ItemBO();
			ItemTO itemTO = new ItemTO();
			itemTO.setCodConfigTarefa(listaOpcaoItemTO.getCodConfigTarefa());
			itemTO.setNumeroOrdem(listaOpcaoItemTO.getNumeroOrdem());
			itemTO.setNumOrdemAnterior(listaOpcaoItemTO.getNumeroOrdem());
			itemBO.alterar(itemTO);
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}

}
