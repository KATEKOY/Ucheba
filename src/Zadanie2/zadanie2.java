package Zadanie2;

import java.util.Scanner;

public class zadanie2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Задайте значение переменной 'a' ");
        int num1 = scan.nextInt();
        System.out.println("Задайте значение переменной 'b' ");
        int num2 = scan.nextInt();
        System.out.println("Задайте значение переменной 'c' ");
        int num3 = scan.nextInt();

        int a = num1;
        int b = num2;
        int c = num3;

        if (a % 5 ==0){
            System.out.print("a= " + a + ", \n");
        } if (b % 5 ==0) {
            System.out.print("b= " + b + ", \n");
        } if (c % 5 == 0) {
            System.out.print("c= "+ c + ", \n");
        }if (a % 5 !=0 && b % 5 !=0 && c % 5 != 0){
            System.out.println("нет значений, кратных 5 \n");
        }
        System.out.println("значение от целочисленного деления a на b = " + a/b);
        float a1 = a;
        float b1 = b;
        System.out.println("значение от деления a на b(число с плавающей запятой) = " + a1/b1);

        double res = Math.ceil(a1/b1);
        System.out.println("значение от деления a на b, округленного до ближайшего целого в большую сторону = " + res);
        double res1 = Math.floor(a1/b1);
        System.out.println("значение от деления a на b, округленного до ближайшего целого в меньшую сторону = " + res1);
        double res2 = Math.round(a1/b1);
        System.out.println("значение от деления a на b, округленного до ближайшего целого математическим округлением = "+ res2);
        System.out.println("остаток от деления b на c = " + b%c);
        if (a<b){
            System.out.println("наименьшее значение из a и b = " + a);
        }else {
            System.out.println("наименьшее значение из a и b = " + b);
        }
        if (b<c) {
            System.out.println("наибольшее значение из b и c = " + c);
        }else {
            System.out.println("наибольшее значение из b и c = " + b);
        }
    }
}

