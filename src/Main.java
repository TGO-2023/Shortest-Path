import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
            scores.add(random.nextDouble() * maxScore);
        }

        MainWindow mainPanel = new MainWindow(scores, padding, labelPadding, pointWidth, lineColor, pointColor, gridColor, arena.getObstacleList());
        mainPanel.setPreferredSize(new Dimension(arena.getXDimension(), arena.getYDimension()));
        JFrame frame = new JFrame("Draw Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ArrayList<Obstacle> obstacleList = new ArrayList<>();

        Arena arena = new Arena(800, 800);

        Obstacle obstacle1 = new Obstacle(Obstacle.ObstacleType.RECTANGLE, 100, 150, 50, 450, "Obstacle 1");
        Obstacle obstacle2 = new Obstacle(Obstacle.ObstacleType.RIGHT_TRIANGLE, 50, 100, 350, 450, "Obstacle 2");
        Obstacle obstacle3 = new Obstacle(Obstacle.ObstacleType.RIGHT_TRIANGLE, 150, 100, 250, 400, "Obstacle 3");
        Obstacle obstacle4 = new Obstacle(Obstacle.ObstacleType.SQUARE, 100, 100, 50, 300, "Obstacle 4");
        Obstacle obstacle5 = new Obstacle(Obstacle.ObstacleType.RECTANGLE, 100, 150, 200, 200, "Obstacle 5");
        Obstacle obstacle6 = new Obstacle(Obstacle.ObstacleType.RECTANGLE, 100, 50, 400, 150, "Obstacle 6");

        obstacleList.add(obstacle1);
        obstacleList.add(obstacle2);
        obstacleList.add(obstacle3);
        obstacleList.add(obstacle4);
        obstacleList.add(obstacle5);
        obstacleList.add(obstacle6);

        arena.setObstacleList(obstacleList);

        arena.printObstacle();

        arena.buildGraph();

//        SwingUtilities.invokeLater(() -> createAndShowGui(arena));
    }
}