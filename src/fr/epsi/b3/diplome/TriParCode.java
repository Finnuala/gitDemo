package fr.epsi.b3.diplome;

import java.util.Comparator;

public class TriParCode implements Comparator<Examen>{

	@Override
	public int compare(Examen a, Examen b)
	{
		return a.getCode().compareTo(b.getCode());
	}
}
