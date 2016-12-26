package com.glocii.ui.menus;

import com.glocii.ui.AboutDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Александр on 25.12.2016.
 */
public class MainMenu {

    private final String file = "Файл";
    private final String open = "Открыть";
    private final String newGame = "Новая игра";
    private final String exit = "Выход";
    private final String aboutProgram = "О программе";
    private final String aboutDev = "Разработчик";
    private final String help = "Помощь";
    private final String program = "Программа";


    public JMenuBar getMenu (final JFrame frame) {
        /*
        Основное меню программы, состоит из:

         */
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu(file);
        JMenu menuAbout = new JMenu(aboutProgram);
        menuBar.add(menuFile);
        menuBar.add(menuAbout);

        JMenuItem openItem = new JMenuItem(open, KeyEvent.VK_O);
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenuItem newGameItem = new JMenuItem(newGame, KeyEvent.VK_N);

        newGameItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenuItem exitItem = new JMenuItem(exit, KeyEvent.VK_E);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuFile.add(openItem);
        menuFile.add(newGameItem);
        menuFile.addSeparator();
        menuFile.add(exitItem);

        JMenuItem aboutDevItem = new JMenuItem(aboutDev);
        aboutDevItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenuItem aboutProgramItem = new JMenuItem(program);
        aboutProgramItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AboutDialog aboutDialog = new AboutDialog();
                aboutDialog.createDialog(frame);
            }
        });

        JMenuItem helpItem = new JMenuItem(help, KeyEvent.VK_H);
        helpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuAbout.add(aboutDevItem);
        menuAbout.add(helpItem);
        menuAbout.add(aboutProgramItem);
        return menuBar;
    }


}
