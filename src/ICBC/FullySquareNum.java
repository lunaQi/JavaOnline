package ICBC;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullySquareNum {
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
            helper(a, target - a[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //while ((str = br.readLine()) != null) {
        int target = Integer.parseInt(br.readLine());
        int temp = 1;
        while (temp * temp < target) {
            temp++;
        }
        int[] candidates = new int[temp - 1];
        for (int i = 0; i < temp - 1; i++) {
            candidates[i] = (i + 1) * (i + 1);
            //System.out.println(candidates[i]);
        }

        List<List<Integer>> list = combinSum(candidates, target);
        //System.out.println(list);
        if (list.size() == 0) {
            System.out.println("NA");
            return;
        }
        int result = list.get(0).size();
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (result > list.get(i).size()) {
                result = list.get(i).size();
                index = i;
            }
        }
        System.out.println(list.get(index));
        //}
    }
}
