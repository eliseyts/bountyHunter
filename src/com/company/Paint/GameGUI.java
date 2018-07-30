package com.company.Paint;

import com.company.back.Map;
import com.company.back.turnProcessor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameGUI extends JComponent {
    /* Начальные координаты для отрисовки клеток карты */
    private final int xCoordBegin = 50;
    private final int yCoordBegin = 100;

    /* Создание изображений */
    BufferedImage earthCell = null;
    BufferedImage waterCell = null;
    BufferedImage stoneCell = null;
    BufferedImage nextButton = null;
    BufferedImage frameImage = null;
    BufferedImage infoButton = null;
    BufferedImage newGameButton = null;
    BufferedImage loadButton = null;
    BufferedImage saveButton = null;
    BufferedImage player1Image = null;
    BufferedImage player2Image = null;
    BufferedImage pers1Image = null;
    BufferedImage pers2Image = null;


    Map testMap = new Map();
    turnProcessor process = new turnProcessor();

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

        try {
            infoButton = ImageIO.read(new File("images/infoButton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            newGameButton = ImageIO.read(new File("images/newGameButton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            loadButton = ImageIO.read(new File("images/loadButton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            saveButton = ImageIO.read(new File("images/saveButton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            player1Image = ImageIO.read(new File("images/player1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            player2Image = ImageIO.read(new File("images/player2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            pers1Image = ImageIO.read(new File("images/pers1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            pers2Image = ImageIO.read(new File("images/pers2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Отрисовка элементов интерфейса */
    private void drawGUI(Graphics g) {

        //заливка карты
        g.setColor(mapFilling);
        g.fillRect(50, 100, 1000, 500);

        g.drawImage(nextButton, 400, 615, 300, 100, null);
        g.drawImage(frameImage, 35, 85, 1030, 530, null);

        g.drawImage(infoButton, 50, 25, 50, 48, null);
        g.drawImage(newGameButton, 125, 25, 262, 48, null);
        g.drawImage(loadButton, 415, 25, 135, 48, null);
        g.drawImage(saveButton, 585, 25, 135, 48, null);


    }

    /* Отрисовка клеток карты */
    private void drawCells(Graphics g) {
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

    private void drawPlayers(Graphics g) {

        if (process.getWhoseTurn() == 0) {
            g.drawImage(player1Image, 800, 50, 180, 20, null);
        } else {
            g.drawImage(player2Image, 800, 50, 180, 20, null);
        }

        int cellX = testMap.players.get(0).getXCoord();
        int cellY = testMap.players.get(0).getYCoord();
        g.drawImage(pers1Image, 50 + 50 * cellX, 75 + 50 * cellY, 40, 80, null);

        cellX = testMap.players.get(1).getXCoord();
        cellY = testMap.players.get(1).getYCoord();
        g.drawImage(pers2Image, 50 + 50 * cellX, 75 + 50 * cellY, 40, 80, null);
    }

    public void paint(Graphics g) {
        xCoord = xCoordBegin;
        yCoord = yCoordBegin;

        /* Извините, тут буферизация изображений текстур */
        setImages();
        drawGUI(g);
        drawCells(g);
        drawPlayers(g);


    }


}
