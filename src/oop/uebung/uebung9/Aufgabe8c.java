package oop.uebung.uebung9;

import java.util.function.IntBinaryOperator;

public class Aufgabe8c
{

    public static void main(String[] args)
    {
        IntBinaryOperator op1 = (int x, int y) -> x + y;                        
        //korrekt    
        
        IntBinaryOperator op2 = int x, int y -> x + y;                        
        //Wenn es mehr Parameters gibt, ist "()" notwendig.
        
        IntBinaryOperator op3 = (x, y) -> x + y;                                
        //korrekt
        
        IntBinaryOperator op4 = (x, y) -> {if(x > y) return x; else return y;}; 
        //korrekt
        
        IntBinaryOperator op5 = x, y -> x + y;                                
        //Wenn es mehr Parameters gibt, ist "()" notwendig.
        
        IntBinaryOperator op6 = (int x, y) -> x + y;                          
        //Wenn es mehr Parameters gibt, muss Alle ihrer Typ eigeben

    }

}
