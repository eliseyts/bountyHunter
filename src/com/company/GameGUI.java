package com.company;

import com.sun.prism.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GameGUI extends JComponent {
    private final int xCoordBegin = 50;
    private final int yCoordBegin = 100;
    public Color objColor = new Color(255, 200, 115);
    public Color cursorColor = new Color(180, 50, 61);
    BufferedImage earthCell = null;
    BufferedImage waterCell = null;
    BufferedImage stoneCell = null;
    BufferedImage nextButton = null;
    BufferedImage frameImage = null;


    public Color mapFilling = new Color(0, 215, 255);

    int[] arrX1 = {60, 60};
    int[] arrY1 = {100, 60};
    int xCoord = 50;
    int yCoord = 100;

    GameGUI() {

    }

    private void setImages() {
        try {
            earthCell = ImageIO.read(new File("images/earth.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            waterCell = ImageIO.read(new File("images/water.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            stoneCell = ImageIO.read(new File("images/stone.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            nextButton = ImageIO.read(new File("images/nextTurnButton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            frameImage = ImageIO.read(new File("images/frame.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        xCoord = xCoordBegin;
        yCoord = yCoordBegin;


        //извините, тут буферизация изображений текстур
        setImages();


        //заливка карты
        g.setColor(mapFilling);
        g.fillRect(50, 100, 1000, 500);

        g.drawImage(nextButton, 400, 615, 300, 100, null);

        g.drawImage(frameImage, 35, 85, 1030, 530, null);

        Map testMap = new Map();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {

                if (testMap.getCell(i, j).getSimpleInfo()[0] == 0) {
                    g.drawImage(waterCell, xCoord, yCoord, 50, 50, null);
                }
                if (testMap.getCell(i, j).getSimpleInfo()[0] == 1) {
                    g.drawImage(earthCell, xCoord, yCoord, 50, 50, null);
                }
                xCoord = xCoord + 50;
            }
            xCoord = 50;
            yCoord = yCoord + 50;
        }


    }


}
