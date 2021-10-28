package ru.gb;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    //побеждает тот, у кого в строке/столбце/диагонали 4 символа в любой позиции
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final int BLOCK_MOVE = 2;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc  = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");


    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void aiTurn() {
        int x, y;
        //если у компьютера есть шанс выиграть, то он выигрывает, а не блокирует ход игрока
        if (!aiBlock(DOT_O, DOTS_TO_WIN - BLOCK_MOVE + 1) && !aiBlock(DOT_X, DOTS_TO_WIN - BLOCK_MOVE)) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[x][y] = DOT_O;
        }
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[x][y] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }
    public static boolean checkWin(char symb) {
        int line = 0, vert = 0, diagrl = 0, diaglr = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == symb) {
                    line++;
                    vert++;
                    diagrl++;
                    diaglr++;
                    for (int k = j + 1; k < SIZE; k++) { //проверка по горизонтали
                        if (map[i][k] == symb) {
                            line++;
                            if (line >= DOTS_TO_WIN){
                                return true;
                            }
                        }
                        else {
                            line = 0;
                            }
                    }
                    for (int k = i + 1; k < SIZE; k++) { //проверка по вертикали
                        if (map[k][j] == symb) {
                            vert++;
                            if (vert >= DOTS_TO_WIN){
                                return true;
                            }
                        }
                        else {
                            vert = 0;
                        }
                    }
//проверка диагоналей
                    for (int k = i + 1, l = j + 1; k < SIZE && l < SIZE; k++, l++){ //слева направо
                        if (map[k][l] == symb) {
                            diaglr++;
                            if (diaglr >= DOTS_TO_WIN){
                                return true;
                            }
                        }
                        else {
                            diaglr = 0;
                        }
                    }
                    for (int k = i + 1, l = j - 1; k < SIZE &&  l >= 0; k++, l--){ //справа налево
                        if (map[k][l] == symb) {
                            diagrl++;
                            if (diagrl >= DOTS_TO_WIN){
                                return true;
                            }
                        }
                        else {
                            diagrl = 0;
                        }
                    }
                }
            }

        }
        return false;
    }
    public static boolean aiBlock(char symb, int dots) {
        int line = 0, vert = 0, diagrl = 0, diaglr = 0 , o = 0, p = 0, diagKol = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == symb) {
                    line++;
                    vert++;
                    diagrl++;
                    diaglr++;
/////////////////////////////////////////////////////////////////////////////////////
                    for (int k = j + 1; k < SIZE; k++) { //проверка по горизонтали
                        if (map[i][k] == symb) {
                            line++;
                        }
                    }
                    if (line >= dots){ //заблокируем ход
                        for (int l = 0; l < SIZE; l++) {  //проверка по горизонтали, меняем только столбец
                            if (map[i][l] == DOT_EMPTY) {
                                map[i][l] = DOT_O;
                                return true;
                            }
                        }
                    }
/////////////////////////////////////////////////////////////////////////////////////////
                    for (int k = i + 1; k < SIZE; k++) { //проверка по вертикали
                        if (map[k][j] == symb) {
                            vert++;
                        }
                    }
                    if (vert >= dots){
                        for (int l = 0; l < SIZE; l++) {//проверка по вертикали, меняем только строку
                            if (map[l][j] == DOT_EMPTY) {
                                map[l][j] = DOT_O;
                                return true;
                            }
                        }
                    }
//проверка диагоналей///////////////////////////////////////////////////////////
                    diagKol = diaglr;
                    for (int k = i + 1, l = j + 1; k < SIZE && l < SIZE; k++, l++) { //слева направо со следующего элемента
                        if (map[k][l] == symb) {
                            diaglr++;
                        }
                        diagKol++; //если в диагонали будет меньше элементов, чем нужно для победы, то не блокируем
                        //найдем начало диагонали
                        for (int m = i, n = j; m >= 0 && n >= 0; m--, n--) {
                            o = m;
                            p = n;
                        }
                    }
                    if (diaglr >= dots && diagKol >= DOTS_TO_WIN){
                            for (int m = o, n = p; m < SIZE && n < SIZE; m++, n++) {
                                if (map[m][n] == DOT_EMPTY) {
                                    map[m][n] = DOT_O;
                                    return true;
                                }
                            }
                    }
/////////////////////////////////////////////////////////////////////////////////////////////
                    diagKol = diagrl;
                    for (int k = i + 1, l = j - 1; k < SIZE && l >= 0; k++, l--) { //справа налево
                        if (map[k][l] == symb) {
                            diagrl++;
                        }
                        diagKol++;
                        o = k;  //сохраним нижние координаты диагонали
                        p = l;
                    }
                    if (diagrl >= dots && diagKol >= DOTS_TO_WIN){
                        // для диагонали справа налево, координаты верхней точки диагонали равны перевернутым координатам нижней точки
                        for (int m = p, n = o; m < SIZE && n >= 0; m++, n--) {
                            if (map[m][n] == DOT_EMPTY) {
                                map[m][n] = DOT_O;
                                return true;

                            }
                        }
                    }
                    line = 0;
                    vert = 0;
                    diagrl = 0;
                    diaglr = 0;
                }
            }
        }
        return false;
    }
}
