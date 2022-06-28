package oop.proxy.caching;

import java.util.Arrays;

public class FunctionImplementation implements FunctionInterface, FunctionAdminInterface
{
    private double[] coefficients;

    public FunctionImplementation()
    {
        coefficients = new double[0];
    }

    @Override
    public void setCoefficients(double[] coeffs)
    {

        this.coefficients = coeffs.clone();

    }

    @Override
    public double[] getCoefficients()
    {
        return this.coefficients.clone();

    }

    @Override
    public double f(double x)
    {
        if (coefficients == null || coefficients.length == 0)
        {
            return 0;
        }
        double result = 0.0;
        for (int i = 0; i < coefficients.length; i++)
        {
            double pol = coefficients[i] * Math.pow(x, ((coefficients.length - 1) - i));
            result += pol;
        }
        return result;
    }

    public static void main(String[] args)
    {
        FunctionImplementation myObj = new FunctionImplementation();
        myObj.setCoefficients(new double[]
        { 0.0 });
        System.out.println(myObj.f(-10.0));
        System.out.println(myObj.f(-9.0));
        System.out.println(Arrays.toString(myObj.getCoefficients()));
        myObj.setCoefficients(new double[]
        { 1.0, 1.0 });
        System.out.println(myObj.f(-10.0));
        System.out.println(myObj.f(-9.0));
        System.out.println(Arrays.toString(myObj.getCoefficients()));
    }
}
