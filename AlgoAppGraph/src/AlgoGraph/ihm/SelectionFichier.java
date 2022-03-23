package AlgoGraph.ihm;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AlgoGraph.metier.App;
import AlgoGraph.metier.LecteurFichier;


public class SelectionFichier extends JFrame implements ActionListener{

    private LecteurFichier lecteur;

  public static void main(String[] args) {
    /* init + affichage de la fenêtre */
    new SelectionFichier().setVisible(true);
  }
  
  public SelectionFichier() {
    /* init de la fenêtre */
    setSize(100, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    JLabel titre = new JLabel("AlgoAppGraph");
    /* init du bouton qui va afficher le FileChooser */
    JButton button = new JButton("Ouvrir un Fichier Graphe");
    /* ajout du listener qui prend en charge l'action sur le click */
    button.addActionListener(this);
    
    /* ajout du bouton à la fenêtre */
    JPanel p = new JPanel();
    p.add(titre);
    p.add(button);
    setContentPane(p);
  }
  
  public void actionPerformed(ActionEvent e) {
    /* init du filechooser */
    JFileChooser fc = new JFileChooser();
    /* affichage du dialog et test si le bouton ok est pressé */
    if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        /* demande au système d'ouvrir le fichier précédemment séléctionné */
        this.lecteur = new LecteurFichier(fc.getSelectedFile().getAbsolutePath());
		new App(this.lecteur.getGraphe());
  }
}