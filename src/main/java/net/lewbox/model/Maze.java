package net.lewbox.model;

public class Maze
{
    private MazeCell[][] maze;

    private int optimalPathLength = Integer.MAX_VALUE;

    public Maze(int N)
    {
        this.maze = new MazeCell[N][N];
    }

    public MazeCell[][] getMaze()
    {
        return this.maze;
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
