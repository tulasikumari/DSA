package Question3;

import java.util.Scanner;
//you are provided certain string and pattern, return true if pattern entirely matches the string otherwise return false.
//        Note: if pattern contains char @ it matches entire sequence of characters and # matches any single character within
//        string.
//        Input: String a=“tt”, pattern =”@”
//        Output: true
//        Input: String a=“ta”, pattern =”t”
//        Output: false
//        Input: String a=“ta”, pattern =”t#”
//        Output: true

public class Q3b {
    public static boolean match(String str, String pattern) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        if (pattern.charAt(0) == '@') {
            return match(str.substring(1), pattern.substring(1));
        }
        if (str.length() == 0) {
            return false;
        }
        if (pattern.charAt(0) == '#') {
            return match(str.substring(1), pattern.substring(1));
        }
        if (str.charAt(0) == pattern.charAt(0)) {
            return match(str.substring(1), pattern.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "ta";
        String pattern = "t#";
        boolean result = match(str, pattern);
        System.out.println(result); // output: true

    }
}
