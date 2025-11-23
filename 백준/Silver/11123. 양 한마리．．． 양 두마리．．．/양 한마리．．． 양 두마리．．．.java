import java.util.*;
import java.io.*;

public class Main {
	// 4방향으로 연결되면 같은 섬
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map;
	static int cnt, n, m;
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
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			cnt=0;
			map = new char[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i] = str.toCharArray();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == '#' && visited[i][j] == false) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		

		}
		System.out.print(sb);
	}

	static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Pos node = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] == '#' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}
		}
	}
}
