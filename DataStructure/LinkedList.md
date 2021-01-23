### Linked List

![LinkedList 구조2](https://github.com/ssd256/TIL/blob/main/DataStructure/images/LinkedList%20%EA%B5%AC%EC%A1%B02.png)

불연속적으로 존재하는 데이터를 서로 연결(link)한 [선형 데이터 구조](https://github.com/ssd256/TIL/blob/main/%EA%B8%B0%EC%B4%88%EB%8B%A8%EC%96%B4/%EC%84%A0%ED%98%95_%EB%B9%84%EC%84%A0%ED%98%95.md)(포인터를 사용해서 연결됨)

각 노드는 **데이터(자신) + 다음 노드에 대한 참조(주소값)을** 포함하는 노드로 구성

![node](https://github.com/ssd256/TIL/blob/main/DataStructure/images/node.png)

```java
class Node {
	Node next;	// 다음 요소의 주소를 저장
	Object obj; // 데이터를 저장
}
```
<br>

장점   

> 동적 크기 : 한 번 크기가 정해지면 수정되지 않는 배열과 달리 동적으로 크기가 줄고 늘어남
>
> 삽입/삭제 빠름 : 추가/삭제할 노드가 있으면 기존 노드와 연결을 끊고 새 노드와 연결

단점 

> 접근시간이 길다 :  데이터가 많을수록 읽어오는 시간이 길다.  불연속적으로 데이터가 위치해서
>
> 중간값이나 특정값의 경우 처음부터 읽어오기 때문   

   

Linked List 삽입/삭제 과정
<br>
* 삽입   

![Linked List 삽입](https://github.com/ssd256/TIL/blob/main/DataStructure/images/Linked%20List%20%EC%82%BD%EC%9E%85.png) 

```
node[3]은 node[Head]의 주소를 참조하지 않고 node[8]의 주소를 참조한다. 
node[8]이 2번째 node가 되어 node[Head]의 주소를 참조한다.
```


<br>

* 삭제   

![Linked List 삭제](https://github.com/ssd256/TIL/blob/main/DataStructure/images/Linked%20List%20%EC%82%AD%EC%A0%9C.png)

```
node[3]은 node[6]의 주소를 참조하지 않고 node[Tail]의 주소를 참조한다.
node[6]은 node[Tail]의 주소를 참조하지 않아서, node[6]의 연결이 끊겨 삭제된다.

* Java에서는 GV가 있어서 연결이 끊겨 사용되지 않는 node[6]의 메모리를 다시 회수한다.
```

<br>

* 코드 구현

```java
class LinkedList {
	Node header;	// header를 따로 만들지 않으면, 처음 시작하는 node가 header이자 
    // 해당 객체의 대표가 되서 다른 노들들이 참고하고 있는데 삭제할 경우 참조문제 발생
    
	static class Node {
		int data;
		Node next = null;
	}
	
	LinkedList() {
		header = new Node(); // node의 첫 번째 부분이 됨
	}
	
	void append(int d) {
		Node end = new Node();
		end.data = d; 
		Node n = header; // n의 시작은 header
		while(n.next != null) {
			n = n.next;	// null을 만나면 while문 종료
		}
		n.next = end; // while문을 나온 n은 마지막이라, 이 마지막 n의 다음값에(next) 새로운 node인 end를 넣음[추가]
	}
	
	void delete(int d) {
		Node n = header;
		while(n.next != null) {
			if(n.next.data == d) {	// n의 다음값의 data가 매개변수로 만들어진 node라면
				n.next = n.next.next; // n의 다음값에 null을 넣음[node의 필드에서 next = null이라서 -> 연결이 해제되서 삭제]
			} else {
				n = n.next;	// 아니면 n에 다음 node를 넣음
			}
		}
	}
	
	void retrieve() {
		Node n = header.next; // header 다음부터 출력
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next; // n에 n 다음값을 계속 넣어줌
		}
		System.out.println(n.data); // 마지막은 다음값이 null이라 밖에서 출력
	}
}
```

