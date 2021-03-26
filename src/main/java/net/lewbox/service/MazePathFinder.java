package net.lewbox.service;

import java.util.List;
import net.lewbox.model.Maze;
import net.lewbox.model.MazeCell;

public interface MazePathFinder
{
    List<MazeCell> findOptimalPath(Maze maze);
}
