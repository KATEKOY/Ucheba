package Zadanie4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class zadanie4 {

    public static void main(String[] args) {
        //4.1
        Scanner scan = new Scanner(System.in);
      /*  String stroka = scan.nextLine(); // купил купец купон на купаж зёрен
        String podstroka = scan.nextLine(); // куп
        System.out.println((stroka).split(podstroka).length - 1);*/

        //4.2
       /* String repstr = scan.nextLine();
        String replStr1 = repstr.replace("кака", "'Вырезано цензурой'");
        String replStr2 = replStr1.replace("бяка", "'Вырезано цензурой'");
        System.out.println(replStr2);*/

        //4.3
       /* String date = scan.nextLine();
        String year = date.substring(6);
        String month = date.substring(3, 5);
        String day = date.substring(0, 2);
        String format = year + "-" + month + "-" + day;
        System.out.println(format);*/

        //4.4
        String data = "09.10.2023";
        SimpleDateFormat data1 = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat data2 = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date1 = data1.parse(data);
            String outputDateString = data2.format(date1);
            ;
            System.out.println(outputDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


