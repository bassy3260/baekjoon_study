import java.io.*;
import java.util.*;

public class Main {
	static int[] minDist;
	static boolean[] visited;
	static int V, E; // 정점의 갯수, 간선의 갯수
	static int K; // 시작 정점의 번호
	static List<Node>[] adjList;

	static class Node {
		int to; // 목적지 정점
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new List[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new ArrayList<>();
		minDist = new int[V];
		visited = new boolean[V];
		K = Integer.parseInt(br.readLine()) - 1;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, weight));
		}
		dijkstra();
		for(int i = 0; i<V;i++) {
			if(minDist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(minDist[i]);
		}
	}

	private static void dijkstra() {
		// TODO Auto-generated method stub
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[K] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
		pq.offer(new Node(K,0));
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int minIdx = cur.to;
			if(visited[minIdx]) continue;
			
			visited[minIdx] = true;
			if(++cnt == V ) break;
			for(Node n: adjList[minIdx]) {
				int to = n.to;
				int weight = n.weight;
				
				if(minDist[to] < minDist[minIdx] + weight) continue;
				minDist[to] = minDist[minIdx] + weight;
				pq.offer(new Node(to,minDist[to]));
			}
		}
	}

}
