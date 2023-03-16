class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        
        // 가로 가위질 수 + (가로 가위질 수 * 세로 가위질 수)
        answer = (M-1) + (M*(N-1));
        
        return answer;
    }
}