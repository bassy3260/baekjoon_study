import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int re = 0;
		StringBuilder sb =new StringBuilder();
		String result = "";
		for (int i = 0; i < n; i++) {
			int money = Integer.parseInt(br.readLine());

			
			re = money / 25;
			sb.append(re + " ");
			money %= 25;
			re = money / 10;
			sb.append(re + " ");
			money %= 10;
			re = money / 5;
			sb.append(re + " ");
			money %= 5;
			re = money / 1;
			sb.append(re + " ");

			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
