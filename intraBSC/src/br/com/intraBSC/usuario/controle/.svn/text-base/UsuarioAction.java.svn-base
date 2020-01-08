package br.com.intraBSC.usuario.controle;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.modelo.GrupoTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.GrupoBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.usuario.visao.UsuarioForm;
import br.com.intraBSC.util.Criptografia;


public class UsuarioAction extends DispatchActionBSC{	
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo que realiza a inclusao dos dados do usuario do sistema
	 * Data 12/12/2005
	 * */
	public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {
			UsuarioForm usuarioForm = (UsuarioForm) form;
			UsuarioTO usuarioTO = new UsuarioTO();
			usuarioForm.setUsuarioTO(usuarioTO);
			UsuarioBO usuarioBO = new UsuarioBO();
			/*Verifica se o usuario ja existe*/
			UsuarioTO usuarioTOConsulta = new UsuarioTO();
			usuarioTOConsulta.setLogin(usuarioTO.getLogin());
			usuarioTOConsulta = usuarioBO.consultarUm(usuarioTOConsulta); 
			if ((usuarioTOConsulta.getNome() == null))
				usuarioBO.incluir(usuarioTO);
			else{
				setErro("bsc.jaExiste.inclusao.usuario",request);
				return mapping.findForward("erro");
			}
			setMensagem("bsc.sucesso.inclusao.usuario",request);
			request.removeAttribute("usuarioForm");
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro.incluir.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}		
	}
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo que realiza a exclusao dos dados do usuario do sistema
	 * Data 12/12/2005
	 * */
	public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {
			UsuarioForm usuarioForm = (UsuarioForm) form;
			UsuarioTO usuarioTO = new UsuarioTO();
			UsuarioBO usuarioBO = new UsuarioBO();
			
			UsuarioTO consUsuarioTO = new UsuarioTO();
			consUsuarioTO.setLogin(usuarioForm.getLogin());
			if (usuarioBO.consultarUm(consUsuarioTO).getSenha().equalsIgnoreCase(Criptografia.criptografar(usuarioForm.getSenhaAtual()))){
				usuarioTO.setIdUsuario(usuarioForm.getIdUsuario());
				usuarioBO.excluir(usuarioTO);
				setMensagem("bsc.sucesso.exclusao.usuario",request);
				request.removeAttribute("usuarioForm");
			}else{
				setErro("bsc.erro.excluir.usuario","Senha inválida para realizar esta operação",request);
				return mapping.findForward("erro");
			}
			return mapping.findForward("sucesso");
			
		} catch (Exception e) {
			setErro("bsc.erro.excluir.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}		
	}
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo que realiza a pesquisa dos dados do usuario do sistema
	 * Data 12/12/2005
	 * */
	public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {
			UsuarioForm usuarioForm = (UsuarioForm) form;
			UsuarioTO usuarioTO = new UsuarioTO();
			usuarioForm.setUsuarioTO(usuarioTO);
			UsuarioBO usuarioBO = new UsuarioBO();
			Collection listaUsuarios = new ArrayList();
			listaUsuarios = usuarioBO.consultarVarios(usuarioTO);
			if (!listaUsuarios.isEmpty()){
				request.getSession().setAttribute("listaUsuarios",listaUsuarios);
			}else{
				setMensagem("bsc.naoExiste.usuario",request);
			}
			return mapping.findForward("sucesso");			
		} catch (Exception e) {
			setErro("bsc.erro.consultar.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo que realiza a exclusao dos dados do usuario do sistema
	 * Data 12/12/2005
	 * */
	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {
			UsuarioForm usuarioForm = (UsuarioForm) form;
			UsuarioTO usuarioTO = new UsuarioTO();			
			UsuarioBO usuarioBO = new UsuarioBO();
		
			usuarioForm.setUsuarioTO(usuarioTO);
			usuarioTO.setIdUsuario(usuarioForm.getIdUsuario());
			usuarioBO.alterar(usuarioTO);
			setMensagem("bsc.sucesso.alteracao.usuario",request);
			UsuarioTO sessao = usuarioBO.consultarUm(usuarioTO);
			if (sessao.getIdUsuario() == UsuarioBO.getUsuarioTO().getIdUsuario()){
				request.getSession().setAttribute("usuarioBSC", sessao);
			}
			
			UsuarioBO.setUsuarioTO(sessao);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro.alterar.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}		
	}
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo que realiza a pesquisa de um unico usuario passando como parametro o codigo do usuario
	 * Data 12/12/2005
	 * */
	public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {			
			UsuarioTO usuarioTO = new UsuarioTO();			
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioTO.setIdUsuario(Integer.parseInt(request.getParameter("codigo")));
			GrupoTO grupoTO = new GrupoTO();			
			GrupoBO grupoBO = new GrupoBO();
			grupoTO.setAtivo(1);
			request.setAttribute("listaGrupo",grupoBO.consultarVarios(grupoTO));
			UsuarioForm usuarioForm = (UsuarioForm) form;
			usuarioForm.setUsuarioForm(usuarioBO.consultarUm(usuarioTO));
			request.setAttribute("usuarioForm",usuarioForm);
			return mapping.findForward("sucesso");			
		} catch (Exception e) {
			setErro("bsc.erro.consultar.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo que realiza a pesquisa de um unico usuario passando como parametro o codigo do usuario
	 * Data 12/12/2005
	 * */
	public ActionForward encaminharIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {			
			GrupoTO grupoTO = new GrupoTO();			
			GrupoBO grupoBO = new GrupoBO();
			grupoTO.setAtivo(1);
			request.setAttribute("listaGrupo",grupoBO.consultarVarios(grupoTO));
			return mapping.findForward("sucesso");			
		} catch (Exception e) {
			setErro("bsc.erro.consultar.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo que realiza a pesquisa de um unico usuario passando como parametro o codigo do usuario
	 * Data 12/12/2005
	 * */
	public ActionForward alterarSenha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {
			UsuarioForm usuarioForm = (UsuarioForm) form;
			UsuarioTO usuarioTO = new UsuarioTO();			
			UsuarioBO usuarioBO = new UsuarioBO();

			/*Testa se a senha esta correta para alterar dados do usuario*/
			UsuarioTO consUsuarioTO = new UsuarioTO();
			consUsuarioTO.setIdUsuario(usuarioForm.getIdUsuario());
			if (usuarioBO.consultarUm(consUsuarioTO).getSenha().equals(Criptografia.criptografar(usuarioForm.getSenhaAtual()))){
				usuarioForm.setUsuarioTO(usuarioTO);
				usuarioTO.setIdUsuario(usuarioForm.getIdUsuario());
				usuarioBO.alterar(usuarioTO);
			}else{
				setErro("bsc.erro.alterar.usuario","Senha inválida para realizar esta operação",request);
				return mapping.findForward("erro");
			}
			setMensagem("bsc.mensagem.sucesso",request);
			return mapping.findForward("sucessoSenha");			
		} catch (Exception e) {
			setErro("bsc.erro.consultar.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo para alterar login do usuario
	 * Data 12/12/2005
	 * */
	public ActionForward alterarLogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {
			UsuarioForm usuarioForm = (UsuarioForm) form;
			UsuarioTO usuarioTO = new UsuarioTO();			
			UsuarioBO usuarioBO = new UsuarioBO();
			
			/*Testa se a senha esta correta para alterar dados do usuario*/
			UsuarioTO consUsuarioTO = new UsuarioTO();
			consUsuarioTO.setIdUsuario(usuarioForm.getIdUsuario());
			if (usuarioBO.consultarUm(consUsuarioTO).getSenha().equalsIgnoreCase(Criptografia.criptografar(usuarioForm.getSenhaAtual()))){
				usuarioTO.setLogin(usuarioForm.getLogin());
				if (usuarioBO.consultarLogon(usuarioTO).getIdUsuario() == 0){
					usuarioTO.setIdUsuario(usuarioForm.getIdUsuario());
					usuarioBO.alterar(usuarioTO);
				}else{
					setErro("bsc.erro.alterar.usuario","Login já existe",request);
					return mapping.findForward("erro");
				}
			} else {
				setErro("bsc.erro.alterar.usuario","Senha inválida para realizar esta operação",request);
				return mapping.findForward("erro");
			}
			
			setMensagem("bsc.mensagem.sucesso",request);
			return mapping.findForward("sucesso");			
		} catch (Exception e) {
			setErro("bsc.erro.consultar.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo que realiza a pesquisa de um unico usuario passando como parametro o codigo do usuario
	 * Data 12/12/2005
	 * */
	public ActionForward encaminharAlterarCadastro(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {
			UsuarioTO usuarioTO = UsuarioBO.getUsuarioTO();
			UsuarioForm usuarioForm = (UsuarioForm) form;
			usuarioForm.setUsuarioForm(usuarioTO);
			request.setAttribute("usuarioForm", usuarioForm);
			
			GrupoTO grupoTO = new GrupoTO();			
			GrupoBO grupoBO = new GrupoBO();
			grupoTO.setAtivo(1);
			request.setAttribute("listaGrupo",grupoBO.consultarVarios(grupoTO));
			return mapping.findForward("sucesso");			
		} catch (Exception e) {
			setErro("bsc.erro.consultar.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo que realiza a pesquisa de um unico usuario passando como parametro o codigo do usuario
	 * Data 12/12/2005
	 * */
	public ActionForward encaminharAlterarSenha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {
			GrupoTO grupoTO = new GrupoTO();			
			GrupoBO grupoBO = new GrupoBO();
			grupoTO.setAtivo(1);
			request.setAttribute("listaGrupo",grupoBO.consultarVarios(grupoTO));
			return mapping.findForward("sucesso");			
		} catch (Exception e) {
			setErro("bsc.erro.consultar.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	/*
	 * Autor Tiago Stangarlin
	 * Metodo que realiza a pesquisa de um unico usuario passando como parametro o codigo do usuario
	 * Data 12/12/2005
	 * */
	public ActionForward encaminharAlterarLogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {			
			GrupoTO grupoTO = new GrupoTO();			
			GrupoBO grupoBO = new GrupoBO();
			grupoTO.setAtivo(1);
			request.setAttribute("listaGrupo",grupoBO.consultarVarios(grupoTO));
			return mapping.findForward("sucesso");			
		} catch (Exception e) {
			setErro("bsc.erro.consultar.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
	public ActionForward imprimirUsuario(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{		
		try {
			Collection listaUsuario = (Collection) request.getSession().getAttribute("listaUsuarios");
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaUsuario);
			String caminhoRelJasper = request.getSession().getServletContext().getRealPath("/relatorios/relUsuario.jasper");
			try {
				Map parametros = new HashMap();
				byte[] bytes = JasperRunManager.runReportToPdf(caminhoRelJasper, parametros, ds);
                response.setContentType("application/pdf");    
                response.setContentLength(bytes.length);    
                ServletOutputStream ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();             
                ouputStream.close();
				
			} catch (JRException e) {
				setErro("bsc.erro.consultar.usuario",e.getMessage(),request);
				return mapping.findForward("erro");
			}
			return mapping.findForward("sucesso");			
		} catch (Exception e) {
			setErro("bsc.erro.consultar.usuario",e.getMessage(),request);
			return mapping.findForward("erro");
		}
	}
	
}
