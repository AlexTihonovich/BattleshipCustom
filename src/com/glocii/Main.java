package com.glocii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
	    System.out.print("Hello, Vlad! \nPlease, answer me!");

	    System.out.println("Hello Sancho!\n I'm answer you!");

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }


    public static void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Морской бой");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnStart = new JButton("Начать игру");
        btnStart.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // display/center the jdialog when the button is pressed
                JDialog d = new JDialog(frame, "Hello", true);
                d.setLocationRelativeTo(frame);
                d.setVisible(true);
            }
        });
        frame.getContentPane().add(btnStart);

        frame.setPreferredSize(new Dimension(200, 100));

        frame.pack();
        frame.setVisible(true);


    }
}
