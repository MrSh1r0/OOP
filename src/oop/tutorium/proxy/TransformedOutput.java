package oop.tutorium.proxy;

public class TransformedOutput implements Output
{
    private Output output;

    public TransformedOutput(Output output)
    {
        super();
        this.output = output;
    }

    @Override
    public void sendData(String data)
    {
        String newData = data.toUpperCase();
        output.sendData(newData);
    }

    @Override
    public void flush()
    {
        output.flush();

    }

}
