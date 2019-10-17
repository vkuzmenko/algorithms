import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringInArrayOfStrings {

    private List<String> filterBySubstring(List<String> input, String key) {
        return input.stream().filter(x -> x.contains(key)).collect(toList());
    }

    public static void main(String[] args) {

        List<String> input = Arrays.asList(
                "minecraftgame", "intelligent", "innercrafttalent",
                "knife", "scissor", "stonecrafter"
        );
        String key = "craft";

        StringInArrayOfStrings s = new StringInArrayOfStrings();
        List<String> res = s.filterBySubstring(input, key);
        for(String str : res) {
            System.out.println(str);
        }
    }
}
