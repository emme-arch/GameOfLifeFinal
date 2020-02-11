public class GameOfLife {
    static String converter(String[][] cells) {
        int w = 10, h = 10;
        int[][] grid = new int[w][h];

        for (int i = 0; i < 10; i++) {
            for (int x = 0; x < 10; x++) {
                if (cells[i][x].equals("+")) {
                    grid[i][x] = 0;
                } else grid[i][x] = 1;
            }
        }
        System.out.println("Original Generation");
        System.out.println(generationPrint(w, h, grid));
        System.out.println();
        System.out.println(nextGeneration(grid, w, h));
        return nextGeneration(grid, w, h);
    }

    // Output with + and #
    static String generationPrint(int m, int n, int[][] grid) {
        StringBuilder Generation = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    Generation.append("+");
                else
                    Generation.append("#");
            }
            Generation.append("\n");
        }
        return String.valueOf(Generation);
    }

    // Printing next generation
    static String nextGeneration(int[][] grid, int x, int y) {
        int[][] nextGen = new int[x][y];
        // Checking every cell
        for (int l = 1; l < x - 1; l++) {
            for (int m = 1; m < y - 1; m++) {
                // finding number of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];
                aliveNeighbours -= grid[l][m];
                //solo cells
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    nextGen[l][m] = 0;
                    //over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    nextGen[l][m] = 0;
                    //New Cell
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    nextGen[l][m] = 1;
                    //No change
                else
                    nextGen[l][m] = grid[l][m];
            }
        }
        System.out.println("Next Generation");
        return generationPrint(x, y, nextGen);
    }
}

