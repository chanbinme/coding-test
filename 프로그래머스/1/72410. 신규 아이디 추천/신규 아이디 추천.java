import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String new_id) {
        // 1단계 : 모든 대문자를 소문자로 변경
        new_id = new_id.toLowerCase();

        // 2단계 : 소문자, 숫자, -, _, . 를 제외한 모든 문자 제거
        ArrayList<String> list = (ArrayList<String>) Arrays.stream(new_id.split(""))
            .filter(i -> i.matches("[a-z0-9._-]")).collect(Collectors.toList());

        // 3단계 : . 가 2개 이상 연속된 부분을 하나의 . 로 치환
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).equals(".") && list.get(i - 1).equals(".")) {
                list.remove(i);
            }
        }

        // 4단계 : . 가 처음이나 끝에 위치한다면 제거
        removeFirstAndLastComma(list);

        // 5단계 : 빈 문자열이라면 a 대입
        if (list.isEmpty()) {
            list = new ArrayList<>(List.of("a"));
        }

        // 6단계 : 16자 이상이면 15자로 자르기. 끝에 위치한 . 제거
        while (list.size() > 15) {
            list.remove(list.size() - 1);
            removeFirstAndLastComma(list);
        }

        // 7단계 : 2자 이하라면 마지막 문자를 3자가 될 때까지 반복해서 붙이기
        String lastChar = list.get(list.size() - 1);
        while (list.size() <= 2) {
            list.add(lastChar);
        }

        String result = String.join("", list);
        return result;
    }

    private void removeFirstAndLastComma(ArrayList<String> list) {
        boolean hasStartAndEndComma = true;
        while (hasStartAndEndComma && !list.isEmpty()) {
            if (list.get(0).equals(".")) {
                list.remove(0);
            } else if (list.get(list.size() - 1).equals(".")) {
                list.remove(list.size() - 1);
            } else {
                hasStartAndEndComma = false;
            }
        }
    }
}