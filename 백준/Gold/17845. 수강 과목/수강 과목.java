import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 최대 공부시간
		int K = Integer.parseInt(st.nextToken()); // 과목 수

		int[][] dp = new int[K + 1][N + 1]; 
		int[][] subject = new int[K][2]; // 중요도, 공부시간

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			subject[i][0] = Integer.parseInt(st.nextToken());
			subject[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= K; i++) {
			for (int time = 0; time <= N; time++) {
				dp[i][time] = dp[i - 1][time];
				if (time < subject[i - 1][1])
					continue;
				dp[i][time] = Math.max(dp[i][time], dp[i - 1][time - subject[i - 1][1]] + subject[i - 1][0]);
			}
		}

		System.out.println(dp[K][N]);
	}
}
