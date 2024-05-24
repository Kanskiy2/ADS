package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(V data) {
        vertices.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(destination);
        if (sourceVertex != null && destVertex != null) {
            sourceVertex.addAdjacentVertex(destVertex, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getAllVertices() {
        return vertices.values();
    }
}
