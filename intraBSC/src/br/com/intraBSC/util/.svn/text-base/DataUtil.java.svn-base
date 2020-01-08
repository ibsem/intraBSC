package br.com.intraBSC.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DataUtil {
	private static Locale locale = new Locale("portugu?s", "Brasil");
	private Date date;
	//formata??o para o DB2
	private SimpleDateFormat sdfDB2 = new SimpleDateFormat("yyyyMMddHHmmss");
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSS");
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy    HH:mm:ss");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
	/*private SimpleDateFormat sdf4 = new SimpleDateFormat("mm:ss");*/
	private SimpleDateFormat sdf5 = new SimpleDateFormat("dd.MM.yyyy");
	
	private static String FORMATO_DATA = "dd/MM/yyyy";

	public DataUtil() {
		this.date = new Date();
	}
	public DataUtil(String datastring) {
		setData(datastring);
	}
	
	public DataUtil(Date dt) {
		this.date = dt;
	}

	public DataUtil(java.sql.Date dt) {
		this.date = dt;
	}

	//Compara uma data com a data atual
	public boolean comparaDatas(java.sql.Date dataAcomparar) throws Exception{
	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
	    Date minhaData = format.parse(formataDataSql(dataAcomparar));
	    if (minhaData.after(new Date())) {  
	      return false;  
	    } else if (minhaData.before(new Date())){  
	      return true;  
	    }
		return false;  
	}
	
	public String getData() {
		return sdf2.format(this.date); //formato = dd/MM/yyyy
	}
	
	
	public Date getDate() {
		return this.date;
	}
	
	public int getDiaSemana() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(this.date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	//Recupera dia da data atual
	public int getDia() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(this.date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	//Recupera dia da data passada por parametro
	public int getDia(Date data) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(data);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	//esse metodo esta sendo copiado 	
	public int getDiaMes(Date data) {
	 if(data!=null){
	 	Calendar calendar = new GregorianCalendar();
		calendar.setTime(data);
		return calendar.get(Calendar.DAY_OF_MONTH);
	 } else {
	 	return 0;
	 }
	}
	
	//esse metodo esta sendo copiado 	
	@SuppressWarnings("static-access")
	public int getMes() {
   		Calendar dataHoje;
   		int mes;
   		dataHoje = new GregorianCalendar();
   		mes = dataHoje.get(Calendar.MONTH);
		return mes;	
	}
	
	public String getHora() {
		return sdf3.format(this.date); //formato = hh:mm:ss
	}
	
	public void setData(String datastring) {
		/*como a data que a jsp est? passando para o banco de dados pode ser null, este m?todo deve contemplar
		 * esta situa?ao
		 */

		if(datastring.equals("")){
			datastring = "";
		}
		else{
			int ano = Integer.parseInt(datastring.substring(6, 10));
			int mes = Integer.parseInt(datastring.substring(3, 5)) - 1;
			int dia = Integer.parseInt(datastring.substring(0, 2));
			this.date = new GregorianCalendar(ano, mes, dia).getTime();
		}
	}
	
	public void setData(Date dt) {
		this.date = dt;
	}

	public void setData(java.sql.Date dt) {
		this.date = dt;
	}

	public void setHora(String horastring) {

		//pega a data atual:
		String horastr = this.getHora();
		int horaDataCal = Integer.parseInt(horastr.substring(0, 2));
		int minutosDataCal = Integer.parseInt(horastr.substring(3, 5));
		int segundosDataCal = Integer.parseInt(horastr.substring(6, 8));
		int horaInformada = Integer.parseInt(horastring.substring(0, 2));
		int minutosInformada = Integer.parseInt(horastring.substring(3, 5));
		int segundosInformada = Integer.parseInt(horastring.substring(6, 8));

		this.somaHora(horaInformada - horaDataCal);
		this.somaMinuto(minutosInformada - minutosDataCal);
		this.somaSegundo(segundosInformada - segundosDataCal);

	}

	private Date executaCalculoDataHora(int quantidade, int parcelaTempo) {
		Calendar calend = new GregorianCalendar();
		calend.setTime(this.date);
		
		calend.add(parcelaTempo, quantidade);
		return this.date = calend.getTime();
	}

	public Date soma(int dias) {
		Date result = executaCalculoDataHora(dias, Calendar.DATE);
		return result;
	}

	
	public void somaHora(int horas) {
		executaCalculoDataHora(horas, Calendar.HOUR_OF_DAY);

	}

	public void somaMinuto(int minutos) {
		executaCalculoDataHora(minutos, Calendar.MINUTE);
	}

	public void somaSegundo(int segundos) {
		executaCalculoDataHora(segundos, Calendar.SECOND);
	}

	public Timestamp getTimestampAtual() {
		Calendar calendario = Calendar.getInstance();
		Timestamp dataAtual = new Timestamp(calendario.getTime().getTime());		
		return dataAtual;
	}
	
	public static Timestamp getTimestamp(long varTime) {
		Timestamp dataAtual = new Timestamp(varTime);		
		return dataAtual;
	}
		
	public String getDataFormatoDB2() {		
		return getData().replace('/', '.') ;
	}

	public String getHorarioFormatoDB2() {
		return getHora();
	}

	
	public static final Date strToDate(String pStrData) throws Exception{
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", locale);
	        return sdf.parse(pStrData);
	    }catch (Exception e) {
	        throw new Exception("Data invalida");
	    }
	}
	
	public static final java.sql.Date strToDateSql(String pStrData) throws Exception{
		try{
			java.sql.Date data = new java.sql.Date(strToDate(pStrData).getTime());
	        return data;
	    }catch (Exception e) {
	        throw new Exception("Data invalida");
	    }
	}
	 
	public String getTimestampFormatoComum(Timestamp timestamp) {
		return sdf1.format(timestamp) ;
	}
	/**
	 * Tiago Stangarlin - 08/07/2005
	 * Metodo que formata um timestamp e retorna uma string
	 * */
	public String getTimestampFormatoSemHora(Timestamp timestamp) {
		return sdf2.format(timestamp) ;
	}
	
	public String getTimestampFormatoDB2() {
		return sdfDB2.format(getDate()) ;
	}

	public String getDataFormatoDB2(Date data) {
		return sdf5.format(data) ;
	}
	
	public String getData(Date data) {
		return sdf2.format(data) ;
	}


	public String getHorarioFormatoDB2(Time time) {
		return time.toString();
	}

	public String getTimestampFormatoDB2(Timestamp timestamp) {
		return sdf.format(timestamp);
	}
	


	public Timestamp getTimestamp() {
		return new Timestamp(this.getDate().getTime());
	}

	public java.sql.Date getSQLDate() {
		return new java.sql.Date(this.getDate().getTime());
	}
	
	
	public java.sql.Date getSQLDate(String datas) {
		if(datas.equals("")){
			return null;
		}
		else{
			setData(datas);
			return new java.sql.Date(this.getDate().getTime());
		}
	}
	
	//m?todo retorna o ano da data de hoje
	public int getAnoDataAtual(){
   		Calendar dataHoje;
   		int ano;
   		dataHoje = new GregorianCalendar();
   		ano = dataHoje.get(Calendar.YEAR);

		return ano;	
	}
	//m?todo retorna a data de hoje
	public Date getDataAtual(){
		Calendar dataAtual = Calendar.getInstance();
   		Date tempo = dataAtual.getTime();		
   		return tempo;
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
 	 * Formata uma java.sql.Date em String usando o pattern "dd/mm/yyyy"
	 * @param data
	 * @return
	 */
	//	Recebe uma sql date e retrona uma String
	public static String formataDataSql(java.sql.Date data) throws ParseException{
		SimpleDateFormat formatador = new SimpleDateFormat(FORMATO_DATA);
		String dataFormatada = "";
		if(data!=null){
		     dataFormatada = formatador.format(data);
		}else{
		    dataFormatada = "";
		}
		return dataFormatada.toString();
	}

	
    //metodo que retorna a diferenca entre duas datas.
    public long getDiferencaEmDias(Date dtMenor, Date dtMaior) {
        return ( dtMaior.getTime() - dtMenor.getTime() ) / ( 1000*60*60*24 );
    }
    
    public Date getParseData(String data) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        Date dataConvertida = df.parse(data);
        return dataConvertida;
    }
    
    public java.sql.Date formataData(java.sql.Date data) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        setData(data);
        java.sql.Date dataConvertida = new java.sql.Date(df.parse(getData()).getTime());
        return dataConvertida;
    }
    
    public Date transformaSQLUtilDate(java.sql.Date data){
    	Date dataUtil = new Date(data.getTime());
    	return dataUtil;
    }
    
 }
