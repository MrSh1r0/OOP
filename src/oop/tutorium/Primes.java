package oop.tutorium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes
{
    public static void main(String[] args)
    {
        System.out.println(calcPrimes(100));
    }

    public static List<Integer> calcPrimes(int max)
    {
        boolean[] candidates = new boolean[max + 1];
        Arrays.fill(candidates, true); // alle true
        for (int i = 2; i < candidates.length; i++)
        {
            if (candidates[i])
            {
                eraseMultiples(candidates, i);
            }
        }

        return buildList(candidates);
    }

    private static List<Integer> buildList(boolean[] candidates)
    {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < candidates.length; i++)
        {
            if (candidates[i])
            {
                result.add(i);
            }
        }
        return result;
    }

    private static void eraseMultiples(boolean[] candidates, int n)
    {
        for (int i = 2 * n; i < candidates.length; i += n)
        {
            candidates[i] = false;
        }

    }

    main ()
}
