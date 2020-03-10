package sample;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleMovingAverage {

    private final Queue<RecordItem> Dataset = new LinkedList<RecordItem>();
    private final int period;
    private double sum;

    public SimpleMovingAverage(int period)
    {
        this.period = period;
    }

    public void addData(RecordItem item)
    {
        sum += item.Value;
        Dataset.add(item);

        if (Dataset.size() > period)
        {
            sum -= Dataset.remove().Value;
        }
    }

    public double getMean()
    {
        return sum / period;
    }
}
