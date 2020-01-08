package br.com.intraPRO.negocio;

import java.util.Collection;

import com.ibatis.dao.client.DaoManager;

import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.FormularioTO;
import br.com.intraPRO.modelo.ListaOpcaoFormularioTO;
import br.com.intraPRO.persistencia.ListaOpcaoFormularioDAO;

public class ListaOpcaoFormularioBO {
	
	public ListaOpcaoFormularioBO(){
	}
	
	
	public void incluir(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			ListaOpcaoFormularioDAO listaOpcaoFormularioDAO = (ListaOpcaoFormularioDAO) daoManager.getDao(ListaOpcaoFormularioDAO.class);			
			daoManager.startTransaction();
			listaOpcaoFormularioTO.setCodigo(consultarMax());
			alterarTipoFormulario(listaOpcaoFormularioTO);
			listaOpcaoFormularioDAO.incluir(listaOpcaoFormularioTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
	}
	
	
	public void alterar(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			ListaOpcaoFormularioDAO listaOpcaoFormularioDAO = (ListaOpcaoFormularioDAO) daoManager.getDao(ListaOpcaoFormularioDAO.class);			
			daoManager.startTransaction();
			listaOpcaoFormularioDAO.alterar(listaOpcaoFormularioTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
	}
	
	
	public Collection consultarVarios(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			ListaOpcaoFormularioDAO listaOpcaoFormularioDAO = (ListaOpcaoFormularioDAO) daoManager.getDao(ListaOpcaoFormularioDAO.class);			
			daoManager.startTransaction();
			return listaOpcaoFormularioDAO.consultarVarios(listaOpcaoFormularioTO);
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
	}
	
	
	public int consultarMax() throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			ListaOpcaoFormularioDAO listaOpcaoFormularioDAO = (ListaOpcaoFormularioDAO) daoManager.getDao(ListaOpcaoFormularioDAO.class);
			daoManager.startTransaction();
			return listaOpcaoFormularioDAO.consultarMax();
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		} finally{
			daoManager.endTransaction();
		}
	}
	
	
	public void exluir(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionNegocioPRO{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try {
			ListaOpcaoFormularioDAO listaOpcaoFormularioDAO = (ListaOpcaoFormularioDAO) daoManager.getDao(ListaOpcaoFormularioDAO.class);			
			daoManager.startTransaction();
			listaOpcaoFormularioDAO.excluir(listaOpcaoFormularioTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
	}
	
	
	public void alterarTipoFormulario(ListaOpcaoFormularioTO listaOpcaoFormularioTO) throws ExceptionNegocioPRO{
		try {
			FormularioBO formularioBO = new FormularioBO();
			FormularioTO formularioTO = new FormularioTO();
			formularioTO.setCodConfigTarefa(listaOpcaoFormularioTO.getCodConfigTarefa());
			formularioTO.setNumeroOrdem(listaOpcaoFormularioTO.getNumeroOrdem());
			formularioTO.setNumOrdemAnterior(listaOpcaoFormularioTO.getNumeroOrdem());
			formularioBO.alterar(formularioTO);
		} catch (ExceptionNegocioPRO e) {
			throw new ExceptionNegocioPRO(e.getMessage());
		}
	}

}
