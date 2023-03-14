class Solution {
    public int solution(int n) {
        int answer = 0;
        answer += 7;
        
        while (answer < n) {
            answer += 7;
        }
        
        answer /= 7;
        return answer;
    }
}