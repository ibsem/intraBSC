package br.com.intraBSC.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import br.com.intraBSC.excecoes.ExceptionNegocioBSC;
import br.com.intraBSC.modelo.CausaEfeitoTO;
import br.com.intraBSC.modelo.MapaEstrategicoTO;
import br.com.intraBSC.modelo.ObjetivoTO;
import br.com.intraBSC.modelo.UsuarioTO;
import br.com.intraBSC.negocio.CausaEfeitoBO;
import br.com.intraBSC.negocio.MapaEstrategicoBO;
import br.com.intraPRO.modelo.ParticipanteTO;
import br.com.intraPRO.modelo.TarefaTO;
import br.com.intraPRO.negocio.TarefaBO;

public class ValidaUsuario {
	
	public static Boolean Autoriza(UsuarioTO usuarioTO, MapaEstrategicoTO mapaTO, TarefaTO tarefaTO ){
	boolean Autorizado = false;
	
		/*Parte referente aos Mapa do usuario*/
	try {
	MapaEstrategicoBO mapaEstrategicoBO = new MapaEstrategicoBO();
	MapaEstrategicoTO mapaEstrategicoTO = new MapaEstrategicoTO();
	mapaEstrategicoTO.setAtivo(1);
	mapaEstrategicoTO.setIdUsuario(usuarioTO.getIdUsuario());
	Collection listaMapa;
	listaMapa = mapaEstrategicoBO.consultarMapaUsuario(mapaEstrategicoTO);
	
	Iterator contador = listaMapa.iterator();
		while (contador.hasNext()){
		MapaEstrategicoTO mapaEstrategicoTO2 = (MapaEstrategicoTO) contador.next();
		if (mapaTO.getId() == mapaEstrategicoTO2.getId())
			Autorizado = true;
		}
		
	
	/*Parte referente as Tarefas do usuario*/
	if (tarefaTO.getCodigo() != -99){
	TarefaBO tarefaBO = new TarefaBO();
	ParticipanteTO participanteTO = new ParticipanteTO();
	participanteTO.setCodTipoParticipacao(1);
	participanteTO.setCodUsuario(usuarioTO.getIdUsuario());
	tarefaTO.setCodUsuSolicitante(usuarioTO.getIdUsuario());
	Collection listaArvoreMapaEstrategicoConfig = tarefaBO.consultarArvore(tarefaTO, participanteTO);
	
	if (!listaArvoreMapaEstrategicoConfig.isEmpty())
		Autorizado = true; 
	}
		} catch (ExceptionNegocioBSC e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return Autorizado;
	
	}
}

