import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		arr[0] = 6;
		arr[1] = 2;
		arr[2] = 5;
		arr[3] = 5;
		arr[4] = 4;
		arr[5] = 5;
		arr[6] = 6;
		arr[7] = 3;
		arr[8] = 7;
		arr[9] = 6;

		for (int i = 0; i <= 99; i++) {
			int cnt = 0;
			int a = i / 10;
			int b = i % 10;
			cnt += arr[a] + arr[b];
			int temp = cnt;
			for (int j = 0; j <= 99; j++) {
				cnt = temp;
				int c = j / 10;
				int d = j % 10;
				cnt += arr[c] + arr[d];

				int result = i + j;
				if(result >=100 )	break;
				
				int ra = result / 10;
				int rb = result % 10;
				cnt+= arr[ra] + arr[rb];

				if (cnt == n-4) {
					System.out.println(String.format("%02d", i) + "+" + String.format("%02d", j) + "=" + String.format("%02d", result));
					return;
				}
			}

		}
		System.out.println("impossible");
	}
}
