package CCB;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    static public List<List<Integer>> combinSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    static private void helper(int[] a, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < a.length; i++) {
            if (i != index && a[i] == a[i -1]) {
                continue;
            }
            if (a[i] > target) {
                break;
            }
            current.add(a[i]);
            helper(a, target - a[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        //while ((str = br.readLine()) != null) {
        String[] s = str.split(",");
        int[] candidates = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            candidates[i] = Integer.parseInt(s[i]);
        }
        int target = Integer.parseInt(br.readLine());
        List<List<Integer>> list = combinSum(candidates, target);
        //System.out.println(list);
        if (list.size() == 0) {
            System.out.println(-1);
            return;
        }
        int result = list.get(0).size();
        for (int i = 0; i < list.size(); i++) {
            if (result > list.get(i).size()) {
                result = list.get(i).size();
            }
        }
        System.out.println(result);
        //}
    }
}

