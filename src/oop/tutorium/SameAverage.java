package oop.tutorium;

public class SameAverage
{
    public static void main(String[] args)
    {
        Integer[] integerNumbers =
        { 1, 2, 3, 4 };
        Double[] doubleNumbers =
        { 1.0, 2.0, 3.0, 4.0 };
        Average<Integer> integerObject = new Average<>(integerNumbers);
        Average<Double> doubleObject = new Average<>(doubleNumbers);
        System.out.println(integerObject.sameAverage(doubleObject));
    }
}

class Average<T extends Number>
{
    T[] numbers;

    Average(T[] numbers)
    {
        this.numbers = numbers;
    }

    boolean sameAverage(Average<? extends Number> obj)
    {
        return getAverage() == obj.getAverage();
    }
    // Alternative:
    // boolean sameAverage (Average <? extends Number> obj)
    // {
    // return getAverage () == obj.getAverage ();
    // }

    double getAverage()
    {
        double num = 0.0;
        for (int i = 0; i < numbers.length; i++)
        {
            num += numbers[i].getValue();
        }
        return num / numbers.length;
    }
}
