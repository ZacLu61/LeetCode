import java.util.ArrayList;
import java.util.List;

class FindKClosestElements658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        // sliding window between 0...len-k
        int left = 0, right = arr.length -k, mid = 0;
        
        while (left < right) {
            mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for (int i=left; i<left+k; ++i) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        // // Test 1
        // int[] arr = {1,2,3,4,5};
        // int k = 4;
        // int x = 3;
        // // expect: [1,2,3,4]

        // Test 2
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = -1;
        // expect: [1,2,3,4]

        System.out.println(new FindKClosestElements658().findClosestElements(arr, k, x));
    }
}