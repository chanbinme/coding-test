# 01_[Greedy] 짐 나르기

## **문제**

김코딩과 박해커는 사무실 이사를 위해 짐을 미리 싸 둔 뒤, 짐을 넣을 박스를 사왔다. 박스를 사오고 보니 각 이사짐의 무게는 들쭉날쭉한 반면, 박스는 너무 작아서 한번에 최대 2개의 짐 밖에 넣을 수 없었고 무게 제한도 있었다.

예를 들어, 짐의 무게가 `[70kg, 50kg, 80kg, 50kg]`이고 박스의 무게 제한이 100kg이라면 2번째 짐과 4번째 짐은 같이 넣을 수 있지만 1번째 짐과 3번째 짐의 무게의 합은 150kg이므로 박스의 무게 제한을 초과하여 같이 넣을 수 없다.

박스를 최대한 적게 사용하여 모든 짐을 옮기려고 합니다.

짐의 무게를 담은 배열 stuff와 박스의 무게 제한 limit가 매개변수로 주어질 때, 모든 짐을 옮기기 위해 필요한 박스 개수의 최소값을 return 하도록 movingStuff 함수를 작성하세요.

## **입력**

### **인자 1: stuff**

- `int` 타입의 40 이상 240 이하의 자연수를 담은 배열
    - ex) `[70, 50, 80, 50]`

### **인자 2: limited**

- `int` 타입의 40 이상 240 이하의 자연수

## **출력**

- `int` 타입을 리턴해야 합니다.
- 모든 짐을 옮기기 위해 필요한 박스 개수의 최솟값을 숫자로 반환합니다.

## **주의사항**

- 옮겨야 할 짐의 개수는 1개 이상 50,000개 이하입니다.
- 박스의 무게 제한은 항상 짐의 무게 중 최대값보다 크게 주어지므로 짐을 나르지 못하는 경우는 없습니다.

## **입출력 예시**

```java
int output = movingStuff(new int[]{70, 50, 80, 50}, 100);
System.out.println(output); // 3

int output = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
System.out.println(output); // 4
```

## 풀이

```java
package com.codestates.coplit; 
import java.util.*;

public class Solution { 
	public int movingStuff(int[] stuff, int limit) {
// TODO:
        // 상자에 담길 무게는 limit을 넘길 수 없다.
        // 모든 짐을 옮길 때 필요한 박스 개수의 최솟값을 구해야하 한다.

        // stuff를 ArrayList로 변환
        List<Integer> stuff2 = new ArrayList<>();
        // box ArrayList 생성
        List<Integer> box = new ArrayList<>();

        // box 개수
        int count = 0;

        for (int i = 0; i < stuff.length; i++) {
            stuff2.add(stuff[i]);
        }
        // 박스의 무게를 내림차순으로 정렬
        stuff2.sort(Comparator.reverseOrder());
        // 짐을 모두 담을 때까지 반복해서 박스에 짐을 넣음
        while (!stuff2.isEmpty()) {
            // stuff2를 순회할 iterator 생성
            Iterator<Integer> iterator = stuff2.iterator();
            // 물건 모두 순회
            while (iterator.hasNext()) {
                // 박스 무게를 구함
                int boxWeight = box.stream().mapToInt(i -> i).sum();
                // 박스에 넣으려는 물건
                int nextStuff = iterator.next();
                // 만약 박스 무게와 넣으려는 물건의 무게 합이 limit보다 작거나 같다면 그리고 box에 물건이 1개 이하로 들어있다면
                if (boxWeight + nextStuff <= limit && box.size() < 2) {
                    // 박스에 넣어라
                    box.add(nextStuff);
                    // stuff에서 제거
                    iterator.remove();
                }
            }
            // 박스 비움
            box.clear();
            count++;
        }
        return count;
    }
}
```

## 레퍼런스

```java
package com.codestates.coplit; 
import java.util.*;

public class Solution { 
	public int movingStuff(int[] stuff, int limit) {
    int twoStuff = 0;
    // 짐을 무게순으로 오름차순 정렬
    Arrays.sort(stuff);
    // 가장 가벼운 짐의 인덱스
    int leftIdx = 0;
    // 가장 무거운 짐의 인덱스
    int rightIdx = stuff.length - 1;
    while(leftIdx < rightIdx) {
      // 가장 가벼운 짐과 무거운 짐의 합이 limit 보다 작거나 같으면 2개를 한번에 나를 수 있다
      if(stuff[leftIdx] + stuff[rightIdx] <= limit) {
        // 다음 짐을 확인하기 위해 가장 가벼운 짐과 무거운 짐을 가리키는 인덱스를 옮겨주고
        // 한번에 2개 옮길 수 있는 개수를 +1 해준다
        leftIdx++;
        rightIdx--;
        twoStuff++;
      } else {
        // 위 조건에 맞지 않는 경우는 한번에 한 개만 나를 수 있는 경우이기 때문에
        // 가장 무거운 짐의 인덱스만 옮겨준다
        rightIdx--;
      }
    }
    // 전체 짐의 개수에서 한번에 2개를 나를 수 있는 경우를 빼 주면 총 필요한 박스의 개수를 구할 수 있다
    return stuff.length - twoStuff;
  }
}
```