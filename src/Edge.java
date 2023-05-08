public class Edge {
    public int src;
    public int dest;
    public double weight;
    public String sourceName;
    public String destinationName;

    public Edge(int src, int dest, double weight, String sourceName, String destinationName) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
        this.sourceName = sourceName;
        this.destinationName = destinationName;
    }
}
