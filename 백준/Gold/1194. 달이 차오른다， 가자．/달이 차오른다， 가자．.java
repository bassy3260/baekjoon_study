import java.util.*;
import java.io.*;

/**
 * 빈 칸: 언제나 이동할 수 있다. ('.') 벽: 절대 이동할 수 없다. ('#') 열쇠: 언제나 이동할 수 있다. 이 곳에 처음 들어가면
 * 열쇠를 집는다. ('a', 'b', 'c', 'd', 'e', 'f') 문: 대응하는 열쇠가 있을 때만 이동할 수 있다. ('A','B',
 * 'C', 'D', 'E', 'F') 민식이의 현재 위치: 빈 곳이고, 민식이가 현재 서 있는 곳이다. ('0') 출구: 달이 차오르기
 * 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. ('1')
 * 
 * 미로의 세로 크기 N과 가로 크기 M이 주어진다. 둘째 줄부터 N개의 줄에 미로의 모양이 주어진다. 같은 타입의 열쇠가 여러 개 있을 수
 * 있고, 문도 마찬가지이다. '0'은 한 개, '1'은 적어도 한 개 있다. 열쇠는 여러 번 사용할 수 있다.
 */

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Node> q = new LinkedList<>();

	static class Node {
		int r;
		int c;
		int cnt;
		int key;

		Node(int r, int c, int cnt, int key) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[64][N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					q.offer(new Node(i, j, 0, 0));
					visited[0][i][j] = true;
				}
			}
		}
		int result = bfs();
		System.out.println(result);
	}

	static int bfs() {
		while (!q.isEmpty()) {
			Node node = q.poll();
			int row = node.r;
			int col = node.c;
			int cnt = node.cnt;
			int key = node.key;
			if (map[node.r][node.c] == '1') {
				return cnt;
			}
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (map[nr][nc] == '#')
					continue;
				if (visited[key][nr][nc])
					continue;
				if (map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1') {
					visited[key][nr][nc] = true;
					q.offer(new Node(nr, nc, cnt + 1, key));

					// 열쇠
				} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
					int newkey = 1 << (map[nr][nc] - 'a');
					newkey = newkey | key;
					if (!visited[newkey][nr][nc]) {
						visited[key][nr][nc] = true;
						visited[newkey][nr][nc] = true;
						q.offer(new Node(nr, nc, cnt + 1, newkey));
					}
					// 문
				} else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
					int door = 1 << (map[nr][nc] - 'A');
					if ((key & door) > 0) {
						visited[key][nr][nc] = true;
						q.offer(new Node(nr, nc, cnt + 1, key));
					}
				}
			}
		}
		return -1;
	}
}
