package AlgoGraph.metier;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LecteurFichier {
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
	public LecteurFichier(String fichier)
	{
	
		// On essaye de lire le .grph
		if (fichier.split("\\.")[1].equals("grph"))
		{
			try (Scanner sc = new Scanner(new FileInputStream(fichier), "UTF-8"))
			{
				while (sc.hasNext())
					graphe.add(sc.nextLine());
			}
			catch(IOException e)
			{
				System.out.println("Aucun fichier trouvé en .grph à exécuter avec le nom spécifié.\n");
			}
		} else if (fichier.split("\\.")[1].equals("txt"))
		{
			try (Scanner sc = new Scanner(new FileInputStream(fichier), "UTF-8"))
			{
				while (sc.hasNext())
					arc.add(sc.nextLine());
			}
			catch(IOException e)
			{
				System.out.println("Aucun fichier trouvé en .grph à exécuter avec le nom spécifié.\n");
			}
		} else {
			System.out.println("Erreur de fichier");
		}
	}
}