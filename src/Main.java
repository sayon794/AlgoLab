
import graph.Graph;
import graph.TopoSort;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        int nodes,edges;
        Scanner S = new Scanner(System.in);
        nodes = S.nextInt();
        edges = S.nextInt();
        Graph G = new Graph(nodes);
        int a,b;
        for(int i=0;i<edges;i++) {
            a = S.nextInt();
            b = S.nextInt();
            G.connect(a, b, false);
        }
        
        TopoSort T = new TopoSort(G);
        T.countType();
        T.printArray();
    }
}
