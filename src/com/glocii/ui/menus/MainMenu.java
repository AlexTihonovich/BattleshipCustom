package com.glocii.ui.menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Александр on 25.12.2016.
 */
public class MainMenu {

    public JMenuBar getMenu () {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        menuBar.add(menu);

        JMenuItem fileItem = new JMenuItem("Файл");
        fileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(fileItem);
        return menuBar;
    }
}
