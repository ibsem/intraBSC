package br.com.intraBSC.persistencia;

import com.ibatis.dao.client.Dao;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoTransaction;

/**
 * @author Tiago Trindade Stangarlin
 */
public class ControleTransacao implements DaoManager {

	DaoManager daoManager;
	ThreadLocal numTransacao;
	
	public ControleTransacao(DaoManager daoManager) {
		this.daoManager = daoManager;
		numTransacao = new ThreadLocal();
	}
	
	public Dao getDao(Class arg0) {
		return daoManager.getDao(arg0);
	}

	public Dao getDao(Class arg0, String arg1) {
		return daoManager.getDao(arg0,arg1);
	}

	public DaoTransaction getTransaction(Dao arg0) {
		return daoManager.getTransaction(arg0);
	}

	@SuppressWarnings("unchecked")
	public void startTransaction() {
		if(numTransacao.get() == null){
			numTransacao.set(new Integer(1));
			daoManager.startTransaction();
		}else{
			numTransacao.set(new Integer(((Integer)numTransacao.get()).intValue()+1));
		}
	}

	public void commitTransaction() {
		if((numTransacao.get() != null)&&(((Integer)numTransacao.get()).intValue() == 1)){
			daoManager.commitTransaction();
		}
	}

	@SuppressWarnings("unchecked")
	public void endTransaction() {
		if(numTransacao.get() == null){
			return;
		}
		if(((Integer)numTransacao.get()).intValue() > 1){
			numTransacao.set(new Integer(((Integer)numTransacao.get()).intValue()-1));
		} else {
			daoManager.endTransaction();
			numTransacao.set(null);
		}
	}
	
}