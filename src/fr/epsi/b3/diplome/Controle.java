package fr.epsi.b3.diplome;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Controle extends Examen{
	private float note;
	private String code;
	private Date date;
	private String appreciation= "";
	
	@Override
	public float getNote() {
		return note;
	}
	
	@Override
	public String getCode() {
		return code;
	}
	
	@Override
	public void setDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToTest = formatter.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateToTest);
		if(cal.get(Calendar.MONTH) == Calendar.OCTOBER || cal.get(Calendar.MONTH) == Calendar.NOVEMBER || cal.get(Calendar.MONTH) == Calendar.DECEMBER 
				|| cal.get(Calendar.MONTH) == Calendar.JANUARY || cal.get(Calendar.MONTH) == Calendar.FEBRUARY || cal.get(Calendar.MONTH) == Calendar.MARCH 
				|| cal.get(Calendar.MONTH) == Calendar.APRIL || cal.get(Calendar.MONTH) == Calendar.MAY || cal.get(Calendar.MONTH) == Calendar.JUNE) {
			if(cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				this.date =  dateToTest;
			}
		}
	}
	
	@Override
	public Date getDate() {
		return date;
	}
	
	@Override
	public void setNote(float note) {
		if(note > 20 || note < 0) {
			throw new IllegalArgumentException("Une note ne peut pas être inférieure à 0 ou supérieure à 20");
		}
		else {
			this.note = note;			
		}
	}
	
	@Override
	public String toString() {
		DateTimeFormatter frenchDatePattern = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRANCE);
		LocalDate dateToFormat = this.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMaximumFractionDigits(2);
		return df.format(this.note) + "/20 à l'examen du " + dateToFormat.format(frenchDatePattern);
	}
	
	@Override
	public void setAppreciation(String appreciation) {
		this.appreciation += appreciation + " ";
	}
	
	@Override
	public String getAppreciation() {
		return appreciation;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
		
	}
}
