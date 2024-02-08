package Zadanie8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return name + ",возраст" + age + "лет";
    }

    public static void main (String[] args){
        HashMap<Integer, List<User>> myHash = new HashMap<Integer, List<User>>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<5; i++){
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите возраст: ");
            Integer age = scanner.nextInt();
            scanner.nextLine();
            User users = new User (name, age);
            List<User> list = myHash.getOrDefault(age, new ArrayList<>());
            list.add(users);
            myHash.put(age, list);
        }
        System.out.print("Введите требуемый возраст: ");
        int requiredAge = scanner.nextInt();
        List<User> list = myHash.get(requiredAge);
        if (list != null) {
            list.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));

            for (User user : list) {
                System.out.println(user);
            }
        } else {
            System.out.println("Пользователи с требуемым возрастом не найдены");
        }
    }
    }