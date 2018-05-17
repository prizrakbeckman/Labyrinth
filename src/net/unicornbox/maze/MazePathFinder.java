package net.unicornbox.maze;

import java.util.List;

public interface MazePathFinder
{
    List<MazeCell> findOptimalPath(Maze maze);
}
