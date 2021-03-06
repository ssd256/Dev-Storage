### HashTable

> 데이터를 효율적으로 관리하기 위해 임의의 길이 데이터를 고정된 길이의 데이터로 매핑

F(key)를 HashCode로 변환하고, 그 변환된 HashCode가 고정된 배열의 Index값으로 쓰임

때문에 HashCode로 빠르게 Value에 접근할 수 있음 

```java
John -> 해싱함수 -> 1
Lisa -> 해싱함수 -> 2
...
Sam -> 해싱함수 -> 2 // Lisa와 해싱값 충돌
```

<br>

**HashTable의 장점**

> 적은 자원으로 많은 데이터를 효율적으로 관리
>
> 하드디스크, 클라우드에 존재하는 무한한 데이터들을 유한한 개수의 해시값으로 매핑하면 작은 메모리로도 프로세스 관리가 가능

* 언제나 동일한 해시값 리턴, index를 알면 빠른 데이터 검색이 가능
* 해시테이블의 시간복잡도는  O(1)   cf) 이진탐색트리는 O(log N)

<br>

hash 함수에서 중요한 것은 인덱스의 배열을 나눌 때의 조건(알고리즘)을 잘 설정해야 한다!

다른 데이터가 같은 해시 값으로 충돌 발생 -> **collision(충돌)현상으로 Big O가 O(n)까지 걸릴 수 있음**

< br>

**hash 알고리즘 & collision**

- key는 문자열도 되고 무한하지만, hashcode는 정수밖에 없어서 한정된 값만 제공(different key -> same code)

- 다른 hashcode여도 같은 인덱스로 배정될 수 있음(different code -> same index)

<br>

**collision 해결**

1. **체이닝** : 연결리스트로 노드를 계속 추가해나가는 방식(제한 없이 계속 연결 가능. but 메모리 문제 O)

![체이닝](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/%EC%B2%B4%EC%9D%B4%EB%8B%9D.PNG)

2. **Open Addressing** : 해시 함수로 얻은 주소가 아닌 다른 주소에 데이터를 저장할 수 있도록 허용(해당 키 값에 저장되어 있으면 다음 주소에 저장)

3. **선형 탐사** : 정해진 고정 폭으로 옮겨 해시값의 중복을 피함

4. **제곱 탐사** : 정해진 고정 폭을 제곱수로 옮겨 해시값의 중복을 피함



