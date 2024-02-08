package Zadanie7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class User1 {
    private String name;
    private Integer age;

    static class AgeComparator implements Comparator<User1> {
        public int compare(User1 u1, User1 u2) {
            return Integer.compare(u1.getAge(), u2.getAge());
        }
    }
    public User1(String name, Integer age) {
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

    public static void main (String[] args){
        ArrayList<User1> humen = new ArrayList<User1>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<5; i++ ){
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите возраст: ");
            Integer age = scanner.nextInt();
            scanner.nextLine();
            User1 newUser = new User1(name, age);
            humen.add(newUser);
        }
        Collections.sort(humen, new AgeComparator());
        for (User1 user : humen) {
            System.out.println(user.toString());
        }
    }

}
