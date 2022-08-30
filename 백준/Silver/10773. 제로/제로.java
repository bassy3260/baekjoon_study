import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Long> stack = new Stack<>();
		long k = Long.parseLong(br.readLine());
		for (long i = 0; i < k; i++) {
			long n = Long.parseLong(br.readLine());
			if (n == 0) {
				stack.pop();

			} else {
				stack.push(n);

			}
		}
		long sum = 0;
		long size = stack.size();
		for (long i = 0; i < size; i++) {
			sum += stack.pop();
		}
		System.out.print(sum);

		br.close();
	}
}
