package ru.gb;

import java.util.Arrays;

public class Homework3 {
    public static void main(String[] args) {
//задание 1
        int [] a = {0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0};
        System.out.println("Входной массив  " + Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] == 1 ? 0 : 1;
        }
        System.out.println("Выходной массив " + Arrays.toString(a));
        System.out.println("-------------------------------------------------");
//задание 2
        int [] b = new int[100];
        for (int i = 0; i < b.length; i++) {
            b[i] = i + 1;
        }
        System.out.println("Выходной массив " + Arrays.toString(b));
        System.out.println("-------------------------------------------------");
//задание 3
        int [] c = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < c.length; i++) {
            if (c[i] < 6){
                c[i] *= 2;
            }
        }
        System.out.println("Выходной массив " + Arrays.toString(c));
        System.out.println("-------------------------------------------------");
//задание 4
        int [][] d = new int[7][7];

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                if (i == j || d.length == i + j + 1) {
                    d[i][j] = 1;
                }
                System.out.print(d[i][j] + " ");
            }
            System.out.println("");
        }
//задание 5
        System.out.println("-------------------------------------------------");
        System.out.println(Arrays.toString(returnMass(5,8)));
        System.out.println("-------------------------------------------------");
//задание 6
        int[] e = {10, 20, 5, -6, -3, 9, 15, 40, -30};
        //f - мин, g - max
        int f = e[0], g = e[0];
        for (int i = 1; i < e.length; i++) {
            if (e[i] > e[i-1]){
                g = e[i];
            }
            if (e[i] < e[i-1]){
                f = e[i];
            }
        }
        System.out.printf("Минимальное значение = %d, Максимальное значение = %d\n", f, g);
        System.out.println("-------------------------------------------------");
//задание 7
        int[] h = {10,2,10,1,3,5,1,-6,4,3,1,4,1,1,3};
        System.out.println(checkBalance(h));
        System.out.println("-------------------------------------------------");
//задание 8
        int[] j = {1,2,3,4,5};
        System.out.println(Arrays.toString(movePosition(j,-2)));
    }
    public static int[] returnMass (int len, int value){
        int[] mass = new int[len];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = value;
        }
        return mass;
    }
    public static boolean checkBalance (int[] mas){
        int a = 0, b = mas.length - 1, leftSum = mas[a], rightSum = mas[b];
        while (b - a != 1){
            if (leftSum > rightSum){
                b--;
                rightSum += mas[b];
            } else {
                a++;
                leftSum += mas[a];
            }
        }
        System.out.println(leftSum + " " + rightSum);
        return leftSum == rightSum;
    }
    public static int[] movePosition (int[] mas, int n) {
        boolean zero = n > 0;
        for (int j = 0; j < Math.abs(n); j++) {
            if (zero) { //сдвигаем элемент вправо
                for (int i = mas.length - 1; i > 0; i--) {
                    mas[i] = mas[i] + mas[i - 1];
                    mas[i - 1] = mas[i] - mas[i - 1];
                    mas[i] = mas[i] - mas[i - 1];
                }
            } else { //сдвигаем элемент влево
                for (int i = 0; i < mas.length - 1; i++) {
                    mas[i] = mas[i] + mas[i + 1];
                    mas[i + 1] = mas[i] - mas[i + 1];
                    mas[i] = mas[i] - mas[i + 1];
                }
            }

        }
        return mas;
    }

}
