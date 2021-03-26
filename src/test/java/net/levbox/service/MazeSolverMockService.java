package java.net.levbox.service;


import net.lewbox.model.Maze;
import net.lewbox.model.MazeCell;
import net.lewbox.model.MazeCellState;
import net.lewbox.service.MazePathFinder;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MazeSolverMockService {

    @Mock
    private final MazePathFinder mazePathFinder;

    private Long solvingTime;

    public MazeSolverMockService(MazePathFinder mazePathFinder) {
        this.mazePathFinder = mazePathFinder;
    }

    @Test
    void testSolvingMazeShouldReturnIntegerNonNull(){
        assertNotNull(solveMaze());
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
        return mazeCellPath.size();
    }

}
