import java.io.*;
import java.util.*;

public class Main {
	static class Time {
		int a;
		int b;

		Time(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Time[] arr = new Time[n];
		
		for(int i = 0;i<n;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Time(x,y);
		}
		Arrays.sort(arr,new Comparator<Time>() {
			@Override
			public int compare(Time o, Time time) {
				return o.a - time.a;
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0].b);
		int sum = 1;
		for(int i = 1; i<n; i++) {
			if(!pq.isEmpty()) {
				int peek  = pq.peek();
				if(arr[i].a>=peek) {
					pq.poll();
					pq.add(arr[i].b);
				}else {
					pq.add(arr[i].b);
					sum = Math.max(sum,pq.size());
				}
			}
		}
		System.out.println(sum);
	}
}
