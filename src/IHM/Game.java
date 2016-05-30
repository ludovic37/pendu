package IHM;

import JeuDuPendu.GameEnginer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Ludovic on 30/05/2016.
 */
public class Game {

    public JLabel mot;
    public JPanel droite;
    public CardLayout cardLayout = new CardLayout();
    public JFrame frame;

    private String motSecret;

    public Game() {
        //Initialisation de la frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Jeux du pendu");

        //Initialisation des panel
        JPanel panelMain = new JPanel();
        JPanel gauche = new JPanel();
        //gauche.setSize(300,400);
        gauche.setLayout(new BoxLayout(gauche, BoxLayout.Y_AXIS));
        droite = new JPanel();
        droite.setLayout(cardLayout);
        JPanel panelMot = new JPanel();
        JPanel button = new JPanel(new GridLayout(4, 7, 0, 0));
        button.setPreferredSize(new Dimension(180, 180));

        GameEnginer game = new GameEnginer();
        //Initialisation liste
        try {
            //game.getMotSecret();

            motSecret = game.newGame();

            System.out.println(motSecret);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }


        String str = "";
        for (int i = 0; i < motSecret.length(); i++)
            str += "_ ";

        mot = new JLabel(str);
        mot.setFont(new Font("Arial", Font.BOLD, 18));

        panelMot.add(mot);

        //Creation et Ajout des lettres dans le panel des button
        button.add(new Jlab(this, game, "A"));
        button.add(new Jlab(this, game, "B"));
        button.add(new Jlab(this, game, "C"));
        button.add(new Jlab(this, game, "D"));
        button.add(new Jlab(this, game, "E"));
        button.add(new Jlab(this, game, "F"));
        button.add(new Jlab(this, game, "G"));

        button.add(new Jlab(this, game, "H"));
        button.add(new Jlab(this, game, "I"));
        button.add(new Jlab(this, game, "J"));
        button.add(new Jlab(this, game, "K"));
        button.add(new Jlab(this, game, "L"));
        button.add(new Jlab(this, game, "M"));
        button.add(new Jlab(this, game, "N"));

        button.add(new Jlab(this, game, "O"));
        button.add(new Jlab(this, game, "P"));
        button.add(new Jlab(this, game, "Q"));
        button.add(new Jlab(this, game, "R"));
        button.add(new Jlab(this, game, "S"));
        button.add(new Jlab(this, game, "T"));
        button.add(new Jlab(this, game, "U"));
        button.add(new JLabel());
        button.add(new Jlab(this, game, "V"));
        button.add(new Jlab(this, game, "W"));
        button.add(new Jlab(this, game, "X"));
        button.add(new Jlab(this, game, "Y"));
        button.add(new Jlab(this, game, "Z"));
        button.add(new JLabel());

        //Ajout des element dans le panel gauche
        gauche.add(panelMot);
        gauche.add(button);

        //Ajout de la list dans le panel droite
        JLabel lab1 = new JLabel(new ImageIcon("./Image/131869.jpg"));
        JLabel lab2 = new JLabel(new ImageIcon("./Image/131870.jpg"));
        JLabel lab3 = new JLabel(new ImageIcon("./Image/131871.jpg"));
        JLabel lab4 = new JLabel(new ImageIcon("./Image/131872.jpg"));
        JLabel lab5 = new JLabel(new ImageIcon("./Image/131873.jpg"));
        JLabel lab6 = new JLabel(new ImageIcon("./Image/131874.jpg"));
        JLabel lab7 = new JLabel(new ImageIcon("./Image/131875.jpg"));
        JLabel lab8 = new JLabel(new ImageIcon("./Image/131876.jpg"));
        droite.add(lab1, "1");
        droite.add(lab2, "2");
        droite.add(lab3, "3");
        droite.add(lab4, "4");
        droite.add(lab5, "5");
        droite.add(lab6, "6");
        droite.add(lab7, "7");
        droite.add(lab8, "8");

        //Ajout des panel droite et gauche dans le panel principal
        panelMain.add(gauche, BorderLayout.WEST);
        panelMain.add(droite, BorderLayout.EAST);


        //ajout du panel principale dans la frame
        frame.add(panelMain);
        //frame.pack();
        //afficher la frame
        frame.setVisible(true);
    }
}
