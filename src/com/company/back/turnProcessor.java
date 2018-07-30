package com.company.back;

import com.company.back.Map;

public class turnProcessor {
    private Integer p1tX, p1tY, p2tX, p2tY;
    private boolean Ready = false;
    private Map bufferMap = null;
    private int whoseTurn = 0;
    //if 0 -player 1
    //if 1 -player 2

    // TODO: 30.07.18 finish processsing

    public void getPlayerCoords(int ptX, int ptY) {
        if (whoseTurn == 0) {
            p1tX = ptX;
            p1tY = ptY;
        } else {
            p2tX = ptX;
            p2tY = ptY;
        }
    }

    public int getWhoseTurn() {
        return whoseTurn;
    }

    public boolean processor(Map map) {
        bufferMap = map;

        //if some shit do move
        if ((p1tX != null) && p1tY != null && bufferMap.players.get(0).moveToCoord(p1tX, p1tY))
            return true;

        if ((p2tX != null) && p2tY != null && bufferMap.players.get(1).moveToCoord(p2tX, p2tY))
            return true;

        p1tX = null;
        p1tY = null;
        p2tX = null;
        p2tY = null;
        changeTurn();
        return false;
    }

    public Map getBufferMap() {
        return bufferMap;
    }

    private void changeTurn() {
        whoseTurn = 1 - whoseTurn;
    }
}
