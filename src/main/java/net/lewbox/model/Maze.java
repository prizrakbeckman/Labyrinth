package net.lewbox.model;

public class Maze
{
    private MazeCell[][] mazeCell;

    private int optimalPathLength = Integer.MAX_VALUE;

    public Maze(int n)
    {
        this.mazeCell = new MazeCell[n][n];
    }

    public MazeCell[][] getMaze()
    {
        return this.mazeCell;
    }

    public int getOptimalPathLength()
    {
        return this.optimalPathLength;
    }

    public void setOptimalPathLength(int optimalPathLength)
    {
        this.optimalPathLength = optimalPathLength;
    }
}
