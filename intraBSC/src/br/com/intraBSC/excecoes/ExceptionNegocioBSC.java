/*
 * Created on 17/05/2001
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.intraBSC.excecoes;


public class ExceptionNegocioBSC extends ExceptionBSC {
	public ExceptionNegocioBSC() {
	}
	
	public ExceptionNegocioBSC(Throwable t){
		super(t);
	}
	
	public ExceptionNegocioBSC(String key) {
		super(key);
	}
	
	public ExceptionNegocioBSC(String key, Object values[]) {
        super(key,values);
	}
	
	public ExceptionNegocioBSC(String key, Object value0) {
        this(key, new Object[] {
            value0
        });
    }

    public ExceptionNegocioBSC(String key, Object value0, Object value1) {
        this(key, new Object[] {
            value0, value1
        });
    }

    public ExceptionNegocioBSC(String key, Object value0, Object value1, Object value2) {
        this(key, new Object[] {
            value0, value1, value2
        });
    }

    public ExceptionNegocioBSC(String key, Object value0, Object value1, Object value2, Object value3) {
        this(key, new Object[] {
            value0, value1, value2, value3
        });
    }
}
