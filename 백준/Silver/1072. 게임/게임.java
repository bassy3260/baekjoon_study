import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long z = (y * 100) / x;
		if(x==y || z ==99) {
			System.out.println(-1);
			return;
		}
		
		long low = 1; long high = 1000000000;
		
		long newz = 0;
		long mid; 
		long answer = 0;
		while(low<=high) {
			mid =  (low+high)/2;
			newz = ((long)(y + mid) * 100 / (x + mid));
			if(newz > z) {
				answer= mid;
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		System.out.println(answer);
	}
}
