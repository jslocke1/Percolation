/**
 * Created by jslocke on 4/29/17.
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
    private boolean[][] isOpen;
    private WeightedQuickUnionUF grid;

    public Percolation(int n)
    {
        if (n<0)
            throw new IllegalArgumentException("n must be greater than zero");
        isOpen = new boolean[n][n];
        for (int i = 0; i< isOpen.length; i++)
            for (int j = 0; j< isOpen.length; j++)
                isOpen[i][j]=false;
        grid = new WeightedQuickUnionUF(n);
    }

    public void open(int row, int col)
    {
        if (row<=0)
            throw new IndexOutOfBoundsException("row must be greater than zero");
        if (col<=0)
            throw new IndexOutOfBoundsException("col must be greater than zero");
        isOpen[row-1][col-1]=true;
    }

    public boolean isOpen(int row, int col)
    {
        if (row<=0)
            throw new IndexOutOfBoundsException("row must be greater than zero");
        if (col<=0)
            throw new IndexOutOfBoundsException("col must be greater than zero");
        return isOpen[row-1][col-1];
    }

    public boolean isFull(int row, int col)
    {
        if (row<=0)
            throw new IndexOutOfBoundsException("row must be greater than zero");
        if (col<=0)
            throw new IndexOutOfBoundsException("col must be greater than zero");
        return isOpen[row-1][col-1];
    }

    public int numberOfOpenSites()
    {
        int numberOfOpenSites=0;
        for (int i = 0; i< isOpen.length; i++)
        {
            for (int j = 0; j < isOpen.length; j++)
            {
                if (isOpen[i][j])
                    numberOfOpenSites++;
            }
        }
        return numberOfOpenSites;
    }

    public static void main(String args[])
    {

    }
}
