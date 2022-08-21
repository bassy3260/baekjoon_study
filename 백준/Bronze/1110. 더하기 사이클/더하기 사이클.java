import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int result=0;
		int count = 1;
		int f = n / 10;
		int s = n % 10;
		if (s + f < 10) {
			result = s * 10 + (s + f);
		}else {
			result = s * 10 + (s + f)%10;
		}

		while (result != n) {
			if (result == 0) {
				break;
			}
			count += 1;
			f = result / 10;
			s = result % 10;
			if (s + f < 10) {
				result = s * 10 + (s + f);
			}else {
				result = s * 10 + (s + f)%10;
			}
		}

		System.out.print(count);
	}
}
