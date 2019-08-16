package test;


import java.util.ArrayList;

public class TopK {
        public static void GetLeastNumbers_Solution(int [] input, int k) {
            if (input == null || input.length == 0 || k > input.length || k <= 0) {
                return;
            }
            quickSort(input, 0, input.length);
            System.out.println(input);
            return;
        }
        private static void quickSort(int[] input, int start, int end) {
            if (start >= end) {
                return;
            }
            int left = start, right = end;
            int pivot = input[(start + end) / 2];
            while (left <= right) {
                while (left <= right && input[left] < pivot) {
                    left++;
                }
                System.out.println(left);
                System.out.println(right);
                while (left <= right && input[right] > pivot) {
                    right--;
                }
                if (left <= right) {
                    int temp = input[left];
                    input[left] = input[right];
                    input[right] = temp;
                    left++;
                    right--;
                }
            }
            quickSort(input, start, right);
            quickSort(input, left, end);
        }
        public static void main(String[] args) {
            int[] input = {4,5,1,6,2,7,3,8};
            int k = 4;
            GetLeastNumbers_Solution(input, k);
        }
}

