package metro;

import java.util.*;

public class MetroApp {
    private Map<String, Station> stations;

    public MetroApp() {
        stations = new HashMap<>();
        initializeStations();
    }

    private void initializeStations() {
        Station aliTown = new Station("Ali Town");
        Station daewoo = new Station("Daewoo");
        Station thokar = new Station("Thokar Niaz Baig");
        Station bhaiPheru = new Station("Bhai Pheru");
        Station shahdara = new Station("Shahdara");
        Station samanabad = new Station("Samanabad");
        Station gulberg = new Station("Gulberg");
        Station anarkali = new Station("Anarkali");
        Station railwayStation = new Station("Railway Station");
        Station iqbalPark = new Station("Iqbal Park");
        Station allamaIqbal = new Station("Allama Iqbal Station");
        Station mauzaLakhodair = new Station("Mauza Lakhodair");
        Station bhattiGate = new Station("Bhatti Gate");
        Station chungiAmarSidhu = new Station("Chungi Amar Sidhu");
        Station faisalTown = new Station("Faisal Town");
        Station kotLakhpat = new Station("Kot Lakhpat");
        Station sabzazar = new Station("Sabzazar");
        Station kashmirRoad = new Station("Kashmir Road");
        Station sanda = new Station("Sanda");
        Station gulshanRavi = new Station("Gulshan-e-Ravi");
        Station pecoRoad = new Station("Peco Road");

        // Adding routes (example distances)
        aliTown.addRoute(new Route(thokar, 5));
        thokar.addRoute(new Route(bhaiPheru, 3));
        bhaiPheru.addRoute(new Route(shahdara, 2));
        shahdara.addRoute(new Route(samanabad, 4));
        samanabad.addRoute(new Route(gulberg, 3));
        gulberg.addRoute(new Route(anarkali, 2));
        anarkali.addRoute(new Route(railwayStation, 1));
        railwayStation.addRoute(new Route(iqbalPark, 2));
        iqbalPark.addRoute(new Route(allamaIqbal, 2));
        allamaIqbal.addRoute(new Route(mauzaLakhodair, 3));
        mauzaLakhodair.addRoute(new Route(bhattiGate, 2));
        bhattiGate.addRoute(new Route(chungiAmarSidhu, 2));
        chungiAmarSidhu.addRoute(new Route(faisalTown, 3));
        faisalTown.addRoute(new Route(kotLakhpat, 4));
        kotLakhpat.addRoute(new Route(sabzazar, 5));
        sabzazar.addRoute(new Route(kashmirRoad, 2));
        kashmirRoad.addRoute(new Route(sanda, 3));
        sanda.addRoute(new Route(gulshanRavi, 2));
        gulshanRavi.addRoute(new Route(pecoRoad, 4));

        // Add stations to the map
        stations.put(aliTown.getName(), aliTown);
        stations.put(daewoo.getName(), daewoo);
        stations.put(thokar.getName(), thokar);
        stations.put(bhaiPheru.getName(), bhaiPheru);
        stations.put(shahdara.getName(), shahdara);
        stations.put(samanabad.getName(), samanabad);
        stations.put(gulberg.getName(), gulberg);
        stations.put(anarkali.getName(), anarkali);
        stations.put(railwayStation.getName(), railwayStation);
        stations.put(iqbalPark.getName(), iqbalPark);
        stations.put(allamaIqbal.getName(), allamaIqbal);
        stations.put(mauzaLakhodair.getName(), mauzaLakhodair);
        stations.put(bhattiGate.getName(), bhattiGate);
        stations.put(chungiAmarSidhu.getName(), chungiAmarSidhu);
        stations.put(faisalTown.getName(), faisalTown);
        stations.put(kotLakhpat.getName(), kotLakhpat);
        stations.put(sabzazar.getName(), sabzazar);
        stations.put(kashmirRoad.getName(), kashmirRoad);
        stations.put(sanda.getName(), sanda);
        stations.put(gulshanRavi.getName(), gulshanRavi);
        stations.put(pecoRoad.getName(), pecoRoad);
    }

    public List<String> findShortestRoute(String startName, String endName) {
        Station start = stations.get(startName);
        Station end = stations.get(endName);

        if (start == null || end == null) {
            return Collections.emptyList();
        }

        Map<Station, Integer> distances = new HashMap<>();
        Map<Station, Station> previous = new HashMap<>();
        PriorityQueue<Station> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (Station station : stations.values()) {
            distances.put(station, Integer.MAX_VALUE);
            previous.put(station, null);
        }

        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Station current = queue.poll();

            for (Route route : current.getRoutes()) {
                Station neighbor = route.getDestination();
                int newDist = distances.get(current) + route.getDistance();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // Build the shortest path
        List<String> path = new ArrayList<>();
        int totalDistance = 0;
        for (Station at = end; at != null; at = previous.get(at)) {
            path.add(at.getName());
            if (previous.get(at) != null) {
                // Add the distance from previous station to current station
                Station prevStation = previous.get(at);
                for (Route route : prevStation.getRoutes()) {
                    if (route.getDestination().equals(at)) {
                        totalDistance += route.getDistance();
                        break;
                    }
                }
            }
        }
        Collections.reverse(path);
        // Displaying the path with distances
        System.out.println("Shortest Route: " + String.join(" -> ", path) + " | Total Distance: " + totalDistance + " km");
        return path;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetroApp app = new MetroApp();

        System.out.println("Welcome to The Metro App!");
        System.out.println("Enter start station:");
        String start = scanner.nextLine();
        System.out.println("Enter destination station:");
        String destination = scanner.nextLine();

        app.findShortestRoute(start, destination);
    }
}
