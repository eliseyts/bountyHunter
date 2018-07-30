package com.company.back;

public class cell {
    public enum Type {
        Earth, Water, Stone
    }
    public enum Treasure {
        None, Bounty, Speed, Bullet
    }

    /**
     * скрыта ли клетка
     * <p>
     * есть 3 типа-вода0 земля1 и камень 2
     * <p>
     * бонусы ничего0 сокровище1 скорость2 пуля 3
     */
    private boolean isHidden = false;
    private boolean isMovableByHero =false;
    private Type cellType = Type.Water;
    private Treasure cellTreasure = Treasure.None;


    //simple codint in int
    private int typeToInt() {
        switch (cellType) {
            case Water:
                return 0;
            case Earth:
                return 1;
            case Stone:
                return 2;
            default:
                return 0;
        }
    }
    private int treasureToInt() {
        switch (cellTreasure) {
            case None:
                return 0;
            case Bounty:
                return 1;
            case Speed:
                return 2;
            case Bullet:
                return 3;
            default:
                return 0;
        }
    }
    public int[] getSimpleInfo() {
        int[] ret = new int[2];
        ret[0] = typeToInt();
        ret[1] = treasureToInt();
        return ret;
    }


    //auto setters for generator
    void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public boolean isMovableByHero() {
        return isMovableByHero;
    }
    public void setMovableByHero(boolean movableByHero) {
        isMovableByHero = movableByHero;
    }
    void setCellType(Type cellType) {
        this.cellType = cellType;
    }
    void setCellTreasure(Treasure cellTreasure) {
        this.cellTreasure = cellTreasure;
    }
    public boolean isHidden() {
        return isHidden;
    }
    @Override
    public String toString() {
        return "cell{" +
                "isHidden=" + isHidden +
                ", cellType=" + cellType +
                ", cellTreasure=" + cellTreasure +
                '}';
    }


}
