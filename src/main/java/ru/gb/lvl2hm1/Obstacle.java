package ru.gb.lvl2hm1;

public abstract class Obstacle {
    private double maxMove;


    public Obstacle(double length) {
        this.maxMove = length;
    }

    public double getMaxMove() {
        return maxMove;
    }


    String info() {
        return "";
    }

}
