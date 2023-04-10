import java.util.ArrayList;

public class Arena {
    private int xSource;
    private int ySource;
    private int xDestination;
    private int yDestination;
    private int xBoundary;
    private int yBoundary;
    private ArrayList<Obstacle> obstacleList = new ArrayList<>();

    public Arena(int xBoundary, int yBoundary){
        this.xSource = 0;
        this.ySource = yBoundary;
        this.xDestination = xBoundary;
        this.yDestination = 0;
        this.xBoundary = xBoundary;
        this.yBoundary = yBoundary;
    }

    public void printObstacle(){
        int index = 1;
        for (Obstacle obstacle: this.obstacleList) {
            System.out.println(index + ". " + obstacle.getObstacleType() + ": " + obstacle.getCoordinate());
            index++;
        }
    }

    public int getxSource() {
        return xSource;
    }
    public void setxSource(int xSource) {
        this.xSource = xSource;
    }
    public int getySource() {
        return ySource;
    }
    public void setySource(int ySource) {
        this.ySource = ySource;
    }
    public int getxDestination() {
        return xDestination;
    }
    public void setxDestination(int xDestination) {
        this.xDestination = xDestination;
    }
    public int getyDestination() {
        return yDestination;
    }
    public void setyDestination(int yDestination) {
        this.yDestination = yDestination;
    }
    public int getxBoundary() {
        return xBoundary;
    }
    public void setxBoundary(int xBoundary) {
        this.xBoundary = xBoundary;
    }
    public int getyBoundary() {
        return yBoundary;
    }
    public void setyBoundary(int yBoundary) {
        this.yBoundary = yBoundary;
    }
    public ArrayList<Obstacle> getObstacleList() {
        return obstacleList;
    }
    public void setObstacleList(ArrayList<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
    }
}
