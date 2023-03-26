import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 가장 무거운 사람과 가장 가벼운 사람의 무게를 합쳐 보트에 태울지 결정
     * 가장 가벼운 사람의 무게가 limit / 2보다 크면 모든 인원이 혼자 탈 수 밖에 없음
     */
    Deque<Integer> peopleDeqeue;
    int limit;
    int count = 0;
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        List<Integer> peopleList = Arrays.stream(Arrays.stream(people).boxed().toArray(Integer[]::new)).collect(Collectors.toList());
        this.limit = limit;
        peopleDeqeue = new ArrayDeque<>(peopleList);

        while (!peopleDeqeue.isEmpty()) {
            int light = peopleDeqeue.peekFirst();
            int heavy = peopleDeqeue.peekLast();
            int sumWeight = light + heavy;

            if (everyoneIsHeavy(light)) {
                break;
            }
            sendABoat();
            if (lessThanOrEqualToLimit(sumWeight)) {
                rescue(2);
            } else {
                rescue(1);
            }
        }

        return count + peopleDeqeue.size();
    }

    private boolean everyoneIsHeavy(int light) {
        return light > limit / 2;
    }

    private void rescue(int numberOfPeople) {
        if (numberOfPeople == 2) {
            peopleDeqeue.pollFirst();
            peopleDeqeue.pollLast();
        } else if (numberOfPeople == 1) {
            peopleDeqeue.pollLast();
        }
    }

    private void sendABoat() {
        count++;
    }

    private boolean lessThanOrEqualToLimit(int sumWeight) {
        return sumWeight <= limit;
    }
}
