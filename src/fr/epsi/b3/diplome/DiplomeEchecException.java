package fr.epsi.b3.diplome;

public class DiplomeEchecException extends Exception{
	
	public DiplomeEchecException() {
		super("Echec du diplome, il ne peut �tre d�livr� en raison d'une moyenne trop faible");
	}

}
