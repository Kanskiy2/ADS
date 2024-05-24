package graph;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "E", 3);
        graph.addEdge("E", "D", 4);

        Search<String> bfs = new BreadthFirstSearch<>(graph);
        System.out.println("BFS from A to D: " + bfs.search("A", "D"));

        Search<String> dijkstra = new DijkstraSearch<>(graph);
        System.out.println("Dijkstra from A to D: " + dijkstra.search("A", "D"));
    }
}
