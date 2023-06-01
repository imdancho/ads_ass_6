import java.util.*;
public class Search<Vertex> {
    private WeightedGraph<Vertex> graph;


    public Search(WeightedGraph<Vertex> graph) {
        this.graph = graph;

    }

    public WeightedGraph<Vertex> getGraph() {
        return graph;

    }

    public boolean pathExist(Vertex source, Vertex destination) {
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        visited.add(source);
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (current.equals(destination)) return true;
            List<Edge<Vertex>> adj = graph.getAdjacentEdges(current);
            for (Edge<Vertex> edge : adj) {
                Vertex neigh = edge.getDestination();
                if (!visited.contains(neigh))
                {
                    visited.add(neigh);
                    queue.offer(neigh);
                }

            }

        }
        return false;
    }

}