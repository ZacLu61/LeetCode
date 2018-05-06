package May4;

public class ReverseWordsinaStringII186
{
    public ReverseWordsinaStringII186()
    {
        String input = "the sky is blue";

        char[] arr = input.toCharArray();

        reverseWords(arr);

        System.out.println(new String(arr));
    }

    private void reverseWords(char[] str)
    {
        if (str == null || str.length == 0) return;

        int index = 0, start = 0;
        // Reverse entire string
        reverse(str, 0, str.length -1);

        while (index < str.length)
        {   // Find reverse point
            if (str[index] == ' ')
            {   // Do the reverse substring(start, index)
                reverse(str, start, index -1);
                // Update new start point
                start = index + 1;
            }
            index++;
        }
        // Reverse last substring(start, len -1)
        reverse(str, start, str.length -1);
    }

    private void reverse(char[] arr, int start, int end)
    {
        while (start < end)
        {
            swap(arr, start++, end--);
        }
    }

    private void swap(char[] arr, int index1, int index2)
    {
        char temp = arr[index1];

        arr[index1] = arr[index2];

        arr[index2] = temp;
    }
}
