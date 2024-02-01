package Zadanie5;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите дату формата: день.месяц.год");
        String polzovatel = scan.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.y");
        java.util.Date date = null;
        try {
            date = dateFormat.parse(polzovatel);
            System.out.printf("Дата: %1$td %1$tm %1$tY", date);
        } catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + date);
        }

        //увеличиваем дату на 45 дней
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 45);
        Date newDate = calendar.getTime();
        System.out.printf("\nНовая дата: %1$td.%1$tm.%1$tY", newDate);
        //ставим дату на начало года
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date shiftedDate = calendar.getTime();
        System.out.printf("\nНачало года: %1$td.%1$tm.%1$tY", shiftedDate);

// добавляем 10 рабочих дней с учётом выходных
        calendar.setTime(date);
        int workingDays = 0;
        while (workingDays < 10) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workingDays++;
            }
        }
        Date workingWeek = calendar.getTime();
        System.out.printf("\nДата с прибавлением 10 рабочих дней: %1$td.%1$tm.%1$tY ", workingWeek);

// добавление ещё одной даты и сохранение ёё в переменной класса Date
        System.out.println("\nВведите дату формата: день.месяц.год");
        String polzovatel2 = scan.nextLine();
        java.util.Date date2 = null;
        try {
            date2 = dateFormat.parse(polzovatel2);
            System.out.printf("Дата: %1$td %1$tm %1$tY", date2);
        } catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + date2);
        }

// сравниваем количество дней между датами с учётом выходных

        calendar.setTime(date);
        Calendar calendar2 = new GregorianCalendar();
        calendar2.setTime(date2);
        int workingDays2 = 0;
        while (calendar.before(calendar2)) {
            int dayOfWeek2 = calendar.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek2 != Calendar.SATURDAY && dayOfWeek2 != Calendar.SUNDAY) {
                workingDays2++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }System.out.println("\nРазница: " + workingDays2 + " рабочих дней");

    }

    }



