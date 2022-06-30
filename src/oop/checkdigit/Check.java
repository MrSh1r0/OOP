package oop.checkdigit;

public class Check
{

    public static long transformToCheckedNumber(long input)
    {
        if (input < 0 || input >= (Long.MAX_VALUE / 10))
        {
            throw new IllegalArgumentException("ungültige Zahl");
        }
        long number = input;
        long check;
        long output;
        long digit;
        long sum = 0;
        while (number > 0)
        {
            digit = number % 10;
            sum += digit;
            number /= 10;
        }
        check = 10 - (sum % 10);
        if (check == 10)
        {
            check = 0;
        }
        output = input * 10 + check;
        return output;
    }

    public static long transformToUncheckedNumber(long input)
    {
        if (input < 0 || input >= Long.MAX_VALUE)
        {
            throw new IllegalArgumentException("ungültige Zahl");
        }
        long number = input;
        long output;
        long digit;
        long sum = 0;
        while (number > 0)
        {
            digit = number % 10;
            sum += digit;
            number /= 10;
        }
        if (sum % 10 == 0)
        {
            output = (input - (input % 10)) / 10;
        }
        else
        {
            throw new IllegalArgumentException("ungültige Zahl");
        }

        return output;
    }

    public static void main(String[] args)
    {
        System.out.println(transformToCheckedNumber(9223372036854775807L));
    }

}
