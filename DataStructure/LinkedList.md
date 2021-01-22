### Linked List

![LinkedList 구조2](C:\Study(개념_과제)\0_개인공부\자료구조\Linked List\LinkedList 구조2.png)

불연속적으로 존재하는 데이터를 서로 연결(link)한 선형 데이터 구조(포인터를 사용해서 연결됨)

각 노드는 **데이터(자신) + 다음 노드에 대한 참조(주소값)**을 포함하는 노드로 구성

![node](https://github.com/ssd256/TIL/blob/main/DataStructure/images/node.png)

```java
class Node {
	Node next;	// 다음 요소의 주소를 저장
	Object obj; // 데이터를 저장
}
```



장점

> 동적 크기 : 한 번 크기가 정해지면 수정되지 않는 배열과 달리 동적으로 크기가 줄고 늘어남
>
> 삽입/삭제 빠름 : 추가/삭제할 노드가 있으면 기존 노드와 연결을 끊고 새 노드와 연결

단점

> 접근시간이 길다 :  데이터가 많을수록 읽어오는 시간이 길다.  불연속적으로 데이터가 위치해서
>
> 중간값이나 특정값의 경우 처음부터 읽어오기 때문



Linked List 삽입/삭제 과정

* 삽입

![Linked List 삽입](https://github.com/ssd256/TIL/blob/main/DataStructure/images/Linked%20List%20%EC%82%BD%EC%9E%85.png) 

```
node[3]은 node[Head]의 주소를 참조하지 않고 node[8]의 주소를 참조한다. 
node[8]이 2번째 node가 되어 node[Head]의 주소를 참조한다.
```



* 삭제

![Linked List 삭제](https://github.com/ssd256/TIL/blob/main/DataStructure/images/Linked%20List%20%EC%82%AD%EC%A0%9C.png)

```
node[3]은 node[6]의 주소를 참조하지 않고 node[Tail]의 주소를 참조한다.
node[6]은 node[Tail]의 주소를 참조하지 않아서, node[6]의 연결이 끊겨 삭제된다.

* Java에서는 GV가 있어서 연결이 끊겨 사용되지 않는 node[6]의 메모리를 다시 회수한다.
```
