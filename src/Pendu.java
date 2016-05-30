import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Ludovic on 05/05/2016.
 */
public class Pendu {

    //private int compteur = 0;
    private String motSecret = "";
    private int nbEssai = 0;
    private String lettreDejaSaisie = "";
    private JLabel mot;
    int nbLettreTrouver = 0;
    private JPanel droite;
    private CardLayout cardLayout = new CardLayout();
    private JFrame frame;

    /*
    public Pendu() {
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

        //Initialisation liste
        try {
            motSecret=getMotSecret();
            //System.out.println(motSecret);
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
        button.add(new Jlab(this, "A"));
        button.add(new Jlab(this, "B"));
        button.add(new Jlab(this, "C"));
        button.add(new Jlab(this, "D"));
        button.add(new Jlab(this, "E"));
        button.add(new Jlab(this, "F"));
        button.add(new Jlab(this, "G"));

        button.add(new Jlab(this, "H"));
        button.add(new Jlab(this, "I"));
        button.add(new Jlab(this, "J"));
        button.add(new Jlab(this, "K"));
        button.add(new Jlab(this, "L"));
        button.add(new Jlab(this, "M"));
        button.add(new Jlab(this, "N"));
        
        button.add(new Jlab(this, "O"));
        button.add(new Jlab(this, "P"));
        button.add(new Jlab(this, "Q"));
        button.add(new Jlab(this, "R"));
        button.add(new Jlab(this, "S"));
        button.add(new Jlab(this, "T"));
        button.add(new Jlab(this, "U"));
        button.add(new JLabel());
        button.add(new Jlab(this, "V"));
        button.add(new Jlab(this, "W"));
        button.add(new Jlab(this, "X"));
        button.add(new Jlab(this, "Y"));
        button.add(new Jlab(this, "Z"));
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
        droite.add(lab1,"1");
        droite.add(lab2,"2");
        droite.add(lab3,"3");
        droite.add(lab4,"4");
        droite.add(lab5,"5");
        droite.add(lab6,"6");
        droite.add(lab7,"7");
        droite.add(lab8,"8");

        //Ajout des panel droite et gauche dans le panel principal
        panelMain.add(gauche, BorderLayout.WEST);
        panelMain.add(droite, BorderLayout.EAST);


        //ajout du panel principale dans la frame
        frame.add(panelMain);
        //frame.pack();
        //afficher la frame
        frame.setVisible(true);

    }
    */

    public String getMotSecret() throws IOException {

        int nombre = (int)(Math.random()*17);

        File fichier = new File("./Dico/dico.txt");
        FileInputStream fis = new FileInputStream(fichier);
        FileReader reader = new FileReader(fichier);
        BufferedReader buf = new BufferedReader(reader);

        LineNumberReader linereade = new LineNumberReader(reader);
        String ligne;
        //boolean test;
        int nbligne;
        do{
            ligne = linereade.readLine();
            nbligne = linereade.getLineNumber();
            if(nbligne == nombre) {
                //System.out.println(nbligne + " " + ligne);
                 return ligne;
            }

        }while(ligne !=null);



        return "";
    }

    public void testWin(){

        final Frame framefin = new Frame();
        //framefin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framefin.setSize(550, 400);
        framefin.setResizable(false);
        framefin.setLocationRelativeTo(null);
        framefin.setTitle("Jeux du pendu");

        JPanel panelMain = new JPanel();

        JLabel winLoose =new JLabel();
        JButton replay = new JButton("replay");
        replay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                framefin.setVisible(false);
                frame.dispose();
                new Pendu();

            }
        });

        JButton exit = new JButton("exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        panelMain.add(winLoose);
        panelMain.add(replay);
        panelMain.add(exit);

        framefin.add(panelMain);


        if (nbEssai <= 6 && nbLettreTrouver==motSecret.length()) {
            //frame WIN
            System.out.println("Bravo le veau");
            framefin.setVisible(true);
        }
        if (nbEssai==7){
            //frame loose
            System.out.println("Perdu :(");
            framefin.setVisible(true);
        }

    }

    public void click(String lettre) {
        //System.out.println("clic");
        //System.out.println(lettre);
        //System.out.println(motSecret);
        boolean ok;
        nbLettreTrouver = 0;
        int lg_mot = motSecret.length();


        String lettreTapee = lettre.toLowerCase();
        char lettreSeule = lettreTapee.charAt(0);


        lettreDejaSaisie += lettreSeule;


        ok = false;

        String str = "";
        for (int parcours = 0; parcours <= lg_mot - 1; parcours++) {
            if (lettreSeule == motSecret.charAt(parcours)) {
                ok = true;
            }

            char lettreAAfficher = '_';
            for (int ctp = 0; ctp < lettreDejaSaisie.length(); ctp++) {
                char uneLettre = lettreDejaSaisie.charAt(ctp);
                if (uneLettre == motSecret.charAt(parcours)) {
                    lettreAAfficher = uneLettre;
                    nbLettreTrouver++;
                }
            }
            str += lettreAAfficher+" ";
            //System.out.print(lettreAAfficher + " ");

        }

        if (!ok) {
            nbEssai++;
            switch (nbEssai){
                case 1:
                    cardLayout.show(droite,"2");
                    break;
                case 2:
                    cardLayout.show(droite,"3");
                    break;
                case 3:
                    cardLayout.show(droite,"4");
                    break;
                case 4:
                    cardLayout.show(droite,"5");
                    break;
                case 5:
                    cardLayout.show(droite,"6");
                    break;
                case 6:
                    cardLayout.show(droite,"7");
                    break;
                case 7:
                    cardLayout.show(droite,"8");
                    break;
            }

        }

        mot.setText(str);

        testWin();


    }
}
