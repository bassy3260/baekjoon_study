import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		long N= Long.parseLong(st.nextToken()); // 박스 총 갯수
		long L= Long.parseLong(st.nextToken()); // 가로
		long W= Long.parseLong(st.nextToken()); // 세로
		long H= Long.parseLong(st.nextToken()); //높이
		
		double low = 0;
		double high = Math.min(L,Math.min(W, H));
		while(low<high) {
			double mid = (low+high)/2;
			
			if((long)(L/mid)*(long)(W/mid)*(long)(H/mid)<N) {
				if(high==mid) break;
				high = mid;
			}else {
				if(low==mid) break;
				low=mid;
			}
		}
		System.out.println(low);
	}
}
