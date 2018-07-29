package com.company;

public class turnProcesdor {
    int p1tX, p1tY, p2tX, p2tY;

    // TODO: 30.07.18 finish processsing
    Map bufferMap = null;

    public void player1Turn(int p1tX, int p1tY) {
        this.p1tX = p1tX;
        this.p1tY = p1tY;
    }

    public void player2Turn(int p2tX, int p2tY) {
        this.p2tX = p2tX;
        this.p2tY = p2tY;
    }

    public boolean processor(Map map) {
        bufferMap = map;

        bufferMap.players.get(0).moveToCoord(p1tX, p1tY);
        bufferMap.players.get(1).moveToCoord(p2tX, p2tY);

        return true;
    }

    public Map getBufferMap() {
        return bufferMap;
    }
}
