package AlgoGraph.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AlgoGraph.metier.App;
import AlgoGraph.metier.LecteurFichier;


public class CreationDeGraphe extends JFrame implements ActionListener{

    private JButton button,button2;
    private JTextField nomSommet;
    private JTextField poid;
    private String contenuGraphe = "";
    private DefaultComboBoxModel<String> model;
    private DefaultComboBoxModel<String> model2;
    private JComboBox<String> jComboBox; 
    private JComboBox<String> jComboBox2; 
    private String[] listeSommets = new String[100];
    private int nbSommets = 0;
    private App app;

  public static void main(String[] args) {
    /* init + affichage de la fenêtre */
    new SelectionFichier().setVisible(true);
  }
  
  public CreationDeGraphe() {

    this.app = new App(new LecteurFichier("src/AlgoGraph/files/graphe.grph").getGraphe());
    /* init de la fenêtre */
    setSize(200, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    JLabel titre = new JLabel("AlgoAppGraph");

    /* init du bouton qui va afficher le FileChooser */
    button = new JButton("Créer un sommet");
    button.addActionListener(this);

    button2 = new JButton("Créer une relation");
    /* ajout du listener qui prend en charge l'action sur le click */
    button2.addActionListener(this);

    nomSommet = new JTextField("A");
    nomSommet.setColumns(1);

    String[] liste = { "Par défault" };
    model = new DefaultComboBoxModel<>(liste);
    model2 = new DefaultComboBoxModel<>(liste);
    jComboBox = new JComboBox<>(model);
    jComboBox2 = new JComboBox<>(model2);

    poid = new JTextField("1");
    poid.setColumns(1);

    JLabel LabnomSommet = new JLabel("Nom du Sommet");
    JLabel LabnomPoid = new JLabel("Poid de la relation");
    
    /* ajout du bouton à la fenêtre */
    JPanel p = new JPanel();
    p.add(titre);
    p.add(button);
    p.add(LabnomSommet);
    p.add(nomSommet);
    p.add(button2);
    p.add(jComboBox);
    p.add(jComboBox2);
    p.add(LabnomPoid);
    p.add(poid);
    setContentPane(p);
  }
  
  public void actionPerformed(ActionEvent e) {

    Object  source=e.getSource();
        
    if(source==this.button && nomSommet.getText() != null)
    {
        String nomNouveauSommet = nomSommet.getText();
        nomNouveauSommet = app.verifierNomSommet(nomNouveauSommet);
        if(nomNouveauSommet != "")
        {
          contenuGraphe = contenuGraphe + nomNouveauSommet + "\n";
          model.addElement(nomSommet.getText());
          model2.addElement(nomSommet.getText());
          app.ajouterSommet(nomNouveauSommet);
          listeSommets[nbSommets] = nomSommet.getText();
          nomSommet.setText("");
          nbSommets++;
        try {
            FileWriter myWriter = new FileWriter("src/AlgoGraph/files/graphe.grph");
            myWriter.write(contenuGraphe);
            myWriter.close();
          } 
          catch (IOException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
          }
        }
    }
    else if (source==button2)
    {
        contenuGraphe = contenuGraphe + jComboBox.getSelectedItem().toString() + jComboBox2.getSelectedItem().toString() + " " + jComboBox.getSelectedItem().toString() + " " + jComboBox2.getSelectedItem().toString() + " " + poid.getText() + "\n";
        if(app.verifierRelation(jComboBox.getSelectedItem().toString(), jComboBox2.getSelectedItem().toString()) != "")
        {
          app.ajouterRelation(jComboBox.getSelectedItem().toString(), jComboBox2.getSelectedItem().toString(),  Integer.parseInt(poid.getText()));
          try {
              FileWriter myWriter = new FileWriter("src/AlgoGraph/files/graphe.grph");
              myWriter.write(contenuGraphe);
              myWriter.close();
            } 
            catch (IOException f) {
              System.out.println("An error occurred.");
              f.printStackTrace();
            }
        }
    }
  }
}