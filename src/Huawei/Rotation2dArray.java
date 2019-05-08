package Huawei;

import java.util.Scanner;

public class Rotation2dArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            arrayRotate(array);
        }
        printArray(array);
    }

    /**
     * 顺时针：次对角线，逆时针：主对角线
     * @param array
     */
    private static void arrayRotate(int[][] array) {
        int n = array.length;
        /**
         * 不是简单的互换，而是只换对角线上半部分（中心点以前）
         */
        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j <= n / 2; j++) {
                if (i == n - 1 - j) {
                    continue;
                }
                int temp = array[i][j];
                array[i][j] = array[n - 1 - j][n - 1 - i];
                //System.out.println(array[i][j]);
                array[n - 1 - j][n - 1 - i] = temp;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            int[] temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }

    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
