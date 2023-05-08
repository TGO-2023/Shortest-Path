import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Main {

    private static void createAndShowGui(Arena arena) {
        // Setting for margin and padding in GUI
        int padding = 25;
        int labelPadding = 25;
        int numberDivisions = 11;

        // Setting for points width in GUI
        int pointWidth = 6;

        // Setting for color in GUI
        Color lineColor = new Color(44, 102, 230, 180);
        Color pointColor = new Color(100, 100, 100, 180);
        Color gridColor = new Color(200, 200, 200, 200);
        Color pointSourceColor = new Color(0,255,0);
        Color pointGoalColor = new Color(220,20,60);

        MainWindow mainPanel = new MainWindow(padding, labelPadding, pointWidth, lineColor,
                pointColor, gridColor, pointSourceColor, pointGoalColor,
                arena.getObstacleList(), numberDivisions);

        // Setting for default Frame GUI
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

        SwingUtilities.invokeLater(() -> createAndShowGui(arena));
    }
}