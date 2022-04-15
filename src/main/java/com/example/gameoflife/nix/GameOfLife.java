package com.example.gameoflife.nix;


public class GameOfLife {
    public static void main(String[] args) {
        int m = 25, n = 25;

        // Initializing the grid pattern
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        System.out.println("Original Generation");
        Utils.printGeneration(m, n, grid);

        boolean isSameGrid = false;

        while (!isSameGrid) {
            int[][] nextGrid = nextGeneration(grid, m, n);
            isSameGrid = Utils.isSameGrid(grid, nextGrid);
            grid = nextGrid;
        }
    }

    static int[][] nextGeneration(int[][] grid, int M, int N) {
        int[][] future = new int[M][N];

        for (int rowIndex = 0; rowIndex < M; rowIndex++) {
            for (int columnIndex = 0; columnIndex < N; columnIndex++) {
                // count alive neighbours
                int aliveNeighboursCounter = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if ((rowIndex + i >= 0 && rowIndex + i < M) && (columnIndex + j >= 0 && columnIndex + j < N))
                            aliveNeighboursCounter += grid[rowIndex + i][columnIndex + j];

                // The main cell needs to be subtracted from neighbours counter
                aliveNeighboursCounter -= grid[rowIndex][columnIndex];
                // Implementing the Rules of Life
                if (LifeRules.isUnderpopulation(grid[rowIndex][columnIndex], aliveNeighboursCounter))
                    future[rowIndex][columnIndex] = 0;
                else if (LifeRules.isOvercrowding(grid[rowIndex][columnIndex], aliveNeighboursCounter))
                    future[rowIndex][columnIndex] = 0;
                else if (LifeRules.isReproduction(grid[rowIndex][columnIndex], aliveNeighboursCounter))
                    future[rowIndex][columnIndex] = 1;
                    // All other cases, cell remains the same
                else
                    future[rowIndex][columnIndex] = grid[rowIndex][columnIndex];
            }
        }

        System.out.println("Next Generation");
        Utils.printGeneration(M, N, future);
        return future;
    }

    static class LifeRules {
        //dead cell with exactly three live neighbors becomes a live cell
        private static boolean isReproduction(int cell, int aliveNeighbours) {
            return (cell == 0) && (aliveNeighbours == 3);
        }

        //live cell with more than three live neighbors dies
        private static boolean isOvercrowding(int cell, int aliveNeighbours) {
            return (cell == 1) && (aliveNeighbours > 3);
        }

        //live cell with fewer than two live neighbors dies
        private static boolean isUnderpopulation(int cell, int aliveNeighbours) {
            return (cell == 1) && (aliveNeighbours < 2);
        }
    }


    static class Utils {
        private static void printGeneration(int m, int n, int[][] generation) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (generation[i][j] == 0)
                        System.out.print("-");
                    else
                        System.out.print("+");
                }
                System.out.println();
            }
        }

        private static boolean isSameGrid(int[][] oldGrid, int[][] newGrid) {
            boolean sameGrid = true;

            for (int i = 0; i < oldGrid.length; i++)
                for (int j = 0; j < oldGrid[i].length; j++)
                    if (oldGrid[i][j] != newGrid[i][j]) {
                        sameGrid = false;
                        break;
                    }

            return sameGrid;
        }
    }

}