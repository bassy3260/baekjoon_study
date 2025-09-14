import java.io.*;
import java.util.*;

public class Main{
	static int N;// 물품의 갯수
	static int K; // 버틸수 있는 무게
	static int[] W; // 각 물건의 무개
	static int[] V; // 각 물건의 가치

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N];
		V = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N + 1][K + 1];
		// 냅색 시작
		// 식재료 만큼 돌거임
		for (int i = 1; i <= N; i++) {
			// 무게만큼
			for (int weight = 0; weight <= K; weight++) {
				dp[i][weight] = dp[i - 1][weight];
				if (weight < W[i-1])
					continue;
				dp[i][weight] = Math.max(dp[i][weight], dp[i - 1][weight - W[i-1]] + V[i-1]);
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
