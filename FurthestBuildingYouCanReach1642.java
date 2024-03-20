import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class FurthestBuildingYouCanReach1642 {
    
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // return furthestBuildingByHeap(heights, bricks, ladders);   
        return furthestBuildingByBinarySearch(heights, bricks, ladders);   
    }

    private int furthestBuildingByBinarySearch(int[] heights, int bricks, int ladders) {
        int left = 0 , right = heights.length -1, mid = 0;

        while (left < right) {
            // This ensure that on even-lengthed search spaces, the upper middle is chosen 
            // and on odd-lengthed search spaces, the actual middle is chosen.
            mid = (left + right + 1) / 2;
            if (isReachable(mid, heights, bricks, ladders)) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return right;
    }

    private boolean isReachable(int index, int[] heights, int bricks, int ladders) {
        // Find out how many climb from 0 to index
        List<Integer> climbs = new ArrayList<>();
        for (int i=0; i<index; ++i) {
            int climb = heights[i+1] - heights[i];
            if (climb <= 0) {
                continue;
            }
            climbs.add(climb);
        }
        Collections.sort(climbs);

        // Determine climbs can be covered by bricks or ladders
        for (int climb : climbs) {
            if (bricks >= climb) {
                bricks -= climb;
            } else if (ladders >= 1) {
                ladders--;
            } else {
                // no ladders nor bricks
                return false;
            }
        }
        return true;
    }

    private int furthestBuildingByHeap(int[] heights, int bricks, int ladders) {
        // Descending order
        Queue<Integer> bricksPQ = new PriorityQueue<>((o1, o2) -> {
            return o2.compareTo(o1);
        });
        int len = heights.length;
        // start with 0, it's asking how far can we reach
        for (int i=0; i<len-1; ++i) {
            int climb = heights[i+1] - heights[i];
            if (climb <= 0) {
                continue;
            }
            // Use bricks first
            bricksPQ.offer(climb);
            bricks -= climb;
            // Run out of bricks and ladders
            if (bricks < 0 && ladders == 0) {
                return i;
            }
            // Run out of bricks, replace ladder with biggest bricks count
            if (bricks < 0) {
                bricks += bricksPQ.poll();
                ladders--;
            }
        }
        return len -1;
    }

    public static void main(String[] args) {
        // // Test 1 
        // int[] heights = {4,2,7,6,9,14,12};
        // int bricks = 5;
        // int ladders = 1;
        // // expect: 4

        // Test 2
        int[] heights = {4,12,2,7,3,18,20,3,19};
        int bricks = 10;
        int ladders = 2;
        // expect: 7

        System.out.println(new FurthestBuildingYouCanReach1642().furthestBuilding(heights, bricks, ladders));
    }
}