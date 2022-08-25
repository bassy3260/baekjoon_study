import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int i=0;
		while(n!=i) {
			String str= br.readLine();
			if (str==null) {
				break;
			}else {
				StringTokenizer st=new StringTokenizer(str);
				 int a = Integer.parseInt(st.nextToken());
	             int b = Integer.parseInt(st.nextToken());
	             System.out.println(a+b);
	             i++;
			}
		}
	}
}