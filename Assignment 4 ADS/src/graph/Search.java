package graph;

import java.util.List;

public interface Search<V> {
    List<V> search(V start, V end);
}
