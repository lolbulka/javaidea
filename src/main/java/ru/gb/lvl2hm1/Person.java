package ru.gb.lvl2hm1;

public class Person implements Player {
    private double maxJump;
    private double maxRun;
    private boolean fail = false;

    public Person(double maxJump, double maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public void move(Obstacle a) {
        if (a instanceof Wall && !fail) {
            if (maxJump < a.getMaxMove()) {
                fail = true;
                System.out.println("Человек не может прыгнуть на " + a.getMaxMove() +
                        " метров. Максимальное значение " + maxJump + ".");
            } else {
                System.out.println("Человек прыгнул на " + a.getMaxMove());
            }
        }
        if (a instanceof Treadmill && !fail) {
            if (maxRun < a.getMaxMove()) {
                fail = true;
                System.out.println("Человек не может пробежать на " + a.getMaxMove() +
                        " метров. Максимальное значение " + maxRun + ".");
            } else {
                System.out.println("Человек пробежал на " + a.getMaxMove());
            }
        }
    }
}
