package ru.gb.lvl2hm3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook   {
     HashMap<String, String> myMap = new HashMap<>();
     public void add(String lastName, String number){
      myMap.put(number, lastName);
     }
     public ArrayList<String> get(String lastName){
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, String> o : myMap.entrySet()) {
            if (o.getValue().equals(lastName)) {
                list.add(o.getKey());
            }
        }
        return list;
     }
     @Override
     public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> o : myMap.entrySet()) {
            stringBuilder.append("Фамилия: " + o.getValue() + "; ");
            stringBuilder.append("Телефон: " + o.getKey() + "\n");
        }
        return stringBuilder.toString();
     }
}
