package oop.tutorium.proxy;

public class ConsoleOutput implements Output
{
    @Override
    public void sendData(String data)
    {
        System.out.println(data);
    }

    @Override
    public void flush()
    {
        // TODO Auto-generated method stub

    }
}
