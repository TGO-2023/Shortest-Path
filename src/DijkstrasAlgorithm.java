// A Java program for Dijkstra's
// single source shortest path
// algorithm. The program is for
// adjacency matrix representation
// of the graph.

class DijkstrasAlgorithm {

    private static final int NO_PARENT = -1;

    private static void dijkstra(double[][] adjacencyMatrix,
                                 int startVertex)
    {
        int nVertices = adjacencyMatrix[0].length;

        double[] shortestDistances = new double[nVertices];

        boolean[] added = new boolean[nVertices];

        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        shortestDistances[startVertex] = 0;

        int[] parents = new int[nVertices];

        parents[startVertex] = NO_PARENT;

        for (int i = 1; i < nVertices; i++)
        {
            int nearestVertex = -1;
            double shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            added[nearestVertex] = true;

            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                double edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                            edgeDistance;
                }
            }
        }

        printSolution(startVertex, shortestDistances, parents);
    }

    private static void printSolution(int startVertex, double[] distances, int[] parents)
    {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0;
             vertexIndex < nVertices;
             vertexIndex++)
        {
            if (vertexIndex != startVertex)
            {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }

    private static void printPath(int currentVertex, int[] parents)
    {
        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }

    // Driver Code
    public static void main(String[] args)
    {
        double[][] adjacencyMatrix = { { 0, 353.55, 403.11, 452.77, 0, 494.97, 0, 602.08, 471.70, 0, 0, 502.49, 0, 602.08, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 353.55, 0, 150, 100, 0, 300, 0, 0, 0, 0, 0, 150, 0, 250, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 403.11, 150, 0, 180.28, 100, 150, 0, 0, 70.71, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 452.77, 100, 180.28, 0, 150, 316.23, 0, 0, 206.16, 0, 0, 50, 111.80, 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 100, 150, 0, 0, 0, 0, 70.71, 0, 0, 158.11, 70.71, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 494.97, 300, 150, 316.23, 0, 0, 50, 111.80, 111.80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 150, 0, 0, 0, 0, 0, 200, 0, 300, 254.95, 269.26, 0, 0, 602.08 },
                { 602.08, 0, 0, 0, 0, 111.80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 531.51 },
                { 471.70, 0, 70.71, 206.16, 70.71, 111.80, 0, 0, 0, 0, 0, 0, 141.42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 0, 206.16, 111.80, 70.71, 111.80, 0, 0, 0, 223.61, 0, 0, 604.15 },
                { 0, 0, 0, 0, 0, 0, 150, 0, 0, 100, 0, 0, 0, 304.14, 206.16, 158.11, 50, 0, 150, 111.80, 141.42, 0, 0, 514.78 },
                { 502.49, 150, 0, 50, 158.11, 0, 0, 0, 0, 0, 0, 0, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 111.80, 70.71, 0, 0, 0, 141.42, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 602.08, 250, 0, 150, 0, 0, 0, 0, 0, 206.16, 304.14, 100, 0, 0, 100, 150, 300, 180.28, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 111.80, 206.16, 0, 0, 100, 0, 50, 200, 111.80, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 70.71, 158.11, 0, 0, 150, 50, 0, 150, 100, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 200, 0, 0, 111.80, 50, 0, 0, 300, 200, 150, 0, 180.28, 100, 70.71, 111.80, 0, 0, 492.44 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 180.28, 111.80, 100, 180.28, 0, 150, 206.16, 0, 206.16, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 300, 0, 0, 0, 150, 0, 0, 0, 0, 0, 100, 150, 0, 70.71, 111.80, 70.71, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 254.95, 0, 0, 0, 111.80, 0, 0, 0, 0, 0, 70.71, 206.16, 70.71, 0, 50, 100, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 269.26, 0, 0, 223.61, 141.42, 0, 0, 0, 0, 0, 111.80, 0, 111.80, 50, 0, 111.80, 100, 380.79 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 206.16, 70.71, 100, 111.80, 0, 50, 403.11 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 50, 0, 353.55 },
                { 0, 0, 0, 0, 0, 0, 602.08, 531.51, 0, 604.15, 514.78, 0, 0, 0, 0, 0, 492.44, 0, 0, 0, 380.79, 403.11, 353.55, 0 } };
        dijkstra(adjacencyMatrix, 0);
    }
}
