/*
 * Created on 17/05/2001
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.intraBSC.excecoes;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class ExceptionPersistenciaBSC extends ExceptionNegocioBSC {
	
	public ExceptionPersistenciaBSC() {
	}
	
	public ExceptionPersistenciaBSC(Throwable t){
	    super(getMensagemConfigurada(t.getMessage()));
	    exOriginal = t;
	}
	
	public ExceptionPersistenciaBSC(String key) {
	    super(getMensagemConfigurada(key));
	}
	
	public ExceptionPersistenciaBSC(String key, Object values[]) {
        super(key,values);
	}
	
	public ExceptionPersistenciaBSC(String key, Object value0) {
	    this(key, new Object[] {
            value0
        });
    }

    public ExceptionPersistenciaBSC(String key, Object value0, Object value1) {
        this(key, new Object[] {
            value0, value1
        });
    }

    public ExceptionPersistenciaBSC(String key, Object value0, Object value1, Object value2) {
        this(key, new Object[] {
            value0, value1, value2
        });
    }

    public ExceptionPersistenciaBSC(String key, Object value0, Object value1, Object value2, Object value3) {
        this(key, new Object[] {
            value0, value1, value2, value3
        });
    }

    private static String getMensagemConfigurada(String msg){
        String codState = getParametroMensagem(msg,"SQLSTATE");
        if(codState == null){
            return msg;
        }
        try{
            ResourceBundle arquivoMsg = ResourceBundle.getBundle("recursos/Db2Exceptions");
            return arquivoMsg.getString(codState);
        } catch (MissingResourceException e){
            return msg;
        }
    }
    
    /**
     * 
     * @param msg
     * @param param
     * @return
     */
    public static String getParametroMensagem(String msg , String param){
        if(msg == null){
            return null;
        }
        String codigo = msg;
        int posicao = msg.toUpperCase().lastIndexOf(param);
        if(posicao < 0){
            return null;
        }
        posicao = msg.indexOf('=',posicao);
        if(posicao < 0){
            return null;
        }
        int i = 1;
        while(msg.substring(posicao).charAt(i) == ' '){
            i++;
        }
        codigo = msg.substring(posicao+i);
        i = 0;
        while((i<codigo.length())&&(codigo.charAt(i) != ' ')){
            i++;
        }
        return codigo.substring(0,i).trim();
    }
}
