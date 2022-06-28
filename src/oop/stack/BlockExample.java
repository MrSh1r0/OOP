package oop.stack;

public class BlockExample
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int i = 0;
        {
            int j = 30;
            {
                int k = 100;
                j = k;
            }
            i = j;
        }
    }

}
