import java.io.*;
import java.util.*;

public class Main {
	static int[][] needs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		// 필요한 부품 수 넣기
		needs = new int[n + 1][n + 1];

		ArrayList<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		int[] inDegree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj.get(b).add(new int[] { a, c });
			inDegree[a]++;
		}

		topologicalSort(n, adj, inDegree);

		for (int i = 1; i <= n; i++) {
			if (needs[i][i] == 1) {
				System.out.println(i + " " + needs[n][i]);
			}
		}
	}

	public static void topologicalSort(int N, List<List<int[]>> adj, int[] inDegree) {
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
				needs[i][i] = 1;
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();
			// node가 5라면 ...
			for (int[] neighbor : adj.get(node)) {

				int a = neighbor[0]; // node.를 재료로 사용하는 다음 조립 부품
				int c = neighbor[1]; // a 1개를 만드는 데에 필요한 node의 수량
				inDegree[a]--;
				for (int i = 1; i <= N; i++) {
					needs[a][i] += needs[node][i] * c;
				}
				if (inDegree[a] == 0) {
					q.add(a);
				}

			}
		}
	}
}
