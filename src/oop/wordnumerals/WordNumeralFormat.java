package oop.wordnumerals;

public class WordNumeralFormat
{
    public static String toString(int num)
    {

        String str = String.valueOf(num);
        StringBuilder temp = new StringBuilder();
        for (char digit : str.toCharArray())
        {
            if (digit == '0')
            {
                temp.append("null ");
                continue;
            }
            if (digit == '1')
            {
                temp.append("eins ");
                continue;
            }
            if (digit == '2')
            {
                temp.append("zwei ");
                continue;
            }
            if (digit == '3')
            {
                temp.append("drei ");
                continue;
            }
            if (digit == '4')
            {
                temp.append("vier ");
                continue;
            }
            if (digit == '5')
            {
                temp.append("fuenf ");
                continue;
            }
            if (digit == '6')
            {
                temp.append("sechs ");
                continue;
            }
            if (digit == '7')
            {
                temp.append("sieben ");
                continue;
            }
            if (digit == '8')
            {
                temp.append("acht ");
                continue;
            }
            if (digit == '9')
            {
                temp.append("neun ");
                continue;
            }
        }
        String result = temp.toString().trim();
        if (num < 0)
        {
            result = "- " + result;
        }
        return result;

    }

    public static int parse(String words)
    {
        String number = new String();
        int negative = 0;
        double result = 0;
        String[] word = words.split(" ");

        for (int i = 0; i < word.length; i++)
        {
            if (word[i].equals("-") && i != 0)
            {
                throw new NumberFormatException("Sie m¸ssen die korekten Form eingeben!");
            }
            if (word[i].equals("null") && word.length <= 1)
            {
                break;
            }
            switch (word[i])
            {
                case "-":
                    negative = 1;
                    break;

                case "null":
                    number += "0";
                    break;

                case "eins":
                    number += "1";
                    break;

                case "zwei":
                    number += "2";
                    break;

                case "drei":
                    number += "3";
                    break;

                case "vier":
                    number += "4";
                    break;

                case "fuenf":
                    number += "5";
                    break;

                case "sechs":
                    number += "6";
                    break;

                case "sieben":
                    number += "7";
                    break;

                case "acht":
                    number += "8";
                    break;

                case "neun":
                    number += "9";
                    break;

                default:
                    throw new NumberFormatException("Sie m¸ssen die korekten Form eingeben!");
            }
        }
        if (number == null || number.isEmpty())
        {
            result = 0.0;
        }
        else
        {
            result = Double.parseDouble(number);
        }

        if (negative == 1)
        {
            result = result * -1;
        }
        if (result > Integer.MAX_VALUE)
        {
            throw new NumberFormatException("Die Zahl ist zu groﬂ!");
        }
        if (result < Integer.MIN_VALUE)
        {
            throw new NumberFormatException("Die Zahl ist zu klein!");
        }

        return (int) result;
    }

    public static void main(String args[])
    {
        System.out.println(toString(-5321));
        System.out.println(parse(""));
        System.out.println(parse("null null eins null null"));
    }
}