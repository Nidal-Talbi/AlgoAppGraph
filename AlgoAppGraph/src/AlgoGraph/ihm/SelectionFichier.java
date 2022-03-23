package AlgoGraph.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AlgoGraph.metier.App;
import AlgoGraph.metier.BellmanFord;
import AlgoGraph.metier.LecteurArc;
import AlgoGraph.metier.LecteurFichier;


public class SelectionFichier extends JFrame implements ActionListener{

    private JButton button,button2;
    private LecteurFichier lecteurGraphe;
    private LecteurArc lecteurArc;
    private App app;

  public static void main(String[] args) {
    /* init + affichage de la fenêtre */
    new SelectionFichier().setVisible(true);
  }
  
  public SelectionFichier() {
    /* init de la fenêtre */
    setSize(200, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    JLabel titre = new JLabel("AlgoAppGraph");

    /* init du bouton qui va afficher le FileChooser */
    button = new JButton("Ouvrir un Fichier Graphe");
    button.addActionListener(this);

    button2 = new JButton("Créer un Fichier Graphe");
    /* ajout du listener qui prend en charge l'action sur le click */
    button2.addActionListener(this);
    
    /* ajout du bouton à la fenêtre */
    JPanel p = new JPanel();
    p.add(titre);
    p.add(button);
    p.add(button2);
    setContentPane(p);
  }
  
  public void actionPerformed(ActionEvent e) {

    Object  source=e.getSource();
        
    if(source==this.button)
    {
        /* init du filechooser */
        JFileChooser fc = new JFileChooser();
        /* affichage du dialog et test si le bouton ok est pressé */
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            /* demande au système d'ouvrir le fichier précédemment séléctionné */
            this.lecteurGraphe = new LecteurFichier(fc.getSelectedFile().getAbsolutePath());
            this.lecteurArc = new LecteurArc("arc.txt");
            this.app = new App(this.lecteurGraphe.getGraphe());
            new BellmanFord(this.app, this.lecteurArc);
        }
    }
    else if (source==button2)
    {
        new CreationDeGraphe().setVisible(true);
    }
  }
}