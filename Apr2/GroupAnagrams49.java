package Apr2;

import java.util.*;

public class GroupAnagrams49
{
    public GroupAnagrams49()
    {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));
    }

    /**
     * Time complexity: O(m + nlgn), m is the length of strs array. n is longest word length.
     * Arrays.sort used Quick Sort, average case nlgn, worse case n^2.
     *
     * Space complexity: O(m), Map contains all elements from strs array.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs)
    {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs)
        {
            char[] temp = str.toCharArray();

            Arrays.sort(temp);

            String key = new String(temp);

            if (!map.containsKey(key))
            {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
