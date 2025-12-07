import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb;

	public static void hanoi(int num, int start, int to, int via) {
		if (num == 1) {
			sb.append(start).append(" ").append(to).append("\n");
			return;
		} else {
			hanoi(num - 1, start, via, to);
			sb.append(start).append(" ").append(to).append("\n");
			hanoi(num - 1, via, to, start);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
	
		BigInteger count = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
		System.out.println(count);
		if (n <= 20) {
			hanoi(n, 1, 3, 2);
			System.out.println(sb);
		}
	}
}
