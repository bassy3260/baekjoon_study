import java.io.*;
import java.util.*;

public class Main {
	static int n,c;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 c = Integer.parseInt(st.nextToken());

		 arr = new int[n];

		// 이게 어떻게 이분탐색이지
		// 먼저 배열을 정렬해야하나?

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		// 그다음에 이분탐색?
		// 최소거리: 제일 작은 값, 최대 거리: 제일 큰 값
		// 이분탐색은? 중간값을 공유기사이의 최소 거리라고 가정
		
		int low = 1;
		int high = arr[n-1];
		int ans = 0 ;
		
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				low = mid +1;
			}else {
				high = mid-1;
			}
		}
		System.out.println(ans);
	}

	static boolean check (int distance) {
		int count = 1;
		int last_location = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - last_location >= distance) {
				count += 1;
				last_location = arr[i];
			}
		}
		if (count >= c) {
			return true;
		} else {
			return false;
		}
	}
}
