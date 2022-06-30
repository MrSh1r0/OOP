package oop.tutorium;

import java.util.Map;
import java.util.function.Function;

interface MyFunction<S, T>
{
    public T apply(S s);

    public default <U> MyFunction<S, U> andThen(MyFunction<? super T, ? extends U> f)
    {
        return s -> f.apply(this.apply(s));
    }
}

class X
{
}

public class AndThen
{

    public static void main(String[] args)
    {
        Function<Integer, Integer> f1 = x -> 10 * x;
        Function<Integer, Integer> f2 = x -> x + 4;

        Function<Integer, Integer> f3 = f1.andThen(f2);
        Function<Integer, Integer> f4 = f2.andThen(f1);

        System.out.println(f3.apply(1));
        System.out.println(f4.apply(1));

        Function<Double, Long> g1 = d -> Math.round(d.doubleValue());
        Function<Long, String> g2 = l -> "Ergebnis: " + l;
        // g1.andThen(g2);
        // g2.andThen(g1);
        Function<Double, String> g3 = g1.andThen(g2);
        System.out.println(g3.apply(3.74));

    }

    public static X mapmap(Map<String, Integer> map1, Map<Integer, X> map2, String s)
    {
        // return map2.get(map1.get(s));
        Function<String, Integer> f1 = str -> map1.get(str);
        Function<Integer, X> f2 = i -> map2.get(i);
        return f1.andThen(f2).apply(s);
    }

}
