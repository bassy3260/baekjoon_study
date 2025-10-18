import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[K];
		int max = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i])
				max = arr[i];
		}

		long low = 1; // 랜선 길이는 1부터 시작
        long high = max; // 최대 길이는 입력된 랜선 중 가장 긴 것
        long result = 0; // 최종 결과(최대 길이)를 저장할 변수
		while(low<=high) {
			long mid = (low+high)/2;
			
			if(sum(arr,mid)<N) {
				high = mid-1;
			}else {
				low=mid+1;
				result = Math.max(result, mid);
			}
		}
		System.out.println(result);

	}

	static long sum(int[] arr, long mid) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] / mid;
		}
		return sum;
	}
}
