package br.com.intraBSC.controle;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.tiles.TilesRequestProcessor;
import java.util.Collection;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.UsuarioBO;


public class BSCRequestProcessor extends TilesRequestProcessor implements Filter {

	private HashMap resources = new HashMap();

	@SuppressWarnings("unchecked")
	public void init(FilterConfig filter) throws ServletException {
		try {
	         String accessFile = this.getClass().getClassLoader().getResource("access.properties").getPath();
	         Properties properties = new Properties();
	         properties.load(new FileInputStream(accessFile));
	         resources.putAll(properties);
	      } catch (Exception e) {
	         e.printStackTrace();
	         throw new ServletException(e);
	      }		
	}
	
	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		UsuarioTO usuario = (UsuarioTO) ((HttpServletRequest) request).getSession().getAttribute("usuarioBSC");
		String contexto = ((HttpServletRequest)request).getContextPath();
	    boolean allowed = verificaAcesso((HttpServletRequest) request);
	    if (!allowed) {
	    	if (usuario != null){
				((HttpServletResponse) response).sendRedirect("http://"+request.getServerName()+":"+request.getLocalPort()+""+contexto+"/autorizacao.do");
			}else{
				((HttpServletResponse) response).sendRedirect("http://"+request.getServerName()+":"+request.getLocalPort()+""+contexto+"/encaminhaLogon.do");
			}
	    }

		if (usuario != null){
			((HttpServletRequest) request).getSession().removeAttribute("UsuarioSenhaInvalido");
			((HttpServletRequest) request).getSession().setAttribute("usuarioBSC", usuario);
			UsuarioBO.setUsuarioTO(usuario);
			mantemArvorePROSessao(request,response);
		}
	    chain.doFilter(request, response);
	 }
	
	 
	 @SuppressWarnings("unused")
	private Collection montarUsuonline(UsuarioTO usuarioTO, ServletRequest request){
		 UsuarioBO usuarioBO = new UsuarioBO();
		 UsuarioTO usuConsulta = new UsuarioTO();
		 Collection lista = new ArrayList();
		 try {
			usuConsulta.setOnline(1);
			usuConsulta.setGrupoTO(usuarioTO.getGrupoTO());
			lista = usuarioBO.montaListaUsuarioOnline(usuConsulta);
		} catch (ExceptionNegocioBSC e) {
			e.printStackTrace();
		}
		return lista;
	 }
	 
	 protected boolean verificaAcesso(HttpServletRequest request) {
	     String resource = request.getRequestURI().replaceAll(request.getContextPath(), "");
	     while (resource.length() > 0) {
	        String rules = (String) resources.get(resource);
	        if (rules != null && !resource.equals("/logon.do")) {
	        	UsuarioTO usuarioTO = (UsuarioTO) request.getSession().getAttribute("usuarioBSC");
	           return (usuarioTO != null && usuarioTO.hasRoles(rules));
	        } else if (!resource.equals("/")) {
	           int index = resource.lastIndexOf("/");
	           if (index > -1) {
	              resource = resource.substring(0, index);
	           }
	        } else {
	           resource = "";
	        }
	     }
	     return true;
	  }

	private void mantemArvorePROSessao(ServletRequest request, ServletResponse response){
		Collection lista = (Collection)((HttpServletRequest) request).getSession().getAttribute("listaArvoreMapaEstrategicoConfig");
		if (lista != null){
			((HttpServletRequest) request).getSession().setAttribute("listaArvoreMapaEstrategicoConfig",lista);
		}
	}
	
	public void destroy() {
	}
	
	
	@SuppressWarnings("unused")
	private void listaUsuariosOnline(UsuarioTO usuarioTO){
		UsuarioBO usuarioBO = new UsuarioBO();
		UsuarioTO usuarioTOConsulta = new UsuarioTO();
		usuarioTOConsulta.setGrupoTO(usuarioTO.getGrupoTO());
		
		
	}
}
