import java.util.HashMap;
import java.util.Map;

class MinimumNumberOfOperationsToMakeArray2870 {

    public int minOperations(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // <num, count>
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (int freq : countMap.values()) {
            if (freq == 1) {
                return -1;
            }
            
            result += freq / 3;
            
            if (freq % 3 != 0) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // // Test 1
        // int[] nums = {2,3,3,2,2,4,2,3,4}; 
        // // expect 4

        // // Test 2
        // int[] nums = {2,1,2,2,3,3}; 
        // // expect -1

        // Test 3
        int[] nums = {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12}; 
        // expect 7

        // // Test 4
        // int[] nums = {19,19,19,19,19,19,19,19,19,19,19,19,19}; 
        // // expect 5

        System.out.println(new MinimumNumberOfOperationsToMakeArray2870().minOperations(nums));
    }
}