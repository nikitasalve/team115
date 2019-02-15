import java.util.Date;
import java.util.Scanner;

import java.text.ParseException;

import java.text.SimpleDateFormat;

public class DateEx2 {
    public static void main(String[] args) throws ParseException {
        String dt;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Date (yyyy-MM-dd) ");
        dt =sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(dt);
        System.out.println(d);
    }
}