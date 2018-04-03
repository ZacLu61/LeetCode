package Apr3;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII59
{
    public SpiralMatrixII59()
    {
        int n = 3;

        int[][] result = generateMatrix(n);

        printArray(result);
    }

    /**
     * Time Complexity: O(MN), M is the length of matrix. N is the length of matrix[0]
     *
     * @param n
     * @return
     */
    private int[][] generateMatrix(int n)
    {
        int[][] matrix = new int[n][n];
        // Edge Case
        if (n == 0) return matrix;

        int rowStart = 0, rowEnd = n -1, colStart = 0, colEnd = n -1;

        int num = 1;

        while (rowStart <= rowEnd && colStart <= colEnd)
        {
            for (int j=colStart; j<=colEnd; j++)
            {
                matrix[rowStart][j] = num++;
            }
            rowStart++;

            for (int i=rowStart; i<=rowEnd; i++)
            {
                matrix[i][colEnd] = num++;
            }
            colEnd--;
            // Check if need to continue
            if (rowStart <= rowEnd)
            {
                for (int j=colEnd; j>=colStart; j--)
                {
                    matrix[rowEnd][j] = num++;
                }
                rowEnd--;
            }
            // Check if need to continue
            if (colStart <= colEnd)
            {
                for (int i=rowEnd; i>=rowStart; i--)
                {
                    matrix[i][colStart] = num++;
                }
                colStart++;
            }
        }
        return matrix;
    }

    private void printArray(int[][] matrix)
    {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list;

        for (int[] arr:  matrix)
        {
            list = new ArrayList<>();

            for (int num: arr)
            {
                list.add(num);
            }
            result.add(new ArrayList<>(list));
        }
        for (List<Integer> curList: result)
        {
            System.out.println(curList);
        }
    }
}
