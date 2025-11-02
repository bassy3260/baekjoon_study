import java.io.*;
import java.util.*; 

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int[] arr =new int[n];
		
		for(int i = 0;i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = Integer.MAX_VALUE;;
		//바깥쪽 for문: b[0]
		if(arr.length > 1) {
		for(int i =-1; i<=1;i++) {
			//안쪽 for문 : b[1]
			for(int j = -1; j<=1; j++) {
				int cnt = 0;
				if(i !=0) cnt++;
				if(j!=0)cnt++;
				int firstTerm = arr[0]+i;
				int diff = (arr[1]+j) - firstTerm ; 
				for(int k = 2; k<n; k++) {
					int exValue = firstTerm + (k*diff); 
					if(Math.abs(exValue - arr[k]) == 1) {
						cnt++;
					}else if(Math.abs(exValue - arr[k]) > 1){
						cnt = Integer.MAX_VALUE;
						break;
					}
				}
				result = Math.min(cnt, result);
			}
		}
		if(result == Integer.MAX_VALUE)result = -1;
		System.out.println(result);
		}else {
			System.out.println(0);
		}
	}
}
