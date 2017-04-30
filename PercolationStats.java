/**
 * Created by jslocke on 4/29/17.
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats
{
    private int trials;
    private int size;
    private int[][] grid;
    private double[] result;

    public PercolationStats(int n, int trials)
    {
        this.trials = trials;
        this.size = size;
        result = new double[trials];
        for (int i=0;i<trials;i++)
        {
            result[i] = (double) runPercolation(n)/(n*n);
        }
    }

    private int runPercolation(int n)
    {
        Percolation percolation = new Percolation(n);
        int blocksOpen = 0;
        while (!percolation.percolates())
        {
            int row = StdRandom.uniform(1,n+1);
            int col = StdRandom.uniform(1,n+1);
            percolation.open(row,col);
            blocksOpen++;
        }
        return blocksOpen;
    }

    public double mean()
    {
        return StdStats.mean(result);
    }

    public double stddev()
    {
        return StdStats.stddev(result);
    }

    public double confidenceLo()
    {
        return mean()-(1.96*stddev()/Math.sqrt(result.length));
    }


    public double confidenceHi()
    {
        return mean()+(1.96*stddev()/Math.sqrt(result.length));
    }
}
