class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 기사단 수만큼 반복
        for(int i = 1; i <= number; i++) {
            int offencePower = 0;
            
            // 공격력(약수 개수) 구하기
            for(int j = 1; j * j <= i; j++) {
                if(j * j == i) {
                    offencePower++;
                }
                else if(i % j == 0) {
                    offencePower += 2;
                }
            }
            
            // 공격력이 limit을 초과하는지 체크
            if (offencePower > limit) {
                // 초과한다면 power값이 해당 기사단의 공격력
                offencePower = power;
            }
            
            // answer + 해당 기사단 공격력
            answer += offencePower;
        }
        
        return answer;
    }
}