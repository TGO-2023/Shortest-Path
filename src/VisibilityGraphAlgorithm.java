import java.util.ArrayList;
import java.util.List;

public class VisibilityGraphAlgorithm {

    public static double calculateDistance(Points p1, Points p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static boolean doSegmentsIntersect(Points p1, Points q1, Points p2, Points q2) {
        double o1 = (q1.y - p1.y) * (p2.x - p1.x) - (q1.x - p1.x) * (p2.y - p1.y);
        double o2 = (q1.y - p1.y) * (q2.x - p1.x) - (q1.x - p1.x) * (q2.y - p1.y);
        double o3 = (q2.y - p2.y) * (p1.x - p2.x) - (q2.x - p2.x) * (p1.y - p2.y);
        double o4 = (q2.y - p2.y) * (q1.x - p2.x) - (q2.x - p2.x) * (q1.y - p2.y);

        return o1 * o2 < 0 && o3 * o4 < 0;
    }

    public static List<Edge> buildVisibilityGraph(List<Points> points) {
        List<Edge> visibilityGraph = new ArrayList<>();
        int numPoints = points.size();

        for (int i = 0; i < numPoints; i++) {
            for (int j = i + 1; j < numPoints; j++) {
                boolean isVisible = true;

                for (int k = 0; k < numPoints; k++) {
                    if ((k != i) && (k != j)) {
                        if (doSegmentsIntersect(points.get(i), points.get(j), points.get(k), points.get((k + 1) % numPoints))) {
                            isVisible = false;
                            break;
                        }
                    }
                }

                if (isVisible) {
                    double distance = calculateDistance(points.get(i), points.get(j));
                    visibilityGraph.add(new Edge(i, j, distance, points.get(i).name, points.get(j).name));
                }
            }
        }

        return visibilityGraph;
    }
}
