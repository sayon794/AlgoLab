package graph;

import datastructure.LinkedList;


public class DFS {
    protected Graph G;
    protected int nodes;
    protected boolean visited[];
    protected int discovery[], finishing[];
    protected int time=0;
    protected LinkedList list;
    
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
    
    protected void dfs(int node) {
        discovery[node] = ++time;
        visited[node] = true;
        for(int i=1;i<=nodes;i++) {
            if(G.isConnected(node, i) && node!=i &&!visited[i]) {
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
