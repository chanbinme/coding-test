class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    private int dfs(int[] numbers, int target, int sum, int current) {
        int ans = 0;
        
        if (current >= numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        
        ans += dfs(numbers, target, sum + numbers[current], current + 1);
        ans += dfs(numbers, target, (sum + numbers[current] * -1), current + 1);
        
        return ans;
    }
}