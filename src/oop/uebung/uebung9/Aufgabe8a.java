package oop.uebung.uebung9;

import java.util.function.IntUnaryOperator;

public class Aufgabe8a
{

    public static void main(String[] args)
    {
        IntUnaryOperator op1 = (int x) -> x + 1;                
        //korrekt

        IntUnaryOperator op2 = int x -> x + 1;                  
        //Typ des Parameter ist deklariert, "()" ist notwendig.
        
        IntUnaryOperator op3 = (x) -> x + 1;                    
        //korrekt
        
        IntUnaryOperator op4 = (int x) -> return x + 1;;        
        //"return" Anweisung ist explizite im Code-Blocks angegeben, "{}" ist notwendig.
        
        IntUnaryOperator op5 = (x) -> {return x + 1};           
        //"return" Anweisung ist explizite im Code-Blocks angegeben, ";" ist am Ende notwendig.
        
        IntUnaryOperator op6 = x -> x + 1;                      
        //korrekt
        
        IntUnaryOperator op7 = (x) -> (x > 0) ? 1 : 0;          
        //korrekt
    }
}