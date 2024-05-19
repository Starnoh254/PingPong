package com.starnoh.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private static final int DELAY = 10; // milliseconds
    private int paddle1Y = 250;
    private int paddle2Y = 250;
    private JLabel scoreLabel;
    private int score;
    private boolean upPressed, downPressed, wPressed, sPressed;

    private int ballX = 395, ballY = 295, ballXDir = -2, ballYDir = -2;

    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        score = 0;
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setForeground(Color.WHITE); // Set the text color to white
        add(scoreLabel);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(50, paddle1Y, 10, 100); // Left paddle
        g.fillRect(740, paddle2Y, 10, 100); // Right paddle
        g.fillOval(ballX, ballY, 10, 10); // Ball
    }

    private void movePaddles() {
        if (wPressed && paddle1Y > 0) {
            paddle1Y -= 5;
        }
        if (sPressed && paddle1Y < getHeight() - 100) {
            paddle1Y += 5;
        }
        if (upPressed && paddle2Y > 0) {
            paddle2Y -= 5;
        }
        if (downPressed && paddle2Y < getHeight() - 100) {
            paddle2Y += 5;
        }
    }

    private void moveBall() {
        ballX += ballXDir;
        ballY += ballYDir;

        // Ball collision with top and bottom
        if (ballY <= 0 || ballY >= getHeight() - 10) {
            ballYDir = -ballYDir;
        }

        // ball collision with left and right
        if(ballX <= 0 || ballX >= getWidth() - 10){
            ballXDir = -ballXDir;
        }

        // Ball collision with paddles
        if (ballX <= 60 && ballY >= paddle1Y && ballY <= paddle1Y + 100) {
            ballXDir = -ballXDir;
            score++;
            scoreLabel.setText("Score: " + score);
        }
        if (ballX >= 730 && ballY >= paddle2Y && ballY <= paddle2Y + 100) {
            ballXDir = -ballXDir;
            score++;
            scoreLabel.setText("Score: " + score);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movePaddles();
        moveBall();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            wPressed = true;
        }
        if (key == KeyEvent.VK_S) {
            sPressed = true;
        }
        if (key == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            wPressed = false;
        }
        if (key == KeyEvent.VK_S) {
            sPressed = false;
        }
        if (key == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
    }
}
