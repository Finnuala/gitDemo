package fr.epsi.b3.diplome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Diplome {
	public enum Mention { 
		PASSABLE, 
		BIEN, 
		TRES_BIEN, 
		EXCELLENT;
	}
	
	private List<Examen> examens= new ArrayList<Examen>();

	public void setExamens(Examen ... examen) {
		this.examens.addAll(Arrays.asList(examen));
	}
	
	public List<Examen> getExamenUnderNote(float note){
		List<Examen> examensFilter = new ArrayList<Examen>();
		for(Examen examen : examens) {
			if(examen.getNote() < note) {
				examensFilter.add(examen);
			}
		}
		return examensFilter;
	}
	
	public void deleteExamenBeforeDate(String date) throws ParseException {
		List<Examen> examensToDell = new ArrayList<Examen>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateLimit = formatter.parse(date);
		for(Examen examen : examens) {
			if(examen.getDate().before(dateLimit)) {
				examensToDell.add(examen);
			}
		}
		this.examens.removeAll(examensToDell);
	}
	
	public boolean isValide() throws DiplomeEchecException {
		float total = 0;
		for (Examen examen : examens) {
			System.out.println(examen.getNote());
			total += examen.getNote();
		}
		if(total / examens.size() < 10) {
			delivrer();
		}
		return total / examens.size() >= 10;
	}
	
	public void afficherDetailDesNotes(){
		for(Examen examen : examens) {
			System.out.println(examen.getNote() + " " + examen.getAppreciation());
			System.out.println(examen.toString());
		}
	}
	
	private void delivrer() throws DiplomeEchecException {
		throw new DiplomeEchecException();
	}
	
	public Mention getMention() {
		float total = 0;
		Mention mentionDiplome = null;
		for (Examen examen : examens) {
			total += examen.getNote();
		}
		float moyenne = total / examens.size();
		if( moyenne >= 10 && moyenne < 12) {
			mentionDiplome = Mention.PASSABLE;
		}
		else if( moyenne >= 12 && moyenne < 14) {
			mentionDiplome = Mention.BIEN;
		}
		else if( moyenne >= 14 && moyenne < 16) {
			mentionDiplome = Mention.TRES_BIEN;
		}
		else if( moyenne >= 16) {
			mentionDiplome = Mention.EXCELLENT;
		}
		return mentionDiplome;
	}
	
	public List<Examen> getExamens(Comparator param){
		Collections.sort(examens, param);
		return this.examens;
		
	}
}
