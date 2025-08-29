public class MultistageGraphAlgoTest {
    public static void main(String[] args) {
        int numNodes = 14; // 14 nodes
        int maxEdgeWeight = 20; // set boundary to generate graph adjancy matrix
        long seed = 1234; // set seed for repeatative output

        int[][] graph = MultistageGraphAlgo.generateRandomMultistageGraph(numNodes, maxEdgeWeight, seed); //generate graph

        System.out.println("Generated Graph Adjacency Matrix :"); // print graph
        for(int i=0; i<numNodes; i++){
            for(int j=0; j<numNodes; j++){
                if(graph[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        MultistageGraphAlgo.Result result = MultistageGraphAlgo.solveMultistageGraph(graph, numNodes); // get minimum cost path
        System.out.println("\nMinimum cost from source to sink: " + result.cost);
        System.out.print("Optimal path: ");
        for(int node : result.path){
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
