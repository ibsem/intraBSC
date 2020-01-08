

/*
 * Created on 15/02/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package br.com.intraBSC.persistencia;

import java.util.Collection;

import net.sf.jasperreports.engine.JasperPrint;

import br.com.intraBSC.excecoes.ExceptionPersistenciaBSC;
import br.com.intraBSC.modelo.IndicadorTO;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.PerspectivaTO;



/**
 * @author Tiago
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface MapaEstrategicoDAO{
   
   public abstract Collection consultarVarios(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;
   
   public abstract Collection consultarMapaUsuario(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;
    
   public abstract MapaEstrategicoTO consultarUm(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;
   
   public abstract MapaEstrategicoTO consultarIdMapa(PerspectivaTO perspectivaTO, ObjetivoTO objetivoTO, IndicadorTO indicadorTO) throws ExceptionPersistenciaBSC;
   
   public abstract void incluir(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;
   
   public void alterar(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;   
   
   public void excluir(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;
   
   public int consultarMax(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;
   
   public JasperPrint mapaEstrategicoRelatorioDetalha(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;
   
   public Collection consultarArvoreConfiguracao(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;

   public MapaEstrategicoTO contarPerspectivas(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;

   public Collection contarObjetivos(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;
   
   public void incluirXml(MapaEstrategicoTO mapaEstrategicoTO) throws ExceptionPersistenciaBSC;
}

