import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static ArrayList<Integer> result;
	static int[][] arr;
	static int cnt;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		result= new ArrayList<>();
		arr = new int[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			for (int j = b; j < d; j++) {
				for (int k = a; k < c; k++) {
					arr[j][k] = 1;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					cnt = 1;
					bfs(i, j);
					result.add(cnt);
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for (int a : result) {
			System.out.print(a + " ");
		}
	}

	static void bfs(int r, int c) {
		
		arr[r][c] = 1;
		for (int a = 0; a < 4; a++) {
			int nr = dr[a] +r;
			int nc = dc[a] + c;

			if (nr < 0 || nc < 0 || nr >= M || nc >= N )
				continue;
			if(arr[nr][nc]==1) continue;
			cnt++;
			bfs(nr, nc);
		}

	}
}
