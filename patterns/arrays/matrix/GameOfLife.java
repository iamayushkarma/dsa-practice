package patterns.arrays.matrix;

/**
 * Problem : Game of Life
 * LeetCode : 289
 * Link: https://leetcode.com/problems/game-of-life/
 * Pattern : Matrix Traversal / In-Place State Encoding
 * Difficulty : Medium
 * Date Solved: 18-10-2026
 * Revision : [ ] Day3 [ ] Day7 [ ] Day14
 *
 * My Approach:
 * - Used two nested loops to visit every cell in the matrix.
 * - Created a countNeighbors() function to count the live neighbors
 * of each cell by examining its surrounding 3 x 3 area.
 * - Skipped the current cell and checked matrix boundaries before
 * accessing neighboring cells.
 * - Used four values to encode the original and next states:
 * 0 -> Originally dead, remains dead.
 * 1 -> Originally alive, remains alive.
 * 2 -> Originally dead, becomes alive.
 * 3 -> Originally alive, becomes dead.
 * - Used board[x][y] % 2 == 1 to identify cells that were originally
 * alive, including cells already encoded as 3.
 * - Applied the Game of Life rules and encoded state changes without
 * immediately overwriting the original state.
 * - Traversed the matrix a second time to convert encoded values
 * into their final states:
 * 2 -> 1
 * 3 -> 0
 *
 * Pattern Insight:
 * - In-place state encoding allows us to store the original state
 * and the next state in the same matrix.
 * - The original state must remain accessible until every cell has
 * been processed because all cells update simultaneously.
 * - Values 1 and 3 represent cells that were originally alive.
 * - Values 0 and 2 represent cells that were originally dead.
 * - The modulo operation helps recover the original state:
 * board[x][y] % 2 == 1 -> Originally alive.
 * - This technique avoids creating an additional matrix and reduces
 * auxiliary space from O(n * m) to O(1).
 *
 * Mistake I Made:
 * - Initially checked board[i][j] instead of board[x][y] while
 * counting neighbors.
 * - Used incorrect boundary conditions for neighboring cells.
 * - Applied the Game of Life rules without distinguishing between
 * currently alive and currently dead cells.
 * - Initially struggled to understand why values 2 and 3 were needed.
 * - Learned that state encoding preserves the original state while
 * recording the next state in the same matrix.
 *
 * Time Complexity: O(n * m)
 * - Each cell examines at most eight neighbors, which takes O(1) time.
 * - The first pass processes all cells, and the second pass converts
 * encoded states into their final values.
 *
 * Space Complexity: O(1) auxiliary space.
 * - The original matrix is modified in place.
 * - No additional matrix or data structure is created.
 */

public class GameOfLife {

    public static void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        // First pass: Calculate next states using in-place encoding.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int liveNeighbors = countNeighbors(board, i, j);

                // Originally alive
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 3; // Alive -> Dead
                    }
                }

                // Originally dead
                else if (liveNeighbors == 3) {
                    board[i][j] = 2; // Dead -> Alive
                }
            }
        }

        // Second pass: Convert encoded states into final states.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int countNeighbors(int[][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        int liveNeighbors = 0;

        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {

                // Skip the current cell.
                if (x == i && y == j) {
                    continue;
                }

                // Ensure the neighbor is inside the matrix.
                if (x >= 0 && x < n && y >= 0 && y < m) {

                    // Odd values 1 and 3 represent originally alive cells.
                    if (board[x][y] % 2 == 1) {
                        liveNeighbors++;
                    }
                }
            }
        }

        return liveNeighbors;
    }

    public static void main(String[] args) {
        int[][] board = {
                { 0, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 0 }
        };

        gameOfLife(board);

        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}