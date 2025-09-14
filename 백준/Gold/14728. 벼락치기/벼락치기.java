import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 단원 수
		int T = Integer.parseInt(st.nextToken()); // 총 시간

		int[][] dp = new int[N + 1][T + 1];
		int[][] subject = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			subject[i][0] = Integer.parseInt(st.nextToken());
			subject[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int time = 0; time <= T; time++) {
				dp[i][time] = dp[i - 1][time];
				if (time < subject[i - 1][0])
					continue;
				dp[i][time] = Math.max(dp[i][time], dp[i - 1][time - subject[i-1][0]] + subject[i-1][1]);
			}
		}

		System.out.println(dp[N][T]);
	}
}
