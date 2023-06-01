import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private Map<Vertex, Vertex> pMap;
    private Map<Vertex, Integer> dist;


    public DijkstraSearch(WeightedGraph<Vertex> graph) {
        super(graph);

    }

    public List<Vertex> findShortestPath(Vertex source, Vertex dest) {
        calculateShortestDistances(source);

        if (!dist.containsKey(dest))   return null;

        List<Vertex> path = new ArrayList<>();
        Vertex curr = dest;
        while (!curr.equals(source)) {

            path.add(0, curr);
            curr = pMap.get(curr);

        }
        path.add(0, source);

        return path;
    }

    private void calculateShortestDistances(Vertex source) {
        dist = new HashMap<>();
        pMap = new HashMap<>();

        for (Vertex vertex : getGraph().getVertices()) { dist.put(vertex, Integer.MAX_VALUE); }

        dist.put(source, 0);
        pMap.put(source, null);

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();

            List<Edge<Vertex>> adjacentEdges = getGraph().getAdjacentEdges(curr);
            for (Edge<Vertex> edge : adjacentEdges) {

                Vertex nei = edge.getDestination();
                int weight = (int) edge.getWeight();
                int newD = dist.get(curr) + weight;

                if (newD < dist.get(nei)) {

                    dist.put(nei, newD);
                    pMap.put(nei, curr);
                    queue.offer(nei);

                }

            }

        }

    }

}