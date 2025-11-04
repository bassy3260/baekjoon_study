import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr= new int[n][2];
		
		for(int i = 0;i<n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1,int[] o2) {
				return o1[0]- o2[0];
			}
		});
		
		int start = arr[0][0];
		int end = arr[0][1];
		int sum = 0;
		for(int i = 0; i<n; i++) {
			if(arr[i][0] > end) { // 새 선분, 현재 그린 선분의 길이 정산.
				sum +=end-start;
				start = arr[i][0];
			}
			
			if(arr[i][1] >end) { //선분 확장: 선분만 갱신 
				end  = arr[i][1];
			}
		}
		sum +=end-start;
		System.out.println(sum);
	}
}
