package ru.gb.lvl2hm2;

import java.util.stream.Stream;

public class Homework2 {
    public static void main(String[] args) {
        String[][] array = {{String.valueOf(1), String.valueOf(2), String.valueOf(3), String.valueOf(4)},
                {String.valueOf(-3), String.valueOf(-3), String.valueOf(6), String.valueOf(5)}, {String.valueOf(3),
                String.valueOf(9), String.valueOf(2),String.valueOf(5)},{String.valueOf(9), String.valueOf(2),
                String.valueOf(5), "abc"}};
        try {
            System.out.println("Сумма всех элементов равна " + arraySum(array));
        } catch (MyArraySizeException e){
            e.printStackTrace();
        }
    }

    private static int arraySum(String[][] ints) throws MyArraySizeException {
            if (ints.length == 4 && Stream.of(ints).mapToInt(m -> m.length).sum() == 16) {
                int sum = 0;
                for (int i = 0; i < ints.length; i++) {
                    for (int j = 0; j < ints[i].length; j++) {
                        try {
                            sum += Integer.parseInt(ints[i][j]);
                        } catch (NumberFormatException e) {
                            throw new MyArrayDataException(i, j, ints[i][j], e);
                        }
                    }
                }
                return sum;
            } else {
                throw new MyArraySizeException("Длина массива не 4х4");
            }
    }
}
