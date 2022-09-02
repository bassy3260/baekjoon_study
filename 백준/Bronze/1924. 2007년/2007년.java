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
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		if(m!=1) {
			for(int i=1;i<m;i++) {
				if(i==4||i==6||i==9||i==11) {
					d+=30;
				}else if(i==2){
					d+=28;
				}else{
					d+=31;
				}
			}
		}
	
		if(d%7==1) {
			bw.write("MON");
		}else if(d%7==2){
			bw.write("TUE");
		}else if(d%7==3){
			bw.write("WED");
		}else if(d%7==4){
			bw.write("THU");
		}else if(d%7==5){
			bw.write("FRI");
		}else if(d%7==6){
			bw.write("SAT");
		}else {
			bw.write("SUN");	
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
