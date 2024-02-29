import java.util.HashMap;
import java.util.Map;

class DegreeOfAnArray697 {
    
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        int result = 0;
        Map<Integer, Node> degreeMap = new HashMap<>();

        for (int i=0; i<nums.length; ++i) {
            int num = nums[i];
            degreeMap.putIfAbsent(num, new Node(i));
            Node node = degreeMap.get(num);
            node.freq++;

            if (node.freq > max) {
                max = node.freq;
                result = i - node.start + 1;
            } else if (node.freq == max) {
                result = Math.min(result, i - node.start + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // // Test 1
        // int[] nums = {1,2,2,3,1};
        // // expect: 2

        // Test 2
        int[] nums = {1,2,2,3,1,4,2};
        // expect: 6

        System.out.println(new DegreeOfAnArray697().findShortestSubArray(nums));
    }
}

class Node {
    int start;
    int freq;

    Node(int start) {
        this.start = start;
        freq = 0;
    }
}