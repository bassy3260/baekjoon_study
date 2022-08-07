import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid + 1, end);
			merge(arr, tmp, start, mid, end);
		}
	}

	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid + 1;
		int index = start;

		while (part1 <= mid && part2 <= end) {
			if (tmp[part1] >= tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			} else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int student= Integer.parseInt(st.nextToken());
		int cut=Integer.parseInt(st.nextToken());
		String[] str=br.readLine().split(" ");
		int[] score=new int[student];
		for(int i=0;i<student;i++) {
			score[i]=Integer.parseInt(str[i]);
		}
		
		mergeSort(score);
		
		for(int i=0;i<student;i++) {
			
		}
		
		System.out.print(score[cut-1]);
	}
}
