class Solution {
    public String solution(int[] food) {
        String answer = "";
        for (int i = 1; i < food.length; i++) {
            int foodNumber = food[i];
            if (foodNumber % 2 == 1) {
                food[i] = foodNumber - 1;
            }
        }
        for (int i = 1; i < food.length; i++) {
            int half = food[i] / 2;
            
            while(half != food[i]) {
                answer += i;
                food[i] -= 1;
            }
        }
        
        answer += 0;
        
        for (int i = food.length - 1; i > 0; i--) {
            while(food[i] > 0) {
                answer += i;
                food[i] -= 1;
            }
        }
        
        return answer;
    }
}