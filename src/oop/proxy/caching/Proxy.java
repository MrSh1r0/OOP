package oop.proxy.caching;

import java.util.HashMap;

public class Proxy implements ProxyAdminInterface, FunctionInterface
{
    private FunctionInterface function;

    private HashMap<Double, Double> cacheMap = new HashMap<>();

    public Proxy(FunctionInterface func)
    {
        this.function = func;
    }

    @Override
    public void clearCache()
    {
        cacheMap.clear();
    }

    @Override
    public double f(double x)
    {
        if (cacheMap.containsKey(x))
        {
            return cacheMap.get(x);
        }
        else
        {
            double result = function.f(x);
            cacheMap.put(x, result);
            return result;
        }
    }

}
