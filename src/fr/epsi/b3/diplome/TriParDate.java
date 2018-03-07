package fr.epsi.b3.diplome;

import java.util.Comparator;

public class TriParDate implements Comparator<Examen>{

	@Override
	public int compare(Examen o1, Examen o2) {
		if (o1.getDate().before(o2.getDate())) {
            return 1;
        } 
		else if (o2.getDate().before(o1.getDate())) {
            return -1;
        } 
		else {
            return 0;
        }   
	}

}
