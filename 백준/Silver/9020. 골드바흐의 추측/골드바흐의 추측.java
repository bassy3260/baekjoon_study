import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static boolean prime_number(int number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		int f = 0;
		int[] prime = new int[1300];
		for (int j = 0; j <= 10001; j++) {
			if (prime_number(j) == true) {
				prime[f] = j;
				f++;
			}
		}
		for (int i = 0; i < t; i++) {
		
			int n = Integer.parseInt(br.readLine());
			boolean[] num = new boolean[n];
			
			int[] result = new int[2];
			for (int k = 0; k <= f; k++) {
				if (prime[k] + prime[k] == n) {
					result[0] = prime[k];
					result[1] = prime[k];
					break;
				}
				else {
					for (int m = k + 1; m <= f; m++) {
						if (prime[k] + prime[m] == n) {
							result[0] = prime[k];
							result[1] = prime[m];
							break;
						}
					}
				}
			}
			if (result[0] != 0 && result[1]!=0) {
				bw.write(result[0] + " " + result[1]+"\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
