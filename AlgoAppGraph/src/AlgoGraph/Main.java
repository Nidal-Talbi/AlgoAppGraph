package AlgoGraph;

import java.io.IOException;

import AlgoGraph.ihm.SelectionFichier;

public class Main {

	private static Main instance;
	
	/**
	 * Constructeur de Main, l'ensemble du programme
	 * @throws IOException
	 */
	public Main() throws IOException
	{
		instance = this;
		new SelectionFichier().setVisible(true);
	}
	
	/**
	 * getInstance()
	 * @return l'instance de Main en cours
	 */
	public static Main getInstance() {
		return instance;
	}

	public static void main (String[] args) throws Exception{
		new Main();
	}
}
