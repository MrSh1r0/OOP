package oop.tutorium;

import java.util.Arrays;

class NotFoundException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
}

public interface MyPredicate<S>
{
    public boolean test(S s);

    public default MyPredicate<S> negate()
    {
        return s -> !test(s);
    }

    public default MyPredicate<S> and(MyPredicate<? super S> pred)
    {
        return s -> test(s) && pred.test(s);
    }

    public default MyPredicate<S> or(MyPredicate<S> pred)
    {
        return s -> test(s) || pred.test(s);
    }

    public static <T> MyPredicate<T> not(MyPredicate<T> pred)
    {
        // return t ->!pred.test(t);
        return t -> pred.negate().test(t);
    }

    public static <T> MyPredicate<T> alawaysTrue()
    {
        return t -> true;
    }

    public static String findFirst(String[] array, MyPredicate<String> pred) throws NotFoundException
    {
        for (String str : array)
        {
            if (pred.test(str))
            {
                return str;
            }
        }
        throw new NotFoundException();
    }

    public static void main(String[] args) throws NotFoundException
    {
        String[] array =
        { "", "xxxxx", "Mallo" };
        System.out.println(Arrays.toString(array));
        MyPredicate<CharSequence> length5 = s -> s.length() == 5;
        MyPredicate<String> startWithMa = s -> s.startsWith("Ma");

        System.out.println("length5 für \"abcd\": " + length5.test("abcd"));
        System.out.println("length5.negate für \"abcd\": " + length5.negate().test("abcd"));

        System.out.println(findFirst(array, startWithMa));
        System.out.println(findFirst(array, startWithMa.negate()));
        System.out.println(findFirst(array, startWithMa.and(startWithMa)));

    }
}
