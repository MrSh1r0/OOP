package oop.tutorium;

public class Example
{
    private static final int END = Integer.MAX_VALUE;

    private static final int SPAN = 50;

    private static final int START = END - SPAN;

    public static void main(String[] args)
    {
        /*
         * int counter = 0; for (int i = START; i < END; i++) { counter++; }
         * System.out.println(counter);
         */
        int i = Integer.MAX_VALUE;
        System.out.println(i);
        i++;
        System.out.println(i);
        i--;
        System.out.println(i);
        // start i++;
        try
        {
            i = Math.addExact(i, 1);
            System.out.println(i);
        }
        catch (ArithmeticException a)
        {
            System.out.println("geht nicht");
        }
    }
}