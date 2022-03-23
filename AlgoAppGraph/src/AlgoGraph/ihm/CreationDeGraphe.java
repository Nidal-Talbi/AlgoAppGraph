package AlgoGraph.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import AlgoGraph.metier.App;
import AlgoGraph.metier.LecteurFichier;


public class CreationDeGraphe extends JFrame implements ActionListener{

    private JButton button,button2;
    private JTextField nomSommet;
    private String contenuGraphe = "";
    private JComboBox listeSommet1;
    private JComboBox listeSommet2;
    private DefaultComboBoxModel<String> model;
    private JComboBox<String> jComboBox; 
    private String[] listeSommets = new String[100];
    private int nbSommets = 0;

  public static void main(String[] args) {
    /* init + affichage de la fenêtre */
    new SelectionFichier().setVisible(true);
  }
  
  public CreationDeGraphe() {
    /* init de la fenêtre */
    setSize(200, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    JLabel titre = new JLabel("AlgoAppGraph");

    /* init du bouton qui va afficher le FileChooser */
    button = new JButton("Créer un sommet");
    button.addActionListener(this);

    button2 = new JButton("Créer une relation");
    /* ajout du listener qui prend en charge l'action sur le click */
    button2.addActionListener(this);

    nomSommet = new JTextField();
    nomSommet.setColumns(1);

    String[] liste = { "" };
    model = new DefaultComboBoxModel<>(liste);
    jComboBox = new JComboBox<>(model);
    
    /* ajout du bouton à la fenêtre */
    JPanel p = new JPanel();
    p.add(titre);
    p.add(button);
    p.add(button2);
    p.add(nomSommet);
    p.add(jComboBox);
    setContentPane(p);
  }
  
  public void actionPerformed(ActionEvent e) {

    Object  source=e.getSource();
        
    if(source==this.button && nomSommet.getText() != null)
    {
        contenuGraphe = contenuGraphe + nomSommet.getText() + "\n";
        model.addElement(nomSommet.getSelectedText());
        jComboBox.setSelectedItem(nomSommet.getSelectedText());
        listeSommets[nbSommets] = nomSommet.getSelectedText();
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
    else if (source==button2)
    {
        System.out.println("2eme !");
    }
  }
}