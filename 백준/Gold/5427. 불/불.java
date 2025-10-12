import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static char[][] map;
	static int[][] firemap;
	static boolean[][] visited;
	static int w;
	static int h;

	static class Node {
		int r;
		int c;
		int cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	// 출구의 조건? 각변의 끝부분..
	static Queue<Node> q = new LinkedList<>();
	static Queue<Node> fireQ = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			q.clear();
			fireQ.clear();
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			firemap = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				Arrays.fill(firemap[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '@') {
						q.offer(new Node(i, j, 0));
						visited[i][j] = true;
					} else if (map[i][j] == '*') {
						fireQ.offer(new Node(i, j, 0));
						  firemap[i][j] = 0;
					}
				}
			}
			firebfs();
			int result = sbfs();
			if (result == -1) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result);
			}
		}
	}

	static void firebfs() {
		while (!fireQ.isEmpty()) {
			Node node = fireQ.poll();
			for (int i = 0; i < 4; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];

				if (nr >= h || nc >= w || nr < 0 || nc < 0)
					continue;
				if (map[nr][nc] == '#')
					continue;
				if (firemap[nr][nc] <= node.cnt + 1)
					continue;
				firemap[nr][nc] = node.cnt + 1;
				fireQ.offer(new Node(nr, nc, node.cnt + 1));
			}
		}
	}

	static int sbfs() {
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
					return node.cnt + 1; // 현재까지 온 시간이 바로 탈출 시간
				}
				if (nr >= h || nc >= w || nr < 0 || nc < 0)
					continue;
				if (map[nr][nc] == '#')
					continue;
				if (visited[nr][nc])
					continue;
				if (firemap[nr][nc] <= node.cnt + 1)
					continue;

				visited[nr][nc] = true;
				q.offer(new Node(nr, nc, node.cnt + 1));
			}
		}
		return -1;
	}
}
