package graph;

import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<V> search(V start, V end) {
        List<V> result = new LinkedList<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        Vertex<V> startVertex = graph.getVertex(start);
        Vertex<V> endVertex = graph.getVertex(end);

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            result.add(current.getData());

            if (current.equals(endVertex)) {
                return result;
            }

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return result; // Returns the path from start to end or empty if no path found
    }
}
