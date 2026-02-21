import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Long[] arr= new Long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int low = 0; // 제일 작은거
		int high = n-1; // 제일 큰거
		Long now = Long.MAX_VALUE; //둘이 합한 값, 초기 값은 그냥 제일 큰거
		Long ansLow = arr[low]; // 이게 정답 출력 작은 쪽
		Long ansHigh = arr[high];//정답 출력 큰 쪽
		while(low<high) {
			Long sum =arr[low]+arr[high]; // 둘이 합한 값이 0에서 얼마나 떨어져있는지?
			// 이번 중간값이 원래 중간값보다 작으면..
			if( Math.abs(sum) < now) {
				// sum이  0보다 작다면??... low++
				ansLow = arr[low];
				ansHigh = arr[high];
				now = Math.abs(sum);
			}
			if(sum<0) {
				low++;
			}else {
				high--;
			}
		}
		
		System.out.println(ansLow+" "+ansHigh);
	}
}
