package Apr8;

public class WordSearch79
{
    public WordSearch79()
    {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};

//        String word = "ABCCED";

        String word = "SEE";

//        String word = "ABCB";

        System.out.println(exist(board, word));
    }

    /**
     * Time complexity: O(MNX^4), M is the length of board, N is the length of board[0]
     * X^4 is from the exist helper method
     *
     * @param board
     * @param word
     * @return
     */
    private boolean exist(char[][] board, String word)
    {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) return false;

        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[0].length; j++)
            {
                if (exist(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * Time complexity: O(X^4), X is the word length;
     *
     * @param board
     * @param i
     * @param j
     * @param word
     * @param index
     * @return
     */
    private boolean exist(char[][] board, int i, int j, String word, int index)
    {
        if (index == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;

        if (board[i][j] != word.charAt(index)) return false;

        board[i][j] ^= 256;

        boolean result = exist(board, i + 1, j, word, index + 1)
                || exist(board, i - 1, j, word, index + 1)
                || exist(board, i, j + 1, word, index + 1)
                || exist(board, i, j - 1, word, index + 1);

        board[i][j] ^= 256;

        return result;
    }
}
