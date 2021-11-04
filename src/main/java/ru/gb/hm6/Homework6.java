package ru.gb.hm6;

public class Homework6 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        Cat cat2 = new Cat();
        cat.run(100);
        cat.swim(10);
        dog.run(150);
        dog.swim(20);
        System.out.println("Создано животных: " + Animal.getAnimalKol());
        System.out.println("Создано собак: " + Dog.getDogKolKol());
        System.out.println("Создано котов: " + Cat.getCatKol());
    }
}
