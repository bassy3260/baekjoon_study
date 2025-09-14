/**
 * 증가하는 부분 수열의 합을 구하는 거래..
 * 지워가는 방식은 시간이 엄청 오래걸려~~
 * d = { a b c d} dp = new int[4];
 * a<c<d 관계에서 d => a+ c+d, a+c를 가지고 있으면 d만 가지면 됨!!
 * dp[2] => dp[0] + dp[2]
 * dp[3] = dp[2] + dp[3] 
 * for i (0<n)
 * 	for j (0 < j)
 * 		if( d[j] < d[i]) 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int A =Integer.parseInt(br.readLine());
		
		int[] arr= new int[A];
		int[] dp= new int[A];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i = 0;i<A;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		int r = dp[0]; // 가장 큰 증가 부분 수열의 합
		
		for(int i = 1; i<A; i++) {
			for(int j = 0; j<i; j++) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i] += arr[i];
			r = Math.max(r, dp[i]);
		}
		
		System.out.println(r);
	}
}
