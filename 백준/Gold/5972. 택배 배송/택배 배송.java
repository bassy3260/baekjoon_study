import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static List<Node>[] adjList;
	static int[] minDist;
	static int N,M;
	static class Node {
		int to;
		int weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st  =new StringTokenizer(br.readLine());
		 N =Integer.parseInt(st.nextToken());
		 M =Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N];
		for(int i = 0; i<N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		minDist = new int[N];
		visited = new boolean[N];
		
		for(int i = 0;i<M;i++) {
			st  =new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1; 
			int to= Integer.parseInt(st.nextToken())-1; 
			int weight= Integer.parseInt(st.nextToken()); 
			
			adjList[start].add(new Node(to,weight));
			adjList[to].add(new Node(start,weight));
		}
		dijkstra();
		System.out.println(minDist[N-1]);
	}
	
	private static void dijkstra() {
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[0] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((x,y)-> x.weight - y.weight);
		pq.offer(new Node(0,0));
		int cnt= 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int minIdx= cur.to;
			if(visited[minIdx]) continue;
			visited[minIdx] = true;
			if(++cnt == N) break;
			for(int i = 0;i<adjList[minIdx].size(); i++) {
				int to = adjList[minIdx].get(i).to;
				int weight = adjList[minIdx].get(i).weight;
				
				if(minDist[to]< minDist[minIdx] +weight) continue;
				minDist[to] = minDist[minIdx] +weight;
				pq.offer(new Node(to,minDist[to]));
			}
		}
		
	}
}
