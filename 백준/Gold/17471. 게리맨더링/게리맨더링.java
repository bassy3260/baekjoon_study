import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] selected;
	static boolean[] visited;
	static int[] pop;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		pop = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>(i));
			pop[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j<num; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		selected = new boolean[n];
		divide(0);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	public static void divide(int index) {
		if (index == n) {
			int startNodeA = -1;
			int startNodeB = -1;
			int countA = 0;
			for (int i = 0; i < n; i++) {
				if (selected[i]) {
					countA++;
					if (startNodeA == -1) {
						startNodeA = i;
					}
				} else {
					if (startNodeB == -1) {
						startNodeB = i;
					}
				}
			}
			if (countA == 0 || countA == n) {
				return; // 그룹 A가 비었거나 전체 구역이라면 유효하지 않은 분할
			}
			visited = new boolean[n];
			int countB = n - countA;

			Queue<Integer> q = new LinkedList<>();
			q.add(startNodeA);
			visited[startNodeA] = true;
			int connectedCountA = 1;
			while (!q.isEmpty()) {
				int node = q.poll();
				ArrayList<Integer> nodeArr = graph.get(node);
				for (int a : nodeArr) {
					if (visited[a])
						continue;
					if (!selected[a])
						continue;
					q.add(a);
					visited[a] = true;
					connectedCountA++;
				}
			}
			if (connectedCountA != countA)
				return;

			q.add(startNodeB);
			visited[startNodeB] = true;
			int connectedCountB = 1;
			while (!q.isEmpty()) {
				int node = q.poll();
				ArrayList<Integer> nodeArr = graph.get(node);
				for (int a : nodeArr) {
					if (visited[a])
						continue;
					if (selected[a])
						continue;
					q.add(a);
					visited[a] = true;
					connectedCountB++;
				}
			}
			if (connectedCountB != countB)
				return;

			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i < n; i++) {
				if (selected[i]) {
					sumA += pop[i];
				} else {
					sumB += pop[i];
				}
			}
			min = Math.min(min, Math.abs(sumA-sumB));
			return;
		}

		selected[index] = true;
		divide(index + 1);

		selected[index] = false;
		divide(index + 1);
	}
}
