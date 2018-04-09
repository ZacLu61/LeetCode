package Apr8;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII212
{
    public WordSearchII212()
    {
        char[][] board = {{'o','a','a','n'},
                          {'e','t','a','e'},
                          {'i','h','k','r'},
                          {'i','f','l','v'}};

        String[] words = {"oath","pea","eat","rain"};

        System.out.println(findWords(board, words));
    }

    private List<String> findWords(char[][] board, String[] words)
    {
        List<String> result = new ArrayList<>();

        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) return result;

        TrieNode root = buildTrie(words);

        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[0].length; j++)
            {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result)
    {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;

        char ch = board[i][j];

        if (ch == '#' || root.next[ch - 'a'] == null) return;

        root = root.next[ch - 'a'];

        if (root.word != null)
        {
            result.add(root.word);

            root.word = null;
        }
        board[i][j] = '#';

        dfs(board, i+1, j, root, result);

        dfs(board, i-1, j, root, result);

        dfs(board, i, j+1, root, result);

        dfs(board, i, j-1, root, result);

        board[i][j] = ch;
    }

    private TrieNode buildTrie(String[] words)
    {
        TrieNode root = new TrieNode();

        for (String word: words)
        {
            TrieNode cur = root;

            for (int i=0; i<word.length(); i++)
            {
                int index = word.charAt(i) - 'a';

                if (cur.next[index] == null)
                {
                    cur.next[index] = new TrieNode();
                }
                cur = cur.next[index];
            }
            cur.word = word;
        }
        return root;
    }

    private class TrieNode
    {
        TrieNode[] next;

        String word;

        TrieNode()
        {
            next = new TrieNode[26];

            word = null;
        }
    }
}
