package net.levbox.service;

import net.lewbox.model.Maze;
import net.lewbox.model.MazeCell;
import net.lewbox.model.MazeCellState;
import net.lewbox.service.impl.MazePathFinderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class MazeSolverMockServiceReturnSizeTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(MazeSolverMockServiceReturnSizeTestCase.class);

    @InjectMocks
    private MazePathFinderImpl mazePathFinder;

    private Long solvingTime;

    private Integer mazeSizeResult;

    @BeforeEach
    void calculateSolvingTime(){
        this.mazeSizeResult = solveMaze();
    }

    @Test
    void testSolvingMazeShouldReturnIntegerNonNull(){
        assertNotNull(this.mazeSizeResult);
    }

    @Test
    void testSolvingTestShouldBeLessThanTwoSeconds(){
        assertTrue(this.solvingTime<2);
    }

    private Integer solveMaze() {
       return findPath(returnMaze());
    }

    private Maze returnMaze() {
        Maze maze = new Maze(1000);

        //Cr�ation d'un labyrinth de taille 1000x1000 � partir d'une matrice triangulaire sup.
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                maze.getMaze()[i][j] = new MazeCell(i, j, null);
                if (j >= i)
                    maze.getMaze()[i][j].setCellState(MazeCellState.EMPTY);
                else
                    maze.getMaze()[i][j].setCellState(MazeCellState.WALL);
            }
        }

        //Entr�e � la cellule (0,0)
        maze.getMaze()[0][0].setCellState(MazeCellState.ENTRANCE);

        //Sortie � l'index (n-1, n-1)
        maze.getMaze()[999][999].setCellState(MazeCellState.EXIT);
        return maze;
    }

    private Integer findPath(Maze maze) {
        Date d1 = new Date();
        List<MazeCell> mazeCellPath = this.mazePathFinder.findOptimalPath(maze);
        Date d2 = new Date();
        this.solvingTime = (d2.getTime() - d1.getTime()) / 1000;
        LOG.info("Solving time is "+ this.solvingTime);
        return mazeCellPath.size();
    }

}
