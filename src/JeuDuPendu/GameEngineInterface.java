package jeuDuPendu;

import java.io.IOException;

/**
 * Created by Ludovic on 30/05/2016.
 */
public interface GameEngineInterface {

    /*
     * Start Game
     */
    public String newGame() throws IOException;

    /*
     * Coup Suivant
     */
    public String nextGame(String letter);

    /*
     * La partie est-elle terminée
     */
    public boolean isFinish();

    /*
     * Obtenir l'etat de la partie
     */
    public int getState();

}
