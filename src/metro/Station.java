package metro;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private List<Route> routes;

    public Station(String name) {
        this.name = name;
        this.routes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public List<Route> getRoutes() {
        return routes;
    }
}
