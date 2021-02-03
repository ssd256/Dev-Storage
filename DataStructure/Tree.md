### Tree

부모와 자식의 관계를 가지는 계층적인 자료구조. 각 노드들이 하나 이상의 자식 노드를 가진다.

(트리에서 자식노드를 가지지 않는 마지막 노드를 leaf(잎사귀)라고 부름)

![tree 구조](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/tree%20%EA%B5%AC%EC%A1%B0.PNG)

---

**종류**

1. ***Binary Tree(이진트리)** : 자식 노드가 최대 2개까지만 붙는 트리

   1-1. **[Binary Search Tree](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/Binary%20Search%20Tree.md)(이진탐색트리/이진검색트리)** :sparkles:

   : 기본적인 구조는 이진트리와 같지만 왼쪽 노드의 데이터들은 현재 노드보다 작아야 하고, 오른쪽 노드의 데이터들은 현재노드 보다 커야 함

   1-2. Balanced : 왼쪽과 오른쪽 노드가 균형을 이루는 트리. 대표적으로  red-black tree, AVL tree가 있음

   1-3. Complete Binary Tree(완전이진트리) : 왼쪽과 오른쪽의 모든 레벨이 맞아야 하며 마지막 레벨의 노드가 왼쪽부터 채워진 트리

   ![완전이진트리](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/%EC%99%84%EC%A0%84%EC%9D%B4%EC%A7%84%ED%8A%B8%EB%A6%AC.PNG)

2. **Ternary Tree** : 자식 노드가 최대 3개까지 붙는 트리

3. **Full Binary Tree** : 자식 노드를 안 가지려면 안가지고, 가지려면 두 개를 가지는 트리

   ![Full Binary Tree](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Full%20Binary%20Tree.PNG)

4. **Perfect Binary Tree** : 양쪽으로 빈 공간없이 모든 노드가 두 개의 노드를 가지고 레벨도 정확히 떨어지는 상태. 완벽한 피라미드 구조를 가짐. (n이 트리의 레벨일 때, 2ⁿ - 1개의 노드를 가짐)

   ![Perfect Binary Tree](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Perfect%20Binary%20Tree.PNG)









