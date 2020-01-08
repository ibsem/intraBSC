package br.com.intraBSC.meta.controle;

import java.util.Collection;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import br.com.intraBSC.controle.DispatchActionBSC;
import br.com.intraBSC.meta.visao.MetaForm;
import br.com.intraBSC.modelo.MetaTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.MetaBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.util.Constantes;
import br.com.intraPRO.util.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tiago Trindade Stangarlin
 */
public class MetaAction extends DispatchActionBSC{
   
   public MetaAction(){   
   }
   
   /*Encaminha para tela de inclusao da ferramenta de visualizacao*/
   public ActionForward encaminhaIncluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {			
			UsuarioTO usuarioTO = new UsuarioTO();			
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
			Collection listaUsuario = usuarioBO.consultarVarios(usuarioTO);
			request.getSession().setAttribute("listaResponsavel",listaUsuario);
			MetaForm metaForm = (MetaForm) form;			
			MetaTO metaTO = new MetaTO();			
			metaTO.setIdIndicador(Integer.parseInt(request.getSession().getAttribute("codIndicadorSelecionado").toString()));
			metaForm.setNomeIndicador(new MetaBO().consultarUmIndicador(metaTO).getNome());
			
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
   }
   
   /*Metodo que encaminha para a inclusao de Meta na ferramenta de configuracao*/
   public ActionForward encaminhaIncluirConfiguracao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		    /*Consultar Responsavel*/
			UsuarioTO usuarioTO = new UsuarioTO();			
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
			Collection listaUsuario = usuarioBO.consultarVarios(usuarioTO);
			if (!listaUsuario.isEmpty()){
				request.getSession().setAttribute("listaResponsavel",listaUsuario);
			}
			MetaForm metaForm = (MetaForm) form;
			int codInd = Integer.parseInt(request.getParameter("codIndicador"));
			metaForm.setIdIndicador(codInd);
			metaForm.setNomeIndicador(request.getParameter("nomeIndicador"));
			metaForm.setDescricao("");
			metaForm.setNome("");
			Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			return mapping.findForward("sucessoIncluir");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
   }
   
   private void validarLimites(MetaForm form) throws Exception {
	   if (form.getLimiteSuperior() < form.getLimiteInferior()) {
		   throw new Exception(Constantes.ERRO_LIMITE);
	   }
   }
   
   public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   	MetaForm metaForm = (MetaForm) form;
		   	validarLimites(metaForm);
			MetaBO metaBO = new MetaBO();
			MetaTO metaTO = new MetaTO();
		    metaTO.setIdIndicador(metaForm.getIdIndicador());
		    metaTO.setAtivo("1");
		    /*Caso este indicador tenha uma meta ativa, ela sera passada para inativa, para que a nova meta seja a unica ativa*/
			MetaTO retorno = metaBO.consultarUm(metaTO);
			if (retorno.getId() != 0){
				retorno.setAtivo("2");
				metaBO.alterar(retorno);
			}
			metaForm.setMetaTO(metaTO);
			metaBO.incluir(metaTO);
			metaForm.setId(metaTO.getId());
			setMensagem("bsc.mensagem.sucesso",request);
			Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			return mapping.findForward("sucessoIncluir");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
   }
   
   public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   	MetaForm metaForm = (MetaForm) form;
		   	validarLimites(metaForm);
			MetaBO metaBO = new MetaBO();
			MetaTO metaTO = new MetaTO();
		    metaTO.setIdIndicador(metaForm.getIdIndicador());
		    if (metaForm.getAtivo().equals("1")){
			    metaTO.setAtivo("1");
			    /*Caso este indicador tenha uma meta ativa, ela sera passada para inativa, para que a nova meta seja a unica ativa*/
				MetaTO retorno = metaBO.consultarUm(metaTO);
				if (retorno.getId() != 0){
					retorno.setAtivo("2");
					metaBO.alterar(retorno);
				}
		    }
			metaForm.setMetaTO(metaTO);
			metaTO.setId(metaForm.getId());
			metaBO.alterar(metaTO);
			setMensagem("bsc.mensagem.sucesso",request);
			Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			return mapping.findForward("sucessoAlterar");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
   }
   
   /*Encaminha para a tela de consulta de Metas setando os valores necessarios do indicador*/
   public ActionForward encaminharConsultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   	MetaForm metaForm = (MetaForm) form;
			MetaTO metaTO = new MetaTO();
		    metaTO.setIdIndicador(metaForm.getIdIndicador());
		    metaForm.setNome("");
		    metaForm.setResponsavel(0);
		    metaForm.setAtivo("");
		    Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			return mapping.findForward("sucessoConsultar");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
   }
   
   /*Encaminha para a tela de consulta de Metas setando os valores necessarios do indicador*/
   public ActionForward consultarVarios(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   	MetaForm metaForm = (MetaForm) form;
		   	MetaBO metaBO = new MetaBO();
			MetaTO metaTO = new MetaTO();
			metaForm.setMetaTO(metaTO);
			request.setAttribute("listaMetas",metaBO.consultarVarios(metaTO));
			Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			return mapping.findForward("sucessoConsultar");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
   }
   
   public ActionForward consultarUm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		    MetaForm metaForm = (MetaForm) form;
		   	MetaBO metaBO = new MetaBO();
			MetaTO metaTO = new MetaTO();
			int codInd = Integer.parseInt(request.getParameter("codIndicador"));
			String nomeInd = request.getParameter("nomeIndicador");
			metaTO.setIdIndicador(codInd);
			int codMeta = Integer.parseInt(request.getParameter("codMeta"));
			metaTO.setId(codMeta);
			metaForm.setMetaForm(metaBO.consultarUm(metaTO));
			metaForm.setNomeIndicador(nomeInd);
			Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			/*Consultar Responsavel*/
			UsuarioTO usuarioTO = new UsuarioTO();			
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioTO.setGrupoTO(UsuarioBO.getUsuarioTO().getGrupoTO());
			Collection listaUsuario = usuarioBO.consultarVarios(usuarioTO);
			if (!listaUsuario.isEmpty()){
				request.getSession().setAttribute("listaResponsavel",listaUsuario);
			}
			return mapping.findForward("sucessoAlterar");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
   }
   
   public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	   try {
		   	MetaForm metaForm = (MetaForm) form;
			MetaBO metaBO = new MetaBO();
			MetaTO metaTO = new MetaTO();
			metaForm.setMetaTO(metaTO);
			metaTO.setId(metaForm.getId());
			metaBO.excluir(metaTO);
			setMensagem("bsc.mensagem.sucesso",request);
			Integer codMapa = (Integer) request.getSession().getAttribute("codMapaArvoreConfiguracao");
			Util.atualizaArvoreConfiguracao(request, request.getParameter("itemSelecionado"),codMapa);
			return mapping.findForward("sucessoExcluir");
		} catch (Exception e) {
			setErro("bsc.erro",e.getMessage(),request);
			return mapping.findForward("erro");
		}
   }
}
