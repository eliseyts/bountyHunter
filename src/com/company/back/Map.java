package com.company.back;

import java.util.ArrayList;
//карта,реалитзует действия с клетками и перемещения игрков
public class Map {
    public static int Y = 10;
    public static int X = 20;
    private cell[][] map = new cell[Y][X];
    public ArrayList<Player> players = new ArrayList<>();
//    turnProcessor proc=new turnProcessor();

    /**
     * конструктор определяет тип мира
     */
    public Map() {
        generateRandomMap();
        set2Players();
        showHiddenCells(0,0,2);
        showHiddenCells(19,9,2);
    }

    cell[][] getMap() {
        return map;
    }

    public cell getCell(int x, int y) {
        return map[x][y];
    }

    private void set2Players() {
        players.add(new Player(0, 0));
        players.add(new Player(19, 9));
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

    private void generateRandomMap(){
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                map[i][j] = new cell();
                map[i][j].setHidden(true);
                if (Math.random()>0.7){
                    map[i][j].setCellType(cell.Type.Earth);
                    continue;
                }
                if (Math.random()<0.99){
                    map[i][j].setCellType(cell.Type.Water);
                    continue;
                }
                map[i][j].setCellType(cell.Type.Stone);
            }
        }
    }

    void setMovableCoords(int Xcoord,int Ycoord,int Rad) {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if ((j - Xcoord) * (j - Xcoord) + (i - Ycoord) * (i - Ycoord) > Rad * Rad && !map[i][j].isMovableByHero()) continue;
                if ((j - Xcoord) * (j - Xcoord) + (i - Ycoord) * (i - Ycoord) > Rad * Rad && map[i][j].isMovableByHero()) {
                    map[i][j].setMovableByHero(false);
                    continue;
                }
                if ((j - Xcoord) * (j - Xcoord) + (i - Ycoord) * (i - Ycoord) <= Rad * Rad && map[i][j].isMovableByHero()) {
                    continue;
                }
                if ((j - Xcoord) * (j - Xcoord) + (i - Ycoord) * (i - Ycoord) <= Rad * Rad && !map[i][j].isMovableByHero()) {
                    map[i][j].setMovableByHero(true);
                }
            }
        }
    }

    void showHiddenCells(int Xcoord,int Ycoord,int Rad){
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if( (j-Xcoord)*(j-Xcoord)+(i-Ycoord)*(i-Ycoord)<=Rad*Rad && map[i][j].isHidden())
                    map[i][j].setHidden(false);
            }
        }
    }
}
