//Source file: c:\\Java\\workspace\\AD\\WEB-INF\\src\\br\\com\\bb\\apoiodesenvolvimentoproducao\\ad\\util\\Formatador.java
 
package br.com.intraPRO.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

 
/**
 * Classe utilitária para formatação de dados.
 * @author CETI
 * @version 1.0
 */
public class Formatador {
	
	private static String FORMATO_DATA = "dd/MM/yyyy";
	/*private static String FORMATO_HORARIO = "HH:mm:ss";
	private static String FORMATO_HORA = "HH";
	private static String FORMATO_MINUTO = "mm";*/
	private static String FORMATO_TIMESTAP = "dd/MM/yyyy HH:mm:ss";
	
	/**
	 * Formata uma java.util.Date em String usando o pattern "dd/mm/yyyy"
	 * @param data
	 * @return
	 */
	//Recebe uma util date e retrona uma String
	public static String formataDataUtil(Date data) {	
		SimpleDateFormat formatador = new SimpleDateFormat(FORMATO_DATA);
		String dataFormatada = formatador.format(data);
		return dataFormatada;
	}
	
	/**
 	 * Formata uma java.sql.Date em String usando o pattern "dd/mm/yyyy"
	 * @param data
	 * @return
	 */
	//	Recebe uma sql date e retrona uma String
	public static String formataDataSql(java.sql.Date data) throws ParseException{
		SimpleDateFormat formatador = new SimpleDateFormat(FORMATO_DATA);
		String dataFormatada = formatador.format(data);
		return dataFormatada.toString();
	}

	/**
	 * Formata uma java.sql.Timestamp em String usando o pattern "dd/mm/yyyy"
	 * @param timestamp
	 * @return
	 */
	//	Recebe uma timestamp e retrona uma String timestamp
	public static String formataTimestamp(Timestamp timestamp) {
		SimpleDateFormat formatador = new SimpleDateFormat(FORMATO_TIMESTAP);
		String dataFormatada = formatador.format(timestamp);
		return dataFormatada;
	}

	/**
	 * Formata uma java.sql.Timestamp em String usando o pattern "dd/mm/yyyy"
	 * @param timestamp
	 * @return
	 */
	//	Recebe uma timestamp e retrona uma String Data
	public static String formataData(Timestamp timestamp) {
		SimpleDateFormat formatador = new SimpleDateFormat(FORMATO_DATA);
		String dataFormatada = formatador.format(timestamp);
		return dataFormatada;
	}


	/**
	 * Formata uma String em java.sql.Date usando o pattern "dd/mm/yyyy"
	 * @param data
	 * @return
	 */	
	//	Recebe uma String e retrona um sql date
	public static java.sql.Date formataDataSql(String data) throws ParseException {
		SimpleDateFormat formatador = new SimpleDateFormat(FORMATO_DATA);
		java.util.Date dataFormatada = formatador.parse(data);
		return new java.sql.Date(dataFormatada.getTime());		
	}
	
	/**
 	 * Formata uma String em java.util.Date usando o pattern "dd/mm/yyyy"
	 * @param data
	 * @return
	 */	
	//	Recebe uma String e retrona uma util date
	public static Date formataDataUtil(String data) throws ParseException{
		SimpleDateFormat formatador = new SimpleDateFormat(FORMATO_DATA);
		Date dataFormatada = formatador.parse(data);
		return dataFormatada;
		}
}
