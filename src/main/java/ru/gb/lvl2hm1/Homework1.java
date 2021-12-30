package ru.gb.lvl2hm1;

public class Homework1 {
    public static void main(String[] args) {
        Player[] players = {
           new Robot(1.0,200.0),
           new Person(0.5, 100.0),
           new Cat(0.2, 10.0),
           new Robot(5.0,700.0),
        };
        Obstacle[] obstacles = {
                new Treadmill(50.0),
                new Wall(2.0),
                new Wall(4.0),
                new Treadmill(100.0)
        };
        for (Player player : players) {
            for (Obstacle obstacle : obstacles) {
                player.move(obstacle);
            }
        }
    }
}
