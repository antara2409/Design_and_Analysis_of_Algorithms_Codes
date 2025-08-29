import java.util.*;
public class MinPathSum {
// Dynamic Programming approach
    public static List<int[]> minPathSumDP(int[][] grid) {
        int n = grid.length, m = grid[0].length; // n is number of rows and m is number of columns
        int[][] dp = new int[n][m];// create dp

        dp[0][0] = grid[0][0];
        for (int j = 1; j < m; j++) 
            dp[0][j] = dp[0][j - 1] + grid[0][j]; //Since we can only move right or down, for the first row, 
            //the only way to reach (0,j) is to reach (0,j-1)

        for (int i = 1; i < n; i++) 
            dp[i][0] = dp[i - 1][0] + grid[i][0]; //Similar to row 0 logic, only way to reach (i,0) is (i-1,0)

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]); // To reach (i,j) we need to reach from either 
                // (i-1,j) or (i,j-1) whichever is minimum

        List<int[]> path = new ArrayList<>(); // To store path 
        int i = n - 1, j = m - 1; // start from bottom right end
        path.add(new int[]{i, j}); // add (i,j) to path
        while (i > 0 || j > 0) {
            if (i == 0) // move left
                j--;
            else if (j == 0) // move up
                i--;
            else if (dp[i - 1][j] < dp[i][j - 1]) // move up
                i--;
            else 
                j--; // move left
            path.add(new int[]{i, j}); // add (i,j) to path
        }
        Collections.reverse(path); // reverse path
        return path; 
    }
// Greedy approach
    public static List<int[]> minPathSumGreedy(int[][] grid) {
        int n = grid.length, m = grid[0].length; // n is number of rows and m is number of columns
        List<int[]> path = new ArrayList<>();
        int i = 0, j = 0; // start from top left corner
        path.add(new int[]{i, j}); // add (i,j) to path

        while (i != n - 1 || j != m - 1) {
            if (i == n - 1) // move right
                j++;
            else if (j == m - 1) // move down
                    i++;
            else {
                if (grid[i + 1][j] < grid[i][j + 1]) // move down
                    i++;
                else 
                    j++; // move right
            }
            path.add(new int[]{i, j}); // add (i,j) to path
        }
        return path;
    }
    public static int calculatePathSum(List<int[]> path, int[][] grid) {
        int sum = 0;
        for (int[] cell : path) {
            sum += grid[cell[0]][cell[1]]; // add all visited values
        }
        return sum;
    }
    public static void printPath(List<int[]> path) {
        for (int[] cell : path) {
            System.out.printf("(%d, %d) -> ", cell[0], cell[1]); // print visited cells
        }
        System.out.println("end");
    }
}
