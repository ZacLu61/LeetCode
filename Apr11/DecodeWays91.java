package Apr11;

public class DecodeWays91
{
    public DecodeWays91()
    {
        String s = "12";

        System.out.println(numDecodings(s));
    }

    private int numDecodings(String s)
    {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int len = s.length();

        int[] dp = new int[len + 1];

        dp[0] = 1;

        dp[1] = 1;

        char[] arr = s.toCharArray();

        for (int i=1; i<len; i++)
        {
            char pre = arr[i -1];

            char cur = arr[i];

            int curValue = cur - '0';

            int preValue = 10 * (pre - '0') + curValue;

            if (isValid(curValue))
            {
                dp[i + 1] += dp[i];
            }
            if (isValid(preValue) && pre != '0')
            {
                dp[i + 1] += dp[i -1];
            }
        }
        return dp[len];
    }

    private boolean isValid(int value)
    {
        return value > 0 && value < 27;
    }
}
