package net.unicornbox.maze;

public class MazeCell
{
    private int x;

    private int y;

    private MazeCellState cellState;

    public enum MazeCellState
    {
        EXIT, ENTRANCE, WALL, EMPTY;
    }

    public MazeCell(int x, int y, MazeCellState cellState)
    {
        this.x = x;
        this.y = y;
        this.cellState = cellState;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public MazeCellState getCellState()
    {
        return cellState;
    }

    void setCellState(MazeCellState cellState)
    {
        this.cellState = cellState;
    };

    @Override
    public String toString()
    {
        return "{" + x + "," + y + "," + cellState + "}";
    }
}
