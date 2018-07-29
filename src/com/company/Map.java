package com.company;

import java.util.ArrayList;

//карта,реалитзует действия с клетками и перемещения игрков
public class Map {
    public static int Y = 10;
    public static int X = 20;
    private cell[][] map = new cell[Y][X];
    ArrayList<Player> players = new ArrayList<>();
//    turnProcesdor proc=new turnProcesdor();

    /**
     * конструктор определяет тип мира
     */
    Map() {
        testMapGenerate();
    }

    Map(int y, int x) {
        Y = y;
        X = x;
        testMapGenerate();
    }

    cell[][] getMap() {
        return map;
    }

    cell getCell(int x, int y) {
        return map[x][y];
    }

    private void allWaterMapGenerate() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                map[i][j] = new cell();
            }
        }
    }

    private void testMapGenerate() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                map[i][j] = new cell();
                if ((i + j) % 2 == 0) map[i][j].setCellType(cell.Type.Earth);
            }
        }
    }
}
