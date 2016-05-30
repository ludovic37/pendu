package IHM;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ludovic on 05/05/2016.
 */
public class Accueil {

    public Accueil(){

        //Initialisation de la frame
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(190,130);             //taille de la frame
        frame.setResizable(false);          //Bloque la redimention manuel
        frame.setLocationRelativeTo(null);  //place la fenetre au centre de l'ecran
        frame.setTitle("Jeux du pendu");    //titre de la frame

        //Initialisation du panel
        JPanel panel = new JPanel();

        //Initialisation des label
        JLabel lab1 = new JLabel("Bienvenue");
        lab1.setFont(new Font("Arial",Font.BOLD,20));
        JLabel lab2 = new JLabel("dans le jeux du pendu");
        lab2.setFont(new Font("Arial",Font.BOLD,16));

        //Initialisation du boutton Start
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game pendu = new Game();
                frame.setVisible(false);
            }
        });

        //Ajout des elem dans le panel
        panel.add(lab1);
        panel.add(lab2);
        panel.add(start);

        //ajout du panel dans la frame
        frame.add(panel);
        //afficher la frame
        frame.setVisible(true);
    }
}
