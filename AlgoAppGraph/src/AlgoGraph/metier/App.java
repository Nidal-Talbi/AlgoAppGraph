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
				this.graph.getEdge(line[0]).addAttribute("poids", 1);
			}
			else if (line.length == 4)
			{
				this.graph.addEdge(line[0], line[1], line[2]);
				this.graph.getEdge(line[0]).addAttribute("poids", line[3]);
			}
			this.ligne++;
		}
		for (Node node : graph) {
			node.setAttribute("ui.label", node.getId());
		}
		this.graph.display();
	}

	public void marquerRelation(String chemin) {
		for(int i=0; i < chemin.length()-1; i++)
		{
			graph.getEdge(chemin.substring(i, i+2)).setAttribute("ui.style", "fill-color: red;");
		}
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

	public String verifierRelation(String nomSommetA, String nomSommetB)
	{
		String nomRelationVerifier = "";

		if(this.graph.getEdge(nomSommetA+nomSommetB) == null && this.graph.getEdge(nomSommetB+nomSommetA) == null && nomSommetA != nomSommetB)
		{
			nomRelationVerifier = nomSommetA+nomSommetB;
		}

		return nomRelationVerifier;
	}

	public void ajouterSommet(String nomSommet)
	{
		this.graph.addNode(nomSommet);
	}

	public void ajouterRelation(String nomSommetA, String nomSommetB, int poid)
	{
		this.graph.addEdge(nomSommetA+nomSommetB, nomSommetA, nomSommetB);
		this.graph.getEdge(nomSommetA+nomSommetB).addAttribute("poids", poid);
	}

	public int nbSommet()
	{
		return this.graph.getNodeCount();
	}

	public int distance(String u, String v)
	{	
		String res = String.valueOf(u+v);
		return Integer.parseInt(this.graph.getEdge(res).getAttribute("poids").toString());
	}

	public String getSommet(int i) {
		return String.valueOf(this.graph.getNode(i));
	}
}
