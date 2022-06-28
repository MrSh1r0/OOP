package oop.roman;

public class RomanNumeralFormat
{
    private static int[] number =
    { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    private static String[] symbol =
    { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public static String toString(int num)
    {
        if (num < 1)
        {
            throw new IllegalArgumentException("Der Wert muss größer als 0 sein.");
        }
        if (num > 3999)
        {
            throw new IllegalArgumentException("Der Wert muss kleiner als 4000 sein.");
        }

        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < number.length; i++)
        {
            while (num >= number[i])
            {
                num -= number[i];
                roman.append(symbol[i]);
            }
        }
        String out = "" + roman;
        return out;
    }

    public static int parse(String roman)
    {
        if (roman == null || roman.isEmpty() || !roman.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))
        {
            throw new NumberFormatException("ungültige Format");
        }
        long result = 0;
        for (int i = 0; i < roman.length(); i++)
        {
            int num1 = 0;
            switch (roman.charAt(i))
            {
                case ('I'):
                {
                    num1 = 1;
                    break;
                }
                case ('V'):
                {
                    num1 = 5;
                    break;
                }

                case ('X'):
                {
                    num1 = 10;
                    break;
                }

                case ('L'):
                {
                    num1 = 50;
                    break;
                }
                case ('C'):
                {
                    num1 = 100;
                    break;
                }
                case ('D'):
                {
                    num1 = 500;
                    break;
                }
                case ('M'):
                {
                    num1 = 1000;
                    break;
                }
                default:
                {
                    throw new NumberFormatException("ungültige Format");

                }
            }

            if (i + 1 < roman.length())
            {
                int num2 = 0;
                switch (roman.charAt(i + 1))
                {
                    case ('I'):
                    {
                        num2 = 1;
                        break;
                    }
                    case ('V'):
                    {
                        num2 = 5;
                        break;
                    }

                    case ('X'):
                    {
                        num2 = 10;
                        break;
                    }

                    case ('L'):
                    {
                        num2 = 50;
                        break;
                    }
                    case ('C'):
                    {
                        num2 = 100;
                        break;
                    }
                    case ('D'):
                    {
                        num2 = 500;
                        break;
                    }
                    case ('M'):
                    {
                        num2 = 1000;
                        break;
                    }
                    default:
                    {
                        throw new NumberFormatException("ungültige Format");

                    }
                }

                if (num1 >= num2)
                {
                    result += num1;
                }
                else
                {
                    result += (num2 - num1);
                    i++;
                }
            }
            else
            {
                result += num1;
            }
        }
        return (int) result;
    }

    public static void main(String args[])
    {
        System.out.println(toString(2021));
        System.out.println(parse("XC"));
    }

}