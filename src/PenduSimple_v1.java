package td1Intro;

import java.util.Random;
import java.util.Scanner;

/* Tout programme doit être commenté. 2 types de commentaires existent en Java
 *  - les commentaires de code
 *  - le JavaDoc
 */

/**
 * Exemple de Javadoc :
 * Ceci permet de générer une documentation.
 * Cette documentation peut être constituée de texte libre et des éléments suivants :
 *
 * @param il n'y a pas de paramétres à communiquer
 * @author JL Le Bars
 * @version 1.0
 * @return Ce programme affiche juste un message
 * @see Il n'y a pas d'autres méthodes appelées
 * @since 2014
 */
// Pour visualiser un Javadoc sous Eclipse, cliquez sur Javadoc dans la console.

public class PenduSimple_v1 {

	/*
     * Tout programme est une classe en Java.
	 * La classe principale d'un programme doit porter le même nom que le fichier
	 * (attention à la casse !).
	 */
	
	/*
	 *  - public : 
	 *  - static : 
	 *  - void : on attend pas de message en retour.
	 *  - main : il existe une hiérarchie en Java. Ainsi, tout programme doit commencer
	 *  par main. Cette méthode est appelée par la JVM.
	 *  - String[] args : le programme peut être suivi d'arguments, passés en ligne
	 *  de commande (java nomDuProgramme arg1 arg2 ...
	 */

    public String motSecret(){

            String mot;
            do {
                System.out.print("Quel est votre mot : ");
                Scanner saisie = new Scanner(System.in);
                mot = saisie.nextLine();
                System.out.println(mot);
            } while (mot.length() == 0);

            return mot;
    }

    public String Init(String mot){
        int lg_mot = mot.length();
        // L'opérateur + sert à concaténer des chaînes de caractères.
        String str = "";
        System.out.println("Le mot fait " + lg_mot + " lettres : ");
        for (int tiret = 1; tiret <= lg_mot; tiret++) {
            str+="- ";
        }
        return str;
    }


    public static void main(String[] args) {

        PenduSimple_v1 pend = new PenduSimple_v1();

        // partie JOUEUR 1
        String mot = "";
        mot =  pend.motSecret();
        int lg_mot = mot.length();


        String affichage = "";
        affichage = pend.Init(mot);

		/*
		// Autre exemple de structure itérative : while
		int tiret_2 = 1;
		System.out.println();
		System.out.println("Avec une boucle while : ");
		while(tiret_2 <=lg_mot)
			{
			System.out.print("- ");
			tiret_2++;
			}
		// Avec do ... while
		tiret_2 = 1;
		System.out.println();
		System.out.println("Avec une boucle do ... while : ");
		do
			{
			System.out.print("- ");
			tiret_2++;
			}
		while (tiret_2 <=lg_mot);
		*/

        boolean ok;
        int nbLettreTrouver;
        int nbEssai = 0;
        String lettreDejaSaisie = "";
        do {
            nbLettreTrouver = 0;

            String lettreTapee;
            do {
                System.out.println();
                System.out.println("Quelle est votre lettre : ");
                Scanner lettre = new Scanner(System.in);
                lettreTapee = lettre.nextLine();
            }while(lettreTapee.length() == 0);
	/*
	 * Les données saisies ne peuvent être traitées que sous forme de chaîne de caractères.
	 * Pour transformer la lettre tapée en caractère, il faut cr�er une variable qui ne
	 * prendra que le premier caractère de la chaîne.
	 * ! : une chaîne de caract�res commence � 0, et non 1.
	 */
            char lettreSeule = lettreTapee.charAt(0);

            boolean dejaSaisie = false;
            for(int ctp = 0; ctp < lettreDejaSaisie.length(); ctp++) {
                char uneLettre = lettreDejaSaisie.charAt(ctp);
                if(uneLettre == lettreSeule)    {
                    dejaSaisie = true;
                }
            }
            //ou dejaSaisie = lettreDejaSaisie.indexOf(lettreSeule) != -1;

            if(dejaSaisie)  {
                System.out.println("Non la lettre est déjà saisie");
            }else {
                lettreDejaSaisie += lettreSeule;
            }

            ok = false;
            for (int parcours = 0; parcours <= lg_mot - 1; parcours++) {
                if (lettreSeule == mot.charAt(parcours)) {
                    ok = true;
                }
                /*
                boolean afficherLaLettre = false;
                for(int ctp = 0; ctp < lettreDejaSaisie.length(); ctp++) {
                    char uneLettre = lettreDejaSaisie.charAt(ctp);
                    if(uneLettre == mot.charAt(parcours))   {
                        afficherLaLettre = true;
                        nbLettreTrouver++;
                    }
                }
                if(afficherLaLettre)    {
                    System.out.print(mot.charAt(parcours)+ " ");
                }else {
                    System.out.print("_ ");
                }
                */

                char lettreAAfficher = '_';
                for(int ctp = 0; ctp < lettreDejaSaisie.length(); ctp++) {
                    char uneLettre = lettreDejaSaisie.charAt(ctp);
                    if(uneLettre == mot.charAt(parcours))   {
                        lettreAAfficher = uneLettre;
                        nbLettreTrouver++;
                    }
                }
                System.out.print(lettreAAfficher + " ");

            }
            System.out.println();
            if (!ok) {
                System.out.println("La lettre n'est pas dans le mot !");
                nbEssai++;
            }
        }while(nbLettreTrouver != mot.length() && nbEssai < 10);

        if(nbEssai < 10) {
            System.out.println("Bravo le veau");
        } else {
            System.out.println("Perdu :(");
        }

    }
}
