import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());

		int[] arr = new int[A];
		int[] dp = new int[A];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int r = 1;

		for (int i = 0; i < A; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i] && dp[i]<dp[j] +1) {
					dp[i] = dp[j]+1;
				}
			}
		}

		int max=0;
		
		for(int length: dp) {
			if(max<length) {
				max= length;
			}
		}
		System.out.println(max);
	}
}
