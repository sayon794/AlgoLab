package graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
	
	class NODE {
		int n,disc;
		NODE(int n,int disc) { this.n = n; this.disc = disc; }
	}
	
	private WeightedGraph G;
	private int nodes,d[];
	private boolean visited[];
	
	private PriorityQueue<NODE> PQ;
	
	public Dijkstra(WeightedGraph G) {
		this.G = G;
		nodes = G.getNodes();
		PQ = new PriorityQueue<NODE>(nodes,new Comparator<NODE>(){
			public int compare(NODE u, NODE v) {
				return u.disc - v.disc;			//may have to reverse position
			}
		});
	}
	
	public void shortestPath(int source) {
		init();
		d[source] = 0;
		PQ.offer(new NODE(source,d[source]));
		
		while(!PQ.isEmpty()) {
			int u = PQ.poll().n;
			if(visited[u])
				continue;
			
			visited[u] = true;
			for(int i=1;i<=nodes;i++) {
				if(G.isConnected(u, i)) {
					int w = G.getDist(u, i);
					if(d[i]==-1 || d[u]+w < d[i]) {
						d[i] = d[u]+w;
						PQ.offer(new NODE(i,d[i]));
					}
				}
			}
		}
		
	}
	
	private void init() {
		d = new int[nodes+1];
		visited = new boolean[nodes+1];
		for(int i=1;i<=nodes;i++) 
			d[i]=-1;
	}
	
	
	public int getDistance(int node) { return d[node]; }
}
