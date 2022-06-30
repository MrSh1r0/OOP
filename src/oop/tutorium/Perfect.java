package oop.tutorium;

import java.util.ArrayList;
import java.util.List;

class myClass
{
    private int i, j;

    private String desc;

    public MyClass(int i, int j, String desc)
    {
        super();
        this.i = i;
        this.j = j;
        this.desc = desc;
    }

    @Override
    public String toString()
    {
        return i + " / " + j + " / " + desc;
    }
}

public class Perfect
{

    public static List<Integer> calcPerfectNumbers(int max)
    {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++)
        {
            if (isPerfect(i))
            {
                result.add(i);
            }
        }
        return result;
    }

    /*
     * perfekte Zahl; Wert == Summe ihre Teiler
     */
    private static boolean isPerfect(int n)
    {
        int sumOfMultipliers = 0;
        for (int i = 1; i < n; i++)
        {
            if (n % i == 0)
            {
                sumOfMultipliers += i;
            }
        }
        return n == sumOfMultipliers;
    }

    public static void main(String[] args)
    {
        List<Integer> list = calcPerfectNumbers(1000);
        String s = "Mein String " + list;
        System.out.println(s);

        myClass myObject = new MyClass(10, 20, "Beschriebung");
        System.out.println(myObject);

        List<myClass> anotherList = new ArrayList<>();
        anotherList.add(new MyClass(1, 2, "Ha"));
        anotherClass.add(new MyClass(3, 4, "Hu"));
        System.out.println(anotherList);
    }
}