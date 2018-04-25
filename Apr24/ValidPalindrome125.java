package Apr24;

public class ValidPalindrome125
{
    public ValidPalindrome125()
    {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }

    private boolean isPalindrome(String s)
    {   // Check corner
        if (s == null || s.length() == 0) return true;
        // 2 pointer for left and right
        int left = 0, right = s.length() - 1;

        while (left < right) {   // Make char lower case
            char leftChar = Character.toLowerCase(s.charAt(left));

            char rightChar = Character.toLowerCase(s.charAt(right));
            // Check if left char is valid (character or digit only)
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            }
            // Check right character
            else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            }
            // Both left and right char are valid
            else {
                if (leftChar != rightChar) return false;

                left++;

                right--;
            }
        }
        return true;
    }
}
