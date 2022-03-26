package AlgoGraph.metier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * BellmanFord
 */
public class BellmanFord {
    private int[][] tabBelmman = new int[100][100];
    private App app;
    private HashMap<String,Integer> hashArc;
    private LecteurArc lfArc;
    public BellmanFord(App app, LecteurArc lecteurArc)
    {
        this.app = app;
        this.hashArc = new HashMap<String,Integer>();
        this.lfArc   = lecteurArc;
        init();
        algo();
        tabBel();
        System.out.println(tabToString());

        System.out.println("Le chemin le plus cours est " + cheminPlusCourt());
    }

    public void init()
    {
        for (int i = 0; i < app.nbSommet(); i++) {
            if (i == 0)
            {
                this.hashArc.put(app.getSommet(i), 0);
            } else {
                this.hashArc.put(app.getSommet(i), 1000);
            }
            tabBelmman[0][i] = this.hashArc.get(app.getSommet(i));
        }
    }

    public void algo()
    {
        int cpt=0;
        while (cpt < app.nbSommet() -1 ) {
            for (int cpt2=0;cpt2 < lfArc.getArc().size();cpt2++) {
                String res = lfArc.getArc().get(cpt2); //(a,b)
                String u   = String.valueOf(res.charAt(1));
                String v   = String.valueOf(res.charAt(3));
                if ( hashArc.get(v) > hashArc.get(u) + app.distance(u,v))
                {
                    hashArc.replace(v, hashArc.get(u) + app.distance(u,v));
                }
            }
            cpt++;
        }
    }

    public void tabBel()
    {
        for (int i = 0; i < this.app.nbSommet(); i++) {
            for (int j = 0; j < this.app.nbSommet(); j++) {
                if(i != 0)
                {
                    tabBelmman[i][j] = hashArc.get(app.getSommet(j));
                }
                if ( j == 0 )
                {
                    tabBelmman[i][j] = 0;
                }
            }
        }
    }



    public Integer[] intoTab()
    {
        Integer[] tab = new Integer[this.hashArc.size()];
        Integer cpt=0;
        for (Map.Entry<String,Integer> entry : hashArc.entrySet()) {
            tab[cpt] = entry.getValue();
            cpt++;
        }
        Arrays.sort(tab);
        return tab;
    }

    public String cheminPlusCourt()
    {
        Integer[] tab = this.intoTab();
        String sRet = "";
        for (int i = 0; i < this.hashArc.size(); i++) {
            if (tab[i] == this.hashArc.get(this.app.getSommet(i)))
            {
                sRet += this.app.getSommet(i);
            }
        }
        return sRet;
    }

    public String tabToString()
    {
        String tab = "";

        tab += "┌─────────────────┬";
        for(int i=0; i < this.app.nbSommet();i++)
        {
            tab += "───────┬";
        }
        tab += "───────┐\n";
        tab+=  "│   ETAPE/NOEUD   |";
        for(int i=0; i < this.app.nbSommet();i++)
        {
            tab += String.format("%-7s", this.app.getSommet(i)) + "│";
        }
        tab += String.format("%-7s", this.app.getSommet(this.app.nbSommet())) + "│\n";
        tab += "├─────────────────├";
        for(int i=0; i < this.app.nbSommet();i++)
        {
            tab += "───────┴";
        }
        tab += "───────┴\n";

        int cpt=0;

        while(cpt < this.app.nbSommet()-1)
        {
            tab += "│" + String.format("%-17s", cpt) + "│";

            for(int i=0; i < this.app.nbSommet();i++)
            {
                tab += String.format("%-7s", tabBelmman[cpt][i]) + "│";
            }
            tab += String.format("%-7s", tabBelmman[cpt][this.app.nbSommet()]) + "│\n";
            cpt++;
        }
        tab += "└─────────────────┴";
        for(int i=0; i < this.app.nbSommet();i++)
        {
            tab += "───────┴";
        }
        tab += "───────┴\n";
        return tab;
    }
}