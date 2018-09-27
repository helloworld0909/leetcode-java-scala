package com.helloworld09.leetcode.java;

import java.util.*;

import com.helloworld09.leetcode.java.util.UndirectedGraphNode;

public class LC133 {
    /**
     * Given the head of a graph, return a deep copy (clone) of the graph. Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. There is an edge between the given node and each of the nodes in its neighbors.
     * <p>
     * OJ's undirected graph serialization (so you can understand error output):
     * Nodes are labeled uniquely.
     * <p>
     * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
     * <p>
     * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
     * <p>
     * The graph has a total of three nodes, and therefore contains three parts as separated by #.
     * <p>
     * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
     * Second node is labeled as 1. Connect node 1 to node 2.
     * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
     * <p>
     * Note: The information about the tree serialization is only meant so that you can understand error output if you get a wrong answer. You don't need to understand the serialization to solve the problem.
     */
    private Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();

    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> equivelent = new HashMap<>();

        UndirectedGraphNode retNode = new UndirectedGraphNode(node.label);
        UndirectedGraphNode curNode = retNode;
        queue.offer(node);
        equivelent.put(node, curNode);

        while (!queue.isEmpty()) {
            node = queue.poll();
            curNode = equivelent.get(node);

            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (!equivelent.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    equivelent.put(neighbor, neighborCopy);
                    curNode.neighbors.add(neighborCopy);
                } else {
                    curNode.neighbors.add(equivelent.get(neighbor));
                }
            }
        }
        return retNode;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        visited.put(node, nodeCopy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            nodeCopy.neighbors.add(cloneGraph(neighbor));
        }
        return nodeCopy;
    }

    public static void main(String[] args) {
        LC133 solution = new LC133();
        System.out.println(solution.cloneGraph(UndirectedGraphNode.getTestGraph()));
    }
}
