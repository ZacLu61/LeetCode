import java.util.Arrays;

class HIndex274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        int maxCitation = 0, paperCount = 0;

        for (int i=citations.length-1; i>=0; --i) {
            maxCitation = citations[i];
            paperCount++;
            
            if (maxCitation == paperCount) {
                return maxCitation;
            }
            if (maxCitation >= paperCount) {
                result = paperCount;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // // Test 1
        // int[] citations = {3,0,6,1,5}; // expect 3

        // Test 2
        int[] citations = {1,3,1}; // expect 1

        System.out.println(new HIndex274().hIndex(citations));
    }
}