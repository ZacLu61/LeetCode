package May4;

public class ReverseWordsinaString151
{
    public ReverseWordsinaString151()
    {
        String s = "the sky is blue";

        System.out.println(reverseWords(s));
    }

    private String reverseWords(String s)
    {
        if (s == null || s.length() == 0) return s;

        String[] arr = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i=arr.length -1; i>=0; i--)
        {   // If more than 1 space, arr[i] can be "".
            if (!arr[i].equals(""))
            {
                sb.append(arr[i] + " ");
            }
        }
        // remove the last " "
        return sb.toString().trim();
    }
}
