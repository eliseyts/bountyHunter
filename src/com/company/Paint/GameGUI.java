package com.company.Paint;

import com.company.back.Map;
import com.company.back.cell;
import com.company.back.turnProcessor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameGUI extends JComponent {
    /* Начальные координаты для отрисовки клеток карты */
    public final int xCoordBegin = 50;
    public final int yCoordBegin = 100;
    private final int repTime = 70;
    boolean indexNBEnter = false;

    /* Создание изображений */
    private BufferedImage earthCell = null;
    private BufferedImage waterCell = null;
    private BufferedImage stoneCell = null;
    private BufferedImage fogCell = null;
    private BufferedImage nextButton = null;
    private BufferedImage frameImage = null;
    private BufferedImage infoButton = null;
    private BufferedImage newGameButton = null;
    private BufferedImage loadButton = null;
    private BufferedImage saveButton = null;
    private BufferedImage player1Image = null;
    private BufferedImage player2Image = null;
    private BufferedImage pers1Image = null;
    private BufferedImage pers2Image = null;
    private BufferedImage nextButtonActive = null;
    private BufferedImage border = null;

    private Timer repaintTimer = null;



    Map testMap = new Map();
    turnProcessor process = new turnProcessor();

    private Color mapFilling = new Color(0, 215, 255);

    private int xCoord = 50;
    private int yCoord = 100;

    GameGUI() {
        setTimers();
    }

    /* Установка таймера */
    private void setTimers() {
        repaintTimer = new Timer(repTime, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        repaintTimer.start();
    }

    /* Подключение изображений */
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
            fogCell = ImageIO.read(new File("images/fog.png"));
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

        try {
            nextButtonActive = ImageIO.read(new File("images/nextTurnButtonActive.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            border = ImageIO.read(new File("images/border.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Отрисовка кнопки NEXT TURN */
    private void drawnextTurnButton(Graphics g){
        if(indexNBEnter==true) g.drawImage(nextButtonActive, 400, 615, 300, 100, null);
        else {
            g.drawImage(nextButton, 400, 615, 300, 100, null);
        }
    }

    /* Отрисовка элементов интерфейса */
    private void drawGUI(Graphics g) {

        /* Зарисовка интерфейса */
        g.setColor(mapFilling);
        g.fillRect(50, 100, 1000, 500);

        drawnextTurnButton(g);

        g.drawImage(frameImage, 35, 85, 1030, 530, null);

        g.drawImage(infoButton, 50, 25, 50, 48, null);
        g.drawImage(newGameButton, 125, 25, 262, 48, null);
        g.drawImage(loadButton, 415, 25, 135, 48, null);
        g.drawImage(saveButton, 585, 25, 135, 48, null);


    }

    /*   Отрисовка клеток карты
     *   Сначала проверяется, открыта ли клетка (если скрыта - рисуется туман
     *   Затем, если открыта, отрисовывается текстура клетки, соответствующая её типу
     */

    /* Отрисовка клеток */
    private void drawCells(Graphics g) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                cell localCell=testMap.getCell(i, j);

                if (localCell.isHidden()) {
                    g.drawImage(fogCell, xCoord, yCoord, 50, 50, null);
                }
                else {
                    if (localCell.getSimpleInfo()[0] == 0) {
                        g.drawImage(waterCell, xCoord, yCoord, 50, 50, null);
                    }
                    else {
                        if (localCell.getSimpleInfo()[0] == 1) {
                            g.drawImage(earthCell, xCoord, yCoord, 50, 50, null);
                        }
                        else {
                            if (localCell.getSimpleInfo()[0] == 2) {
                                g.drawImage(stoneCell, xCoord, yCoord, 50, 50, null);

                            }
                        }
                    }
                }


                if(localCell.isMovableByHero()) g.drawImage(border, xCoord, yCoord, 50, 50, null);
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
