import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n =Integer.parseInt(st.nextToken()); //가수의 수
		int m =Integer.parseInt(st.nextToken()); //보조 pd의 수
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i =0; i<=n;i++) {
			adj.add(new ArrayList<>());
		}
		int[] inDegree = new int[n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int now = Integer.parseInt(st.nextToken());
				adj.get(prev).add(now);
				inDegree[now]++;
				prev = now;
			}
		}
		List<Integer> result = topologicalSort(n, adj, inDegree);
		
		if(result.size()!=n ) {
			System.out.println(0);
		}else{
			for(int num:result) {
				System.out.println(num);
			}
		}
		
	}
	public static List<Integer> topologicalSort(int n, ArrayList<ArrayList<Integer>> adj, int[] inDegree) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer> result= new ArrayList<>();
		
		for(int i = 1; i<=n; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
				
			}
		} 
		
		while(!q.isEmpty()) {
			int node =q.poll();
			result.add(node);
			
			for(int num: adj.get(node)) {
				inDegree[num]--;
				if(inDegree[num] == 0) {
					q.add(num);
				}
			}
		}
		return result;
	}
}
