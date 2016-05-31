package ihm;

import jeuDuPendu.GameEnginer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ludovic on 05/05/2016.
 */
public class Jlab extends JLabel {

    public Jlab(Game game, GameEnginer ge, String lettre){
        super(lettre,SwingConstants.CENTER);
        setBackground(new Color(165, 165, 165));
        setOpaque(true);
        //addMouseListener();
        addMouseListener(new EventLettre(game, ge, lettre,this));
        //JLabel label = new JLabel(lettre);
        //label.setBackground(new Color(37, 41, 163));
        //label.setOpaque(true);
    }
}
