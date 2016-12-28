package com.glocii.ui.frames;

import javax.swing.*;

import Elements.Field;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Александр on 26.12.2016.
 */
public class GameFrame {

    private static final String GAME_NAME = "Игра";
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private static final String YOUR_TURN = "Ваш ход";
    private static final String ENEMY_TURN = "Противник ходит";
    private static final String YOU_WIN = "Вы проиграли";
    private static final String YOU_LOOSE = "Вы победили";
    private static final String RANDOM_SHIPS = "Сгенерировать корабли";

    private final String setShips = "Расставьте корабли";
    private JLabel lblGameState = new JLabel();
    private JLabel lblState = new JLabel(setShips);
    private JButton btnRandomShipsGenerator = new JButton();

    public void createField () {
        JFrame gameFrame = new JFrame();
        gameFrame.setLayout(new FlowLayout());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        gameFrame.setBounds(screenSize.width/2-(FRAME_WIDTH/2), screenSize.height/2-FRAME_HEIGHT/2,
                FRAME_WIDTH, FRAME_HEIGHT);
        gameFrame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        JPanel fieldsPanel = new JPanel();
        JPanel fieldsHelpPanel = new JPanel();
        JPanel gameStatePanel = new JPanel();


        fieldsPanel.setDoubleBuffered(true);
        final Field myField = new Field();
        Field myField2 = new Field();
        fieldsPanel.setLayout(new GridLayout());
        btnRandomShipsGenerator.setText(RANDOM_SHIPS);
        btnRandomShipsGenerator.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        btnRandomShipsGenerator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myField.generate();

            }
        });


        lblGameState.setText(String.format("<html> <font color='red'>%s</font></html>", YOUR_TURN));

        fieldsPanel.setBackground(Color.DARK_GRAY);
        fieldsHelpPanel.add(btnRandomShipsGenerator);
        fieldsPanel.add(myField);
        fieldsPanel.add(myField2);
        gameStatePanel.add(lblGameState);

        gameFrame.add(fieldsPanel);
        gameFrame.add(fieldsHelpPanel);
        gameFrame.add(gameStatePanel);
        gameFrame.pack();
        gameFrame.setVisible(true);
        
    }


}
