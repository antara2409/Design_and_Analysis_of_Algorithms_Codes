import java.util.*;

public class MinPathSumTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        System.out.println("Enter grid values :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
// Dynamic Programming result
        System.out.println("\nDynamic Programming Approach:");
        List<int[]> dpPath = MinPathSum.minPathSumDP(grid);
        MinPathSum.printPath(dpPath);
        System.out.println("Minimum path sum (DP): " + MinPathSum.calculatePathSum(dpPath, grid));
// Greedy result
        System.out.println("\nGreedy Approach:");
        List<int[]> greedyPath = MinPathSum.minPathSumGreedy(grid);
        MinPathSum.printPath(greedyPath);
        System.out.println("Path sum (Greedy): " + MinPathSum.calculatePathSum(greedyPath, grid));

        sc.close();
    }
}
