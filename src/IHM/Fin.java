package ihm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ludovic on 30/05/2016.
 */
public class Fin {

    public Fin(String msg){

        final JFrame framefin = new JFrame();

        framefin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framefin.setSize(200, 150);
        framefin.setResizable(false);
        framefin.setLocationRelativeTo(null);
        framefin.setTitle("Jeux du pendu");


        JPanel panelMain = new JPanel();
        JPanel ligne1 = new JPanel();
        JPanel ligne2 = new JPanel();



        JButton replay = new JButton("replay");
        replay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                framefin.setVisible(false);
                //frame.dispose();
                new Game();

            }
        });

        JButton exit = new JButton("exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        //panelMain.add(replay);
        //panelMain.add(exit);

        ligne1.add(new JLabel(msg));

        ligne2.add(replay);
        ligne2.add(exit);
        panelMain.add(ligne1);
        panelMain.add(ligne2);

        framefin.add(panelMain);
        framefin.setVisible(true);
    }
}
