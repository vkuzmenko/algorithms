import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KClosestPoints {

    private static double distanceToOrigin(int[] x) {
        return Math.sqrt(Math.pow(x[0], 2) + Math.pow(x[1], 2));
    }

    private int[][] kClosest(int[][] points, int K) {

        List<int[]> res = Arrays.stream(points)
                .sorted(Comparator.comparingDouble(KClosestPoints::distanceToOrigin))
                .distinct()
                .limit(K)
                .collect(Collectors.toList());

        return res.toArray(new int[0][]);
    }

    public static void main(String[] arg) {
        KClosestPoints test = new KClosestPoints();
        int[][] res = test.kClosest(new int[][]{new int[]{3,3},new int[]{-5,1},new int[]{-2,4}}, 2);
        System.out.println(res);
    }
}
