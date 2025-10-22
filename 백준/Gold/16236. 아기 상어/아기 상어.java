import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int n;
	static int[][] map;
	static int now = 2; // 지금 물고기 크기
	static int eatCnt = 0; // 먹은 물고기 수
	static List<Pos> fishList = new ArrayList<>();
	static boolean[][] visited;
	static Pos shark;
	static int totalTime = 0;

	static class Pos implements Comparable<Pos> {
		int r;
		int c;
		int cnt;

		Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pos o) {
			if (this.cnt != o.cnt) {
				return this.cnt - o.cnt;
			} else if (this.r != o.r) {
				return this.r - o.r;
			} else {
				return this.c - o.c;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Pos(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
		// 게임 루프: 먹을 물고기가 없을 때까지 반복
		while (true) {
			// 1. 이번 턴에서 먹을 물고기 후보를 찾습니다 (BFS)
			bfs();

			// 2. 먹을 물고기가 없다면 엄마 상어에게 도움 요청 (게임 종료)
			if (fishList.isEmpty()) {
				break;
			}

			// 3. 정렬을 통해 우선순위가 가장 높은 물고기 선택
			Collections.sort(fishList);
			Pos targetFish = fishList.get(0);

			// 4. 물고기를 먹고 상어 상태 업데이트
			eatFishAndUpdate(targetFish);
		}
		System.out.println(totalTime);
	}

	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		fishList = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];
		q.offer(new Pos(shark.r, shark.c, 0));
		visited[shark.r][shark.c] = true;

		while (!q.isEmpty()) {
			Pos node = q.poll();
			for (int j = 0; j < 4; j++) {
				int nr = node.r + dr[j];
				int nc = node.c + dc[j];

				if (nr < 0 || nc < 0 || nr >= n || nc >= n)
					continue;
				if (map[nr][nc] > now)
					continue;
				if (visited[nr][nc])
					continue;
				if (map[nr][nc] > 0 && map[nr][nc] < now) {
					fishList.add(new Pos(nr, nc, node.cnt + 1));
				}
				visited[nr][nc] = true;
				q.offer(new Pos(nr, nc, node.cnt + 1));
			}
		}
	}

	static void eatFishAndUpdate(Pos targetFish) {
		totalTime += targetFish.cnt;
		
		eatCnt++;
		if (eatCnt == now) {
			now++;
			eatCnt = 0;
		}
		
		map[targetFish.r][targetFish.c] = 0;
		shark = new Pos(targetFish.r, targetFish.c, 0);
	}
}
