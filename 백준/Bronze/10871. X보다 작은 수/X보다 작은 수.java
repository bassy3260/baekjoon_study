import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		StringTokenizer sw = new StringTokenizer(br.readLine());
		int a=0;
		for (int i = 0; i < n; i++) {
			a=Integer.parseInt(sw.nextToken());
			if(a<x) {
				bw.write(a+" ");
			}
			
		}
		bw.flush();
		bw.close();
	}
}
