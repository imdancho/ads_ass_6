public class Edge<Vertex> {

    private Vertex source;
    private Vertex dest;
    private double weight;

    public Edge(Vertex source, Vertex dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;

    }

    public Vertex getDestination() {
        return dest;

    }

    public double getWeight() {
        return weight;

    }

    public Vertex getSource() {
        return source;

    }

}