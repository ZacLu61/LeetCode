package Apr3;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54
{
    public SpiralMatrix54()
    {
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};

        System.out.println(spiralOrder(matrix));
    }

    /**
     * Time Complexity: O(MN), M is the length of matrix. N is the length of matrix[0]
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> result = new ArrayList<>();
        // Corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

        int rowStart = 0, rowEnd = matrix.length -1, colStart = 0, colEnd = matrix[0].length -1;

        while (rowStart <= rowEnd && colStart <= colEnd)
        {
            for (int j=colStart; j<=colEnd; j++)
            {
                result.add(matrix[rowStart][j]);
            }
            rowStart++;

            for (int i=rowStart; i<=rowEnd; i++)
            {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            // Check if need to continue
            if (rowStart <= rowEnd)
            {
                for (int j=colEnd; j>=colStart; j--)
                {
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            // Check if need to continue
            if (colStart <= colEnd)
            {
                for (int i=rowEnd; i>=rowStart; i--)
                {
                    result.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return result;
    }
}
