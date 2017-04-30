/**
 * Created by jslocke on 4/29/17.
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation
{
    private boolean[][] isOpen;
    private WeightedQuickUnionUF grid;
    final private int TOP = 0;
    private int BOTTOM;

    public Percolation(int n)
    {
        if (n<0)
            throw new IllegalArgumentException("n must be greater than zero");
        isOpen = new boolean[n][n];
        for (int i = 0; i< isOpen.length; i++)
            for (int j = 0; j< isOpen.length; j++)
                isOpen[i][j]=false;
        grid = new WeightedQuickUnionUF(n*n+2);
        final int BOTTOM = n*n+1;
    }

    public void open(int row, int col)
    {
        if (row<=0)
            throw new IndexOutOfBoundsException("row must be greater than zero");
        if (col<=0)
            throw new IndexOutOfBoundsException("col must be greater than zero");
        isOpen[row-1][col-1]=true;
        if (row==1)
            grid.union(row*col,TOP);
        if (row==isOpen.length)
            grid.union(row*col, BOTTOM);
        if (isValidCoordinate(row+1,col) && isOpen(row+1,col))
            grid.union(row*col,(row+1)*col);
        if (isValidCoordinate(row-1,col) && isOpen(row-1,col))
            grid.union(row*col,(row-1)*col);
        if (isValidCoordinate(row,col+1) && isOpen(row,col+1))
            grid.union(row*col,row*(col+1));
        if (isValidCoordinate(row,col-1) && isOpen(row,col-1))
            grid.union(row*col,row*(col-1));
    }

    private boolean isValidCoordinate(int row, int col)
    {
        return row>=1 && col>=1;
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
        return grid.connected(TOP,row*col);
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
