import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] time;
	static List<List<Integer>> adj = new ArrayList<>();
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		time = new int[n+1];
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		int[] inDegree = new int[n + 1];
		 cnt = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			time[i] = num;
			while (st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				if (a == -1) {
					break;
				} else {
					adj.get(a).add(i);
					inDegree[i]++;
				}
			}
		}

		topologicalSort(adj, inDegree);

		for (int i = 1; i <= n; i++) {
			System.out.println(cnt[i]);
		}
	}

	public static List<Integer> topologicalSort(List<List<Integer>> adj, int[] inDegree) {
		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
				cnt[i] = time[i];
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();
			result.add(node);

			for (int neighbor : adj.get(node)) {
				cnt[neighbor] = Math.max(cnt[neighbor], cnt[node] );
				inDegree[neighbor]--;

				if (inDegree[neighbor] == 0) {
					cnt[neighbor] += time[neighbor];
					q.add(neighbor);
				}
			}
		}

		return result;
	}
}
