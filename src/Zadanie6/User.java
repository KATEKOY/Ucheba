package Zadanie6;

import java.util.Scanner;

public class User {
    private String name;
    private Integer age;
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String toString() {
        return name + ", возраст " + age + " лет";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        Integer age = scanner.nextInt();
        scanner.nextLine();
        User user = new User(name, age);
        System.out.print("Имя второго пользователя: ");
        String name2 = scanner.nextLine();
        System.out.print("Введите возраст: ");
        Integer age2 = scanner.nextInt();
        User user2 = new User(name2, age2);

        if (age<age2){
            System.out.println(user.toString());
        } else if (age>age2){
            System.out.println(user2.toString());
        }else {
            System.out.println(user.toString());
        }

    }
}