package br.com.intraBSC.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.GrupoTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.persistencia.FabricaDAO;
import br.com.intraBSC.persistencia.UsuarioDAO;

import com.ibatis.dao.client.DaoManager;



public class UsuarioBO {

	private static Log log = LogFactory.getLog(UsuarioBO.class);
	private static ThreadLocal<UsuarioTO> usuario = new ThreadLocal<UsuarioTO>();
	
	/*Metodo utilizado na camada de visao*/
    public static UsuarioTO getUsuarioTO(HttpServletResponse response,HttpServletRequest request) throws IOException {
    	if (usuario.get() != null){
    		return (UsuarioTO) usuario.get();
    	}else{
    		response.sendRedirect("http://"+request.getServerName()+":"+request.getLocalPort()+""+request.getContextPath()+"/encaminhaLogon.do");
    		return null;
    	}
    }
    
    /*Metodo utilizado na camada de negocio*/
    public static UsuarioTO getUsuarioTO() {    	
        return (UsuarioTO) usuario.get();
    }

    public static void setUsuarioTO(UsuarioTO usuarioTO) {    	
        usuario.set(usuarioTO);
    }  
	
	
	/*
	 * Autor Tiago Trindade Stangarlin
	 * Data 11/10/2005
	 * Metodo para consula de um usuario do sistema
	 * */
	public UsuarioTO consultarUm(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		UsuarioDAO usuarioDAO = (UsuarioDAO) daoManager.getDao(UsuarioDAO.class);
		try {
			daoManager.startTransaction();
			UsuarioTO retorno = usuarioDAO.consultarUm(usuarioTO);
			if (retorno.getGrupoTO().getCodigo() != 0) {
				GrupoBO grupoBO = new GrupoBO();
				retorno.setGrupoTO(grupoBO.consultarUm(retorno.getGrupoTO()));
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}finally{
			daoManager.endTransaction();			
		}
		
	}
	
	/**
	 * Metodo de consulta de usuarios pentencentes ao grupo de um determinado
	 * usuario.
	 * @param usuarioTO
	 * @return Collection
	 * @throws ExceptionNegocioBSC
	 */
	public Collection consultarUsuarioGrupo(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		UsuarioDAO usuarioDAO = (UsuarioDAO) daoManager.getDao(UsuarioDAO.class);
		try {
			daoManager.startTransaction();
			return usuarioDAO.consultarUsuarioGrupo(usuarioTO);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}finally{
			daoManager.endTransaction();			
		}
		
	}
	
	//private Perfil 
	
	/*
	 * Autor Tiago Trindade Stangarlin
	 * Data 11/10/2005
	 * Metodo para consula de varios usuario do sistema
	 * */
	@SuppressWarnings("unchecked")
	public Collection consultarVarios(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		UsuarioDAO usuarioDAO = (UsuarioDAO) daoManager.getDao(UsuarioDAO.class);
		try {
			Collection<UsuarioTO> listaUsuarios = new ArrayList<UsuarioTO>();
			UsuarioTO retorno = null;
			GrupoBO grupoBO = new GrupoBO();
			GrupoTO grupoTO = new GrupoTO();
			daoManager.startTransaction();
			for (Iterator<UsuarioTO> iter = usuarioDAO.consultarVarios(usuarioTO).iterator(); iter.hasNext();) {
				retorno = (UsuarioTO) iter.next();
				grupoTO.setCodigo(retorno.getGrupoTO().getCodigo());
				retorno.setGrupoTO(grupoBO.consultarUm(grupoTO));
				if (usuario.get().getPerfil().equals("gerentegeral")) {
					if (retorno.getGrupoTO().getCodigo() == usuario.get().getGrupoTO().getCodigo()) {
						listaUsuarios.add(retorno);
					}
				} else {
					listaUsuarios.add(retorno);
				}
			}
			return listaUsuarios;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}finally{
			daoManager.endTransaction();			
		}
		
	}
	
	/*
	 * Autor Tiago Trindade Stangarlin
	 * Data 11/10/2005
	 * Metodo para excluir um usuario do sistema
	 * */
	public void excluir(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		UsuarioDAO usuarioDAO = (UsuarioDAO) daoManager.getDao(UsuarioDAO.class);
		try {
			daoManager.startTransaction();
			usuarioDAO.excluir(usuarioTO);
			daoManager.commitTransaction();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}finally{
			daoManager.endTransaction();
		}
		
	}
	
	/*
	 * Autor Tiago Trindade Stangarlin
	 * Data 11/10/2005
	 * Metodo para incluir um usuario do sistema
	 * */
	public void incluir(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		UsuarioDAO usuarioDAO = (UsuarioDAO) daoManager.getDao(UsuarioDAO.class);
		try {
			daoManager.startTransaction();
			usuarioDAO.incluir(usuarioTO);
			daoManager.commitTransaction();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}finally{
			daoManager.endTransaction();			
		}
		
	}
	
	/*
	 * Autor Tiago Trindade Stangarlin
	 * Data 11/10/2005
	 * Metodo para incluir um usuario do sistema
	 * */
	public void incluirXml(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		UsuarioDAO usuarioDAO = (UsuarioDAO) daoManager.getDao(UsuarioDAO.class);
		try {
			daoManager.startTransaction();
			usuarioTO.setIdUsuario(consultarMax(usuarioTO));
			usuarioDAO.incluirXml(usuarioTO);
			daoManager.commitTransaction();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}finally{
			daoManager.endTransaction();			
		}
		
	}
	
	public int consultarMax(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		try{        	
    	   UsuarioDAO usuarioDAO = (UsuarioDAO) daoManager.getDao(UsuarioDAO.class);
    	   daoManager.startTransaction();
     		return usuarioDAO.consultarMax(usuarioTO);         	
       }catch (ExceptionNegocioBSC e) {
    	   log.error(e.getMessage());
           throw new ExceptionNegocioBSC(e.getMessage());
       }finally{
       		daoManager.endTransaction();
       }       
	}
	
	/*
	 * Autor Tiago Trindade Stangarlin
	 * Data 11/10/2005
	 * Metodo para alterar um usuario do sistema
	 * */
	public void alterar(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		UsuarioDAO usuarioDAO = (UsuarioDAO) daoManager.getDao(UsuarioDAO.class);
		try {
			daoManager.startTransaction();
			usuarioDAO.alterar(usuarioTO);
			daoManager.commitTransaction();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}finally{
			daoManager.endTransaction();			
		}
		
	}
	
	/**
	 * Autor Tiago Trindade Stangarlin
	 * Data 11/10/2005
	 * Metido que verifica se o login e senha estao corretos para acessar o sistema.
	 * */
	public boolean verificaLogin(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{		
		try {
			UsuarioTO usuarioTOResultado = consultarUm(usuarioTO);
			
			if ((usuarioTOResultado.getLogin() != null) && (usuarioTOResultado.getLogin().equals(usuarioTO.getLogin()))){
				if (usuarioTOResultado.getSenha().equals(usuarioTO.getSenha()))
					return true;
				else
					return false;
			}else
				return false;			
		} catch (ExceptionNegocioBSC e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}
		
	}
	
	/**
	 * Autor Tiago Trindade Stangarlin
	 * Data 11/10/2005
	 * Metodo para consula de um usuario do sistema, somente para logar no sistema
	 * */
	public UsuarioTO consultarLogon(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		UsuarioDAO usuarioDAO = (UsuarioDAO) daoManager.getDao(UsuarioDAO.class);
		try {
			daoManager.startTransaction();
			UsuarioTO retorno = usuarioDAO.consultarLogon(usuarioTO);
			GrupoBO grupoBO = new GrupoBO();
			GrupoTO grupoTO = new GrupoTO();
			grupoTO.setCodigo(retorno.getGrupoTO().getCodigo());
			if (retorno.getGrupoTO().getCodigo() != 0){
				retorno.setGrupoTO(grupoBO.consultarUm(grupoTO));
			}
			return retorno;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}finally{
			daoManager.endTransaction();			
		}
		
	}
	
	/**
	 * Metodo que altera o estado do usuario, Se esta online ou OffLine.
	 * @param usuarioTO
	 * @throws ExceptionNegocioBSC
	 */
	public void alterarOnline(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		DaoManager daoManager = FabricaDAO.getDaoManager();
		UsuarioDAO usuarioDAO = (UsuarioDAO) daoManager.getDao(UsuarioDAO.class);
		try {
			daoManager.startTransaction();
			usuarioDAO.alterarOnline(usuarioTO);
			daoManager.commitTransaction();
		} catch (ExceptionNegocioBSC e) {
			log.error(e.getMessage());
			throw new ExceptionNegocioBSC(e.getMessage());
		}finally{
			daoManager.endTransaction();			
		}
	}
	
	/**
	 * Metodo que menta a lista usuarios do grupo que estao online.
	 * @param usuarioTO
	 * @return
	 * @throws ExceptionNegocioBSC 
	 */
	public Collection montaListaUsuarioOnline(UsuarioTO usuarioTO) throws ExceptionNegocioBSC{
		return consultarVarios(usuarioTO);
	}
}