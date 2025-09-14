import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        //길이만큼 Lis 선언
        int[] lis = new int[N];
        int size =0; //현재까지 만들어진 lis 저장
        
        for(int num:A) {
        	// 이분탐색을 이용해 현재 숫자가 lis 배열에 들어갈 위치를 찾는다.
        	// 탐색 범위는 lis[0] 부터 size-1까지;
        	int insertionPoint = Arrays.binarySearch(lis, 0,size,num);
        	
        	// 양수 또는 0 : num이 이미 lis배열에 존재
        	// 음수: num이 lis배열에 없다. -(insertionpoint+1)은 num이 삽입될 위치
        	if(insertionPoint < 0) {
        		insertionPoint = -(insertionPoint+1);
        	}
        	
        	lis[insertionPoint] = num;
        	
        	if(insertionPoint == size) {
        		size++;
        	}
        }
        System.out.println(size);
        
	}
}
