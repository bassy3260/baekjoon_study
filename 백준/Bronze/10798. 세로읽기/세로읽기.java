
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		char[][] map = new char[5][15];

		int maxLength=0;
		for(int i=0;i<5;i++) {
			String str= br.readLine();
			for(int j=0;j<str.length();j++) {
				map[i][j]=str.charAt(j);
			}
			if(maxLength<str.length()) {
				maxLength=str.length();
			}
		}
		for(int i =0;i<maxLength;i++) {
			for(int j=0;j<5;j++) {
				if(map[j][i]!='\0') {
					bw.write(map[j][i]);
				}
				
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
