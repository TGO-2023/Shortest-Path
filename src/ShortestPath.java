import java.util.ArrayList;

public class ShortestPath {
    public static final int INFINITY = 9999;
    private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> cost = new ArrayList<>();
    private ArrayList<Integer> distance = new ArrayList<>();
    private ArrayList<Integer> prediction = new ArrayList<>();
    private ArrayList<Boolean> visited = new ArrayList<>();
    private int count;
    private int minDistance;
    private int nextNode;
    private int startNode;
    private int totalNode;

    public ShortestPath(int totalNode){
        this.startNode = 0;
        this.totalNode = totalNode;
    }

    public void fillGraph(int value){
        for (int i = 0; i < this.totalNode; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < this.totalNode; j++)
                arrayList.add(value);
            this.graph.add(arrayList);
        }
    }

    public void fillCost(int value){
        for (int i = 0; i < this.totalNode; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
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

        this.distance.set(this.startNode, 0);
        this.visited.set(this.startNode, true);
        this.count = 1;

        while(this.count < this.totalNode - 1){
            this.minDistance = INFINITY;

            for (int i = 0; i < this.totalNode; i++) {
                if (this.distance.get(i) < this.minDistance && !this.visited.get(i)){
                    this.minDistance = this.distance.get(i);
                    this.nextNode = i;
                }
            }

            this.visited.set(this.nextNode, true);

            for (int i = 0; i < this.totalNode; i++) {
                if(!this.visited.get(i)){
                    if(this.minDistance + this.cost.get(this.nextNode).get(i) < this.distance.get(i)){
                        this.distance.set(i, this.minDistance + this.cost.get(this.nextNode).get(i));
                        this.prediction.set(i, this.nextNode);
                    }
                }
            }

            this.count++;
        }

        printSolution();
    }

    public void printSolution(){
        for (int i = 0; i < this.totalNode; i++) {
            if(i != this.startNode)
                System.out.println("Distance from source to " + (i + 1) + ": " + this.distance.get(i));
        }
    }

    public void printGraph(){
        int index = 1;
        System.out.println("Graph: ");
        for (ArrayList<Integer> row : this.graph) {
            System.out.print(index + "-> [ ");
            for (Integer column: row) {
                System.out.print(column + " ");
            }
            System.out.println("]");
            index++;
        }
    }

    public void printCost(){
        System.out.println("Cost: ");
        for (ArrayList<Integer> row : this.cost) {
            System.out.print("[ ");
            for (Integer column: row) {
                System.out.print(column + " ");
            }
            System.out.println("]");
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph() {
        return graph;
    }
    public void setGraph(ArrayList<ArrayList<Integer>> graph) {
        this.graph = graph;
    }
    public int getStartNode() {
        return startNode;
    }
    public void setStartNode(int startNode) {
        if(startNode > 0)
            this.startNode = startNode - 1;
        else
            this.startNode = startNode;
    }
    public int getTotalNode() {
        return totalNode;
    }
    public void setTotalNode(int totalNode) {
        this.totalNode = totalNode;
    }
}
