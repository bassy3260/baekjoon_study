import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 나무의 갯수
		int m = Integer.parseInt(st.nextToken()); // 가져갈 나무
		
		int[] arr = new int[n];
				
		st =new StringTokenizer(br.readLine());
		int max= 0;
		int min= 0;
		for(int i = 0; i< n; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		while(min<max) {
			int mid = (max + min) /2;
			long sum = 0;
			for(int i = 0; i<n; i++) {
				int a = arr[i] - mid; 
				if(a>0) {
					sum += a;
				}
			}
			
			if(sum < m) {
				max = mid;
			}else {
				min = mid +1;
			}
		}
		System.out.println(min-1 );
	}
}
