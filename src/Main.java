import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

//        Tes GUI
        ArrayList<Obstacle> obstacleList = new ArrayList<>();

        Arena arena = new Arena(500, 500);

        Obstacle obstacle1 = new Obstacle(Obstacle.ObstacleType.SQUARE, 100, 100, 50, 300);
        Obstacle obstacle2 = new Obstacle(Obstacle.ObstacleType.RECTANGLE, 150, 100, 50, 450);
        Obstacle obstacle3 = new Obstacle(Obstacle.ObstacleType.RIGHT_TRIANGLE, 100, 150, 250, 400);

        obstacleList.add(obstacle1);
        obstacleList.add(obstacle2);
        obstacleList.add(obstacle3);

        arena.setObstacleList(obstacleList);

        arena.printObstacle();


//      Tes Djikstra
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Total Node: ");
//        int totalNode = scanner.nextInt();
//
//        System.out.println();
//
//        ShortestPath shortestPath = new ShortestPath(totalNode);
//        shortestPath.fillGraph(ShortestPath.INFINITY);
//
//        for (int i = 0; i < totalNode; i++) {
//            System.out.print("Node " + (i + 1) + "\n");
//            for (int j = 0; j < totalNode; j++) {
//                int value;
//                System.out.print("Distance to Node " + (j + 1) + ": ");
//                if(i == j)
//                    shortestPath.getGraph().get(i).set(j, 0);
//                if(shortestPath.getGraph().get(i).get(j) == ShortestPath.INFINITY && shortestPath.getGraph().get(j).get(i) == ShortestPath.INFINITY){
//                    value = scanner.nextInt();
//                    shortestPath.getGraph().get(i).set(j, value);
//                }
//                else{
//                    value = shortestPath.getGraph().get(j).get(i);
//                    shortestPath.getGraph().get(i).set(j, value);
//                    System.out.println(value);
//                }
//            }
//            System.out.println();
//        }
//
//        System.out.print("Start Node: ");
//        int startNode = scanner.nextInt();
//        shortestPath.setStartNode(startNode);
//
//
//        shortestPath.djikstra();
    }
}