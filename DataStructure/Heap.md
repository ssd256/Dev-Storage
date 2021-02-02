#### Heap

힙은, 우선순위 큐를 위해 만들어진 자료구조다. 

<br>

**우선순위 큐** : 우선순위의 개념을 큐에 도입한 자료구조

> 데이터들이 우선순위를 가지고 있음. 우선순위가 높은 데이터가 먼저 나감

스택은 LIFO, 큐는 FIFO

<br>

##### 언제 사용?

> 시뮬레이션 시스템, 작업 스케줄링, 수치해석 계산

우선순위 큐는 배열, 연결리스트, 힙으로 구현 (힙이 가장 효율적)

힙 → 삽입 : O(logn) , 삭제 : O(logn)   
<br>

---

힙은 최대값이나 최소값을 빠르게 연산하기 위해 고안된 완전 이진 트리를 기본 한 자료구조이다.

> 반정렬 상태
>
> 힙 트리는 중복값을 허용(이진 탐색 트리는 중복값 허용X)

<br>

**힙 종류**

1. **최소 힙(Min Heap)**

부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진 트리

트리의 맨 위에는 가장 작은 값이 옴

2. **최대 힙(Max Heap)**

부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리

트리의 맨 위에는 가장 큰 값이 옴

![heap](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Heap.PNG)

<br>

**구현**

---

힙을 저장하는 표준적인 자료구조는 `배열`

구현을 쉽게 하기 위해 배열의 첫번째 인덱스인 0은 사용되지 않음

특정 위치의 노드 번호는 새로운 노드가 추가되어도 변하지 않음

-> 한 줄씩 값을 비교하는 구조라서 비교를 거듭할 때마다 키 값들이 절반씩 줄어듦. Big-O는 **O(log n)**

<br>

##### 부모 노드와 자식 노드 관계

힙 자료구조는 보통 배열을 이용하며 쉽게 구현하기 위해 0번째 인덱스는 사용하지 않는다.

```
왼쪽 자식 index = (부모 index) * 2

오른쪽 자식 index = (부모 index) * 2 + 1

부모 index = (자식 index) / 2
```

![Heap 구조](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Heap%EA%B5%AC%EC%A1%B0.PNG)

<br>

**힙의 삽입 : 최대 힙**

1. 힙에 새로운 요소가 들어오면 마지막 노드에 삽입

2. 새로운 노드를 부모 노드들과 비교해서 교환 

```java
void insert_max_heap(int x) {
    
    maxHeap[++heapSize] = x; 
    // 힙 크기를 하나 증가하고, 마지막 노드에 x를 넣음
    
    for( int i = heapSize; i > 1; i /= 2) {
        
        // 마지막 노드가 자신의 부모 노드보다 크면 swap
        if(maxHeap[i/2] < maxHeap[i]) {
            swap(i/2, i);
        } else {
            break;
        }
        
    }
}
```

<br>

**힙의 삭제 : 최대 힙** 

1. 최대 힙에서 최대값은 루트 노드(맨 처음)이므로 루트 노드가 삭제됨 (최대 힙에서 삭제 연산은 최대값 요소를 삭제하는 것)
2. 삭제된 루트 노드에는 힙의 마지막 노드를 가져옴
3. 힙을 재구성

```java
int delete_max_heap() {
    
    if(heapSize == 0) // 배열이 비어있으면 0 리턴
        return 0;
    
    int item = maxHeap[1]; // 루트 노드의 값을 저장
    maxHeap[1] = maxHeap[heapSize]; // 마지막 노드 값을 루트로 이동
    maxHeap[heapSize--] = 0; // 힙 크기를 하나 줄이고 마지막 노드 0 초기화
    
    for(int i = 1; i*2 <= heapSize;) {
        
        // 마지막 노드가 왼쪽 노드와 오른쪽 노드보다 크면, break
        if(maxHeap[i] > maxHeap[i*2] && maxHeap[i] > maxHeap[i*2+1]) {
            break;
        }
        
        // 왼쪽 노드가 더 큰 경우, swap
        else if (maxHeap[i*2] > maxHeap[i*2+1]) {
            swap(i, i*2);
            i = i*2;
        }
        
        // 오른쪽 노드가 더 큰 경우, swap
        else {
            swap(i, i*2+1);
            i = i*2+1;
        }
    }
    
    return item;
    
}
```

<br>