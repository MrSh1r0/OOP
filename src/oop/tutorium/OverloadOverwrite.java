package oop.tutorium;

class AClass
{
    public void abc()
    {
    }
}

class BClass extends AClass
{
    public void xyz()
    {
    }
}

class X1Class
{
    public void m(BClass b)
    {
        System.out.println();
        BClass a;
        if (a instanceof BClass)
        {
            BClass b = a;
        }
    }
}

class X2Class extends X1Class
{

}

class Y1Class
{

}

class Y2Class extends Y1Class
{

}

public class OverloadOverwrite
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        X1Class x1 = new X1Class();
        x1.m(new AClass());
        x1.m(new BClass());
        X2Class x2 = new X2Class();
        x2.m(new AClass());
        x2.m(new BClass());
        x1 = x2;
        x1.m(new BClass());
        x2.m(new BClass()); // entscheidend Aufruf von X1Class.m(Aclass)!!
        System.out.println();

        // overwriting:
        Y1Class y1 = new Y1Class();
        y1.m(new AClass());
        y1.m(new BClass());
        Y2Class y2 = new Y2Class();
        y2.m(new AClass());
        y2.m(new BClass());
        y1 = y2;
        y1.m(new BClass());
        y2.m(new BClass());
    }

}
