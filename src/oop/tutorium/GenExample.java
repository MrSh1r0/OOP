package oop.tutorium;

class Gen1<T>
{
    public Gen1()
    {
        System.out.println("Kon. Gen1");
    }
}

class Gen2<T> extends Gen1<T>
{
    public Gen2()
    {
    }
}

public class GenExample
{
    public static void main(String[] args)
    {
        Gen2<Object> g = new Gen2<>();
    }
}
