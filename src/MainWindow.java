import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JPanel {
    private final int padding;
    private final int labelPadding;
    private Color lineColor;
    private Color pointColor;
    private Color pointGoalColor;
    private Color pointSourceColor;

    private final Color gridColor;
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private final int pointWidth;

    private int numberDivisions = 11;

    private List<Obstacle> obstaclesList;

    public MainWindow(int padding, int labelPadding,
                      int pointWidth, Color lineColor, Color pointColor,
                      Color gridColor, Color pointSourceColor, Color pointGoalColor,
                      List<Obstacle> obstaclesList, int numberDivisions) {
        this.padding = padding;
        this.labelPadding = labelPadding;
        this.pointWidth = pointWidth;
        this.lineColor = lineColor;
        this.pointColor = pointColor;
        this.gridColor = gridColor;
        this.obstaclesList = obstaclesList;
        this.numberDivisions = numberDivisions;
        this.pointSourceColor = pointSourceColor;
        this.pointGoalColor = pointGoalColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw white background
        g2.setColor(Color.WHITE);
        g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding) - labelPadding, getHeight() - 2 * padding - labelPadding);
        g2.setColor(Color.BLACK);

        int value = 0;

        // Create hatch marks and grid lines for y-axis.
        for (int i = 0; i < numberDivisions; i++) {
            int x0 = padding + labelPadding;
            int x1 = pointWidth + padding + labelPadding;
            int y0 = getHeight() - ((i * (getHeight() - padding * 2 - labelPadding)) / numberDivisions + padding + labelPadding);
            int y1 = y0;
            g2.setColor(gridColor);
            g2.drawLine(padding + labelPadding + 1 + pointWidth, y0, getWidth() - padding, y1);
            g2.setColor(Color.BLACK);

            if(value != 0){
                String yLabel = value + "";
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
            }

            g2.drawLine(x0, y0, x1, y1);
            value += 50;
        }

        // Create hatch marks and grid lines for x-axis.
        value = 0;
        for (int i = 0; i < numberDivisions; i++) {
            int x0 = i * (getWidth() - padding * 2 - labelPadding) / numberDivisions + padding + labelPadding;
            int x1 = x0;
            int y0 = getHeight() - padding - labelPadding;
            int y1 = y0 - pointWidth;

            g2.setColor(gridColor);
            g2.drawLine(x0, getHeight() - padding - labelPadding - 1 - pointWidth, x1, padding);
            g2.setColor(Color.BLACK);

            String xLabel = value + "";
            FontMetrics metrics = g2.getFontMetrics();
            int labelWidth = metrics.stringWidth(xLabel);
            g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);

            g2.drawLine(x0, y0, x1, y1);
            value += 50;
        }

        // Create x and y axes line
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, padding + labelPadding, padding);
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, getWidth() - padding, getHeight() - padding - labelPadding);

        // Draw obstacle
        List<List<Points>> obstacleDraw = new ArrayList<>();
        Stroke oldStroke = g2.getStroke();

        for (Obstacle obstacle : obstaclesList) {
            List<Points> graphPoints = new ArrayList<>();
            List<Points> obstaclePoints = obstacle.getCoordinate();
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0, x4 = 0, y4 = 0;

            if(obstacle.getName().equals("Obstacle 1")){
                x1 = (int) (obstaclePoints.get(0).x + padding + labelPadding + 15);
                y1 = (int) ((numberDivisions * 50 - obstaclePoints.get(0).y) + padding + labelPadding + 5);

                x2 = (int) (obstaclePoints.get(1).x + padding + labelPadding + 65);
                y2 = (int) ((numberDivisions * 50 - obstaclePoints.get(1).y) + padding + labelPadding + 5);

                x3 = (int) (obstaclePoints.get(2).x + padding + labelPadding + 15);
                y3 = (int) ((numberDivisions * 50 - obstaclePoints.get(2).y) + padding + labelPadding + 40);

                x4 = (int) (obstaclePoints.get(3).x + padding + labelPadding + 65);
                y4 = (int) ((numberDivisions * 50 - obstaclePoints.get(3).y) + padding + labelPadding + 40);

            } else if (obstacle.getName().equals("Obstacle 2")) {
                x1 = (int) (obstaclePoints.get(0).x + padding + labelPadding + 45);
                y1 = (int) ((numberDivisions * 50 - obstaclePoints.get(0).y) + padding + labelPadding + 5);

                x2 = (int) (obstaclePoints.get(1).x + padding + labelPadding + 45);
                y2 = (int) ((numberDivisions * 50 - obstaclePoints.get(1).y) + padding + labelPadding + 25);

                x3 = (int) (obstaclePoints.get(2).x + padding + labelPadding + 80);
                y3 = (int) ((numberDivisions * 50 - obstaclePoints.get(2).y) + padding + labelPadding + 25);
            } else if (obstacle.getName().equals("Obstacle 3")) {
                x1 = (int) (obstaclePoints.get(0).x + padding + labelPadding + 80);
                y1 = (int) ((numberDivisions * 50 - obstaclePoints.get(0).y) + padding + labelPadding + 25);

                x2 = (int) (obstaclePoints.get(1).x + padding + labelPadding + 80);
                y2 = (int) ((numberDivisions * 50 - obstaclePoints.get(1).y) + padding + labelPadding + 70);

                x3 = (int) (obstaclePoints.get(2).x + padding + labelPadding + 110);
                y3 = (int) ((numberDivisions * 50 - obstaclePoints.get(2).y) + padding + labelPadding + 70);
            } else if (obstacle.getName().equals("Obstacle 4")) {
                x1 = (int) (obstaclePoints.get(0).x + padding + labelPadding + 15);
                y1 = (int) ((numberDivisions * 50 - obstaclePoints.get(0).y) + padding + labelPadding + 55);

                x2 = (int) (obstaclePoints.get(1).x + padding + labelPadding + 45);
                y2 = (int) ((numberDivisions * 50 - obstaclePoints.get(1).y) + padding + labelPadding + 55);

                x3 = (int) (obstaclePoints.get(2).x + padding + labelPadding + 15);
                y3 = (int) ((numberDivisions * 50 - obstaclePoints.get(2).y) + padding + labelPadding + 87);

                x4 = (int) (obstaclePoints.get(3).x + padding + labelPadding + 45);
                y4 = (int) ((numberDivisions * 50 - obstaclePoints.get(3).y) + padding + labelPadding + 87);
            } else if (obstacle.getName().equals("Obstacle 5")) {
                x1 = (int) (obstaclePoints.get(0).x + padding + labelPadding + 65);
                y1 = (int) ((numberDivisions * 50 - obstaclePoints.get(0).y) + padding + labelPadding + 87);

                x2 = (int) (obstaclePoints.get(1).x + padding + labelPadding + 110);
                y2 = (int) ((numberDivisions * 50 - obstaclePoints.get(1).y) + padding + labelPadding + 87);

                x3 = (int) (obstaclePoints.get(2).x + padding + labelPadding + 65);
                y3 = (int) ((numberDivisions * 50 - obstaclePoints.get(2).y) + padding + labelPadding + 120);

                x4 = (int) (obstaclePoints.get(3).x + padding + labelPadding + 110);
                y4 = (int) ((numberDivisions * 50 - obstaclePoints.get(3).y) + padding + labelPadding + 120);
            } else {
                x1 = (int) (obstaclePoints.get(0).x + padding + labelPadding + 127);
                y1 = (int) ((numberDivisions * 50 - obstaclePoints.get(0).y) + padding + labelPadding + 103);

                x2 = (int) (obstaclePoints.get(1).x + padding + labelPadding + 143);
                y2 = (int) ((numberDivisions * 50 - obstaclePoints.get(1).y) + padding + labelPadding + 103);

                x3 = (int) (obstaclePoints.get(2).x + padding + labelPadding + 127);
                y3 = (int) ((numberDivisions * 50 - obstaclePoints.get(2).y) + padding + labelPadding + 135);

                x4 = (int) (obstaclePoints.get(3).x + padding + labelPadding + 143);
                y4 = (int) ((numberDivisions * 50 - obstaclePoints.get(3).y) + padding + labelPadding + 135);
            }


            graphPoints.add(new Points(x1, y1));
            graphPoints.add(new Points(x2, y2));
            graphPoints.add(new Points(x3, y3));

            if(!obstacle.getName().equals("Obstacle 2") && !obstacle.getName().equals("Obstacle 3"))
                graphPoints.add(new Points(x4, y4));

            obstacleDraw.add(graphPoints);

            // Draw obstacle point
            for (Points point: graphPoints) {
                g2.setStroke(oldStroke);
                g2.setColor(pointColor);
                g2.fillOval((int) (point.x - pointWidth / 2), (int) (point.y - pointWidth / 2), pointWidth, pointWidth);
            }
        }
        //Draw Source and Goals;
        FontMetrics metrics = g2.getFontMetrics();
        g.setFont(new Font("default", Font.BOLD, 14));

        g2.setColor(pointSourceColor);
        g2.fillOval(45, 87, 10, 10);
        g2.setColor(Color.BLACK);
        String xLabel = "Source";
        int labelWidth = metrics.stringWidth(xLabel);
        g2.drawString(xLabel, 45 - labelWidth / 2, 87 + metrics.getHeight() - 18);

        g2.setColor(pointGoalColor);
        g2.fillOval(705, 745, 10, 10);
        g2.setColor(Color.BLACK);
        xLabel = "Goals";
        labelWidth = metrics.stringWidth(xLabel);
        g2.drawString(xLabel, 705 - labelWidth / 2, 745 + metrics.getHeight() - 18);

        // Draw obstacle Line
        g2.setColor(lineColor);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < obstacleDraw.size(); i++) {

            int x1 = (int) obstacleDraw.get(i).get(0).x;
            int y1 = (int) obstacleDraw.get(i).get(0).y;
            int x2 = (int) obstacleDraw.get(i).get(1).x;
            int y2 = (int) obstacleDraw.get(i).get(1).y;
            int x3 = (int) obstacleDraw.get(i).get(2).x;
            int y3 = (int) obstacleDraw.get(i).get(2).y;

            if(obstacleDraw.get(i).size() == 4){
                int x4 = (int) obstacleDraw.get(i).get(3).x;
                int y4 = (int) obstacleDraw.get(i).get(3).y;
                g2.drawLine(x1, y1, x2, y2);
                g2.drawLine(x1, y1, x3, y3);
                g2.drawLine(x2, y2, x4, y4);
                g2.drawLine(x3, y3, x4, y4);
            }else{
                g2.drawLine(x1, y1, x2, y2);
                g2.drawLine(x2, y2, x3, y3);
                g2.drawLine(x1, y1, x3, y3);
            }
        }
    }
}
