package Apr26;

public class FindtheDifference398
{
    public FindtheDifference398()
    {
        String s = "abcd";

        String t = "abcde";

        System.out.println(findTheDifference(s, t));
    }

    private char findTheDifference(String s, String t)
    {
        if (t.length() == 1) return t.charAt(0);

        int sum1 = 0, sum2 = 0;

        for (int i=0; i<s.length(); i++)
        {   // Cast char to int
            sum1 += (int) s.charAt(i);

            sum2 += (int) t.charAt(i);
        }
        sum2 += (int) t.charAt(t.length() -1);
        // Find out the difference
        sum2 -= sum1;
        // Cast back to char
        return (char) sum2;
    }
}
