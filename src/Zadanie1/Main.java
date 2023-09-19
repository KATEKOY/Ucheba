package Zadanie1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Как тебя зовут? ");
        String username = scan.nextLine();
        System.out.println("Привет, " + username + "!");

    }
}