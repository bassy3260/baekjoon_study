import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.parseInt(br.readLine());
		int result=0;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			result+=Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
		}
		
		if(result==sum) {
			System.out.print("Yes");
		}else {
			System.out.print("No");
		}

	}
}
