/**
 * Created by jslocke on 4/29/17.
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats
{
    private int size;
    private double[] result;

    public PercolationStats(int n, int trials)
    {
        this.size = size;
        result = new double[trials];
        for (int i=0;i<trials;i++)
            result[i] = (double)runPercolation(n)/(n*n);
    }

    private int runPercolation(int n)
    {
        Percolation percolation = new Percolation(n);
        int blocksOpen = 0;
        while (!percolation.percolates())
        {
            int row = StdRandom.uniform(1,n);
            int col = StdRandom.uniform(1,n);
            percolation.open(row,col);
            blocksOpen++;
        }
        System.out.println(blocksOpen);
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

    public static void main(String args[])
    {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(n,trials);
        System.out.println("mean                    = "+percolationStats.mean());
        System.out.println("stddev                  = "+percolationStats.stddev());
        System.out.println("95% confidence interval = ["+percolationStats.confidenceLo()+", "
                +percolationStats.confidenceHi()+"]");
    }
}
