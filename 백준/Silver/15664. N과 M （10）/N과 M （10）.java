import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;
	static int N;
	static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[R];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		dfs(0,0);
		System.out.println(sb);
	}

	static void dfs(int depth, int start) {
		if (R == depth) {
			for (int num : result) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		int prev = Integer.MIN_VALUE;
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				if (prev == arr[i])
					continue;
				visited[i] = true;
				result[depth] = arr[i];
				dfs(depth + 1, i+1);
				visited[i] = false;
				prev = arr[i];
			}
		}
	}
}
