package fr.epsi.b3.diplome;

import java.text.ParseException;
import java.util.List;

import fr.epsi.b3.diplome.Diplome.Mention;

public class Application {

	public static void main(String[] args) throws DiplomeEchecException, ParseException {
		Diplome diplome = new Diplome();
		
		Controle controle = new Controle();
		controle.setNote(15);
		controle.setAppreciation("Correct");
		controle.setCode("TEST001");
		controle.setDate("14/02/2018");
		
		Qcm qcm = new Qcm(30);
		qcm.setResponsesCorrecte(22);
		qcm.setAppreciation("");
		qcm.setCode("TEST011");
		qcm.setDate("15/02/2018");
		
		Projet projet = new Projet();
		projet.setNote(9, 7);
		projet.setAppreciationOral("TrËs bon ‡ l'oral.");
		projet.setAppreciationEcrit("Moins bien ‡ l'Ècrit");
		projet.setCode("TEST009");
		projet.setDate("12/02/2018");
		
		diplome.setExamens(controle, projet, qcm);
		
		if (diplome.isValide()) {
			System.out.println("Bravo, vous avez obtenu votre dipl√¥me !");
			Mention mention= diplome.getMention();
			System.out.println("Mention " + mention);
		} else {
			System.out.println("Vous n'avez pas obtenu votre dipl√¥me !");
		}
		
		diplome.deleteExamenBeforeDate("13/02/2018");
		
		diplome.afficherDetailDesNotes();
		
		List<Examen> examenFilter = diplome.getExamenUnderNote(12);
		for(Examen exam : examenFilter) {
			System.out.println("Note en dessous de 12 : "+ exam.getNote());
		}
		
		for(Examen exam : diplome.getExamens(new TriParCode())) {
			System.out.println("Tri par code : "+ exam.getCode());
		}
		
		for(Examen exam : diplome.getExamens(new TriParNote())) {
			System.out.println("Tri par note : "+ exam.getNote());
		}
		
		for(Examen exam : diplome.getExamens(new TriParDate())) {
			System.out.println("Tri par date : "+ exam.getDate());
		}
	}
}
