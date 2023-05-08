import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int xDimension;
    private final int yDimension;
    private final Points source;
    private final Points goals;

    private ArrayList<Obstacle> obstacleList = new ArrayList<>();
    List<Edge> visibilityGraph = new ArrayList<>();


    public Arena(int xBoundary, int yBoundary){
        this.xDimension = xBoundary;
        this.yDimension = yBoundary;
        this.source = new Points(0, yBoundary, "Source");
        this.goals = new Points(xBoundary, 0, "Goals");
    }

    public void buildGraph(){
        List<Points> allPoints = getAllPoints();
        this.visibilityGraph = VisibilityGraphAlgorithm.buildVisibilityGraph(allPoints);

        ShortestPath shortestPath = new ShortestPath(allPoints.size());
        shortestPath.fillGraph(ShortestPath.INFINITY);

        System.out.println("---List of Worthy Edge in Arena---");

        for (Edge edge : this.visibilityGraph) {
            System.out.println(edge.sourceName + "(" + (edge.src + 1) + ") to " +
                    edge.destinationName + "(" + (edge.dest + 1) +"), Weight: " + String.format("%.2f", edge.weight));

            shortestPath.getGraph().get(edge.src).set(edge.dest, edge.weight);
            shortestPath.getGraph().get(edge.dest).set(edge.src, edge.weight);
            shortestPath.getGraph().get(edge.src).set(edge.src, 0d);
        }
        System.out.println();
        System.out.println("---Graph---");
        shortestPath.printGraph();

        System.out.println();
        System.out.println("---Statistic---");
        System.out.println("Total Nodes : " + allPoints.size());
        System.out.println("Total Worthy Edge : " + this.visibilityGraph.size());
        shortestPath.djikstra();
        System.out.println("Distance from source to goals: " + shortestPath.getDistance().get(allPoints.size() - 1));
    }

    public void printObstacle(){
        int index = 1;
        System.out.println("---Obstacle---");
        for (Obstacle obstacle: this.obstacleList) {
            System.out.println(index + ". " + obstacle.getObstacleType() + ": ");
            for (Points points : obstacle.getCoordinate()) {
                System.out.println("x: " + points.x + ", y: " + points.y);
            }
            System.out.println();
            index++;
        }
    }

    public List<Points> getAllPoints(){
        List<Points> allPoints = new ArrayList<>();
        allPoints.add(source);

        for (Obstacle obstacle : this.obstacleList) {
            allPoints.addAll(obstacle.getCoordinate());
        }

        allPoints.add(goals);
        return allPoints;
    }

    public int getXDimension() {
        return xDimension;
    }
    public int getYDimension() {
        return yDimension;
    }
    public ArrayList<Obstacle> getObstacleList() {
        return obstacleList;
    }
    public void setObstacleList(ArrayList<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
    }
}
