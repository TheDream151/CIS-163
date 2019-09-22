package Project1new;

import java.io.*;
import java.util.Scanner;


/**********************************************************************
 *DONT FORGET TO ADD YOUR INFORMATION UPON COMPLETION
 * Please describe your class
 *
 * @author Travis & Brandon Moody
 *@version 1.2
 **********************************************************************/

public class GeoCountDownTimer {

    private int month;

    private int year;

    private int day;

    private static final int MIN_YEAR = 2015;

    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31,
            30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final String[] MONTHS = {"", "January",
            "February", "March", "April", "May", "June", "July"
            , "August", "September", "October", "November", "December"};

    public GeoCountDownTimer() {
        this.month = 1;
        this.year = MIN_YEAR;
        this.day = 1;
    }

    public GeoCountDownTimer(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }


    public GeoCountDownTimer(GeoCountDownTimer other) {
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }

    public  GeoCountDownTimer(String geoDate) {
        String[] s = geoDate.split("/");
        int month, day, year;
        if (s.length == 3) {
             month = Integer.parseInt(s[0]);
             day = Integer.parseInt(s[1]);
             year = Integer.parseInt(s[2]);
        } else
            throw new IllegalArgumentException();

        if (!isValidDate(month, day, year))
            throw new IllegalArgumentException();

        this.month = month;
        this.day = day;
        this.year = year;

    }

    private boolean isValidDate(int month, int day, int year) {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException();
        }
        if (year < MIN_YEAR) {
            throw new IllegalArgumentException();
        }
        if (DAYS_IN_MONTH[month] < day) {
            throw new IllegalArgumentException();
        }
        if (isLeapYear(year) && month == 2) {
            if (day > 29) {
                throw new IllegalArgumentException();
            }
        }
        return true;

    }


    private boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400  == 0))
            return true;
        else
            return false;
    }

    private int daysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year))
           return 29;
        return DAYS_IN_MONTH[month];

    }

    public boolean equals(Object other) {
        if (other != null) {
            if (other instanceof GeoCountDownTimer) {
                GeoCountDownTimer temp = (GeoCountDownTimer) other;
                if (temp.day == this.day && temp.month == this.month
                        && temp.year == this.year)
                    return true;
            }
        }
        return false;
    }

    public int compareTo(GeoCountDownTimer other) {
        if (other.year < this.year)
            return 1;
        else if (other.year > this.year)
            return -1;

        if (other.month < this.month)
            return 1;
        else if (other.month > this.month)
            return -1;

        if (other.day < this.day)
            return 1;
        else if (other.day > this.day)
            return -1;

        return 0;

    }

    public void dec(int days) {
        if (days > 0) {

            while (days > 0) {
                day--;
                if (day < 1) {
                    month--;
                    day = daysInMonth(month, year);


                    if (month < 1) {
                        month = 12;
                        year--;

                    }
                }
                days--;
            }
        } else
            throw new IllegalArgumentException();
    }

    public void dec() {
        dec(1);
    }

    public void inc(int days) {
        if (days > 0) {

            while (days > 0) {
                day++;
                if (day > daysInMonth(month, year)) {
                    day = 1;
                    month++;

                    if (month > 12) {
                        month = 1;
                        year++;

                    }
                }
                days--;
            }
        } else
            throw new IllegalArgumentException();
    }
//

    public void inc() {
        inc(1);
    }

    public String toString() {
        return MONTHS[month] + " " + day + ", " + year;
    }

    public String toDateString() {
        return month + "/" + day + "/" + year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void save(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(
                    fileName)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        out.println(month);
        out.println(day);
        out.println(year);

        out.close();
    }

    public void load(String fileName){
        try{

            // open the data file
            Scanner fileReader = new Scanner(new File(fileName));
            month = fileReader.nextInt();
            day = fileReader.nextInt();
            year = fileReader.nextInt();
            System.out.println (toDateString());

        }

        // problem reading the file
        catch(Exception error){
            System.out.println("Oops!  Something went wrong.");
        }
    }
    public int daysToGo(String fromDate){
        GeoCountDownTimer s1 = new GeoCountDownTimer(fromDate);//Deleted the this
        //GeoCountDownTimer s2 = new GeoCountDownTimer();//Deleted the fromDate form the parameter

        int count = 0;
        if(compareTo(s1) == 1){
            while(compareTo(s1) != 0){
                s1.inc(1);
                count++;
            }
        }
        else if(compareTo(s1) == -1)throw new IllegalArgumentException();

        return count;
    }
    public GeoCountDownTimer daysInFuture(int n){
        GeoCountDownTimer d1 = new GeoCountDownTimer(this);
        GeoCountDownTimer temp = new GeoCountDownTimer(this);
        if(n >= 0)
            temp.inc(n);
        else
            throw new IllegalArgumentException();
        return temp;
    }
}