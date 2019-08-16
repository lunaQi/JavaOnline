package test;

public class ReExpression {
        public static boolean match(char[] str, char[] pattern)
        {
            if (str == null || pattern == null) {
                return false;
            }

            return matchCore(str,  pattern, 0,0);
        }
    private static boolean matchCore(char[] str, char[] pattern, int i, int j) {
        if (i == str.length && j == pattern.length) {
            return true;
        }
        if (i < str.length && j == pattern.length) {
            return false;
        }
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            if ((i < str.length && pattern[j] == str[i]) || (pattern[j] == '.' && i < str.length)) {
                return matchCore(str, pattern, i, j + 2) ||
                        matchCore(str, pattern, i + 1, j + 2) ||
                        matchCore(str, pattern, i + 1, j);
            }else {
                return matchCore(str, pattern, i, j + 2);
            }
        }
        if ((i < str.length && pattern[j] == str[i]) || pattern[j] == '.' && i < str.length) {
            return matchCore(str, pattern, i + 1, j + 1);
        }
        return false;
    }

        public static void main(String[] args) {
            //char[] str = {'b', 'c', 'b', 'b', 'a', 'b', 'a', 'b'};
            //char[] pattern = {'.', '*', 'a', '*', 'a'};
            //System.out.println(match(str, pattern));
            double a = 1.01;
            double b = 1.01;
            System.out.println(a == b);
        }
}
