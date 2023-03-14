class Solution {
    public int solution(int slice, int n) {
        int answer = 0; // 판 개수
        answer += slice; // 1판 조각 더하고 시작
        
        while(answer < n) {
            answer += slice; // 1판 조각 더 더함
        }
        
        answer = answer / slice; // 조각 int로 나누면 몫만 깔끔하게 남음
        
        return answer;
    }
}