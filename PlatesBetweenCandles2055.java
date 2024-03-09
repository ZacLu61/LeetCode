import java.util.Arrays;

class PlatesBetweenCandles2055 {
    
    public int[] platesBetweenCandles(String s, int[][] queries) {
        if (s == null || s.length() == 0 || queries == null || queries.length == 0) {
            return null;
        }

        int len = s.length();
        int[] psum = new int[len+1];
        int[] prev = new int[len+1];
        int[] next = new int[len+1];
        
        Arrays.fill(next, Integer.MAX_VALUE);
        int[] result = new int[queries.length];
        
        for (int i=1; i<=len; ++i) {
            psum[i] = psum[i-1] + (s.charAt(i-1) == '|' ? 1 : 0);
            prev[i] = s.charAt(i-1) == '|' ? i-1 : prev[i-1];
        }

        for (int i=len-1; i>=0; i--) {
            next[i] = s.charAt(i) == '|' ? i : next[i+1];
        }

        int index = 0;

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int left = next[start];
            int right = prev[end+1];

            result[index] = left < right 
                ? right - left - (psum[right] - psum[left])
                : 0;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test 1
        String s = "**|**|***|";
        int[][] queries = {{1,2},{3,4}};
        // expect: {2,3}

        System.out.println(new PlatesBetweenCandles2055().platesBetweenCandles(s, queries));
    }
}