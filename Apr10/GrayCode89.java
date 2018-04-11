package Apr10;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89
{
    public GrayCode89()
    {
        int n = 2;

        System.out.println(grayCode(n));
    }

    private List<Integer> grayCode(int n)
    {
        List<Integer> result = new ArrayList<>();

        int count = (int) Math.pow(2, n);

        for (int i=0; i<count; i++)
        {   // right shift first, then exclusive or
            int temp  = i ^ i >> 1;

            result.add(temp);
        }
        return result;
    }
}
