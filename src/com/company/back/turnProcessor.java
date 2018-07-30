package com.company.back;

import java.sql.BatchUpdateException;

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
        boolean succes = false;

        //if some shit do move
        if (whoseTurn == 0 && (p1tX != null) && p1tY != null)
            if (bufferMap.players.get(0).moveToCoord(p1tX, p1tY)) succes = true;

        if (whoseTurn == 1 && (p2tX != null) && p2tY != null){
            if (bufferMap.players.get(1).moveToCoord(p2tX, p2tY)) {
                succes = true;
            }
        }


        p1tX = null;
        p1tY = null;
        p2tX = null;
        p2tY = null;


        if (succes) {
            map.showHiddenCells(bufferMap.players.get(whoseTurn).getXCoord(),bufferMap.players.get(whoseTurn).getYCoord(),
                    bufferMap.players.get(whoseTurn).visionRange);

            changeTurn();

            map.setMovableCoords(bufferMap.players.get(whoseTurn).getXCoord(),bufferMap.players.get(whoseTurn).getYCoord(),
                    bufferMap.players.get(whoseTurn).visionRange);
            return true;

        }
        return false;
    }

    public Map getBufferMap() {
        return bufferMap;
    }

    private void changeTurn() {
        whoseTurn = 1 - whoseTurn;
    }
}
