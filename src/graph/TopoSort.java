package graph;

import datastructure.LinkedList;

public class TopoSort {
    private Graph G;
    private DFS D;
    private LinkedList list;
    //private boolean adjMat[][];
    private int indegree[],sorted[];
    private int nodes;
    private boolean checked[];
    
    public TopoSort(Graph g) {
        G = g;
    }
    
    public void countType() {
        nodes = G.getNodes();
        //adjMat = G.getMat();
        indegree = new int[nodes+1];
        sorted = new int[nodes+1];
        checked = new boolean[nodes+1];
        
        for(int i=1;i<=nodes;i++)
            for(int j=1;j<=nodes;j++)
                if(G.isConnected(i,j))
                    indegree[j]++;
        
        int n=0;
        for(int i=0;i<nodes;i++)
            for(int j=1;j<=nodes;j++)
                if(indegree[j]==0&&!checked[j]) {
                    checked[j] = true;
                    sorted[n++] = j;
                    for(int k=1;k<=nodes;k++)
                        if(G.isConnected(j,k))
                            indegree[k]--;
                }
    }
    
    public void printArray() {
        if(sorted == null)
            return;
        for(int i=0;i<nodes;i++)
            System.out.print(sorted[i] + " ");
        System.out.println();
    }
    
    public void dfsType() {
        D = new DFS(G);
        D.dfsAll();
        list = D.getList();
    }
    
    public void printList() {
        if(list.empty()||list==null)
            return;
        list.node = list.head.next;
        while(list.node!=list.tail) {
            System.out.print(list.node.val + " ");
            list.node = list.node.next;
        }
        System.out.println();
    }
    
    
}
