package ru.gb.lvl2hm2;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i, int j, String ints, RuntimeException e) {
        super("Ошибка в ячейке " + i + "x" + j +". Значение " + ints, e);
    }
}
