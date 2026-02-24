import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] cost = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] result = new int[3];
		int[][] dp = new int[n + 1][3];
		// R로 시작하는 경우 G로 시작하는 경우 B로 시작하는 경우..
		// R -> G나 B -> 나머지하나
		// G나 B 위쪽도 확인해야하네

		for (int j = 0; j < 3; j++) {
			if (j == 0) {
				dp[1][0] = cost[1][0];
				dp[1][1] = 1000001;
				dp[1][2] = 1000001;
			}else if(j ==1) {
				dp[1][0] = 1000001;
				dp[1][1] = cost[1][1];
				dp[1][2] = 1000001;
			}else {
				dp[1][0] = 1000001;
				dp[1][1] = 1000001;
				dp[1][2] = cost[1][2];
			}
			for (int i = 2; i <= n; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
			}

			if (j == 0) {
				result[j] = Math.min(dp[n][1], dp[n][2]);
			} else if (j == 1) {
				result[j] = Math.min(dp[n][0], dp[n][2]);
			} else {
				result[j] = Math.min(dp[n][0], dp[n][1]);
			}
		}

		int ans = Math.min(result[0], Math.min(result[1], result[2]));
		System.out.println(ans);
	}
}
