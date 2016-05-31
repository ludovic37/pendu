package ihm;

import jeuDuPendu.GameEnginer;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Ludovic on 05/05/2016.
 */
public class EventLettre implements MouseListener {

    private Game pendu;
    private GameEnginer game;
    private String lettre;
    private Jlab lab;
    private boolean test = false;

    public EventLettre(Game pendu, GameEnginer ge, String lettre, Jlab lab){
        this.pendu = pendu;
        this.lettre = lettre;
        this.lab = lab;
        this.game = ge;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(!test){
            test = true;

            String str;
            str = game.nextGame(lettre);
            pendu.mot.setText(str);

            int nbEssai = game.getState();

            switch (nbEssai){
                case 1:

                    pendu.cardLayout.show(pendu.droite,"2");
                    //pendu.cardLayout.show();
                    break;
                case 2:
                    pendu.cardLayout.show(pendu.droite,"3");
                    break;
                case 3:
                    pendu.cardLayout.show(pendu.droite,"4");
                    break;
                case 4:
                    pendu.cardLayout.show(pendu.droite,"5");
                    break;
                case 5:
                    pendu.cardLayout.show(pendu.droite,"6");
                    break;
                case 6:
                    pendu.cardLayout.show(pendu.droite,"7");
                    break;
                case 7:
                    pendu.cardLayout.show(pendu.droite,"8");
                    pendu.frame.setVisible(false);
                    break;
            }


            if(game.isFinish()){
                    System.out.println("finish game");
                //Fin fin = new Fin("You Win");
                Fin fin;
                if(nbEssai<7)
                    fin = new Fin("You Win");
                else
                    fin = new Fin("You Loose");
                }

            lab.setBackground(new Color(255, 255, 255));
            lab.setOpaque(true);
        }
        else {
            System.out.println("deja clic");
        }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
