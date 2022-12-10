

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        
        // 배열 순회
        for (int i = 0; i < babbling.length; i++) {
            int length = babbling[i].length();
            int length2 = length;
            
            // 문자를 모두 삭제하고 문자열 길이가 0이면 answer + 1
            if (babbling[i].contains("aya")) {
                int minus = length2 - babbling[i].replaceFirst("aya", "").length();
                length -= minus;
            }
            if (babbling[i].contains("ye")) {
                int minus = length2 - babbling[i].replaceFirst("ye", "").length();
                length -= minus;
            }
            if (babbling[i].contains("woo")) {
                int minus = length2 - babbling[i].replaceFirst("woo", "").length();
                length -= minus;
            }
            if (babbling[i].contains("ma")) {
                int minus = length2 - babbling[i].replaceFirst("ma", "").length();
                length -= minus;
            }
            
            if (length == 0) answer++;
        }
        
        return answer;
    }
}