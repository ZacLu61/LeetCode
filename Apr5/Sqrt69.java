package Apr5;

public class Sqrt69
{
    public Sqrt69()
    {
        int x = 4;

        System.out.println(mySqrt(x));
    }

    private int mySqrt(int x)
    {
        long num = x;

        while (num * num > x)
        {
            num = (num + num / x) >> 1;
        }
        return (int) num;
    }
}
