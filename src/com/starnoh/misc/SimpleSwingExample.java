package com.starnoh.misc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingExample {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Simple Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a button
        JButton button = new JButton("Click Me!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a message dialog when the button is clicked
                JOptionPane.showMessageDialog(frame, "Button was clicked!");
            }
        });

        // Add the button to the frame
        frame.getContentPane().add(button);

        // Make the frame visible
        frame.setVisible(true);
    }
}
