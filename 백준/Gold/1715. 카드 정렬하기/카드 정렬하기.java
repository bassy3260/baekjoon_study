
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			pq.offer(a);
		}

		int sum = 0;
		while (pq.size() > 1) {

			int a = pq.poll();
			int b = pq.poll();

			int result = a + b;
			sum += result;

			pq.offer(result);

		}

		System.out.println(sum);

	}
}
