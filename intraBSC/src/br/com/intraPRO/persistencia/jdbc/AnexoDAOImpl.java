
package br.com.intraPRO.persistencia.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.intraBSC.persistencia.BscDaoJDBCGenerico;
import br.com.intraBSC.util.DataUtil;
import br.com.intraPRO.excecoes.ExceptionPersistenciaPRO;
import br.com.intraPRO.modelo.AnexoTO;
import br.com.intraPRO.persistencia.AnexoDAO;

import com.ibatis.dao.client.DaoManager;

/**
 * Classe responsavel pela implementacao dos SQLs da operações de banco para a
 * entidade de Anexo
 */
public class AnexoDAOImpl extends BscDaoJDBCGenerico implements AnexoDAO {

	protected final static String tabela = "FILEANEXXTASK";
	protected final static String anoCriacao = "PK_YEAR_START_TASK";
	protected final static String numeroSequencialTarefa = "PK_SEQUENCE_TASK";
	protected final static String numeroSequencialArquivoAnexado = "PK_SEQUENCE_FILE_APPEND";
	protected final static String codigoUsuario = "FK_ACTOR_INIT_APPEND";
	protected final static String nomeArquivo = "NAME_FILE_APPEND";
	protected final static String textoTipoConteudo = "TX_MODEL_CTU_FILE";
	protected final static String quantidadeBytes = "QT_BYTE_FILE";
	protected final static String timestampCriacao = "TS_START_FILE_APPEND";
	protected final static String quantidadeFracoes = "QT_FRACTION_FILE_APPEND";
	private static Log log = LogFactory.getLog(AnexoDAOImpl.class);

	/**
	 * @param daoManager
	 */
	public AnexoDAOImpl(DaoManager daoManager) {
		super(daoManager);
	}


	public boolean incluir(AnexoTO anexoTO) throws ExceptionPersistenciaPRO {
		
		

		// Cria uma StringBuffer dinâmica para inserir apenas os dados
		// informados pelo usuário.
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		sql.append(tabela);
		sql.append(" ( ");

		if ((anexoTO.getAnoCriacao() != null) && (!anexoTO.getAnoCriacao().trim().equals("")))
			sql.append(anoCriacao + ", ");

		if (anexoTO.getNumeroSequencialTarefa() != 0)
			sql.append(numeroSequencialTarefa + ", ");

		if ((anexoTO.getNumeroSequencialArquivo() != 0))
			sql.append(numeroSequencialArquivoAnexado + ", ");

		if ((anexoTO.getCodUsuario() != 0))
			sql.append(codigoUsuario + ", ");

		if ((anexoTO.getNome() != null) && (!anexoTO.getNome().trim().equals("")))
			sql.append(nomeArquivo + ", ");

		if ((anexoTO.getTextoTipoConteudo() != null) && (!anexoTO.getTextoTipoConteudo().trim().equals("")))
			sql.append(textoTipoConteudo + ", ");

		if (anexoTO.getQuantByteAnexo() != 0)
			sql.append(quantidadeBytes + ", ");

		sql.append(timestampCriacao + ", ");
		sql.append(quantidadeFracoes + ") ");
		sql.append(" VALUES (");

		if ((anexoTO.getAnoCriacao() != null) && (!anexoTO.getAnoCriacao().trim().equals("")))
			sql.append(" ?,");

		if (anexoTO.getNumeroSequencialTarefa() != 0)
			sql.append(" ?,");

		if ((anexoTO.getNumeroSequencialArquivo() != 0))
			sql.append(" ?,");

		if ((anexoTO.getCodUsuario() != 0))
			sql.append(" ?,");

		if ((anexoTO.getNome() != null) && (!anexoTO.getNome().trim().equals("")))
			sql.append(" ?,");

		if ((anexoTO.getTextoTipoConteudo() != null) && (!anexoTO.getTextoTipoConteudo().trim().equals("")))
			sql.append(" ?,");

		if (anexoTO.getQuantByteAnexo() != 0)
			sql.append(" ?,");

		sql.append(" ?, ? )");

		PreparedStatement stmt;
		try {
			int i = 0;
			stmt = getConnection().prepareStatement(sql.toString());

			if ((anexoTO.getAnoCriacao() != null) && (!anexoTO.getAnoCriacao().trim().equals("")))
				stmt.setInt(++i, Integer.parseInt(anexoTO.getAnoCriacao()));

			if (anexoTO.getNumeroSequencialTarefa() != 0)
				stmt.setInt(++i, anexoTO.getNumeroSequencialTarefa());

			if ((anexoTO.getNumeroSequencialArquivo() != 0))
				stmt.setInt(++i, anexoTO.getNumeroSequencialArquivo());

			if ((anexoTO.getCodUsuario() != 0))
				stmt.setInt(++i, anexoTO.getCodUsuario());

			if ((anexoTO.getNome() != null) && (!anexoTO.getNome().trim().equals("")))
				stmt.setString(++i, anexoTO.getNome().trim());

			if ((anexoTO.getTextoTipoConteudo() != null) && (!anexoTO.getTextoTipoConteudo().trim().equals("")))
				stmt.setString(++i, anexoTO.getTextoTipoConteudo());

			if (anexoTO.getQuantByteAnexo() != 0)
				stmt.setInt(++i, anexoTO.getQuantByteAnexo());

			stmt.setTimestamp(++i, anexoTO.getTsCriacaoAnexo());			
			stmt.setInt(++i, anexoTO.getQuantFracaoAnexo());

			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return true;
	}


	public AnexoTO consultarUm(AnexoTO anexoTO) throws ExceptionPersistenciaPRO {

		AnexoTO anexoTOResultado = new AnexoTO();

		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(anoCriacao + ", ");
		sql.append(numeroSequencialTarefa + ", ");
		sql.append(numeroSequencialArquivoAnexado + ", ");
		sql.append(codigoUsuario + ", ");
		sql.append(nomeArquivo + ", ");
		sql.append(textoTipoConteudo + ", ");
		sql.append(quantidadeBytes + ", ");
		sql.append(timestampCriacao + ", ");
		sql.append(quantidadeFracoes);
		sql.append(" FROM " + tabela + " A ");
		sql.append("WHERE 1=1 ");

		if ((anexoTO.getAnoCriacao() != null) || (anexoTO.getAnoCriacao().trim().equals("")))
			sql.append("AND A." + anoCriacao + " = ?");

		if (anexoTO.getNumeroSequencialTarefa() != 0)
			sql.append(" AND A." + numeroSequencialTarefa + " = ?");

		if (anexoTO.getNumeroSequencialArquivo() != 0)
			sql.append(" AND A." + numeroSequencialArquivoAnexado + " = ?");

		if ((anexoTO.getCodUsuario() != 0))
			sql.append(" AND A." + codigoUsuario + " = ?");

		PreparedStatement stmt;
		try {

			stmt = getConnection().prepareStatement(sql.toString());
			int i = 0;
			if ((anexoTO.getAnoCriacao() != null) || (anexoTO.getAnoCriacao().trim().equals("")))
				stmt.setInt(++i, Integer.parseInt(anexoTO.getAnoCriacao()));
			if (anexoTO.getNumeroSequencialTarefa() != 0)
				stmt.setInt(++i, anexoTO.getNumeroSequencialTarefa());
			if (anexoTO.getNumeroSequencialArquivo() != 0)
				stmt.setInt(++i, anexoTO.getNumeroSequencialArquivo());
			if ((anexoTO.getCodUsuario() != 0))
				stmt.setInt(++i, anexoTO.getCodUsuario());

			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				anexoTOResultado = carregarTO(resultado);
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return anexoTOResultado;
	}

	@SuppressWarnings("unchecked")
	public Collection consultarVarios(AnexoTO anexoTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(anoCriacao + ", ");
		sql.append(numeroSequencialTarefa + ", ");
		sql.append(numeroSequencialArquivoAnexado + ", ");
		sql.append(codigoUsuario + ", ");
		sql.append(nomeArquivo + ", ");
		sql.append(textoTipoConteudo + ", ");
		sql.append(quantidadeBytes + ", ");
		sql.append(timestampCriacao + ", ");
		sql.append(quantidadeFracoes);
		sql.append(" FROM " + tabela + " A ");
		sql.append("WHERE 1=1 ");

		if ((anexoTO.getAnoCriacao() != null) || (anexoTO.getAnoCriacao().trim().equals("")))
			sql.append("AND A." + anoCriacao + " = ?");

		if (anexoTO.getNumeroSequencialTarefa() != 0)
			sql.append(" AND A." + numeroSequencialTarefa + " = ?");

		if (anexoTO.getNumeroSequencialArquivo() != 0)
			sql.append(" AND A." + numeroSequencialArquivoAnexado + " = ?");

		if ((anexoTO.getCodUsuario() != 0))
			sql.append(" AND A." + codigoUsuario + " = ?");

		sql.append(" ORDER BY ");
		sql.append(numeroSequencialArquivoAnexado);

		PreparedStatement stmt;
		Collection listaAnexos = new ArrayList();
		try {

			stmt = getConnection().prepareStatement(sql.toString());
			int i = 0;
			if ((anexoTO.getAnoCriacao() != null) || (anexoTO.getAnoCriacao().trim().equals("")))
				stmt.setInt(++i, +Integer.parseInt(anexoTO.getAnoCriacao()));
			if (anexoTO.getNumeroSequencialTarefa() != 0)
				stmt.setInt(++i, anexoTO.getNumeroSequencialTarefa());
			if (anexoTO.getNumeroSequencialArquivo() != 0)
				stmt.setInt(++i, anexoTO.getNumeroSequencialTarefa());
			if ((anexoTO.getCodUsuario() != 0))
				stmt.setInt(++i, anexoTO.getCodUsuario());
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				listaAnexos.add(carregarTO(resultado));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return listaAnexos;
	}

	public void excluir(AnexoTO anexoTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("DELETE FROM ");
		sql.append(tabela);
		sql.append(" WHERE 1=1 ");

		if ((anexoTO.getAnoCriacao() != null) && (!anexoTO.getAnoCriacao().trim().equals(""))) {
			sql.append("AND " + anoCriacao + " = ? ");
		}

		if (anexoTO.getNumeroSequencialTarefa() != 0) {
			sql.append("AND " + numeroSequencialTarefa + "= ? ");
		}

		if ((anexoTO.getNumeroSequencialArquivo() != 0)) {
			sql.append("AND " + numeroSequencialArquivoAnexado + "= ? ");
		}

		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(sql.toString());
			int i = 0;
			if ((anexoTO.getAnoCriacao() != null)) {
				stmt.setInt(++i, Integer.parseInt(anexoTO.getAnoCriacao()));
			}
			if (anexoTO.getNumeroSequencialTarefa() != 0) {
				stmt.setInt(++i, anexoTO.getNumeroSequencialTarefa());
			}
			if (anexoTO.getNumeroSequencialArquivo() != 0) {
				stmt.setInt(++i, anexoTO.getNumeroSequencialArquivo());
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}

	}

	public int consultarMax(AnexoTO anexoTO) throws ExceptionPersistenciaPRO {
		StringBuffer sql = new StringBuffer("SELECT MAX(");
		sql.append(numeroSequencialArquivoAnexado);
		sql.append(") AS ");
		sql.append(numeroSequencialArquivoAnexado);
		sql.append(" FROM ");
		sql.append(tabela);
		sql.append(" WHERE 1=1");

		if ((anexoTO.getAnoCriacao() != null) && (!anexoTO.getAnoCriacao().trim().equals("")))
			sql.append(" AND " + anoCriacao + " = " + anexoTO.getAnoCriacao());

		if (anexoTO.getNumeroSequencialTarefa() != 0)
			sql.append(" AND " + numeroSequencialTarefa + " = " + anexoTO.getNumeroSequencialTarefa());

		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = getConnection().prepareStatement(sql.toString());
			result = stmt.executeQuery();
			while (result.next()) {
				return result.getInt(numeroSequencialArquivoAnexado) + 1;
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new ExceptionPersistenciaPRO(e.getMessage());
		}
		return 0;
	}

	
	private AnexoTO carregarTO(ResultSet resultado) throws SQLException {

		AnexoTO anexoTO = new AnexoTO();
		anexoTO.setAnoCriacao(String.valueOf(resultado.getInt(1)));
		anexoTO.setNumeroSequencialTarefa(resultado.getInt(2));
		anexoTO.setNumeroSequencialArquivo(resultado.getInt(3));
		anexoTO.setCodUsuario(resultado.getInt(4));
		anexoTO.setNome(resultado.getString(5));
		anexoTO.setTextoTipoConteudo(resultado.getString(6));
		anexoTO.setQuantByteAnexo(resultado.getInt(7));
		anexoTO.setTsCriacaoAnexo(resultado.getTimestamp(8));
		anexoTO.setTsCriacaoAnexoS(new DataUtil().getTimestampFormatoComum(anexoTO.getTsCriacaoAnexo()));
		anexoTO.setQuantFracaoAnexo(resultado.getInt(9));

		return anexoTO;
	}

	public byte[] download(AnexoTO anexoTO) throws ExceptionPersistenciaPRO {
		return null;
	}

}