package Zadanie3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Zadanie3 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[20];
        System.out.print("Содержимое массива: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(15) + 1; // заполняем массив случайными значениями от 0 до 9
            System.out.print(array[i] + " ");

        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : array) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        System.out.println("\n Числа, встречающиеся больше одного раза:");
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Число '" + entry.getKey() + "' встречается " + entry.getValue() + " раза");
            }
        }
    }
}
