package oop.matrix;

public class Operation
{
    public static void test(int[][] input)
    {
        if (input == null)
        {
            throw new IllegalArgumentException("ungültige Eingabe");
        }
        if (input.length == 0)
        {
            throw new IllegalArgumentException("ungültige Eingabe");
        }
        for (int i = 0; i < input.length; i++)
        {
            if (input[i] == null)
            {
                throw new IllegalArgumentException("ungültige Eingabe");
            }
            if (input[i].length == 0)
            {
                throw new IllegalArgumentException("ungültige Eingabe");
            }
            int check = input[0].length;
            if (input[i].length != check)
            {
                throw new IllegalArgumentException("ungültige Eingabe");
            }
        }
    }

    public static int[][] transpose(int[][] input)
    {
        test(input);
        int x = input.length;
        int y = input[0].length;
        int[][] output = new int[y][x];
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                output[j][i] = input[i][j];
            }
        }
        return output;
    }

    public static int[][] rotateClockwise(int[][] input)
    {
        test(input);
        int x = input.length;
        int y = input[0].length;
        int[][] output = new int[y][x];
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                output[j][x - 1 - i] = input[i][j];
            }
        }
        return output;
    }

    public static int[][] rotateCounterClockwise(int[][] input)
    {
        test(input);
        int x = input.length;
        int y = input[0].length;
        int[][] output = new int[y][x];
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                output[y - 1 - j][i] = input[i][j];
            }
        }
        return output;
    }
}
