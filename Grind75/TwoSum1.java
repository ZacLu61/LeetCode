package Grind75;

import java.util.HashMap;
import java.util.Map;

class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        for (int i=0; i<nums.length; ++i) {
            // Found the remainder
            if (numToIndexMap.containsKey(nums[i])) {
                return new int[]{numToIndexMap.get(nums[i]), i};
            }
            numToIndexMap.put(target - nums[i], i);
        }
        return null;
    }
    public static void main(String... theArgs) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] result = new TwoSum1().twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }
}