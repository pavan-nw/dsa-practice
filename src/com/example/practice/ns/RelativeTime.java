package com.example.practice.ns;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class RelativeTime {
    public static void main(String[] args) throws InterruptedException {
        Date start = new Date();
//        sleep(1029 * 67L);
        Date end = new Date();
        System.out.println(relativeTime(start, end));
    }

    public static String relativeTime(Date start, Date end) {
//        long milliseconds = end.getTime() - start.getTime();
        long milliseconds = 1675788647910L - 1675574400000L;
        long DD = TimeUnit.MILLISECONDS.toDays(milliseconds);
        long HH = TimeUnit.MILLISECONDS.toHours(milliseconds) % 24;
        long MM = TimeUnit.MILLISECONDS.toMinutes(milliseconds) % 60;
        long SS = TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60;
        long SSS = milliseconds % 1000;
        return String.format("Day %02d - %02dH:%02dM:%02dS:%03d", DD, HH, MM, SS, SSS);
    }
}
