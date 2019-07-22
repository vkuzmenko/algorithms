import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSums {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int[] res = {};
        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if (lookup.keySet().contains(diff)) {
                return new int[]{lookup.get(diff), i};
            }
            lookup.put(nums[i], i);
        }
        return res;
    }

    public static void main(String args[]) {
        int[] res = TwoSums.twoSum(new int[]{1,2,3,4,5,7}, 6);

        System.out.println(Arrays.toString(res));
    }
}