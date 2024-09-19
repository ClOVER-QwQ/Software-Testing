import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        PreDate preDate = new PreDate();
        int year = 2024, month = 9, day = 12, isEnd = 0;
        Scanner in = new Scanner(System.in);
        while (isEnd != 1) {
            System.out.println("请依次输入年月份");
            try {
                year = in.nextInt();
                month = in.nextInt();
                day = in.nextInt();
            } catch (Exception e) {
                System.out.println("请输入有效数字");
                System.exit(0);
            }
            System.out.println(preDate.preDate(year, month, day));
            System.out.println("结束请输入1!");
            isEnd = in.nextInt();
        }
    }
}
