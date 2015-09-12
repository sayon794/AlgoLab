import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import graph.Graph;

public class FileInput {
	public int n1,n2;
	public Graph G;
	public FileInput() {
		File fin = new File("in.txt");
		int nodes,edges;
        Scanner S = null;
		try {
			S = new Scanner(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        nodes = S.nextInt();
        edges = S.nextInt();
        G = new Graph(nodes);
        int a,b;
        for(int i=0;i<edges;i++) {
            a = S.nextInt();
            b = S.nextInt();
            G.connect(a, b, true);
        }
        //n1 = S.nextInt();
        //n2 = S.nextInt();
	}
}
