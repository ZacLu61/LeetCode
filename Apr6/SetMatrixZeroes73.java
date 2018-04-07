package Apr6;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes73
{
    public SetMatrixZeroes73()
    {
        int[][] matrix = {{1, 0, 1},
                          {0, 1, 1},
                          {1, 1, 1}};

        setZeroes(matrix);

        printBoard(matrix);
    }

    private void setZeroes(int[][] matrix)
    {
        int row = matrix.length, col = matrix[0].length;

        boolean firstRow = false, firstCol = false;

        for (int i=0; i<row; i++)
        {
            for (int j=0; j<col; j++)
            {
                if (matrix[i][j] == 0)
                {
                    if (i == 0)
                    {
                        firstRow = true;
                    }
                    if (j == 0)
                    {
                        firstCol = true;
                    }
                    matrix[i][0] = 0;

                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=1; i<row; i++)
        {
            for (int j=1; j<col; j++)
            {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow)
        {
            for (int j=0; j<col; j++)
            {
                matrix[0][j] = 0;
            }
        }
        if (firstCol)
        {
            for (int i=0; i<row; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }

    private void printBoard(int[][] board)
    {
        List<List<Integer>> output = new ArrayList<>();

        for (int[] arr: board)
        {
            List<Integer> list = new ArrayList<>();

            for (int num: arr)
            {
                list.add(num);
            }
            output.add(new ArrayList<>(list));
        }
        for (List<Integer> list: output)
        {
            System.out.println(list);
        }
    }
}
