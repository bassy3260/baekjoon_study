import java.io.*;
import java.util.*;

public class Main {
	static int[] dh = { 0,0,0,0,-1, 1 };
	static int[] dr = { 1, 0, -1, 0, 0, 0 };
	static int[] dc = { 0, 1, 0, -1, 0, 0 };

	static int L;
	static int R;
	static int C;
	static char[][][] arr;
	static Queue<Pos> q;
	static boolean[][][] visited;
	static int cnt;

	static class Pos {
		int h;
		int r;
		int c;
		int dis;

		Pos(int h, int r, int c,int dis) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.dis= dis;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			cnt = 0;
			visited = new boolean[L][R][C];
			arr = new char[L][R][C];
			q = new LinkedList<>();
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					for (int k = 0; k < C; k++) {
						arr[i][j][k] = str.charAt(k);
						if (arr[i][j][k] == 'S') {
							q.offer(new Pos(i, j, k,0));
							visited[i][j][k] = true;
						}
					}
				}
				br.readLine();
			}
			cnt = bfs();
			if (cnt != 0) {
				sb.append("Escaped in ").append(cnt).append(" minute(s).").append("\n");
			} else {
				sb.append("Trapped!").append("\n");
			}
		}
		System.out.println(sb);
	}

	public static int bfs() {
		while (!q.isEmpty()) {
			Pos node = q.poll();
			int nh = node.h;
			int nr = node.r;
			int nc = node.c;
			
			if (arr[nh][nr][nc] == 'E') {
				return node.dis;
			}
			for (int i = 0; i < 6; i++) {
				int sh = nh + dh[i];
				int sr = nr + dr[i];
				int sc = nc + dc[i];

				if (sh < 0 || sr < 0 || sc < 0 || sh >= L || sr >= R || sc >= C)
					continue;
				if (visited[sh][sr][sc])
					continue;
				if (arr[sh][sr][sc] == '#')
					continue;
				visited[sh][sr][sc] = true;
				q.offer(new Pos(sh, sr, sc,node.dis+1));
				cnt++;
			}
		}
		return 0;
	}
}
