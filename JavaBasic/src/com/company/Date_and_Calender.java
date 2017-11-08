package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期类的使用
 * Created by moqiaowen on 2017/5/15.
 */
public class Date_and_Calender {

    public static void main(String[] args) throws ParseException {
        // write your code here

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        //String转Date
        String dateString = "2017-05-15";
        Date stringToDate = formatter.parse(dateString);
        System.out.println(stringToDate);

        //Date转String
        Date todayDate = new Date();
        String dateToString = formatter.format(todayDate);
        System.out.println("Date To String : " + dateToString);
        System.out.println("Date To String 2 : " + todayDate.toString()); //简单转换



        //获取两个星期前的星期六
        Calendar cal = new GregorianCalendar();
        cal.setTime(todayDate);
        cal.add(Calendar.WEEK_OF_MONTH, -2);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        Date resultDate = cal.getTime();
        System.out.println(resultDate);
    }
}
