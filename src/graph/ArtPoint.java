package graph;

import datastructure.Link;
import datastructure.LinkedList;

public class ArtPoint extends DFS {
	private int low[];
	private int currentRoot,rootChildren;
	
	public ArtPoint(Graph G) {
		super(G);
		low = new int[nodes+1];
		for(int x:low)
			x=-1;
	}
	
	public LinkedList articulationPoints() {
		dfsAll();
		return this.getList();
	}
	
	public void dfsAll() {
    	for(int i=1;i<=nodes;i++)
            if(!visited[i]) {
            	rootChildren = 0;
            	currentRoot = i;
                dfs(i);
                if(rootChildren>1)
                	list.addFront(i);
            }
    }
	
	protected void dfs(int node) {
		discovery[node] = ++time;
		low[node] = discovery[node];
        visited[node] = true;
        for(int i=1;i<=nodes;i++) {
            if(G.isConnected(node, i) && node!=i) {
            	if(!visited[i]) {
                    dfs(i);
                    if(node == currentRoot)
                    	rootChildren++;
                    if(low[i]<low[node])
                    	low[node] = low[i];
                    if(low[i] >= discovery[node] && node != currentRoot)
                    	list.addFront(node);
            	}
            	else if(discovery[i] < low[node])
            		low[node] = discovery[i];
            }
        }
        finishing[node] = ++time;
		//System.out.println(node + ": " + low[node]);
	}
	
	public void printAP() {
		articulationPoints();
		Link node = list.head;
		while((node=node.next)!=list.tail)
			System.out.println(node.val + " ");
	}
}
