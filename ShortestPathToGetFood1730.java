import java.util.LinkedList;
import java.util.Queue;

class ShortestPathToGetFood1730 {

    private final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int getFood(char[][] grid) {
        int[] startPoint = findStartPoint(grid);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(startPoint);
        
        int count = 0, row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        visited[startPoint[0]][startPoint[1]] = true;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();

            for (int i=0; i<size; ++i) {
                int[] current = queue.remove();
                int x  = current[0];
                int y  = current[1];

                for (int[] dir : DIRECTIONS) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                        continue;
                    }
                    if (visited[nextX][nextY]) {
                        continue;
                    }
                    visited[nextX][nextY] =  true;
                    
                    // Found food
                    if (grid[nextX][nextY] == '#') {
                        return count;
                    }
                    if (grid[nextX][nextY] == 'O') {
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return -1;
    }

    private int[] findStartPoint(char[][] grid) {
        for (int i=0; i<grid.length; ++i) {
            for (int j=0; j<grid[0].length; ++j) {
                if (grid[i][j] == '*') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        // Test 1
        char[][] gird = {
            {'X','X','X','X','X','X'},
            {'X','*','O','O','O','X'},
            {'X','O','O','#','O','X'},
            {'X','X','X','X','X','X'}
        };

        ShortestPathToGetFood1730 solution = new ShortestPathToGetFood1730();
        System.out.println(solution.getFood(gird));
    }
}