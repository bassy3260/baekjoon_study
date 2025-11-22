import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t =Integer.parseInt(br.readLine()); 
		
		StringBuilder sb = new StringBuilder(); 
		
		for(int tc = 0;tc<t; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); 
			int m =Integer.parseInt(st.nextToken()); 
			
			
			sb.append(n-1).append('\n'); 
			
			for(int i = 0;i<m; i++) {
				br.readLine(); 
			}
		}
		
		System.out.print(sb.toString());
	}
}