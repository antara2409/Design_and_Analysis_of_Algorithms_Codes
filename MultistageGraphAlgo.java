import java.util.*;

public class MultistageGraphAlgo {
// Result wrapper to hold cost and path 
    static class Result {
        int cost;
        List<Integer> path;
        // constructor
        Result(int cost, List<Integer> path) {
            this.cost = cost;
            this.path = path;
        }
    }
// Finding Minimum cost path method 
    public static Result solveMultistageGraph(int[][] graph, int numNodes) {
        int[] dp = new int[numNodes];
        int[] next = new int[numNodes];
        Arrays.fill(next, -1);
        dp[numNodes - 1] = 0;
// we use backward loop here as DP needs subproblems to be solved before the current problem which is not possible in forward loop
// last node will be numNodes-1 and we will process all nodes from second last node (numNodes-2) to source node
        for (int i = numNodes - 2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE; // initiallize dp
            for (int j = i + 1; j < numNodes; j++) { // each possible j from i which is reachable
                if (graph[i][j] != Integer.MAX_VALUE && dp[j] != Integer.MAX_VALUE) { // check if direct edge exist or not
                    int cost = graph[i][j] + dp[j]; // update cost
                    if (cost < dp[i]) { // get minimum cost 
                        dp[i] = cost;
                        next[i] = j; // store next index for current node
                    }
                }
            }
        }
// linked list to store path
        List<Integer> path = new ArrayList<>();
        int cur = 0;
        while (cur != -1) { // reconstruct the path
            path.add(cur);
            cur = next[cur];
        }
// dp[0] has minimum cost from source to destination
        return new Result(dp[0], path);
    }
// To generate graph
    public static int[][] generateRandomMultistageGraph(int numNodes, int maxEdgeWeight, long seed) {
        Random rand = new Random(seed); // using seed to allow output deterministic for testing 
        int[][] graph = new int[numNodes][numNodes];
        // fill all edges as no edge (max value)
        for (int i = 0; i < numNodes; i++)
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        // traverse on all nodes
        for (int i = 0; i < numNodes - 1; i++) {
            int maxNext = Math.min(numNodes, i + 3);  // connect one or two nodes ahead for multisatge structure
            for (int j = i + 1; j < maxNext; j++) { // reach nodes which should be reachable
                graph[i][j] = 1 + rand.nextInt(maxEdgeWeight); // non zero weigth of edge between j and i
            }
        }

        return graph;
    }
}
