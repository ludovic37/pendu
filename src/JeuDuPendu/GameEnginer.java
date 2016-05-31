package jeuDuPendu;

import java.io.IOException;

import java.io.*;

/**
 * Created by Ludovic on 30/05/2016.
 */
public class GameEnginer implements GameEngineInterface {

    private String motSecret = "";
    private int nbEssai = 0;
    private String lettreDejaSaisie = "";
    int nbLettreTrouver = 0;


    @Override
    public String newGame() throws IOException {
        return this.motSecret =  getMotSecret();
    }

    @Override
    public String nextGame(String letter) {

        System.out.println(letter);
        boolean ok;
        nbLettreTrouver = 0;
        int lg_mot = motSecret.length();


        String lettreTapee = letter.toLowerCase();
        char lettreSeule = lettreTapee.charAt(0);


        lettreDejaSaisie += lettreSeule;


        ok = false;

        //System.out.println(lg_mot);
        String str = "";
        for (int parcours = 0; parcours <= lg_mot - 1; parcours++) {
            //System.out.println("test");
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
            str += lettreAAfficher + " ";
        }

        if (!ok) {
            nbEssai++;
        }


        System.out.println(str);
        return str;
    }

    @Override
    public boolean isFinish() {

        boolean fin = false;
        System.out.println(nbEssai);
        if (nbEssai <= 6 && nbLettreTrouver == motSecret.length()) {
            //frame WIN
            fin = true;
        }
        if (nbEssai == 7) {
            //frame loose
            fin = true;
        }

        return fin;
    }

    @Override
    public int getState() {

        return nbEssai;


    }

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


}

