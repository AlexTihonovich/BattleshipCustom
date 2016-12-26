package com.glocii.ui.frames;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Александр on 26.12.2016.
 */
public class GameFrame {

    private static final String GAME_NAME = "Игра";
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;

    private final String setShips = "Расставьте корабли";

    private JLabel lblState = new JLabel(setShips);

    public void createField () {
        JFrame gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        gameFrame.setBounds(screenSize.width/2-(FRAME_WIDTH/2), screenSize.height/2-FRAME_HEIGHT/2,
                FRAME_WIDTH, FRAME_HEIGHT);
        gameFrame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        Box stateBox = Box.createHorizontalBox();
        lblState.setText(setShips);
        stateBox.add(lblState);
        stateBox.setAlignmentY(JComponent.TOP_ALIGNMENT);
        gameFrame.add(stateBox);
        gameFrame.add(createNumbers());
        gameFrame.pack();
        gameFrame.setVisible(true);
    }
    private Box createNumbers () {
        JLabel []numbersArrayLabels = new JLabel[10];
        Box numBox = Box.createVerticalBox();
        for (int i = 0; i < numbersArrayLabels.length; i++) {
            numbersArrayLabels[i] = new JLabel();
            numbersArrayLabels[i].setText(String.valueOf(i+1));
            numBox.setAlignmentY(JComponent.CENTER_ALIGNMENT);
            numBox.add(numbersArrayLabels[i]);
        }
        return numBox;
    }


}
