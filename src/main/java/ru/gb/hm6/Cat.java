package ru.gb.hm6;

public class Cat extends Animal {
    private static int catKol;
    public Cat(){
        catKol++;
    }
    public static int getCatKol() {
        return catKol;
    }
    @Override
    public void run(int obstacleLengh) {
        if (obstacleLengh > 200){
            System.out.println("Кот может пробежать не больше 200 метров");
        }
        else{
            System.out.println("Кот пробежал " + obstacleLengh + "м.");
        }
    }
    @Override
    public void swim(int obstacleLengh) {
        System.out.println("Кот не умеет плавать.");
    }
}
