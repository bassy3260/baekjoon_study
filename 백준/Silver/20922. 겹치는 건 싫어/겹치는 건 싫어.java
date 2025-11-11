import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		int[] arr = new int[n];
		int[] cnt = new int[100001];
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		int st = 0;
		int max = 0;
		for (int en = 0; en < n; en++) {
			cnt[arr[en]]++;
			while (cnt[arr[en]] > k) {
				cnt[arr[st]]--;
				st++;
			}
			max = Math.max(max, en - st + 1);
		}

		System.out.println(max);
	}
}
