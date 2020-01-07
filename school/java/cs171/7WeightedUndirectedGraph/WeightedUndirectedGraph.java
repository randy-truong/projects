// Name: Randy Truong
// CS171

package Assignment7;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class WeightedUndirectedGraph {

    // Data fields
    private int V; // # vertices
    private int E; // # edges

    private boolean[][] adjMatrix;
    private double[][] adjWeightedMatrix;
    private LinkedList<Integer> adjListArray[];
    private FileReader file;

    // Class for taking input from a file
    public static class FileReader {
        private Scanner scanner;

        // Constructor that takes in the file name (String)
        public FileReader(String name) throws FileNotFoundException {
            File file = new File(name);
            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis));
        }

        // Methods for reading the input in the file, input is separated by comma
        public int readInt() {
            String[] tokens = scanner.next().split(",");
            int value = Integer.parseInt(tokens[0]);
            return value;
        }
        public double readDouble() {
            String[] tokens = scanner.next().split(",");
            double value = Double.parseDouble(tokens[0]);
            return value;
        }
    }

    // Constructor for creating a weighted, undirected graph from a .txt file
    // In the file, the # vertices is the first integer, the # edges is the second integer
    // each consecutive line represents a vertex-vertex pair with an associated edge weight
    public WeightedUndirectedGraph(FileReader file) {
        this.file = file;
        this.V = file.readInt();
        this.E = file.readInt();

        // Initalize data structures: matrices and adjacency list
        adjMatrix = new boolean[V][V];
        adjWeightedMatrix = new double[V][V];
        adjListArray = new LinkedList[V];


        // Fill previous data structures with empty or false values
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // Creates V*V matrix
                adjMatrix[i][j] = false;
                adjMatrix[j][i] = false;
                adjWeightedMatrix[i][j] = 0;
                adjWeightedMatrix[j][i] = 0;
            }
        }

        // Create adjacency list
        for(int i = 0; i < V; i++) {
            // Creates the "heads"
            adjListArray[i] = new LinkedList<>();
        }
    }

    // Method for adding in the edges to the graph
    // from the .txt file constructed with the graph
    public void addEdge() {
        int u; // vertex
        int v; // other vertex
        double w; // edge weight between u and v vertices

        // For loop reads each line of the .txt fle
        // initializing each vertex pair with weight
        for (int i = 0; i < E; i++) {
            u = file.readInt() - 1;
            v = file.readInt() - 1;
            w = file.readDouble();

            // Conditional to check that the vertex being added
            // is valid given the V and E parameters, then adds to structure
            if (u >= 0 && u < V && v >= 0 && v < V) {
                // We must create a connection between u and v, v and u because undirected
                adjMatrix[u][v] = true;
                adjMatrix[v][u] = true;
                adjWeightedMatrix[u][v] = w;
                adjWeightedMatrix[v][u] = w;
                adjListArray[u].add(v);
                adjListArray[v].add(u);
            }
        }

    }

    // Method for depth-first search
    public void dfs(int v, boolean[] visited) {
        // Marks visited vertex
        visited[v] = true;
        // Prints visited vertex (used later for adjacency list representation)
        System.out.print("(head) " + (v+1) + ":"); // +1 to v because fixing vertex number due to changing its index before

        // Prints all of the vertices attached to the visited vertex
        for (int j = 0; j < V; j++) {
            if (j == v) {
                for (Integer depth : adjListArray[j]) {
                    System.out.print(" -> " + (depth + 1));
                }
                System.out.println();
            }
        }

        // Recursive loop to find adjacent vertices to current vertex
        for (int i : adjListArray[v]) {
            if (!visited[i]) {
                dfs(i, visited);
            }
        }

    }

    // Method for determining the number of connected components in the graph
    public void checkConnected() {
        int count = 0; // counter for how many connected components in graph
        // Boolean array to check visited/unvisited vertices
        boolean[] visited = new boolean[V];

        // Finds and prints the reachable vertices
        for (int i = 0; i < V; ++i) {
            if(!visited[i]) {
                dfs(i, visited);
                System.out.println();
                count++;
            }
        }
        System.out.println("# Connected Components: " + count);
    }

    // Method for finding the vertex with smallest weight
    public int minEdge(double key[], Boolean mstSet[])
    {
        // Initialize min value
        double minWeight = Double.POSITIVE_INFINITY;
        int minIndex = -1;

        // Finds unvisited vertices
        for (int v = 0; v < V; v++)
            if (key[v] < minWeight && mstSet[v] == false) {
                minWeight = key[v];
                // Marks the vertex position
                minIndex = v;
            }
        return minIndex;
    }

    // Method for printing Prim's MST Matrix Representation
    public void printMST(int[] parent, double[][] graph) {
        System.out.println("Prim's Algorithm: Adjacency Matrix for MST");

        System.out.println("Edge \t\t Weight");
        for (int i = 1; i < V; i++) {
            System.out.println((parent[i]+1) + " -> " + (i+1) + "\t\t" + graph[i][parent[i]]); // +1 for index correction
        }

        for (int j = 1; j < V; j++) {
            for (int k = 1; k < V; k++) {
                System.out.print(graph[j][parent[k]] + " ");
            }
            System.out.println();
        }

    }

    // Constructs a minimum spanning tree from an adjacency matrix representation
    public void primMST(double graph[][]) {
        // Initalizes MST array
        int parent[] = new int[V];
        // Initalizes array for minimum edge weights
        double key[] = new double[V];
        // Unvisited vertices
        Boolean mstSet[] = new Boolean[V];

        // Initializes all vertices as infinite and unvisited
        for (int i = 0; i < V; i++) {
            key[i] = Double.POSITIVE_INFINITY;
            mstSet[i] = false;
        }

        // First vertex chosen
        key[0] = 0;
        // Root
        parent[0] = -1;

        // MST size is of V vertices
        for (int count = 0; count < V; count++) {
            // Finds minimum vertex from the unvisited vertices
            int j = minEdge(key, mstSet)+1;
            // Vertex is visited and included in MST
            mstSet[j] = true;

            // Updates the key and only chooses unvisited vertices in MST
            for (int k = 0; k < V; k++) {
                if ((graph[j][k] != 0) && (mstSet[k] == false) && (graph[j][k] < key[k])) {
                    parent[k] = j;
                    key[k] = graph[j][k];
                }
            }
        }
        // Print MST
        printMST(parent, graph);
    }

    // Wrapper for primMST because user is not inputting a graph
    // user inserts a .txt file
    public void primMST() {
        primMST(adjWeightedMatrix);
    }

    // Method for printing the Adjacency Matrix in a boolean representation
    // 1 = true, 0 = false
    public void printAdjMatrix() {

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(adjMatrix[i][j] == true) {
                    System.out.print(1 + " ");
                }
                else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    // Method for printing the Adjacency Matrix in a weighted edge representation
    public void printAdjMatrixWeighted() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjWeightedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        // For graph1.txt
/*
        FileReader file1 = new FileReader("graph1.txt");
        WeightedUndirectedGraph graph1 = new WeightedUndirectedGraph(file1);
        graph1.addEdge();
        System.out.println("Adjacency Boolean Matrix Representation");
        graph1.printAdjMatrix();
        System.out.println();
        System.out.println("Adjacency Weighted Matrix Representation");
        graph1.printAdjMatrixWeighted();
        System.out.println();
        System.out.println("Adjacency List Representation by its Connected Components");
        graph1.checkConnected();
        System.out.println();
        graph1.primMST();
*/

        // For graph2.txt
/*
        FileReader file2 = new FileReader("graph2.txt");
        WeightedUndirectedGraph graph2 = new WeightedUndirectedGraph(file2);
        graph2.addEdge();
        System.out.println("Adjacency Boolean Matrix Representation");
        graph2.printAdjMatrix();
        System.out.println();
        System.out.println("Adjacency Weighted Matrix Representation");
        graph2.printAdjMatrixWeighted();
        System.out.println();
        System.out.println("Adjacency List Representation by its Connected Components");
        graph2.checkConnected();
        System.out.println();
        graph2.primMST();
*/


        // For graph3.txt

        FileReader file3 = new FileReader("graph3.txt");
        WeightedUndirectedGraph graph3 = new WeightedUndirectedGraph(file3);
        graph3.addEdge();
        System.out.println("Adjacency Boolean Matrix Representation");
        graph3.printAdjMatrix();
        System.out.println();
        System.out.println("Adjacency Weighted Matrix Representation");
        graph3.printAdjMatrixWeighted();
        System.out.println();
        System.out.println("Adjacency List Representation by its Connected Components");
        graph3.checkConnected();
        System.out.println();
        graph3.primMST();


    }

}




