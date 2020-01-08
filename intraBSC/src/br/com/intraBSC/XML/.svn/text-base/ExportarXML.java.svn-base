package br.com.intraBSC.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.CausaEfeitoTO;
import br.com.intraBSC.modelo.IndicadorFatoTO;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.MetaTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PeriodicidadeTO;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.modelo.TemaTO;
import br.com.intraBSC.modelo.TipoPerspectivaTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.CausaEfeitoBO;
import br.com.intraBSC.negocio.IndicadorBO;
import br.com.intraBSC.negocio.IndicadorFatoBO;
import br.com.intraBSC.negocio.MetaBO;
import br.com.intraBSC.negocio.ObjetivoBO;
import br.com.intraBSC.negocio.PeriodicidadeBO;
import br.com.intraBSC.negocio.PerspectivaBO;
import br.com.intraBSC.negocio.TemaBO;
import br.com.intraBSC.negocio.TipoPerspectivaBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraPRO.excecoes.ExceptionNegocioPRO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.ParticipanteBO;
import br.com.intraPRO.negocio.TarefaBO;


/**
 * Classe que gera o XML de um determinado mapa selecionado.
 * @author Tiago
 *
 */
public class ExportarXML {
	
	private MapaEstrategicoTO mapaPrincipal;
	
	private Collection<PerspectivaTO> listaPerspectivas;
	
	private Collection<ObjetivoTO> listaObjetivo;
	
	private Collection<IndicadorTO> listaIndicadores;
	
	private Collection<MetaTO> listaMeta;
	
	private HashMap<Integer, UsuarioTO> listaUsuarios = new HashMap<Integer, UsuarioTO>();
	
	private HashMap<Integer, TemaTO> listaTemas = new HashMap<Integer, TemaTO>();
	
	private HashMap<Integer, CausaEfeitoTO> listaCausaEfeito = new HashMap<Integer, CausaEfeitoTO>();
	 
	private static final ResourceBundle CONFIG = ResourceBundle.getBundle("br.com.intraBSC.XML.gerarxml");
	
	private static Integer contLinkageId = 0;
	
	Document document = DocumentHelper.createDocument();
	
	Element bscDoc = document.addElement( "BSCDOC" );
	
	/**
	 * Construtor
	 */
	public void exportarXML(){
	}
	
	/**
	 * Construtor
	 * @param _mapaEstrategicoTO
	 * @throws ExceptionNegocioBSC 
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws ExceptionNegocioPRO 
	 */
	public void exportarXML(MapaEstrategicoTO to, OutputStream out) throws ExceptionNegocioBSC, IOException, ExceptionNegocioPRO, ParseException{
		setMapaPrincipal(to);
		inicializarListaPerspectiva();
		montarXML(out);
	}
	
	/**
	 * Metodo que cria o arquivo e cabecalho do XML
	 * @param document
	 * @param codMapa
	 * @throws IOException
	 * @throws ExceptionNegocioBSC
	 * @throws ParseException 
	 * @throws ExceptionNegocioPRO 
	 */
	
	@SuppressWarnings("unused")
	private OutputStream montarXML(OutputStream out) throws IOException, ExceptionNegocioBSC, ExceptionNegocioPRO, ParseException {
		
        XMLWriter writer = new XMLWriter(new FileWriter( CONFIG.getString("gerarxml.prefixo") + getMapaPrincipal().getNome() + CONFIG.getString("gerarxml.extensao") ));
        OutputFormat format = OutputFormat.createPrettyPrint();
        writer = new XMLWriter( out, format );
        criarArquivo();
        writer.write( document );
        writer.close();
		return out;
    }

	
	/**
	 * Metodo para pesquisar dados da perspectiva
	 * @param _mapaEstrategicoTO
	 * @throws ExceptionNegocioBSC
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void inicializarListaPerspectiva() throws ExceptionNegocioBSC {
		PerspectivaBO perspectivaBO = new PerspectivaBO();
		PerspectivaTO perspectivaTO = new PerspectivaTO();
		perspectivaTO.setIdMapa(getMapaPrincipal().getId());
		setListaPerspectivas(perspectivaBO.consultarVarios(perspectivaTO));
	}
	
	/**
	 * Metodo para pesquisar dados de Objetivo
	 * @param _mapaEstrategicoTO
	 * @throws ExceptionNegocioBSC
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void inicializarListaObjetivo() throws ExceptionNegocioBSC{
		ObjetivoTO objetivoTO = new ObjetivoTO();
		ObjetivoBO objetivoBO = new ObjetivoBO();
		objetivoTO.setIdMapa(getMapaPrincipal().getId());
		setListaObjetivo(objetivoBO.consultarVarios(objetivoTO));
	}
	
	/**
	 * Metodo para pesquisar dados de Objetivo
	 * @param _mapaEstrategicoTO
	 * @throws ExceptionNegocioBSC
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void inicializarListaIndicador() throws ExceptionNegocioBSC{
		IndicadorTO indicadorTO = new IndicadorTO();
		IndicadorBO indicadorBO = new IndicadorBO();
		indicadorTO.setIdMapa(getMapaPrincipal().getId());
		setListaIndicadores(indicadorBO.consultarArvoreVisualizacao(indicadorTO));
	}
	
	/**
	 * Metodo para pesquisar dados de Objetivo
	 * @param _mapaEstrategicoTO
	 * @throws ExceptionNegocioBSC
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void inicializarListaMeta(IndicadorTO indicadorTO) throws ExceptionNegocioBSC{
		MetaTO metaTO = new MetaTO();
		MetaBO metaBO = new MetaBO();
		metaTO.setIdIndicador(indicadorTO.getId());
		setListaObjetivo(metaBO.consultarVarios(metaTO));
	}
	
	
	/**
	 * Metodo que cria o elemento principal BSC
	 * @param document
	 * @param codMapa
	 * @throws ExceptionNegocioBSC
	 * @throws ParseException 
	 * @throws ExceptionNegocioPRO 
	 */
	@SuppressWarnings("unused")
	private void criarArquivo() throws ExceptionNegocioBSC, ExceptionNegocioPRO, ParseException{
		bscDoc.addAttribute("language", "PT");
		criarElementoMapaEstrategico(getMapaPrincipal());
	}
	
	/**
	 * Metodo que cria os elementos do nó BSC
	 * @param mapaEstrategicoTO
	 * @throws ExceptionNegocioBSC 
	 * @throws ParseException 
	 * @throws ExceptionNegocioPRO 
	 */
	@SuppressWarnings("unused")
	private void criarElementoMapaEstrategico(MapaEstrategicoTO to) throws ExceptionNegocioBSC, ExceptionNegocioPRO, ParseException{
		Element mapa = bscDoc.addElement( CONFIG.getString("gerarxml.bsc.element") )
    		.addAttribute( CONFIG.getString("gerarxml.bsc.id") , 
    				to.getId() == 0 ? "" : String.valueOf(to.getId()))
    		.addAttribute( CONFIG.getString("gerarxml.bsc.name") , to.getNome());
		
		montarTema();
		
		for (TemaTO _temaTO : getListaTemas().values()) {
			criarElementoTema(mapa, _temaTO);
		}
		
		for (PerspectivaTO _perspectivaTO : getListaPerspectivas()){
			criarElementoPerspectiva(mapa, _perspectivaTO);
		}
		
		criarElementoIniciativa(mapa, consultarTarefa(to));
		
		criarElementoLinkage(mapa);
		
		criarElementoUsuario(mapa, getListaUsuarios().values());
	}
	
	/**
	 * Metodo de criacao para o elemento de perspectiva
	 * @param elementPai
	 * @param perspectivaTO
	 * @throws ExceptionNegocioBSC 
	 * @throws ParseException 
	 * @throws ExceptionNegocioPRO 
	 */
	@SuppressWarnings("unused")
	private void criarElementoPerspectiva(Element elementPai, PerspectivaTO to)
		throws ExceptionNegocioBSC, ExceptionNegocioPRO, ParseException{
		Element perspectiva = elementPai.addElement(CONFIG.getString("gerarxml.perspectiva.element"))
    		.addAttribute( CONFIG.getString("gerarxml.perspectiva.id"), 
    				String.valueOf(to.getId()))
    		.addAttribute( CONFIG.getString("gerarxml.perspectiva.name"), to.getNome() == null ? "" : to.getNome())
    		.addAttribute( CONFIG.getString("gerarxml.perspectiva.perspectiveType"), 
    				consultarTipoPerspectiva(to.getTipoPerspectiva()).getNome())
    		.addAttribute( CONFIG.getString("gerarxml.perspectiva.sortOrder"), 
    				String.valueOf(to.getOrdem()))
    		.addAttribute( CONFIG.getString("gerarxml.perspectiva.ownerRef"), 
    				consultarUsuario(to.getResponsavel()).getNome());
		
		Element perspectivaDescricao = perspectiva.addElement(
				CONFIG.getString("gerarxml.perspectiva.description")); 
		perspectivaDescricao.setText(to.getDescricao() == null ? "" : to.getDescricao());
		
		criarElementoIniciativa(perspectiva, consultarTarefa(to));
		
		for (ObjetivoTO objetivoTO : getListaObjetivo()) {
			if (to.getId() == objetivoTO.getIdPerspectiva()) {
				criarElementoObjetivo(perspectiva, objetivoTO);
			}
		}
	}
		
	
	/**
	 * Metodo que cria o elemento tema.
	 * @param elementPai
	 * @param temaTO
	 * @throws ExceptionNegocioBSC 
	 */
	@SuppressWarnings("unused")
	private void criarElementoTema(Element elementPai, TemaTO to) throws ExceptionNegocioBSC{
		Element tema = elementPai.addElement( CONFIG.getString("gerarxml.theme.element") )
    		.addAttribute( CONFIG.getString("gerarxml.theme.id"), String.valueOf(to.getIdTema()))
    		.addAttribute( CONFIG.getString("gerarxml.theme.name"), to.getNomeTema() == null ? "" : to.getNomeTema())
    		.addAttribute( CONFIG.getString("gerarxml.theme.ownerRef"), 
    				consultarUsuario(to.getUsuario().getIdUsuario()).getNome());
		
		Element temaDescricao = tema.addElement(CONFIG.getString("gerarxml.theme.description")); 
		temaDescricao.setText(to.getDescricaoTema() == null ? "" : to.getDescricaoTema());
		
	}
	

	/**
	 * Metodo que cria o elemento objetivo.
	 * 
	 * @param elementPai
	 * 
	 * @param _objetivoTO
	 * 
	 * @throws ExceptionNegocioBSC 
	 * @throws ParseException 
	 * @throws ExceptionNegocioPRO 
	 */
	@SuppressWarnings("unused")
	private void criarElementoObjetivo(Element elementPai, ObjetivoTO to) 
										throws ExceptionNegocioBSC, ExceptionNegocioPRO, ParseException{
		Element objetivo = elementPai.addElement( CONFIG.getString("gerarxml.objective.element") )
    		.addAttribute( CONFIG.getString("gerarxml.objective.id"), 
    				String.valueOf(to.getId()))
    		.addAttribute( CONFIG.getString("gerarxml.objective.name"), to.getNome() == null ? "" : to.getNome())
    		.addAttribute( CONFIG.getString("gerarxml.objective.ownerRef"), 
    				consultarUsuario(to.getResponsavel()).getNome())
    		.addAttribute( CONFIG.getString("gerarxml.objective.theme.id"),
    				String.valueOf(to.getIdTema()));
		
		Element objetivoDescricao = objetivo.addElement(
				CONFIG.getString("gerarxml.objective.description")); 
		objetivoDescricao.setText(to.getDescricao() == null ? "" : to.getDescricao());
		
		inicializarListaIndicador();
		
		consultarCausaEfeito(to.getId());
		
		criarElementoIniciativa(objetivo, consultarTarefa(to));
		
		for (IndicadorTO indicadorTO : getListaIndicadores()){
			if (to.getId() == indicadorTO.getIdObjetivo()) {
				criarElementoIndicador(objetivo, indicadorTO);
			}
		}
	}
	
	
	/**
	 * Cria a tag de iniciativa
	 * 
	 * @param elementPai Elemento pai do XML
	 * 
	 * @param tarefaTO 
	 * 
	 * @throws ExceptionNegocioBSC
	 *  
	 * @throws ExceptionNegocioPRO 
	 */
	private void criarElementoIniciativa(Element elementPai, Collection<TarefaTO> lista) throws ExceptionNegocioBSC, ExceptionNegocioPRO {
		
		for(TarefaTO to : lista) {
			Element iniciativa = elementPai.addElement( CONFIG.getString("gerarxml.iniciativa.element") )
			.addAttribute( CONFIG.getString("gerarxml.iniciativa.id"),String.valueOf(to.getCodigo()))
			.addAttribute( CONFIG.getString("gerarxml.iniciativa.name"), to.getNome() == null ? "" : to.getNome())
			.addAttribute( CONFIG.getString("gerarxml.iniciativa.startdate"),
						String.valueOf(to.getDtInicio()))
			.addAttribute( CONFIG.getString("gerarxml.iniciativa.enddate"),
						String.valueOf(to.getDtFim()))
			.addAttribute( CONFIG.getString("gerarxml.iniciativa.ownerref"),
					consultarUsuario(to.getCodUsuSolicitante()).getNome());
			
			Element indicadorDescricao = iniciativa.addElement(
					CONFIG.getString("gerarxml.iniciativa.description")); 
			indicadorDescricao.setText(to.getTextoSolicitacao() == null ? "" : to.getTextoSolicitacao());
			
			criaElementoParticipantes(iniciativa, consultarParticipantes(to));
		}
	}
	
	/**
	 * Cria tag de AdditionalResources
	 * 
	 * @param elementoPai Elemento Pai
	 * 
	 * @param lista Lista de participantes
	 */
	private void criaElementoParticipantes(Element elementoPai, Collection<ParticipanteTO> lista) {
		for (ParticipanteTO to : lista) {
			elementoPai.addElement(CONFIG.getString("gerarxml.iniciativa.additionalresources"))
			.addAttribute( CONFIG.getString("gerarxml.iniciativa.additionalresources.name"), 
					to.getNome() == null ? "" : to.getNome());
		}
	}
	
	/**
	 * Metodo que cria o elemento Indicador.
	 * 
	 * @param elementPai
	 * 
	 * @param _objetivoTO
	 * @throws ExceptionNegocioBSC 
	 * @throws ParseException 
	 * @throws ExceptionNegocioPRO 
	 */
	@SuppressWarnings("unused")
	private void criarElementoIndicador(Element elementPai, IndicadorTO to) 
										throws ExceptionNegocioBSC, ExceptionNegocioPRO, ParseException{
		Element indicador = elementPai.addElement( CONFIG.getString("gerarxml.measure.element") )
    		.addAttribute( CONFIG.getString("gerarxml.measure.id"), 
    				String.valueOf(to.getId()))
    		.addAttribute(CONFIG.getString("gerarxml.measure.name"), to.getNome() == null ? "" : to.getNome())
    		.addAttribute(CONFIG.getString("gerarxml.measure.updateFrequency"), 
    				consultarPeriodicidade(to.getPeriodicidade()).getNome())
    		.addAttribute( CONFIG.getString("gerarxml.measure.ownerRef"), 
    				consultarUsuario(to.getResponsavelIndicador()).getNome());
		
		Element indicadorDescricao = indicador.addElement(
				CONFIG.getString("gerarxml.measure.description")); 
		indicadorDescricao.setText(to.getDescricao() == null ? "" : to.getDescricao());
		
		criarElementoIniciativa(indicador, consultarTarefa(to));
		
		setListaMeta(consultarMetas(to.getId()));
		
		for (MetaTO metaTO : getListaMeta()) {
			criarElementoMeta(indicador, metaTO);
		}
	}
	
	/**
	 * Metodo para criar o elemento de meta
	 * 
	 * @param elementPai
	 * 
	 * @param _metaTO
	 * @throws ExceptionNegocioBSC 
	 */
	@SuppressWarnings("unused")
	private void criarElementoMeta(Element elementPai, MetaTO to) throws ExceptionNegocioBSC{
		Element meta = elementPai.addElement( CONFIG.getString("gerarxml.target.element") )
    		.addAttribute( CONFIG.getString("gerarxml.target.id"), String.valueOf(to.getId()))
    		.addAttribute( CONFIG.getString("gerarxml.target.name"), to.getNome() == null ? "" : to.getNome())
    		.addAttribute( CONFIG.getString("gerarxml.target.targetValueUp"), 
    					 	String.valueOf(to.getLimiteSuperior()))
    		.addAttribute( CONFIG.getString("gerarxml.target.targetValueDown"), 
    						String.valueOf(to.getLimiteInferior()).trim())
    		.addAttribute( CONFIG.getString("gerarxml.target.actualValue"), 
    				String.valueOf(consultarValorMeta(to.getIdIndicador()).getValor()))
    		.addAttribute( CONFIG.getString("gerarxml.target.ownerRef"), 
    				consultarUsuario(to.getResponsavel()).getNome());
		
		Element metaDescricao = meta.addElement(CONFIG.getString("gerarxml.target.description")); 
		metaDescricao.setText(to.getDescricao() == null ? "" : to.getDescricao());
	}
	
	/**
	 * Metodo q cria tag de usuario
	 * 
	 * @param elementPai
	 * 
	 * @param lista
	 */
	private void criarElementoUsuario(Element elementPai, Collection<UsuarioTO> lista) {
		for (UsuarioTO to : lista) {
			elementPai.addElement(CONFIG.getString("gerarxml.usuario.element"))
    		.addAttribute( CONFIG.getString("gerarxml.usuario.id"), 
    				String.valueOf(to.getIdUsuario()))
    		.addAttribute( CONFIG.getString("gerarxml.usuario.name"), to.getNome() == null ? "" : to.getNome())
    		.addAttribute( CONFIG.getString("gerarxml.usuario.email"),to.getEmail() == null ? "" : to.getEmail());
		}
	}
	
	/**
	 * Metodo que cria a tag de LINKAGE
	 * 
	 * @param elementPai Tag pai
	 * 
	 * @param lista Lista com causas e efeitos
	 */
	private void criarElementoLinkage(Element elementPai) {
		HashMap<String, CausaEfeitoTO> listaIncluidos = new HashMap<String, CausaEfeitoTO>();
		
		for (Iterator<Integer> iter = getListaCausaEfeito().keySet().iterator(); iter.hasNext();) {
			Integer id = iter.next();
			CausaEfeitoTO to = getListaCausaEfeito().get(id);
		
			if (!listaIncluidos.containsKey(to.getCausaId() + "" + to.getEfeitoId())) {
			elementPai.addElement(CONFIG.getString("gerarxml.linkage.element"))
    		.addAttribute( CONFIG.getString("gerarxml.linkage.id"), String.valueOf(id))
    		.addAttribute( CONFIG.getString("gerarxml.usuario.name"),
    				to.getNomeObjetivo() == null ? "" : to.getNomeObjetivo())
    		.addAttribute( CONFIG.getString("gerarxml.linkage.causeRef"), 
    				String.valueOf(to.getCausaId()))
			.addAttribute( CONFIG.getString("gerarxml.linkage.effectRef"), 
					String.valueOf(to.getEfeitoId()))
			.addAttribute( CONFIG.getString("gerarxml.linkage.interaction"), to.getInteracao())
			.addAttribute( CONFIG.getString("gerarxml.linkage.degreeStrength"), to.getIntensidade());
			
			}
			listaIncluidos.put(to.getCausaId() + "" + to.getEfeitoId(), to);
		}
	}

	/**
	 * Consulta dados da tarefa
	 * 
	 * @param id Identificador da tarefa
	 * 
	 * @return Lista de tarefas vinculadas
	 * 
	 * @throws ParseException
	 *  
	 * @throws ExceptionNegocioPRO 
	 */
	@SuppressWarnings("unchecked")
	private Collection<TarefaTO> consultarTarefa(Object objeto) throws ExceptionNegocioPRO, ParseException {
		TarefaTO to = new TarefaTO();
		
		if (objeto instanceof IndicadorTO) {
			to.setCodIndicador(((IndicadorTO) objeto).getId());
		} else if (objeto instanceof ObjetivoTO) {
			to.setCodObjetivo(((ObjetivoTO) objeto).getId());
		} else if (objeto instanceof PerspectivaTO) {
			to.setCodPerspectiva(((PerspectivaTO) objeto).getId());
		} else if (objeto instanceof MapaEstrategicoTO) {
			to.setCodMapa(((MapaEstrategicoTO) objeto).getId());
		}
		return new TarefaBO().consultarTarefaFerramentaConfiguracao(to);
	}
	
	
	/**
	 * Consulta os participantes de uma iniciativa
	 * 
	 * @param tarefaTO
	 * 
	 * @return Lista de participantes
	 * 
	 * @throws ExceptionNegocioPRO
	 */
	@SuppressWarnings("unchecked")
	private Collection<ParticipanteTO> consultarParticipantes(TarefaTO tarefaTO) throws ExceptionNegocioPRO {
		ParticipanteTO participanteTO = new ParticipanteTO();
		ParticipanteBO participanteBO = new ParticipanteBO();
		participanteTO.setAnoCriacao(tarefaTO.getAnoCriacao());
		participanteTO.setCodTarefa(tarefaTO.getCodigo());
		
		return participanteBO.consultarVariosExecutante(participanteTO);
	}
	
	/**
	 * Consultar dados de periodicidade
	 * 
	 * @param codigo Codigo da Periodicidade
	 * 
	 * @return Periodicidade 
	 * 
	 * @throws ExceptionNegocioBSC 
	 */
	private PeriodicidadeTO consultarPeriodicidade(Integer codigo) throws ExceptionNegocioBSC {
		PeriodicidadeTO to = new PeriodicidadeTO();
		to.setId(codigo.intValue());
		return new PeriodicidadeBO().consultarUm(to);
	}
	
	/**
	 * Consulta lista de metas do indicador
	 * 
	 * @param idIndicador Codigo do Indicador
	 * 
	 * @return Lista de metas do indicador
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	@SuppressWarnings("unchecked")
	private Collection<MetaTO> consultarMetas(Integer idIndicador) throws ExceptionNegocioBSC {
		MetaTO to = new MetaTO();
		to.setIdIndicador(idIndicador.intValue());
		return new MetaBO().consultarVarios(to);
	}
	
	/**
	 * Monta lista de temas
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private void montarTema() throws ExceptionNegocioBSC {
		inicializarListaObjetivo();
		for ( ObjetivoTO to : getListaObjetivo()) {
			TemaTO temaTo = new TemaTO();
			temaTo = consultarTema(to.getId());
			if (temaTo.getIdTema() != 0) {
				to.setIdTema(temaTo.getIdTema());
				setListaTemas(temaTo);
			}
		}
	}
	
	/**
	 * 
	 * @param idIndicador Id do indicador
	 * 
	 * @return Indicador Fato(Valor da meta)
	 * @throws ExceptionNegocioBSC 
	 */
	private IndicadorFatoTO consultarValorMeta(Integer idIndicador) throws ExceptionNegocioBSC {
		IndicadorFatoTO to = new IndicadorFatoTO();
		to.setId(idIndicador);
		return new IndicadorFatoBO().consultarUltimoIndicadorFato(to);
	}
	
	/**
	 * Consultar dados do Tema
	 * 
	 * @param codigo Codigo do Objetivo
	 * 
	 * @return TemaTO
	 * 
	 * @throws ExceptionNegocioBSC 
	 */
	private TemaTO consultarTema(Integer codigo) throws ExceptionNegocioBSC {
		TemaTO to = new TemaTO();
		to.setIdObjetivo(codigo.intValue());
		return new TemaBO().consultarUmPorObjetivo(to);
	} 
	
	/**
	 * Consulta de dados da tabela de causa e efeito
	 * 
	 * @param idObjetivo Identificador do objetivo
	 * 
	 * @return Causa e efeito
	 * @throws ExceptionNegocioBSC 
	 */
	@SuppressWarnings("unchecked")
	private void consultarCausaEfeito(Integer idObjetivo) throws ExceptionNegocioBSC {
		Collection<CausaEfeitoTO> retorno = new ArrayList<CausaEfeitoTO>();
		CausaEfeitoTO to = new CausaEfeitoTO();
		/*Consulta Causa*/
		to.setCausaId(idObjetivo.intValue());
		retorno.addAll(new CausaEfeitoBO().consultarVarios(to));
		
		/*Consulta de Efeito*/
		to.setEfeitoId(idObjetivo.intValue());
		to.setCausaId(0);
		retorno.addAll(new CausaEfeitoBO().consultarVarios(to));
		
		for (CausaEfeitoTO causaEfeito : retorno) {
			setListaCausaEfeito(causaEfeito);
		}
	}
	
	
	/**
	 * Metodo que consulta dados de tipo de perspectiva
	 * 
	 * @param codigo Codigo do tipo de perspectiva
	 * 
	 * @return Tipo de perspectiva
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private TipoPerspectivaTO consultarTipoPerspectiva(Integer codigo) throws ExceptionNegocioBSC {
		TipoPerspectivaTO to = new TipoPerspectivaTO();
		to.setId(codigo.intValue());
		return new TipoPerspectivaBO().consultarUm(to);
	}
	
	/**
	 * Metodo que consulta dados de um usuario
	 * 
	 * @param codigo Codigo do usuario
	 * 
	 * @return Retorno um usuario
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private UsuarioTO consultarUsuario(Integer codigo) throws ExceptionNegocioBSC {
		UsuarioTO to = new UsuarioTO();
		if (codigo != 0) {
			to.setIdUsuario(codigo.intValue());
			to = new UsuarioBO().consultarUm(to);
			setListaUsuarios(to);
			return to;
		}
		to.setNome("");
		return to;
	}
	
	/**
	 * @return the listaIndicadores
	 */
	public Collection<IndicadorTO> getListaIndicadores() {
		return listaIndicadores;
	}

	/**
	 * @param _listaIndicadores the listaIndicadores to set
	 */
	public void setListaIndicadores(Collection<IndicadorTO> _listaIndicadores) {
		listaIndicadores = _listaIndicadores;
	}

	/**
	 * @return the listaMeta
	 */
	public Collection<MetaTO> getListaMeta() {
		return listaMeta;
	}

	/**
	 * @param _listaMeta the listaMeta to set
	 */
	public void setListaMeta(Collection<MetaTO> _listaMeta) {
		listaMeta = _listaMeta;
	}

	/**
	 * @return the listaObjetivo
	 */
	public Collection<ObjetivoTO> getListaObjetivo() {
		return listaObjetivo;
	}

	/**
	 * @param _listaObjetivo the listaObjetivo to set
	 */
	public void setListaObjetivo(Collection<ObjetivoTO> _listaObjetivo) {
		listaObjetivo = _listaObjetivo;
	}

	/**
	 * @return the listaPerspectivas
	 */
	public Collection<PerspectivaTO> getListaPerspectivas() {
		return listaPerspectivas;
	}

	/**
	 * @param _listaPerspectivas the listaPerspectivas to set
	 */
	public void setListaPerspectivas(Collection<PerspectivaTO> _listaPerspectivas) {
		listaPerspectivas = _listaPerspectivas;
	}


	public MapaEstrategicoTO getMapaPrincipal() {
		return mapaPrincipal;
	}

	public void setMapaPrincipal(MapaEstrategicoTO mapaPrincipal) {
		this.mapaPrincipal = mapaPrincipal;
	}

	/**
	 * @return O valor do atributo listaUsuarios
	 */
	public HashMap<Integer, UsuarioTO> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param _listaUsuarios atribui um valor ao atributo listaUsuarios
	 */
	public void setListaUsuarios(UsuarioTO usuario) {		
		listaUsuarios.put(usuario.getIdUsuario(), usuario) ;
	}

	/**
	 * @return O valor do atributo listaTemas
	 */
	public HashMap<Integer, TemaTO> getListaTemas() {
		return listaTemas;
	}

	/**
	 * @param _listaTemas atribui um valor ao atributo listaTemas
	 */
	public void setListaTemas(TemaTO tema) {
		listaTemas.put(tema.getIdTema(), tema);
	}

	/**
	 * @return O valor do atributo listaCausaEfeito
	 */
	public HashMap<Integer, CausaEfeitoTO> getListaCausaEfeito() {
		return listaCausaEfeito;
	}

	/**
	 * @param _listaCausaEfeito atribui um valor ao atributo listaCausaEfeito
	 */
	public void setListaCausaEfeito(CausaEfeitoTO causaEfeito) {
		listaCausaEfeito.put(++contLinkageId, causaEfeito);
	}
}
