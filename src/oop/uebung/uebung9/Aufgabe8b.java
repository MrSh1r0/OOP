package oop.uebung.uebung9;

import java.util.function.IntSupplier;

public class Aufgabe8b
{

    public static void main(String[] args)
    {
        IntSupplier op1 = () -> 42;
        // korrekt
        IntSupplier op2 = () -> Integer.valueOf(42);
        // korrekt
    }

}
