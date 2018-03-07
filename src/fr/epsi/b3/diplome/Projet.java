package fr.epsi.b3.diplome;

import java.util.Date;

public class Projet extends Controle {
	
	public void setNote(float oral, float ecrit) {
		if(oral < 0 || oral > 10 || ecrit < 0 || ecrit > 10) {
			throw new IllegalArgumentException("Les notes d'un projet ne doivent pas être inférieures à 0 ou supérieures à 10");
		}
		super.setNote(oral + ecrit);
	}
	
	public void setAppreciationOral(String appreciation) {
		super.setAppreciation(appreciation);
	}
	
	public void setAppreciationEcrit(String appreciation) {
		super.setAppreciation(appreciation);
	}

	/*@Override
	public void setNote(float note) {
		super.setNote(note);
	}*/
	
	public void setDate(Date date) {
		
	}
	
	public void setCode(String code) {
		super.setCode(code);
	}

}
