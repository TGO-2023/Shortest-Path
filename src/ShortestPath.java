import java.util.ArrayList;

public class ShortestPath {
    public static final int INFINITY = 9999;
    private final ArrayList<ArrayList<Double>> graph = new ArrayList<>();
    private final ArrayList<ArrayList<Double>> cost = new ArrayList<>();
    private final ArrayList<Double> distance = new ArrayList<>();
    private final ArrayList<Integer> prediction = new ArrayList<>();
    private final ArrayList<Boolean> visited = new ArrayList<>();
    private int nextNode;
    private final int startNode;
    private final double totalNode;

    public ShortestPath(double totalNode){
        this.startNode = 0;
        this.totalNode = totalNode;
    }

    public void fillGraph(double value){
        for (int i = 0; i < this.totalNode; i++) {
            ArrayList<Double> arrayList = new ArrayList<>();
            for (int j = 0; j < this.totalNode; j++)
                arrayList.add(value);
            this.graph.add(arrayList);
        }
    }

    public void fillCost(double value){
        for (int i = 0; i < this.totalNode; i++) {
            ArrayList<Double> arrayList = new ArrayList<>();
            for (int j = 0; j < this.totalNode; j++) {
                if(this.graph.get(i).get(j) == 0)
                    arrayList.add(value);
                else
                    arrayList.add(this.graph.get(i).get(j));
            }
            this.cost.add(arrayList);
        }
    }

    public void djikstra(){
        fillCost(INFINITY);
        for (int i = 0; i < this.totalNode; i++) {
            this.distance.add(this.cost.get(this.startNode).get(i));
            this.prediction.add(this.startNode);
            this.visited.add(false);
        }

        this.distance.set(this.startNode, 0d);
        this.visited.set(this.startNode, true);
        int count = 1;

        while(count < this.totalNode - 1){
            double minDistance = INFINITY;

            for (int i = 0; i < this.totalNode; i++) {
                if (this.distance.get(i) < minDistance && !this.visited.get(i)){
                    minDistance = this.distance.get(i);
                    this.nextNode = i;
                }
            }

            this.visited.set(this.nextNode, true);

            for (int i = 0; i < this.totalNode; i++) {
                if(!this.visited.get(i)){
                    if(minDistance + this.cost.get(this.nextNode).get(i) < this.distance.get(i)){
                        this.distance.set(i, minDistance + this.cost.get(this.nextNode).get(i));
                        this.prediction.set(i, this.nextNode);
                    }
                }
            }

            count++;
        }
    }

    public void printGraph(){
        int index = 1;
        for (ArrayList<Double> row : this.graph) {
            System.out.print(index + "-> [ ");
            for (Double column: row) {
                if(column == 0d || column % 1 == 0){
                    System.out.print(String.format("%.0f", column) + " ");
                } else {
                    System.out.print(String.format("%.2f", column) + " ");
                }
            }
            System.out.println("]");
            index++;
        }
    }

    public ArrayList<Double> getDistance() {
        return distance;
    }

    public ArrayList<ArrayList<Double>> getGraph() {
        return graph;
    }
}
