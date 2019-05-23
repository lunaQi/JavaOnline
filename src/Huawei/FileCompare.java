package Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 文件读入
 * edit-distance
 */
public class FileCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] old = new String[n];
        String[] renew = new String[n];
        for (int i = 0; i < n; i++) {
            old[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            renew[i] = sc.next();       //接收字符串
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += editDistance(old[i], renew[i]);
        }
        System.out.println(sum);
    }

    private static int editDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }
}
