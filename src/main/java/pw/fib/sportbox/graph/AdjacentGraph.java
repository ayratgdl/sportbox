package pw.fib.sportbox.graph;

import java.util.*;

public class AdjacentGraph {
    private boolean directed;
    private Map<Integer, List<Integer>> map = new HashMap<>();

    private AdjacentGraph(boolean directed) {
        this.directed = directed;
    }

    public static AdjacentGraph createDirected() {
        return new AdjacentGraph(true);
    }

    public static AdjacentGraph createIndirected() {
        return new AdjacentGraph(false);
    }

    public boolean isDirected() {
        return directed;
    }

    public void addNode(Integer v) {
        if (map.get(v) == null) {
            map.put(v, new ArrayList<>());
        }
    }

    public boolean hasNode(Integer v) {
        return map.get(v) != null;
    }

    public void addArc(Integer v1, Integer v2) {
        addNode(v1);
        addNode(v2);
        map.get(v1).add(v2);
        if (!directed)
            map.get(v2).add(v1);
    }

    public void removeArc(Integer v1, Integer v2) {
        if (!hasNode(v1) || !hasNode(v2))
            throw new IllegalArgumentException(String.format("Node %d or %d isn't exist", v1, v2));

        map.get(v1).remove(v2);
        if (!directed)
            map.get(v2).remove(v1);
    }

    public void removeNode(Integer v) {
        if (!hasNode(v))
            throw new IllegalArgumentException(String.format("Node %d isn't exist", v));

        if (!directed) {
            for (Integer u : adjacentNodes(v)) {
                removeArc(v, u);
            }
        }
        map.remove(v);
    }

    public Collection<Integer> adjacentNodes(Integer v) {
        if (!hasNode(v))
            throw new IllegalArgumentException(String.format("Node %d isn't exist", v));

        return new ArrayList<>(map.get(v));
    }

    public Collection<Integer> allNodes() {
        return new ArrayList<>(map.keySet());
    }

    public boolean isLeaf(Integer v) {
        if (!hasNode(v))
            throw new IllegalArgumentException(String.format("Node %d isn't exist", v));

        if (!directed)
            return map.get(v).size() == 1;
        else
            return map.get(v).size() == 0;
    }
}