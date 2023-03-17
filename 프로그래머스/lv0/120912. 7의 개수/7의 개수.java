class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for (int i = 0; i < array.length; i++) {
            while (array[i]/10 != 0 || array[i]%10 != 0) { // 1의 자리 수가 0이 아닐때 실행원함, 10의 자리수에 뭔가 있을때 실행원함
                if((array[i]%10)-7 == 0) {
                    answer++;
                }
                array[i] /= 10;
            }
        }
        
        return answer;
    }
}