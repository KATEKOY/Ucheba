package Zadanie4;

public class Main {
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length(); }
    public static void main(String[] args) {
        System.out.print(count("мама папа куча","а"));
    }
}
