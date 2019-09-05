import java.util.ArrayList;
import java.util.List;

public class FindLongestSubstring {

    public static int longestSubstringLength(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int maxLength = 0;

        for (int i = 0; i < s.length() - 1; ++i) {
            List<Character> subString = new ArrayList<>();
            subString.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); ++j) {
                if (subString.contains(s.charAt(j))) {
                    int repeatedCharIndex = subString.indexOf(s.charAt(j));
                    i += (repeatedCharIndex + 1);
                    subString.clear();
                    break;
                } else {
                    subString.add(s.charAt(j));
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(FindLongestSubstring.longestSubstringLength(" "));
        System.out.println(FindLongestSubstring.longestSubstringLength("a"));
        System.out.println(FindLongestSubstring.longestSubstringLength("ab"));
        System.out.println(FindLongestSubstring.longestSubstringLength("aba"));
        System.out.println(FindLongestSubstring.longestSubstringLength("abcda"));
    }
}
