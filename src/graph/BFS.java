package graph;

import datastructure.Queue;

public class BFS {
    private Graph G;
    private Queue Q;
    private int source,nodes;
    private int dist[];
    private boolean visited[];
    
    public BFS(Graph g,int s) {
        Q = new Queue();
        G = g;
        source = s;
        nodes = G.getNodes();
        
        dist = new int[nodes+1];
        visited = new boolean[nodes+1];
        
        visited[source] = true;
        Q.push(source);
        while(!Q.empty()) {
            int u = Q.pop();
            for(int i=1;i<=nodes;i++) {
                if(G.isConnected(u, i)) {
                    int v = i;
                    if(!visited[v]) {
                        visited[v] = true;
                        dist[v] = dist[u] + 1;
                        Q.push(v);
                    }
                }
            }
        }
        
        for(int i=0;i<=nodes;i++)
            if(!visited[i])
                dist[i] = -1;
    }
    
    public int search(int dest) {
        return dist[dest];
    }
    
    public int[] search() {
        return dist;
    }
}
