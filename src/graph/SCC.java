package graph;

import datastructure.Link;
import datastructure.LinkedList;

public class SCC {
	private Graph G,Gt;
	private LinkedList list,components[];
	private DFS D;
	public int CC;
	private int nodes;
	private boolean listed[];
	
	
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
	
	public Graph componentConnectivity() {
		Graph Gcc = new Graph(CC+1);
		for(int i=0;i<CC;i++) {
			int node = components[i].head.next.val;
			DFS D = new DFS(G);
			D.dfsFrom(node);
			for(int j=0;j<CC;j++) {
				if(j!=i&&D.isVisited(components[j].head.next.val))
						Gcc.connect(i+1, j+1, false);
			}
		}
		return Gcc;
	}
	
	public void setEdge(int a,int b) {
		if(G.isConnected(a, b)) {
			System.out.println("Already exists");
			return;
		}
		G.connect(a, b, false);
	}
	
	/*public void newEdge(int a,int b) {
		if(G.isConnected(a, b)) {
			System.out.println("Already exists");
			return;
		}
		
		boolean unreachable[] = new boolean[CC+1];
		//boolean vis2[] = new boolean[CC+1];
		D = new DFS(Gt);
		D.dfsFrom(b);
		for(int i=0;i<CC;i++)
			if(!D.isVisited(components[i].head.next.val))
				unreachable[i]=true;
		
		Gt.connect(b,a,false);
		
		D = new DFS(G);
		D.dfsFrom(b);
		for(int i=0;i<CC;i++)
			if(D.isVisited(components[i].head.next.val)&&unreachable[i])
				System.out.println("Component "+(i+1)+" was affected");
	}*/
	
	/*public void getFlags() {
		G.componentFlag = new int[nodes+1];
		for(int i=0;i<CC;i++) {
			Link node = components[i].head;
			while((node=node.next)!=components[i].tail) {
				G.componentFlag[node.val]=i;
			}
		}
	}*/
}
