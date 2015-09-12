
import graph.ArtPoint;


public class Main {
    public static void main(String args[]) {
        FileInput fin = new FileInput();
        
        ArtPoint AP = new ArtPoint(fin.G);
        AP.printAP();
        /*SCC scc = new SCC(fin.G);
        scc.printComponents();
        
        Graph Gcc1 = scc.componentConnectivity();
        scc.setEdge(fin.n1, fin.n2);
        Graph Gcc2 = scc.componentConnectivity();
        boolean changed[] = new boolean[scc.CC+1];
        
        for(int i=1;i<=scc.CC;i++) 
        	for(int j=1;j<=scc.CC;j++) 
        		if(i!=j&&Gcc1.isConnected(i,j)!=Gcc2.isConnected(i,j))
        			changed[i]=changed[j]=true;
        
        for(int i=1;i<=scc.CC;i++) 
        	if(changed[i])
        		System.out.println("Component "+i+" was affected");*/
        
    }
}
