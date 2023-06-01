import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");

        graph.addEdge("1", "2", 5);
        graph.addEdge("1", "4", 9);
        graph.addEdge("2", "3", 3);
        graph.addEdge("4", "1", 5);
        graph.addEdge("3", "1", 6);
        graph.addEdge("2", "4", 1);


        BreadthFirstSearch<String> bfsSearch = new BreadthFirstSearch<>(graph);
        DijkstraSearch<String> dijkstraSearch = new DijkstraSearch<>(graph);

        System.out.println( bfsSearch.pathExist("1", "3"));
        System.out.println( dijkstraSearch.pathExist("2", "1"));

        List<String> bfsShortestPath = bfsSearch.findShortestPath("2", "3");
        List<String> dijkstraShortestPath = dijkstraSearch.findShortestPath("4", "2");

        if (bfsShortestPath != null)
            System.out.println(bfsShortestPath);

        else
            System.out.println("dont exist");



        if (dijkstraShortestPath != null)
            System.out.println(dijkstraShortestPath);

        else
            System.out.println("dont exist");

    }
}