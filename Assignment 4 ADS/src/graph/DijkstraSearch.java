package graph;

import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<V> search(V start, V end) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previousVertices = new HashMap<>();
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparing(distances::get));
        Set<Vertex<V>> visited = new HashSet<>();

        Vertex<V> startVertex = graph.getVertex(start);
        Vertex<V> endVertex = graph.getVertex(end);

        for (Vertex<V> vertex : graph.getAllVertices()) {
            distances.put(vertex, Double.MAX_VALUE);
        }
        distances.put(startVertex, 0.0);

        priorityQueue.add(startVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> current = priorityQueue.poll();
            visited.add(current);

            if (current.equals(endVertex)) {
                break;
            }

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                if (!visited.contains(neighbor)) {
                    double newDist = distances.get(current) + weight;
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                        previousVertices.put(neighbor, current);
                        priorityQueue.add(neighbor);
                    }
                }
            }
        }

        // Construct the shortest path
        List<V> path = new LinkedList<>();
        for (Vertex<V> vertex = endVertex; vertex != null; vertex = previousVertices.get(vertex)) {
            path.add(0, vertex.getData());
        }
        return path.isEmpty() ? Collections.emptyList() : path;
    }
}
