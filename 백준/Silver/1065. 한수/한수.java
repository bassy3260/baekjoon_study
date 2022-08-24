import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static boolean hansoo(int n) {
		if(n<100) {
			return true;
		}else if(n>99&&n<1000) {
			int f=n/100;
			int s=(n%100)/10;
			int t= (n%100)%10;
			if((f-s)==(s-t)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int count=0;
		for(int i=1;i<=n;i++) {
			if(hansoo(i)==true) {
				count+=1;
			}
		}
		System.out.print(count);
		
	}

}
