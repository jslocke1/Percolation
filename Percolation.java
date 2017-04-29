/**
 * Created by jslocke on 4/29/17.
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
    private int[][] blocks;
    public Percolation(int n)
    {
        blocks = new int[n][n];
        for (int i=0;i<blocks.length;i++)
            for (int j=0;j<blocks.length;j++)
                blocks[i][j]=0;
    }

    public void open(int row, int col)
    {
        blocks[row][col]=1;
    }

    public boolean isOpen(int row, int col)
    {
        return blocks[row][col]==1;
    }

    public boolean isFull(int row, int col)
    {
        return blocks[row][col]==2;
    }

    public int numberOfOpenSites()
    {
        int numberOfOpenSites=0;
        for (int i=0;i<blocks.length;i++)
        {
            for (int j = 0; j < blocks.length; j++)
            {
                if (blocks[i][j]==1)
                    numberOfOpenSites++;
            }
        }
        return numberOfOpenSites;
    }

    public static void main(String args[])
    {

    }
}
