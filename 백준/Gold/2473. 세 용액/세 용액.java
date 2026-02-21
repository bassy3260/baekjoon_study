import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Long[] arr = new Long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);
		
		
		Long now = Long.MAX_VALUE; // 둘이 합한 값, 초기 값은 그냥 제일 큰거
		
		Long ansLow = 0L;
		Long ansHigh = 0L;
		int ansPos = 0;
		for (int i = 0; i < n-2; i++) {
			int low = i+1; // 제일 작은거
			int high = n - 1; // 제일 큰거
			while (low < high) {
				Long sum = arr[low] + arr[high] + arr[i]; // 둘이 합한 값이 0에서 얼마나 떨어져있는지?
				Long absSum = Math.abs(sum);
				
				// 이번 중간값이 원래 중간값보다 작으면..
				if (absSum < now) {
					ansLow = arr[low];
					ansHigh = arr[high];
					ansPos = i;
					now = absSum;
				}
				if (sum < 0) {
					low++;
				} else {
					high--;
				}
			}
		}

		System.out.println(arr[ansPos]+" "+ansLow +" " +ansHigh);
	}
}
