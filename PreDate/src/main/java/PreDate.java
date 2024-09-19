public class PreDate {
    public String preDate(int year, int month, int day) {
        String result;
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
                        if (isLeapYear(year)){
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
            result = year + "-" + month + "-" + day;
        }
        else {
            result = "请输入有效日期 ! ! !";
        }
        return result;
    }

    public static boolean validateDate(int year, int month, int day) {
        boolean flag = false;
        if(year != 0) {
            if (0 < month && month <= 12) {
                if (isBigMonth(month)) {
                    if (0 < day && day <= 31) {
                        flag = true;
                    }
                } else {
                    if (month != 2) {
                        if (0 < day && day <= 30) {
                            flag = true;
                        } else {
                            if (isLeapYear(year)) {
                                if (0 < day && day <= 29) {
                                    flag = true;
                                }
                            } else {
                                if (0 < day && day <= 28) {
                                    flag = true;
                                }
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
        if (month==2||month==4||month==6||month==9||month==11) {
            flag = false;
        }
        return flag;
    }
}