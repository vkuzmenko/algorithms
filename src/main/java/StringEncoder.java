import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class StringEncoder {

    private final Integer hMax = 10;
    private final Integer vMax = 3;

    private Map<Character, Integer> charToNumber;
    private Map<Integer, Character> numberToChar;

    StringEncoder() {
        initMaps();
    }

    String encode(String input, int h, int v) {

        List<Character> encodedCharList = input.chars()
                .mapToObj(x -> (char) x)
                .map(x -> encodeChar(x, h, v))
                .collect(toList());

        StringBuilder sb = new StringBuilder();
        for(Character ch : encodedCharList) {
            sb.append(ch);
        }

        return sb.toString();
    }

    /** One of the possible mapping
     * 0 1 2 3 4 5 6 7 8 9
     * Q W E . T Y I U O P 0
     * Z S D F G H J K L M 1
     * A X & C V B N ? ; R 2
     */
    private void initMaps() {
        this.charToNumber = new HashMap<>();
        this.numberToChar = new HashMap<>();
    }

    private Character encodeChar(Character ch, int h, int v) {
        Integer pos = this.charToNumber.get(ch);
        int hPos = (pos % 10 + h % hMax) % hMax;
        int vPos = (pos / 10 + v % vMax) % vMax;
        pos = hPos + 10 * vPos;
        return this.numberToChar.get(pos);
    }

    public static void main(String[] args) {
        StringEncoder solution = new StringEncoder();

        System.out.println(solution.encode("abcd", 0, 0));
        System.out.println(solution.encode("abcd", 1, 1));
        System.out.println(solution.encode("abcd", -1, -1));
        System.out.println(solution.encode("abcd", 11, 4));
        System.out.println(solution.encode("abcd", -11, -4));
    }
}
