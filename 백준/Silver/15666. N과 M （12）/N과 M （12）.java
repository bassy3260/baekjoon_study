import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] result;
	static StringBuilder sb;
	static int N;
	static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[R];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr); 
		dfs(0,0);
		System.out.println(sb);
	}

	static void dfs(int depth,int start) {
		if (R == depth) {
			for (int num : result) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}

        
		int prev_num = 0; 

		for (int i = start; i < N; i++) {
			if (prev_num == arr[i]) {
				continue;
			}
            
			result[depth] = arr[i];
			dfs(depth+1,i);
			prev_num = arr[i]; 
		}
	}
}