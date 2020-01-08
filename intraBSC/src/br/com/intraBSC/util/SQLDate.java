package br.com.intraBSC.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SQLDate {

	private Date date;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSS");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
	private SimpleDateFormat sdf5 = new SimpleDateFormat("dd.MM.yyyy");

	public SQLDate() {
		this.date = new Date();
	}
	public SQLDate(String datastring) {
		setData(datastring);

	}
	public SQLDate(Date dt) {
		this.date = dt;
	}

	public SQLDate(java.sql.Date dt) {
		this.date = dt;
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
	public String getHora() {
		return sdf3.format(this.date); //formato = hh:mm:ss
	}
	public void setData(String datastring) {
		int ano = Integer.parseInt(datastring.substring(6, 10));
		int mes = Integer.parseInt(datastring.substring(3, 5)) - 1;
		int dia = Integer.parseInt(datastring.substring(0, 2));
		this.date = new GregorianCalendar(ano, mes, dia).getTime();
	}
	public void setData(Date dt) {
		this.date = dt;
	}

	public void setData(java.sql.Date dt) {
		this.date = dt;
//		adjustDateToCurrentTimeZone();
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

	private void executaCalculoDataHora(int quantidade, int parcelaTempo) {
		Calendar calend = new GregorianCalendar();
		calend.setTime(this.date);
		calend.add(parcelaTempo, quantidade);
		this.date = calend.getTime();
	}

	public void soma(int dias) {
		executaCalculoDataHora(dias, Calendar.DATE);
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

	public static Timestamp getTimestampAtual() {
		Calendar calendario = Calendar.getInstance();
		Timestamp dataAtual = new Timestamp(calendario.getTime().getTime());
		return dataAtual;
	}

	public String getDataFormatoDB2() {
		return getData().replace('/', '.') ;
	}

	public String getHorarioFormatoDB2() {
		return getHora();
	}

	public String getTimestampFormatoDB2() {
		return sdf.format(getDate()) ;
	}

	public String getDataFormatoDB2(Date data) {
		return sdf5.format(data) ;
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
	
	public java.sql.Date getSQLDateFormat()  throws ParseException {
		return getSQLDate(sdf2.format(getDate()));
	}
	
	public java.sql.Date getSQLDate(String datas) {
		if(datas.equals("")){
			return null;
		}else{
			setData(datas);
			return new java.sql.Date(this.getDate().getTime());
		}
	}
}
