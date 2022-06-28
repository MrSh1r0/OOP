package oop.interfaces.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable
{
    private int value;

    private List<Observer> observers;

    public Observable(int initialValue)
    {
        value = initialValue;
        observers = new ArrayList<Observer>();
    }

    public Observable()
    {
        this(0);
    }

    public void addChangeObserver(ChangeObserver obs, int start, int end)
    {
        if (obs == null || start > end)
        {
            throw new IllegalArgumentException();
        }
        observers.add(new Observer(obs, start, end));
    }

    public void removeChangeObserver(ChangeObserver obs, int start, int end)
    {
        for (int i = 0; i < observers.size(); i++)
        {
            Observer o = observers.get(i);
            if (o.getObs() == obs && o.getStart() == start && o.getEnd() == end)
            {
                observers.remove(o);
            }
        }

    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        if (this.value != value)
        {
            int oldValue = this.value;
            int newValue = value;
            this.value = value;
            for (Observer obs : observers)
            {
                if (newValue >= obs.getStart() && newValue <= obs.getEnd())
                {
                    obs.getObs().valueHasChanged(oldValue, newValue);
                }
            }
        }
    }

    class Observer
    {
        private ChangeObserver chObs;

        private int start;

        private int end;

        public ChangeObserver getObs()
        {
            return chObs;
        }

        public int getStart()
        {
            return start;
        }

        public int getEnd()
        {
            return end;
        }

        public Observer(ChangeObserver obs, int start, int end)
        {
            this.chObs = obs;
            this.start = start;
            this.end = end;
        }
    }
}
