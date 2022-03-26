package AlgoGraph.metier;

import java.util.ArrayList;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class App {
	private Graph graph;
	private int ligne = 0;
	public App(ArrayList<String> Graphe)
	{
		System.setProperty("org.graphstream.ui", "swing");
		
		this.graph = new SingleGraph("Graphe");

		while(this.ligne < Graphe.size())
		{
			String[] line = Graphe.get(ligne).split(" ");
			if(line.length == 1)
			{
				this.graph.addNode(line[0]);
			}
			else if (line.length == 3)
			{
				this.graph.addEdge(line[0], line[1], line[2]);
				this.graph.getEdge(line[0]).setAttribute("poids", 1);
			}
			else if (line.length == 4)
			{
				this.graph.addEdge(line[0], line[1], line[2]);
				this.graph.getEdge(line[0]).setAttribute("poids", line[3]);
			}
			this.ligne++;
		}
		for(int i=0;i<3;i++) {
			Node nd = graph.addNode("v_"+i);
			nd.setAttribute("ui.label",nd.getId());
		}
		this.graph.display();
	}

	public boolean existe(String s1, String s2)
	{
		
		return false;
	}

	public String verifierNomSommet(String nomSommet)
	{
		String nomSommetVerifier = "";

		if(this.graph.getNode(nomSommet) == null)
		{
			nomSommetVerifier = nomSommet;
		}

		return nomSommetVerifier;
	}

	public void ajouterSommet(String nomSommet)
	{
		this.graph.addNode(nomSommet);
	}
	public int nbSommet()
	{
		return this.graph.getNodeCount();
	}

	public int distance(String u, String v)
	{	
		String res = String.valueOf(u+v);
		return Integer.parseInt(String.valueOf(this.graph.getEdge(res).getAttribute("poids")));
		//return 1;
	}

	public String getSommet(int i) {
		return String.valueOf(this.graph.getNode(i));
	}
}
