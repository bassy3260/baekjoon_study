import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr= new int[n];
		
		for(int i = 0;i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		
		int[][] prefix = new int[m][2];
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			prefix[i][0] = Integer.parseInt(st.nextToken());
			prefix[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] prefixSum = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			prefixSum[i] = prefixSum[i-1] + arr[i-1]; 
		}
		
		for(int i = 0; i<m; i++) {
			System.out.println(prefixSum[prefix[i][1]] -prefixSum[prefix[i][0]-1]);
			
		}
	}
}
