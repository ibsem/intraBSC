package br.com.intraPRO.util;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.MapaEstrategicoBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.util.DataUtil;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;

public class Util {
	
	
	public static String substituiCaracter(String palavra){
		/*Metodo que substitui o caracter "<" e ">" por caracteres para HTML*/
		if (palavra.indexOf("<") != -1){
			palavra = palavra.replaceAll("<","&lt;");
		}
		if (palavra.indexOf(">") != -1){
			palavra = palavra.replaceAll(">","&gt;");
		}
		
		/*Metodo que substitui o caracter " por caracteres para HTML*/
		if (palavra.indexOf("\"") != -1){
			palavra = palavra.replaceAll("\"","&quot;");
		}
		
		return palavra;
	}
	
	
	public static void atualizaArvoreConfiguracao(HttpServletRequest request, String itemSelecionado,Integer codMapa) throws ExceptionNegocioBSC{
		   request.getSession().removeAttribute("arvoreConfiguracao");
		   MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();			
		   MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
		   request.getSession().setAttribute("codMapaArvoreConfiguracao",codMapa);
		   mapaEstrategicoTO.setId(codMapa);
		   Collection lista = mapaEstrategicoBO.consultarArvoreConfiguracao(mapaEstrategicoTO);
		   request.getSession().setAttribute("arvoreConfiguracao",lista);
		 if (itemSelecionado != null){
			 request.setAttribute("itemArvoreMarcado", itemSelecionado);
		 } else {
			 request.setAttribute("itemArvoreMarcado", "1");
		 }
		
	}
	
	
	public static void atualizaArvoreTarefa(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		TarefaBO tarefaBO = new TarefaBO();
		TarefaTO tarefaTO = new TarefaTO();
		ParticipanteTO participanteTO = new ParticipanteTO();
		participanteTO.setCodTipoParticipacao(1);
	
		/*Recupera usuario logado*/
		UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		participanteTO.setCodUsuario(usuario.getIdUsuario());
		tarefaTO.setCodUsuSolicitante(usuario.getIdUsuario());
		request.getSession().removeAttribute("listaArvoreMapaEstrategicoConfig");
		Collection listaArvoreMapaEstrategicoConfig = tarefaBO.consultarArvore(tarefaTO, participanteTO);
		
		if (!listaArvoreMapaEstrategicoConfig.isEmpty())
			request.getSession().setAttribute("listaArvoreMapaEstrategicoConfig",listaArvoreMapaEstrategicoConfig);	
	}
	
	/*Altera dados da tarefa, caso o usuario abra um popup, sem salvar os dados digitados.*/
	public static TarefaTO alterarTarefa(HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException, ExceptionNegocioPRO{
		DataUtil dataUtil = new DataUtil();
		Timestamp dataHora = dataUtil.getTimestamp();
		TarefaTO tarefaTO = new TarefaTO();
		TarefaBO tarefaBO = new TarefaBO();
		TarefaTO tarefaTOSession = (TarefaTO) request.getSession().getAttribute("tarefaTO");
		UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		
		String nome = request.getParameter("nome");
		String dtPrazo = request.getParameter("dtPrazo");
		String codEstado = request.getParameter("codEstado");
		String codCriticidade = request.getParameter("codCriticidade");
		String dtInicio = request.getParameter("dtInicio");
		String dtFim = request.getParameter("dtFim");
		String txtDescricao = request.getParameter("txtDescricao");
		
		
		if (nome!=null){
			tarefaTO.setCodigo(tarefaTOSession.getCodigo());
			tarefaTO.setAnoCriacao(tarefaTOSession.getAnoCriacao());
			tarefaTO.setNome(nome);
	   		tarefaTO.setDtLimitePrazo(dataUtil.getSQLDate(dtPrazo));
			tarefaTO.setCodEstado(Integer.parseInt(codEstado));
			tarefaTO.setCodCriticidade(Integer.parseInt(codCriticidade));
			tarefaTO.setDtInicio(dataUtil.getSQLDate(dtInicio));
			tarefaTO.setDtFim(dataUtil.getSQLDate(dtFim));
			tarefaTO.setTextoSolicitacao(txtDescricao);
	   		tarefaTO.setTsAlteracao(dataHora);
			tarefaTO.setCodUsuAlteracao(usuario.getIdUsuario());
			tarefaBO.alterar(tarefaTO);
		}
		
		return tarefaTO;
	}

	@SuppressWarnings("unchecked")
	public static Collection sortCollection(Collection listaColecao,String campoOrdenar) throws Exception{
		QSortAlgorithm sort = new QSortAlgorithm();
		Vector listaVetor = new Vector((Collection) listaColecao);
		sort.sortString(listaVetor ,campoOrdenar);
		Collection listaRetorno = new ArrayList(listaVetor);
		return listaRetorno;
	}
	
	public static void consultarTarefaMapaConfiguracao(TarefaTO tarefaTO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		/*Recupera Tarefas do usuario logado*/
		   UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		   TarefaBO tarefaBO = new TarefaBO();
		   tarefaTO.setCodUsuSolicitante(usuario.getIdUsuario());
		   Collection listaTarefas = tarefaBO.consultarTarefas(tarefaTO);
		   if (!listaTarefas.isEmpty())
			   request.getSession().setAttribute("listaTarefas",Util.sortCollection(listaTarefas,"nome"));	
	}

	public static void consultarTarefaProcessoConfiguracao(TarefaTO tarefaTO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		/*Recupera Tarefas do usuario logado*/
		   UsuarioTO usuario = UsuarioBO.getUsuarioTO(response,request);
		   TarefaBO tarefaBO = new TarefaBO();
		   tarefaTO.setCodUsuSolicitante(usuario.getIdUsuario());
		   Collection listaTarefas = tarefaBO.consultarTarefas(tarefaTO);
		   if (!listaTarefas.isEmpty())
			   request.getSession().setAttribute("listaTarefas",Util.sortCollection(listaTarefas,"nome"));	
	}


}
