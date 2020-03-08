package com.only.you.utils;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

    public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YYYYMM = "yyyy-MM";

    /**
     * 获取当前时间时间厝
     * @return
     */
    public static Timestamp getNowTimestamp(){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return ts;
    }

    /** 获取今天 */
    public static Date getNowDate() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }

    /**
     * 获取明天的日期
     * @return
     */
    public static String getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);//+1今天的时间加一天
        date = calendar.getTime();
        String date2Str = date2Str(date, null);
        return date2Str;
    }

    //得到18天后的日期
    public static long getDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,18);
        long time = calendar.getTimeInMillis();
        /*long time = new Date().getTime();*/
        return time;
    }
    /**
     * @Title:returnStrs
     * @Description: 将时间类型Date转换为到日的字符串
     * @param date
     * @return
     * @return String
     */
    public static String date2Strday(Date date){
        return date2Str(date, DATE_FORMAT_YYYYMMDD);
    }
    /**
     * @Title:returnStrs
     * @Description: 将时间类型Date转换为到日的字符串
     * @param date
     * @return
     * @return String
     */
    public static String date2Strmonth(Date date){
        return date2Str(date, DATE_FORMAT_YYYYMM);
    }
    /**
     * @Title:returnData
     * @Description: 字符串转换成日期
     * @param dateStr
     * @return
     * @return Date
     */
    public static Date datestr2Date(String dateStr,String format){
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        if (StringUtils.isEmpty(format)) {
            format = DATE_FORMAT_YYYYMMDDHHMMSS;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);//小写的mm表示的是分钟
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            log.error("错误:",e);
        }
        return null;
    }
    /**
     * 将时间类型Date转换为指定日期格式的字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format) {
        if (date == null) {
            return null;
        }
        if (StringUtils.isEmpty(format)) {
            format = DATE_FORMAT_YYYYMMDDHHMMSS;
        }
        try {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            return sf.format(date);
        } catch (Exception e) {
            log.error("错误:",e);
        }
        return null;
    }
    /**
     * 将长整型数字转换为日期格式的字符串
     *
     * @param time
     * @param format
     * @return
     */
    public static String long2DatestrByFormt(long time, String format) {
        if (time > 0L) {
            if (StringUtils.isEmpty(format)) {
                format = DATE_FORMAT_YYYYMMDDHHMMSS;
            }
            try {
                Date date = new Date(time);
                return date2Str(date, format);
            } catch (Exception e) {
                log.error("错误:",e);
            }
        }
        return null;
    }
    /**
     * 将日期格式的字符串转换为长整型
     *
     * @param date
     * @param format yyy-MM-dd HH:mm:ss
     * @return
     */
    public static long datestr2LongByFormt(String date, String format) {
        if (StringUtils.isEmpty(date)) {
            return 0l;
        }
        if (StringUtils.isEmpty(format)) {
            format = DATE_FORMAT_YYYYMMDDHHMMSS;
        }
        try {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            return sf.parse(date).getTime();
        } catch (Exception e) {
            log.error("错误:",e);
        }
        return 0l;
    }
    /**
     * 将日期格式的字符串转为Timestamp
     * @param tsStr yyy-MM-dd HH:mm:ss
     * @return
     */
    public  static Timestamp datestr2Time(String tsStr) {
//        Timestamp ts = new Timestamp(System.currentTimeMillis());
        //	String tsStr = "2011-05-09 11:49:45";
        if (StringUtils.isEmpty(tsStr)) {
            return null;
        }
        try {
            Timestamp ts = Timestamp.valueOf(tsStr);
//			System.out.println(ts);
            return ts;
        } catch (Exception e) {
            log.error("错误:",e);
        }
        return null;
    }
    /**
     *  Date类型转成TimeStamp
     * @param date
     * @return
     */
    public static Timestamp date2Time(Date date) {
        if (date == null) {
            return null;
        }
        try {
            Timestamp ts = new Timestamp(date.getTime());
//			System.out.println(ts);
            return ts;
        } catch (Exception e) {
            log.error("错误:",e);
        }
        return null;
    }
    /**
     * tTimeStamp类型转成Date
     * @param timeStamp
     * @return
     */
    public static Date time2Date(Timestamp timeStamp) {
//        Date date = new Date();
        try {
//			Date d = new Date(timeStamp.getTime());
            Date date = new Date(timeStamp.getTime());
//            System.out.println(date);
            return date;
        } catch (Exception e) {
            log.error("错误:",e);
        }
        return null;
    }

    /**
     * 对时间按天进行增减
     * @param date
     * @param day
     * @return
     */
    public static Date updateDayByDate(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }
    /**
     * 对时间按月进行增减
     * @param date
     * @param month
     * @return
     */
    public static Date updateMonthByDate(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 对时间按小时进行增减
     * @param date
     * @param hours
     * @return
     */
    public static Date updateHourByDate(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return cal.getTime();
    }

    /**
     * 当前时间增加/较少周数后的时间
     * @param date
     * @param addDay
     * @return
     */
    public static Date updateWeekByDate(Date date,int addDay){
        //
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_WEEK, addDay);
        Date time = calendar.getTime();
        return time;
    }
    /**
     * 判断当前日期是星期几
     *
     * @return dayForWeek 判断结果  7，1、2、3、4、5、6、分别代表：周日、周一、周二、周三、周四、周五、周六
     * @Exception 发生异常
     */
    public static int todayForWeek() {

        return dayForWeek(new Date());
    }

    /**
     * 判断日期是星期几
     *
     * @return dayForWeek 判断结果  7，1、2、3、4、5、6、分别代表：周日、周一、周二、周三、周四、周五、周六
     * @Exception 发生异常
     */
    public static int dayForWeek(Date now) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(now);
            int dayForWeek = 0;
            if(c.get(Calendar.DAY_OF_WEEK) == 1){
                dayForWeek = 7;
            }else{
                dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
            }
            return dayForWeek;
        } catch (Exception e) {
            log.error("错误:",e);
        }
        return -1;
    }

    /**
     *  获取本周某一天
     * @param weekDay   weekDay值为：1、2、3、4、5、6、7，分别代表：周日、周一、周二、周三、周四、周五、周六
     * @return  返回本周某一天 （时分秒为当前时间时分秒）
     */
    public static Date getDayOfThisWeek(int weekDay){
        if (weekDay < 1 || weekDay > 7) {

            return null;
        }
        return getDayOfWeekByWhichDate(new Date(), weekDay);
    }

    /**
     *  获取某个时间对应的周的某一天
     *  *@param whichDate  时间
     * @param weekDay   weekDay值为：1、2、3、4、5、6、7，分别代表：周日、周一、周二、周三、周四、周五、周六
     * @return  返回某个时间对应的周的某一天 （时分秒为当前时间时分秒）
     */
    public static Date getDayOfWeekByWhichDate(Date whichDate,int weekDay){
        if (whichDate == null) {
            return null;
        }
        if (weekDay < 1 || weekDay > 7) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(whichDate);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, weekDay);
        return calendar.getTime();
    }
    /**
     *   获取本周周日
     * @return  返回本周周日 （时分秒为当前时间时分秒）
     */
    public static Date getSundayOfThisWeek() {
        return getDayOfWeekByWhichDate(new Date(), Calendar.SUNDAY);
    }
    /**
     *  获取本周周一
     * @return  返回本周周一  （时分秒为当前时间时分秒）
     */
    public static Date getMondayOfThisWeek() {
        return getDayOfWeekByWhichDate(new Date(), Calendar.MONDAY);
    }

    /**
     *  获取上周周一
     * @return  返回上周周一
     */
    public static Date getMondayOfLastWeek() {
        Date lastWeek = updateWeekByDate(new Date(), -1);
        return getDayOfWeekByWhichDate(lastWeek,Calendar.MONDAY);

    }

    /** 获取上周周日 */
    /**
     *  获取上周周日
     * @return 返回上周周日
     */
    public static Date getSundayOfLastWeek() {
        Date lastWeek = updateWeekByDate(new Date(), -1);
        return getDayOfWeekByWhichDate(lastWeek,Calendar.SUNDAY);
    }

    /**
     *  获取当前时间间隔N周的周几
     * @param weekDay weekDay值为：1、2、3、4、5、6、7，分别代表：周日、周一、周二、周三、周四、周五、周六
     * @param poor 间隔
     * @return 当前时间间隔N周的周几
     */
    public static Date getDayOfPoorThisWeek(int weekDay,int poor) {
        if (weekDay < 1 || weekDay > 7) {
            return null;
        }
        Date poorWeek = updateWeekByDate(new Date(), poor);
        return getDayOfWeekByWhichDate(poorWeek,weekDay);
    }

    /**
     *  获取某个时间间隔N周的周几
     * @param whichDate 某个时间
     * @param weekDay weekDay值为：1、2、3、4、5、6、7，分别代表：周日、周一、周二、周三、周四、周五、周六
     * @param poor 间隔
     * @return 某个时间间隔N周的周几
     */
    public static Date getDayOfPoorWeekByWhichDate(Date whichDate,int weekDay,int poor) {
        if (whichDate == null) {
            return null;
        }
        if (weekDay < 1 || weekDay > 7) {
            return null;
        }
        Date poorWeek = updateWeekByDate(whichDate, poor);
        return getDayOfWeekByWhichDate(poorWeek,weekDay);
    }

    /**
     *  获取某天的0点
     * @param fDay
     * @return
     */
    public static Date getZeroStartTimeByDate(Date fDay) {
        if (fDay == null) {
            return  null;
        }
        return datestr2Date(date2Str(fDay, "yyyy-MM-dd 00:00:00"),DATE_FORMAT_YYYYMMDDHHMMSS);
    }
    /**
     * 获取某天的23：59：59时间
     * @param fDay
     * @return
     */
    public static Date getZeroEndTimeByDate(Date fDay) {
        if (fDay == null) {
            return  null;
        }
        return datestr2Date(date2Str(fDay, "yyyy-MM-dd 23:59:59"),DATE_FORMAT_YYYYMMDDHHMMSS);
    }

    /** 获取本月一号 */
    public static Date getFirstDayOfThisMonth() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }
    /**
     * 获取本月最后一天
     */
    public static Date getLastDayOfThisMonth() {
        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        // calendar.setTime(new Date());
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return calendar.getTime();
    }

    /**
     * 返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /** 获取两个时间的时间查 如1天2小时30分钟 */
    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
         long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟"+ sec + "秒";
    }


    /** 获取两个时间的时间查 如1天2小时30分钟 */
    public static String getDatePoorS(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        long msec = diff % nd % nh % nm % ns;
        return day + "天" + hour + "小时" + min + "分钟"+ sec + "秒" + msec + "毫秒";
    }
    /**
     * @Title:getDatePoor
     * @Description: 返回日期差值
     * @param endDate
     * @param nowDate
     * @param flag(d：相差多少天；h：相差多少小时；m：相差多少分；空或者其他值则返回0)
     * @return
     * @return String
     */
    public static long getDatePoor(Date endDate, Date nowDate, String flag) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
//        // 计算差多少天
//        long day = diff / nd;
//        // 计算差多少小时
//        long hour = diff % nd / nh;
//        // 计算差多少分钟
//        long min = diff % nd % nh / nm;
//        // 计算差多少秒//输出结果
//        long sec = diff % nd % nh % nm / ns;
//        long result = 0;
        if("d".equals(flag)){
            return diff / nd;
        }else if("h".equals(flag)){
            return diff % nd / nh;
        }else if("m".equals(flag)){
            return diff % nd % nh / nm;
        }else if("s".equals(flag)){
            return diff % nd % nh % nm / ns;
        }
        return 0l;
    }

//    /**
//     * 获取当前时间字符串结果
//     */
//    public static void getTimeByCalendar(){
//        Calendar cal = Calendar.getInstance();
//        int year = cal.get(Calendar.YEAR);//获取年份
//        int month=cal.get(Calendar.MONTH);//获取月份
//        int day=cal.get(Calendar.DATE);//获取日
//        int hour=cal.get(Calendar.HOUR);//小时
//        int minute=cal.get(Calendar.MINUTE);//分
//        int second=cal.get(Calendar.SECOND);//秒
//        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
//        System.out.println("现在的时间是：公元"+year+"年"+month+"月"+day+"日      "+hour+"时"+minute+"分"+second+"秒       星期"+WeekOfYear);
//    }

    /**
     * 获取上月的第一天
     *
     * @return
     */
    public static Date getLastMonthFirstDay(Date date){

        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }
    /**
     * 获取上月的最后一天
     *
     * @return
     */
    public static Date getLastMonthEndDay(Date date){

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND,59);
        int month=calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        return calendar.getTime();
    }
    public static String getTimeTask(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    public static void main(String[] args) {




//        System.out.println(str2Time("2018-08-08 08:08:08"));

//        System.out.println(DateUtil.formatDate(getDayOfWeekByWhichDate(new Date(),6),"yyyy-MM-dd HH:mm:ss"));
//
//        System.out.println(todayForWeek());
//        System.out.println(dayForWeek(new Date()));
//        System.out.println(dayForWeek(DateUtil.updateDate(new Date(),-1)));
//        System.out.println(dayForWeek(DateUtil.updateDate(new Date(),1)));
//        System.out.println(dayForWeek(DateUtil.updateDate(new Date(),3)));
//        System.out.println(DateUtil.getDayOfThisWeek(6));
//        System.out.println(DateUtil.returnData(DateUtil.formatDate(DateUtil.getDayOfThisWeek(6), "yyyy-MM-dd") + " 16:00:00"));
//        System.out.println(DateUtil.date2Time(DateUtil.returnData(DateUtil.formatDate(DateUtil.getDayOfThisWeek(6), "yyyy-MM-dd") + " 16:00:00")));
//        System.out.println(System.currentTimeMillis());
//        System.out.println(System.currentTimeMillis()-DateUtil.date2Time(DateUtil.returnData(DateUtil.formatDate(DateUtil.getDayOfThisWeek(6), "yyyy-MM-dd") + " 16:00:00")).getTime());

//		System.out.println(time2Date());


//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		getTimeByCalendar();
//		System.out.println(sdf.format(getMondayOfThisWeek()));
//		System.out.println(sdf.format(getSundayOfThisWeek()));
//
//		System.out.println(sdf.format(getDayOfThisWeek(3)));
//
////		System.out.println(sdf.format(getMondayOfWhichWeek(DateUtil.updateDate(new Date(),10))));
////		System.out.println(sdf.format(getSundayOfWhichWeek(DateUtil.updateDate(new Date(),10))));
//		System.out.println(sdf.format(getDayOfWeekByWhichDate(DateUtil.updateDate(new Date(),10),3)));
//
//		System.out.println(sdf.format(getMondayOfLastWeek()));
//		System.out.println(sdf.format(getSundayOfLastWeek()));
//		System.out.println(sdf.format(getDayOfPoorThisWeek(1,1)));
//		System.out.println(sdf.format(getDayOfPoorWeekByWhichDate(DateUtil.updateDate(new Date(),10),1,1)));
//
//
//		System.out.println(sdf.format(getFirstDayOfThisMonth()));
//
//		System.out.println(sdf.format(getFirstDayOfThisMonth()));
//
//		System.out.println(sdf.format(getSundayOfThisWeek()));
//		System.out.println(sdf.format(getToday()));
//		System.out.println(getTime());
////		System.out.println("  --  " + addDay(new Date()));
////		System.out.println(sdf.format(getLastDayOfThisMonth()));
////		System.out.println(sdf.format(reduceTwoDay(new Date())));
////
////		System.out.println(getDatePoor(addDay(new Date()), new Date()));
////
////		System.out.println(updateDate(getToday(), 2));
////		System.out.println(returnDataSdf("2017-01-01","yyyy-MM-dd"));
//		System.out.println(formatDate(updateDate(returnDataSdf("2017-01-01 00:00:00","yyyy-MM-dd"), 1),"yyyy-MM-dd HH:mm:ss"));

//		System.out.println(convert2String(1533206346956L,null));
//		System.out.println(convert2String(1533139200L*1000L,null));
//		System.out.println(convert2String(1508947200L*1000L,null));
//		long ss1 = convert2long("2018-08-03 00:00:00",null);
//		long ss2 = convert2long("2018-08-02 00:00:00",null);
//		System.out.println(ss1-ss2);
//		System.out.println(24*60*60*1000);
//		System.out.println(ss);
//		String sss = convert2String(ss, null);
//		System.out.println(sss);
//		long ssss = convert2long(sss,null);
//		System.out.println(ssss);



    }

}
