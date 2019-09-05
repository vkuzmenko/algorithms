import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
        Set<Character> str = new HashSet<>();

        for (Character ch : s.toCharArray()) {
            if (str.contains(ch)) {
                return s.charAt(ch);
            } else {
                str.add(ch);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstUniqueCharacter.firstUniqChar("leetcode"));
        System.out.println(FirstUniqueCharacter.firstUniqChar("loveleetcode"));
    }
}
