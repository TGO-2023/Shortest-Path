import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {

    private static void createAndShowGui(Arena arena) {
        int padding = 25;
        int labelPadding = 25;
        int pointWidth = 6;

        Color lineColor = new Color(44, 102, 230, 180);
        Color pointColor = new Color(100, 100, 100, 180);
        Color gridColor = new Color(200, 200, 200, 200);

        List<Double> scores = new ArrayList<>();
        Random random = new Random();
        int maxDataPoints = 40;
        int maxScore = 10;

        for (int i = 0; i < maxDataPoints; i++) {
            scores.add((double) random.nextDouble() * maxScore);
        }

        MainWindow mainPanel = new MainWindow(scores, padding, labelPadding, pointWidth, lineColor, pointColor, gridColor, arena.getObstacleList());
        mainPanel.setPreferredSize(new Dimension(arena.getxBoundary(), arena.getyBoundary()));
        JFrame frame = new JFrame("Draw Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
//        Tes GUI
        ArrayList<Obstacle> obstacleList = new ArrayList<>();

        Arena arena = new Arena(800, 800);

        Obstacle obstacle1 = new Obstacle(Obstacle.ObstacleType.SQUARE, 100, 100, 50, 300);
        Obstacle obstacle2 = new Obstacle(Obstacle.ObstacleType.RECTANGLE, 150, 100, 50, 450);
        Obstacle obstacle3 = new Obstacle(Obstacle.ObstacleType.RIGHT_TRIANGLE, 100, 150, 250, 400);

        obstacleList.add(obstacle1);
        obstacleList.add(obstacle2);
        obstacleList.add(obstacle3);

        arena.setObstacleList(obstacleList);

        SwingUtilities.invokeLater(() -> createAndShowGui(arena));

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