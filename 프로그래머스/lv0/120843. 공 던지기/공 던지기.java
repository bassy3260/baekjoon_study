class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        // 1,2,3,4 일 때 2번째 -> (2-1)*2 = 2뒤의 숫자
        // 1,2,3,4,5,6 일 때 5번째 -> (5-1)*2 = 10 뒤의 숫자 = (8-배열개수) = 2뒤의 숫자
        // 1,2,3 일 때 3번째 -> (배열개수-1)*2 = 4 뒤의 숫자 = (4-배열개수) = 1뒤의 숫자
        

        answer = (k-1)*2;
        
        while (answer > numbers.length) {
            answer -= numbers.length;    
        }
        
        answer = numbers[answer];

        
        return answer;
    }
}