import java.util.Scanner;

public class PreDate {
    public static void main(String[] args) {
        int year=2024,month=9,day=12,isEnd = 0;
            Scanner in = new Scanner(System.in);
        while (isEnd != 1){
            System.out.println("请依次输入年月份");
            try {
                year = in.nextInt();
                month = in.nextInt();
                day = in.nextInt();
            } catch (Exception e) {
                System.out.println("请输入有效数字");
                System.exit(0);
            }
            System.out.println(preDate(year, month, day));
            System.out.println("结束请输入1!");
            isEnd = in.nextInt();
        }
    }

    public static String preDate(int year, int month, int day) {
        if (validateDate(year, month, day)) {
            if(day == 1){
                if (month == 1){
                    if (year == 1){
                        year = -1;
                    }
                    else {
                        year = year - 1;
                    }
                    month = 12;
                    day = 31;
                }
                else {
                    month = month - 1;
                    if(month == 2){
                        if (isLeapYear(month)){
                            day = 29;
                        }
                        else {
                            day = 28;
                        }
                    }else {
                        if (isBigMonth(month)) {
                            day = 31;
                        } else {
                            day = 30;
                        }
                    }
                }
            }
            else {
                day = day - 1;
            }
        }
        else {
            System.out.println("请输入有效日期！！！");
            System.exit(0);
        }
        String result = year + "-" + month + "-" + day;
        return result;
    }

    public static boolean validateDate(int year, int month, int day) {
        boolean flag = false;
        if(0<month&&month<12){
            if (isBigMonth(month)) {
                if(0<day&&day<31){
                    flag = true;
                }
            }
            else {
                if(month!=2){
                    if(0<day&&day<30){
                        flag = true;
                    }
                    else {
                        if(isLeapYear(year)){
                            if(0<day&&day<29){
                                flag = true;
                            }
                        }
                        else {
                            if (0<day&&day<28){
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public static boolean isLeapYear(int year) {
        boolean flag = false;
        if((year%4==0&&year%100!=0)||year%400==0){
            flag = true;
        }
        return flag;
    }

    public static boolean isBigMonth(int month){
        boolean flag = true;
        if (month%2==0) {
            flag = false;
        }
        return flag;
    }
}