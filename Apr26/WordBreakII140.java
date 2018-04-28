package Apr26;

import Apr8.WordSearchII212;

import java.util.*;

public class WordBreakII140
{
    public WordBreakII140()
    {
        String s = "catsanddog";

        String[] arr = {"cat", "cats", "and", "sand", "dog"};

//        String s = "pineapplepenapple";
//
//        String[] arr = {"apple", "pen", "applepen", "pine", "pineapple"};

        List<String> wordDict = Arrays.asList(arr);

        System.out.println(wordBreak(s, wordDict));
    }

    private List<String> wordBreak(String s, List<String> wordDict)
    {
        Set<String> set = new HashSet<>();

        Map<Integer, List<String>> map = new HashMap<>();

        int max = 0;

        for (String str: wordDict)
        {
            set.add(str);

            max = Math.max(max, str.length());
        }
        return helper(s, set, 0, max, map);
    }

    private List<String> helper(String s, Set<String> set, int start, int max, Map<Integer, List<String>> map)
    {
        if (map.get(start) != null)
            return map.get(start);

        List<String> result = new LinkedList<>();

        if (start == s.length())
        {
            result.add("");

            return result;
        }
        for (int len=1; len<=Math.min(max, s.length()-start); len++)
        {
            String cur = s.substring(start, start+len);

            if (set.contains(cur))
            {
                List<String> next = helper(s, set, start+len, max, map);

                for (String str: next)
                {
                    result.add((cur + " " + str).trim());
                }
            }
        }
        map.put(start, result);

        return result;
    }
}
