package ru.gb.hm6;

public class Dog extends Animal {
    private static int dogKol;
    public Dog(){
        dogKol++;
    }
    public static int getDogKolKol() {
        return dogKol;
    }
    @Override
    public void run(int obstacleLengh) {
        if (obstacleLengh > 500){
            System.out.println("Собака может пробежать не больше 500 метров");
        }
        else{
            System.out.println("Собака пробежала " + obstacleLengh + "м.");
        }
    }
    @Override
    public void swim(int obstacleLengh) {
        if (obstacleLengh > 10){
            System.out.println("Собака может проплыть не больше 10 метров");
        }
        else{
            System.out.println("Собака проплыла " + obstacleLengh + "м.");
        }
    }
}
