import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[][] map;
	static boolean[][] visited;

	static int n, m;
	static int cnt;

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
		visited = new boolean[n][m];
		cnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					if( bfs(i, j)) {
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);

	}

	static boolean bfs(int r, int c) {

		Queue<Pos> q = new LinkedList<>();

		q.offer(new Pos(r, c));
		visited[r][c] = true;

		boolean isTop = true; // 이 뭉치가 산봉우리인지 여부
		int currentHeight = map[r][c];
		while (!q.isEmpty()) {
			Pos node = q.poll();

			for (int i = 0; i < 8; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (map[nr][nc] > currentHeight) {
					isTop = false;
				}
				
				if (!visited[nr][nc] && map[nr][nc] == currentHeight) {
					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}
		}
		return isTop;
	}
}
