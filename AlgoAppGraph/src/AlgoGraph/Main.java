package AlgoGraph;

import java.io.IOException;

import AlgoGraph.metier.App;
import AlgoGraph.metier.LecteurFichier;

public class Main {

	private LecteurFichier lecteur;
	private static Main instance;
	static String fichier;
	int limiteLine = 0;
	
	/**
	 * Constructeur de Main, l'ensemble du programme
	 * @throws IOException
	 */
	public Main() throws IOException
	{
		instance = this;
		this.lecteur = new LecteurFichier(fichier);
		new App(this.lecteur.getGraphe());
	}
	
	/**
	 * getInstance()
	 * @return l'instance de Main en cours
	 */
	public static Main getInstance() {
		return instance;
	}
	
/**
 * Démarrage
 * @param args Fichier à prendre en paramètre (si c'est Exemple1.algo, alors ce sera Exemple1 à entrer)
 * @throws Exception
 */
	public static void main (String[] args) throws Exception{
		//fichier = "../files/" + args[1];
		new Main();
	}
}
