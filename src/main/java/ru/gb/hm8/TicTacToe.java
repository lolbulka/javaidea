package ru.gb.hm8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class TicTacToe extends JFrame {
    private static int SIZE = 3;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static JButton[][] map;
    private static Random rand = new Random();
    private static boolean isExit = false;
    private static boolean isGoodMove = false;

    public TicTacToe() {
        setBounds(800, 400, 400, 400);
        setTitle("TicTacToe Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        printMap(); //напечатаем поле
        // Панель для кнопок добавляем вниз формы
        JPanel buttonPanel = new JPanel(new GridLayout());
        add(buttonPanel, BorderLayout.NORTH);
        JButton btnStart = new JButton("Начать новую игру");
        JButton btnEnd = new JButton("Закончить игру");
        buttonPanel.add(btnStart);
        buttonPanel.add(btnEnd);
        setVisible(true);
        // Добавим обработчик событий для закрытия формы
        btnEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // Добавляем обработчик событий для создания новой игры
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Загружаем новую форму
                setVisible(false);
                new TicTacToe();
            }
        });
        // играем
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int finalI = i;
                int finalJ = j;
                map[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (humanTurn(finalI, finalJ)) {
                            System.out.println("Вы победили!");
                            isExit = true;
                        } else if (isGoodMove && !isMapFull() && aiTurn()) {
                            System.out.println("Победил компьютер!");
                            isExit = true;
                        } else if (isMapFull()) {
                            System.out.println("Ничья!");
                            isExit = true;
                        }
                        if (isExit) { //в случае окончания игры перезапустим ее
                            setVisible(false);
                            isExit = false;
                            new TicTacToe();
                        }
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    public void printMap() { //создадим игровое поле
        JPanel buttPanel = new JPanel(new GridLayout(SIZE, SIZE));
        add(buttPanel, BorderLayout.CENTER);
        map = new JButton[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = (JButton) buttPanel.add(new JButton(String.valueOf(DOT_EMPTY)));
            }
        }
    }

    public static boolean humanTurn(int i, int j) { //ход человека
        isGoodMove = false;
        if (isCellValid(i, j)) {
            isGoodMove = true;
            map[i][j].setText(String.valueOf(DOT_X));
        }
        if (checkWin(DOT_X)) {
            return true;
        }
        return false;
    }

    public static boolean aiTurn() { //ход компьютера
        int x = 0;
        int y = 0;
        boolean ai_win = false;
        boolean player_win = false;
        // Находим победный ход
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j].setText(String.valueOf(DOT_O));
                    if (checkWin(DOT_O)) {
                        x = i;
                        y = j;
                        ai_win = true;
                    }
                    map[i][j].setText(String.valueOf(DOT_EMPTY));
                }
            }
        }
        // Блокировка хода пользователя, если он побеждает на следующем ходу
        if (!ai_win) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i, j)) {
                        map[i][j].setText(String.valueOf(DOT_X));
                        if (checkWin(DOT_X)) {
                            x = i;
                            y = j;
                            player_win = true;
                        }
                        map[i][j].setText(String.valueOf(DOT_EMPTY));
                    }
                }
            }
        }
        if (!ai_win && !player_win && !isMapFull()) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }
            while (!isCellValid(x, y));
        }
        map[x][y].setText(String.valueOf(DOT_O));
        if (checkWin(DOT_O)) {
            return true;
        }
        return false;
    }

    public static boolean isCellValid(int x, int y) { //проверка на незанятость
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y].getText().equals(String.valueOf(DOT_EMPTY))) return true;
        return false;
    }

    public static boolean isMapFull() { //все ли поле занято
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j].getText().equals(String.valueOf(DOT_EMPTY))) return false;
            }
        }
        return true;
    }

    public static boolean checkLine(int start_x, int start_y, int dx, int dy, char symb) { //проверка линий на победу
        for (int i = 0; i < SIZE; i++) {
            if (!map[start_x + i * dx][start_y + i * dy].getText().equals(String.valueOf(symb)))
                return false;
        }
        return true;
    }

    public static boolean checkWin(char symb) { //проверка всех комбинаций на игровом поле на победу
        for (int i = 0; i < SIZE; i++) {
            // проверяем строки
            if (checkLine(i, 0, 0, 1, symb)) return true;
            // проверяем столбцы
            if (checkLine(0, i, 1, 0, symb)) return true;
        }
        // проверяем диагонали
        if (checkLine(0, 0, 1, 1, symb)) return true;
        if (checkLine(0, SIZE - 1, 1, -1, symb)) return true;
        return false;
    }
}