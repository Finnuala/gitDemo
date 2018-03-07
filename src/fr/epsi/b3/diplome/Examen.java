package fr.epsi.b3.diplome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Examen {

	private String code;
	/*private float note;
	private Date date;
	private String appreciation= "";*/

	public abstract float getNote();
	
	public abstract String getCode();
	
	public abstract void setCode(String code);
	
	public abstract void setDate(String date) throws ParseException;
	
	public abstract Date getDate();
	
	public abstract String toString();
	
	public abstract void setNote(float note);
	
	public abstract void setAppreciation(String appreciation);

	public abstract String getAppreciation();

}
