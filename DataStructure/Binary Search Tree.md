#### Binary Search [Tree](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/Tree.md)(이진탐색트리)

> 이진탐색(binary search) + 연결리스트(linked list)를 결합한 자료구조

이진탐색 : **탐색의 시간복잡도는 O(log N)**, but 삽입, 삭제가 불가능

연결리스트 :  **삽입, 삭제의 시간복잡도는 O(1)**, but 탐색 시간복잡도는 O(N)

:sparkles: ​효율적인 탐색 능력을 유지하면서 빈번한 자료 입력과 삭제를 가능하게 함

![Binary Search Tree 구조](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Binary%20Search%20Tree%20%EA%B5%AC%EC%A1%B0.PNG)

<br>

**특징**

* 각 노드의 자식은 2개 이하
* 각 노드의 왼쪽 자식노드는 부모 노드보다 작고, 오른쪽 자식 노드는 부모 노드보다 큼
* 중복된 노드가 없어야 함 -> 검색 목적 자료구조인데 중복이 많으면 검색 속도가 느려지기 때문!

<br>

이진탐색트리를 순회할 때는 **중위순회(inorder) 방식(왼쪽 - 루트 - 오른쪽)** 사용

중위 순회로 모든 값들을 **정렬된 순서**대로 읽을 수 있음

![inorder](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/inorder.PNG)

> 중위순회 : 2 - 4 - 6 - 10 - 12 - 16

<br>

**BST 핵심연산**

* 검색(retreive/find)
* 삽입(insert)
* 삭제(delete)
* 트리 생성(create)
* 트리 삭제(destroy)

<br>

**시간 복잡도**

* 균등 트리 : 노드의 개수가 N일 때 O(long N)
* 편향 트리 : 노드의 개수가 N일 떄 O(N)

> 삽입, 검색, 삭제 시간복잡도는 **트리의 Depth/Level에 비례**

<br>

**삭제의 3가지 Case**

1. 자식이 없는 leaf 노드일 때 : 단순 삭제
2. 자식이 1개인 노드일 때 : 지워진 노드에 자식을 올리기
3. 자식이 2개인 노드일 때 : 오른쪽 자식 노드에서 가장 작은 값 or 왼쪽 자식 노드에서 가장 큰 값 올리기

<br>

편향된 트리는 시간복잡도가 O(N)이므로 트리를 사용할 이유X -> 이를 바로 잡도록 도와주는 개선된 트리가 AVL Tree, RedBlack Tree

<br>

[구현 코드(java)]()

