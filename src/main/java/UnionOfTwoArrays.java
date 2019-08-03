import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfTwoArrays {

    /**
     *  @param a - a list of non null integers, in ascending order
     *  @param b - a list of non null integers, in ascending order
     *  @return the integers that are contained in either a or b, in ascending order
     */

    static List<Integer> union(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                res.add(a.get(i));
                i++;
            } else {
                res.add(b.get(j));
                j++;
            }
        }

        if (i < a.size()) {
            res.addAll(a.subList(i, a.size()));
        } else {
            res.addAll(b.subList(j, b.size()));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(union(Arrays.asList(1,3,4), Arrays.asList(2,5,6)));
    }
}
