package test;

import com.github.javafaker.Faker;
import org.joda.time.Days;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class LocalDateTest {


    public static void main(String[] args) {

        //Current Date

//        LocalDate today = LocalDate.now();
//        System.out.println("Current Date=" + today);

        //Creating LocalDate by providing input arguments
//        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
//        System.out.println("Specific Date=" + firstDay_2014);


        //Try creating date by providing invalid inputs
        //LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
        //Exception in thread "main" java.time.DateTimeException:
        //Invalid date 'February 29' as '2014' is not a leap year

//        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
//        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
//        System.out.println("Current Date in IST="+todayKolkata);
//
//        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
//        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));
//
//        //Getting date from the base date i.e 01/01/1970
//        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
//        System.out.println("365th day from base date= "+dateFromBase);
//
//        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
//        System.out.println("100th day of 2014="+hundredDay2014);
//    }

    }




    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static String createRandomDate() {

        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(1970, 2020);


        return month+"/" +day+"/"+ year;
    }





}
