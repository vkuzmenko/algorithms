public class FindLongestSubstring {

    private final static int NO_OF_CHARS = 256;

    public static int longestSubstringLength(String str) {
        if (str.isEmpty()) return 0;
        if (str.length() == 1) return 1;
        return longestSubstringLengthN(str);
    }

    private static int longestSubstringLengthN(String str)
    {
        int visited[] = new int[NO_OF_CHARS];
        int cur_len = 1;
        int max_len = 1;
        int prev_index;

        for (int i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }

        visited[str.charAt(0)] = 0;
        for (int i = 1; i < str.length(); i++) {
            prev_index = visited[str.charAt(i)];
            if (prev_index == -1 || i - cur_len > prev_index)
                cur_len++;
            else {
                if (cur_len > max_len)
                    max_len = cur_len;

                cur_len = i - prev_index;
            }
            visited[str.charAt(i)] = i;
        }

        if (cur_len > max_len)
            max_len = cur_len;

        return max_len;
    }

    public static void main(String[] args) {
//        System.out.println(FindLongestSubstring.longestSubstringLength(""));
//        System.out.println(FindLongestSubstring.longestSubstringLength(" "));
//        System.out.println(FindLongestSubstring.longestSubstringLength("a"));
//        System.out.println(FindLongestSubstring.longestSubstringLength("ab"));
//        System.out.println(FindLongestSubstring.longestSubstringLength("aba"));
        System.out.println(FindLongestSubstring.longestSubstringLength("abcda"));
    }
}
