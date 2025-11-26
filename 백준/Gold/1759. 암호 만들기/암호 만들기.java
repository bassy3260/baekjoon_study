import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Character> a = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

	static int l;
	static int c;
	static char result[];
	static char[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[c];
		result = new char[l];
		visited = new boolean[c];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);

		permutation(0, 0, 0, 0);
		System.out.println(sb);
	}

	public static void permutation(int start, int depth, int aCnt, int bCnt) {
		if (depth == l) {
			if (aCnt >= 1 && bCnt >= 2) {
				for (int i = 0; i < l; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;

		}
		for (int i = start; i < c; i++) {
			result[depth] = arr[i];
			if (a.contains(arr[i])) {
				permutation(i+1, depth + 1, aCnt + 1, bCnt);
			} else {
				permutation(i+1, depth + 1, aCnt, bCnt + 1);

			}
		}
	}
}
