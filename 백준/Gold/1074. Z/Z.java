import java.io.*;
import java.util.*;

public class Main {
	static int mid;
	static int area;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		
		
		int cnt = solve(N,r,c);
		
		System.out.println(cnt);
	}
	
	public static int solve(int n, int r,int c) {
	
		if(n==0) {
			return 0;
		}
	
		mid = (int) Math.pow(2, (n-1)); // 한 변의 길이 절반 
		area = mid * mid; //한 사분면의 넓이
		
		if(r<mid && c<mid) {
			return solve(n-1,r,c);
		}
		
		if(r<mid && c>=mid) {
			// 2사분면
			return area+ solve(n-1,r,c-mid);
		}
		if(r>=mid && c<mid) {
			// 3사분면
			return 2*area+ solve(n-1,r-mid,c);
		}
		return 3* area + solve(n-1,r-mid,c-mid);
	}
}
