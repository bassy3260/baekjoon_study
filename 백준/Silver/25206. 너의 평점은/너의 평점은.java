import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		double scoreSum=0;
		double avg=0;
		double creditSum=0;
		
		for(int i=0;i<20;i++) {
			st=new StringTokenizer(br.readLine());
			st.nextToken();
			double credit= Double.parseDouble(st.nextToken()); //학점
			String grade=st.nextToken(); //등급
			
			if(!grade.equals("P")) {
				creditSum+=credit;
			}else {
				credit=0;
			}

			double g=0; //등급 별 점수
			switch(grade) {
			case "A+":
				g=4.5;
				break;
			case "A0":
				g=4.0;
				break;

			case "B+":
				g=3.5;
				break;

			case "B0":
				g=3.0;
				break;

			case "C+":
				g=2.5;
				break;

			case "C0":
				g=2.0;
				break;
			case "D+":
				g=1.5;
				break;
			case "D0":
				g=1.0;
				break;
			case "F":
				g=0.0;
				break;
			}
			scoreSum += credit*g; 
		}
		avg= scoreSum/creditSum;
		
		bw.write(String.format("%.6f",avg));
		bw.flush();
		bw.close();
		br.close();
	}
}
