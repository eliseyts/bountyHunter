package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameExplorer extends JFrame {

    public GameGUI gameGUI = new GameGUI();
    public JPanel mainPanel;
    public static Color backgroundColor = new Color(21, 27, 48);

    GameExplorer() {
        super("Night Hunter");
        setBounds(200, 100, 1100, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(backgroundColor);
        mainPanel.add(gameGUI, BorderLayout.CENTER);

        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseHandler());

        setContentPane(mainPanel);
        setVisible(true);

        repaint();
    }

    public class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }


}
