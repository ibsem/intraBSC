package br.com.intraBSC.XML;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.CausaEfeitoTO;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.MetaTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PeriodicidadeTO;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.modelo.TemaTO;
import br.com.intraBSC.modelo.TipoPerspectivaTO;
import br.com.intraBSC.negocio.CausaEfeitoBO;
import br.com.intraBSC.negocio.IndicadorBO;
import br.com.intraBSC.negocio.MapaEstrategicoBO;
import br.com.intraBSC.negocio.MetaBO;
import br.com.intraBSC.negocio.ObjetivoBO;
import br.com.intraBSC.negocio.PeriodicidadeBO;
import br.com.intraBSC.negocio.PerspectivaBO;
import br.com.intraBSC.negocio.TemaBO;
import br.com.intraBSC.negocio.TipoPerspectivaBO;
import br.com.intraBSC.negocio.UsuarioBO;
import br.com.intraBSC.persistencia.FabricaDAO;

import com.ibatis.dao.client.DaoManager;

/**
 * Classe de importar dados de XML para incluir novo mapa estrategico
 * 
 * @author Tiago Trindade Stangarlin
 * 
 *         Data:31/01/2011
 * 
 */
public class ImportarXml {

	private InputStream arquivoXml;
	
	private MapaEstrategicoTO mapaTo = new MapaEstrategicoTO();
	
	private TemaTO temaTo = new TemaTO();
	
	private PerspectivaTO perspectivaTo = new PerspectivaTO();
	
	private ObjetivoTO objetivoTo = new ObjetivoTO();
	
	private IndicadorTO indicadorTo = new IndicadorTO();
	
	private HashMap<Integer, ObjetivoTO> objetivos = new HashMap<Integer, ObjetivoTO>();

	private static final ResourceBundle CONFIG = ResourceBundle.getBundle("br.com.intraBSC.XML.gerarxml");
	
	private HashMap<String, TipoPerspectivaTO> tipoPerspectivas = new HashMap<String, TipoPerspectivaTO>();
	
	private HashMap<String, PeriodicidadeTO> periodicidades = new HashMap<String, PeriodicidadeTO>();
	

	/**
	 * Constructor
	 */
	public ImportarXml() {
	}

	/**
	 * Constructor
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws ExceptionNegocioBSC 
	 */
	public ImportarXml(InputStream input) throws ParserConfigurationException, SAXException, 
																IOException, ExceptionNegocioBSC {
		setArquivoXml(input);
		executarImportacao();
	}

	/**
	 * Metodo que inicia a importação dos dados do XML
	 * 
	 * @throws ParserConfigurationException
	 * 
	 * @throws SAXException
	 * 
	 * @throws IOException
	 */
	private void executarImportacao() throws ParserConfigurationException, SAXException, 
																IOException, ExceptionNegocioBSC{
		
		DaoManager daoManager = FabricaDAO.getDaoManager();
		daoManager.startTransaction();
		try {
//			throw new ExceptionNegocioBSC("ERRO - IMPORTACAO XML");
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(getArquivoXml());
			
			NodeList listaMapas = doc.getElementsByTagName(
											CONFIG.getString("gerarxml.bsc.element"));
			
			for (int s = 0; s < listaMapas.getLength(); s++) {
				Node firstPersonNode = listaMapas.item(s);
				incluirMapa(firstPersonNode.getAttributes().getNamedItem(
											CONFIG.getString("gerarxml.bsc.name")).getNodeValue());
				if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {
					Element firstElement = (Element) firstPersonNode;

					extrairTema(firstElement);
					extrairPerspectiva(firstElement);
					extrairCausaEfeito(firstElement);
				}
			}
			daoManager.commitTransaction();
			System.out.println("XML Importado com sucesso.");
		} catch (Exception e) {
			throw new ExceptionNegocioBSC("Ocorreu um erro na importação: "+e.getMessage());
		}finally{
			daoManager.endTransaction();			
		}
	}
	//**********************************************************************************************
	
	//Metodos referentes ao Mapa********************************************************************
	/**
	 * Inclui dados do mapa
	 * 
	 * @param nome String
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private void incluirMapa(String nome) throws ExceptionNegocioBSC{
		mapaTo.setNome(nome);
		mapaTo.setAtivo(1);
		mapaTo.setIdResponsavel(UsuarioBO.getUsuarioTO().getIdUsuario());
		MapaEstrategicoBO bo = new MapaEstrategicoBO();
		try {
			bo.incluirXml(mapaTo);
		} catch (Exception e) {
			throw new ExceptionNegocioBSC("Erro na inclusão do Mapa.");
		}
	}
	//**********************************************************************************************
	
	//Metodos referentes a perspectiva**************************************************************
	/**
	 * Estrair e incluir dados de perspectiva
	 * @throws ExceptionNegocioBSC 
	 */
	private void extrairPerspectiva(Element firstElement) throws ExceptionNegocioBSC {
		NodeList firstNameList = firstElement.getElementsByTagName(
												CONFIG.getString("gerarxml.perspectiva.element"));
		for (int s = 0; s < firstNameList.getLength(); s++) {
			Element perspectivaElement = (Element) firstNameList.item(s);
			PerspectivaTO entidade = new PerspectivaTO();

			verificarExisteTipoPerspectiva(perspectivaElement);
			String tipoPerspectiva = perspectivaElement.getAttribute(CONFIG.getString("gerarxml.perspectiva.perspectiveType"));
			entidade.setTipoPerspectiva(tipoPerspectivas.get(tipoPerspectiva).getId());
			entidade.setDescricao(recuperarValorNode(
												CONFIG.getString("gerarxml.perspectiva.description"), 
												perspectivaElement));
			
			entidade.setNome(perspectivaElement.getAttribute(
											CONFIG.getString("gerarxml.perspectiva.name")));
			entidade.setAtivo(1);
			entidade.setOrdem(new Integer(perspectivaElement.getAttribute(
											CONFIG.getString("gerarxml.perspectiva.sortOrder"))));
			entidade.setIdMapa(getMapaTo().getId());
			incluirPerspectiva(entidade);
			
			extrairObjetivo(perspectivaElement);
		}
	}
	
	/**
	 * Incluir perspectiva
	 * 
	 * @param perspectiva PerspectivaTO
	 * @throws ExceptionNegocioBSC 
	 */
	private void incluirPerspectiva(PerspectivaTO perspectiva) throws ExceptionNegocioBSC {
		PerspectivaBO bo = new PerspectivaBO();
		try {
			bo.incluir(perspectiva);
		} catch (Exception e) {
			throw new ExceptionNegocioBSC("Erro ao incluir Perspectiva. " + e.getMessage());
		}
		setPerspectivaTo(perspectiva);
	}
	//**********************************************************************************************
	
	//Metodos referentes ao tema********************************************************************
	
	/**
	 * Metodo que extrai dados de objetivo
	 * @throws ExceptionNegocioBSC 
	 */
	private void extrairObjetivo(Element firstElement) throws ExceptionNegocioBSC {
		NodeList firstNameList = firstElement.getElementsByTagName(
				CONFIG.getString("gerarxml.objective.element"));
		for (int s = 0; s < firstNameList.getLength(); s++) {
			Element objetivoElement = (Element) firstNameList.item(s);
			ObjetivoTO entidade = new ObjetivoTO();
			
			Integer idOriginal = new Integer(objetivoElement.getAttribute(
													CONFIG.getString("gerarxml.objective.id")));
			
			entidade.setDescricao(recuperarValorNode(
							CONFIG.getString("gerarxml.objective.description"), objetivoElement));
			entidade.setAtivo(1);
			entidade.setNome(objetivoElement.getAttribute(
					CONFIG.getString("gerarxml.objective.name")));
			entidade.setLinha(1);
			entidade.setColuna(1);
			entidade.setIdPerspectiva(getPerspectivaTo().getId());
			entidade.setIdTema(getTemaTo().getIdTema());
			
			incluirObjetivo(entidade, idOriginal);
			extrairIndicador(objetivoElement);
		}
	}
	
	/**
	 * Incluir Objetivo
	 * 
	 * @param entidade ObjetivoTO
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private void incluirObjetivo(ObjetivoTO entidade, Integer idOriginal) throws ExceptionNegocioBSC {
		ObjetivoBO bo = new ObjetivoBO();
		try {
			bo.incluir(entidade);
		} catch (Exception e) {
			throw new ExceptionNegocioBSC("Erro ao incluir Objetivo - "+entidade.getNome()+". " + e.getMessage());
		}
		setObjetivoTo(entidade);
		objetivos.put(idOriginal, entidade);
	}
	//**********************************************************************************************

	//Metodos referentes ao Indicador***************************************************************
	/**
	 * Metodo que estrai dados de indicador.
	 * @throws ExceptionNegocioBSC 
	 */
	private void extrairIndicador(Element firstElement) throws ExceptionNegocioBSC {
		NodeList firstNameList = firstElement.getElementsByTagName(
													CONFIG.getString("gerarxml.measure.element"));
		
		for (int s = 0; s < firstNameList.getLength(); s++) {
			Element indicadorElement = (Element) firstNameList.item(s);
			IndicadorTO entidade = new IndicadorTO();
			
			entidade.setDescricao(recuperarValorNode(
							CONFIG.getString("gerarxml.measure.description"), indicadorElement));
			entidade.setAtivo(1);
			entidade.setNome(indicadorElement.getAttribute(
														CONFIG.getString("gerarxml.measure.name")));
			entidade.setIdObjetivo(getObjetivoTo().getId());
			
			String nomePeriodicidade = indicadorElement.getAttribute(
											CONFIG.getString("gerarxml.measure.updateFrequency"));
			verificarExistePeriodicidade(nomePeriodicidade);
			entidade.setPeriodicidade(periodicidades.get(nomePeriodicidade).getId());
			
			incluirIndicador(entidade);
			extrairMeta(indicadorElement);
		}
	}
	/**
	 * Realiza a inclusao de indicadores.
	 * 
	 * @param entidade IndicadorTO
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private void incluirIndicador(IndicadorTO entidade)  throws ExceptionNegocioBSC  {
		IndicadorBO bo = new IndicadorBO();
		try {
			bo.incluir(entidade);
		} catch (Exception e) {
			throw new ExceptionNegocioBSC("Erro ao incluir o Indicador "+ entidade.getNome() +". " + e.getMessage());
		}
		setIndicadorTo(entidade);
	}
	//**********************************************************************************************
	
	//Metodos referentes a Meta*********************************************************************
	/**
	 * Extrai dados da Meta
	 * @throws ExceptionNegocioBSC 
	 */
	private void extrairMeta(Element firstElement) throws ExceptionNegocioBSC {
		NodeList firstNameList = firstElement.getElementsByTagName(
													CONFIG.getString("gerarxml.target.element"));

		for (int s = 0; s < firstNameList.getLength(); s++) {
			Element metaElement = (Element) firstNameList.item(s);
			MetaTO entidade = new MetaTO();
			
			entidade.setDescricao(recuperarValorNode(
							CONFIG.getString("gerarxml.target.description"), metaElement));
			
			entidade.setAtivo("1");
			entidade.setNome(metaElement.getAttribute(
											CONFIG.getString("gerarxml.target.name")));
			entidade.setLimiteInferior(new Double(metaElement.getAttribute(
											CONFIG.getString("gerarxml.target.targetValueDown"))));
			
			entidade.setLimiteSuperior(new Double(metaElement.getAttribute(
											CONFIG.getString("gerarxml.target.targetValueUp"))));
			
			entidade.setIdIndicador(getIndicadorTo().getId());
			entidade.setInversaoSinal(2);
			incluirMeta(entidade);
		}
	}
	
	/**
	 * Metodo que realiza a inclusao dos dados de Meta
	 * 
	 * @param entidade MetaTO
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private void incluirMeta(MetaTO entidade) throws ExceptionNegocioBSC  {
		MetaBO bo = new MetaBO();
		try {
			bo.incluir(entidade);
		} catch (Exception e) {
			throw new ExceptionNegocioBSC("Erro ao incluir Meta "+ entidade.getNome() +". " + e.getMessage());
		}
	}
	//**********************************************************************************************
	
	//Metodos referentes a Causa e Efeito***********************************************************
	/**
	 * Extrai dados da entidade CausaEfeito
	 * @throws ExceptionNegocioBSC 
	 */
	private void extrairCausaEfeito(Element firstElement) throws ExceptionNegocioBSC {
		NodeList firstNameList = firstElement.getElementsByTagName(
				CONFIG.getString("gerarxml.linkage.element"));

		for (int s = 0; s < firstNameList.getLength(); s++) {
			Element causaEfeitoElement = (Element) firstNameList.item(s);
			CausaEfeitoTO entidade = new CausaEfeitoTO();
			
			entidade.setCausaId(new Integer(
					causaEfeitoElement.getAttribute(CONFIG.getString("gerarxml.linkage.causeRef"))));
			
			entidade.setEfeitoId(new Integer(
					causaEfeitoElement.getAttribute(CONFIG.getString("gerarxml.linkage.effectRef"))));
			
			entidade.setIntensidade(causaEfeitoElement.getAttribute(
												CONFIG.getString("gerarxml.linkage.degreeStrength")));
			
			entidade.setInteracao(causaEfeitoElement.getAttribute(
												CONFIG.getString("gerarxml.linkage.interaction")));
			
			incluirCausaEfeito(entidade);
		}
	}
	
	/**
	 * Realiza a inclusao da entidade de CausaEfeito
	 * 
	 * @param entidade CausaEfeitoTO
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private void incluirCausaEfeito(CausaEfeitoTO entidade) throws ExceptionNegocioBSC  {
		CausaEfeitoBO bo = new CausaEfeitoBO();
		entidade.setCausaId(objetivos.get(entidade.getCausaId()).getId());
		entidade.setEfeitoId(objetivos.get(entidade.getEfeitoId()).getId());
		
		try {
			bo.incluir(entidade);
		} catch (ExceptionNegocioBSC e) {
			throw new ExceptionNegocioBSC("Erro ao incluir o tema." + e.getMessage());
		}
	}
	//**********************************************************************************************
	
	//Metodos referentes ao tema********************************************************************
	/**
	 * Metodo que percorre todos os temas e chama a inclusão
	 * 
	 * @param firstPersonElement Element
	 * @throws ExceptionNegocioBSC 
	 */
	private void extrairTema(Element firstPersonElement) throws ExceptionNegocioBSC {
		NodeList firstNameList = firstPersonElement.getElementsByTagName(
													CONFIG.getString("gerarxml.theme.element"));
		for (int s = 0; s < firstNameList.getLength(); s++) {
			Element temaElement = (Element) firstNameList.item(s);
			TemaTO tema = new TemaTO();
			tema.setNomeTema((temaElement.getAttribute(
													CONFIG.getString("gerarxml.theme.name"))));
			tema.setIdMapa(getMapaTo().getId());
			tema.setDescricaoTema(recuperarValorNode(
									CONFIG.getString("gerarxml.theme.description"), temaElement));
			incluirTema(tema);
		}
	}
	
	/**
	 * Realiza a inclusão do Tema
	 * 
	 * @param tema TemaTO
	 * @throws ExceptionNegocioBSC 
	 */
	private void incluirTema(TemaTO tema) throws ExceptionNegocioBSC{
		TemaBO bo = new TemaBO();
		try {
			bo.incluir(tema);
		} catch (Exception e) {
			throw new ExceptionNegocioBSC("Erro ao incluir o tema "+ tema.getNomeTema() +". " + e.getMessage());
		}
		setTemaTo(tema);
	}
	//**********************************************************************************************
	
	//Metodos Comum ********************************************************************************
	/**
	 * Recupera o valor de uma node.
	 * 
	 * @param tag String 
	 * 
	 * @paran element Element 
	 * 
	 * @return String
	 */
	private String recuperarValorNode(String tag, Element element) {
		NodeList description = element.getElementsByTagName(tag);
		Element descriptionElement = (Element) description.item(0);
		return descriptionElement.getFirstChild().getNodeValue();
	}
	
	/**
	 * Consulta dados da Periodicidade pelo nome
	 * 
	 * @param nome String 
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private void verificarExistePeriodicidade(String nome) throws ExceptionNegocioBSC {
		PeriodicidadeTO entidade = new PeriodicidadeTO();
		entidade.setNome(nome);
		PeriodicidadeBO bo = new PeriodicidadeBO();
		try {
			entidade =  bo.consultarUm(entidade);
		} catch (Exception e) {
			throw new ExceptionNegocioBSC("Periodicidade não encontrada "+ entidade.getNome() +". " + e.getMessage());
		}
		if (entidade.getId() == 0) {
			entidade.setNome(nome);
			incluirPeriodicidade(entidade);
		}
		periodicidades.put(entidade.getNome(), entidade);
	}
	
	/**
	 * Incluir dados novos de Periodicidade
	 * 
	 * @param entidade
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private void incluirPeriodicidade(PeriodicidadeTO entidade) throws ExceptionNegocioBSC {
		PeriodicidadeBO bo = new PeriodicidadeBO();
		try {
			bo.incluir(entidade);
		} catch (Exception e) {
			throw new ExceptionNegocioBSC("Erro ao incluir Periodicidade "+ entidade.getNome() +". " + e.getMessage());
		}
	}
	//**********************************************************************************************
	
	//Metodos tipo de perspectiva*******************************************************************
	/**
	 * Consultar TipoPerspectiva por nome da perspectiva
	 * 
	 * @param nomeTipo String
	 * 
	 * @return TipoPerspectivaTO
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private TipoPerspectivaTO consultarTipoPerspectivaTo(String nomeTipo) throws ExceptionNegocioBSC {
		TipoPerspectivaBO bo = new TipoPerspectivaBO();
		TipoPerspectivaTO tipo = new TipoPerspectivaTO();
		tipo.setNome(nomeTipo);
		try {
			return bo.consultarUm(tipo);
		} catch (Exception e) {
			throw new ExceptionNegocioBSC("Tipo de perspectiva não encontrado. " + e.getMessage());
		}
	}
	
	/**
	 * Veriica se o TipoPerspectiva existe, caso nao, inclui um novo
	 * 
	 * @param perspectivaElement Element
	 * 
	 * @return TipoPerspectivaTO
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private void verificarExisteTipoPerspectiva(Element perspectivaElement) throws ExceptionNegocioBSC 
																		 {
		TipoPerspectivaTO tipo = new TipoPerspectivaTO();
		String nomeTipo = perspectivaElement.getAttribute(
									CONFIG.getString("gerarxml.perspectiva.perspectiveType"));
		tipo = consultarTipoPerspectivaTo(nomeTipo);
		if ((tipo.getId() == 0)) {
			tipo.setDescricao(nomeTipo);
			try {
				incluirTipoPerspectiva(tipo);
			} catch (Exception e) {
				throw new ExceptionNegocioBSC("Erro na inclusão do Tipo de perspectiva. " + e.getMessage());
			}
		}
		tipoPerspectivas.put(tipo.getNome(), tipo);
	}
	
	/**
	 * Metodo que inclu um novo tipo de perspectiva
	 * 
	 * @param entidade TipoPerspectivaTO
	 * 
	 * @throws ExceptionNegocioBSC
	 */
	private void incluirTipoPerspectiva(TipoPerspectivaTO entidade) throws ExceptionNegocioBSC {
		TipoPerspectivaBO bo = new TipoPerspectivaBO();
		bo.incluir(entidade);
	}
	//**********************************************************************************************
	
	//GET e SET
	public void setArquivoXml(InputStream arquivoXml) {
		this.arquivoXml = arquivoXml;
	}

	public InputStream getArquivoXml() {
		return arquivoXml;
	}
	
	public MapaEstrategicoTO getMapaTo() {
		return mapaTo;
	}

	public void setMapaTo(MapaEstrategicoTO mapaTo) {
		this.mapaTo = mapaTo;
	}

	public void setTemaTo(TemaTO temaTo) {
		this.temaTo = temaTo;
	}

	public TemaTO getTemaTo() {
		return temaTo;
	}

	public void setPerspectivaTo(PerspectivaTO perspectivaTo) {
		this.perspectivaTo = perspectivaTo;
	}

	public PerspectivaTO getPerspectivaTo() {
		return perspectivaTo;
	}

	public void setObjetivoTo(ObjetivoTO objetivoTo) {
		this.objetivoTo = objetivoTo;
	}

	public ObjetivoTO getObjetivoTo() {
		return objetivoTo;
	}

	public void setObjetivos(HashMap<Integer, ObjetivoTO> objetivos) {
		this.objetivos = objetivos;
	}

	public HashMap<Integer, ObjetivoTO> getObjetivos() {
		return objetivos;
	}

	public void setTipoPerspectivas(HashMap<String, TipoPerspectivaTO> tipoPerspectivas) {
		this.tipoPerspectivas = tipoPerspectivas;
	}

	public HashMap<String, TipoPerspectivaTO> getTipoPerspectivas() {
		return tipoPerspectivas;
	}

	public IndicadorTO getIndicadorTo() {
		return indicadorTo;
	}

	public void setIndicadorTo(IndicadorTO indicadorTo) {
		this.indicadorTo = indicadorTo;
	}

	public void setPeriodicidades(HashMap<String, PeriodicidadeTO> periodicidades) {
		this.periodicidades = periodicidades;
	}

	public HashMap<String, PeriodicidadeTO> getPeriodicidades() {
		return periodicidades;
	}
}