package ru.gb.hm7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false; //сытость
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        p.decreaseFood(appetite, this);
        System.out.println(this.toString(p));
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    //@Override
    public String toString(Plate plate) {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}' + ". Котик " + (satiety ? "" : "не ") + "поел. В миске осталось " + plate.getFood() + " еды.";
    }
}
