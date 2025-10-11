import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Deque<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		int cnt = 0;
		boolean dir = true;
		while (!queue.isEmpty()) {
			if (dir) {
				for (int j = 0; j < k - 1; j++) {
					queue.add(queue.poll());
				}
				sb.append(queue.poll() + "\n");
			} else {
				for (int j = 0; j < k - 1; j++) {
					queue.addFirst(queue.pollLast());
				}
				sb.append(queue.pollLast() + "\n");
			}

			cnt++;
			if(cnt == m ) {
				dir = !dir;
				cnt = 0;
			}
		}
		System.out.println(sb);
	}
}
