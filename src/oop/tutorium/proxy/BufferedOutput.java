package oop.tutorium.proxy;

public class BufferedOutput implements Output
{
    private Output output;

    private StringBuilder buffer;

    private int size;

    public BufferedOutput(Output output, int size)
    {
        super();
        this.output = output;
        this.size = size;
        this.buffer = new StringBuilder();
    }

    @Override
    public void sendData(String data)
    {
        buffer.append(data);
        if (buffer.length() > size)
        {
            output.sendData(buffer.toString());
            buffer.setLength(0);
        }
    }

    @Override
    public void flush()
    {
        // TODO Auto-generated method stub

    }
}
