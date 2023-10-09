package Zadanie4;

public class hg {
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length(); }
}
