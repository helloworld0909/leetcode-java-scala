package com.helloworld09.leetcode.java.util;

import java.util.*;

public class UndirectedGraphNode extends GraphNode {
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

    public static void addUndirectedEdge(UndirectedGraphNode node1, UndirectedGraphNode node2) {
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
    }

    public static UndirectedGraphNode getTestGraph() {
        List<UndirectedGraphNode> nodeList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            nodeList.add(new UndirectedGraphNode(i));
        }
        addUndirectedEdge(nodeList.get(0), nodeList.get(1));
        addUndirectedEdge(nodeList.get(1), nodeList.get(2));
        addUndirectedEdge(nodeList.get(0), nodeList.get(2));
        addUndirectedEdge(nodeList.get(2), nodeList.get(2));
        return nodeList.get(0);
    }
}
