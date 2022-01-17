package ru.gb.lvl2hm3;

import java.util.HashMap;
import java.util.Map;

public class Homework3 {
    public static void main(String[] args) {
        HashMap<String, Integer> myMap = new HashMap<>();
        String[] list = {"волк", "медведь", "кот", "лиса", "кабан", "лось", "лошадь", "крокодил", "кабан",
                "волк", "кабан", "кот", "кабан", "собака", "кабан", "лось"};
        for (int i = 0; i < list.length; i++) {
            if (!myMap.containsKey(list[i])) { //если в мапе нет еще этой строки
                int count = 1; // кол-во повторений строки в массиве
                for (int j = 0; j < list.length; j++) {
                    if (i != j && list[i].equals(list[j])) {
                        count++;
                    }
                }
                myMap.put(list[i], count);
            }
        }
        System.out.println("Список уникальных строк: ");
        for (Map.Entry<String, Integer> o : myMap.entrySet()) {
            if (o.getValue().equals(1))
            System.out.println(" - " + o.getKey());
        }
        System.out.println("------------------------------------------");
        for (Map.Entry<String, Integer> o : myMap.entrySet()) {
            System.out.println("Строка " + o.getKey() + " встретилась " + o.getValue() + " раз.");
        }
        System.out.println("------------------------------------------");
        PhoneBook book = new PhoneBook();
        book.add("nemov","+79161111111");
        book.add("nemov","+79161111112");
        book.add("nemov","+79161111113");
        book.add("nemov1","+79161111114");
        book.add("nemov1","+79161111115");
        System.out.print(book);
        System.out.println("------------------------------------------");
        System.out.println(book.get("nemov"));
    }
}
