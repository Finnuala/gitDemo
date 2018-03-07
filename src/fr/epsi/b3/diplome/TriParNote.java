package fr.epsi.b3.diplome;

import java.util.Comparator;

public class TriParNote implements Comparator<Examen>{

	@Override
	public int compare(Examen o1, Examen o2) {
		if (o1.getNote() < o2.getNote()) {
			return 1;
		} 
		else if (o1.getNote() > o2.getNote()) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
