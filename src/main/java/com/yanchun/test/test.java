package com.yanchun.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author quyanchun
 * @Date 2018/12/3
 */
public class test {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df2 = new SimpleDateFormat("HH:mm");
        try
        {
            Date d1 = df.parse("2004-03-25 22:31:40");
            Date d2 = df.parse("2004-03-26 11:30:24");
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            long days = diff / (1000 * 60 * 60 * 24);

            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
            System.out.println(""+days+"天"+hours+"小时"+minutes+"分");

            System.out.println(df1.parse("2004-01-02 11:30:24"));


            System.out.println("两个日期的差距：" + differentDays(d1,d2));
        }catch (Exception e)
        {
        }
    }


    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
}
