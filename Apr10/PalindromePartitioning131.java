package Apr10;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131
{
    public PalindromePartitioning131()
    {
        String s = "aab";

        System.out.println(partition(s));
    }

    private List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<>();
        // This array stores if substring index of s from i to j is palindrome.
        boolean[][] palindromeFromTo = new boolean[s.length()][s.length()];

        for (int i=0; i<s.length(); i++)
        {
            for (int j=0; j<=i; j++)
            {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || palindromeFromTo[j + 1][i - 1]))
                {
                    palindromeFromTo[j][i] = true;
                }
            }
        }
        helper(s, 0, palindromeFromTo, new ArrayList<>(), result);

        return result;
    }

    private void helper(String s, int index, boolean[][] palindromeFromTo, List<String> list, List<List<String>> result)
    {
        if (index == s.length())
        {
            result.add(new ArrayList<>(list));

            return;
        }
        for (int i=index; i<s.length(); i++)
        {
            // If the substring of s index from index to i is palindrome
            if (palindromeFromTo[index][i])
            {
                list.add(s.substring(index, i + 1));
                // Next iteration from i + 1
                helper(s, i + 1, palindromeFromTo, list, result);

                list.remove(list.size() -1);
            }
        }
    }
}
