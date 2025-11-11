import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());

		int[] arr = new int[n];
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		int en = 0;
		int cnt= 0;
		int tot = arr[0];
		int min = Integer.MAX_VALUE;
		for (int st = 0; st < n; st++) {
			while (en < n && tot < m) {
				en++;
				if(en != n) tot+=arr[en];
			}
			if(en == n)
				break;
			if(tot == m) {
				cnt++;
			}
			tot-=arr[st];
		}
		System.out.println(cnt);
	}
}
