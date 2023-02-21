
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	public static void swap(int[] n,int a,int b){
		int temp=n[a];
		n[a]=n[b];
		n[b]= temp;
	}
	
	public static void turn(int[] n,int a,int b) {
		int half=(a+b)/2;
		
		for(int i=0;a+i<=half;i++) {
			swap(n,a+i,b-i);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		st=new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		int[] basket=new int[n];
		for(int i=0;i<n;i++) {
			basket[i]=i+1;
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int basket1=Integer.parseInt(st.nextToken());
			int basket2=Integer.parseInt(st.nextToken());
			
			turn(basket,basket1-1,basket2-1);
		}
		for(int i=0;i<n;i++) {
			bw.write(String.valueOf(basket[i])+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

