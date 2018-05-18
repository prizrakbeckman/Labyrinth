package net.unicornbox.maze;

import java.util.Date;
import java.util.List;

import net.unicornbox.maze.MazeCell.MazeCellState;

public class Test {
	
	
	public static void main(String[] args) {
		MazePathFinder mazePathFinder = new MazePathFinderImpl();
		Maze maze = new Maze(1000);
		
		//Création d'un labyrinth de taille 1000x1000 à partir d'une matrice triangulaire sup.
		for(int i=0;i<1000;i++){
			for(int j=0;j<1000;j++) {
				maze.getMaze()[i][j] = new MazeCell(i, j,null);
				if(j>=i)
					maze.getMaze()[i][j].setCellState(MazeCellState.EMPTY);
				else
					maze.getMaze()[i][j].setCellState(MazeCellState.WALL);
			}
		}
				
		//Entrée à la cellule (0,0)
		maze.getMaze()[0][0].setCellState(MazeCellState.ENTRANCE);
		
		//Sortie à l'index (n-1, n-1)
		maze.getMaze()[999][999].setCellState(MazeCellState.EXIT);
		
		Date d1 = new Date();
		List<MazeCell> mazeCellPath = mazePathFinder.findOptimalPath(maze);
		Date d2 = new Date();
		long seconds = (d2.getTime()-d1.getTime())/1000; 
		System.err.println(mazeCellPath.size());
		
	}

}
