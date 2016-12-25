package com.glocii.ui;

import javax.swing.*;

/**
 * Created by Александр on 25.12.2016.
 */
public class AboutDialog {


    JLabel lblHeader = new JLabel();

    public void createDialog (JFrame frame) {
        // display/center the jdialog when the button is pressed
        JDialog d = new JDialog(frame, "Dialog", true);
        d.setBounds(50, 50, 200, 200);
        lblHeader.setText("Морской бой");
        d.setLocationRelativeTo(frame);
        d.setVisible(true);
    }
}
