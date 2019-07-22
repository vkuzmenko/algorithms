import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    static String removeDuplicates(String S) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (st.isEmpty()) {
                st.push(ch);
            } else {
                if (st.peek() == ch) {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (Character c : st) {
            res.append(c);
        }
        return res.toString();
    }

    static String removeDuplicates2(String S) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < S.length(); ++i) {
            char cur = S.charAt(i);

            if (res.length() == 0) {
                res.append(cur);
            } else {
                final int lastElem = res.length() - 1;
                if (res.charAt(lastElem) == cur) {
                    res.deleteCharAt(lastElem);
                } else {
                    res.append(cur);
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(RemoveAllAdjacentDuplicatesInString.removeDuplicates("aababaab"));
        System.out.println(RemoveAllAdjacentDuplicatesInString.removeDuplicates2("aababaab"));
    }
}
