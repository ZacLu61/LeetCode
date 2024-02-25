import java.util.*;

class MaximumPathQualityOfAGraph2065 {

    private int maxScore;

    public MaximumPathQualityOfAGraph2065() {
        maxScore = 0;
    }
    
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, Data> dataMap = buildDataMap(values, edges);
        // Can visited multiple times
        int[] visited = new int[values.length];
        dfs(dataMap, visited, 0, 0, maxTime, 0);
        return maxScore;
    }

    private void dfs(
        Map<Integer, Data> dataMap, 
        int[] visited, 
        int nodeIndex, 
        int currentTime,
        int maxTime,
        int currentScore
    ) {
        // Overtime
        if (currentTime > maxTime) {
            return;
        }
        if (visited[nodeIndex] == 0) {
            currentScore += dataMap.get(nodeIndex).value;
        }
        // Back to origin (0)
        if (nodeIndex == 0) {
            maxScore = Math.max(maxScore, currentScore);
        }
        visited[nodeIndex]++;
        for (Map.Entry<Integer, Integer> entry : dataMap.get(nodeIndex).destinationMap.entrySet()) {
            int to = entry.getKey();
            int time = entry.getValue();
            dfs(dataMap, visited, to, currentTime + time, maxTime, currentScore);
        }
        visited[nodeIndex]--;
    }

    private Map<Integer, Data> buildDataMap(int[] values, int[][] edges) {
        Map<Integer, Data> dataMap = new HashMap<>();
        int len = values.length;
        for (int i=0; i<len; ++i) {
            dataMap.putIfAbsent(i, new Data(values[i]));
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int time = edge[2];
            // one way
            Data data = dataMap.get(from);
            data.destinationMap.putIfAbsent(to, time);
            // the other way
            data = dataMap.get(to);
            data.destinationMap.putIfAbsent(from, time);
        }
        return dataMap;
    }

    public static void main(String[] args) {
        MaximumPathQualityOfAGraph2065 solution = new MaximumPathQualityOfAGraph2065();
        
        // Test 1
        int[] values = {0,32,10,43};
        int[][] edges = {{0,1,10},{1,2,15},{0,3,10}};
        int maxTime = 49;

        // // Test 2
        // int[] values = {5, 10, 15, 20};
        // int[][] edges = {{0,1,10},{1,2,10},{0,3,10}};
        // int maxTime = 30;

        // // Test 3
        // int[] values = {1, 2, 3, 4};
        // int[][] edges = {{0,1,10},{1,2,11},{2,3,12}, {1, 3, 13}};
        // int maxTime = 30;

        System.out.println(solution.maximalPathQuality(values, edges, maxTime));
    }
}

class Data {
    int value;
    Map<Integer, Integer> destinationMap;

    Data(int value) {
        this.value = value;
        destinationMap = new HashMap<>();
    }

    @Override 
    public String toString() {
        return "value:" + value + ", destinationMap:" + destinationMap;
    }
}