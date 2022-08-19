import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int max= Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int sum=0;
		int[] card= new int[n];
		for(int i=0;i<n;i++) {
			card[i]=Integer.parseInt(st.nextToken());;
		}
		
		int result=0;
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n-1;j++) {
				for(int k=j+1;k<n;k++) {
					sum= card[i]+card[j]+card[k];
					if((sum<=max)&&(sum>result)) {
						result=sum;
					}
				}
			}
		}
		System.out.print(result);
		
	}
}
