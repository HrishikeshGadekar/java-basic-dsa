package org.javadsa.advancedDataStructures;

import java.util.Arrays;
import java.util.LinkedList;

public class GraphImpl {

    int vertexCount;
    LinkedList<Integer>[] adjacencyList;


    public GraphImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adjacencyList = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(LinkedList<Integer>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    private GraphImpl addEdge(GraphImpl graph, int source, int target) {
        LinkedList<Integer>[] graphAdjacencyList = graph.getAdjacencyList();
        graphAdjacencyList[source].add(target);
        graphAdjacencyList[target].add(source);
        graph.setAdjacencyList(graphAdjacencyList);
        return graph;
    }

    private void printGraph(GraphImpl graph) {
        LinkedList<Integer>[] graphAdjacencyList = graph.getAdjacencyList();
        System.out.println("Adjacency List for the current graph is: ");
        for (int i = 0; i < graphAdjacencyList.length; i++) {
            System.out.print(i + ":");
            for (int node : graphAdjacencyList[i]) {
                System.out.print(" -> " + node);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphImpl graph = new GraphImpl(5);

        graph = graph.addEdge(graph, 0, 1);
        graph = graph.addEdge(graph, 0, 4);
        graph = graph.addEdge(graph, 1, 2);
        graph = graph.addEdge(graph, 1, 3);
        graph = graph.addEdge(graph, 2, 3);
        graph = graph.addEdge(graph, 3, 4);
        graph = graph.addEdge(graph, 4, 1);

        graph.printGraph(graph);

    }


}
