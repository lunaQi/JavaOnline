import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num3 {
    static public int getAloneNum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum ^ array[i];
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] s = str.split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        System.out.println(getAloneNum(array));
    }
}
