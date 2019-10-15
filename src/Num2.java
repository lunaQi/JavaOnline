import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num2 {
    static public boolean isTongou(String a, String b) {
        int[] cnt = new int[1000];
        for (int i = 0; i < a.length(); i++) {
            cnt[(int)a.charAt(i)] += 1;
        }
        for (int i = 0; i < b.length(); i++) {
            cnt[(int)b.charAt(i)] -= 1;
        }
        for (int i = 0; i < 1000; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] parts = str.split(";");
            String a = parts[0];
            String b = parts[1];
            if (isTongou(a, b)) {
                System.out.println("True");
            }else {
                System.out.println("False");
            }
        }
    }
}
