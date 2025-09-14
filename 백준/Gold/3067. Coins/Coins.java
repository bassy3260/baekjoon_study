import java.io.*;
import java.util.*;

// 이건 0-1 냅색..
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		 while (T-- > 0) {
			int N =Integer.parseInt(br.readLine());
			
			int[] coins = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			
			int M= Integer.parseInt(br.readLine());
			
			int[] dp = new int[M+1]; 
			
			dp[0] = 1;
		
			for(int coin:coins) {
				for(int cost = coin; cost<=M; cost++) {
					dp[cost] = dp[cost] + dp[cost - coin];
				}
			}
			sb.append(dp[M]).append("\n");
		}
		System.out.println(sb);
		
	}
}
