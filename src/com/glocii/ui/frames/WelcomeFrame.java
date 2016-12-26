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
        final JFrame welcomeFrame = new JFrame(WELCOME_FRAME_NAME);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        welcomeFrame.setBounds(screenSize.width/2-(FRAME_WIDTH/2), screenSize.height/2-FRAME_HEIGHT/2,
                FRAME_WIDTH, FRAME_HEIGHT);

        JButton btnStart = new JButton("Начать игру");
        btnStart.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        btnStart.setBackground(new Color(59, 89, 182));
        btnStart.setForeground(Color.WHITE);
        btnStart.setFocusPainted(false);
        btnStart.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameFrame gameFrame = new GameFrame();
                gameFrame.createField();
            }
        });

        JButton btnAbout = new JButton("О программе");
        btnAbout.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        btnAbout.setBackground(new Color(59, 89, 182));
        btnAbout.setForeground(Color.WHITE);
        btnAbout.setFocusPainted(false);
        btnAbout.setFont(new Font("Tahoma", Font.BOLD, 12));

        btnAbout.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                AboutDialog aboutDialog = new AboutDialog();
                aboutDialog.createDialog(welcomeFrame);
            }
        });

        welcomeFrame.setLayout(new BorderLayout());
        welcomeFrame.setContentPane(new JLabel(new ImageIcon("D:\\workspace\\Battleship\\src\\resources\\ships.png")));
        welcomeFrame.setLayout(new FlowLayout());
        Box box = Box.createVerticalBox();


        box.add(Box.createVerticalStrut(80));
        box.add(btnStart);
        box.add(Box.createVerticalStrut(10));
        box.add(btnAbout);
        box.setBackground(new Color(0, 255, 0, 0));

        welcomeFrame.add(box);

        welcomeFrame.setPreferredSize(new Dimension(300, 300));

        welcomeFrame.pack();
        MainMenu mainMenu = new MainMenu();

        welcomeFrame.setJMenuBar(mainMenu.getMenu(welcomeFrame));
        welcomeFrame.setResizable(false);
        welcomeFrame.setVisible(true);

    }
}
