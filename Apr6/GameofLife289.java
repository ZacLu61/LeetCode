package Apr6;

import sun.jvm.hotspot.jdi.ArrayReferenceImpl;

import java.util.ArrayList;
import java.util.List;

public class GameofLife289
{
    public GameofLife289()
    {
        int[][] board = {{1, 0, 1},
                         {0, 1, 1},
                         {1, 1, 1}};

        gameOfLife(board);

        printBoard(board);
    }

    /**
     * Time complexity: O(MN), M is the length of board. N is the length of board[0].length.
     * Space complexity: O(1), m and n
     *
     *
     * @param board
     */
    private void gameOfLife(int[][] board)
    {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int m = board.length, n = board[0].length;

        for (int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
            {
                int lives = findNeighborLives(board, i, j);

                if (board[i][j] == 0 && lives == 3)
                {
                    board[i][j] = 2;  // 10
                }
                if (board[i][j] == 1 && (lives == 2 || lives == 3))
                {
                    board[i][j] = 3;  // 11
                }
            }
        }
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
            {
                board[i][j] >>= 1;
            }
        }
    }

    /**
     * Time complexity O(1), do the 3 * 3 iteration (average case). Still O(1)
     * Space complexity O(1)
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private int findNeighborLives(int[][] board, int row, int col)
    {
        int lives = 0;

        for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, board.length - 1); i++) {
            for (int j = Math.max(col - 1, 0); j <= Math.min(col + 1, board[0].length - 1); j++) {
                lives += board[i][j] & 1;
            }
        }
        lives -= board[row][col] & 1;

        return lives;
    }

    private void printBoard(int[][] board)
    {
        List<List<Integer>> output = new ArrayList<>();

        for (int[] arr: board)
        {
            List<Integer> list = new ArrayList<>();

            for (int num: arr)
            {
                list.add(num);
            }
            output.add(new ArrayList<>(list));
        }
        for (List<Integer> list: output)
        {
            System.out.println(list);
        }
    }
}
