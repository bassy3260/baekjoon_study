import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);
		
		int[][] question = new int[q][2];
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			question[i][0] = Integer.parseInt(st.nextToken());
			question[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] pSum = new int[n+1];
		
		for(int i =0; i<n; i++) {
			pSum[i+1] = pSum[i] + a[i];
		}
		
		for(int i =0; i<q; i++) {
			System.out.println(pSum[question[i][1]] - pSum[(question[i][0]-1)] );
		}
	}
}
