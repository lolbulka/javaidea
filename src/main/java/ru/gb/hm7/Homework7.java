package ru.gb.hm7;

public class Homework7 {
    public static void main(String[] args) {
        Plate plate = new Plate(50);
        Cat[] cats = {
                new Cat("Barsik", 20),
                new Cat("Murzik", 15),
                new Cat("Vaska", 10),
                new Cat("Bantik", 30),
        };
        for (Cat cat1 : cats) {
            cat1.eat(plate);
        }
    }
}
