class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        int[] num = {0, 0, 0};
        
        for (int i = 0; i < 3; i++) {
            while (box[i]/n > 0) {
                num[i]++;
                box[i] -= n;
            }    
        }
        
        answer = num[0]*num[1]*num[2];

        return answer;
    }
}