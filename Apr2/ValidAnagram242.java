package Apr2;

import java.util.Arrays;

public class ValidAnagram242
{
    public ValidAnagram242()
    {
        String s = "anagram", t = "nagaram";

//        String s = "rat", t = "car";

        System.out.println(isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t)
    {
//        return method1(s, t);

        return method2(s, t);
    }

    /**
     * Time Complexity: O(nlgn), n is the length of s or t since their lengths are the same.
     * Arrays.sort used Quick Sort for primitive type, average case is (nlgn), worse case (n^2)
     *
     * @param s
     * @param t
     * @return
     */
    private boolean method1(String s, String t)
    {
        if (s == null || t == null || s.length() != t.length()) return false;

        char[] arr1 = s.toCharArray();

        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);

        Arrays.sort(arr2);

        for (int i=0; i<arr1.length; i++)
        {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    /**
     * Time Complexity:  O(n + 256), which still O(n)
     * Space complexity: O(256) -> O(1), 256 for AscII code to store the frequency shown in s and t
     *
     * @param s
     * @param t
     * @return
     */
    private boolean method2(String s, String t)
    {
        if (s == null || t == null || s.length() != t.length()) return false;

        int[] freq = new int[256];

        for (int i=0; i<s.length(); i++)
        {
            freq[s.charAt(i)]++;

            freq[t.charAt(i)]--;
        }
        for (int i=0; i<freq.length; i++)
        {
            if (freq[i] != 0) return false;
        }
        return true;
    }
}
