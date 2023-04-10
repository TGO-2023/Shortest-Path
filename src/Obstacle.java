import java.util.ArrayList;
import java.util.List;

public class Obstacle {
    enum ObstacleType {
        RIGHT_TRIANGLE,
        SQUARE,
        RECTANGLE
    }

    private ObstacleType obstacleType;
    private int width;
    private int length;
    private int startX;
    private int startY;
    private ArrayList<ArrayList<Integer>> coordinate = new ArrayList<>();

    public Obstacle(ObstacleType obstacleType, int width, int length,
                    int startX, int startY){
        this.obstacleType = obstacleType;
        this.width = width;
        this.length = length;
        this.startX = startX;
        this.startY = startY;
        this.setDimension();
    }

    private void setDimension(){
        switch (this.obstacleType){
            case RECTANGLE, SQUARE -> {
                ArrayList<Integer> coordinate1 = new ArrayList<>();
                coordinate1.add(startX);
                coordinate1.add(startY);

                ArrayList<Integer> coordinate2 = new ArrayList<>();
                coordinate2.add(startX + length);
                coordinate2.add(startY);

                ArrayList<Integer> coordinate3 = new ArrayList<>();
                coordinate3.add(startX);
                coordinate3.add(startY - width);

                ArrayList<Integer> coordinate4 = new ArrayList<>();
                coordinate4.add(startX + length);
                coordinate4.add(startY - width);

                this.coordinate.add(coordinate1);
                this.coordinate.add(coordinate2);
                this.coordinate.add(coordinate3);
                this.coordinate.add(coordinate4);
            }
            case RIGHT_TRIANGLE -> {
                ArrayList<Integer> coordinate1 = new ArrayList<>();
                coordinate1.add(startX);
                coordinate1.add(startY);

                ArrayList<Integer> coordinate2 = new ArrayList<>();
                coordinate2.add(startX);
                coordinate2.add(startY - width);

                ArrayList<Integer> coordinate3 = new ArrayList<>();
                coordinate3.add(startX + length);
                coordinate3.add(startY - width);

                this.coordinate.add(coordinate1);
                this.coordinate.add(coordinate2);
                this.coordinate.add(coordinate3);
            }
        }
    }

    public ObstacleType getObstacleType() {
        return obstacleType;
    }
    public void setObstacleType(ObstacleType obstacleType) {
        this.obstacleType = obstacleType;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getStartX() {
        return startX;
    }
    public void setStartX(int startX) {
        this.startX = startX;
    }
    public int getStartY() {
        return startY;
    }
    public void setStartY(int startY) {
        this.startY = startY;
    }
    public ArrayList<ArrayList<Integer>> getCoordinate() {
        return coordinate;
    }
    public void setCoordinate(ArrayList<ArrayList<Integer>> coordinate) {
        this.coordinate = coordinate;
    }
}
