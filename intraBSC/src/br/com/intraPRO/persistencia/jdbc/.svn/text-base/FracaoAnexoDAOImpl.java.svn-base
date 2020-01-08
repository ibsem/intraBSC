
package br.com.intraPRO.persistencia.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.FracaoAnexoTO;
import br.com.intraPRO.persistencia.FracaoAnexoDAO;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

/**
Classe que implementa so metodos de SQL de operação a base dados de Fracao de 
Anexo
*/
public class FracaoAnexoDAOImpl extends BscDaoJDBCGenerico implements FracaoAnexoDAO{
    
    protected final static String tabela = "TASKAPPENDBLOCK"; 
    protected final static String anoCriacao = "PK_YEAR_START_TASK";
    protected final static String numeroSequencialTarefa = "PK_NUMBER_SEQUENCE_TASK";
    protected final static String numeroSequencialArquivoAnexado = "PK_NUMBER_SEQUENCE_FILE_APPEND";
    protected final static String numeroFracoes = "PK_NUMBER_TASKAPPENDBLOCK";
    protected final static String textoConteudoFracao = "TX_CTU_FRACTION_APPEND";
    
    private static Log log = LogFactory.getLog(FracaoAnexoDAOImpl.class);
   
   public FracaoAnexoDAOImpl(DaoManager daoManager){
   		super(daoManager);
   }
   
   
	public void incluir(FracaoAnexoTO fracaoAnexoTO) throws ExceptionPersistenciaPRO {
	    
	    // Cria uma StringBuffer dinâmica para montar a sql de acordo com os dados informados pelo usuário
	    StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(tabela);
		sql.append(" ( ");
		
		if ((fracaoAnexoTO.getAnoCriacao() != null) && (!fracaoAnexoTO.getAnoCriacao().trim().equals("")))
		    sql.append(anoCriacao);
		
		if (fracaoAnexoTO.getNumeroSequencialTarefa() != 0)
		    sql.append(", " + numeroSequencialTarefa);
		
		if (fracaoAnexoTO.getNumeroSequencialArquivoAnexo() != 0)
		    sql.append(", " + numeroSequencialArquivoAnexado);
		
		if (fracaoAnexoTO.getNumeroFracaoAnexoTarefa() != 0)
		    sql.append(", " + numeroFracoes);
		
		if ((fracaoAnexoTO.getConteudoFracaoAnexo() != null) && (!fracaoAnexoTO.getConteudoFracaoAnexo().trim().equals("")))
		    sql.append(", " + textoConteudoFracao);
		
		sql.append(" ) ");
		sql.append("VALUES");
		sql.append(" ( ");
		
		if ((fracaoAnexoTO.getAnoCriacao() != null) && (!fracaoAnexoTO.getAnoCriacao().trim().equals("")))
		    sql.append("?");
		
		if (fracaoAnexoTO.getNumeroSequencialTarefa() != 0)
		    sql.append(", ?");
		
		if (fracaoAnexoTO.getNumeroSequencialArquivoAnexo() != 0)
		    sql.append(", ?");
		
		if (fracaoAnexoTO.getNumeroFracaoAnexoTarefa() != 0)
		    sql.append(", ?");
		
		if ((fracaoAnexoTO.getConteudoFracaoAnexo() != null) && (!fracaoAnexoTO.getConteudoFracaoAnexo().trim().equals("")))
		    sql.append(", ?");
		
		sql.append(" )");
		
		PreparedStatement stmt;
		try {
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());
			
			if ((fracaoAnexoTO.getAnoCriacao() != null) && (!fracaoAnexoTO.getAnoCriacao().trim().equals("")))
				stmt.setString(++i, fracaoAnexoTO.getAnoCriacao());

			if (fracaoAnexoTO.getNumeroSequencialTarefa() != 0)
				stmt.setInt(++i, fracaoAnexoTO.getNumeroSequencialTarefa());
			
			if (fracaoAnexoTO.getNumeroSequencialArquivoAnexo() != 0)
			    stmt.setInt(++i, fracaoAnexoTO.getNumeroSequencialArquivoAnexo());
			
			if (fracaoAnexoTO.getNumeroFracaoAnexoTarefa() != 0)
			    stmt.setInt(++i, fracaoAnexoTO.getNumeroFracaoAnexoTarefa());
			
			if ((fracaoAnexoTO.getConteudoFracaoAnexo() != null) && (!fracaoAnexoTO.getConteudoFracaoAnexo().trim().equals("")))
			    stmt.setString(++i, fracaoAnexoTO.getConteudoFracaoAnexo());
				
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
	}

	public void excluir(FracaoAnexoTO fracaoAnexoTO) throws ExceptionPersistenciaPRO {	   
	    StringBuffer sql = new StringBuffer("DELETE FROM ");
		sql.append(tabela);
		sql.append(" WHERE 1=1 ");
		
		if ((fracaoAnexoTO.getAnoCriacao() != null) && (!fracaoAnexoTO.getAnoCriacao().trim().equals("")))
		    sql.append("AND "+ anoCriacao +"= ? ");
		
		if (fracaoAnexoTO.getNumeroSequencialTarefa() != 0)
			 sql.append("AND "+ numeroSequencialTarefa +"= ? ");
		 
		
		if (fracaoAnexoTO.getNumeroSequencialArquivoAnexo() != 0)
			 sql.append("AND "+ numeroSequencialArquivoAnexado +"= ? ");
		
		PreparedStatement stmt;
		try {
			int i=0;
			stmt = getConnection().prepareStatement(sql.toString());
			
			if ((fracaoAnexoTO.getAnoCriacao() != null) && (!fracaoAnexoTO.getAnoCriacao().trim().equals("")))
				stmt.setString(++i, fracaoAnexoTO.getAnoCriacao());

			if (fracaoAnexoTO.getNumeroSequencialTarefa() != 0)
				stmt.setInt(++i, fracaoAnexoTO.getNumeroSequencialTarefa());
			
			if (fracaoAnexoTO.getNumeroSequencialArquivoAnexo() != 0)
			    stmt.setInt(++i, fracaoAnexoTO.getNumeroSequencialArquivoAnexo());	
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
	}
	

	@SuppressWarnings("unchecked")
	public Collection download(FracaoAnexoTO fracaoAnexoTO) throws ExceptionPersistenciaPRO {
	    Collection resultadoFracao = new ArrayList();	    
	    
	    StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(anoCriacao + ", ");
		sql.append(numeroSequencialTarefa + ", ");
		sql.append(numeroSequencialArquivoAnexado  + ", ");
		sql.append(numeroFracoes + ", ");
		sql.append(textoConteudoFracao);
		sql.append(" FROM ");
		sql.append(tabela + " A ");
		sql.append("WHERE 1=1 ");
		
		
		if ((fracaoAnexoTO.getAnoCriacao() != null) && (!fracaoAnexoTO.getAnoCriacao().trim().equals("") ))
		    sql.append(" AND A." + anoCriacao + " =?");
		
		if (fracaoAnexoTO.getNumeroSequencialTarefa() != 0)		
		    sql.append(" AND A." + numeroSequencialTarefa + " =?");
		
		if (fracaoAnexoTO.getNumeroSequencialArquivoAnexo() != 0)
		    sql.append(" AND A." + numeroSequencialArquivoAnexado + " =?");
			
		sql.append(" ORDER BY " + numeroFracoes);
		
		PreparedStatement stmt;

		try {
			int i=1;
			stmt = getConnection().prepareStatement(sql.toString());
			
			// Conclui a montagem da StringBuffer dinamica informando os campos e os valores a serem utilizados como filtro na pesquisa
			if ((fracaoAnexoTO.getAnoCriacao() != null) && (!fracaoAnexoTO.getAnoCriacao().trim().equals("") )){
			    stmt.setString(i++, fracaoAnexoTO.getAnoCriacao());
			}
			
			if (fracaoAnexoTO.getNumeroSequencialTarefa() != 0){
			    stmt.setInt(i++, fracaoAnexoTO.getNumeroSequencialTarefa());			
			}
			
			if (fracaoAnexoTO.getNumeroSequencialArquivoAnexo() != 0)
			    stmt.setInt(i++, fracaoAnexoTO.getNumeroSequencialArquivoAnexo());			
					
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
			    resultadoFracao.add(carregarTO(resultado));	
			}			
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DaoException(e.getMessage());
		}		
		return resultadoFracao;	    	
	}
	

	public int consultarMax(FracaoAnexoTO fracaoAnexoTO) throws ExceptionPersistenciaPRO {
	    // Cria uma StringBuffer dinâmica para consultar o numero maior sequencial da tabela    
	    StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(numeroSequencialArquivoAnexado);
		sql.append(") AS ");
		sql.append(numeroSequencialArquivoAnexado);
		sql.append(" FROM ");
		sql.append(tabela);		
		sql.append(" WHERE 1=1");
		
		if ((fracaoAnexoTO.getAnoCriacao() != null) && (!fracaoAnexoTO.getAnoCriacao().trim().equals("")))
		    sql.append(" AND " + anoCriacao + " = " + fracaoAnexoTO.getAnoCriacao());
		
		if (fracaoAnexoTO.getNumeroSequencialTarefa() != 0)
		    sql.append(" AND " + numeroSequencialTarefa + " = " + fracaoAnexoTO.getNumeroSequencialTarefa());
		
		if (fracaoAnexoTO.getNumeroSequencialArquivoAnexo() != 0)
		    sql.append(" AND " + numeroSequencialArquivoAnexado + " = " + fracaoAnexoTO.getNumeroSequencialArquivoAnexo());		

		PreparedStatement stmt;
		ResultSet result;		
		try {
			stmt = getConnection().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(numeroSequencialArquivoAnexado)+1;
			}			
		} 
		catch (SQLException e) {
		    log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}		
		return 0;
	}

	
	
	private FracaoAnexoTO carregarTO(ResultSet resultado) throws SQLException{
	    FracaoAnexoTO fracaoAnexoTO = new FracaoAnexoTO();
	    fracaoAnexoTO.setAnoCriacao(resultado.getString(1));
	    fracaoAnexoTO.setNumeroSequencialTarefa(resultado.getInt(2));
	    fracaoAnexoTO.setNumeroSequencialArquivoAnexo(resultado.getInt(3));
	    fracaoAnexoTO.setNumeroFracaoAnexoTarefa(resultado.getInt(4));
	    fracaoAnexoTO.setConteudoFracaoAnexo(resultado.getString(5));
	    return fracaoAnexoTO;
	}

}