import java.util.*;
class Solution {
    public String solution(String s) {
        // 쪼개서 배열에 넣고 정렬할까?..
        // 공백으로 쪼개기
        String arr[] = s.split(" ");
        int[] num = new int[arr.length];
        
        for(int i = 0; i<num.length; i++){
            num[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(num);
        
        String answer = num[0]+" "+num[num.length-1];
        return answer;
    }
}