### Trie

문자열에서 검색을 빠르게 도와주는 자료구조. 문자열의 최대 길이가 M일 때, 시간복잡도는 **O(M)**

>정수형에서 이진검색을 이용하면 **시간복잡도는 O(log N)**
>
>하지만 문자열에서 적용하면 노드 -> 문자열 하나하나를 비교해야 함.
>
>문자열의 최대 길이가 M이면, **시간복잡도는 O(M*log N)**

---

![Trie 구조](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Trie%20%EA%B5%AC%EC%A1%B0.PNG)

> {CAR, CAT, COW, COP, COPY, DOG, DOLL}
>
> 예시를 통해 주어진 단어는 총 7개인데, 트라이를 활용한 트리에서 단어 마지막에 끝나는 노드마다 '네모' 모양을 확인하면 총 7개이다. 

