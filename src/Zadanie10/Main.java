package Zadanie10;

import java.util.stream.LongStream;
public class Main {
    public static void main(String[] args) {
        System.out.println(sumNumbersBetween(10000000, 1000000000));
    }
    public static long sumNumbersBetween(int a, int b) {
        return LongStream.range(a, b)
                .sum();
    }

}
