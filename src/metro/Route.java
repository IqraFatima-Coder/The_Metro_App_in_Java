package metro;

public class Route {
    private Station destination;
    private int distance;

    public Route(Station destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public Station getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }
}
