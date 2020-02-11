
public class GameOfLife {


    static String converter(String[][] cells) {
        String ans = "";
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

//        ans += generationPrint(w, h, grid);
//        ans += "\n";
        ans += nextGeneration(grid, w, h);
        return ans;
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

    // Function to print next generation
    static String nextGeneration(int[][] grid, int M, int N) {
        int[][] future = new int[M][N];

        // Loop through every cell
        for (int l = 1; l < M - 1; l++) {
            for (int m = 1; m < N - 1; m++) {
                // finding number of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];

                // The cell needs to be subtracted from its neighbours as it was counted before
                aliveNeighbours -= grid[l][m];

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;

                    // Cell dies due to over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                    // A new cell is born
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;

                    // Remains the same
                else
                    future[l][m] = grid[l][m];
            }
        }

        System.out.println("Next Generation");
        return generationPrint(M, N, future);
    }
}

