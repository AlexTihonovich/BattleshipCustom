package com.glocii;

import com.glocii.ui.AboutDialog;
import com.glocii.ui.frames.WelcomeFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
	    System.out.print("Hello, Vlad! \nPlease, answer me!");

	    System.out.println("Hello Sancho!\n I'm answer you!");

        WelcomeFrame.createGUI();
    }


    public static void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        final JFrame frame = new JFrame("Battle Ship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnStart = new JButton("Start Game");
        btnStart.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                AboutDialog aboutDialog = new AboutDialog();
                aboutDialog.createDialog(frame);
            }
        });
        frame.getContentPane().add(btnStart);

        frame.setPreferredSize(new Dimension(200, 100));

        frame.pack();
        frame.setVisible(true);


    }
}
