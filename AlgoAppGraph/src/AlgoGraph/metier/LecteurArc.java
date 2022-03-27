package AlgoGraph.metier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LecteurArc {
	static ArrayList<String> graphe = new ArrayList<String>();
	static ArrayList<String> arc = new ArrayList<String>();

	/**
	 * Méthode qui retourne le pseudo code sans couleur
	 * @return pseudo code pur
	 */
	public ArrayList<String> getGraphe() {
		return graphe;	
	}

	public ArrayList<String> getArc() {
		return arc;	
	}

	/**
	 * Constructeur de LecteurFichier
	 * Permet de lire et stocker les données entrantes d'un fichier pris en paramètre
	 * @param fichier appelé en argument dans la console
	 */
	public LecteurArc()
	{
		// On essaye de lire le .grph
		File doc =
          new File("C:\\Users\\etien\\Documents\\Github\\AlgoAppGraph\\AlgoAppGraph\\src\\AlgoGraph\\arc.txt");  
		try (Scanner obj = new Scanner(doc)) {
			while (obj.hasNextLine())
			  	arc.add(obj.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}