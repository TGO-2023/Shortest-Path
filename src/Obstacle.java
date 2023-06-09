import java.util.ArrayList;

public class Obstacle {
    enum ObstacleType {
        RIGHT_TRIANGLE,
        SQUARE,
        RECTANGLE
    }

    private final ObstacleType obstacleType;
    private final int width;
    private final int length;
    private final ArrayList<Points> coordinate = new ArrayList<>();
    private final String name;

    public Obstacle(ObstacleType obstacleType, int width, int length,
                    int startX, int startY, String name){
        this.obstacleType = obstacleType;
        this.width = width;
        this.length = length;
        this.name = name;
        this.setDimension(startX, startY);
    }

    private void setDimension(int startX, int startY){
        switch (this.obstacleType){
            case RECTANGLE, SQUARE -> {
                this.coordinate.add(new Points(startX, startY, name + "-1"));
                this.coordinate.add(new Points(startX + this.length, startY, name + "-2"));
                this.coordinate.add(new Points(startX, startY - this.width, name + "-3"));
                this.coordinate.add(new Points(startX + this.length, startY - this.width, name + "-4"));
            }
            case RIGHT_TRIANGLE -> {
                this.coordinate.add(new Points(startX, startY, name + "-1"));
                this.coordinate.add(new Points(startX, startY - this.width, name + "-2"));
                this.coordinate.add(new Points(startX + this.length, startY - this.width, name + "-3"));
            }
        }
    }
    public String getName() {
        return name;
    }
    public ObstacleType getObstacleType() {
        return obstacleType;
    }
    public ArrayList<Points> getCoordinate() {
        return coordinate;
    }
}
