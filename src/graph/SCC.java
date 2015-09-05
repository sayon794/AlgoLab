package graph;

import datastructure.Link;
import datastructure.LinkedList;

public class SCC {
	Graph G,Gt;
	LinkedList list,components[];
	DFS D;
	int CC,nodes;
	boolean listed[];
	
	public SCC(Graph G) {
		this.G = G;
		nodes = G.getNodes();
		listed = new boolean[nodes+1];
		components = new LinkedList[nodes+1];
		CC=0;
		
		D = new DFS(G);
		D.dfsAll();
		list = D.getList();
		Gt = G.transpose();
		D = new DFS(Gt);
		while(!list.empty()) {
			int node = list.head.next.val;
			//System.out.println(node);
			if(!D.isVisited(node)) {
				D.dfsFrom(node);
				components[CC++] = D.getList();
				D.clearList();
				for(int i=1;i<nodes;i++) {
					if(D.isVisited(i)&&!listed[i]) {
						listed[i]=true;
					}
				}
			}
			list.removeFront();
		}
	}
	
	public void printComponents() {
		for(int i=0;i<CC;i++) {
			Link node = components[i].head;
			System.out.println("Component " + (i+1) + ":");
			while((node=node.next)!=components[i].tail) {
				System.out.print(node.val + " ");
			}
			System.out.println();
		}
	}
	
}
