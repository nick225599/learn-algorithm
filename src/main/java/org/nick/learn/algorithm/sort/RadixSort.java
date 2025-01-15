package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class RadixSort {
    public static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws Exception {
        Date[] dates = RadixSort.generateDate();
        RadixSort.printDates(dates);
        log.info("original type 👆");
        RadixSort.radixSort(dates);
    }

    private static void printDates(Date[] dates) {
        log.info("-----------------------------------------------");
        for (Date d : dates) {
            System.out.println(DF.format(d));
        }
        log.info("-----------------------------------------------");
        System.out.println();

    }

    private static void radixSort(Date[] dates) {
        Queue<Date>[] buckets;

        // 按照秒排序
        // 按照分排序
        // 按照时排序

        // 按照日排序
        buckets = new LinkedList[31];
        for (Date d : dates) {
            int dayOfMonth = RadixSort.getDayOfMonth(d);
            int index = dayOfMonth - 1;
            Queue<Date> dateList;
            if (null == buckets[index]) {
                dateList = new LinkedList<>();
                buckets[index] = dateList;
            } else {
                dateList = buckets[index];
            }
            dateList.offer(d);
        }
        RadixSort.mergeBuckets(buckets, dates);
        log.info("after sort by day-of-month");
        RadixSort.printDates(dates);

        // 按照月排序
        buckets = new LinkedList[12];
        for (Date d : dates) {
            int month = RadixSort.getMonth(d);
            Queue<Date> dateList;
            if (null == buckets[month]) {
                dateList = new LinkedList<>();
                buckets[month] = dateList;
            } else {
                dateList = buckets[month];
            }
            dateList.offer(d);
        }
        RadixSort.mergeBuckets(buckets, dates);
        log.info("after sort by month");
        RadixSort.printDates(dates);

        // 按照年排序
        buckets = new LinkedList[2024 - 1900];
        for (Date d : dates) {
            int deltaFrom1900 = RadixSort.getDeltaFrom1900(d);
            Queue<Date> dateList;
            if (null == buckets[deltaFrom1900]) {
                dateList = new LinkedList<>();
                buckets[deltaFrom1900] = dateList;
            } else {
                dateList = buckets[deltaFrom1900];
            }
            dateList.offer(d);
        }
        RadixSort.mergeBuckets(buckets, dates);
        log.info("after sort by year");
        RadixSort.printDates(dates);


        // 按照时排序
        // 按照分排序


    }

    private static int getDayOfMonth(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    private static void mergeBuckets(Queue<Date>[] buckets, Date[] dates) {
        int i = 0;
        for (Queue<Date> bucket : buckets) {
            if (null == bucket) {
                continue;
            }
            Date d;
            while ((d = bucket.poll()) != null) {
                dates[i++] = d;
            }
        }
    }

    private static int getMonth(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.MONTH);
    }

    private static int getDeltaFrom1900(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.YEAR) - 1900;
    }

    private static Date[] generateDate() throws Exception {
        String str = "1999-04-21\n" +
                "2018-11-11\n" +
                "1991-07-16\n" +
                "1991-07-17\n" +
                "2018-04-05\n" +
                "2012-09-16\n" +
                "2001-01-31\n" +
                "1995-02-02\n" +
                "2019-09-05\n" +
                "2014-08-11\n" +
                "1996-12-03\n" +
                "1991-04-02\n" +
                "2018-03-16\n" +
                "2012-05-18\n" +
                "1994-05-27\n" +
                "2013-01-09\n" +
                "2020-03-18\n" +
                "2004-12-11\n" +
                "2009-02-08\n" +
                "2017-02-10\n" +
                "2014-05-06\n" +
                "1991-07-16";
        String[] strings = str.split("\n");
        Date[] dates = new Date[strings.length];
        for (int i = 0; i < strings.length; i++) {
            Date d = DF.parse(strings[i]);
            dates[i] = d;
        }
        return dates;
    }
}
