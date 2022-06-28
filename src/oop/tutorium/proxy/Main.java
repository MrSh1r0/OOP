package oop.tutorium.proxy;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        ConsoleOutput output = new ConsoleOutput();
        TransformedOutput trans = new TransformedOutput(output);
        BufferedOutput buffered = new BufferedOutput(trans, 100);

        Scanner input = new Scanner(System.in);
        use(input, buffered);
        input.close();
    }

    public static void use(Scanner input, Output output)
    {
        while (true)
        {
            String line = input.nextLine();
            if (line.equals("exit"))
            {
                break;
            }
            output.sendData(line + "/n");
        }
        output.flush();
    }

}
