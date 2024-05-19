package com.starnoh.game;
import javax.swing.*;

public class PingPongGame extends JFrame {
    public PingPongGame(){
        setTitle("Ping pong Game");
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new GamePanel());

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PingPongGame::new);
    }
}
