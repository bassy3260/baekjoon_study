class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 1. 6조각을 나누었을 때, 0으로 나누어 떨어지는가?
        //    아니라면 6에 다시 6을 더한다. 그런식으로 반복
        
        answer++;
        
        while ((answer*6)%n != 0) {
            answer++;
        }
        
        return answer;
    }
}