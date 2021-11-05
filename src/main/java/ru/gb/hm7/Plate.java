package ru.gb.hm7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n, Cat cat) {
        while (!cat.isSatiety()) {
            if (food - n >= 0) { //коту хватило еды
                food -= n;
                cat.setSatiety(true);
            } else {
                System.out.println(cat.toString(this));
                System.out.printf("Котику %s не хватает %d еды. ", cat.getName(), Math.abs(food - n));
                addFood(50); //добавим еды в миску
            }
        }
    }
    public int getFood() {
        return food;
    }
    public void addFood(int food){ //добавление еды в миску
        this.food +=food;
        System.out.printf("Добавим %d еды в миску.\n", food);
    }
}
