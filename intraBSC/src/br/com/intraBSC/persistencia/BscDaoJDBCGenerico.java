/*
 * Created on 30/05/2001
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.intraBSC.persistencia;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.JdbcDaoTemplate;


public class BscDaoJDBCGenerico extends JdbcDaoTemplate{
	
	public BscDaoJDBCGenerico(DaoManager daoManager) {
		super(daoManager);
	}

	
	public static final String DB_ALIAS = "INTRABSC2.";

}
