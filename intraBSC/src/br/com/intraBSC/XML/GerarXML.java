package br.com.intraBSC.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.ResourceBundle;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.MetaTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PerspectivaTO;
import br.com.intraBSC.modelo.TemaTO;
import br.com.intraBSC.negocio.IndicadorBO;
import br.com.intraBSC.negocio.MetaBO;
import br.com.intraBSC.negocio.ObjetivoBO;
import br.com.intraBSC.negocio.PerspectivaBO;
import br.com.intraBSC.negocio.TemaBO;


/**
 * Classe que gera o XML de um determinado mapa selecionado.
 * @author Tiago
 *
 */
public class GerarXML {
	
	private Collection<PerspectivaTO> listaPerspectivas;
	private Collection<TemaTO> listaTema;
	private Collection<ObjetivoTO> listaObjetivo;
	private Collection<IndicadorTO> listaIndicadores;
	private Collection<MetaTO> listaMeta;
	private MapaEstrategicoTO mapaPrincipal; 
	private static final ResourceBundle CONFIG = ResourceBundle.getBundle("br.com.intraBSC.XML.gerarxml");
	
	Document document = DocumentHelper.createDocument();
	Element bscDoc = document.addElement( "BSCDOC" );
	
	
	public void gerarXML(){
	}
	
	/**
	 * Construtor
	 * @param _mapaEstrategicoTO
	 * @throws ExceptionNegocioBSC 
	 */
	public void gerarXML(MapaEstrategicoTO _mapaEstrategicoTO) throws ExceptionNegocioBSC{
		setMapaPrincipal(_mapaEstrategicoTO);
		inicializarListaTema();
		inicializarListaPerspectiva();
		inicializarListaIndicador();
		inicializarListaObjetivo();
	}
	
	
	/**
	 * Metodo que cria o arquivo e cabecalho do XML
	 * @param document
	 * @param codMapa
	 * @throws IOException
	 * @throws ExceptionNegocioBSC
	 */
	
	@SuppressWarnings("unused")
	public void criaArquivo(Document document) throws IOException, ExceptionNegocioBSC {
		
        XMLWriter writer = new XMLWriter(new FileWriter( CONFIG.getString("gerarxml.prefixo") + getMapaPrincipal().getNome() + CONFIG.getString("gerarxml.extensao") ));
        writer.write( document );
        writer.close();

        OutputFormat format = OutputFormat.createPrettyPrint();
        writer = new XMLWriter( System.out, format );
        writer.write( document );
        
        criarBSC(this.document);
		
        writer.write(bscDoc);
    }

	
	/**
	 * Metodo para pesquisar dados de tema
	 * @param _mapaEstrategicoTO
	 * @throws ExceptionNegocioBSC
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void inicializarListaTema() throws ExceptionNegocioBSC{
		TemaBO temaBO = new TemaBO();
		TemaTO temaTO = new TemaTO();
		temaTO.setIdMapa(getMapaPrincipal().getId());
		setListaTema(temaBO.consultarVarios(temaTO));
	}
	
	/**
	 * Metodo para pesquisar dados da perspectiva
	 * @param _mapaEstrategicoTO
	 * @throws ExceptionNegocioBSC
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void inicializarListaPerspectiva() throws ExceptionNegocioBSC{
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
		setListaObjetivo(indicadorBO.consultarArvoreVisualizacao(indicadorTO));
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
	 */
	@SuppressWarnings("unused")
	private void criarBSC(Document document) throws ExceptionNegocioBSC{
		bscDoc.addAttribute("language", "");
		
		criarElementoMapaEstrategico(getMapaPrincipal());
	}
	
	/**
	 * Metodo que cria os elementos do nó BSC
	 * @param mapaEstrategicoTO
	 */
	@SuppressWarnings("unused")
	private void criarElementoMapaEstrategico(MapaEstrategicoTO mapaEstrategicoTO){
		Element bsc = bscDoc.addElement( CONFIG.getString("gerarxml.bsc.element") )
    		.addAttribute( CONFIG.getString("gerarxml.bsc.id") , String.valueOf(mapaEstrategicoTO.getId()))
    		.addAttribute( CONFIG.getString("gerarxml.bsc.name") , "mapaEstrategicoTO.getNome()");
		
		for (TemaTO _temaTO : getListaTema()) {
			criarElementoTema(bsc, _temaTO);
		}
		
		for (PerspectivaTO _perspectivaTO : getListaPerspectivas()){
			criarPerspectiva(bsc, _perspectivaTO);
		}
	}
	
	
	/**
	 * Metodo que cria o elemento tema.
	 * @param elementPai
	 * @param temaTO
	 */
	@SuppressWarnings("unused")
	private void criarElementoTema(Element elementPai, TemaTO temaTO){
		Element tema = elementPai.addElement( CONFIG.getString("gerarxml.theme.element") )
    		.addAttribute( CONFIG.getString("gerarxml.theme.id"), String.valueOf(temaTO.getIdTema()))
    		.addAttribute( CONFIG.getString("gerarxml.theme.name"), "temaTO.getNomeTema()")
    		.addAttribute( CONFIG.getString("gerarxml.theme.ownerRef"), "temaTO.getUsuario().getNome()");
		
		Element temaDescricao = tema.addElement(CONFIG.getString("gerarxml.theme.description")); 
		temaDescricao.setText("temaTO.getDescricaoTema()");
		
		for (ObjetivoTO objetivoTO : getListaObjetivo()) {
			if (objetivoTO.getIdTema() != 0){
				criarElementoObjetivo(tema, objetivoTO);
			}
		}
	}
	
	/**
	 * Metodo que cria o elemento objetivo.
	 * @param elementPai
	 * @param _objetivoTO
	 */
	@SuppressWarnings("unused")
	private void criarElementoObjetivo(Element elementPai, ObjetivoTO _objetivoTO){
		Element objetivo = elementPai.addElement( CONFIG.getString("gerarxml.objective.element") )
    		.addAttribute( CONFIG.getString("gerarxml.objective.id"), String.valueOf(_objetivoTO.getId()))
    		.addAttribute( CONFIG.getString("gerarxml.objective.name"), "_objetivoTO.getNome()")
    		.addAttribute( CONFIG.getString("gerarxml.objective.ownerRef"), "_objetivoTO.getUsuario().getNome()");
		
		Element objetivoDescricao = objetivo.addElement(CONFIG.getString("gerarxml.objective.description")); 
		objetivoDescricao.setText("_objetivoTO.getDescricao()");
		
		for (IndicadorTO indicadorTO : getListaIndicadores()){
			criarElementoIndicador(objetivo, indicadorTO);
		}
	}
	
	
	/**
	 * Metodo que cria o elemento Indicador.
	 * @param elementPai
	 * @param _objetivoTO
	 */
	@SuppressWarnings("unused")
	private void criarElementoIndicador(Element elementPai, IndicadorTO _indicadorTO){
		Element indicador = elementPai.addElement( CONFIG.getString("gerarxml.measure.element") )
    		.addAttribute( CONFIG.getString("gerarxml.measure.id"), String.valueOf(_indicadorTO.getId()))
    		.addAttribute( CONFIG.getString("gerarxml.measure.name"), "_indicadorTO.getNome()")
    		.addAttribute( CONFIG.getString("gerarxml.measure.updateFrequency"), "_indicadorTO.getNome()")
    		.addAttribute( CONFIG.getString("gerarxml.measure.updateFrequency"), "_indicadorTO.getNome()")
    		.addAttribute( CONFIG.getString("gerarxml.measure.ownerRef"), "_indicadorTO.getUsuario().getNome()");
		
		Element indicadorDescricao = indicador.addElement(CONFIG.getString("gerarxml.measure.description")); 
		indicadorDescricao.setText("_indicadorTO.getDescricao()");
		
		for (MetaTO metaTO : getListaMeta()) {
			criarMeta(indicador, metaTO);
		}
	}
	
	/**
	 * Metodo para criar o elemento de meta
	 * @param elementPai
	 * @param _metaTO
	 */
	@SuppressWarnings("unused")
	private void criarMeta(Element elementPai, MetaTO _metaTO){
		Element meta = elementPai.addElement( CONFIG.getString("gerarxml.target.element") )
    		.addAttribute( CONFIG.getString("gerarxml.target.id"), String.valueOf(_metaTO.getId()))
    		.addAttribute( CONFIG.getString("gerarxml.target.name"), "_metaTO.getNome()")
    		.addAttribute( CONFIG.getString("gerarxml.target.targetValue"), "_metaTO.getNome()")
    		.addAttribute( CONFIG.getString("gerarxml.target.actualValue"), "_metaTO.getNome()")
    		.addAttribute( CONFIG.getString("gerarxml.target.ownerRef"), "_metaTO.getNome()");
		
		Element metaDescricao = meta.addElement(CONFIG.getString("gerarxml.target.description")); 
		metaDescricao.setText("_metaTO.getDescricao()");
	}
	
	/**
	 * Metodo de criacao para o elemento de perspectiva
	 * @param elementPai
	 * @param perspectivaTO
	 */
	@SuppressWarnings("unused")
	private void criarPerspectiva(Element elementPai, PerspectivaTO perspectivaTO){
		Element perspectiva = elementPai.addElement( CONFIG.getString("gerarxml.perspectiva.element") )
    		.addAttribute( CONFIG.getString("gerarxml.perspectiva.id"), String.valueOf(perspectivaTO.getId()))
    		.addAttribute( CONFIG.getString("gerarxml.perspectiva.name"), "perspectiva.getNome()")
    		.addAttribute( CONFIG.getString("gerarxml.perspectiva.perspectiveType"), "perspectiva.getNome()")
    		.addAttribute( CONFIG.getString("gerarxml.perspectiva.sortOrder"), "perspectiva.getNome()")
    		.addAttribute( CONFIG.getString("gerarxml.perspectiva.ownerRef"), "perspectiva.getNome()");
		
		Element metaDescricao = perspectiva.addElement(CONFIG.getString("gerarxml.perspectiva.description")); 
		metaDescricao.setText("perspectiva.getDescricao()");
		
		for (ObjetivoTO objetivoTO : getListaObjetivo()) {
			if (objetivoTO.getIdTema() != 0) {
				criarElementoObjetivo(perspectiva, objetivoTO);
			}
		}
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

	/**
	 * @return the listaTema
	 */
	public Collection<TemaTO> getListaTema() {
		return listaTema;
	}

	/**
	 * @param _listaTema the listaTema to set
	 */
	public void setListaTema(Collection<TemaTO> _listaTema) {
		listaTema = _listaTema;
	}

	public MapaEstrategicoTO getMapaPrincipal() {
		return mapaPrincipal;
	}

	public void setMapaPrincipal(MapaEstrategicoTO mapaPrincipal) {
		this.mapaPrincipal = mapaPrincipal;
	}
}
