import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] darr = new int[n / 2];
		int[] uarr = new int[n / 2];
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				darr[i / 2] = Integer.parseInt(br.readLine()); // 종유석
			} else {
				uarr[i / 2] = Integer.parseInt(br.readLine()); // 석순
			}
		}

		// 오름차순 정렬
		Arrays.sort(darr);
		Arrays.sort(uarr);
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		int[] result = new int[m + 1];

		for (int i = 1; i <= m; i++) {
			int dresult = n/2;
			int low = 0;
			int high = darr.length-1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (darr[mid] < i) {
					low = mid + 1;
				} else {
					high = mid - 1;
					dresult = mid;
				}
			}
			
			
			low = 0;
			high = uarr.length-1;
			int uresult = n/2;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (uarr[mid] < (m - i + 1)) {
					low = mid + 1;
				} else {
					high = mid - 1;
					uresult = mid;
				}
			}

			result[i] = ((n / 2) - dresult) + ((n / 2) - uresult);
			if (result[i] < min) {
				min = result[i];
				cnt = 1;
			} else if (result[i] == min) {
				cnt++;
			}
		}
		System.out.println(min+" "+cnt);
	}
}
