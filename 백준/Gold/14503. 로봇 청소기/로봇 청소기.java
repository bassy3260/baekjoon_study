import java.io.*;
import java.util.*;

public class Main {

	static class Robot {
		int r;
		int c;
		// 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽을 바라보고 있는 것이다
		int pos;

		Robot(int r, int c, int pos) {
			this.r = r;
			this.c = c;
			this.pos = pos;
		}
	}

	public static void main(String[] args) throws IOException {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		Robot robot;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		boolean[][] isCleaned = new boolean[n][m];
		st = new StringTokenizer(br.readLine());
		robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		A: while (true) {
			// 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if (arr[robot.r][robot.c] == 0 && isCleaned[robot.r][robot.c] == false) {
				isCleaned[robot.r][robot.c] = true;
				cnt++;
			}

			boolean isChecked = false;
			
			// 주변 4칸 청소 확인 (북 동 남 서 순서)
			for (int i = 0; i < 4; i++) {
				// 반시계 방향으로 90도 회전한다.
				robot.pos -= 1;
				if (robot.pos<0) {
					robot.pos = 4+ robot.pos;
				}
				int nr = robot.r + dr[robot.pos];
				int nc = robot.c + dc[robot.pos];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
				if(arr[nr][nc] ==1 )continue;
				if(isCleaned[nr][nc] == true) continue;
				// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
			
				// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
				robot.r = nr;
				robot.c = nc;
				isChecked = true;
				break;
			}
			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
			if (isChecked == false) {
				// 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면
				int sr = robot.r - dr[robot.pos];
				int sc = robot.c - dc[robot.pos];

				// 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
				if (sr < 0 || sc < 0 || sr >= n || sc >= m) break A;
				if(arr[sr][sc] == 1) break A;
				
				// 한 칸 후진하고 1번으로 돌아간다.
				robot.r = sr;
				robot.c = sc;
			}
		}
		System.out.println(cnt);

	}
}
