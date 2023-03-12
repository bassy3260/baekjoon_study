import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
     Arrays.sort(array);
        int answer = array.length/2;
       if(array.length%2 ==0){
         return(array[answer-1]+array[answer])/2;
       }else{
           return array[answer];
       }
    }
}
