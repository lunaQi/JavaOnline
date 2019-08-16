package CCB;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestPadlidrome {
    static public String longestPa(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, len = 0, longest = 0;
        for (int i = 0; i < s.length(); i++) {
            len = findLongestPa(s, i, i);
            if (len > longest) {
                longest = len;
                start = i - (len - 1) / 2;
            }
            len = findLongestPa(s, i, i + 1);
            if (len > longest) {
                longest = len;
                start = i - (len - 2) /2;
            }
        }
        return s.substring(start, start + longest);
    }
    static int findLongestPa(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right <= s.length() - 1) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            len += left == right ? 1 : 2;
            left--;
            right++;
        }
        return len;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String result = longestPa(str);
            System.out.println(result.length());
        }
    }
}
