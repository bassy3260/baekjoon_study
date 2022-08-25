import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int n= Integer.parseInt(br.readLine());
		int i=0;
		int sum=0;
		while(n!=i) {
			String str= br.readLine();
			if (str==null) {
				break;
			}else {
				StringTokenizer st=new StringTokenizer(str);
				 sum= Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
	             bw.write(sum+"\n");
	             i++;
			}
		}
		bw.flush();
		bw.close(); 
	}
}