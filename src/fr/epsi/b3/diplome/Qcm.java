package fr.epsi.b3.diplome;

public class Qcm extends Controle {
	
	private int nbQuestions;
	private float note;
	
	public Qcm(int nbQuestions) {
		if(nbQuestions <= 0) {
			throw new IllegalArgumentException("Le nombre de questions pour un QCM ne peut être négatif ou nul");
		}
		else {
			this.nbQuestions = nbQuestions;
		}
	}
	
	public void setResponsesCorrecte(int reponse) {
		if(reponse < 0 || this.nbQuestions < reponse) {
			throw new IllegalArgumentException("Le nombre de réponses correctes ne peut pas être supérieures au nombre de questions d'un QCM");
		}
		else {
			this.setNote(reponse / (float) nbQuestions * 20);
		}
	}
	
	public void setNote(float note) {
		super.setNote(note);
	}
	
	public void setAppreciation(String appreciation) {
		if(this.getNote()<8)
			super.setAppreciation("Insuffisant");
		else if(this.getNote() >= 8 && this.getNote() < 12)
			super.setAppreciation("Passable");
		else if(this.getNote() >= 12 && this.getNote() <= 15)
			super.setAppreciation("Bien");
		else if(this.getNote() >= 16)
			super.setAppreciation("Très bien");
	}
	
	public void setNote(String code) {
		super.setCode(code);
	}
}
