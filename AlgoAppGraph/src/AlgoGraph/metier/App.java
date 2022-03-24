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
		this.graph.display();
	}

	public void relancerGraph(ArrayList<String> Graphe)
	{
		System.out.println(this.ligne);
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
		}
		this.ligne++;
		this.graph.display();

	}
	public int nbSommet()
	{
		return this.graph.getNodeCount();
	}

	public int distance(String u, String v)
	{	
		String res = u+v;
		return Integer.parseInt(String.valueOf(this.graph.getEdge(res).getAttribute("poids")));
	}

	public String getSommet(int i) {
		return String.valueOf(this.graph.getNode(i));//pas sûr de cette méthode
	}
}
