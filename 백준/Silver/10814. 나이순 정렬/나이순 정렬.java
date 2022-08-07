import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static void mergeSort(int[] arr,String[] arr1) {
		int[] tmp=new int[arr.length];
		String[] tmp1=new String[arr.length];

		mergeSort(arr,arr1,tmp,tmp1,0,arr.length-1);
	}
	
	private static void mergeSort(int[] arr,String[] arr1,int[] tmp,String[] tmp1,int start,int end) {
		if(start<end) {
			int mid=(start+end)/2;
			mergeSort(arr,arr1,tmp,tmp1,start,mid);
			mergeSort(arr,arr1,tmp,tmp1,mid+1,end);
			merge(arr,arr1,tmp,tmp1,start,mid,end);
		}
	}
	private static void merge(int[] arr,String[] arr1,int[] tmp,String[] tmp1,int start,int mid, int end) {
		for(int i=start;i<=end;i++) {
			tmp[i]=arr[i];
			tmp1[i]=arr1[i];
		}
		int part1=start;
		int part2=mid+1;
		int index=start;
		
		while(part1<=mid && part2<=end) {
			if(tmp[part1]<=tmp[part2]) {
				arr[index]=tmp[part1];
				arr1[index]=tmp1[part1];
				part1++;
			}else {
				arr[index]=tmp[part2];
				arr1[index]=tmp1[part2];
				part2++;;
			}
			index++;
		}
		for(int i=0;i<=mid-part1;i++) {
			arr[index+i]=tmp[part1+i];
			arr1[index+i]=tmp1[part1+i];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		int m= Integer.parseInt(br.readLine());

		int[] age=new int[m];
		String[] name=new String[m];
		for(int i=0;i<m;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			age[i]= Integer.parseInt(st.nextToken());
			name[i]= st.nextToken();			
		}
		mergeSort(age,name);
		
		for(int i=0;i<m;i++) {
			System.out.println(age[i]+" "+name[i]);
		}
	}
}
