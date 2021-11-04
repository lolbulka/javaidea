package ru.gb.hm6;

public abstract class Animal {
    private static int animalKol;
    public Animal(){
        animalKol++;
    }

    public static int getAnimalKol() {
        return animalKol;
    }

    public abstract void run(int obstacleLengh);
    public abstract void swim(int obstacleLengh);

}
