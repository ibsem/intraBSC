/*
 * Created on 17/05/2001
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.intraPRO.excecoes;

import java.io.PrintStream;
import java.io.PrintWriter;


public class ExceptionPRO extends Exception {
	
	
	Throwable exOriginal;
	private String mensagem;
	private Object values[];
	
	public ExceptionPRO() {	
		super();
	}
	
	public ExceptionPRO(Throwable t) {
		super(t.toString());
		exOriginal = t;
	}
	
	public ExceptionPRO(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public ExceptionPRO(String key, Object values[]) {
        this(key);
		this.values = values;
    }
	
	public ExceptionPRO(String key, Object value0) {
        this(key, new Object[] {
            value0
        });
    }

    public ExceptionPRO(String key, Object value0, Object value1) {
        this(key, new Object[] {
            value0, value1
        });
    }

    public ExceptionPRO(String key, Object value0, Object value1, Object value2) {
        this(key, new Object[] {
            value0, value1, value2
        });
    }

    public ExceptionPRO(String key, Object value0, Object value1, Object value2, Object value3) {
        this(key, new Object[] {
            value0, value1, value2, value3
        });
    }

	public ExceptionPRO(String mensagem, Throwable t) {
		this(mensagem);
		exOriginal = t;
	}

	/**
	 * Recupera a exceção original encapsulada nesta.
	 * @return exceção original
	 */
	public Throwable getExOriginal() {
		return exOriginal;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return mensagem;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if(exOriginal != null) {
			return this.getClass().getName() + ": " +  mensagem + " ("+ exOriginal.toString()+")";
		} else {	
			return this.getClass().getName() + ": " +  mensagem;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#printStackTrace()
	 */
	public void printStackTrace() {
		super.printStackTrace();
		if(exOriginal!= null) {
			exOriginal.printStackTrace();
		} 
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
	 */
	public void printStackTrace(PrintStream s) {
		synchronized(s) {
			super.printStackTrace(s);
			if(exOriginal!= null) {
				exOriginal.printStackTrace(s);
			}
		}
		 
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	public void printStackTrace(PrintWriter s) {
		synchronized(s) {
			super.printStackTrace(s);
			if(exOriginal!= null) {
				exOriginal.printStackTrace(s);
			}
		} 
	}
	
	public Object[] getValues() {
        return values;
    }
}
