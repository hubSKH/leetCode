package leetcode.array;

/**
 * 1185. 一周中的第几天
 * @Description
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个 
 * {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * @auther SHENKAIHUAN
 * @create 2019-10-13 10:56
 */
public class DayoftheWeek {
    public static void main(String[] args) {
        int day=13;
        int month=10;
        int year=2019;
        long start =System.currentTimeMillis ();
        System.out.println (dayOfTheWeek (day,month,year));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    /**
     * 蔡勒（Zeller）公式
     *
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dayOfTheWeek(int day, int month, int year) {

        String[] weekString = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if(month<3){
            month+=12;
            year--;
        }
        int week =(1+day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        return weekString[week];
    }
}
