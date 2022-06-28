package oop.tutorium;

import java.util.ArrayList;
import java.util.List;

public class FavoriteClass<S, R, T>
{
    private S favorite1;

    private R favorite2;

    private T favorite3;

    public FavoriteClass()
    {
        this.favorite1 = favorite1;
        this.favorite2 = favorite2;
        this.favorite3 = favorite3;
    }

    public S getFav1()
    {
        return (this.favorite1);
    }

    public R getFav2()
    {
        return (this.favorite2);
    }

    public T getFav3()
    {
        return (this.favorite3);
    }
}

public class Main
{
    public static void main(String[] args)
    {
        List<Double> r = new ArrayList<Double>();
        r.add(Double.valueOf(6.3));
        r.add(5.9);
    }
}
