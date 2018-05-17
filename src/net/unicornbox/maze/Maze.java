package net.unicornbox.maze;

public class Maze
{
    private MazeCell[][] maze;

    private int optimalPathLength = Integer.MAX_VALUE;

    public Maze(int N)
    {
        maze = new MazeCell[N][N];
    }

    public MazeCell[][] getMaze()
    {
        return maze;
    }

    public int getOptimalPathLength()
    {
        return optimalPathLength;
    }

    void setOptimalPathLength(int optimalPathLength)
    {
        this.optimalPathLength = optimalPathLength;
    }
}
