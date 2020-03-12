import java.util.Random;

public class Game {

    public static void main(String[] args) {
        int M = 10, N = 10;
        // Initializing the grid.

        int[][] grid = new int[N][M]; //Declaring the array
        Random number = new Random(); //Creating the random generator object

        // Displaying the grid
        System.out.println("Original Generation");

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                // Initializing the grids
                grid[row][col] = number.nextInt(2);
                if (grid[row][col] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, M, N);
    }


    // Function to print next generation
    public static void nextGeneration(int grid[][], int M, int N) {
        int[][] future = new int[M][N];

        // Go through every cell
        for (int l = 1; l < M - 1; l++) {
            for (int m = 1; m < N - 1; m++) {
                // Checking Alive neighbours
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];
                // Subtract cells from neighbours that was countered before
                aliveNeighbours -= grid[l][m];


                // Implementing the Rules of Life

                // Under population
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;

                    // Over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                    // Resurrection
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;

                    // Change nothing
                else
                    future[l][m] = grid[l][m];
            }
        }

        //Display next generation
        System.out.println("Next Generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (future[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }
}

