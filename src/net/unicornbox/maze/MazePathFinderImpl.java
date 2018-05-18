package net.unicornbox.maze;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import net.unicornbox.maze.MazeCell.MazeCellState;

public class MazePathFinderImpl implements MazePathFinder {
  
    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };
    
    //La Méthode qui doit nécessairement être implémentée pour implémenter l'interface MathPathFinder. Cette méthode résout la solution
    @Override
    public List<MazeCell> findOptimalPath(Maze maze) {
        Map<MazeCell, MazeCell> parents = new HashMap<>();
        int n = maze.getMaze().length;
        int i,j;
        boolean[][] visited = new boolean[n][n];  
        Queue<MazeCell> q = new ArrayDeque<>();
        int minDist = 0;
        MazeCell target = maze.getMaze()[n-1][n-1];
       
        visited[0][0] = true;
        q.add(maze.getMaze()[0][0]);
        while (!q.isEmpty())
        {
            MazeCell mazeCell = q.poll();
            i = mazeCell.getX();
            j = mazeCell.getY();

            for (int k = 0; k < 4; k++)
            {
                int posX = i + row[k];
                int posY = j + col[k];
                
                //Vérifier si la cellule est valide pour être visité et exploité.
                
                if (isValid(maze, visited, posX, posY, n))
                {
                    visited[i + row[k]][j + col[k]] = true;
                    MazeCell mazeCellChild = maze.getMaze()[i + row[k]][j + col[k]];
                    q.add(maze.getMaze()[i + row[k]][j + col[k]]);
                    if (!parents.containsKey(mazeCellChild)) {
                        parents.put(mazeCellChild, mazeCell);
                    }
                    
                }
            }
        }
       
        maze.setOptimalPathLength(constructPath(target, parents, minDist).size());
        return constructPath(target, parents, minDist);
      
    }
    
    //Construction du chemin de (0,0) à (n-1,n-1)
    private List<MazeCell> constructPath(MazeCell target, Map<MazeCell,MazeCell> parents, int minDist) {
        MazeCell current = target;
        final List<MazeCell> path = new ArrayList<>();

        while (current != null) {
            path.add(current);
            current = parents.get(current);
            minDist++;
        }
        System.out.println("The path's length is " +minDist);
        Collections.reverse(path);
        return path;
    }

    //tester si la cellule i,j est valide, (si ce n'est pas un mur)
     private static boolean isValid(Maze maze, boolean visited[][], int i, int j, int n)
        {
            
           if((i >= 0) && (i < n) && (j >= 0) && (j < n)
                           && visited[i][j] != true){
               MazeCell mazeCell = maze.getMaze()[i][j];
               if(mazeCell.getCellState() == MazeCellState.EMPTY || mazeCell.getCellState() == MazeCellState.EXIT ){
                   return true;
               }
           }
        return false;
        }
  
    
}

