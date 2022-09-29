# 02_[Greedy] 편의점 알바

## **문제**

편의점에서 아르바이트를 하고 있는 중에, 하필이면 피크 시간대에 손님에게 거스름돈으로 줄 동전이 부족하다는 것을 알게 되었습니다.
현재 가지고 있는 동전은 `1원`, `5원`, `10원`, `50원`, `100원`, `500원`으로 오름차순으로 정렬되어 있고, 각 동전들은 서로 배수 관계에 있습니다.
동전 개수를 최소화하여 거스름돈 K를 만들어야 합니다. 이때, 필요한 동전 개수의 최솟값을 구하는 함수를 작성해 주세요.

## **입력**

### **인자: k**

- `int` 타입의 k
- 1 <= k <= 100,000,000

## **출력**

- `int` 타입의 거스름돈 K원을 만드는데 필요한 동전 개수의 최솟값을 반환해야 합니다.

## **입출력 예시**

```java
// 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
int output1 = partTimeJob(4000);
System.out.println(output1); // --> 8

// 4972원을 받았을 때 500원짜리 동전 9개, 100원짜리 동전 4개, 50원짜리 동전 1개, 10원짜리 동전 2개, 1원짜리 동전 2개, 총 18개를 반환합니다.
int output2 = partTimeJob(4972);
System.out.println(output2); // --> 18
```

## 풀이

```java
package com.codestates.coplit; 
import java.util.*;

public class Solution { 
	public int partTimeJob(int k) {
    // TODO:
		// 거스름돈 선언
		int changes = 0;
		// 최소 동전 개수 선언
		int count = 0;
		// 동전을 넣어둘 리스트 생성
		List<Integer> coin = new ArrayList<>();
		// 리스트에 동전을 내림차순으로 저장
		coin.add(500);
		coin.add(100);
		coin.add(50);
		coin.add(10);
		coin.add(5);
		coin.add(1);

		// k가 0이 될 때까지 반복 //by.선우예림
		while(k != 0) {
			// changes에 coin.remove() 값 저장
			changes = coin.remove(0);
			// if(k가 changes보다 크거나 같다면)
			if(k >= changes) {
				// k를 changes로 나눈 값을 count에 더하고
				count += k / changes;
				// k를 chnages로 나눈 나머지 값을 k에 저장
				k = k % changes;
			}
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
	public int partTimeJob(int k) {
    int result = 0;
		//동전의 종류를 배열에 넣어준 이후
    int[] wallet = new int[]{500, 100, 50, 10, 5, 1};
		//해당 동전의 종류만큼 배열을 순회합니다.
    for(int i = 0; i < wallet.length; i++) {
			//총 금액이 0보다 클때마다
      if(k > 0) {
				//총 금액을 현재 동전으로 나눈 수를 구합니다(해당 동전의 총 갯수)
        int sum = (int)Math.floor((double)k / wallet[i]);
				//해당 동전의 갯수를 결과에 더해준 이후
        result = result + sum;
				//총 금액을 사용한 동전의 금액만큼 차감합니다.
        k = k - (wallet[i] * sum);
      }
    }
		//결과를 반환합니다.
    return result;
  }
}
```