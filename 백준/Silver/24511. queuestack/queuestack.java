import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int queueCnt = 0;
		int stackCnt = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] queueStack = new int[n];
		for (int i = 0; i < n; i++) {
			queueStack[i] = Integer.parseInt(st.nextToken());
		}

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> tempQ = new LinkedList<>();
		for(int i = n-1; i>=0; i--) {
			if(queueStack[i] == 0) {
				tempQ.offer(arr[i]);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] input = new int[m];
		for (int i = 0; i < m; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < m; i++) {
			int temp = input[i];
			tempQ.offer(temp);
			sb.append(tempQ.poll()).append(" ");
		}
		System.out.println(sb);
	}
}
