import com.sun.source.tree.IfTree;

import java.util.Scanner;

public class PreData {
    public static void main(String[] args) {
        int year=2024,month=9,day=12,isEnd = 0;
        Scanner in = new Scanner(System.in);
        while (isEnd != 1){
            System.out.println("请依次输入年月份");
            year = in.nextInt();
            month = in.nextInt();
            day = in.nextInt();
            preData(year, month, day);
            System.out.println("结束请输入1!");
            isEnd = in.nextInt();
        }
    }

    private static void preData(int year, int month, int day) {
        if (validateDate(year, month, day)) {
        }
    }

    private static boolean validateDate(int year, int month, int day) {
        if(0<month&&month<12){
            if (isBigMonth(month)) {
                if(0<day&&day<31){

                }
            }
            else {
                if(month!=2){
                    if(0<day&&day<30){

                    }
                    else {
                        if(isLeapYear(year)){
                            if(0<day&&day<29){

                            }
                        }
                        else {
                            if (0<day&&day<28){

                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    private static boolean isLeapYear(int year) {
        if((year%4==0&&year%100!=0)&&year%400==0){
            return true;
        }
        return false;
    }

    private static boolean isBigMonth(int month){
        if (month%2==0) {
            return false;
        }
        return true;
    }
}