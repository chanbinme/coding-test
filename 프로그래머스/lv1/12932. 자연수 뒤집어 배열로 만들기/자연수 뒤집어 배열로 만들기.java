class Solution {
    public int[] solution(long n) {
        // 정수형 n을 문자열로 변환
        String s = String.valueOf(n);
        // 문자로 쪼개서 문자열 배열에 선언
        String[] str = s.split("");
        // 문자열 배열 길이만큼의 정수형 배열 생성
        int[] answer = new int[str.length];
        // 문자열 배열 인덱스 값
        int strIndex = str.length - 1;
        for (int i = 0; i < str.length; i++) {
            // 문자열 배열 역순으로 정수형 배열에 입력
            answer[i] = Integer.parseInt(str[strIndex]);
            strIndex--;
        }
        return answer;
    }
}