import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int n;
	static int m;
	static boolean[] inProgress;
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 n= Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		parent = new int[n];
	
		for(int i = 0;i<n;i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			graph.add(arr);
			parent[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(b).add(a);
			graph.get(a).add(b);

			if(!union(a,b)) {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println(0);
	}
	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	// 사이클을 어떻게 체크하지
	public static boolean union(int x,int y) {
		int rootX = find(x);
		int rootY = find(y);
		if(rootX==rootY) return false;
		parent[rootY] = rootX;
		return true;
	}
}
