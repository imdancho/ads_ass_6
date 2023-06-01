import java.util.Map;

public class Vertex<V> {
    private V da;

    private Map<Vertex<V>, Double> adjacentVertices;

    public V getDa() {
        return da;

    }

    public void addAdjacentVertex(Vertex<V> d, double w) {
        adjacentVertices.put(d, w);

    }

    public String toString() {
        return String.valueOf(da);

    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;

    }



}