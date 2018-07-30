package com.company.back;

public class Player {
    /**
     * координаты игрока,его движение
     */
    int visionRange=2;
    private int xCoord = 0, yCoord = 0;
    private final int defaultMoveRange = 2;
    private final int shoootRadius = 1;
    private int moveRange = 4;
    private int health = 2;
    private boolean hasKey = false;

    public Player(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean shootToPlayer(int oppX, int oppY) {
        if ((Math.abs(xCoord - oppX) + Math.abs(yCoord - oppY)) <= 1) {
            return true;
        }
        return false;
    }

    public void getDamadge() {
        health -= 1;
    }

    public boolean isAlive() {
        return (health > 0);
    }

    public boolean moveToCoord(int x1, int y1) {
        if ((Math.abs(xCoord - x1) + Math.abs(yCoord - y1) <= moveRange)
                && (x1 >= 0) && (x1 < Map.X)
                && (y1 >= 0) && (y1 < Map.Y)) {
            xCoord = x1;
            yCoord = y1;
            moveRange -= Math.abs(xCoord - x1) + Math.abs(yCoord - y1);
            return true;
        }
        return false;
    }

    public void setMoveRangeToDefault() {
        moveRange = defaultMoveRange;
    }

    boolean move(int dx, int dy) {
        if ((Math.abs(dx) + Math.abs(dy) <= moveRange)
                && (xCoord + dx > 0) && (xCoord + dx < Map.X)
                && (yCoord + dy > 0) && (yCoord + dy < Map.Y)) {
            xCoord += dx;
            yCoord += dy;
            moveRange -= (Math.abs(dx) + Math.abs(dy));
            return true;
        }
        return false;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }
}
