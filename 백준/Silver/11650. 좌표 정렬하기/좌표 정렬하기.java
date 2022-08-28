import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int tmp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n: 입력할 좌표 갯수
		int n = Integer.parseInt(br.readLine());

		// 좌표 저장 2차원 배열
		int[][] arr = new int[n][2];
		tmp = new int[n][2];
		// 좌표 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		mergeSort(arr, 0, n - 1);

		// 출력
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}

	private static void mergeSort(int[][] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[][] arr, int start, int mid, int end) {
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		while (part1 <= mid && part2 <= end) {
			if (arr[part1][0] < arr[part2][0]) {
				tmp[index][0] = arr[part1][0];
				tmp[index][1] = arr[part1][1];
				part1++;
			} else if (arr[part1][0] > arr[part2][0]) {
				tmp[index][0] = arr[part2][0];
				tmp[index][1] = arr[part2][1];
				part2++;
			} else {
				// x좌표가 같을 경우 처리
				if (arr[part1][1] < arr[part2][1]) {
					tmp[index][0] = arr[part1][0];
					tmp[index][1] = arr[part1][1];
					part1++;
				} else {
					tmp[index][0] = arr[part2][0];
					tmp[index][1] = arr[part2][1];
					part2++;
				}
			}
			index++;
		}
		if(part1>mid) {
			for(int t=part2;t<=end;t++) {
				tmp[index][0]= arr[t][0];
				tmp[index][1]= arr[t][1];
				index++;
			}
		}
		else {
			for(int t=part1;t<=mid;t++) {
				tmp[index][0]= arr[t][0];
				tmp[index][1]= arr[t][1];
				index++;
			}
		}
		
		for (int i = start; i <= end; i++) {
			arr[i][0] = tmp[i][0];
			arr[i][1] = tmp[i][1];
		}
	}

}