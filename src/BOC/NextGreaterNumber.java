package BOC;

import java.util.Stack;

/**
 * 栈的增删
 */

public class NextGreaterNumber {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 1, 4, 6, 8, 5, 2};
        nextGreaterNumber(numbers, new Stack<>());
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }

    }

    private static void nextGreaterNumber(int[] numbers, Stack<Integer> stack) {
        int biggest = numbers[0];
        stack.push(0);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < biggest) {
                stack.push(i);
                continue;
            }else {
                while (!stack.isEmpty()) {
                    int index = stack.pop();
                    numbers[index] = numbers[i];
                }
                biggest = numbers[i];
                stack.push(i);
            }

        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            numbers[index] = -1;
        }
    }
}
