import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] chess = new int[6];
		for (int i = 0; i < chess.length; i++) {
			chess[i] = Integer.parseInt(st.nextToken());
		}
		int n=0;
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 0:
				n = 1;
				break;
			case 1:
				n = 1;
				break;
			case 2:
				n = 2;
				break;
			case 3:
				n = 2;
				break;
			case 4:
				n = 2;
				break;
			case 5:
				n = 8;
				break;
			}
			if (chess[i] == n) {
				chess[i] = 0;
			} else if (chess[i] > n) {
				chess[i] = -(chess[i] - n);
			} else {
				chess[i] = -(chess[i] - n);
			}
			System.out.print(chess[i]+" ");
		}
	
	}
}
