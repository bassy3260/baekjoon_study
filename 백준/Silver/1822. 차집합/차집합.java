import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer> a = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(a);

		HashSet<Integer> bSet = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			bSet.add(num);
		}

		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int num : a) {
			if (!bSet.contains(num)) {
				cnt++;
				sb.append(num).append(" ");
			}
		}

		System.out.println(cnt);
		System.out.print(sb);
	}
}
