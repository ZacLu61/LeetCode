package Apr5;

public class Pow50
{
    public Pow50()
    {
        double x = 2.000;

        int n = 10;

        System.out.println(myPow(x, n));
    }

    public double myPow(double x, int n)
    {
        long N = n;

        if (N < 0)
        {
            N = -N;

            x = 1 / x;
        }
        double result = 1, product = x;

        for (long i=N; i>0; i/=2)
        {
            if (i % 2 == 1)
            {
                result *= product;
            }
            product *= product;
        }
        return result;
    }
}
