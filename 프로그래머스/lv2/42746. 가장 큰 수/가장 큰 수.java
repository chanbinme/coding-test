import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
    String[] arr = new String[numbers.length];

        // String 배열로 변환
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // o1 - o2 == 오름차순, o2 - o1 == 내림차순
        // 반환값이 양수인 경우에는 두 객체의 자리가 바뀌고, 음수 또는 0이면 객체의 자리가 유지된다.
        Arrays.sort(arr, (o1, o2) -> {
            int num1 = Integer.parseInt(o1 + o2);
            int num2 = Integer.parseInt(o2 + o1);

            return num2 - num1;
        });

        // String을 합치기 위한 StringBuilder 
        StringBuilder answer = new StringBuilder();

        for (String num : arr) {
            answer.append(num);
        }

        // 00인 결과값이 나올 수 있기 때문에 0으로 반환
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}