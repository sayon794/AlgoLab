package graph;

import datastructure.LinkedList;


public class DFS {
    private Graph G;
    private int nodes;
    private boolean visited[];
    private int discovery[], finishing[];
    private int time=0;
    private LinkedList list;
    
    public DFS(Graph g) {
        G = g;
        nodes = G.getNodes();
        visited = new boolean[nodes+1];
        discovery = new int[nodes+1];
        finishing = new int[nodes+1];
        list = new LinkedList();
    }
    
    public void dfsFrom(int source) {
    	dfs(source);
    }
    
    public void dfsAll() {
    	for(int i=1;i<=nodes;i++) {
            if(!visited[i])
                dfs(i);
        }
    }
    
    private void dfs(int node) {
        discovery[node] = ++time;
        visited[node] = true;
        for(int i=1;i<=nodes;i++) {
            if(G.isConnected(node, i) && node!=i &&!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
        finishing[node] = ++time;
        list.addFront(node);
    }
    
    public boolean isVisited(int node) {
        return visited[node];
    }
    
    public void clearList() {
    	list = new LinkedList();
    }
    
    public LinkedList getList() {
        return list;
    }
}
