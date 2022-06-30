package oop.tutorium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pythagoras
{
    private static long power(int x, int n) // x ** n
    {
        if (n < 0)
        {
            throw new IllegalArgumentException();
        }
        long result = 1;
        for (int i = 0; i < n; i++)
        {
            // result *=x
            result = Math.multiplyExact(result, x);
        }
        return result;
    }

    public static List<int[]> calcTriples(int max, int power)
    {
        List<int[]> result = new ArrayList<>();
        for (int a = 1; a <= max; a++)
        {
            for (int b = 1; b <= max; b++)
            {
                long aPower = power(a, power);
                long bPower = power(b, power);
                long sum = aPower + bPower;
                for (int c = Math.max(a, b) + 1; c <= max; c++)
                {
                    long cPower = power(c, power);
                    if (cPower > sum)
                    {
                        break;
                    }
                    else if (cPower == sum)
                    {
                        int[] triple = new int[]
                        { a, b, c };
                        /*
                         * triple = new int[3]; triple[0] = a; triple[1] = b;
                         * triple[2] = c;
                         */
                        result.add(triple);
                    }
                }
            }
        }
        return result;
    }

    private static void calcAndPrint(int max, int power)
    {
        System.out.println("Potenz: " + power);
        try
        {
            List<int[]> list = calcTriples(max, power); // Stelle2
            for (int[] triple : list)
            {
                System.out.println("  " + Arrays.toString(triple));
            }
            System.out.println("  Anzahl " + list.size());
        }
        catch (Exception e)
        {

            e.printStackTrace();
            System.out.println("sehr schade...");
        }

    }

    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        calcAndPrint(1_000, -1);
        calcAndPrint(1_000, 2);
        calcAndPrint(1_000, 3);
        calcAndPrint(1_000, 4);
        calcAndPrint(1_000, 5);
        long endTime = System.currentTimeMillis();
        System.out.println("Zeit:" + (endTime - startTime));
    }
}
