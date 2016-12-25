package com.glocii.ui.frames;

import com.glocii.ui.AboutDialog;
import com.glocii.ui.menus.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Александр on 18.12.2016.
 */
public class WelcomeFrame {
    private static final String WELCOME_FRAME_NAME = "Добро пожаловать в 'Морской бой'";
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 200;

    public static void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame welcomeFrame = new JFrame(WELCOME_FRAME_NAME);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        welcomeFrame.setBounds(screenSize.width/2-(FRAME_WIDTH/2), screenSize.height/2-FRAME_HEIGHT/2,
                FRAME_WIDTH, FRAME_HEIGHT);

        JButton btnStart = new JButton("Start Game");
        JButton btnAbout = new JButton("О программе");

        btnAbout.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                AboutDialog aboutDialog = new AboutDialog();
                aboutDialog.createDialog(welcomeFrame);
            }
        });
        welcomeFrame.getContentPane().add(btnStart);
        welcomeFrame.getContentPane().add(btnAbout);
        welcomeFrame.setPreferredSize(new Dimension(200, 100));

        welcomeFrame.pack();
        MainMenu mainMenu = new MainMenu();

        welcomeFrame.setJMenuBar(mainMenu.getMenu());

        welcomeFrame.setVisible(true);

    }
}
