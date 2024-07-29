package org.example;
import java.util.Scanner;


// 注意类名必须为 Main, 不要有任何 package xxx 信息

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别

        //

        int n = in.nextInt(), k = in.nextInt();

        double dp = find(1, n);

        for (int i = 2; i <= k; i++) {

            dp += find(i, n) + 1;

        }

        System.out.print(dp);

    }

    public static double find(int i, int n) { //n个杯子i杯水，喝到第一杯的期望轮次

        if (i == n) {

            return 1;

        }

        int round = 1;

        double select = (double)i / n;

        double noselect = (double)(n - i) / n;

        double pre = 1;

        double res = 0;

        while (round * select * pre >= 0.000_000_1) { // 界限越小精度越高

            res += round * pre * select;

            pre *= noselect;

            round++;

        }

        return res;

    }

}
