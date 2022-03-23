package AlgoGraph.metier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * BellmanFord
 */
public class BellmanFord {
    private App app;
    private HashMap<String,Integer> hashArc;
    private LecteurArc lfArc;
    public BellmanFord(App app, LecteurArc lecteurArc)
    {
        this.app = app;
        this.hashArc = new HashMap<String,Integer>();
        this.lfArc   = lecteurArc;

        for (int i = 0; i < app.nbSommet(); i++) {
            if (i == 0)
            {
                this.hashArc.put(app.getSommet(i), 0);
            } else {
                this.hashArc.put(app.getSommet(i), Integer.MAX_VALUE);
            }
        }
        int cpt=0;
        while (cpt < app.nbSommet() -1 ) {
            for (String str : lfArc.getArc()) {
                String res = lfArc.getArc().get(cpt); //(a,b)
                String u   = String.valueOf(res.substring(1));
                String v   = String.valueOf(res.substring(3));
                if ( hashArc.get(v) > hashArc.get(u) + app.distance(u,v))
                {
                    hashArc.remove(v);
                    hashArc.put(v, hashArc.get(u) + app.distance(u,v));
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
}