package Huawei;
/**
 * 数组初始化
 * List添加，查找，删除元素
 * 全排列算法
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiftDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gifts = sc.nextInt();
        int people = sc.nextInt();
        //char[] symbols = {'*', '*', '*', '|', '|'};
        char[] symbols = new char[gifts + people];
        for (int i = 0; i < symbols.length; i++) {
            if (i < gifts) {
                symbols[i] = '*';
            }else {
                symbols[i] = '|';
            }
        }
        List<List<Character>> result = new ArrayList<>();
        dfs(symbols, new boolean[symbols.length], new ArrayList<>(), result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j));
            }
            System.out.println();
        }
    }
    private static void dfs(char[] symbols, boolean[] visited,
                            List<Character> permutation, List<List<Character>> result) {
        if (permutation.size() == symbols.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < symbols.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && symbols[i] == symbols[i - 1] && !visited[i - 1]) {
                continue;
            }
            permutation.add(symbols[i]);
            visited[i] = true;
            dfs(symbols, visited, permutation, result);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }

}
