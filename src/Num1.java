import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num1 {
    static public int getGreatestSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int[] temp = new int[array.length];
        temp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (temp[i - 1] > 0) {
                temp[i] = temp[i - 1] + array[i];

            }else {
                temp[i] = array[i];
            }
            if (temp[i] > result) {
                result = temp[i];
            }

        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] parts = str.replace("[", "").replace("]", "").replace(" ", "").split(",");
            int[] array = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i]);
            }
            System.out.println(getGreatestSum(array));
        }
    }
}
