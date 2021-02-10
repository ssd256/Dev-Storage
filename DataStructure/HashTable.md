### HashTable

F(key) -> HashCode -> Index -> Value

가장 큰 장점 : 검색 속도가 매우 빠름. hashcode는 고정된 배열의 index값으로 쓰이기 때문에 바로 값에 접근할 수 있기 때문 -> O(1)

hash 함수에서 중요한 것은 인덱스의 배열을 나눌 때의 조건을 잘 설정해야 하는 것!

배열의 특정 인덱스에만 값이 몰릴 수도 있음 -> collision(충돌현상) O(n)까지 걸릴 수 있음

hash 알고리즘을 잘 설정해야 함

hash 알고리즘 & collision

- key는 문자열도 되고 무한하지만, hashcode는 정수밖에 없어서 한정된 값만 제공(different key -> same code)

- 다른 hashcode여도 같은 인덱스로 배정될 수 있음(different code -> same index)