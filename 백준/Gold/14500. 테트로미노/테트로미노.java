
import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] map;
	static int max = 0;

	static int n;
	static int m;
	static boolean[][] visited;

	static class Pos {
		int r;
		int c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(max);
	}

	static void dfs(int r, int c, int cnt, int sum) {
		if (cnt == 4) {
			max = Math.max(sum, max);
			return;
		}
		if (r < 0 || c < 0 || r >= n || c >= m) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
				continue;
			}

			if (visited[nr][nc])
				continue;

			if (cnt == 2) {
				visited[nr][nc] = true;
				dfs(r, c, cnt + 1, sum + map[nr][nc]);
				visited[nr][nc] = false;
			}

			visited[nr][nc] = true;
			dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
			visited[nr][nc] = false;

		}

	}
}
