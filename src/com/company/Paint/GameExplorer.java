package com.company.Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameExplorer extends JFrame {

    public GameGUI gameGUI = new GameGUI();
    public JPanel mainPanel;
    public static Color backgroundColor = new Color(21, 27, 48);



    public GameExplorer() {
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

    }

    public class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //борьба с излишними координатами окна
            int X = e.getX() - 3;
            int Y = e.getY() - 30;
            //cast to int
            int cellNumberX = (X - gameGUI.xCoordBegin) / 50;
            int cellNumberY = (Y - gameGUI.yCoordBegin) / 50;
            gameGUI.process.getPlayerCoords(cellNumberX, cellNumberY);
            if (gameGUI.process.processor(gameGUI.testMap)) {
                System.out.println("player moved");
            }



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
            int X = e.getX() - 3;
            int Y = e.getY() - 30;

            if(!((X>400)&&(X<700)&&(Y>615)&&(Y<715)) && !gameGUI.indexNBEnter)return;
            if(!((X>400)&&(X<700)&&(Y>615)&&(Y<715))) {
                gameGUI.indexNBEnter =false;
                return;
            }
            if((X>400)&&(X<700)&&(Y>615)&&(Y<715)) gameGUI.indexNBEnter = true;

        }
    }


}
