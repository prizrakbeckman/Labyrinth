package net.lewbox.model;

public class MazeCell
{
    private int x;

    private int y;

    private MazeCellState cellState;

    public MazeCell(int x, int y, MazeCellState cellState)
    {
        this.x = x;
        this.y = y;
        this.cellState = cellState;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public MazeCellState getCellState()
    {
        return this.cellState;
    }

    public void setCellState(MazeCellState cellState)
    {
        this.cellState = cellState;
    };

    @Override
    public String toString()
    {
        return "{" + this.x + "," + this.y + "," + this.cellState + "}";
    }
}
