import java.util.Stack;

class NumberOfValidSubarrays1063 {
    
    public int validSubarrays(int[] nums) {
        int result = 0, len = nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<len; ++i) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                result += i - stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result += len - stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        // Test 1
        int[] nums = {1,4,2,5,3};
        // expect: 11

        // // Test 2
        // int[] nums = {3,2,1};
        // // expect: 3
        
        System.out.println(new NumberOfValidSubarrays1063().validSubarrays(nums));
    }
}