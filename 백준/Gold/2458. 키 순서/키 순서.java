import java.io.*;
import java.util.*;

public class Main {
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dist = new int[n][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			dist[a][b] = 1;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dist[i][k] == 1 && dist[k][j] == 1) {
						dist[i][j] = 1;
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {

			int a = 0;
			int b = 0;
			for (int j = 0; j < n; j++) {
				if (dist[i][j] == 1) {
					a++;
				}
				if (dist[j][i] == 1) {
					b++;
				}
			}
			if (a + b == n - 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
