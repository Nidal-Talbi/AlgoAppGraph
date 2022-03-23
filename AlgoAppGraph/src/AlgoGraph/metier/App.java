package AlgoGraph.metier;

import java.util.ArrayList;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class App {
	private Graph graph;
	public App(ArrayList<String> Graphe)
	{
		System.setProperty("org.graphstream.ui", "swing");
		
		this.graph = new SingleGraph("Graphe");

		for(int i=0; i < Graphe.size();i++)
		{
			String[] line = Graphe.get(i).split(" ");
			if(line.length == 1)
			{
				graph.addNode(line[0]);
			}
			else if (line.length == 3)
			{
				graph.addEdge(line[0], line[1], line[2]);
				graph.getEdge(line[0]).setAttribute("poids", 1);
			}
			else if (line.length == 4)
			{
				graph.addEdge(line[0], line[1], line[2]);
				graph.getEdge(line[0]).setAttribute("poids", line[3]);
			}
		}
		graph.display();
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
